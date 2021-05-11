package com.example.diplomandroid.miband;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothProfile;
import android.content.Context;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MiBandConnectionHelper {
    private final Context myContext = null;
    private final android.os.Handler myHandler = null;
    private final ArrayList<BLEAction> listeners = new ArrayList<>();
    byte notification;
    byte alert;
    byte[] dates;
    byte[] parameters;
    byte[] bytes;
    private BluetoothDevice activeDevice = null;
    private boolean isConnectedToGatt = false;
    private BluetoothGatt myGatBand = null;
    private BluetoothGattCharacteristic characteristic;
    private BluetoothGattCharacteristic characteristicAlert;
    private final BluetoothGattCallback myGattCallback = new BluetoothGattCallback() {
        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                characteristic = gatt.getService(CustomUUID.UUID_SERVICE_1811).getCharacteristic(CustomUUID.UUID_CHARACTERISTIC_2A46);
                characteristicAlert = gatt.getService(CustomUUID.UUID_SERVICE_1802).getCharacteristic(CustomUUID.UUID_CHARACTERISTIC_2A06);
                isConnectedToGatt = true;
            }
        }

        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                gatt.discoverServices();
                isConnectedToGatt = true;
                raiseOnConnect();
            } else {
                isConnectedToGatt = false;
                raiseOnDisconnect();
            }
        }

        @Override
        public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            raiseOnWrite(gatt, characteristic, status);
            super.onCharacteristicWrite(gatt, characteristic, status);
        }

        @Override
        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            raiseOnRead(gatt, characteristic, status);
            super.onCharacteristicRead(gatt, characteristic, status);
        }

        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            raiseNotification(gatt, characteristic);
            super.onCharacteristicChanged(gatt, characteristic);
        }
    };

    public boolean isConnected() {
        return isConnectedToGatt;
    }

    public void connect() {
        if (!BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            return;
        }
        isConnectedToGatt = false;
        final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        try {
        } catch (Exception e) {
            activeDevice = null;
            e.printStackTrace();
        }
        if (activeDevice != null) {
            if (!connectGatt()) {
                isConnectedToGatt = false;
            }
        }
    }

    public boolean connectGatt() {
        if (activeDevice == null)
            return false;
        myGatBand = activeDevice.connectGatt(null, false, myGattCallback);
        if (myGatBand == null)
            return false;
        return myGatBand.connect();
    }

    public void DisconnectGatt() {
        if (myGatBand != null && isConnectedToGatt) {
            myHandler.post(new Runnable() {
                @Override
                public void run() {
                    myGatBand.disconnect();
                    myGatBand.close();
                    myGatBand = null;
                    isConnectedToGatt = false;
                }
            });
        }
    }

    public void sendCall(String value) {
        if (!isConnectedToGatt) {
            connect();
        }
        try {
            byte alert = CustomUUID.alert1;
            byte[] params = new byte[]{notification, alert};
            byte[] bytes = value.getBytes(StandardCharsets.US_ASCII);
            byte[] data = unitBytes(params, bytes);
            characteristic.setValue(data);
            myGatBand.writeCharacteristic(characteristic);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendSms(String value) {
        if (!isConnectedToGatt) {
            connect();
        }
        try {
            alert = CustomUUID.alert1;
            parameters = new byte[]{notification, alert};
            bytes = value.getBytes(StandardCharsets.US_ASCII);
            dates = unitBytes(parameters, bytes);
            characteristic.setValue(dates);
            myGatBand.writeCharacteristic(characteristic);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addListener(BLEAction toAdd) {
        listeners.add(toAdd);
    }

    public void removeListener(BLEAction toDel) {
        listeners.remove(toDel);
    }

    public void raiseNotification(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        for (BLEAction listener : listeners)
            listener.onNotification(gatt, characteristic);
    }

    public void raiseOnRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        for (BLEAction listener : listeners)
            listener.onRead(gatt, characteristic, status);
    }

    public void raiseOnWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        for (BLEAction listener : listeners)
            listener.onWrite(gatt, characteristic, status);
    }

    public void raiseOnDisconnect() {
        for (BLEAction listener : listeners)
            listener.onDisconnect();
    }

    public void raiseOnConnect() {
        for (BLEAction listener : listeners)
            listener.onConnect();
    }

    public void readData(java.util.UUID service, java.util.UUID Characteristics) {
        if (!isConnectedToGatt || myGatBand == null) {
            return;
        }
        BluetoothGattService myGatService = myGatBand.getService(service);
        if (myGatService != null) {
            BluetoothGattCharacteristic myGatChar = myGatService.getCharacteristic(Characteristics);
            if (myGatChar != null) {
                boolean status = myGatBand.readCharacteristic(myGatChar);
            }
        }
    }

    public void writeData(java.util.UUID service, java.util.UUID Characteristics, byte[] data) {
        if (!isConnectedToGatt || myGatBand == null) {
            return;
        }
        BluetoothGattService myGatService = myGatBand.getService(service);
        if (myGatService != null) {
            BluetoothGattCharacteristic myGatChar = myGatService.getCharacteristic(Characteristics);
            if (myGatChar != null) {
                myGatChar.setValue(data);
                boolean status = myGatBand.writeCharacteristic(myGatChar);
            }
        }
    }

    public void getNotifications(java.util.UUID service, java.util.UUID Characteristics) {
        if (!isConnectedToGatt || myGatBand == null) {
            return;
        }
        BluetoothGattService myGatService = myGatBand.getService(service);
        if (myGatService != null) {
            BluetoothGattCharacteristic myGatChar = myGatService.getCharacteristic(Characteristics);
            if (myGatChar != null) {
                boolean status = myGatBand.setCharacteristicNotification(myGatChar, true);
            }
        }
    }

    public void getNotificationsWithDescriptor(java.util.UUID service, java.util.UUID Characteristics, java.util.UUID Descriptor) {
        if (!isConnectedToGatt || myGatBand == null) {
            return;
        }
        BluetoothGattService myGatService = myGatBand.getService(service);
        if (myGatService != null) {
            BluetoothGattCharacteristic myGatChar = myGatService.getCharacteristic(Characteristics);
            if (myGatChar != null) {
                boolean status = myGatBand.setCharacteristicNotification(myGatChar, true);
                BluetoothGattDescriptor myDescriptor = myGatChar.getDescriptor(Descriptor);
                if (myDescriptor != null) {
                    myDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                }
            }
        }
    }

    public void alert() {
        characteristicAlert.setValue(new byte[]{1, 1});
        myGatBand.writeCharacteristic(characteristicAlert);
    }

    public byte[] unitBytes(byte[] a, byte[] b) {
        byte[] dates = new byte[a.length + b.length];
        System.arraycopy(a, 0, dates, 0, a.length);
        System.arraycopy(b, 0, dates, a.length, b.length);
        return dates;
    }

    public interface BLEAction {
        void onDisconnect();

        void onConnect();

        void onRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status);

        void onWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status);

        void onNotification(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic);
    }
}
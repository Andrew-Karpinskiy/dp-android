package com.example.diplomandroid.miband;

public class CustomUUID {
    public static final String BASE_UUID = "0000%s-0000-1000-8000-00805f9b34fb";
    public static final java.util.UUID UUID_SERVICE_GENERIC = java.util.UUID.fromString(String.format(BASE_UUID, "1800"));
    public static final java.util.UUID UUID_SERVICE_1802 = java.util.UUID.fromString(String.format(BASE_UUID, "1802"));
    public static final java.util.UUID UUID_SERVICE_1811 = java.util.UUID.fromString(String.format(BASE_UUID, "1811"));
    public static final java.util.UUID UUID_SERVICE_HEARTBEAT = java.util.UUID.fromString(String.format(BASE_UUID, "180D"));
    public static final java.util.UUID UUID_CHARACTERISTIC_2A06 = java.util.UUID.fromString(String.format(BASE_UUID, "2A06"));
    public static final java.util.UUID UUID_CHARACTERISTIC_2A46 = java.util.UUID.fromString(String.format(BASE_UUID, "2A46"));
    public static final java.util.UUID UUID_DESCRIPTOR_GATT_CLIENT_CHARACTERISTIC_CONFIGURATION = java.util.UUID.fromString(String.format(BASE_UUID, "2902"));
    public static final java.util.UUID UUID_CHARACTERISTIC_DEVICE_NAME = java.util.UUID.fromString(String.format(BASE_UUID, "2A00"));
    public static final java.util.UUID UUID_UNKNOWN_CHARACTERISTIC0 = java.util.UUID.fromString("00000000-0000-3512-2118-0009af100700");
    public static final java.util.UUID UUID_UNKNOWN_CHARACTERISTIC1 = java.util.UUID.fromString("00000001-0000-3512-2118-0009af100700");
    public static final java.util.UUID UUID_UNKNOWN_CHARACTERISTIC2 = java.util.UUID.fromString("00000002-0000-3512-2118-0009af100700");
    public static final java.util.UUID UUID_CHARACTERISTIC_3_CONFIGURATION = java.util.UUID.fromString("00000003-0000-3512-2118-0009af100700");
    public static final java.util.UUID UUID_UNKNOWN_CHARACTERISTIC4 = java.util.UUID.fromString("00000004-0000-3512-2118-0009af100700");
    public static final java.util.UUID UUID_CHARACTERISTIC_5_ACTIVITY_DATA = java.util.UUID.fromString("00000005-0000-3512-2118-0009af100700");
    public static final java.util.UUID UUID_CHARACTERISTIC_6_BATTERY_INFO = java.util.UUID.fromString("00000006-0000-3512-2118-0009af100700");
    public static final java.util.UUID UUID_CHARACTERISTIC_7_REALTIME_STEPS = java.util.UUID.fromString("00000007-0000-3512-2118-0009af100700");
    public static final java.util.UUID UUID_UNKNOWN_CHARACTERISTIC8 = java.util.UUID.fromString("00000008-0000-3512-2118-0009af100700");
    public static final java.util.UUID UUID_CHARACTERISTIC_AUTH = java.util.UUID.fromString("00000009-0000-3512-2118-0009af100700");
    public static final java.util.UUID UUID_BUTTON_TOUCH = java.util.UUID.fromString("00000010-0000-3512-2118-0009af100700");
    public static final byte[] BYTE_LAST_HEART_RATE_SCAN = {21, 1, 1};
    public static final byte[] BYTE_NEW_HEART_RATE_SCAN = {21, 2, 1};
    public static final java.util.UUID UUID_DESCRIPTOR_UPDATE_NOTIFICATION = java.util.UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    public static final Byte alert1 = 1;
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
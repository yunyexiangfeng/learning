package com.constant;


import java.util.List;
import java.util.regex.Pattern;

public enum TenantEvent {
    ADD_NEW_TENANT,
    REMOVE_TENANT,
    TENANT_BACKUP,
    TENANT_RESTORE,
    TENANT_RESTORE_COMPLETED;

    private TenantEvent() {
    }

    private static String regex = "^ENC(.*)$";
    private static final Pattern pattern = Pattern.compile(regex);

    public static void main(String[] args) {
        /*String action = "TENANT_BACKUP";
        switch (TenantEvent.valueOf(action)){
            case ADD_NEW_TENANT:
                System.out.println("ADD_NEW_TENANT");
                break;
            case REMOVE_TENANT:
            case TENANT_RESTORE_COMPLETED:
                System.out.println("REMOVE_TENANT and TENANT_RESTORE_COMPLETED");
                break;
            case TENANT_BACKUP:
            case TENANT_RESTORE:
                System.out.println("TENANT_BACKUP and TENANT_RESTORE");
                return;
            default:
                System.out.println("default");
        }*/
        try {
            List<String> list = null;
            list.clear();
        }catch (Exception e){e.printStackTrace();}

    }
    public static boolean check(String s){
        return pattern.matcher(s).matches();
    }
}

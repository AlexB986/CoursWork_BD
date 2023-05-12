public enum RoleType {
    DEVELOPER("1-Разработчик"),
    ANALIST("2-Аналитик"),
    TESTER("3-Тестировщик"),
    MANAGER("4-Менеджер"),
    DESIGNER("5-Дизайнер"),
    DEFAULT("6-По умолчанию");

    private String roleType;

    RoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return roleType;
    }

    @Override
    public String toString() {
        return "RoleType{" +
                "roleType='" + roleType + '\'' +
                '}';
    }
    public String getValue(){
        return this.roleType;
    }
    public static RoleType valueOf(Integer value){
        switch (value){
            case 1:
                return DEVELOPER;
            case 2:
                return ANALIST;
            case 3:
                return TESTER;
            case 4:
                return MANAGER;
            case 5:
                return DESIGNER;
            case 6:
                return DEFAULT;
            default:
                break;
        }
        return null;
    }
}

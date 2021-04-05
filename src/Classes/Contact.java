package Classes;

public class Contact {
    private String name;
    private String number;
    private int code;

    // #region get and set
    
    private String numberReplace(String number) {
        number = number.replaceAll("(\\d{4})(\\d{4})", "$1-$2");
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return numberReplace(number);
    }

    public void setNumber(String number) {

        if (number.length() == 8) {
            this.number = number;
        } else {
            throw new NumberFormatException("O número deve conter pelo menos 8 digítos.");
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    // #endregion

}

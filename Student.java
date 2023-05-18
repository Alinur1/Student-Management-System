public final class Student {

    private int id;
    private String name;
    private float marks;
    private String mobileNo;
    private String address;
    private String description;
	
	
	public void setID(final int idInput){
		this.id = idInput;
	}
	public int getID(){
		return id;
	}
	
	public void setName(final String nameInput){
		this.name = nameInput;
	}
	public String getName(){
		return name;
	}
	
	public void setMarks(final float marksInput){
		this.marks = marksInput;
	}
	public float getMarks(){
		return marks;
	}
	
	public void setMobileNo(final String mobileNoInput){
		this.mobileNo = mobileNoInput;
	}
	public String getMobileNo(){
		return mobileNo;
	}
	
	public void setAddress(final String addressInput){
		this.address = addressInput;
	}
	public String getAddress(){
		return address;
	}
	
	public void setDescription(final String descriptionInput){
		this.description = descriptionInput;
	}
	public String getDescription(){
		return description;
	}
	

   
    public Student() {
        super();
    }
	
	
    public Student(final int idInput, final String nameInput,
            final float marksInput, final String mobileNoInput,
            final String addressInput, final String descriptionInput) {
        super();
        this.id = idInput;
        this.name = nameInput;
        this.marks = marksInput;
        this.mobileNo = mobileNoInput;
        this.address = addressInput;
        this.description = descriptionInput;

    }

    
  

    
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("     Student ID:");
        sb.append(id);
        sb.append("\n");
        sb.append("     Student Name:");
        sb.append(name);
        sb.append("\n");
        sb.append("     Student marks:");
        sb.append(marks);
        sb.append("\n");
        sb.append("     Student mobile no:");
        sb.append(mobileNo);
        sb.append("\n");
        sb.append("     Student Address:");
        sb.append(address);
        sb.append("\n");
        sb.append("     Student Description:");
        sb.append(description);
        sb.append("\n");

        return sb.toString();
    }

    
    public String toStringSaveFile() {

        String result = id + "," + name + "," + marks + "," + mobileNo + ","
                + address + "," + description;

        return result;
    }

}
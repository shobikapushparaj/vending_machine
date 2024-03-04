
public class Container {
	
		private static String TEA_CONTAINER_VALUE = "tea";
		private static String COFFEE_CONTAINER_VALUE = "coffee";
		private static String SUGAR_CONTAINER_VALUE = "sugar";
		private static String WATER_CONTAINER_VALUE = "water";
		private static String MILK_CONTAINER_VALUE = "milk";
	 	private Float tea_container = 2000.0F;
	    private Float coffee_container = 2000.0F;
	    private Float sugar_container = 8000.0F;
	    private Float water_container = 15000.0F;
	    private Float milk_container = 10000.0F;
	    public ContainerDAO containerDao;
	     
	    public Container() {
	    	containerDao = new ContainerDAO();
	    }
	    
	    public void initiateContainer() {
	    	containerDao.addValuesToContainerTable(tea_container, coffee_container, sugar_container, water_container, milk_container);
	    }

	    public Float getTea_container() {
	    	tea_container = containerDao.retriveSingleContainerValue(TEA_CONTAINER_VALUE);
	        return tea_container;
	    }

	    public void setTea_container(Float tea_container) {
	    	containerDao.updateIndividualContainer(TEA_CONTAINER_VALUE, tea_container);
	    	this.tea_container = tea_container; // unnecessary since we are keeping the record in DB
	    }

	    public Float getCoffee_container() {
	    	coffee_container = containerDao.retriveSingleContainerValue(COFFEE_CONTAINER_VALUE);
	        return coffee_container;
	    }

	    public void setCoffee_container(Float coffee_container) {
	    	containerDao.updateIndividualContainer(COFFEE_CONTAINER_VALUE, coffee_container);
	        this.coffee_container = coffee_container;
	    }

	    public Float getSugar_container() {
	    	sugar_container = containerDao.retriveSingleContainerValue(SUGAR_CONTAINER_VALUE);
	        return sugar_container;
	    }

	    public void setSugar_container(Float sugar_container) {
	    	containerDao.updateIndividualContainer(SUGAR_CONTAINER_VALUE, sugar_container);
	        this.sugar_container = sugar_container;
	    }

	    public Float getWater_container() {
	    	water_container = containerDao.retriveSingleContainerValue( WATER_CONTAINER_VALUE);
	        return water_container;
	    }

	    public void setWater_container(Float water_container1) {
	    	System.out.println(water_container1);
	    	containerDao.updateIndividualContainer(WATER_CONTAINER_VALUE, water_container1);
	        this.water_container = water_container1;
	    }

	    public Float getMilk_container() {
	    	milk_container = containerDao.retriveSingleContainerValue(MILK_CONTAINER_VALUE);
	        return milk_container;
	    }

	    public void setMilk_container(Float milk_container) {
	    	containerDao.updateIndividualContainer(MILK_CONTAINER_VALUE, milk_container);
	        this.milk_container = milk_container;
	    }

	    public Container(Float tea_container, Float coffee_container, Float sugar_container, Float water_container, Float milk_container) {
	        System.out.println("The unused function is finally used !!!!!!!");
	    	this.tea_container = tea_container;
	        this.coffee_container = coffee_container;
	        this.sugar_container = sugar_container;
	        this.water_container = water_container;
	        this.milk_container = milk_container;
	    }

}

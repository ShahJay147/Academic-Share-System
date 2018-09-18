class Material {
    
    int ID, numOfPages;
    String name, type, sellername, ch;        // type = book, pdf, audio or video
    double price;
    Account owner;
    
    Material(Account curr,String name, int numOfPages, String type, String ch, double price) {
    	this.owner=curr;
    	this.numOfPages = numOfPages;
        this.name = name;
        this.type = type;
        this.ch = ch;
        this.price = price;
    }
}
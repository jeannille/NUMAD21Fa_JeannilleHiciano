package com.example.numad21fa_jeannillehiciano;

//Represents one link item (view) in list of links (contained by RecyclerViewHolder)
public class LinkItem implements LinkClickListener {
    private final String textLink; //can't modify existing link or url
    private final String urlLink;
    private boolean isChecked;

    //Constructor
    //each link in list has display text, the url, and status if checked
    public LinkItem(String textLink, String urlLink, boolean isChecked) {
        this.textLink = textLink;
        this.urlLink = urlLink;
        this.isChecked = isChecked;
    }

    //Accessor methods for Link fields
    public String getTextLink() {
        return textLink;
    }

    public String getUrlLink() {
        return urlLink;
    }

    public boolean isChecked() {
        return isChecked;
    }

    //inherited method, clicking on Link 'card' in list of links
    //should open up link in browser
    @Override
    public void onLinkClick(int position) {
        isChecked = !isChecked;
    }

    @Override
    public void onFloatButtonClick(int position) {
        //to fill in once float button is created
        System.out.println("Have clicked on Floating button");
    }

}

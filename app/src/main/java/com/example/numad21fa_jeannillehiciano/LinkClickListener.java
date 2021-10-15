package com.example.numad21fa_jeannillehiciano;
// Listens for a link or floating addLink button being clicked
public interface LinkClickListener {

    //when a link is clicked, link url should open in browser
    void onLinkClick(int position);

    //when floating button is clicked (in RViewHolder containing list of links), user will be
    //prompted to enter link text and URL, which will then be added to the list of links
    void onFloatButtonClick(int position);

}

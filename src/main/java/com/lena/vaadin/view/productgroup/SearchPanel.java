package com.lena.vaadin.view.productgroup;

import com.vaadin.ui.*;

/**
 * Created by alexey.dranchuk on 26/12/14.
 */
public class SearchPanel extends HorizontalLayout {

    private TextField searchField;
    private Button searchButton;
    private SearchModel searchModel;

    public SearchPanel(SearchModel searchModel) {
        this.searchModel = searchModel;
        setSpacing(true);
        setMargin(true);
        initComponents();
    }

    private void initComponents() {
        addSearchLabel();
        addSearchField();
        addSearchButton();
    }

    private void addSearchButton() {
        searchButton = new Button("Поиск", new Button.ClickListener(){
            @Override
            public void buttonClick(Button.ClickEvent event) {
                searchModel.processClickEvent();
            }
        });
        addComponent(searchButton);
    }

    private void addSearchField() {
        searchField = new TextField(searchModel.getSearchProperty());
        addComponent(searchField);
    }

    private void addSearchLabel() {
        addComponent(new Label("Поиск : "));
    }

}

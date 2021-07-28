@IOassignment
Feature: Testing IO shopping Application


Background:
Given IO shopping app is install

Scenario: Verify creation of new list and add new item and then remove it

When select type of application UI
And click on menu item
And click on new list
And create new list as "NewList01"
And click on menu item
And click on new list
And create new list as "NewList02"
And add new item as "NewItem01"
Then delete the recently created item from list

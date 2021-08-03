@IO
Feature: Testing IO shopping Applications


Background:
Given IO shopping app is installed successffully

Scenario: Verify creation of new list and add new item and then remove it

When select type of application UI
And create new list as "NewList01"
And create new list as "NewList02"
And add new ten items 
Then delete four items 
And check count
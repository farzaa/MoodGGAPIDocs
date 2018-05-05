import requests
import json

# Overwatch
# retrieve all heroes supported by Mood
getHeroes = "https://moodggapi.herokuapp.com/api/ow/ListOfHeroes"
# for retrieving information about a specific hero enter it here
hero = "Genji"
getSpecificHero = "https://moodggapi.herokuapp.com/api/ow/" + hero


# League of Legends
# retrieve all champs supported by Mood
getChamps = "https://moodggapi.herokuapp.com/api/lol/ListOfChampions"
# for retrieving information about a specific champs enter it here
champion = "Yasuo"
getSpecificChamp = "https://moodggapi.herokuapp.com/api/lol/" + champion


# for LOL replace with getChamps
response = requests.get(getHeroes)
print(response.content.decode("utf-8"))


# for specific heroes/champions the data returned is in JSON format. The data contains these fields:
# id
# name
# playlistID
# videoArray
# suggestionPlaylistID
# suggestionArray

# for LOL replace with getSpecificChampion
response = requests.get(getSpecificHero)
responseData = response.json()

print("Name: " + responseData["name"])
print("PlaylistID: " + responseData["playlistID"])
# ![alt_text](https://i.imgur.com/xvvUMf1.png) API

### Table of Contents
[Welcome](#welcome)<br>
[Getting Started](#getting-started)<br> 
[League Of Legends API](#league-of-legends-api)<br>
[Overwatch API](#overwatch-api)<br>
[Payload Format](#payload-format)<br>
[Python Example](#python-example)<br>
[Java Example](#java-example)<br>
[Improvements](#improvements)


### Welcome
Welcome to the mood.gg API Doc! This doc will get you started with using the API behind the best thing to ever happen to gaming (according to my mother). Lots of people expressed intrest in building things like **Discord Bots, Spotify Apps, iOS/Android versions of mood, plugins for their website, and lots of other cool stuff**. 

This API supports all of your favorite languages like: Java, Javacsript, Python, and many many many more. Still unsure what to use? Make sure to take a look at the example below! 

Don't know what mood is? Thats fine, I forgive you. If you are a **League of Legends** player, educate yourself at [this Reddit post.](https://www.reddit.com/r/leagueoflegends/comments/6m91vo/after_months_of_painful_work_and_lots_of_coffee/?utm_content=title&utm_medium=user&utm_source=reddit&utm_name=frontpage)<br>
Is **Overwatch** more your thing? Check out [TODO](TODO). 

### Getting Started
This API offers 4 very simple endpoints. Each endpoint only supports `GET` requests.<br>
The API formats data in JSON, but I'm sure not all of us are wizards with JSON. If you aren't super comfortable with JSON be sure you browse the API on Chrome and download [this](https://chrome.google.com/webstore/detail/jsonview/chklaanhfefbnpoihckbnefhakgolnmc?hl=en) chrome extension. It will save you from many headaches later on.

### League of Legends API
`GET` List Of Champions Mood Supports<br>
```https://moodggapi.herokuapp.com/api/lol/listOfChampions```

`GET` A Specific Champions Data<br>
```https://moodggapi.herokuapp.com/api/lol/<champ_name>```

For example, to access data about Yasuo, use<br>
```https://moodggapi.herokuapp.com/api/lol/Yasuo```

If the champion name has a special character in it, like Rek'Sai, thats fine! Just access it normally<br>
```https://moodggapi.herokuapp.com/api/lol/Rek'Sai```

What if the champ has a space in its name? No problem, write it as is<br>
```https://moodggapi.herokuapp.com/api/lol/Lee Sin```


### Overwatch API
The process to access this data is very similar to League of Legends.

`GET` List Of Heroes Mood Supports<br> 
```https://moodggapi.herokuapp.com/api/ow/listOfHeroes```

`GET` A Specific Hero's Data<br>
```https://moodggapi.herokuapp.com/api/ow/<hero_name>```

For example, to access data about Genji, use<br> 
```https://moodggapi.herokuapp.com/api/ow/Genji```

If the hero name has a special character in it, like D.Va, thats fine! Just access it normally<br>
```https://moodggapi.herokuapp.com/api/ow/D.Va```

What if the hero has a space in its name? No problem, write it as is<br>
```https://moodggapi.herokuapp.com/api/ow/Soldier: 76```


### Payload Format
For both **Overwatch** and **League of Legends**, the data under ```/api/ow/<hero_name>``` and ```/api/lol/<champ_name>``` is structured like this - 

```
{
    _id: String,
    name: String,
    playlistID: String,
    videoArray: [String]
}
```

- ```id``` - you can ignore this, it's just a unique id for the character.
- ```name``` - name of the character. 
- ```playlistID``` - this is the YouTube playlist ID where all the songs are located for the **main** playlist. To access the playlist do -  ```https://www.youtube.com/playlist?list=<insert_playlistID_here>```
- ```videoArray``` - an array of strings that hold the individual YouTube videoIDs for each song in the main playlist. To access it, do - ```https://www.youtube.com/watch?v=<insert_videoID_here>```.


### Python Example
There are multiple ways of making API calls using python but this example will use the python 'Requests' library. Use pip to install it if you do not already have it installed. It also uses the python's native json library.<br>
**Step 1:** Make a variable with the url of the api call you want to make (look above)
```python 
getHeroes = "https://moodggapi.herokuapp.com/api/ow/ListOfHeroes"
```
**Step 2:** Call 'requests.get' on your variable and use .content to access the results
```python 
response = requests.get(getHeroes)
print(response.content)
```
**Step 3:** If retrieving data on a specific hero/champion use .json() to parse through and obtain individual fields
```python 
responseData = response.json()
print("Name: " + responseData["name"])
print("PlaylistID: " + responseData["playlistID"])
```

### Java Example
Once again there are many different ways to call API's and parse through JSON's in Java. This example uses the HttpURLConnection library native to Java and the json-simple library which you can find [here](https://code.google.com/archive/p/json-simple/).<br>
**Step 1:** Make a string variable with the url of the api call you want to make (look above)
```java
String getHeroes = "https://moodggapi.herokuapp.com/api/ow/listOfHeroes";
```
**Step 2:** Call the callAPI function and pass it your string
```java
System.out.println(callAPI(getHeroes));
```
**callAPI Function** (takes in String str as parameter)
```java
URL url = new URL(str);
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();

while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();

return response.toString();
```
**Step 3:** If retrieving data on a specific hero/champion call the parseJSON function to be able to access individual fields and pass it a string similar to Step 1 but with the hero/champion name rather than listOfHeroes
```java
JSONObject obj = parseJSON(callAPI(getSpecificHero));
System.out.println(obj.get("name"));
System.out.println(obj.get("playlistID"));
```
**parseJSON Function** (takes in String str as parameter)
```java
JSONObject jsonObj = new JSONObject();
JSONParser parser = new JSONParser();
try {
    Object obj = parser.parse(str);
    JSONArray array = new JSONArray();
    array.add(obj);
    jsonObj = (JSONObject)array.get(0);
}catch(ParseException pe){
    System.out.println("position: " + pe.getPosition());
    System.out.println(pe);
}
return jsonObj;
```

### Improvements
Any open source project is looking for improvements. If you find something in the API or documents submit a Github Issue [here](https://github.com/farzaa/MoodGGAPIDocs/issues)!

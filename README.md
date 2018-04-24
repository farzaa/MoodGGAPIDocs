# ![alt_text](https://i.imgur.com/xvvUMf1.png) API 

Yo whats up. These are the docs on how to use the API behind the best thing to ever happen to gaming according to my mother: mood.gg . Lots of people expressed intrests in building things like **Discord Bots, Spotify Apps, iOS/Android versions of mood, plugins for their website, and lots of other cool stuff**. 

It should work using any of your favorite programming langauges like Java, Javacsript, Python, and many many many more. **I give examples below :)**. 

Don't know what mood is? Thats fine man I forgive you. If you are a **League of Legends** player check out [this Reddit post.](https://www.reddit.com/r/leagueoflegends/comments/6m91vo/after_months_of_painful_work_and_lots_of_coffee/?utm_content=title&utm_medium=user&utm_source=reddit&utm_name=frontpage) If you are more into **Overwatch**, check out the other post [TODO](TODO). 

### Basics
The API only had 4 endpoints and is extremely easy to use. It only supports *GET* requests. Also, unless you are used to JSON, I highly reccomend you browse the API on Chrome. Be sure to get [this](https://chrome.google.com/webstore/detail/jsonview/chklaanhfefbnpoihckbnefhakgolnmc?hl=en) extension as well, it makes things much prettier.

**League of Legends**
To get the list of champions mood supports go to - 
```https://moodggapi.herokuapp.com/api/lol/listOfChampions```

To access data for a specfic champion -
```https://moodggapi.herokuapp.com/api/lol/<champ_name>```

For example, to access data about Yasuo, just go to -
```https://moodggapi.herokuapp.com/api/lol/Yasuo```

If the champion name has a special character in it, like Rek'Sai, thats fine! Just access it normally - 
```https://moodggapi.herokuapp.com/api/lol/Rek'Sai```

What if the champ has a space in its name? No problem, write it as is - 
```https://moodggapi.herokuapp.com/api/lol/Lee Sin```

**Overwatch**
The process to access this data is very similar to League of Legends.

To get the list of heroes mood supports go to - 
```https://moodggapi.herokuapp.com/api/ow/listOfHeroes```

To access data for a specfic champion -
```https://moodggapi.herokuapp.com/api/ow/<hero_name>```

For example, to access data about Genji, just go to -
```https://moodggapi.herokuapp.com/api/ow/Genji```

If the hero name has a special character in it, like D.Va, thats fine! Just access it normally - 
```https://moodggapi.herokuapp.com/api/ow/D.Va```

What if the hero has a space in its name? No problem, write it as is - 
```https://moodggapi.herokuapp.com/api/ow/Soldier: 76```

For both **Overwatch** and **League of Legends**, the data under ```/api/ow/<hero_name>``` and ```/api/lol/<champ_name>``` is structured like this - 

```
{
_id: String,
name: String,
playlistID: String,
videoArray: [String]
suggestionPlaylistID: String
suggestionArray: [
    {
        videoID: String,
        likes: Int,
        dislikes: Int
    }
]
}
```

- ```id``` - you can ignore this, it's just a unique id for the character.
- ```name``` - name of the character. 
- ```playlistID``` - this is the YouTube playlist ID where all the songs are located for the main playlist. To access the playlist do -  ```https://www.youtube.com/playlist?list=<insert_playlistID_here>```
- ```videoArray``` - an array of strings that hold the individual YouTube videoIDs for each song in the main playlist. To access it, do - ```https://www.youtube.com/watch?v=<insert_videoID_here>```.
- ```suggestionPlaylistID``` - this is the YouTube playlist ID where all the songs are located for the voting playlist. To access the playlist do -  ```https://www.youtube.com/playlist?list=<insert_suggestionPlaylistID_here>```.
- ```suggestionArray``` - an array of objects that hold information related to songs being voted on by users of the site. ```videoID``` is the id of the song that is being voted on. ```likes``` is the # of users who upvoted the song and feel the song belongs in the main playlist. ```dislikes``` is the # of users who feel the song does not belong at all.





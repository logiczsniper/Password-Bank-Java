## Password Bank

#### Introduction
Being a beginner in Java, I wanted a practice project that was more complicated than my [first ever Java project](https://github.com/logiczsniper/Simple-CMD-Game-Java), but not too extravagant.
I discovered the Swing library and with a ton of help from the javatpoint website(link later on), I created this password bank. <br><br>
Like a few of my other projects, the idea is not to come up with a brand new, original product, but to just learn more about Java and have fun. Having said that, there are definitely far more functional and elegant password bank applications out there for free. <br><br>
My password bank allows you to do four things:
1. Add a username and password pair
2. Delete a username and password pair
3. Get a password when provided a username
4. Clear all saved credentials

It is not a lot, but I suppose at a basic level it gets the job done.

#### Navigation
This is for those who are here looking for something specific in the code. The password bank itself is a JSON object stored in `bank.json`. The methods that interact with the bank are in `PasswordBank.java`. The main method that use the bank interaction methods are obviously in `Main.java`.

#### Running
In the `out/` directory there is `password_bank.jar` however it is slightly defective in that the pop-up messages do not appear to work. You can quickly download it and run it if you want to see the layout/appearance of the application. If you want to run it properly, you need to have Java installed and the library called gson. Pull the code and static files and run `Main.java`.

#### Sources
As previously mentioned, [javatpoint](https://www.javatpoint.com/) was a crucial asset for the making of the project. It helped so much to have information and examples of almost every aspect of Swing. The image of the padlock which is used as the icon can be found [here](https://pixabay.com/en/photos/lock/). The button press sound can be found [here](http://soundbible.com/1705-Click2.html).

#### Tools Used
- IntelliJ
- Cmder

#### Author
My name is Logan Czernel, I would love some feedback: <br>
lczernel@gmail.com

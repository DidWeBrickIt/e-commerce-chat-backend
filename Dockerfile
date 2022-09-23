FROM gradle
# specify what the environment in my container should be

COPY . /workspace
# copy all files in the current folder and put them in a folder called workspace in the virtual environment when created

WORKDIR /workspace
# any commands we run in our dockerfile will execute from that location

RUN gradle task customFatJar

WORKDIR /workspace/build/libs

EXPOSE 8080
# we specify what port our application runs on

ENV dwbitechchat=${dwbitechchat}

ENTRYPOINT java -jar all-in-one-jar-1.0-SNAPSHOT.jar
# what command will be used to start my application
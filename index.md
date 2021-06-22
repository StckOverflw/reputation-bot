# Reputation Bot - Your community driven Level System

The Reputation Bot was created for communities where the main focus is on mutual help between users.

Normal level systems, which are based on pure activity are not able to reflect how much a user contributes to the community. User which have a lot of knowledge have the same level like users which asks a lot of questions all the time.

The reputation bot changes this and allows users to give eachother reputation when they say something like "Thank you".

The bot will then try to determine the receiver of the thank phrase or ask the user directly:

![Image of a text with a confirmation request.](https://chojos.lewds.de/vOz0UrEc6t.png)

As an alternative user can also use a custom emote to thank a user.

![Image of a reaction on a message](https://chojos.lewds.de/9VJzOVuIr3.png)

Another method is to answer on the message with a thank phrase.

![](https://chojos.lewds.de/VvTRamr6Il.png)

You can also mention the user instead. This can be done via mention or with some kind of fuzzy matching.

![](https://chojos.lewds.de/jp05ifXGet.png)

Which version you want to allow can be defined in the settings.

# Reputation Profile
Each user will have its own reputation profile. The top users get some nice badges on it.

![Reputation profile with badge](https://chojos.lewds.de/191hvsKNFp.png)

# Roles
You can define multiple roles which a user will get when he has a minimum amount of reputation.\
These are displayed as level.

![A list of roles](https://chojos.lewds.de/2cGkWYgzVE.png)

# Absuse protection
The whole system is designed to be as abuse proof as possible.

## Backthanking
If a user A received reputation from user B, neither A nor B can thank eachother for a fixed time defined as cooldown.\
User B can still thank user C or any other user. Cooldown is measured between users not global.

## Outdated Messages
Users cant thank other users on outdated messages which are older than a time defined by `maxmessageage`.

## Ghost Reputation
If a user thanks someone and deleted its messages the reputation will be removed as well.

## Context sensitive
User A can only thank user B when B has at least one message after the first message of user A in the channel. This also takes the `maxmessageage` into account. User A can also thank B if the share or have shared a voice channel in the `maxmessageage`.

# Setup

Setup is easy.

Just execute the /setup command and follow the instructions.

After this, there are some optional steps you may want to take a look at.
- Use the scan command to scan the messages in a channel for thank phrases. This will backfill your reputations. You can scan up to 100k messages in a channel. This will take some time and you can only scan one channel at a time.
- Set your own reputation emote with `/repsettings reaction`. This can be a custom emote from your server or a normal discord emote.
- Set the legacy prefix. All slash commands also exists as legacy text commands.
- Use the `/repsettings` command to tweak your settings.
- User the `/thankwords check` command to check if a message would give reputation.

# Commands

User commands are:
- `rep` - Shows the user reputation or reputation of another user.
- `top` - Shows the top users from this server.
- `info` - Shows various informations about the bot.

Team commands are:
- `repsettings` - Manage your server settings
- `channel` - Manage reputation channel
- `roles` - Manage reputation and bot roles
- `locale` - Change the bot locale
- `log` - Get the recent donated or received reputation of a user. Or reputation information about a message.
- `scan` - Scan a channel for reputation messages.

# You can invite the bot with this [link](https://discord.com/api/oauth2/authorize?client_id=834843896579489794&permissions=1342532672&scope=bot%20applications.commands).

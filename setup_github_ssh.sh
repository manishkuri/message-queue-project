#!/bin/bash

# Set variables
EMAIL="kurimanish049@gmail.com"
GITHUB_USERNAME="manishkuri"
REPO_NAME="message-queue-project"

# Generate a new SSH key
ssh-keygen -t rsa -C "$EMAIL" -f ~/.ssh/id_rsa_personal

# Add the new SSH key to the SSH agent
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_rsa_personal

# Print the public key
echo "Please copy the following public key and add it to your second GitHub account:"
cat ~/.ssh/id_rsa_personal.pub
echo "Press Enter when you have added the key to your GitHub account."
read

# Configure the local Git repository to use the new SSH key
git config core.sshCommand "ssh -i ~/.ssh/id_rsa_personal"

# Update the remote URL to use the SSH URL
git remote set-url origin git@github.com:$GITHUB_USERNAME/$REPO_NAME.git

# Test the SSH connection
ssh -T git@github.com

echo "Setup complete. You can now push your changes to the new repository."
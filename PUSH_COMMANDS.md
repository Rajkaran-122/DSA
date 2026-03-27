# GitHub Repository Push Guide

## Push Commands

### To push changes to the repository, use:

```bash
# First time setup - add remote origin
git remote add origin https://github.com/Rajkaran-122/DSA.git

# Configure git with your credentials (first time only)
git config --global user.email "your-email@example.com"
git config --global user.name "Your Name"

# Stage all changes
git add .

# Commit changes with a message
git commit -m "Add DSA solutions and code"

# Push to main branch
git push -u origin main

# For subsequent pushes, simply use:
git push
```

### Quick Push Workflow:
```bash
# Stage changes
git add .

# Commit with message
git commit -m "Your commit message here"

# Push to repository
git push
```

### Useful Git Commands:
```bash
# Check status
git status

# View commit history
git log

# View current remotes
git remote -v

# Undo last commit (keep changes)
git reset --soft HEAD~1

# View differences
git diff
```

### Branch Operations:
```bash
# Create new branch
git checkout -b feature-name

# Switch to branch
git checkout branch-name

# Push new branch to remote
git push -u origin branch-name
```

---
**Repository:** https://github.com/Rajkaran-122/DSA.git

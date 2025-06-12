# Use official Node.js image
FROM node:alpine

# Set working directory
WORKDIR /app

# Copy package.json and install dependencies
COPY ./my-app/package*.json ./
RUN npm install

# Copy all files
COPY my-app/ ./

# Build the app
RUN npm run build

# Expose port
EXPOSE 4173

# Start the app
CMD ["npm", "run", "preview"]
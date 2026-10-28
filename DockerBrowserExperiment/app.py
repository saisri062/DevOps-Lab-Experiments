
from flask import Flask

app = Flask(__name__)

@app.route("/")
def home():
    return """
    <!DOCTYPE html>
    <html>
    <head>
        <title>Docker Hello World</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <img src="/static/devops.png"
             width="420">
        <h2>My First Dockerized Application</h2>
        <p>This application is running inside a Docker container.</p>
    </body>
    </html>
    """

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)


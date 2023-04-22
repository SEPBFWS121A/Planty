const { app, BrowserWindow } = require("electron");
const path = require("path");
const url = require("url");
  
let win;
function createWindow() {
  win = new BrowserWindow({ width: 700, height: 700 });
  // load the dist folder from Angular
  win.loadURL(
    url.format({
      
      // compiled version of our app
      pathname: path.join(__dirname, '/dist/index.html'), 
      protocol: "file:",
      slashes: true
    })
  );
  win.on("closed", () => {
    win = null;
  });
}
app.on("ready", createWindow);
// If you are using MACOS, we have to quit the app manually 
app.on("window-all-closed", () => {
  if (process.platform !== "darwin") {
    app.quit();
  }
});
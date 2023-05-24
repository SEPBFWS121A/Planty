let chai = require("chai");
let chaiHttp = require("chai-http");
let should = chai.should();

chai.use(chaiHttp);

describe("DELETE POST GET test", function () {
  it("DELETE test", () => {
    chai
      .request("http://localhost:8080")
      .get("/plant")
      .end((error, response) => {
        for (let i = 0; i < response.body.length; i++) {
          chai
            .request("http://localhost:8080")
            .delete("/plant/" + response.body[i].id)
            .end((err, res) => {
              res.should.have.status(200);
            });
        }
      });
  });
  it("POST test", () => {
    let plant = {
      name: "Betty",
      description:
        "Betty was your first sunflower. By the help of Planty, you managed to keep her alive ever since.",
      plantTypeId: 1,
      sensorId: 1,
      roomId: 1,
    };
    chai
      .request("http://localhost:8080")
      .post("/plant")
      .send(plant)
      .end((err, res) => {
        res.should.have.status(201);
      });
  });

  it("GET test", () => {
    chai
      .request("http://localhost:8080")
      .get("/plant")
      .end((err, res) => {
        res.should.have.status(200);
        res.body.should.be.a("array");
        console.log(res.body);
      });
  });
});

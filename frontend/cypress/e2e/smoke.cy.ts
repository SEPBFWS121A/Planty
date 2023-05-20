import { forEach } from 'cypress/types/lodash';
describe('Pie Chart Existence Test', () => {
  // Hinzufügen von Daten in die Datenbank

  it('POST-Anfrage mit Fixture-Daten', () => {
    // Lösche alle Daten aus der Datenbank
    cy.request('http://localhost:8080/plant').then((response) => {
      for (let i = 0; i < response.body.length; i++) {
        cy.request(
          'DELETE',
          `http://localhost:8080/plant/${response.body[i].id}`
        );
      }
    });
    // cy.request('http://localhost:8080/room').then((response) => {
    //   for (let i = 0; i < response.body.length; i++) {
    //     cy.request(
    //       'DELETE',
    //       `http://localhost:8080/room/${response.body[i].id}`
    //     );
    //   }
    // });
    cy.request('http://localhost:8080/sensor').then((response) => {
      for (let i = 0; i < response.body.length; i++) {
        cy.request(
          'DELETE',
          `http://localhost:8080/sensor/${response.body[i].id}`
        );
      }
    });
    cy.request('http://localhost:8080/plantType').then((response) => {
      for (let i = 0; i < response.body.length; i++) {
        cy.request(
          'DELETE',
          `http://localhost:8080/plantType/${response.body[i].id}`
        );
      }
    });
    cy.request('http://localhost:8080/moistureRecord').then((response) => {
      for (let i = 0; i < response.body.length; i++) {
        cy.request(
          'DELETE',
          `http://localhost:8080/moistureRecord/${response.body[i].id}`
        );
      }
    });
    // Führe die POST-Anfrage mit Fixture-Daten aus
    cy.fixture('room1.json').then((postData) => {
      cy.request({
        method: 'POST',
        url: 'http://localhost:8080/room',
        headers: { 'Content-Type': 'application/json' },
        body: postData,
      }).then((response) => {
        expect(response.status).to.eq(201);
      });
    });
    cy.fixture('room2.json').then((postData) => {
      cy.request({
        method: 'POST',
        url: 'http://localhost:8080/room',
        headers: { 'Content-Type': 'application/json' },
        body: postData,
      }).then((response) => {
        expect(response.status).to.eq(201);
      });
    });
    cy.fixture('plantType1.json').then((postData) => {
      cy.request({
        method: 'POST',
        url: 'http://localhost:8080/plantType',
        headers: { 'Content-Type': 'application/json' },
        body: postData,
      }).then((response) => {
        expect(response.status).to.eq(201);
      });
    });
    cy.fixture('plantType2.json').then((postData) => {
      cy.request({
        method: 'POST',
        url: 'http://localhost:8080/plantType',
        headers: { 'Content-Type': 'application/json' },
        body: postData,
      }).then((response) => {
        expect(response.status).to.eq(201);
      });
    });
    cy.fixture('sensor1.json').then((postData) => {
      cy.request({
        method: 'POST',
        url: 'http://localhost:8080/sensor',
        headers: { 'Content-Type': 'application/json' },
        body: postData,
      }).then((response) => {
        expect(response.status).to.eq(201);
      });
    });
    cy.fixture('sensor2.json').then((postData) => {
      cy.request({
        method: 'POST',
        url: 'http://localhost:8080/sensor',
        headers: { 'Content-Type': 'application/json' },
        body: postData,
      }).then((response) => {
        expect(response.status).to.eq(201);
      });
    });
    cy.fixture('plants1.json').then((postData) => {
      cy.request({
        method: 'POST',
        url: 'http://localhost:8080/plant',
        headers: { 'Content-Type': 'application/json' },
        body: postData,
      }).then((response) => {
        expect(response.status).to.eq(201);
      });
    });
    cy.fixture('plants2.json').then((postData) => {
      cy.request({
        method: 'POST',
        url: 'http://localhost:8080/plant',
        headers: { 'Content-Type': 'application/json' },
        body: postData,
      }).then((response) => {
        expect(response.status).to.eq(201);
      });
    });
    cy.request('http://localhost:8080/plant').then((response) => {
      for (let i = 0; i < response.body.length; i++) {
        for (let j = 1; j <= 9; j++) {
          let moistureRecord = {
            timestamp: `2021-01-0${j}T12:00:00Z`,
            humidityLevel: Math.floor(Math.random() * (100 - 0 + 1)),
            plantId: response.body[i].id,
          };
          cy.request({
            method: 'POST',
            url: 'http://localhost:8080/moistureRecord',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(moistureRecord),
          }).then((response) => {
            expect(response.status).to.eq(201);
          });
        }
      }
    });
  });
  beforeEach(() => {
    // Öffne die Webseite, die du testen möchtest
    cy.visit('http://localhost:4200/');
  });

  // ANFANG DER TESTS
  it('should display pie chart', () => {
    // Überprüfe, ob das Element mit der ID "Bettypie" existiert
    cy.get('#Bettypie').should('exist');
  });
});

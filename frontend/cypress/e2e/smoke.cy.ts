describe('Pie Chart Existence Test', () => {
  it('POST-Anfrage mit Fixture-Daten', () => {
    // Führe die POST-Anfrage mit Fixture-Daten aus
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
  });
  beforeEach(() => {
    // Öffne die Webseite, die du testen möchtest
    cy.visit('http://localhost:4200/');
  });
  it('should display pie chart', () => {
    // Überprüfe, ob das Element mit der ID "Bettypie" existiert
    cy.get('#Bettypie').should('exist');
  });
});

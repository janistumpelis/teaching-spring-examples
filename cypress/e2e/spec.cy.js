describe('template spec', () => {
  it('passes', () => {
    cy.visit('https://www.ss.com')
    cy.get('a').contains('Vieglie auto').click()
    cy.get('a').contains('Toyota').click()
    cy.contains('b', 'Corolla Verso').should('be.visible')
  })
})
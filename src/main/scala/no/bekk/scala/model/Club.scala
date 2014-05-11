package no.bekk.scala.model

trait Club extends Ordered[Club]{
  self =>
  val teams: List[Team]

  // state
  lazy val teamsLength = teams.length

  def compare(that: Club) = teamsLength - that.teams.length

  // Example of method using self reference
  def largest(that: Club) = if (self >= that) self else that
}

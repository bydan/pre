/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.nomina.business.logic;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.Date;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;


//VALIDACION
import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.bydan.framework.ConstantesCommon;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.CursoConstantesFunciones;
import com.bydan.erp.nomina.util.CursoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CursoParameterGeneral;
import com.bydan.erp.nomina.business.entity.Curso;
import com.bydan.erp.nomina.business.logic.CursoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class CursoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CursoLogic.class);
	
	protected CursoDataAccess cursoDataAccess; 	
	protected Curso curso;
	protected List<Curso> cursos;
	protected Object cursoObject;	
	protected List<Object> cursosObject;
	
	public static ClassValidator<Curso> cursoValidator = new ClassValidator<Curso>(Curso.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CursoLogicAdditional cursoLogicAdditional=null;
	
	public CursoLogicAdditional getCursoLogicAdditional() {
		return this.cursoLogicAdditional;
	}
	
	public void setCursoLogicAdditional(CursoLogicAdditional cursoLogicAdditional) {
		try {
			this.cursoLogicAdditional=cursoLogicAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	/*
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
	
	protected DatosDeep datosDeep;
	protected Boolean isConDeep=false;
	*/
	
	
	
	
	public  CursoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cursoDataAccess = new CursoDataAccess();
			
			this.cursos= new ArrayList<Curso>();
			this.curso= new Curso();
			
			this.cursoObject=new Object();
			this.cursosObject=new ArrayList<Object>();
				
			/*
			this.connexion=new Connexion();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.cursoDataAccess.setConnexionType(this.connexionType);
			this.cursoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CursoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cursoDataAccess = new CursoDataAccess();
			this.cursos= new ArrayList<Curso>();
			this.curso= new Curso();
			this.cursoObject=new Object();
			this.cursosObject=new ArrayList<Object>();
			
			/*
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.cursoDataAccess.setConnexionType(this.connexionType);
			this.cursoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Curso getCurso() throws Exception {	
		CursoLogicAdditional.checkCursoToGet(curso,this.datosCliente,this.arrDatoGeneral);
		CursoLogicAdditional.updateCursoToGet(curso,this.arrDatoGeneral);
		
		return curso;
	}
		
	public void setCurso(Curso newCurso) {
		this.curso = newCurso;
	}
	
	public CursoDataAccess getCursoDataAccess() {
		return cursoDataAccess;
	}
	
	public void setCursoDataAccess(CursoDataAccess newcursoDataAccess) {
		this.cursoDataAccess = newcursoDataAccess;
	}
	
	public List<Curso> getCursos() throws Exception {		
		this.quitarCursosNulos();
		
		CursoLogicAdditional.checkCursoToGets(cursos,this.datosCliente,this.arrDatoGeneral);
		
		for (Curso cursoLocal: cursos ) {
			CursoLogicAdditional.updateCursoToGet(cursoLocal,this.arrDatoGeneral);
		}
		
		return cursos;
	}
	
	public void setCursos(List<Curso> newCursos) {
		this.cursos = newCursos;
	}
	
	public Object getCursoObject() {	
		this.cursoObject=this.cursoDataAccess.getEntityObject();
		return this.cursoObject;
	}
		
	public void setCursoObject(Object newCursoObject) {
		this.cursoObject = newCursoObject;
	}
	
	public List<Object> getCursosObject() {		
		this.cursosObject=this.cursoDataAccess.getEntitiesObject();
		return this.cursosObject;
	}
		
	public void setCursosObject(List<Object> newCursosObject) {
		this.cursosObject = newCursosObject;
	}
	
	/*
	public Connexion getConnexion() {
		return this.connexion;		
	}
	
	public void setConnexion(Connexion newConnexion) {
		this.connexion=newConnexion;		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}
	*/
	
	public void setDatosCliente(DatosCliente datosCliente) {		
		this.datosCliente = datosCliente;
		
		if(this.cursoDataAccess!=null) {
			this.cursoDataAccess.setDatosCliente(datosCliente);
		}
	}
	
	/*
	public DatosDeep getDatosDeep() {
		return this.datosDeep;
	}

	public void setDatosDeep(DatosDeep datosDeep) {
		this.datosDeep = datosDeep;
	}
	
	public void setDatosDeepFromDatosCliente() {
		this.datosDeep = this.datosCliente.getDatosDeep();
		this.isConDeep=this.datosCliente.getIsConDeep();
	}
	
	public Boolean getIsConDeep() {
		return this.isConDeep;
	}

	public void setIsConDeep(Boolean isConDeep) {
		this.isConDeep = isConDeep;
	}
	
	public ArrayList<DatoGeneral> getArrDatoGeneral() {
		return arrDatoGeneral;
	}

	public void setArrDatoGeneral(ArrayList<DatoGeneral> arrDatoGeneral) {
		this.arrDatoGeneral = arrDatoGeneral;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}


	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	*/
	
			
	public void setDatosDeepParametros(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String strTituloMensaje) {
		this.datosDeep.setIsDeep(isDeep);
		this.datosDeep.setDeepLoadType(deepLoadType);
		this.datosDeep.setClases(clases);
		this.datosDeep.setSTituloMensaje(strTituloMensaje);
	}
	
	public InvalidValue[] getInvalidValues() {
		return invalidValues;
	}

	public void setInvalidValues(InvalidValue[] invalidValues) {
		this.invalidValues = invalidValues;
	}
	
	public StringBuilder getStringBuilder() {
		return this.stringBuilder;
	}

	public void setStringBuilder(StringBuilder stringBuilder) {
		this.stringBuilder = stringBuilder;
	}
	
	public Boolean getConMostrarMensajesStringBuilder() {
		return this.conMostrarMensajesStringBuilder;
	}

	public void setConMostrarMensajesStringBuilder(Boolean conMostrarMensajesStringBuilder) {
		this.conMostrarMensajesStringBuilder = conMostrarMensajesStringBuilder;
	}	
	
			
	
	public void getNewConnexionToDeep()throws Exception {
		//this.getNewConnexionToDeep();
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,"");connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void getNewConnexionToDeep(String sDetalle)throws Exception {
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,sDetalle);connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void commitNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.commit();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void rollbackNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.rollback();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void closeNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.close();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public  void executeQueryWithConnection(String sQueryExecute) throws Exception {
		try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cursoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void executeQuery(String sQueryExecute) throws Exception {
		try {			
			cursoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		curso = new  Curso();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			curso=cursoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.curso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.curso);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntity(Long id) throws Exception {
		curso = new  Curso();
		  		  
        try {
			
			curso=cursoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.curso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.curso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		curso = new  Curso();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			curso=cursoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.curso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.curso);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntityWithConnection(String sFinalQuery) throws Exception {
		curso = new  Curso();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntityWithConnection(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
					
		}
	}
	
	public  void getEntity(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		curso = new  Curso();
		  		  
        try {
			
			curso=cursoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.curso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.curso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		curso = new  Curso();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntity(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		curso = new  Curso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cursoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMinimo;
	}
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		curso = new  Curso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cursoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		curso = new  Curso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cursoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		curso = new  Curso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cursoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		curso = new  Curso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cursoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMaximos;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		curso = new  Curso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cursoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cursos = new  ArrayList<Curso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cursos=cursoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCurso(cursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();	
		}
	}
	
	public  void getEntitiesWithConnection(String sFinalQuery)throws Exception {	
		cursos = new  ArrayList<Curso>();
		  		  
        try {
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntitiesWithConnection(queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
		}
	}
	
	public  void getEntities(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cursos = new  ArrayList<Curso>();
		  		  
        try {			
			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cursos=cursoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCurso(cursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cursos = new  ArrayList<Curso>();
		  		  
        try {			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntities(queryWhereSelectParameters);    	       	 			
		
		} catch(Exception e) {	
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cursos = new  ArrayList<Curso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cursos=cursoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCurso(cursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cursos = new  ArrayList<Curso>();
		  		  
        try {
			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cursos=cursoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCurso(cursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	/**
	* Trae cualquier tipo de query select
	* @conMapGenerico  Si es true, trae todo como objeto generico, Si es false trae query en campos de la clase, usando unicamente los determinados en listColumns y deepLoadType
	* @deepLoadType  Si conMapGenerico es false trae query select con las columnas de listColumns, incluyento o excludendo deacuerdo a deepLoadType
	*/
	public void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cursos = new  ArrayList<Curso>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cursos=cursoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCurso(cursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cursos = new  ArrayList<Curso>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cursos=cursoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCurso(cursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		curso = new  Curso();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			curso=cursoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCurso(curso);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.curso);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntity(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		curso = new  Curso();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			curso=cursoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCurso(curso);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.curso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cursos = new  ArrayList<Curso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cursos=cursoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCurso(cursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntitiesSimpleQueryBuild(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cursos = new  ArrayList<Curso>();
		  		  
        try {
			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cursos=cursoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCurso(cursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCursosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cursos = new  ArrayList<Curso>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-getTodosCursosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cursos=cursoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCurso(cursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {	
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}		
	}
	
	public  void  getTodosCursos(String sFinalQuery,Pagination pagination)throws Exception {
		cursos = new  ArrayList<Curso>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cursos=cursoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCurso(cursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCurso(Curso curso) throws Exception {
		Boolean estaValidado=false;
		
		if(curso.getIsNew() || curso.getIsChanged()) { 
			this.invalidValues = cursoValidator.getInvalidValues(curso);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(curso);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCurso(List<Curso> Cursos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Curso cursoLocal:cursos) {				
			estaValidadoObjeto=this.validarGuardarCurso(cursoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCurso(List<Curso> Cursos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCurso(cursos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCurso(Curso Curso) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCurso(curso)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Curso curso) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+curso.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CursoConstantesFunciones.getCursoLabelDesdeNombre(invalidValue.getPropertyName());
			sMensajeCampo=invalidValue.getMessage();
			
			sMensaje+="\r\n"+sCampo+"->"+sMensajeCampo;
			
			//MOSTRAR CAMPOS INVALIDOS
        }
				
		if(!sMensaje.equals("")) {
			this.stringBuilder.append(sMensaje);	
		}		
	}	
	
	public void manejarMensajesStringBuilder(String sMensajeExcepcion) throws Exception {
		String sMensajeDetalleExcepcion="";
		
		sMensajeDetalleExcepcion=this.stringBuilder.toString();
		
		if(!sMensajeDetalleExcepcion.equals("")) {
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"curso","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CursoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CursoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCursoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-saveCursoWithConnection");connexion.begin();			
			
			CursoLogicAdditional.checkCursoToSave(this.curso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CursoLogicAdditional.updateCursoToSave(this.curso,this.arrDatoGeneral);
			
			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.curso,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCurso();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCurso(this.curso)) {
				CursoDataAccess.save(this.curso, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.curso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CursoLogicAdditional.checkCursoToSaveAfter(this.curso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCurso();
			
			connexion.commit();			
			
			if(this.curso.getIsDeleted()) {
				this.curso=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCurso()throws Exception {	
		try {	
			
			CursoLogicAdditional.checkCursoToSave(this.curso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CursoLogicAdditional.updateCursoToSave(this.curso,this.arrDatoGeneral);
			
			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.curso,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCurso(this.curso)) {			
				CursoDataAccess.save(this.curso, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.curso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CursoLogicAdditional.checkCursoToSaveAfter(this.curso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.curso.getIsDeleted()) {
				this.curso=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCursosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-saveCursosWithConnection");connexion.begin();			
			
			CursoLogicAdditional.checkCursoToSaves(cursos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCursos();
			
			Boolean validadoTodosCurso=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Curso cursoLocal:cursos) {		
				if(cursoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CursoLogicAdditional.updateCursoToSave(cursoLocal,this.arrDatoGeneral);
	        	
				CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cursoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCurso(cursoLocal)) {
					CursoDataAccess.save(cursoLocal, connexion);				
				} else {
					validadoTodosCurso=false;
				}
			}
			
			if(!validadoTodosCurso) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CursoLogicAdditional.checkCursoToSavesAfter(cursos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCursos();
			
			connexion.commit();		
			
			this.quitarCursosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCursos()throws Exception {				
		 try {	
			CursoLogicAdditional.checkCursoToSaves(cursos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCurso=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Curso cursoLocal:cursos) {				
				if(cursoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CursoLogicAdditional.updateCursoToSave(cursoLocal,this.arrDatoGeneral);
	        	
				CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cursoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCurso(cursoLocal)) {				
					CursoDataAccess.save(cursoLocal, connexion);				
				} else {
					validadoTodosCurso=false;
				}
			}
			
			if(!validadoTodosCurso) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CursoLogicAdditional.checkCursoToSavesAfter(cursos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCursosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CursoParameterReturnGeneral procesarAccionCursos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Curso> cursos,CursoParameterReturnGeneral cursoParameterGeneral)throws Exception {
		 try {	
			CursoParameterReturnGeneral cursoReturnGeneral=new CursoParameterReturnGeneral();
	
			CursoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cursos,cursoParameterGeneral,cursoReturnGeneral);
			
			return cursoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CursoParameterReturnGeneral procesarAccionCursosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Curso> cursos,CursoParameterReturnGeneral cursoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-procesarAccionCursosWithConnection");connexion.begin();			
			
			CursoParameterReturnGeneral cursoReturnGeneral=new CursoParameterReturnGeneral();
	
			CursoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cursos,cursoParameterGeneral,cursoReturnGeneral);
			
			this.connexion.commit();
			
			return cursoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CursoParameterReturnGeneral procesarEventosCursos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Curso> cursos,Curso curso,CursoParameterReturnGeneral cursoParameterGeneral,Boolean isEsNuevoCurso,ArrayList<Classe> clases)throws Exception {
		 try {	
			CursoParameterReturnGeneral cursoReturnGeneral=new CursoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cursoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CursoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cursos,curso,cursoParameterGeneral,cursoReturnGeneral,isEsNuevoCurso,clases);
			
			return cursoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CursoParameterReturnGeneral procesarEventosCursosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Curso> cursos,Curso curso,CursoParameterReturnGeneral cursoParameterGeneral,Boolean isEsNuevoCurso,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-procesarEventosCursosWithConnection");connexion.begin();			
			
			CursoParameterReturnGeneral cursoReturnGeneral=new CursoParameterReturnGeneral();
	
			cursoReturnGeneral.setCurso(curso);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cursoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CursoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cursos,curso,cursoParameterGeneral,cursoReturnGeneral,isEsNuevoCurso,clases);
			
			this.connexion.commit();
			
			return cursoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CursoParameterReturnGeneral procesarImportacionCursosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CursoParameterReturnGeneral cursoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-procesarImportacionCursosWithConnection");connexion.begin();			
			
			CursoParameterReturnGeneral cursoReturnGeneral=new CursoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cursos=new ArrayList<Curso>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.curso=new Curso();
				
				
				if(conColumnasBase) {this.curso.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.curso.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.curso.setnombre(arrColumnas[iColumn++]);
				this.curso.setcodigo_inscripcion(arrColumnas[iColumn++]);
				this.curso.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.curso.setfecha_fin(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.curso.setnumero_horas(Integer.parseInt(arrColumnas[iColumn++]));
				this.curso.setes_aprobado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.curso.setes_auspicio_empresa(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.curso.setdescripcion(arrColumnas[iColumn++]);
				
				this.cursos.add(this.curso);
			}
			
			this.saveCursos();
			
			this.connexion.commit();
			
			cursoReturnGeneral.setConRetornoEstaProcesado(true);
			cursoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cursoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCursosEliminados() throws Exception {				
		
		List<Curso> cursosAux= new ArrayList<Curso>();
		
		for(Curso curso:cursos) {
			if(!curso.getIsDeleted()) {
				cursosAux.add(curso);
			}
		}
		
		cursos=cursosAux;
	}
	
	public void quitarCursosNulos() throws Exception {				
		
		List<Curso> cursosAux= new ArrayList<Curso>();
		
		for(Curso curso : this.cursos) {
			if(curso==null) {
				cursosAux.add(curso);
			}
		}
		
		//this.cursos=cursosAux;
		
		this.cursos.removeAll(cursosAux);
	}
	
	public void getSetVersionRowCursoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(curso.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((curso.getIsDeleted() || (curso.getIsChanged()&&!curso.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cursoDataAccess.getSetVersionRowCurso(connexion,curso.getId());
				
				if(!curso.getVersionRow().equals(timestamp)) {	
					curso.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				curso.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCurso()throws Exception {	
		
		if(curso.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((curso.getIsDeleted() || (curso.getIsChanged()&&!curso.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cursoDataAccess.getSetVersionRowCurso(connexion,curso.getId());
			
			try {							
				if(!curso.getVersionRow().equals(timestamp)) {	
					curso.setVersionRow(timestamp);
				}
				
				curso.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCursosWithConnection()throws Exception {	
		if(cursos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Curso cursoAux:cursos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cursoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cursoAux.getIsDeleted() || (cursoAux.getIsChanged()&&!cursoAux.getIsNew())) {
						
						timestamp=cursoDataAccess.getSetVersionRowCurso(connexion,cursoAux.getId());
						
						if(!curso.getVersionRow().equals(timestamp)) {	
							cursoAux.setVersionRow(timestamp);
						}
								
						cursoAux.setIsChangedAuxiliar(false);														
					//}
				}
				
				connexion.commit();									
				
			} catch(Exception e) {
				connexion.rollback();							
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCursos()throws Exception {	
		if(cursos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Curso cursoAux:cursos) {
					if(cursoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cursoAux.getIsDeleted() || (cursoAux.getIsChanged()&&!cursoAux.getIsNew())) {
						
						timestamp=cursoDataAccess.getSetVersionRowCurso(connexion,cursoAux.getId());
						
						if(!cursoAux.getVersionRow().equals(timestamp)) {	
							cursoAux.setVersionRow(timestamp);
						}
						
													
						cursoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CursoParameterReturnGeneral cargarCombosLoteForeignKeyCursoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoCurso,String finalQueryGlobalTipoInstitucion) throws Exception {
		CursoParameterReturnGeneral  cursoReturnGeneral =new CursoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-cargarCombosLoteForeignKeyCursoWithConnection");connexion.begin();
			
			cursoReturnGeneral =new CursoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cursoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			cursoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoCurso> tipocursosForeignKey=new ArrayList<TipoCurso>();
			TipoCursoLogic tipocursoLogic=new TipoCursoLogic();
			tipocursoLogic.setConnexion(this.connexion);
			tipocursoLogic.getTipoCursoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCurso.equals("NONE")) {
				tipocursoLogic.getTodosTipoCursos(finalQueryGlobalTipoCurso,new Pagination());
				tipocursosForeignKey=tipocursoLogic.getTipoCursos();
			}

			cursoReturnGeneral.settipocursosForeignKey(tipocursosForeignKey);


			List<TipoInstitucion> tipoinstitucionsForeignKey=new ArrayList<TipoInstitucion>();
			TipoInstitucionLogic tipoinstitucionLogic=new TipoInstitucionLogic();
			tipoinstitucionLogic.setConnexion(this.connexion);
			tipoinstitucionLogic.getTipoInstitucionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoInstitucion.equals("NONE")) {
				tipoinstitucionLogic.getTodosTipoInstitucions(finalQueryGlobalTipoInstitucion,new Pagination());
				tipoinstitucionsForeignKey=tipoinstitucionLogic.getTipoInstitucions();
			}

			cursoReturnGeneral.settipoinstitucionsForeignKey(tipoinstitucionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cursoReturnGeneral;
	}
	
	public CursoParameterReturnGeneral cargarCombosLoteForeignKeyCurso(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoCurso,String finalQueryGlobalTipoInstitucion) throws Exception {
		CursoParameterReturnGeneral  cursoReturnGeneral =new CursoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cursoReturnGeneral =new CursoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cursoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			cursoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoCurso> tipocursosForeignKey=new ArrayList<TipoCurso>();
			TipoCursoLogic tipocursoLogic=new TipoCursoLogic();
			tipocursoLogic.setConnexion(this.connexion);
			tipocursoLogic.getTipoCursoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCurso.equals("NONE")) {
				tipocursoLogic.getTodosTipoCursos(finalQueryGlobalTipoCurso,new Pagination());
				tipocursosForeignKey=tipocursoLogic.getTipoCursos();
			}

			cursoReturnGeneral.settipocursosForeignKey(tipocursosForeignKey);


			List<TipoInstitucion> tipoinstitucionsForeignKey=new ArrayList<TipoInstitucion>();
			TipoInstitucionLogic tipoinstitucionLogic=new TipoInstitucionLogic();
			tipoinstitucionLogic.setConnexion(this.connexion);
			tipoinstitucionLogic.getTipoInstitucionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoInstitucion.equals("NONE")) {
				tipoinstitucionLogic.getTodosTipoInstitucions(finalQueryGlobalTipoInstitucion,new Pagination());
				tipoinstitucionsForeignKey=tipoinstitucionLogic.getTipoInstitucions();
			}

			cursoReturnGeneral.settipoinstitucionsForeignKey(tipoinstitucionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cursoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyCursoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleCursoLogic detallecursoLogic=new DetalleCursoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyCursoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleCurso.class));
											
			

			detallecursoLogic.setConnexion(this.getConnexion());
			detallecursoLogic.setDatosCliente(this.datosCliente);
			detallecursoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Curso curso:this.cursos) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleCursoConstantesFunciones.getClassesForeignKeysOfDetalleCurso(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallecursoLogic.setDetalleCursos(curso.detallecursos);
				detallecursoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			}
			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
	}
	
	public void deepLoad(Curso curso,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CursoLogicAdditional.updateCursoToGet(curso,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		curso.setEmpresa(cursoDataAccess.getEmpresa(connexion,curso));
		curso.setEmpleado(cursoDataAccess.getEmpleado(connexion,curso));
		curso.setTipoCurso(cursoDataAccess.getTipoCurso(connexion,curso));
		curso.setTipoInstitucion(cursoDataAccess.getTipoInstitucion(connexion,curso));
		curso.setDetalleCursos(cursoDataAccess.getDetalleCursos(connexion,curso));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				curso.setEmpresa(cursoDataAccess.getEmpresa(connexion,curso));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				curso.setEmpleado(cursoDataAccess.getEmpleado(connexion,curso));
				continue;
			}

			if(clas.clas.equals(TipoCurso.class)) {
				curso.setTipoCurso(cursoDataAccess.getTipoCurso(connexion,curso));
				continue;
			}

			if(clas.clas.equals(TipoInstitucion.class)) {
				curso.setTipoInstitucion(cursoDataAccess.getTipoInstitucion(connexion,curso));
				continue;
			}

			if(clas.clas.equals(DetalleCurso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				curso.setDetalleCursos(cursoDataAccess.getDetalleCursos(connexion,curso));

				if(this.isConDeep) {
					DetalleCursoLogic detallecursoLogic= new DetalleCursoLogic(this.connexion);
					detallecursoLogic.setDetalleCursos(curso.getDetalleCursos());
					ArrayList<Classe> classesLocal=DetalleCursoConstantesFunciones.getClassesForeignKeysOfDetalleCurso(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallecursoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(detallecursoLogic.getDetalleCursos());
					curso.setDetalleCursos(detallecursoLogic.getDetalleCursos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			curso.setEmpresa(cursoDataAccess.getEmpresa(connexion,curso));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			curso.setEmpleado(cursoDataAccess.getEmpleado(connexion,curso));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCurso.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			curso.setTipoCurso(cursoDataAccess.getTipoCurso(connexion,curso));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoInstitucion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			curso.setTipoInstitucion(cursoDataAccess.getTipoInstitucion(connexion,curso));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleCurso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleCurso.class));
			curso.setDetalleCursos(cursoDataAccess.getDetalleCursos(connexion,curso));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		curso.setEmpresa(cursoDataAccess.getEmpresa(connexion,curso));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(curso.getEmpresa(),isDeep,deepLoadType,clases);
				
		curso.setEmpleado(cursoDataAccess.getEmpleado(connexion,curso));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(curso.getEmpleado(),isDeep,deepLoadType,clases);
				
		curso.setTipoCurso(cursoDataAccess.getTipoCurso(connexion,curso));
		TipoCursoLogic tipocursoLogic= new TipoCursoLogic(connexion);
		tipocursoLogic.deepLoad(curso.getTipoCurso(),isDeep,deepLoadType,clases);
				
		curso.setTipoInstitucion(cursoDataAccess.getTipoInstitucion(connexion,curso));
		TipoInstitucionLogic tipoinstitucionLogic= new TipoInstitucionLogic(connexion);
		tipoinstitucionLogic.deepLoad(curso.getTipoInstitucion(),isDeep,deepLoadType,clases);
				

		curso.setDetalleCursos(cursoDataAccess.getDetalleCursos(connexion,curso));

		for(DetalleCurso detallecurso:curso.getDetalleCursos()) {
			DetalleCursoLogic detallecursoLogic= new DetalleCursoLogic(connexion);
			detallecursoLogic.deepLoad(detallecurso,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				curso.setEmpresa(cursoDataAccess.getEmpresa(connexion,curso));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(curso.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				curso.setEmpleado(cursoDataAccess.getEmpleado(connexion,curso));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(curso.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCurso.class)) {
				curso.setTipoCurso(cursoDataAccess.getTipoCurso(connexion,curso));
				TipoCursoLogic tipocursoLogic= new TipoCursoLogic(connexion);
				tipocursoLogic.deepLoad(curso.getTipoCurso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoInstitucion.class)) {
				curso.setTipoInstitucion(cursoDataAccess.getTipoInstitucion(connexion,curso));
				TipoInstitucionLogic tipoinstitucionLogic= new TipoInstitucionLogic(connexion);
				tipoinstitucionLogic.deepLoad(curso.getTipoInstitucion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleCurso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				curso.setDetalleCursos(cursoDataAccess.getDetalleCursos(connexion,curso));

				for(DetalleCurso detallecurso:curso.getDetalleCursos()) {
					DetalleCursoLogic detallecursoLogic= new DetalleCursoLogic(connexion);
					detallecursoLogic.deepLoad(detallecurso,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			curso.setEmpresa(cursoDataAccess.getEmpresa(connexion,curso));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(curso.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			curso.setEmpleado(cursoDataAccess.getEmpleado(connexion,curso));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(curso.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCurso.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			curso.setTipoCurso(cursoDataAccess.getTipoCurso(connexion,curso));
			TipoCursoLogic tipocursoLogic= new TipoCursoLogic(connexion);
			tipocursoLogic.deepLoad(curso.getTipoCurso(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoInstitucion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			curso.setTipoInstitucion(cursoDataAccess.getTipoInstitucion(connexion,curso));
			TipoInstitucionLogic tipoinstitucionLogic= new TipoInstitucionLogic(connexion);
			tipoinstitucionLogic.deepLoad(curso.getTipoInstitucion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleCurso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleCurso.class));
			curso.setDetalleCursos(cursoDataAccess.getDetalleCursos(connexion,curso));

			for(DetalleCurso detallecurso:curso.getDetalleCursos()) {
				DetalleCursoLogic detallecursoLogic= new DetalleCursoLogic(connexion);
				detallecursoLogic.deepLoad(detallecurso,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Curso curso,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CursoLogicAdditional.updateCursoToSave(curso,this.arrDatoGeneral);
			
CursoDataAccess.save(curso, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(curso.getEmpresa(),connexion);

		EmpleadoDataAccess.save(curso.getEmpleado(),connexion);

		TipoCursoDataAccess.save(curso.getTipoCurso(),connexion);

		TipoInstitucionDataAccess.save(curso.getTipoInstitucion(),connexion);

		for(DetalleCurso detallecurso:curso.getDetalleCursos()) {
			detallecurso.setid_curso(curso.getId());
			DetalleCursoDataAccess.save(detallecurso,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(curso.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(curso.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCurso.class)) {
				TipoCursoDataAccess.save(curso.getTipoCurso(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoInstitucion.class)) {
				TipoInstitucionDataAccess.save(curso.getTipoInstitucion(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleCurso.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleCurso detallecurso:curso.getDetalleCursos()) {
					detallecurso.setid_curso(curso.getId());
					DetalleCursoDataAccess.save(detallecurso,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(curso.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(curso.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(curso.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(curso.getEmpleado(),isDeep,deepLoadType,clases);
				

		TipoCursoDataAccess.save(curso.getTipoCurso(),connexion);
		TipoCursoLogic tipocursoLogic= new TipoCursoLogic(connexion);
		tipocursoLogic.deepLoad(curso.getTipoCurso(),isDeep,deepLoadType,clases);
				

		TipoInstitucionDataAccess.save(curso.getTipoInstitucion(),connexion);
		TipoInstitucionLogic tipoinstitucionLogic= new TipoInstitucionLogic(connexion);
		tipoinstitucionLogic.deepLoad(curso.getTipoInstitucion(),isDeep,deepLoadType,clases);
				

		for(DetalleCurso detallecurso:curso.getDetalleCursos()) {
			DetalleCursoLogic detallecursoLogic= new DetalleCursoLogic(connexion);
			detallecurso.setid_curso(curso.getId());
			DetalleCursoDataAccess.save(detallecurso,connexion);
			detallecursoLogic.deepSave(detallecurso,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(curso.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(curso.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(curso.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(curso.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCurso.class)) {
				TipoCursoDataAccess.save(curso.getTipoCurso(),connexion);
				TipoCursoLogic tipocursoLogic= new TipoCursoLogic(connexion);
				tipocursoLogic.deepSave(curso.getTipoCurso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoInstitucion.class)) {
				TipoInstitucionDataAccess.save(curso.getTipoInstitucion(),connexion);
				TipoInstitucionLogic tipoinstitucionLogic= new TipoInstitucionLogic(connexion);
				tipoinstitucionLogic.deepSave(curso.getTipoInstitucion(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleCurso.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleCurso detallecurso:curso.getDetalleCursos()) {
					DetalleCursoLogic detallecursoLogic= new DetalleCursoLogic(connexion);
					detallecurso.setid_curso(curso.getId());
					DetalleCursoDataAccess.save(detallecurso,connexion);
					detallecursoLogic.deepSave(detallecurso,isDeep,deepLoadType,clases);
				}
				continue;
			}
		}
	}

	}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Curso.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(curso,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(curso);
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoad(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.deepLoad(this.curso,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.curso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Curso.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cursos!=null) {
				for(Curso curso:cursos) {
					this.deepLoad(curso,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(cursos);
				}
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoads(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			if(cursos!=null) {
				for(Curso curso:cursos) {
					this.deepLoad(curso,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(cursos);
				}	
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
		
	public void deepSaveWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			this.getNewConnexionToDeep(Curso.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(curso,isDeep,deepLoadType,clases);	
			
			this.connexion.commit();
		} catch(Exception e) {			
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSavesWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			this.getNewConnexionToDeep(Curso.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cursos!=null) {
				for(Curso curso:cursos) {
					this.deepSave(curso,isDeep,deepLoadType,clases);
				}
			}
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		}finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSaves(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			if(cursos!=null) {
				for(Curso curso:cursos) {
					this.deepSave(curso,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCursosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,CursoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cursos=cursoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCursosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,CursoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cursos=cursoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCursosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CursoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cursos=cursoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCursosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CursoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cursos=cursoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCursosFK_IdTipoCursoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_curso)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCurso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCurso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_curso,CursoConstantesFunciones.IDTIPOCURSO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCurso);

			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCurso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cursos=cursoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCursosFK_IdTipoCurso(String sFinalQuery,Pagination pagination,Long id_tipo_curso)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCurso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCurso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_curso,CursoConstantesFunciones.IDTIPOCURSO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCurso);

			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCurso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cursos=cursoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCursosFK_IdTipoInstitucionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_institucion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Curso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoInstitucion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoInstitucion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_institucion,CursoConstantesFunciones.IDTIPOINSTITUCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoInstitucion);

			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoInstitucion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cursos=cursoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCursosFK_IdTipoInstitucion(String sFinalQuery,Pagination pagination,Long id_tipo_institucion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoInstitucion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoInstitucion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_institucion,CursoConstantesFunciones.IDTIPOINSTITUCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoInstitucion);

			CursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoInstitucion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cursos=cursoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(this.cursos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CursoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CursoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Curso curso,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CursoConstantesFunciones.ISCONAUDITORIA) {
				if(curso.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CursoDataAccess.TABLENAME, curso.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CursoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CursoLogic.registrarAuditoriaDetallesCurso(connexion,curso,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(curso.getIsDeleted()) {
					/*if(!curso.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CursoDataAccess.TABLENAME, curso.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CursoLogic.registrarAuditoriaDetallesCurso(connexion,curso,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CursoDataAccess.TABLENAME, curso.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(curso.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CursoDataAccess.TABLENAME, curso.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CursoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CursoLogic.registrarAuditoriaDetallesCurso(connexion,curso,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCurso(Connexion connexion,Curso curso)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(curso.getIsNew()||!curso.getid_empresa().equals(curso.getCursoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(curso.getCursoOriginal().getid_empresa()!=null)
				{
					strValorActual=curso.getCursoOriginal().getid_empresa().toString();
				}
				if(curso.getid_empresa()!=null)
				{
					strValorNuevo=curso.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CursoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(curso.getIsNew()||!curso.getid_empleado().equals(curso.getCursoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(curso.getCursoOriginal().getid_empleado()!=null)
				{
					strValorActual=curso.getCursoOriginal().getid_empleado().toString();
				}
				if(curso.getid_empleado()!=null)
				{
					strValorNuevo=curso.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CursoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(curso.getIsNew()||!curso.getid_tipo_curso().equals(curso.getCursoOriginal().getid_tipo_curso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(curso.getCursoOriginal().getid_tipo_curso()!=null)
				{
					strValorActual=curso.getCursoOriginal().getid_tipo_curso().toString();
				}
				if(curso.getid_tipo_curso()!=null)
				{
					strValorNuevo=curso.getid_tipo_curso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CursoConstantesFunciones.IDTIPOCURSO,strValorActual,strValorNuevo);
			}	
			
			if(curso.getIsNew()||!curso.getid_tipo_institucion().equals(curso.getCursoOriginal().getid_tipo_institucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(curso.getCursoOriginal().getid_tipo_institucion()!=null)
				{
					strValorActual=curso.getCursoOriginal().getid_tipo_institucion().toString();
				}
				if(curso.getid_tipo_institucion()!=null)
				{
					strValorNuevo=curso.getid_tipo_institucion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CursoConstantesFunciones.IDTIPOINSTITUCION,strValorActual,strValorNuevo);
			}	
			
			if(curso.getIsNew()||!curso.getnombre().equals(curso.getCursoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(curso.getCursoOriginal().getnombre()!=null)
				{
					strValorActual=curso.getCursoOriginal().getnombre();
				}
				if(curso.getnombre()!=null)
				{
					strValorNuevo=curso.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CursoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(curso.getIsNew()||!curso.getcodigo_inscripcion().equals(curso.getCursoOriginal().getcodigo_inscripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(curso.getCursoOriginal().getcodigo_inscripcion()!=null)
				{
					strValorActual=curso.getCursoOriginal().getcodigo_inscripcion();
				}
				if(curso.getcodigo_inscripcion()!=null)
				{
					strValorNuevo=curso.getcodigo_inscripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CursoConstantesFunciones.CODIGOINSCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(curso.getIsNew()||!curso.getfecha_inicio().equals(curso.getCursoOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(curso.getCursoOriginal().getfecha_inicio()!=null)
				{
					strValorActual=curso.getCursoOriginal().getfecha_inicio().toString();
				}
				if(curso.getfecha_inicio()!=null)
				{
					strValorNuevo=curso.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CursoConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(curso.getIsNew()||!curso.getfecha_fin().equals(curso.getCursoOriginal().getfecha_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(curso.getCursoOriginal().getfecha_fin()!=null)
				{
					strValorActual=curso.getCursoOriginal().getfecha_fin().toString();
				}
				if(curso.getfecha_fin()!=null)
				{
					strValorNuevo=curso.getfecha_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CursoConstantesFunciones.FECHAFIN,strValorActual,strValorNuevo);
			}	
			
			if(curso.getIsNew()||!curso.getnumero_horas().equals(curso.getCursoOriginal().getnumero_horas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(curso.getCursoOriginal().getnumero_horas()!=null)
				{
					strValorActual=curso.getCursoOriginal().getnumero_horas().toString();
				}
				if(curso.getnumero_horas()!=null)
				{
					strValorNuevo=curso.getnumero_horas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CursoConstantesFunciones.NUMEROHORAS,strValorActual,strValorNuevo);
			}	
			
			if(curso.getIsNew()||!curso.getes_aprobado().equals(curso.getCursoOriginal().getes_aprobado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(curso.getCursoOriginal().getes_aprobado()!=null)
				{
					strValorActual=curso.getCursoOriginal().getes_aprobado().toString();
				}
				if(curso.getes_aprobado()!=null)
				{
					strValorNuevo=curso.getes_aprobado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CursoConstantesFunciones.ESAPROBADO,strValorActual,strValorNuevo);
			}	
			
			if(curso.getIsNew()||!curso.getes_auspicio_empresa().equals(curso.getCursoOriginal().getes_auspicio_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(curso.getCursoOriginal().getes_auspicio_empresa()!=null)
				{
					strValorActual=curso.getCursoOriginal().getes_auspicio_empresa().toString();
				}
				if(curso.getes_auspicio_empresa()!=null)
				{
					strValorNuevo=curso.getes_auspicio_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CursoConstantesFunciones.ESAUSPICIOEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(curso.getIsNew()||!curso.getdescripcion().equals(curso.getCursoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(curso.getCursoOriginal().getdescripcion()!=null)
				{
					strValorActual=curso.getCursoOriginal().getdescripcion();
				}
				if(curso.getdescripcion()!=null)
				{
					strValorNuevo=curso.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CursoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCursoRelacionesWithConnection(Curso curso,List<DetalleCurso> detallecursos) throws Exception {

		if(!curso.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCursoRelacionesBase(curso,detallecursos,true);
		}
	}

	public void saveCursoRelaciones(Curso curso,List<DetalleCurso> detallecursos)throws Exception {

		if(!curso.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCursoRelacionesBase(curso,detallecursos,false);
		}
	}

	public void saveCursoRelacionesBase(Curso curso,List<DetalleCurso> detallecursos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Curso-saveRelacionesWithConnection");}
	
			curso.setDetalleCursos(detallecursos);

			this.setCurso(curso);

			if(CursoLogicAdditional.validarSaveRelaciones(curso,this)) {

				CursoLogicAdditional.updateRelacionesToSave(curso,this);

				if((curso.getIsNew()||curso.getIsChanged())&&!curso.getIsDeleted()) {
					this.saveCurso();
					this.saveCursoRelacionesDetalles(detallecursos);

				} else if(curso.getIsDeleted()) {
					this.saveCursoRelacionesDetalles(detallecursos);
					this.saveCurso();
				}

				CursoLogicAdditional.updateRelacionesToSaveAfter(curso,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleCursoConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleCursos(detallecursos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveCursoRelacionesDetalles(List<DetalleCurso> detallecursos)throws Exception {
		try {
	

			Long idCursoActual=this.getCurso().getId();

			DetalleCursoLogic detallecursoLogic_Desde_Curso=new DetalleCursoLogic();
			detallecursoLogic_Desde_Curso.setDetalleCursos(detallecursos);

			detallecursoLogic_Desde_Curso.setConnexion(this.getConnexion());
			detallecursoLogic_Desde_Curso.setDatosCliente(this.datosCliente);

			for(DetalleCurso detallecurso_Desde_Curso:detallecursoLogic_Desde_Curso.getDetalleCursos()) {
				detallecurso_Desde_Curso.setid_curso(idCursoActual);
			}

			detallecursoLogic_Desde_Curso.saveDetalleCursos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCurso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CursoConstantesFunciones.getClassesForeignKeysOfCurso(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCurso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CursoConstantesFunciones.getClassesRelationshipsOfCurso(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

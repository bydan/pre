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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.LineaConstantesFunciones;
import com.bydan.erp.inventario.util.LineaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.LineaParameterGeneral;
import com.bydan.erp.inventario.business.entity.Linea;
import com.bydan.erp.inventario.business.logic.LineaLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class LineaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(LineaLogic.class);
	
	protected LineaDataAccess lineaDataAccess; 	
	protected Linea linea;
	protected List<Linea> lineas;
	protected Object lineaObject;	
	protected List<Object> lineasObject;
	
	public static ClassValidator<Linea> lineaValidator = new ClassValidator<Linea>(Linea.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected LineaLogicAdditional lineaLogicAdditional=null;
	
	public LineaLogicAdditional getLineaLogicAdditional() {
		return this.lineaLogicAdditional;
	}
	
	public void setLineaLogicAdditional(LineaLogicAdditional lineaLogicAdditional) {
		try {
			this.lineaLogicAdditional=lineaLogicAdditional;
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
	
	
	
	
	public  LineaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.lineaDataAccess = new LineaDataAccess();
			
			this.lineas= new ArrayList<Linea>();
			this.linea= new Linea();
			
			this.lineaObject=new Object();
			this.lineasObject=new ArrayList<Object>();
				
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
			
			this.lineaDataAccess.setConnexionType(this.connexionType);
			this.lineaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  LineaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.lineaDataAccess = new LineaDataAccess();
			this.lineas= new ArrayList<Linea>();
			this.linea= new Linea();
			this.lineaObject=new Object();
			this.lineasObject=new ArrayList<Object>();
			
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
			
			this.lineaDataAccess.setConnexionType(this.connexionType);
			this.lineaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Linea getLinea() throws Exception {	
		LineaLogicAdditional.checkLineaToGet(linea,this.datosCliente,this.arrDatoGeneral);
		LineaLogicAdditional.updateLineaToGet(linea,this.arrDatoGeneral);
		
		return linea;
	}
		
	public void setLinea(Linea newLinea) {
		this.linea = newLinea;
	}
	
	public LineaDataAccess getLineaDataAccess() {
		return lineaDataAccess;
	}
	
	public void setLineaDataAccess(LineaDataAccess newlineaDataAccess) {
		this.lineaDataAccess = newlineaDataAccess;
	}
	
	public List<Linea> getLineas() throws Exception {		
		this.quitarLineasNulos();
		
		LineaLogicAdditional.checkLineaToGets(lineas,this.datosCliente,this.arrDatoGeneral);
		
		for (Linea lineaLocal: lineas ) {
			LineaLogicAdditional.updateLineaToGet(lineaLocal,this.arrDatoGeneral);
		}
		
		return lineas;
	}
	
	public void setLineas(List<Linea> newLineas) {
		this.lineas = newLineas;
	}
	
	public Object getLineaObject() {	
		this.lineaObject=this.lineaDataAccess.getEntityObject();
		return this.lineaObject;
	}
		
	public void setLineaObject(Object newLineaObject) {
		this.lineaObject = newLineaObject;
	}
	
	public List<Object> getLineasObject() {		
		this.lineasObject=this.lineaDataAccess.getEntitiesObject();
		return this.lineasObject;
	}
		
	public void setLineasObject(List<Object> newLineasObject) {
		this.lineasObject = newLineasObject;
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
		
		if(this.lineaDataAccess!=null) {
			this.lineaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			lineaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			lineaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		linea = new  Linea();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			linea=lineaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.linea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.linea);
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
		linea = new  Linea();
		  		  
        try {
			
			linea=lineaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.linea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.linea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		linea = new  Linea();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			linea=lineaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.linea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.linea);
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
		linea = new  Linea();
		  		  
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
		linea = new  Linea();
		  		  
        try {
			
			linea=lineaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.linea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.linea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		linea = new  Linea();
		  		  
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
		linea = new  Linea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =lineaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		linea = new  Linea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=lineaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		linea = new  Linea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =lineaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		linea = new  Linea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=lineaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		linea = new  Linea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =lineaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		linea = new  Linea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=lineaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		lineas = new  ArrayList<Linea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineas=lineaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLinea(lineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
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
		lineas = new  ArrayList<Linea>();
		  		  
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
		lineas = new  ArrayList<Linea>();
		  		  
        try {			
			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineas=lineaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarLinea(lineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		lineas = new  ArrayList<Linea>();
		  		  
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
		lineas = new  ArrayList<Linea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineas=lineaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLinea(lineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
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
		lineas = new  ArrayList<Linea>();
		  		  
        try {
			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineas=lineaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLinea(lineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
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
		lineas = new  ArrayList<Linea>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineas=lineaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLinea(lineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
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
		lineas = new  ArrayList<Linea>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineas=lineaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLinea(lineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		linea = new  Linea();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			linea=lineaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLinea(linea);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.linea);
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
		linea = new  Linea();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			linea=lineaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLinea(linea);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.linea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		lineas = new  ArrayList<Linea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineas=lineaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLinea(lineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
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
		lineas = new  ArrayList<Linea>();
		  		  
        try {
			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineas=lineaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLinea(lineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosLineasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		lineas = new  ArrayList<Linea>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-getTodosLineasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineas=lineaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarLinea(lineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
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
	
	public  void  getTodosLineas(String sFinalQuery,Pagination pagination)throws Exception {
		lineas = new  ArrayList<Linea>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineas=lineaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarLinea(lineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarLinea(Linea linea) throws Exception {
		Boolean estaValidado=false;
		
		if(linea.getIsNew() || linea.getIsChanged()) { 
			this.invalidValues = lineaValidator.getInvalidValues(linea);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(linea);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarLinea(List<Linea> Lineas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Linea lineaLocal:lineas) {				
			estaValidadoObjeto=this.validarGuardarLinea(lineaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarLinea(List<Linea> Lineas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarLinea(lineas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarLinea(Linea Linea) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarLinea(linea)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Linea linea) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+linea.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=LineaConstantesFunciones.getLineaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"linea","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(LineaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(LineaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveLineaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-saveLineaWithConnection");connexion.begin();			
			
			LineaLogicAdditional.checkLineaToSave(this.linea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			LineaLogicAdditional.updateLineaToSave(this.linea,this.arrDatoGeneral);
			
			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.linea,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowLinea();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarLinea(this.linea)) {
				LineaDataAccess.save(this.linea, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.linea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			LineaLogicAdditional.checkLineaToSaveAfter(this.linea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowLinea();
			
			connexion.commit();			
			
			if(this.linea.getIsDeleted()) {
				this.linea=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveLinea()throws Exception {	
		try {	
			
			LineaLogicAdditional.checkLineaToSave(this.linea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			LineaLogicAdditional.updateLineaToSave(this.linea,this.arrDatoGeneral);
			
			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.linea,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarLinea(this.linea)) {			
				LineaDataAccess.save(this.linea, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.linea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			LineaLogicAdditional.checkLineaToSaveAfter(this.linea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.linea.getIsDeleted()) {
				this.linea=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveLineasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-saveLineasWithConnection");connexion.begin();			
			
			LineaLogicAdditional.checkLineaToSaves(lineas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowLineas();
			
			Boolean validadoTodosLinea=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Linea lineaLocal:lineas) {		
				if(lineaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				LineaLogicAdditional.updateLineaToSave(lineaLocal,this.arrDatoGeneral);
	        	
				LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),lineaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarLinea(lineaLocal)) {
					LineaDataAccess.save(lineaLocal, connexion);				
				} else {
					validadoTodosLinea=false;
				}
			}
			
			if(!validadoTodosLinea) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			LineaLogicAdditional.checkLineaToSavesAfter(lineas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowLineas();
			
			connexion.commit();		
			
			this.quitarLineasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveLineas()throws Exception {				
		 try {	
			LineaLogicAdditional.checkLineaToSaves(lineas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosLinea=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Linea lineaLocal:lineas) {				
				if(lineaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				LineaLogicAdditional.updateLineaToSave(lineaLocal,this.arrDatoGeneral);
	        	
				LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),lineaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarLinea(lineaLocal)) {				
					LineaDataAccess.save(lineaLocal, connexion);				
				} else {
					validadoTodosLinea=false;
				}
			}
			
			if(!validadoTodosLinea) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			LineaLogicAdditional.checkLineaToSavesAfter(lineas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarLineasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public LineaParameterReturnGeneral procesarAccionLineas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Linea> lineas,LineaParameterReturnGeneral lineaParameterGeneral)throws Exception {
		 try {	
			LineaParameterReturnGeneral lineaReturnGeneral=new LineaParameterReturnGeneral();
	
			LineaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,lineas,lineaParameterGeneral,lineaReturnGeneral);
			
			return lineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public LineaParameterReturnGeneral procesarAccionLineasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Linea> lineas,LineaParameterReturnGeneral lineaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-procesarAccionLineasWithConnection");connexion.begin();			
			
			LineaParameterReturnGeneral lineaReturnGeneral=new LineaParameterReturnGeneral();
	
			LineaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,lineas,lineaParameterGeneral,lineaReturnGeneral);
			
			this.connexion.commit();
			
			return lineaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public LineaParameterReturnGeneral procesarEventosLineas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Linea> lineas,Linea linea,LineaParameterReturnGeneral lineaParameterGeneral,Boolean isEsNuevoLinea,ArrayList<Classe> clases)throws Exception {
		 try {	
			LineaParameterReturnGeneral lineaReturnGeneral=new LineaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				lineaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			LineaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,lineas,linea,lineaParameterGeneral,lineaReturnGeneral,isEsNuevoLinea,clases);
			
			return lineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public LineaParameterReturnGeneral procesarEventosLineasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Linea> lineas,Linea linea,LineaParameterReturnGeneral lineaParameterGeneral,Boolean isEsNuevoLinea,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-procesarEventosLineasWithConnection");connexion.begin();			
			
			LineaParameterReturnGeneral lineaReturnGeneral=new LineaParameterReturnGeneral();
	
			lineaReturnGeneral.setLinea(linea);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				lineaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			LineaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,lineas,linea,lineaParameterGeneral,lineaReturnGeneral,isEsNuevoLinea,clases);
			
			this.connexion.commit();
			
			return lineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public LineaParameterReturnGeneral procesarImportacionLineasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,LineaParameterReturnGeneral lineaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-procesarImportacionLineasWithConnection");connexion.begin();			
			
			LineaParameterReturnGeneral lineaReturnGeneral=new LineaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.lineas=new ArrayList<Linea>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.linea=new Linea();
				
				
				if(conColumnasBase) {this.linea.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.linea.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.linea.setcodigo(arrColumnas[iColumn++]);
				this.linea.setnombre(arrColumnas[iColumn++]);
			this.linea.setdescripcion(arrColumnas[iColumn++]);
				
				this.lineas.add(this.linea);
			}
			
			this.saveLineas();
			
			this.connexion.commit();
			
			lineaReturnGeneral.setConRetornoEstaProcesado(true);
			lineaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return lineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarLineasEliminados() throws Exception {				
		
		List<Linea> lineasAux= new ArrayList<Linea>();
		
		for(Linea linea:lineas) {
			if(!linea.getIsDeleted()) {
				lineasAux.add(linea);
			}
		}
		
		lineas=lineasAux;
	}
	
	public void quitarLineasNulos() throws Exception {				
		
		List<Linea> lineasAux= new ArrayList<Linea>();
		
		for(Linea linea : this.lineas) {
			if(linea==null) {
				lineasAux.add(linea);
			}
		}
		
		//this.lineas=lineasAux;
		
		this.lineas.removeAll(lineasAux);
	}
	
	public void getSetVersionRowLineaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(linea.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((linea.getIsDeleted() || (linea.getIsChanged()&&!linea.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=lineaDataAccess.getSetVersionRowLinea(connexion,linea.getId());
				
				if(!linea.getVersionRow().equals(timestamp)) {	
					linea.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				linea.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowLinea()throws Exception {	
		
		if(linea.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((linea.getIsDeleted() || (linea.getIsChanged()&&!linea.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=lineaDataAccess.getSetVersionRowLinea(connexion,linea.getId());
			
			try {							
				if(!linea.getVersionRow().equals(timestamp)) {	
					linea.setVersionRow(timestamp);
				}
				
				linea.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowLineasWithConnection()throws Exception {	
		if(lineas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Linea lineaAux:lineas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(lineaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(lineaAux.getIsDeleted() || (lineaAux.getIsChanged()&&!lineaAux.getIsNew())) {
						
						timestamp=lineaDataAccess.getSetVersionRowLinea(connexion,lineaAux.getId());
						
						if(!linea.getVersionRow().equals(timestamp)) {	
							lineaAux.setVersionRow(timestamp);
						}
								
						lineaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowLineas()throws Exception {	
		if(lineas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Linea lineaAux:lineas) {
					if(lineaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(lineaAux.getIsDeleted() || (lineaAux.getIsChanged()&&!lineaAux.getIsNew())) {
						
						timestamp=lineaDataAccess.getSetVersionRowLinea(connexion,lineaAux.getId());
						
						if(!lineaAux.getVersionRow().equals(timestamp)) {	
							lineaAux.setVersionRow(timestamp);
						}
						
													
						lineaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public LineaParameterReturnGeneral cargarCombosLoteForeignKeyLineaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalNivelLinea,String finalQueryGlobalLinea) throws Exception {
		LineaParameterReturnGeneral  lineaReturnGeneral =new LineaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-cargarCombosLoteForeignKeyLineaWithConnection");connexion.begin();
			
			lineaReturnGeneral =new LineaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			lineaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<NivelLinea> nivellineasForeignKey=new ArrayList<NivelLinea>();
			NivelLineaLogic nivellineaLogic=new NivelLineaLogic();
			nivellineaLogic.setConnexion(this.connexion);
			nivellineaLogic.getNivelLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNivelLinea.equals("NONE")) {
				nivellineaLogic.getTodosNivelLineas(finalQueryGlobalNivelLinea,new Pagination());
				nivellineasForeignKey=nivellineaLogic.getNivelLineas();
			}

			lineaReturnGeneral.setnivellineasForeignKey(nivellineasForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			lineaReturnGeneral.setlineasForeignKey(lineasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return lineaReturnGeneral;
	}
	
	public LineaParameterReturnGeneral cargarCombosLoteForeignKeyLinea(String finalQueryGlobalEmpresa,String finalQueryGlobalNivelLinea,String finalQueryGlobalLinea) throws Exception {
		LineaParameterReturnGeneral  lineaReturnGeneral =new LineaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			lineaReturnGeneral =new LineaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			lineaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<NivelLinea> nivellineasForeignKey=new ArrayList<NivelLinea>();
			NivelLineaLogic nivellineaLogic=new NivelLineaLogic();
			nivellineaLogic.setConnexion(this.connexion);
			nivellineaLogic.getNivelLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNivelLinea.equals("NONE")) {
				nivellineaLogic.getTodosNivelLineas(finalQueryGlobalNivelLinea,new Pagination());
				nivellineasForeignKey=nivellineaLogic.getNivelLineas();
			}

			lineaReturnGeneral.setnivellineasForeignKey(nivellineasForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			lineaReturnGeneral.setlineasForeignKey(lineasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return lineaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyLineaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PresupuestoLineaLogic presupuestolineaLogic=new PresupuestoLineaLogic();
			LineaLogic lineaLogic=new LineaLogic();
			ComisionGrupoLogic comisiongrupoLogic=new ComisionGrupoLogic();
			ProductoPuntoVentaLogic productopuntoventaLogic=new ProductoPuntoVentaLogic();
			ComisionLineaLogic comisionlineaLogic=new ComisionLineaLogic();
			ComisionCateLogic comisioncateLogic=new ComisionCateLogic();
			DetallePlaneacionCompraLogic detalleplaneacioncompraLogic=new DetallePlaneacionCompraLogic();
			CuentasContablesLineaProductoLogic cuentascontableslineaproductoLogic=new CuentasContablesLineaProductoLogic();
			PrecioLogic precioLogic=new PrecioLogic();
			LineaPuntoVentaLogic lineapuntoventaLogic=new LineaPuntoVentaLogic();
			DetalleCodigoBarraProductoLogic detallecodigobarraproductoLogic=new DetalleCodigoBarraProductoLogic();
			PresupuestoVentasLineasLogic presupuestoventaslineasLogic=new PresupuestoVentasLineasLogic();
			CentroCostoGrupoProductoLogic centrocostogrupoproductoLogic=new CentroCostoGrupoProductoLogic();
			ProductoLogic productoLogic=new ProductoLogic();
			ComisionMarcaLogic comisionmarcaLogic=new ComisionMarcaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyLineaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PresupuestoLinea.class));
			classes.add(new Classe(Linea.class));
			classes.add(new Classe(ComisionGrupo.class));
			classes.add(new Classe(ProductoPuntoVenta.class));
			classes.add(new Classe(ComisionLinea.class));
			classes.add(new Classe(ComisionCate.class));
			classes.add(new Classe(DetallePlaneacionCompra.class));
			classes.add(new Classe(CuentasContablesLineaProducto.class));
			classes.add(new Classe(Precio.class));
			classes.add(new Classe(LineaPuntoVenta.class));
			classes.add(new Classe(DetalleCodigoBarraProducto.class));
			classes.add(new Classe(PresupuestoVentasLineas.class));
			classes.add(new Classe(CentroCostoGrupoProducto.class));
			classes.add(new Classe(Producto.class));
			classes.add(new Classe(ComisionMarca.class));
											
			

			presupuestolineaLogic.setConnexion(this.getConnexion());
			presupuestolineaLogic.setDatosCliente(this.datosCliente);
			presupuestolineaLogic.setIsConRefrescarForeignKeys(true);

			lineaLogic.setConnexion(this.getConnexion());
			lineaLogic.setDatosCliente(this.datosCliente);
			lineaLogic.setIsConRefrescarForeignKeys(true);

			comisiongrupoLogic.setConnexion(this.getConnexion());
			comisiongrupoLogic.setDatosCliente(this.datosCliente);
			comisiongrupoLogic.setIsConRefrescarForeignKeys(true);

			productopuntoventaLogic.setConnexion(this.getConnexion());
			productopuntoventaLogic.setDatosCliente(this.datosCliente);
			productopuntoventaLogic.setIsConRefrescarForeignKeys(true);

			comisionlineaLogic.setConnexion(this.getConnexion());
			comisionlineaLogic.setDatosCliente(this.datosCliente);
			comisionlineaLogic.setIsConRefrescarForeignKeys(true);

			comisioncateLogic.setConnexion(this.getConnexion());
			comisioncateLogic.setDatosCliente(this.datosCliente);
			comisioncateLogic.setIsConRefrescarForeignKeys(true);

			detalleplaneacioncompraLogic.setConnexion(this.getConnexion());
			detalleplaneacioncompraLogic.setDatosCliente(this.datosCliente);
			detalleplaneacioncompraLogic.setIsConRefrescarForeignKeys(true);

			cuentascontableslineaproductoLogic.setConnexion(this.getConnexion());
			cuentascontableslineaproductoLogic.setDatosCliente(this.datosCliente);
			cuentascontableslineaproductoLogic.setIsConRefrescarForeignKeys(true);

			precioLogic.setConnexion(this.getConnexion());
			precioLogic.setDatosCliente(this.datosCliente);
			precioLogic.setIsConRefrescarForeignKeys(true);

			lineapuntoventaLogic.setConnexion(this.getConnexion());
			lineapuntoventaLogic.setDatosCliente(this.datosCliente);
			lineapuntoventaLogic.setIsConRefrescarForeignKeys(true);

			detallecodigobarraproductoLogic.setConnexion(this.getConnexion());
			detallecodigobarraproductoLogic.setDatosCliente(this.datosCliente);
			detallecodigobarraproductoLogic.setIsConRefrescarForeignKeys(true);

			presupuestoventaslineasLogic.setConnexion(this.getConnexion());
			presupuestoventaslineasLogic.setDatosCliente(this.datosCliente);
			presupuestoventaslineasLogic.setIsConRefrescarForeignKeys(true);

			centrocostogrupoproductoLogic.setConnexion(this.getConnexion());
			centrocostogrupoproductoLogic.setDatosCliente(this.datosCliente);
			centrocostogrupoproductoLogic.setIsConRefrescarForeignKeys(true);

			productoLogic.setConnexion(this.getConnexion());
			productoLogic.setDatosCliente(this.datosCliente);
			productoLogic.setIsConRefrescarForeignKeys(true);

			comisionmarcaLogic.setConnexion(this.getConnexion());
			comisionmarcaLogic.setDatosCliente(this.datosCliente);
			comisionmarcaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Linea linea:this.lineas) {
				

				classes=new ArrayList<Classe>();
				classes=PresupuestoLineaConstantesFunciones.getClassesForeignKeysOfPresupuestoLinea(new ArrayList<Classe>(),DeepLoadType.NONE);

				presupuestolineaLogic.setPresupuestoLineas(linea.presupuestolineas);
				presupuestolineaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=LineaConstantesFunciones.getClassesForeignKeysOfLinea(new ArrayList<Classe>(),DeepLoadType.NONE);

				lineaLogic.setLineas(linea.lineas);
				lineaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ComisionGrupoConstantesFunciones.getClassesForeignKeysOfComisionGrupo(new ArrayList<Classe>(),DeepLoadType.NONE);

				comisiongrupoLogic.setComisionGrupos(linea.comisiongrupoGrupos);
				comisiongrupoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoPuntoVentaConstantesFunciones.getClassesForeignKeysOfProductoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				productopuntoventaLogic.setProductoPuntoVentas(linea.productopuntoventas);
				productopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ComisionLineaConstantesFunciones.getClassesForeignKeysOfComisionLinea(new ArrayList<Classe>(),DeepLoadType.NONE);

				comisionlineaLogic.setComisionLineas(linea.comisionlineas);
				comisionlineaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ComisionCateConstantesFunciones.getClassesForeignKeysOfComisionCate(new ArrayList<Classe>(),DeepLoadType.NONE);

				comisioncateLogic.setComisionCates(linea.comisioncates);
				comisioncateLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetallePlaneacionCompraConstantesFunciones.getClassesForeignKeysOfDetallePlaneacionCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleplaneacioncompraLogic.setDetallePlaneacionCompras(linea.detalleplaneacioncompras);
				detalleplaneacioncompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CuentasContablesLineaProductoConstantesFunciones.getClassesForeignKeysOfCuentasContablesLineaProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				cuentascontableslineaproductoLogic.setCuentasContablesLineaProductos(linea.cuentascontableslineaproductoCategorias);
				cuentascontableslineaproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PrecioConstantesFunciones.getClassesForeignKeysOfPrecio(new ArrayList<Classe>(),DeepLoadType.NONE);

				precioLogic.setPrecios(linea.precioGrupos);
				precioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=LineaPuntoVentaConstantesFunciones.getClassesForeignKeysOfLineaPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				lineapuntoventaLogic.setLineaPuntoVentas(linea.lineapuntoventaMarcas);
				lineapuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleCodigoBarraProductoConstantesFunciones.getClassesForeignKeysOfDetalleCodigoBarraProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallecodigobarraproductoLogic.setDetalleCodigoBarraProductos(linea.detallecodigobarraproductoMarcas);
				detallecodigobarraproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PresupuestoVentasLineasConstantesFunciones.getClassesForeignKeysOfPresupuestoVentasLineas(new ArrayList<Classe>(),DeepLoadType.NONE);

				presupuestoventaslineasLogic.setPresupuestoVentasLineass(linea.presupuestoventaslineasMarcas);
				presupuestoventaslineasLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CentroCostoGrupoProductoConstantesFunciones.getClassesForeignKeysOfCentroCostoGrupoProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				centrocostogrupoproductoLogic.setCentroCostoGrupoProductos(linea.centrocostogrupoproductos);
				centrocostogrupoproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoConstantesFunciones.getClassesForeignKeysOfProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoLogic.setProductos(linea.productos);
				productoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ComisionMarcaConstantesFunciones.getClassesForeignKeysOfComisionMarca(new ArrayList<Classe>(),DeepLoadType.NONE);

				comisionmarcaLogic.setComisionMarcas(linea.comisionmarcaGrupos);
				comisionmarcaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Linea linea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			LineaLogicAdditional.updateLineaToGet(linea,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		linea.setEmpresa(lineaDataAccess.getEmpresa(connexion,linea));
		linea.setNivelLinea(lineaDataAccess.getNivelLinea(connexion,linea));
		linea.setLinea(lineaDataAccess.getLinea(connexion,linea));
		linea.setPresupuestoLineas(lineaDataAccess.getPresupuestoLineas(connexion,linea));
		linea.setLineas(lineaDataAccess.getLineas(connexion,linea));
		linea.setComisionGrupoGrupos(lineaDataAccess.getComisionGrupoGrupos(connexion,linea));
		linea.setProductoPuntoVentas(lineaDataAccess.getProductoPuntoVentas(connexion,linea));
		linea.setComisionLineas(lineaDataAccess.getComisionLineas(connexion,linea));
		linea.setComisionCates(lineaDataAccess.getComisionCates(connexion,linea));
		linea.setDetallePlaneacionCompras(lineaDataAccess.getDetallePlaneacionCompras(connexion,linea));
		linea.setCuentasContablesLineaProductoCategorias(lineaDataAccess.getCuentasContablesLineaProductoCategorias(connexion,linea));
		linea.setPrecioGrupos(lineaDataAccess.getPrecioGrupos(connexion,linea));
		linea.setLineaPuntoVentaMarcas(lineaDataAccess.getLineaPuntoVentaMarcas(connexion,linea));
		linea.setDetalleCodigoBarraProductoMarcas(lineaDataAccess.getDetalleCodigoBarraProductoMarcas(connexion,linea));
		linea.setPresupuestoVentasLineasMarcas(lineaDataAccess.getPresupuestoVentasLineasMarcas(connexion,linea));
		linea.setCentroCostoGrupoProductos(lineaDataAccess.getCentroCostoGrupoProductos(connexion,linea));
		linea.setProductos(lineaDataAccess.getProductos(connexion,linea));
		linea.setComisionMarcaGrupos(lineaDataAccess.getComisionMarcaGrupos(connexion,linea));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				linea.setEmpresa(lineaDataAccess.getEmpresa(connexion,linea));
				continue;
			}

			if(clas.clas.equals(NivelLinea.class)) {
				linea.setNivelLinea(lineaDataAccess.getNivelLinea(connexion,linea));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				linea.setLinea(lineaDataAccess.getLinea(connexion,linea));
				continue;
			}

			if(clas.clas.equals(PresupuestoLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setPresupuestoLineas(lineaDataAccess.getPresupuestoLineas(connexion,linea));

				if(this.isConDeep) {
					PresupuestoLineaLogic presupuestolineaLogic= new PresupuestoLineaLogic(this.connexion);
					presupuestolineaLogic.setPresupuestoLineas(linea.getPresupuestoLineas());
					ArrayList<Classe> classesLocal=PresupuestoLineaConstantesFunciones.getClassesForeignKeysOfPresupuestoLinea(new ArrayList<Classe>(),DeepLoadType.NONE);
					presupuestolineaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(presupuestolineaLogic.getPresupuestoLineas());
					linea.setPresupuestoLineas(presupuestolineaLogic.getPresupuestoLineas());
				}

				continue;
			}

			if(clas.clas.equals(Linea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setLineas(lineaDataAccess.getLineas(connexion,linea));

				if(this.isConDeep) {
					LineaLogic lineaLogic= new LineaLogic(this.connexion);
					lineaLogic.setLineas(linea.getLineas());
					ArrayList<Classe> classesLocal=LineaConstantesFunciones.getClassesForeignKeysOfLinea(new ArrayList<Classe>(),DeepLoadType.NONE);
					lineaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(lineaLogic.getLineas());
					linea.setLineas(lineaLogic.getLineas());
				}

				continue;
			}

			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setComisionGrupoGrupos(lineaDataAccess.getComisionGrupoGrupos(connexion,linea));

				if(this.isConDeep) {
					ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(this.connexion);
					comisiongrupoLogic.setComisionGrupos(linea.getComisionGrupoGrupos());
					ArrayList<Classe> classesLocal=ComisionGrupoConstantesFunciones.getClassesForeignKeysOfComisionGrupo(new ArrayList<Classe>(),DeepLoadType.NONE);
					comisiongrupoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(comisiongrupoLogic.getComisionGrupos());
					linea.setComisionGrupoGrupos(comisiongrupoLogic.getComisionGrupos());
				}

				continue;
			}

			if(clas.clas.equals(ProductoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setProductoPuntoVentas(lineaDataAccess.getProductoPuntoVentas(connexion,linea));

				if(this.isConDeep) {
					ProductoPuntoVentaLogic productopuntoventaLogic= new ProductoPuntoVentaLogic(this.connexion);
					productopuntoventaLogic.setProductoPuntoVentas(linea.getProductoPuntoVentas());
					ArrayList<Classe> classesLocal=ProductoPuntoVentaConstantesFunciones.getClassesForeignKeysOfProductoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					productopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesProductoPuntoVenta(productopuntoventaLogic.getProductoPuntoVentas());
					linea.setProductoPuntoVentas(productopuntoventaLogic.getProductoPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setComisionLineas(lineaDataAccess.getComisionLineas(connexion,linea));

				if(this.isConDeep) {
					ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(this.connexion);
					comisionlineaLogic.setComisionLineas(linea.getComisionLineas());
					ArrayList<Classe> classesLocal=ComisionLineaConstantesFunciones.getClassesForeignKeysOfComisionLinea(new ArrayList<Classe>(),DeepLoadType.NONE);
					comisionlineaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(comisionlineaLogic.getComisionLineas());
					linea.setComisionLineas(comisionlineaLogic.getComisionLineas());
				}

				continue;
			}

			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setComisionCates(lineaDataAccess.getComisionCates(connexion,linea));

				if(this.isConDeep) {
					ComisionCateLogic comisioncateLogic= new ComisionCateLogic(this.connexion);
					comisioncateLogic.setComisionCates(linea.getComisionCates());
					ArrayList<Classe> classesLocal=ComisionCateConstantesFunciones.getClassesForeignKeysOfComisionCate(new ArrayList<Classe>(),DeepLoadType.NONE);
					comisioncateLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(comisioncateLogic.getComisionCates());
					linea.setComisionCates(comisioncateLogic.getComisionCates());
				}

				continue;
			}

			if(clas.clas.equals(DetallePlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setDetallePlaneacionCompras(lineaDataAccess.getDetallePlaneacionCompras(connexion,linea));

				if(this.isConDeep) {
					DetallePlaneacionCompraLogic detalleplaneacioncompraLogic= new DetallePlaneacionCompraLogic(this.connexion);
					detalleplaneacioncompraLogic.setDetallePlaneacionCompras(linea.getDetallePlaneacionCompras());
					ArrayList<Classe> classesLocal=DetallePlaneacionCompraConstantesFunciones.getClassesForeignKeysOfDetallePlaneacionCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleplaneacioncompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(detalleplaneacioncompraLogic.getDetallePlaneacionCompras());
					linea.setDetallePlaneacionCompras(detalleplaneacioncompraLogic.getDetallePlaneacionCompras());
				}

				continue;
			}

			if(clas.clas.equals(CuentasContablesLineaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setCuentasContablesLineaProductoCategorias(lineaDataAccess.getCuentasContablesLineaProductoCategorias(connexion,linea));

				if(this.isConDeep) {
					CuentasContablesLineaProductoLogic cuentascontableslineaproductoLogic= new CuentasContablesLineaProductoLogic(this.connexion);
					cuentascontableslineaproductoLogic.setCuentasContablesLineaProductos(linea.getCuentasContablesLineaProductoCategorias());
					ArrayList<Classe> classesLocal=CuentasContablesLineaProductoConstantesFunciones.getClassesForeignKeysOfCuentasContablesLineaProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					cuentascontableslineaproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(cuentascontableslineaproductoLogic.getCuentasContablesLineaProductos());
					linea.setCuentasContablesLineaProductoCategorias(cuentascontableslineaproductoLogic.getCuentasContablesLineaProductos());
				}

				continue;
			}

			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setPrecioGrupos(lineaDataAccess.getPrecioGrupos(connexion,linea));

				if(this.isConDeep) {
					PrecioLogic precioLogic= new PrecioLogic(this.connexion);
					precioLogic.setPrecios(linea.getPrecioGrupos());
					ArrayList<Classe> classesLocal=PrecioConstantesFunciones.getClassesForeignKeysOfPrecio(new ArrayList<Classe>(),DeepLoadType.NONE);
					precioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(precioLogic.getPrecios());
					linea.setPrecioGrupos(precioLogic.getPrecios());
				}

				continue;
			}

			if(clas.clas.equals(LineaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setLineaPuntoVentaMarcas(lineaDataAccess.getLineaPuntoVentaMarcas(connexion,linea));

				if(this.isConDeep) {
					LineaPuntoVentaLogic lineapuntoventaLogic= new LineaPuntoVentaLogic(this.connexion);
					lineapuntoventaLogic.setLineaPuntoVentas(linea.getLineaPuntoVentaMarcas());
					ArrayList<Classe> classesLocal=LineaPuntoVentaConstantesFunciones.getClassesForeignKeysOfLineaPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					lineapuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(lineapuntoventaLogic.getLineaPuntoVentas());
					linea.setLineaPuntoVentaMarcas(lineapuntoventaLogic.getLineaPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(DetalleCodigoBarraProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setDetalleCodigoBarraProductoMarcas(lineaDataAccess.getDetalleCodigoBarraProductoMarcas(connexion,linea));

				if(this.isConDeep) {
					DetalleCodigoBarraProductoLogic detallecodigobarraproductoLogic= new DetalleCodigoBarraProductoLogic(this.connexion);
					detallecodigobarraproductoLogic.setDetalleCodigoBarraProductos(linea.getDetalleCodigoBarraProductoMarcas());
					ArrayList<Classe> classesLocal=DetalleCodigoBarraProductoConstantesFunciones.getClassesForeignKeysOfDetalleCodigoBarraProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallecodigobarraproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(detallecodigobarraproductoLogic.getDetalleCodigoBarraProductos());
					linea.setDetalleCodigoBarraProductoMarcas(detallecodigobarraproductoLogic.getDetalleCodigoBarraProductos());
				}

				continue;
			}

			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setPresupuestoVentasLineasMarcas(lineaDataAccess.getPresupuestoVentasLineasMarcas(connexion,linea));

				if(this.isConDeep) {
					PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(this.connexion);
					presupuestoventaslineasLogic.setPresupuestoVentasLineass(linea.getPresupuestoVentasLineasMarcas());
					ArrayList<Classe> classesLocal=PresupuestoVentasLineasConstantesFunciones.getClassesForeignKeysOfPresupuestoVentasLineas(new ArrayList<Classe>(),DeepLoadType.NONE);
					presupuestoventaslineasLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(presupuestoventaslineasLogic.getPresupuestoVentasLineass());
					linea.setPresupuestoVentasLineasMarcas(presupuestoventaslineasLogic.getPresupuestoVentasLineass());
				}

				continue;
			}

			if(clas.clas.equals(CentroCostoGrupoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setCentroCostoGrupoProductos(lineaDataAccess.getCentroCostoGrupoProductos(connexion,linea));

				if(this.isConDeep) {
					CentroCostoGrupoProductoLogic centrocostogrupoproductoLogic= new CentroCostoGrupoProductoLogic(this.connexion);
					centrocostogrupoproductoLogic.setCentroCostoGrupoProductos(linea.getCentroCostoGrupoProductos());
					ArrayList<Classe> classesLocal=CentroCostoGrupoProductoConstantesFunciones.getClassesForeignKeysOfCentroCostoGrupoProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					centrocostogrupoproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(centrocostogrupoproductoLogic.getCentroCostoGrupoProductos());
					linea.setCentroCostoGrupoProductos(centrocostogrupoproductoLogic.getCentroCostoGrupoProductos());
				}

				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setProductos(lineaDataAccess.getProductos(connexion,linea));

				if(this.isConDeep) {
					ProductoLogic productoLogic= new ProductoLogic(this.connexion);
					productoLogic.setProductos(linea.getProductos());
					ArrayList<Classe> classesLocal=ProductoConstantesFunciones.getClassesForeignKeysOfProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(productoLogic.getProductos());
					linea.setProductos(productoLogic.getProductos());
				}

				continue;
			}

			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setComisionMarcaGrupos(lineaDataAccess.getComisionMarcaGrupos(connexion,linea));

				if(this.isConDeep) {
					ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(this.connexion);
					comisionmarcaLogic.setComisionMarcas(linea.getComisionMarcaGrupos());
					ArrayList<Classe> classesLocal=ComisionMarcaConstantesFunciones.getClassesForeignKeysOfComisionMarca(new ArrayList<Classe>(),DeepLoadType.NONE);
					comisionmarcaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(comisionmarcaLogic.getComisionMarcas());
					linea.setComisionMarcaGrupos(comisionmarcaLogic.getComisionMarcas());
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
			linea.setEmpresa(lineaDataAccess.getEmpresa(connexion,linea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NivelLinea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			linea.setNivelLinea(lineaDataAccess.getNivelLinea(connexion,linea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			linea.setLinea(lineaDataAccess.getLinea(connexion,linea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoLinea.class));
			linea.setPresupuestoLineas(lineaDataAccess.getPresupuestoLineas(connexion,linea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Linea.class));
			linea.setLineas(lineaDataAccess.getLineas(connexion,linea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionGrupo.class));
			linea.setComisionGrupoGrupos(lineaDataAccess.getComisionGrupoGrupos(connexion,linea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoPuntoVenta.class));
			linea.setProductoPuntoVentas(lineaDataAccess.getProductoPuntoVentas(connexion,linea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionLinea.class));
			linea.setComisionLineas(lineaDataAccess.getComisionLineas(connexion,linea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionCate.class));
			linea.setComisionCates(lineaDataAccess.getComisionCates(connexion,linea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePlaneacionCompra.class));
			linea.setDetallePlaneacionCompras(lineaDataAccess.getDetallePlaneacionCompras(connexion,linea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentasContablesLineaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentasContablesLineaProducto.class));
			linea.setCuentasContablesLineaProductoCategorias(lineaDataAccess.getCuentasContablesLineaProductoCategorias(connexion,linea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Precio.class));
			linea.setPrecioGrupos(lineaDataAccess.getPrecioGrupos(connexion,linea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LineaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(LineaPuntoVenta.class));
			linea.setLineaPuntoVentaMarcas(lineaDataAccess.getLineaPuntoVentaMarcas(connexion,linea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleCodigoBarraProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleCodigoBarraProducto.class));
			linea.setDetalleCodigoBarraProductoMarcas(lineaDataAccess.getDetalleCodigoBarraProductoMarcas(connexion,linea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoVentasLineas.class));
			linea.setPresupuestoVentasLineasMarcas(lineaDataAccess.getPresupuestoVentasLineasMarcas(connexion,linea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCostoGrupoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CentroCostoGrupoProducto.class));
			linea.setCentroCostoGrupoProductos(lineaDataAccess.getCentroCostoGrupoProductos(connexion,linea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Producto.class));
			linea.setProductos(lineaDataAccess.getProductos(connexion,linea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionMarca.class));
			linea.setComisionMarcaGrupos(lineaDataAccess.getComisionMarcaGrupos(connexion,linea));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		linea.setEmpresa(lineaDataAccess.getEmpresa(connexion,linea));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(linea.getEmpresa(),isDeep,deepLoadType,clases);
				
		linea.setNivelLinea(lineaDataAccess.getNivelLinea(connexion,linea));
		NivelLineaLogic nivellineaLogic= new NivelLineaLogic(connexion);
		nivellineaLogic.deepLoad(linea.getNivelLinea(),isDeep,deepLoadType,clases);
				
		linea.setLinea(lineaDataAccess.getLinea(connexion,linea));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(linea.getLinea(),isDeep,deepLoadType,clases);
				

		linea.setPresupuestoLineas(lineaDataAccess.getPresupuestoLineas(connexion,linea));

		for(PresupuestoLinea presupuestolinea:linea.getPresupuestoLineas()) {
			PresupuestoLineaLogic presupuestolineaLogic= new PresupuestoLineaLogic(connexion);
			presupuestolineaLogic.deepLoad(presupuestolinea,isDeep,deepLoadType,clases);
		}

		linea.setLineas(lineaDataAccess.getLineas(connexion,linea));

		for(Linea lineaRecursivo:linea.getLineas()) {
			LineaLogic lineaRecursivoLogic= new LineaLogic(connexion);
			lineaRecursivoLogic.deepLoad(lineaRecursivo,isDeep,deepLoadType,clases);
		}

		linea.setComisionGrupoGrupos(lineaDataAccess.getComisionGrupoGrupos(connexion,linea));

		for(ComisionGrupo comisiongrupo:linea.getComisionGrupoGrupos()) {
			ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(connexion);
			comisiongrupoLogic.deepLoad(comisiongrupo,isDeep,deepLoadType,clases);
		}

		linea.setProductoPuntoVentas(lineaDataAccess.getProductoPuntoVentas(connexion,linea));

		for(ProductoPuntoVenta productopuntoventa:linea.getProductoPuntoVentas()) {
			ProductoPuntoVentaLogic productopuntoventaLogic= new ProductoPuntoVentaLogic(connexion);
			productopuntoventaLogic.deepLoad(productopuntoventa,isDeep,deepLoadType,clases);
		}

		linea.setComisionLineas(lineaDataAccess.getComisionLineas(connexion,linea));

		for(ComisionLinea comisionlinea:linea.getComisionLineas()) {
			ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(connexion);
			comisionlineaLogic.deepLoad(comisionlinea,isDeep,deepLoadType,clases);
		}

		linea.setComisionCates(lineaDataAccess.getComisionCates(connexion,linea));

		for(ComisionCate comisioncate:linea.getComisionCates()) {
			ComisionCateLogic comisioncateLogic= new ComisionCateLogic(connexion);
			comisioncateLogic.deepLoad(comisioncate,isDeep,deepLoadType,clases);
		}

		linea.setDetallePlaneacionCompras(lineaDataAccess.getDetallePlaneacionCompras(connexion,linea));

		for(DetallePlaneacionCompra detalleplaneacioncompra:linea.getDetallePlaneacionCompras()) {
			DetallePlaneacionCompraLogic detalleplaneacioncompraLogic= new DetallePlaneacionCompraLogic(connexion);
			detalleplaneacioncompraLogic.deepLoad(detalleplaneacioncompra,isDeep,deepLoadType,clases);
		}

		linea.setCuentasContablesLineaProductoCategorias(lineaDataAccess.getCuentasContablesLineaProductoCategorias(connexion,linea));

		for(CuentasContablesLineaProducto cuentascontableslineaproducto:linea.getCuentasContablesLineaProductoCategorias()) {
			CuentasContablesLineaProductoLogic cuentascontableslineaproductoLogic= new CuentasContablesLineaProductoLogic(connexion);
			cuentascontableslineaproductoLogic.deepLoad(cuentascontableslineaproducto,isDeep,deepLoadType,clases);
		}

		linea.setPrecioGrupos(lineaDataAccess.getPrecioGrupos(connexion,linea));

		for(Precio precio:linea.getPrecioGrupos()) {
			PrecioLogic precioLogic= new PrecioLogic(connexion);
			precioLogic.deepLoad(precio,isDeep,deepLoadType,clases);
		}

		linea.setLineaPuntoVentaMarcas(lineaDataAccess.getLineaPuntoVentaMarcas(connexion,linea));

		for(LineaPuntoVenta lineapuntoventa:linea.getLineaPuntoVentaMarcas()) {
			LineaPuntoVentaLogic lineapuntoventaLogic= new LineaPuntoVentaLogic(connexion);
			lineapuntoventaLogic.deepLoad(lineapuntoventa,isDeep,deepLoadType,clases);
		}

		linea.setDetalleCodigoBarraProductoMarcas(lineaDataAccess.getDetalleCodigoBarraProductoMarcas(connexion,linea));

		for(DetalleCodigoBarraProducto detallecodigobarraproducto:linea.getDetalleCodigoBarraProductoMarcas()) {
			DetalleCodigoBarraProductoLogic detallecodigobarraproductoLogic= new DetalleCodigoBarraProductoLogic(connexion);
			detallecodigobarraproductoLogic.deepLoad(detallecodigobarraproducto,isDeep,deepLoadType,clases);
		}

		linea.setPresupuestoVentasLineasMarcas(lineaDataAccess.getPresupuestoVentasLineasMarcas(connexion,linea));

		for(PresupuestoVentasLineas presupuestoventaslineas:linea.getPresupuestoVentasLineasMarcas()) {
			PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(connexion);
			presupuestoventaslineasLogic.deepLoad(presupuestoventaslineas,isDeep,deepLoadType,clases);
		}

		linea.setCentroCostoGrupoProductos(lineaDataAccess.getCentroCostoGrupoProductos(connexion,linea));

		for(CentroCostoGrupoProducto centrocostogrupoproducto:linea.getCentroCostoGrupoProductos()) {
			CentroCostoGrupoProductoLogic centrocostogrupoproductoLogic= new CentroCostoGrupoProductoLogic(connexion);
			centrocostogrupoproductoLogic.deepLoad(centrocostogrupoproducto,isDeep,deepLoadType,clases);
		}

		linea.setProductos(lineaDataAccess.getProductos(connexion,linea));

		for(Producto producto:linea.getProductos()) {
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
		}

		linea.setComisionMarcaGrupos(lineaDataAccess.getComisionMarcaGrupos(connexion,linea));

		for(ComisionMarca comisionmarca:linea.getComisionMarcaGrupos()) {
			ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(connexion);
			comisionmarcaLogic.deepLoad(comisionmarca,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				linea.setEmpresa(lineaDataAccess.getEmpresa(connexion,linea));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(linea.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NivelLinea.class)) {
				linea.setNivelLinea(lineaDataAccess.getNivelLinea(connexion,linea));
				NivelLineaLogic nivellineaLogic= new NivelLineaLogic(connexion);
				nivellineaLogic.deepLoad(linea.getNivelLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				linea.setLinea(lineaDataAccess.getLinea(connexion,linea));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(linea.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PresupuestoLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setPresupuestoLineas(lineaDataAccess.getPresupuestoLineas(connexion,linea));

				for(PresupuestoLinea presupuestolinea:linea.getPresupuestoLineas()) {
					PresupuestoLineaLogic presupuestolineaLogic= new PresupuestoLineaLogic(connexion);
					presupuestolineaLogic.deepLoad(presupuestolinea,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Linea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setLineas(lineaDataAccess.getLineas(connexion,linea));

				for(Linea lineaRecursivo:linea.getLineas()) {
					LineaLogic lineaRecursivoLogic= new LineaLogic(connexion);
					lineaRecursivoLogic.deepLoad(lineaRecursivo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setComisionGrupoGrupos(lineaDataAccess.getComisionGrupoGrupos(connexion,linea));

				for(ComisionGrupo comisiongrupo:linea.getComisionGrupoGrupos()) {
					ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(connexion);
					comisiongrupoLogic.deepLoad(comisiongrupo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setProductoPuntoVentas(lineaDataAccess.getProductoPuntoVentas(connexion,linea));

				for(ProductoPuntoVenta productopuntoventa:linea.getProductoPuntoVentas()) {
					ProductoPuntoVentaLogic productopuntoventaLogic= new ProductoPuntoVentaLogic(connexion);
					productopuntoventaLogic.deepLoad(productopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setComisionLineas(lineaDataAccess.getComisionLineas(connexion,linea));

				for(ComisionLinea comisionlinea:linea.getComisionLineas()) {
					ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(connexion);
					comisionlineaLogic.deepLoad(comisionlinea,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setComisionCates(lineaDataAccess.getComisionCates(connexion,linea));

				for(ComisionCate comisioncate:linea.getComisionCates()) {
					ComisionCateLogic comisioncateLogic= new ComisionCateLogic(connexion);
					comisioncateLogic.deepLoad(comisioncate,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetallePlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setDetallePlaneacionCompras(lineaDataAccess.getDetallePlaneacionCompras(connexion,linea));

				for(DetallePlaneacionCompra detalleplaneacioncompra:linea.getDetallePlaneacionCompras()) {
					DetallePlaneacionCompraLogic detalleplaneacioncompraLogic= new DetallePlaneacionCompraLogic(connexion);
					detalleplaneacioncompraLogic.deepLoad(detalleplaneacioncompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CuentasContablesLineaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setCuentasContablesLineaProductoCategorias(lineaDataAccess.getCuentasContablesLineaProductoCategorias(connexion,linea));

				for(CuentasContablesLineaProducto cuentascontableslineaproducto:linea.getCuentasContablesLineaProductoCategorias()) {
					CuentasContablesLineaProductoLogic cuentascontableslineaproductoLogic= new CuentasContablesLineaProductoLogic(connexion);
					cuentascontableslineaproductoLogic.deepLoad(cuentascontableslineaproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setPrecioGrupos(lineaDataAccess.getPrecioGrupos(connexion,linea));

				for(Precio precio:linea.getPrecioGrupos()) {
					PrecioLogic precioLogic= new PrecioLogic(connexion);
					precioLogic.deepLoad(precio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(LineaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setLineaPuntoVentaMarcas(lineaDataAccess.getLineaPuntoVentaMarcas(connexion,linea));

				for(LineaPuntoVenta lineapuntoventa:linea.getLineaPuntoVentaMarcas()) {
					LineaPuntoVentaLogic lineapuntoventaLogic= new LineaPuntoVentaLogic(connexion);
					lineapuntoventaLogic.deepLoad(lineapuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleCodigoBarraProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setDetalleCodigoBarraProductoMarcas(lineaDataAccess.getDetalleCodigoBarraProductoMarcas(connexion,linea));

				for(DetalleCodigoBarraProducto detallecodigobarraproducto:linea.getDetalleCodigoBarraProductoMarcas()) {
					DetalleCodigoBarraProductoLogic detallecodigobarraproductoLogic= new DetalleCodigoBarraProductoLogic(connexion);
					detallecodigobarraproductoLogic.deepLoad(detallecodigobarraproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setPresupuestoVentasLineasMarcas(lineaDataAccess.getPresupuestoVentasLineasMarcas(connexion,linea));

				for(PresupuestoVentasLineas presupuestoventaslineas:linea.getPresupuestoVentasLineasMarcas()) {
					PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(connexion);
					presupuestoventaslineasLogic.deepLoad(presupuestoventaslineas,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CentroCostoGrupoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setCentroCostoGrupoProductos(lineaDataAccess.getCentroCostoGrupoProductos(connexion,linea));

				for(CentroCostoGrupoProducto centrocostogrupoproducto:linea.getCentroCostoGrupoProductos()) {
					CentroCostoGrupoProductoLogic centrocostogrupoproductoLogic= new CentroCostoGrupoProductoLogic(connexion);
					centrocostogrupoproductoLogic.deepLoad(centrocostogrupoproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setProductos(lineaDataAccess.getProductos(connexion,linea));

				for(Producto producto:linea.getProductos()) {
					ProductoLogic productoLogic= new ProductoLogic(connexion);
					productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				linea.setComisionMarcaGrupos(lineaDataAccess.getComisionMarcaGrupos(connexion,linea));

				for(ComisionMarca comisionmarca:linea.getComisionMarcaGrupos()) {
					ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(connexion);
					comisionmarcaLogic.deepLoad(comisionmarca,isDeep,deepLoadType,clases);
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
			linea.setEmpresa(lineaDataAccess.getEmpresa(connexion,linea));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(linea.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NivelLinea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			linea.setNivelLinea(lineaDataAccess.getNivelLinea(connexion,linea));
			NivelLineaLogic nivellineaLogic= new NivelLineaLogic(connexion);
			nivellineaLogic.deepLoad(linea.getNivelLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			linea.setLinea(lineaDataAccess.getLinea(connexion,linea));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(linea.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoLinea.class));
			linea.setPresupuestoLineas(lineaDataAccess.getPresupuestoLineas(connexion,linea));

			for(PresupuestoLinea presupuestolinea:linea.getPresupuestoLineas()) {
				PresupuestoLineaLogic presupuestolineaLogic= new PresupuestoLineaLogic(connexion);
				presupuestolineaLogic.deepLoad(presupuestolinea,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Linea.class));
			linea.setLineas(lineaDataAccess.getLineas(connexion,linea));

			for(Linea lineaRecursivo:linea.getLineas()) {
				LineaLogic lineaRecursivoLogic= new LineaLogic(connexion);
				lineaRecursivoLogic.deepLoad(lineaRecursivo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionGrupo.class));
			linea.setComisionGrupoGrupos(lineaDataAccess.getComisionGrupoGrupos(connexion,linea));

			for(ComisionGrupo comisiongrupo:linea.getComisionGrupoGrupos()) {
				ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(connexion);
				comisiongrupoLogic.deepLoad(comisiongrupo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoPuntoVenta.class));
			linea.setProductoPuntoVentas(lineaDataAccess.getProductoPuntoVentas(connexion,linea));

			for(ProductoPuntoVenta productopuntoventa:linea.getProductoPuntoVentas()) {
				ProductoPuntoVentaLogic productopuntoventaLogic= new ProductoPuntoVentaLogic(connexion);
				productopuntoventaLogic.deepLoad(productopuntoventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionLinea.class));
			linea.setComisionLineas(lineaDataAccess.getComisionLineas(connexion,linea));

			for(ComisionLinea comisionlinea:linea.getComisionLineas()) {
				ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(connexion);
				comisionlineaLogic.deepLoad(comisionlinea,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionCate.class));
			linea.setComisionCates(lineaDataAccess.getComisionCates(connexion,linea));

			for(ComisionCate comisioncate:linea.getComisionCates()) {
				ComisionCateLogic comisioncateLogic= new ComisionCateLogic(connexion);
				comisioncateLogic.deepLoad(comisioncate,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePlaneacionCompra.class));
			linea.setDetallePlaneacionCompras(lineaDataAccess.getDetallePlaneacionCompras(connexion,linea));

			for(DetallePlaneacionCompra detalleplaneacioncompra:linea.getDetallePlaneacionCompras()) {
				DetallePlaneacionCompraLogic detalleplaneacioncompraLogic= new DetallePlaneacionCompraLogic(connexion);
				detalleplaneacioncompraLogic.deepLoad(detalleplaneacioncompra,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentasContablesLineaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentasContablesLineaProducto.class));
			linea.setCuentasContablesLineaProductoCategorias(lineaDataAccess.getCuentasContablesLineaProductoCategorias(connexion,linea));

			for(CuentasContablesLineaProducto cuentascontableslineaproducto:linea.getCuentasContablesLineaProductoCategorias()) {
				CuentasContablesLineaProductoLogic cuentascontableslineaproductoLogic= new CuentasContablesLineaProductoLogic(connexion);
				cuentascontableslineaproductoLogic.deepLoad(cuentascontableslineaproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Precio.class));
			linea.setPrecioGrupos(lineaDataAccess.getPrecioGrupos(connexion,linea));

			for(Precio precio:linea.getPrecioGrupos()) {
				PrecioLogic precioLogic= new PrecioLogic(connexion);
				precioLogic.deepLoad(precio,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LineaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(LineaPuntoVenta.class));
			linea.setLineaPuntoVentaMarcas(lineaDataAccess.getLineaPuntoVentaMarcas(connexion,linea));

			for(LineaPuntoVenta lineapuntoventa:linea.getLineaPuntoVentaMarcas()) {
				LineaPuntoVentaLogic lineapuntoventaLogic= new LineaPuntoVentaLogic(connexion);
				lineapuntoventaLogic.deepLoad(lineapuntoventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleCodigoBarraProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleCodigoBarraProducto.class));
			linea.setDetalleCodigoBarraProductoMarcas(lineaDataAccess.getDetalleCodigoBarraProductoMarcas(connexion,linea));

			for(DetalleCodigoBarraProducto detallecodigobarraproducto:linea.getDetalleCodigoBarraProductoMarcas()) {
				DetalleCodigoBarraProductoLogic detallecodigobarraproductoLogic= new DetalleCodigoBarraProductoLogic(connexion);
				detallecodigobarraproductoLogic.deepLoad(detallecodigobarraproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoVentasLineas.class));
			linea.setPresupuestoVentasLineasMarcas(lineaDataAccess.getPresupuestoVentasLineasMarcas(connexion,linea));

			for(PresupuestoVentasLineas presupuestoventaslineas:linea.getPresupuestoVentasLineasMarcas()) {
				PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(connexion);
				presupuestoventaslineasLogic.deepLoad(presupuestoventaslineas,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCostoGrupoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CentroCostoGrupoProducto.class));
			linea.setCentroCostoGrupoProductos(lineaDataAccess.getCentroCostoGrupoProductos(connexion,linea));

			for(CentroCostoGrupoProducto centrocostogrupoproducto:linea.getCentroCostoGrupoProductos()) {
				CentroCostoGrupoProductoLogic centrocostogrupoproductoLogic= new CentroCostoGrupoProductoLogic(connexion);
				centrocostogrupoproductoLogic.deepLoad(centrocostogrupoproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Producto.class));
			linea.setProductos(lineaDataAccess.getProductos(connexion,linea));

			for(Producto producto:linea.getProductos()) {
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionMarca.class));
			linea.setComisionMarcaGrupos(lineaDataAccess.getComisionMarcaGrupos(connexion,linea));

			for(ComisionMarca comisionmarca:linea.getComisionMarcaGrupos()) {
				ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(connexion);
				comisionmarcaLogic.deepLoad(comisionmarca,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Linea linea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			LineaLogicAdditional.updateLineaToSave(linea,this.arrDatoGeneral);
			
LineaDataAccess.save(linea, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(linea.getEmpresa(),connexion);

		NivelLineaDataAccess.save(linea.getNivelLinea(),connexion);

		LineaDataAccess.save(linea.getLinea(),connexion);

		for(PresupuestoLinea presupuestolinea:linea.getPresupuestoLineas()) {
			presupuestolinea.setid_linea(linea.getId());
			PresupuestoLineaDataAccess.save(presupuestolinea,connexion);
		}

		for(Linea lineaRecursivo:linea.getLineas()) {
			lineaRecursivo.setid_linea(linea.getId());
			LineaDataAccess.save(lineaRecursivo,connexion);
		}

		for(ComisionGrupo comisiongrupo:linea.getComisionGrupoGrupos()) {
			comisiongrupo.setid_linea_grupo(linea.getId());
			ComisionGrupoDataAccess.save(comisiongrupo,connexion);
		}

		for(ProductoPuntoVenta productopuntoventa:linea.getProductoPuntoVentas()) {
			productopuntoventa.setid_linea(linea.getId());
			ProductoPuntoVentaDataAccess.save(productopuntoventa,connexion);
		}

		for(ComisionLinea comisionlinea:linea.getComisionLineas()) {
			comisionlinea.setid_linea(linea.getId());
			ComisionLineaDataAccess.save(comisionlinea,connexion);
		}

		for(ComisionCate comisioncate:linea.getComisionCates()) {
			comisioncate.setid_linea(linea.getId());
			ComisionCateDataAccess.save(comisioncate,connexion);
		}

		for(DetallePlaneacionCompra detalleplaneacioncompra:linea.getDetallePlaneacionCompras()) {
			detalleplaneacioncompra.setid_linea(linea.getId());
			DetallePlaneacionCompraDataAccess.save(detalleplaneacioncompra,connexion);
		}

		for(CuentasContablesLineaProducto cuentascontableslineaproducto:linea.getCuentasContablesLineaProductoCategorias()) {
			cuentascontableslineaproducto.setid_linea_categoria(linea.getId());
			CuentasContablesLineaProductoDataAccess.save(cuentascontableslineaproducto,connexion);
		}

		for(Precio precio:linea.getPrecioGrupos()) {
			precio.setid_linea_grupo(linea.getId());
			PrecioDataAccess.save(precio,connexion);
		}

		for(LineaPuntoVenta lineapuntoventa:linea.getLineaPuntoVentaMarcas()) {
			lineapuntoventa.setid_linea_marca(linea.getId());
			LineaPuntoVentaDataAccess.save(lineapuntoventa,connexion);
		}

		for(DetalleCodigoBarraProducto detallecodigobarraproducto:linea.getDetalleCodigoBarraProductoMarcas()) {
			detallecodigobarraproducto.setid_linea_marca(linea.getId());
			DetalleCodigoBarraProductoDataAccess.save(detallecodigobarraproducto,connexion);
		}

		for(PresupuestoVentasLineas presupuestoventaslineas:linea.getPresupuestoVentasLineasMarcas()) {
			presupuestoventaslineas.setid_linea_marca(linea.getId());
			PresupuestoVentasLineasDataAccess.save(presupuestoventaslineas,connexion);
		}

		for(CentroCostoGrupoProducto centrocostogrupoproducto:linea.getCentroCostoGrupoProductos()) {
			centrocostogrupoproducto.setid_linea(linea.getId());
			CentroCostoGrupoProductoDataAccess.save(centrocostogrupoproducto,connexion);
		}

		for(Producto producto:linea.getProductos()) {
			producto.setid_linea(linea.getId());
			ProductoDataAccess.save(producto,connexion);
		}

		for(ComisionMarca comisionmarca:linea.getComisionMarcaGrupos()) {
			comisionmarca.setid_linea_grupo(linea.getId());
			ComisionMarcaDataAccess.save(comisionmarca,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(linea.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(NivelLinea.class)) {
				NivelLineaDataAccess.save(linea.getNivelLinea(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(linea.getLinea(),connexion);
				continue;
			}


			if(clas.clas.equals(PresupuestoLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresupuestoLinea presupuestolinea:linea.getPresupuestoLineas()) {
					presupuestolinea.setid_linea(linea.getId());
					PresupuestoLineaDataAccess.save(presupuestolinea,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Linea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Linea lineaRecursivo:linea.getLineas()) {
					lineaRecursivo.setid_linea(linea.getId());
					LineaDataAccess.save(lineaRecursivo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionGrupo comisiongrupo:linea.getComisionGrupoGrupos()) {
					comisiongrupo.setid_linea_grupo(linea.getId());
					ComisionGrupoDataAccess.save(comisiongrupo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoPuntoVenta productopuntoventa:linea.getProductoPuntoVentas()) {
					productopuntoventa.setid_linea(linea.getId());
					ProductoPuntoVentaDataAccess.save(productopuntoventa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionLinea comisionlinea:linea.getComisionLineas()) {
					comisionlinea.setid_linea(linea.getId());
					ComisionLineaDataAccess.save(comisionlinea,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionCate comisioncate:linea.getComisionCates()) {
					comisioncate.setid_linea(linea.getId());
					ComisionCateDataAccess.save(comisioncate,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetallePlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetallePlaneacionCompra detalleplaneacioncompra:linea.getDetallePlaneacionCompras()) {
					detalleplaneacioncompra.setid_linea(linea.getId());
					DetallePlaneacionCompraDataAccess.save(detalleplaneacioncompra,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CuentasContablesLineaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentasContablesLineaProducto cuentascontableslineaproducto:linea.getCuentasContablesLineaProductoCategorias()) {
					cuentascontableslineaproducto.setid_linea_categoria(linea.getId());
					CuentasContablesLineaProductoDataAccess.save(cuentascontableslineaproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Precio precio:linea.getPrecioGrupos()) {
					precio.setid_linea_grupo(linea.getId());
					PrecioDataAccess.save(precio,connexion);
				}
				continue;
			}

			if(clas.clas.equals(LineaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(LineaPuntoVenta lineapuntoventa:linea.getLineaPuntoVentaMarcas()) {
					lineapuntoventa.setid_linea_marca(linea.getId());
					LineaPuntoVentaDataAccess.save(lineapuntoventa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleCodigoBarraProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleCodigoBarraProducto detallecodigobarraproducto:linea.getDetalleCodigoBarraProductoMarcas()) {
					detallecodigobarraproducto.setid_linea_marca(linea.getId());
					DetalleCodigoBarraProductoDataAccess.save(detallecodigobarraproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresupuestoVentasLineas presupuestoventaslineas:linea.getPresupuestoVentasLineasMarcas()) {
					presupuestoventaslineas.setid_linea_marca(linea.getId());
					PresupuestoVentasLineasDataAccess.save(presupuestoventaslineas,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CentroCostoGrupoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CentroCostoGrupoProducto centrocostogrupoproducto:linea.getCentroCostoGrupoProductos()) {
					centrocostogrupoproducto.setid_linea(linea.getId());
					CentroCostoGrupoProductoDataAccess.save(centrocostogrupoproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Producto producto:linea.getProductos()) {
					producto.setid_linea(linea.getId());
					ProductoDataAccess.save(producto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionMarca comisionmarca:linea.getComisionMarcaGrupos()) {
					comisionmarca.setid_linea_grupo(linea.getId());
					ComisionMarcaDataAccess.save(comisionmarca,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(linea.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(linea.getEmpresa(),isDeep,deepLoadType,clases);
				

		NivelLineaDataAccess.save(linea.getNivelLinea(),connexion);
		NivelLineaLogic nivellineaLogic= new NivelLineaLogic(connexion);
		nivellineaLogic.deepLoad(linea.getNivelLinea(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(linea.getLinea(),connexion);
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(linea.getLinea(),isDeep,deepLoadType,clases);
				

		for(PresupuestoLinea presupuestolinea:linea.getPresupuestoLineas()) {
			PresupuestoLineaLogic presupuestolineaLogic= new PresupuestoLineaLogic(connexion);
			presupuestolinea.setid_linea(linea.getId());
			PresupuestoLineaDataAccess.save(presupuestolinea,connexion);
			presupuestolineaLogic.deepSave(presupuestolinea,isDeep,deepLoadType,clases);
		}

		for(Linea lineaRecursivo:linea.getLineas()) {
			LineaLogic lineaRecursivoLogic= new LineaLogic(connexion);
			lineaRecursivo.setid_linea(linea.getId());
			LineaDataAccess.save(lineaRecursivo,connexion);
			lineaRecursivoLogic.deepSave(lineaRecursivo,isDeep,deepLoadType,clases);
		}

		for(ComisionGrupo comisiongrupo:linea.getComisionGrupoGrupos()) {
			ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(connexion);
			comisiongrupo.setid_linea_grupo(linea.getId());
			ComisionGrupoDataAccess.save(comisiongrupo,connexion);
			comisiongrupoLogic.deepSave(comisiongrupo,isDeep,deepLoadType,clases);
		}

		for(ProductoPuntoVenta productopuntoventa:linea.getProductoPuntoVentas()) {
			ProductoPuntoVentaLogic productopuntoventaLogic= new ProductoPuntoVentaLogic(connexion);
			productopuntoventa.setid_linea(linea.getId());
			ProductoPuntoVentaDataAccess.save(productopuntoventa,connexion);
			productopuntoventaLogic.deepSave(productopuntoventa,isDeep,deepLoadType,clases);
		}

		for(ComisionLinea comisionlinea:linea.getComisionLineas()) {
			ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(connexion);
			comisionlinea.setid_linea(linea.getId());
			ComisionLineaDataAccess.save(comisionlinea,connexion);
			comisionlineaLogic.deepSave(comisionlinea,isDeep,deepLoadType,clases);
		}

		for(ComisionCate comisioncate:linea.getComisionCates()) {
			ComisionCateLogic comisioncateLogic= new ComisionCateLogic(connexion);
			comisioncate.setid_linea(linea.getId());
			ComisionCateDataAccess.save(comisioncate,connexion);
			comisioncateLogic.deepSave(comisioncate,isDeep,deepLoadType,clases);
		}

		for(DetallePlaneacionCompra detalleplaneacioncompra:linea.getDetallePlaneacionCompras()) {
			DetallePlaneacionCompraLogic detalleplaneacioncompraLogic= new DetallePlaneacionCompraLogic(connexion);
			detalleplaneacioncompra.setid_linea(linea.getId());
			DetallePlaneacionCompraDataAccess.save(detalleplaneacioncompra,connexion);
			detalleplaneacioncompraLogic.deepSave(detalleplaneacioncompra,isDeep,deepLoadType,clases);
		}

		for(CuentasContablesLineaProducto cuentascontableslineaproducto:linea.getCuentasContablesLineaProductoCategorias()) {
			CuentasContablesLineaProductoLogic cuentascontableslineaproductoLogic= new CuentasContablesLineaProductoLogic(connexion);
			cuentascontableslineaproducto.setid_linea_categoria(linea.getId());
			CuentasContablesLineaProductoDataAccess.save(cuentascontableslineaproducto,connexion);
			cuentascontableslineaproductoLogic.deepSave(cuentascontableslineaproducto,isDeep,deepLoadType,clases);
		}

		for(Precio precio:linea.getPrecioGrupos()) {
			PrecioLogic precioLogic= new PrecioLogic(connexion);
			precio.setid_linea_grupo(linea.getId());
			PrecioDataAccess.save(precio,connexion);
			precioLogic.deepSave(precio,isDeep,deepLoadType,clases);
		}

		for(LineaPuntoVenta lineapuntoventa:linea.getLineaPuntoVentaMarcas()) {
			LineaPuntoVentaLogic lineapuntoventaLogic= new LineaPuntoVentaLogic(connexion);
			lineapuntoventa.setid_linea_marca(linea.getId());
			LineaPuntoVentaDataAccess.save(lineapuntoventa,connexion);
			lineapuntoventaLogic.deepSave(lineapuntoventa,isDeep,deepLoadType,clases);
		}

		for(DetalleCodigoBarraProducto detallecodigobarraproducto:linea.getDetalleCodigoBarraProductoMarcas()) {
			DetalleCodigoBarraProductoLogic detallecodigobarraproductoLogic= new DetalleCodigoBarraProductoLogic(connexion);
			detallecodigobarraproducto.setid_linea_marca(linea.getId());
			DetalleCodigoBarraProductoDataAccess.save(detallecodigobarraproducto,connexion);
			detallecodigobarraproductoLogic.deepSave(detallecodigobarraproducto,isDeep,deepLoadType,clases);
		}

		for(PresupuestoVentasLineas presupuestoventaslineas:linea.getPresupuestoVentasLineasMarcas()) {
			PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(connexion);
			presupuestoventaslineas.setid_linea_marca(linea.getId());
			PresupuestoVentasLineasDataAccess.save(presupuestoventaslineas,connexion);
			presupuestoventaslineasLogic.deepSave(presupuestoventaslineas,isDeep,deepLoadType,clases);
		}

		for(CentroCostoGrupoProducto centrocostogrupoproducto:linea.getCentroCostoGrupoProductos()) {
			CentroCostoGrupoProductoLogic centrocostogrupoproductoLogic= new CentroCostoGrupoProductoLogic(connexion);
			centrocostogrupoproducto.setid_linea(linea.getId());
			CentroCostoGrupoProductoDataAccess.save(centrocostogrupoproducto,connexion);
			centrocostogrupoproductoLogic.deepSave(centrocostogrupoproducto,isDeep,deepLoadType,clases);
		}

		for(Producto producto:linea.getProductos()) {
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			producto.setid_linea(linea.getId());
			ProductoDataAccess.save(producto,connexion);
			productoLogic.deepSave(producto,isDeep,deepLoadType,clases);
		}

		for(ComisionMarca comisionmarca:linea.getComisionMarcaGrupos()) {
			ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(connexion);
			comisionmarca.setid_linea_grupo(linea.getId());
			ComisionMarcaDataAccess.save(comisionmarca,connexion);
			comisionmarcaLogic.deepSave(comisionmarca,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(linea.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(linea.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NivelLinea.class)) {
				NivelLineaDataAccess.save(linea.getNivelLinea(),connexion);
				NivelLineaLogic nivellineaLogic= new NivelLineaLogic(connexion);
				nivellineaLogic.deepSave(linea.getNivelLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(linea.getLinea(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(linea.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(PresupuestoLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresupuestoLinea presupuestolinea:linea.getPresupuestoLineas()) {
					PresupuestoLineaLogic presupuestolineaLogic= new PresupuestoLineaLogic(connexion);
					presupuestolinea.setid_linea(linea.getId());
					PresupuestoLineaDataAccess.save(presupuestolinea,connexion);
					presupuestolineaLogic.deepSave(presupuestolinea,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Linea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Linea lineaRecursivo:linea.getLineas()) {
					LineaLogic lineaRecursivoLogic= new LineaLogic(connexion);
					lineaRecursivo.setid_linea(linea.getId());
					LineaDataAccess.save(lineaRecursivo,connexion);
					lineaRecursivoLogic.deepSave(lineaRecursivo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionGrupo comisiongrupo:linea.getComisionGrupoGrupos()) {
					ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(connexion);
					comisiongrupo.setid_linea_grupo(linea.getId());
					ComisionGrupoDataAccess.save(comisiongrupo,connexion);
					comisiongrupoLogic.deepSave(comisiongrupo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoPuntoVenta productopuntoventa:linea.getProductoPuntoVentas()) {
					ProductoPuntoVentaLogic productopuntoventaLogic= new ProductoPuntoVentaLogic(connexion);
					productopuntoventa.setid_linea(linea.getId());
					ProductoPuntoVentaDataAccess.save(productopuntoventa,connexion);
					productopuntoventaLogic.deepSave(productopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionLinea comisionlinea:linea.getComisionLineas()) {
					ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(connexion);
					comisionlinea.setid_linea(linea.getId());
					ComisionLineaDataAccess.save(comisionlinea,connexion);
					comisionlineaLogic.deepSave(comisionlinea,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionCate comisioncate:linea.getComisionCates()) {
					ComisionCateLogic comisioncateLogic= new ComisionCateLogic(connexion);
					comisioncate.setid_linea(linea.getId());
					ComisionCateDataAccess.save(comisioncate,connexion);
					comisioncateLogic.deepSave(comisioncate,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetallePlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetallePlaneacionCompra detalleplaneacioncompra:linea.getDetallePlaneacionCompras()) {
					DetallePlaneacionCompraLogic detalleplaneacioncompraLogic= new DetallePlaneacionCompraLogic(connexion);
					detalleplaneacioncompra.setid_linea(linea.getId());
					DetallePlaneacionCompraDataAccess.save(detalleplaneacioncompra,connexion);
					detalleplaneacioncompraLogic.deepSave(detalleplaneacioncompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CuentasContablesLineaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentasContablesLineaProducto cuentascontableslineaproducto:linea.getCuentasContablesLineaProductoCategorias()) {
					CuentasContablesLineaProductoLogic cuentascontableslineaproductoLogic= new CuentasContablesLineaProductoLogic(connexion);
					cuentascontableslineaproducto.setid_linea_categoria(linea.getId());
					CuentasContablesLineaProductoDataAccess.save(cuentascontableslineaproducto,connexion);
					cuentascontableslineaproductoLogic.deepSave(cuentascontableslineaproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Precio precio:linea.getPrecioGrupos()) {
					PrecioLogic precioLogic= new PrecioLogic(connexion);
					precio.setid_linea_grupo(linea.getId());
					PrecioDataAccess.save(precio,connexion);
					precioLogic.deepSave(precio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(LineaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(LineaPuntoVenta lineapuntoventa:linea.getLineaPuntoVentaMarcas()) {
					LineaPuntoVentaLogic lineapuntoventaLogic= new LineaPuntoVentaLogic(connexion);
					lineapuntoventa.setid_linea_marca(linea.getId());
					LineaPuntoVentaDataAccess.save(lineapuntoventa,connexion);
					lineapuntoventaLogic.deepSave(lineapuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleCodigoBarraProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleCodigoBarraProducto detallecodigobarraproducto:linea.getDetalleCodigoBarraProductoMarcas()) {
					DetalleCodigoBarraProductoLogic detallecodigobarraproductoLogic= new DetalleCodigoBarraProductoLogic(connexion);
					detallecodigobarraproducto.setid_linea_marca(linea.getId());
					DetalleCodigoBarraProductoDataAccess.save(detallecodigobarraproducto,connexion);
					detallecodigobarraproductoLogic.deepSave(detallecodigobarraproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresupuestoVentasLineas presupuestoventaslineas:linea.getPresupuestoVentasLineasMarcas()) {
					PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(connexion);
					presupuestoventaslineas.setid_linea_marca(linea.getId());
					PresupuestoVentasLineasDataAccess.save(presupuestoventaslineas,connexion);
					presupuestoventaslineasLogic.deepSave(presupuestoventaslineas,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CentroCostoGrupoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CentroCostoGrupoProducto centrocostogrupoproducto:linea.getCentroCostoGrupoProductos()) {
					CentroCostoGrupoProductoLogic centrocostogrupoproductoLogic= new CentroCostoGrupoProductoLogic(connexion);
					centrocostogrupoproducto.setid_linea(linea.getId());
					CentroCostoGrupoProductoDataAccess.save(centrocostogrupoproducto,connexion);
					centrocostogrupoproductoLogic.deepSave(centrocostogrupoproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Producto producto:linea.getProductos()) {
					ProductoLogic productoLogic= new ProductoLogic(connexion);
					producto.setid_linea(linea.getId());
					ProductoDataAccess.save(producto,connexion);
					productoLogic.deepSave(producto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionMarca comisionmarca:linea.getComisionMarcaGrupos()) {
					ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(connexion);
					comisionmarca.setid_linea_grupo(linea.getId());
					ComisionMarcaDataAccess.save(comisionmarca,connexion);
					comisionmarcaLogic.deepSave(comisionmarca,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Linea.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(linea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(linea);
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
			this.deepLoad(this.linea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.linea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Linea.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(lineas!=null) {
				for(Linea linea:lineas) {
					this.deepLoad(linea,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(lineas);
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
			if(lineas!=null) {
				for(Linea linea:lineas) {
					this.deepLoad(linea,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(lineas);
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
			this.getNewConnexionToDeep(Linea.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(linea,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Linea.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(lineas!=null) {
				for(Linea linea:lineas) {
					this.deepSave(linea,isDeep,deepLoadType,clases);
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
			if(lineas!=null) {
				for(Linea linea:lineas) {
					this.deepSave(linea,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getLineasBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",LineaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineas=lineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineasBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",LineaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineas=lineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLineasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",LineaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineas=lineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",LineaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineas=lineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLineasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,LineaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineas=lineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,LineaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineas=lineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLineasFK_IdLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,LineaConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineas=lineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineasFK_IdLinea(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,LineaConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineas=lineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLineasFK_IdNivelLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_nivel_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Linea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNivelLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNivelLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_nivel_linea,LineaConstantesFunciones.IDNIVELLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNivelLinea);

			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNivelLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineas=lineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineasFK_IdNivelLinea(String sFinalQuery,Pagination pagination,Long id_nivel_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNivelLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNivelLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_nivel_linea,LineaConstantesFunciones.IDNIVELLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNivelLinea);

			LineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNivelLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineas=lineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(this.lineas);
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
			if(LineaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,LineaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Linea linea,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(LineaConstantesFunciones.ISCONAUDITORIA) {
				if(linea.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LineaDataAccess.TABLENAME, linea.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(LineaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////LineaLogic.registrarAuditoriaDetallesLinea(connexion,linea,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(linea.getIsDeleted()) {
					/*if(!linea.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,LineaDataAccess.TABLENAME, linea.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////LineaLogic.registrarAuditoriaDetallesLinea(connexion,linea,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LineaDataAccess.TABLENAME, linea.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(linea.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LineaDataAccess.TABLENAME, linea.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(LineaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////LineaLogic.registrarAuditoriaDetallesLinea(connexion,linea,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesLinea(Connexion connexion,Linea linea)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(linea.getIsNew()||!linea.getid_empresa().equals(linea.getLineaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(linea.getLineaOriginal().getid_empresa()!=null)
				{
					strValorActual=linea.getLineaOriginal().getid_empresa().toString();
				}
				if(linea.getid_empresa()!=null)
				{
					strValorNuevo=linea.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(linea.getIsNew()||!linea.getid_nivel_linea().equals(linea.getLineaOriginal().getid_nivel_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(linea.getLineaOriginal().getid_nivel_linea()!=null)
				{
					strValorActual=linea.getLineaOriginal().getid_nivel_linea().toString();
				}
				if(linea.getid_nivel_linea()!=null)
				{
					strValorNuevo=linea.getid_nivel_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaConstantesFunciones.IDNIVELLINEA,strValorActual,strValorNuevo);
			}	
			
			if(linea.getIsNew()||!linea.getid_linea().equals(linea.getLineaOriginal().getid_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(linea.getLineaOriginal().getid_linea()!=null)
				{
					strValorActual=linea.getLineaOriginal().getid_linea().toString();
				}
				if(linea.getid_linea()!=null)
				{
					strValorNuevo=linea.getid_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaConstantesFunciones.IDLINEA,strValorActual,strValorNuevo);
			}	
			
			if(linea.getIsNew()||!linea.getcodigo().equals(linea.getLineaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(linea.getLineaOriginal().getcodigo()!=null)
				{
					strValorActual=linea.getLineaOriginal().getcodigo();
				}
				if(linea.getcodigo()!=null)
				{
					strValorNuevo=linea.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(linea.getIsNew()||!linea.getnombre().equals(linea.getLineaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(linea.getLineaOriginal().getnombre()!=null)
				{
					strValorActual=linea.getLineaOriginal().getnombre();
				}
				if(linea.getnombre()!=null)
				{
					strValorNuevo=linea.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(linea.getIsNew()||!linea.getdescripcion().equals(linea.getLineaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(linea.getLineaOriginal().getdescripcion()!=null)
				{
					strValorActual=linea.getLineaOriginal().getdescripcion();
				}
				if(linea.getdescripcion()!=null)
				{
					strValorNuevo=linea.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveLineaRelacionesWithConnection(Linea linea,List<PresupuestoLinea> presupuestolineas,List<Linea> lineas,List<ComisionGrupo> comisiongrupoGrupos,List<ProductoPuntoVenta> productopuntoventas,List<ComisionLinea> comisionlineas,List<ComisionCate> comisioncates,List<DetallePlaneacionCompra> detalleplaneacioncompras,List<CuentasContablesLineaProducto> cuentascontableslineaproductoCategorias,List<Precio> precioGrupos,List<LineaPuntoVenta> lineapuntoventaMarcas,List<DetalleCodigoBarraProducto> detallecodigobarraproductoMarcas,List<PresupuestoVentasLineas> presupuestoventaslineasMarcas,List<CentroCostoGrupoProducto> centrocostogrupoproductos,List<Producto> productos,List<ComisionMarca> comisionmarcaGrupos) throws Exception {

		if(!linea.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveLineaRelacionesBase(linea,presupuestolineas,lineas,comisiongrupoGrupos,productopuntoventas,comisionlineas,comisioncates,detalleplaneacioncompras,cuentascontableslineaproductoCategorias,precioGrupos,lineapuntoventaMarcas,detallecodigobarraproductoMarcas,presupuestoventaslineasMarcas,centrocostogrupoproductos,productos,comisionmarcaGrupos,true);
		}
	}

	public void saveLineaRelaciones(Linea linea,List<PresupuestoLinea> presupuestolineas,List<Linea> lineas,List<ComisionGrupo> comisiongrupoGrupos,List<ProductoPuntoVenta> productopuntoventas,List<ComisionLinea> comisionlineas,List<ComisionCate> comisioncates,List<DetallePlaneacionCompra> detalleplaneacioncompras,List<CuentasContablesLineaProducto> cuentascontableslineaproductoCategorias,List<Precio> precioGrupos,List<LineaPuntoVenta> lineapuntoventaMarcas,List<DetalleCodigoBarraProducto> detallecodigobarraproductoMarcas,List<PresupuestoVentasLineas> presupuestoventaslineasMarcas,List<CentroCostoGrupoProducto> centrocostogrupoproductos,List<Producto> productos,List<ComisionMarca> comisionmarcaGrupos)throws Exception {

		if(!linea.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveLineaRelacionesBase(linea,presupuestolineas,lineas,comisiongrupoGrupos,productopuntoventas,comisionlineas,comisioncates,detalleplaneacioncompras,cuentascontableslineaproductoCategorias,precioGrupos,lineapuntoventaMarcas,detallecodigobarraproductoMarcas,presupuestoventaslineasMarcas,centrocostogrupoproductos,productos,comisionmarcaGrupos,false);
		}
	}

	public void saveLineaRelacionesBase(Linea linea,List<PresupuestoLinea> presupuestolineas,List<Linea> lineas,List<ComisionGrupo> comisiongrupoGrupos,List<ProductoPuntoVenta> productopuntoventas,List<ComisionLinea> comisionlineas,List<ComisionCate> comisioncates,List<DetallePlaneacionCompra> detalleplaneacioncompras,List<CuentasContablesLineaProducto> cuentascontableslineaproductoCategorias,List<Precio> precioGrupos,List<LineaPuntoVenta> lineapuntoventaMarcas,List<DetalleCodigoBarraProducto> detallecodigobarraproductoMarcas,List<PresupuestoVentasLineas> presupuestoventaslineasMarcas,List<CentroCostoGrupoProducto> centrocostogrupoproductos,List<Producto> productos,List<ComisionMarca> comisionmarcaGrupos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Linea-saveRelacionesWithConnection");}
	
			linea.setPresupuestoLineas(presupuestolineas);
			linea.setLineas(lineas);
			linea.setComisionGrupoGrupos(comisiongrupoGrupos);
			linea.setProductoPuntoVentas(productopuntoventas);
			linea.setComisionLineas(comisionlineas);
			linea.setComisionCates(comisioncates);
			linea.setDetallePlaneacionCompras(detalleplaneacioncompras);
			linea.setCuentasContablesLineaProductoCategorias(cuentascontableslineaproductoCategorias);
			linea.setPrecioGrupos(precioGrupos);
			linea.setLineaPuntoVentaMarcas(lineapuntoventaMarcas);
			linea.setDetalleCodigoBarraProductoMarcas(detallecodigobarraproductoMarcas);
			linea.setPresupuestoVentasLineasMarcas(presupuestoventaslineasMarcas);
			linea.setCentroCostoGrupoProductos(centrocostogrupoproductos);
			linea.setProductos(productos);
			linea.setComisionMarcaGrupos(comisionmarcaGrupos);

			this.setLinea(linea);

			if(LineaLogicAdditional.validarSaveRelaciones(linea,this)) {

				LineaLogicAdditional.updateRelacionesToSave(linea,this);

				if((linea.getIsNew()||linea.getIsChanged())&&!linea.getIsDeleted()) {
					this.saveLinea();
					this.saveLineaRelacionesDetalles(presupuestolineas,lineas,comisiongrupoGrupos,productopuntoventas,comisionlineas,comisioncates,detalleplaneacioncompras,cuentascontableslineaproductoCategorias,precioGrupos,lineapuntoventaMarcas,detallecodigobarraproductoMarcas,presupuestoventaslineasMarcas,centrocostogrupoproductos,productos,comisionmarcaGrupos);

				} else if(linea.getIsDeleted()) {
					this.saveLineaRelacionesDetalles(presupuestolineas,lineas,comisiongrupoGrupos,productopuntoventas,comisionlineas,comisioncates,detalleplaneacioncompras,cuentascontableslineaproductoCategorias,precioGrupos,lineapuntoventaMarcas,detallecodigobarraproductoMarcas,presupuestoventaslineasMarcas,centrocostogrupoproductos,productos,comisionmarcaGrupos);
					this.saveLinea();
				}

				LineaLogicAdditional.updateRelacionesToSaveAfter(linea,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PresupuestoLineaConstantesFunciones.InicializarGeneralEntityAuxiliaresPresupuestoLineas(presupuestolineas,true,true);
			LineaConstantesFunciones.InicializarGeneralEntityAuxiliaresLineas(lineas,true,true);
			ComisionGrupoConstantesFunciones.InicializarGeneralEntityAuxiliaresComisionGrupos(comisiongrupoGrupos,true,true);
			ProductoPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoPuntoVentas(productopuntoventas,true,true);
			ComisionLineaConstantesFunciones.InicializarGeneralEntityAuxiliaresComisionLineas(comisionlineas,true,true);
			ComisionCateConstantesFunciones.InicializarGeneralEntityAuxiliaresComisionCates(comisioncates,true,true);
			DetallePlaneacionCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresDetallePlaneacionCompras(detalleplaneacioncompras,true,true);
			CuentasContablesLineaProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresCuentasContablesLineaProductos(cuentascontableslineaproductoCategorias,true,true);
			PrecioConstantesFunciones.InicializarGeneralEntityAuxiliaresPrecios(precioGrupos,true,true);
			LineaPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresLineaPuntoVentas(lineapuntoventaMarcas,true,true);
			DetalleCodigoBarraProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleCodigoBarraProductos(detallecodigobarraproductoMarcas,true,true);
			PresupuestoVentasLineasConstantesFunciones.InicializarGeneralEntityAuxiliaresPresupuestoVentasLineass(presupuestoventaslineasMarcas,true,true);
			CentroCostoGrupoProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresCentroCostoGrupoProductos(centrocostogrupoproductos,true,true);
			ProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresProductos(productos,true,true);
			ComisionMarcaConstantesFunciones.InicializarGeneralEntityAuxiliaresComisionMarcas(comisionmarcaGrupos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveLineaRelacionesDetalles(List<PresupuestoLinea> presupuestolineas,List<Linea> lineas,List<ComisionGrupo> comisiongrupoGrupos,List<ProductoPuntoVenta> productopuntoventas,List<ComisionLinea> comisionlineas,List<ComisionCate> comisioncates,List<DetallePlaneacionCompra> detalleplaneacioncompras,List<CuentasContablesLineaProducto> cuentascontableslineaproductoCategorias,List<Precio> precioGrupos,List<LineaPuntoVenta> lineapuntoventaMarcas,List<DetalleCodigoBarraProducto> detallecodigobarraproductoMarcas,List<PresupuestoVentasLineas> presupuestoventaslineasMarcas,List<CentroCostoGrupoProducto> centrocostogrupoproductos,List<Producto> productos,List<ComisionMarca> comisionmarcaGrupos)throws Exception {
		try {
	

			Long idLineaActual=this.getLinea().getId();

			PresupuestoLineaLogic presupuestolineaLogic_Desde_Linea=new PresupuestoLineaLogic();
			presupuestolineaLogic_Desde_Linea.setPresupuestoLineas(presupuestolineas);

			presupuestolineaLogic_Desde_Linea.setConnexion(this.getConnexion());
			presupuestolineaLogic_Desde_Linea.setDatosCliente(this.datosCliente);

			for(PresupuestoLinea presupuestolinea_Desde_Linea:presupuestolineaLogic_Desde_Linea.getPresupuestoLineas()) {
				presupuestolinea_Desde_Linea.setid_linea(idLineaActual);
			}

			presupuestolineaLogic_Desde_Linea.savePresupuestoLineas();

			LineaLogic lineaLogicHijos_Desde_Linea=new LineaLogic();
			lineaLogicHijos_Desde_Linea.setLineas(lineas);

			lineaLogicHijos_Desde_Linea.setConnexion(this.getConnexion());
			lineaLogicHijos_Desde_Linea.setDatosCliente(this.datosCliente);

			for(Linea lineaHijos_Desde_Linea:lineaLogicHijos_Desde_Linea.getLineas()) {
				lineaHijos_Desde_Linea.setid_linea(idLineaActual);

				lineaLogicHijos_Desde_Linea.setLinea(lineaHijos_Desde_Linea);
				lineaLogicHijos_Desde_Linea.saveLinea();
			}


			ComisionGrupoLogic comisiongrupoGrupoLogic_Desde_Linea=new ComisionGrupoLogic();
			comisiongrupoGrupoLogic_Desde_Linea.setComisionGrupos(comisiongrupoGrupos);

			comisiongrupoGrupoLogic_Desde_Linea.setConnexion(this.getConnexion());
			comisiongrupoGrupoLogic_Desde_Linea.setDatosCliente(this.datosCliente);

			for(ComisionGrupo comisiongrupo_Desde_Linea:comisiongrupoGrupoLogic_Desde_Linea.getComisionGrupos()) {
				comisiongrupo_Desde_Linea.setid_linea_grupo(idLineaActual);
			}

			comisiongrupoGrupoLogic_Desde_Linea.saveComisionGrupos();

			ProductoPuntoVentaLogic productopuntoventaLogic_Desde_Linea=new ProductoPuntoVentaLogic();
			productopuntoventaLogic_Desde_Linea.setProductoPuntoVentas(productopuntoventas);

			productopuntoventaLogic_Desde_Linea.setConnexion(this.getConnexion());
			productopuntoventaLogic_Desde_Linea.setDatosCliente(this.datosCliente);

			for(ProductoPuntoVenta productopuntoventa_Desde_Linea:productopuntoventaLogic_Desde_Linea.getProductoPuntoVentas()) {
				productopuntoventa_Desde_Linea.setid_linea(idLineaActual);
			}

			productopuntoventaLogic_Desde_Linea.saveProductoPuntoVentas();

			ComisionLineaLogic comisionlineaLogic_Desde_Linea=new ComisionLineaLogic();
			comisionlineaLogic_Desde_Linea.setComisionLineas(comisionlineas);

			comisionlineaLogic_Desde_Linea.setConnexion(this.getConnexion());
			comisionlineaLogic_Desde_Linea.setDatosCliente(this.datosCliente);

			for(ComisionLinea comisionlinea_Desde_Linea:comisionlineaLogic_Desde_Linea.getComisionLineas()) {
				comisionlinea_Desde_Linea.setid_linea(idLineaActual);
			}

			comisionlineaLogic_Desde_Linea.saveComisionLineas();

			ComisionCateLogic comisioncateLogic_Desde_Linea=new ComisionCateLogic();
			comisioncateLogic_Desde_Linea.setComisionCates(comisioncates);

			comisioncateLogic_Desde_Linea.setConnexion(this.getConnexion());
			comisioncateLogic_Desde_Linea.setDatosCliente(this.datosCliente);

			for(ComisionCate comisioncate_Desde_Linea:comisioncateLogic_Desde_Linea.getComisionCates()) {
				comisioncate_Desde_Linea.setid_linea(idLineaActual);
			}

			comisioncateLogic_Desde_Linea.saveComisionCates();

			DetallePlaneacionCompraLogic detalleplaneacioncompraLogic_Desde_Linea=new DetallePlaneacionCompraLogic();
			detalleplaneacioncompraLogic_Desde_Linea.setDetallePlaneacionCompras(detalleplaneacioncompras);

			detalleplaneacioncompraLogic_Desde_Linea.setConnexion(this.getConnexion());
			detalleplaneacioncompraLogic_Desde_Linea.setDatosCliente(this.datosCliente);

			for(DetallePlaneacionCompra detalleplaneacioncompra_Desde_Linea:detalleplaneacioncompraLogic_Desde_Linea.getDetallePlaneacionCompras()) {
				detalleplaneacioncompra_Desde_Linea.setid_linea(idLineaActual);
			}

			detalleplaneacioncompraLogic_Desde_Linea.saveDetallePlaneacionCompras();

			CuentasContablesLineaProductoLogic cuentascontableslineaproductoCategoriaLogic_Desde_Linea=new CuentasContablesLineaProductoLogic();
			cuentascontableslineaproductoCategoriaLogic_Desde_Linea.setCuentasContablesLineaProductos(cuentascontableslineaproductoCategorias);

			cuentascontableslineaproductoCategoriaLogic_Desde_Linea.setConnexion(this.getConnexion());
			cuentascontableslineaproductoCategoriaLogic_Desde_Linea.setDatosCliente(this.datosCliente);

			for(CuentasContablesLineaProducto cuentascontableslineaproducto_Desde_Linea:cuentascontableslineaproductoCategoriaLogic_Desde_Linea.getCuentasContablesLineaProductos()) {
				cuentascontableslineaproducto_Desde_Linea.setid_linea_categoria(idLineaActual);
			}

			cuentascontableslineaproductoCategoriaLogic_Desde_Linea.saveCuentasContablesLineaProductos();

			PrecioLogic precioGrupoLogic_Desde_Linea=new PrecioLogic();
			precioGrupoLogic_Desde_Linea.setPrecios(precioGrupos);

			precioGrupoLogic_Desde_Linea.setConnexion(this.getConnexion());
			precioGrupoLogic_Desde_Linea.setDatosCliente(this.datosCliente);

			for(Precio precio_Desde_Linea:precioGrupoLogic_Desde_Linea.getPrecios()) {
				precio_Desde_Linea.setid_linea_grupo(idLineaActual);
			}

			precioGrupoLogic_Desde_Linea.savePrecios();

			LineaPuntoVentaLogic lineapuntoventaMarcaLogic_Desde_Linea=new LineaPuntoVentaLogic();
			lineapuntoventaMarcaLogic_Desde_Linea.setLineaPuntoVentas(lineapuntoventaMarcas);

			lineapuntoventaMarcaLogic_Desde_Linea.setConnexion(this.getConnexion());
			lineapuntoventaMarcaLogic_Desde_Linea.setDatosCliente(this.datosCliente);

			for(LineaPuntoVenta lineapuntoventa_Desde_Linea:lineapuntoventaMarcaLogic_Desde_Linea.getLineaPuntoVentas()) {
				lineapuntoventa_Desde_Linea.setid_linea_marca(idLineaActual);
			}

			lineapuntoventaMarcaLogic_Desde_Linea.saveLineaPuntoVentas();

			DetalleCodigoBarraProductoLogic detallecodigobarraproductoMarcaLogic_Desde_Linea=new DetalleCodigoBarraProductoLogic();
			detallecodigobarraproductoMarcaLogic_Desde_Linea.setDetalleCodigoBarraProductos(detallecodigobarraproductoMarcas);

			detallecodigobarraproductoMarcaLogic_Desde_Linea.setConnexion(this.getConnexion());
			detallecodigobarraproductoMarcaLogic_Desde_Linea.setDatosCliente(this.datosCliente);

			for(DetalleCodigoBarraProducto detallecodigobarraproducto_Desde_Linea:detallecodigobarraproductoMarcaLogic_Desde_Linea.getDetalleCodigoBarraProductos()) {
				detallecodigobarraproducto_Desde_Linea.setid_linea_marca(idLineaActual);
			}

			detallecodigobarraproductoMarcaLogic_Desde_Linea.saveDetalleCodigoBarraProductos();

			PresupuestoVentasLineasLogic presupuestoventaslineasMarcaLogic_Desde_Linea=new PresupuestoVentasLineasLogic();
			presupuestoventaslineasMarcaLogic_Desde_Linea.setPresupuestoVentasLineass(presupuestoventaslineasMarcas);

			presupuestoventaslineasMarcaLogic_Desde_Linea.setConnexion(this.getConnexion());
			presupuestoventaslineasMarcaLogic_Desde_Linea.setDatosCliente(this.datosCliente);

			for(PresupuestoVentasLineas presupuestoventaslineas_Desde_Linea:presupuestoventaslineasMarcaLogic_Desde_Linea.getPresupuestoVentasLineass()) {
				presupuestoventaslineas_Desde_Linea.setid_linea_marca(idLineaActual);
			}

			presupuestoventaslineasMarcaLogic_Desde_Linea.savePresupuestoVentasLineass();

			CentroCostoGrupoProductoLogic centrocostogrupoproductoLogic_Desde_Linea=new CentroCostoGrupoProductoLogic();
			centrocostogrupoproductoLogic_Desde_Linea.setCentroCostoGrupoProductos(centrocostogrupoproductos);

			centrocostogrupoproductoLogic_Desde_Linea.setConnexion(this.getConnexion());
			centrocostogrupoproductoLogic_Desde_Linea.setDatosCliente(this.datosCliente);

			for(CentroCostoGrupoProducto centrocostogrupoproducto_Desde_Linea:centrocostogrupoproductoLogic_Desde_Linea.getCentroCostoGrupoProductos()) {
				centrocostogrupoproducto_Desde_Linea.setid_linea(idLineaActual);
			}

			centrocostogrupoproductoLogic_Desde_Linea.saveCentroCostoGrupoProductos();

			ProductoLogic productoLogic_Desde_Linea=new ProductoLogic();
			productoLogic_Desde_Linea.setProductos(productos);

			productoLogic_Desde_Linea.setConnexion(this.getConnexion());
			productoLogic_Desde_Linea.setDatosCliente(this.datosCliente);

			for(Producto producto_Desde_Linea:productoLogic_Desde_Linea.getProductos()) {
				producto_Desde_Linea.setid_linea(idLineaActual);

				productoLogic_Desde_Linea.setProducto(producto_Desde_Linea);
				productoLogic_Desde_Linea.saveProducto();
			}


			ComisionMarcaLogic comisionmarcaGrupoLogic_Desde_Linea=new ComisionMarcaLogic();
			comisionmarcaGrupoLogic_Desde_Linea.setComisionMarcas(comisionmarcaGrupos);

			comisionmarcaGrupoLogic_Desde_Linea.setConnexion(this.getConnexion());
			comisionmarcaGrupoLogic_Desde_Linea.setDatosCliente(this.datosCliente);

			for(ComisionMarca comisionmarca_Desde_Linea:comisionmarcaGrupoLogic_Desde_Linea.getComisionMarcas()) {
				comisionmarca_Desde_Linea.setid_linea_grupo(idLineaActual);
			}

			comisionmarcaGrupoLogic_Desde_Linea.saveComisionMarcas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=LineaConstantesFunciones.getClassesForeignKeysOfLinea(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=LineaConstantesFunciones.getClassesRelationshipsOfLinea(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.inventario.util.DescuentoMontoConstantesFunciones;
import com.bydan.erp.inventario.util.DescuentoMontoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DescuentoMontoParameterGeneral;
import com.bydan.erp.inventario.business.entity.DescuentoMonto;
import com.bydan.erp.inventario.business.logic.DescuentoMontoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DescuentoMontoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DescuentoMontoLogic.class);
	
	protected DescuentoMontoDataAccess descuentomontoDataAccess; 	
	protected DescuentoMonto descuentomonto;
	protected List<DescuentoMonto> descuentomontos;
	protected Object descuentomontoObject;	
	protected List<Object> descuentomontosObject;
	
	public static ClassValidator<DescuentoMonto> descuentomontoValidator = new ClassValidator<DescuentoMonto>(DescuentoMonto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DescuentoMontoLogicAdditional descuentomontoLogicAdditional=null;
	
	public DescuentoMontoLogicAdditional getDescuentoMontoLogicAdditional() {
		return this.descuentomontoLogicAdditional;
	}
	
	public void setDescuentoMontoLogicAdditional(DescuentoMontoLogicAdditional descuentomontoLogicAdditional) {
		try {
			this.descuentomontoLogicAdditional=descuentomontoLogicAdditional;
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
	
	
	
	
	public  DescuentoMontoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.descuentomontoDataAccess = new DescuentoMontoDataAccess();
			
			this.descuentomontos= new ArrayList<DescuentoMonto>();
			this.descuentomonto= new DescuentoMonto();
			
			this.descuentomontoObject=new Object();
			this.descuentomontosObject=new ArrayList<Object>();
				
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
			
			this.descuentomontoDataAccess.setConnexionType(this.connexionType);
			this.descuentomontoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DescuentoMontoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.descuentomontoDataAccess = new DescuentoMontoDataAccess();
			this.descuentomontos= new ArrayList<DescuentoMonto>();
			this.descuentomonto= new DescuentoMonto();
			this.descuentomontoObject=new Object();
			this.descuentomontosObject=new ArrayList<Object>();
			
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
			
			this.descuentomontoDataAccess.setConnexionType(this.connexionType);
			this.descuentomontoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DescuentoMonto getDescuentoMonto() throws Exception {	
		DescuentoMontoLogicAdditional.checkDescuentoMontoToGet(descuentomonto,this.datosCliente,this.arrDatoGeneral);
		DescuentoMontoLogicAdditional.updateDescuentoMontoToGet(descuentomonto,this.arrDatoGeneral);
		
		return descuentomonto;
	}
		
	public void setDescuentoMonto(DescuentoMonto newDescuentoMonto) {
		this.descuentomonto = newDescuentoMonto;
	}
	
	public DescuentoMontoDataAccess getDescuentoMontoDataAccess() {
		return descuentomontoDataAccess;
	}
	
	public void setDescuentoMontoDataAccess(DescuentoMontoDataAccess newdescuentomontoDataAccess) {
		this.descuentomontoDataAccess = newdescuentomontoDataAccess;
	}
	
	public List<DescuentoMonto> getDescuentoMontos() throws Exception {		
		this.quitarDescuentoMontosNulos();
		
		DescuentoMontoLogicAdditional.checkDescuentoMontoToGets(descuentomontos,this.datosCliente,this.arrDatoGeneral);
		
		for (DescuentoMonto descuentomontoLocal: descuentomontos ) {
			DescuentoMontoLogicAdditional.updateDescuentoMontoToGet(descuentomontoLocal,this.arrDatoGeneral);
		}
		
		return descuentomontos;
	}
	
	public void setDescuentoMontos(List<DescuentoMonto> newDescuentoMontos) {
		this.descuentomontos = newDescuentoMontos;
	}
	
	public Object getDescuentoMontoObject() {	
		this.descuentomontoObject=this.descuentomontoDataAccess.getEntityObject();
		return this.descuentomontoObject;
	}
		
	public void setDescuentoMontoObject(Object newDescuentoMontoObject) {
		this.descuentomontoObject = newDescuentoMontoObject;
	}
	
	public List<Object> getDescuentoMontosObject() {		
		this.descuentomontosObject=this.descuentomontoDataAccess.getEntitiesObject();
		return this.descuentomontosObject;
	}
		
	public void setDescuentoMontosObject(List<Object> newDescuentoMontosObject) {
		this.descuentomontosObject = newDescuentoMontosObject;
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
		
		if(this.descuentomontoDataAccess!=null) {
			this.descuentomontoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			descuentomontoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			descuentomontoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		descuentomonto = new  DescuentoMonto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			descuentomonto=descuentomontoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.descuentomonto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomonto);
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
		descuentomonto = new  DescuentoMonto();
		  		  
        try {
			
			descuentomonto=descuentomontoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.descuentomonto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomonto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		descuentomonto = new  DescuentoMonto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			descuentomonto=descuentomontoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.descuentomonto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomonto);
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
		descuentomonto = new  DescuentoMonto();
		  		  
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
		descuentomonto = new  DescuentoMonto();
		  		  
        try {
			
			descuentomonto=descuentomontoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.descuentomonto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomonto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		descuentomonto = new  DescuentoMonto();
		  		  
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
		descuentomonto = new  DescuentoMonto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =descuentomontoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		descuentomonto = new  DescuentoMonto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=descuentomontoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		descuentomonto = new  DescuentoMonto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =descuentomontoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		descuentomonto = new  DescuentoMonto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=descuentomontoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		descuentomonto = new  DescuentoMonto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =descuentomontoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		descuentomonto = new  DescuentoMonto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=descuentomontoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		descuentomontos = new  ArrayList<DescuentoMonto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentomontos=descuentomontoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDescuentoMonto(descuentomontos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
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
		descuentomontos = new  ArrayList<DescuentoMonto>();
		  		  
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
		descuentomontos = new  ArrayList<DescuentoMonto>();
		  		  
        try {			
			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentomontos=descuentomontoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDescuentoMonto(descuentomontos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		descuentomontos = new  ArrayList<DescuentoMonto>();
		  		  
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
		descuentomontos = new  ArrayList<DescuentoMonto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentomontos=descuentomontoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDescuentoMonto(descuentomontos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
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
		descuentomontos = new  ArrayList<DescuentoMonto>();
		  		  
        try {
			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentomontos=descuentomontoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDescuentoMonto(descuentomontos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
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
		descuentomontos = new  ArrayList<DescuentoMonto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentomontos=descuentomontoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDescuentoMonto(descuentomontos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
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
		descuentomontos = new  ArrayList<DescuentoMonto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentomontos=descuentomontoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDescuentoMonto(descuentomontos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		descuentomonto = new  DescuentoMonto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentomonto=descuentomontoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDescuentoMonto(descuentomonto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomonto);
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
		descuentomonto = new  DescuentoMonto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentomonto=descuentomontoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDescuentoMonto(descuentomonto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomonto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		descuentomontos = new  ArrayList<DescuentoMonto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentomontos=descuentomontoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDescuentoMonto(descuentomontos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
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
		descuentomontos = new  ArrayList<DescuentoMonto>();
		  		  
        try {
			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentomontos=descuentomontoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDescuentoMonto(descuentomontos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDescuentoMontosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		descuentomontos = new  ArrayList<DescuentoMonto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-getTodosDescuentoMontosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentomontos=descuentomontoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDescuentoMonto(descuentomontos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
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
	
	public  void  getTodosDescuentoMontos(String sFinalQuery,Pagination pagination)throws Exception {
		descuentomontos = new  ArrayList<DescuentoMonto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentomontos=descuentomontoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDescuentoMonto(descuentomontos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDescuentoMonto(DescuentoMonto descuentomonto) throws Exception {
		Boolean estaValidado=false;
		
		if(descuentomonto.getIsNew() || descuentomonto.getIsChanged()) { 
			this.invalidValues = descuentomontoValidator.getInvalidValues(descuentomonto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(descuentomonto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDescuentoMonto(List<DescuentoMonto> DescuentoMontos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DescuentoMonto descuentomontoLocal:descuentomontos) {				
			estaValidadoObjeto=this.validarGuardarDescuentoMonto(descuentomontoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDescuentoMonto(List<DescuentoMonto> DescuentoMontos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDescuentoMonto(descuentomontos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDescuentoMonto(DescuentoMonto DescuentoMonto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDescuentoMonto(descuentomonto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DescuentoMonto descuentomonto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+descuentomonto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DescuentoMontoConstantesFunciones.getDescuentoMontoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"descuentomonto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DescuentoMontoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DescuentoMontoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDescuentoMontoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-saveDescuentoMontoWithConnection");connexion.begin();			
			
			DescuentoMontoLogicAdditional.checkDescuentoMontoToSave(this.descuentomonto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DescuentoMontoLogicAdditional.updateDescuentoMontoToSave(this.descuentomonto,this.arrDatoGeneral);
			
			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.descuentomonto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDescuentoMonto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDescuentoMonto(this.descuentomonto)) {
				DescuentoMontoDataAccess.save(this.descuentomonto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.descuentomonto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DescuentoMontoLogicAdditional.checkDescuentoMontoToSaveAfter(this.descuentomonto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDescuentoMonto();
			
			connexion.commit();			
			
			if(this.descuentomonto.getIsDeleted()) {
				this.descuentomonto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDescuentoMonto()throws Exception {	
		try {	
			
			DescuentoMontoLogicAdditional.checkDescuentoMontoToSave(this.descuentomonto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DescuentoMontoLogicAdditional.updateDescuentoMontoToSave(this.descuentomonto,this.arrDatoGeneral);
			
			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.descuentomonto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDescuentoMonto(this.descuentomonto)) {			
				DescuentoMontoDataAccess.save(this.descuentomonto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.descuentomonto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DescuentoMontoLogicAdditional.checkDescuentoMontoToSaveAfter(this.descuentomonto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.descuentomonto.getIsDeleted()) {
				this.descuentomonto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDescuentoMontosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-saveDescuentoMontosWithConnection");connexion.begin();			
			
			DescuentoMontoLogicAdditional.checkDescuentoMontoToSaves(descuentomontos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDescuentoMontos();
			
			Boolean validadoTodosDescuentoMonto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DescuentoMonto descuentomontoLocal:descuentomontos) {		
				if(descuentomontoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DescuentoMontoLogicAdditional.updateDescuentoMontoToSave(descuentomontoLocal,this.arrDatoGeneral);
	        	
				DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),descuentomontoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDescuentoMonto(descuentomontoLocal)) {
					DescuentoMontoDataAccess.save(descuentomontoLocal, connexion);				
				} else {
					validadoTodosDescuentoMonto=false;
				}
			}
			
			if(!validadoTodosDescuentoMonto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DescuentoMontoLogicAdditional.checkDescuentoMontoToSavesAfter(descuentomontos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDescuentoMontos();
			
			connexion.commit();		
			
			this.quitarDescuentoMontosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDescuentoMontos()throws Exception {				
		 try {	
			DescuentoMontoLogicAdditional.checkDescuentoMontoToSaves(descuentomontos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDescuentoMonto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DescuentoMonto descuentomontoLocal:descuentomontos) {				
				if(descuentomontoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DescuentoMontoLogicAdditional.updateDescuentoMontoToSave(descuentomontoLocal,this.arrDatoGeneral);
	        	
				DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),descuentomontoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDescuentoMonto(descuentomontoLocal)) {				
					DescuentoMontoDataAccess.save(descuentomontoLocal, connexion);				
				} else {
					validadoTodosDescuentoMonto=false;
				}
			}
			
			if(!validadoTodosDescuentoMonto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DescuentoMontoLogicAdditional.checkDescuentoMontoToSavesAfter(descuentomontos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDescuentoMontosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DescuentoMontoParameterReturnGeneral procesarAccionDescuentoMontos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DescuentoMonto> descuentomontos,DescuentoMontoParameterReturnGeneral descuentomontoParameterGeneral)throws Exception {
		 try {	
			DescuentoMontoParameterReturnGeneral descuentomontoReturnGeneral=new DescuentoMontoParameterReturnGeneral();
	
			DescuentoMontoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,descuentomontos,descuentomontoParameterGeneral,descuentomontoReturnGeneral);
			
			return descuentomontoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DescuentoMontoParameterReturnGeneral procesarAccionDescuentoMontosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DescuentoMonto> descuentomontos,DescuentoMontoParameterReturnGeneral descuentomontoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-procesarAccionDescuentoMontosWithConnection");connexion.begin();			
			
			DescuentoMontoParameterReturnGeneral descuentomontoReturnGeneral=new DescuentoMontoParameterReturnGeneral();
	
			DescuentoMontoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,descuentomontos,descuentomontoParameterGeneral,descuentomontoReturnGeneral);
			
			this.connexion.commit();
			
			return descuentomontoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DescuentoMontoParameterReturnGeneral procesarEventosDescuentoMontos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DescuentoMonto> descuentomontos,DescuentoMonto descuentomonto,DescuentoMontoParameterReturnGeneral descuentomontoParameterGeneral,Boolean isEsNuevoDescuentoMonto,ArrayList<Classe> clases)throws Exception {
		 try {	
			DescuentoMontoParameterReturnGeneral descuentomontoReturnGeneral=new DescuentoMontoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				descuentomontoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DescuentoMontoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,descuentomontos,descuentomonto,descuentomontoParameterGeneral,descuentomontoReturnGeneral,isEsNuevoDescuentoMonto,clases);
			
			return descuentomontoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DescuentoMontoParameterReturnGeneral procesarEventosDescuentoMontosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DescuentoMonto> descuentomontos,DescuentoMonto descuentomonto,DescuentoMontoParameterReturnGeneral descuentomontoParameterGeneral,Boolean isEsNuevoDescuentoMonto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-procesarEventosDescuentoMontosWithConnection");connexion.begin();			
			
			DescuentoMontoParameterReturnGeneral descuentomontoReturnGeneral=new DescuentoMontoParameterReturnGeneral();
	
			descuentomontoReturnGeneral.setDescuentoMonto(descuentomonto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				descuentomontoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DescuentoMontoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,descuentomontos,descuentomonto,descuentomontoParameterGeneral,descuentomontoReturnGeneral,isEsNuevoDescuentoMonto,clases);
			
			this.connexion.commit();
			
			return descuentomontoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DescuentoMontoParameterReturnGeneral procesarImportacionDescuentoMontosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DescuentoMontoParameterReturnGeneral descuentomontoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-procesarImportacionDescuentoMontosWithConnection");connexion.begin();			
			
			DescuentoMontoParameterReturnGeneral descuentomontoReturnGeneral=new DescuentoMontoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.descuentomontos=new ArrayList<DescuentoMonto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.descuentomonto=new DescuentoMonto();
				
				
				if(conColumnasBase) {this.descuentomonto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.descuentomonto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.descuentomonto.setdescripcion(arrColumnas[iColumn++]);
				this.descuentomonto.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.descuentomonto.setvalor_inicio(Double.parseDouble(arrColumnas[iColumn++]));
				this.descuentomonto.setvalor_fin(Double.parseDouble(arrColumnas[iColumn++]));
				this.descuentomonto.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.descuentomontos.add(this.descuentomonto);
			}
			
			this.saveDescuentoMontos();
			
			this.connexion.commit();
			
			descuentomontoReturnGeneral.setConRetornoEstaProcesado(true);
			descuentomontoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return descuentomontoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDescuentoMontosEliminados() throws Exception {				
		
		List<DescuentoMonto> descuentomontosAux= new ArrayList<DescuentoMonto>();
		
		for(DescuentoMonto descuentomonto:descuentomontos) {
			if(!descuentomonto.getIsDeleted()) {
				descuentomontosAux.add(descuentomonto);
			}
		}
		
		descuentomontos=descuentomontosAux;
	}
	
	public void quitarDescuentoMontosNulos() throws Exception {				
		
		List<DescuentoMonto> descuentomontosAux= new ArrayList<DescuentoMonto>();
		
		for(DescuentoMonto descuentomonto : this.descuentomontos) {
			if(descuentomonto==null) {
				descuentomontosAux.add(descuentomonto);
			}
		}
		
		//this.descuentomontos=descuentomontosAux;
		
		this.descuentomontos.removeAll(descuentomontosAux);
	}
	
	public void getSetVersionRowDescuentoMontoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(descuentomonto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((descuentomonto.getIsDeleted() || (descuentomonto.getIsChanged()&&!descuentomonto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=descuentomontoDataAccess.getSetVersionRowDescuentoMonto(connexion,descuentomonto.getId());
				
				if(!descuentomonto.getVersionRow().equals(timestamp)) {	
					descuentomonto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				descuentomonto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDescuentoMonto()throws Exception {	
		
		if(descuentomonto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((descuentomonto.getIsDeleted() || (descuentomonto.getIsChanged()&&!descuentomonto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=descuentomontoDataAccess.getSetVersionRowDescuentoMonto(connexion,descuentomonto.getId());
			
			try {							
				if(!descuentomonto.getVersionRow().equals(timestamp)) {	
					descuentomonto.setVersionRow(timestamp);
				}
				
				descuentomonto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDescuentoMontosWithConnection()throws Exception {	
		if(descuentomontos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DescuentoMonto descuentomontoAux:descuentomontos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(descuentomontoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(descuentomontoAux.getIsDeleted() || (descuentomontoAux.getIsChanged()&&!descuentomontoAux.getIsNew())) {
						
						timestamp=descuentomontoDataAccess.getSetVersionRowDescuentoMonto(connexion,descuentomontoAux.getId());
						
						if(!descuentomonto.getVersionRow().equals(timestamp)) {	
							descuentomontoAux.setVersionRow(timestamp);
						}
								
						descuentomontoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDescuentoMontos()throws Exception {	
		if(descuentomontos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DescuentoMonto descuentomontoAux:descuentomontos) {
					if(descuentomontoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(descuentomontoAux.getIsDeleted() || (descuentomontoAux.getIsChanged()&&!descuentomontoAux.getIsNew())) {
						
						timestamp=descuentomontoDataAccess.getSetVersionRowDescuentoMonto(connexion,descuentomontoAux.getId());
						
						if(!descuentomontoAux.getVersionRow().equals(timestamp)) {	
							descuentomontoAux.setVersionRow(timestamp);
						}
						
													
						descuentomontoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DescuentoMontoParameterReturnGeneral cargarCombosLoteForeignKeyDescuentoMontoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalBodega) throws Exception {
		DescuentoMontoParameterReturnGeneral  descuentomontoReturnGeneral =new DescuentoMontoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-cargarCombosLoteForeignKeyDescuentoMontoWithConnection");connexion.begin();
			
			descuentomontoReturnGeneral =new DescuentoMontoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			descuentomontoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			descuentomontoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			descuentomontoReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			descuentomontoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return descuentomontoReturnGeneral;
	}
	
	public DescuentoMontoParameterReturnGeneral cargarCombosLoteForeignKeyDescuentoMonto(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalBodega) throws Exception {
		DescuentoMontoParameterReturnGeneral  descuentomontoReturnGeneral =new DescuentoMontoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			descuentomontoReturnGeneral =new DescuentoMontoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			descuentomontoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			descuentomontoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			descuentomontoReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			descuentomontoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return descuentomontoReturnGeneral;
	}
	
	
	public void deepLoad(DescuentoMonto descuentomonto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DescuentoMontoLogicAdditional.updateDescuentoMontoToGet(descuentomonto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		descuentomonto.setEmpresa(descuentomontoDataAccess.getEmpresa(connexion,descuentomonto));
		descuentomonto.setSucursal(descuentomontoDataAccess.getSucursal(connexion,descuentomonto));
		descuentomonto.setUsuario(descuentomontoDataAccess.getUsuario(connexion,descuentomonto));
		descuentomonto.setBodega(descuentomontoDataAccess.getBodega(connexion,descuentomonto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				descuentomonto.setEmpresa(descuentomontoDataAccess.getEmpresa(connexion,descuentomonto));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				descuentomonto.setSucursal(descuentomontoDataAccess.getSucursal(connexion,descuentomonto));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				descuentomonto.setUsuario(descuentomontoDataAccess.getUsuario(connexion,descuentomonto));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				descuentomonto.setBodega(descuentomontoDataAccess.getBodega(connexion,descuentomonto));
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
			descuentomonto.setEmpresa(descuentomontoDataAccess.getEmpresa(connexion,descuentomonto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			descuentomonto.setSucursal(descuentomontoDataAccess.getSucursal(connexion,descuentomonto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			descuentomonto.setUsuario(descuentomontoDataAccess.getUsuario(connexion,descuentomonto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			descuentomonto.setBodega(descuentomontoDataAccess.getBodega(connexion,descuentomonto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		descuentomonto.setEmpresa(descuentomontoDataAccess.getEmpresa(connexion,descuentomonto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(descuentomonto.getEmpresa(),isDeep,deepLoadType,clases);
				
		descuentomonto.setSucursal(descuentomontoDataAccess.getSucursal(connexion,descuentomonto));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(descuentomonto.getSucursal(),isDeep,deepLoadType,clases);
				
		descuentomonto.setUsuario(descuentomontoDataAccess.getUsuario(connexion,descuentomonto));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(descuentomonto.getUsuario(),isDeep,deepLoadType,clases);
				
		descuentomonto.setBodega(descuentomontoDataAccess.getBodega(connexion,descuentomonto));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(descuentomonto.getBodega(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				descuentomonto.setEmpresa(descuentomontoDataAccess.getEmpresa(connexion,descuentomonto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(descuentomonto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				descuentomonto.setSucursal(descuentomontoDataAccess.getSucursal(connexion,descuentomonto));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(descuentomonto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				descuentomonto.setUsuario(descuentomontoDataAccess.getUsuario(connexion,descuentomonto));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(descuentomonto.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				descuentomonto.setBodega(descuentomontoDataAccess.getBodega(connexion,descuentomonto));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(descuentomonto.getBodega(),isDeep,deepLoadType,clases);				
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
			descuentomonto.setEmpresa(descuentomontoDataAccess.getEmpresa(connexion,descuentomonto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(descuentomonto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			descuentomonto.setSucursal(descuentomontoDataAccess.getSucursal(connexion,descuentomonto));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(descuentomonto.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			descuentomonto.setUsuario(descuentomontoDataAccess.getUsuario(connexion,descuentomonto));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(descuentomonto.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			descuentomonto.setBodega(descuentomontoDataAccess.getBodega(connexion,descuentomonto));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(descuentomonto.getBodega(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DescuentoMonto descuentomonto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DescuentoMontoLogicAdditional.updateDescuentoMontoToSave(descuentomonto,this.arrDatoGeneral);
			
DescuentoMontoDataAccess.save(descuentomonto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(descuentomonto.getEmpresa(),connexion);

		SucursalDataAccess.save(descuentomonto.getSucursal(),connexion);

		UsuarioDataAccess.save(descuentomonto.getUsuario(),connexion);

		BodegaDataAccess.save(descuentomonto.getBodega(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(descuentomonto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(descuentomonto.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(descuentomonto.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(descuentomonto.getBodega(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(descuentomonto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(descuentomonto.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(descuentomonto.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(descuentomonto.getSucursal(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(descuentomonto.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(descuentomonto.getUsuario(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(descuentomonto.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(descuentomonto.getBodega(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(descuentomonto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(descuentomonto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(descuentomonto.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(descuentomonto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(descuentomonto.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(descuentomonto.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(descuentomonto.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(descuentomonto.getBodega(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DescuentoMonto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(descuentomonto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(descuentomonto);
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
			this.deepLoad(this.descuentomonto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomonto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DescuentoMonto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(descuentomontos!=null) {
				for(DescuentoMonto descuentomonto:descuentomontos) {
					this.deepLoad(descuentomonto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(descuentomontos);
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
			if(descuentomontos!=null) {
				for(DescuentoMonto descuentomonto:descuentomontos) {
					this.deepLoad(descuentomonto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(descuentomontos);
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
			this.getNewConnexionToDeep(DescuentoMonto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(descuentomonto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DescuentoMonto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(descuentomontos!=null) {
				for(DescuentoMonto descuentomonto:descuentomontos) {
					this.deepSave(descuentomonto,isDeep,deepLoadType,clases);
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
			if(descuentomontos!=null) {
				for(DescuentoMonto descuentomonto:descuentomontos) {
					this.deepSave(descuentomonto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDescuentoMontosFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DescuentoMontoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentomontos=descuentomontoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDescuentoMontosFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DescuentoMontoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentomontos=descuentomontoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDescuentoMontosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DescuentoMontoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentomontos=descuentomontoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDescuentoMontosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DescuentoMontoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentomontos=descuentomontoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDescuentoMontosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DescuentoMontoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentomontos=descuentomontoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDescuentoMontosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DescuentoMontoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentomontos=descuentomontoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDescuentoMontosFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoMonto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,DescuentoMontoConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentomontos=descuentomontoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDescuentoMontosFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,DescuentoMontoConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			DescuentoMontoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentomontos=descuentomontoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(this.descuentomontos);
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
			if(DescuentoMontoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DescuentoMontoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DescuentoMonto descuentomonto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DescuentoMontoConstantesFunciones.ISCONAUDITORIA) {
				if(descuentomonto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DescuentoMontoDataAccess.TABLENAME, descuentomonto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DescuentoMontoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DescuentoMontoLogic.registrarAuditoriaDetallesDescuentoMonto(connexion,descuentomonto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(descuentomonto.getIsDeleted()) {
					/*if(!descuentomonto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DescuentoMontoDataAccess.TABLENAME, descuentomonto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DescuentoMontoLogic.registrarAuditoriaDetallesDescuentoMonto(connexion,descuentomonto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DescuentoMontoDataAccess.TABLENAME, descuentomonto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(descuentomonto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DescuentoMontoDataAccess.TABLENAME, descuentomonto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DescuentoMontoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DescuentoMontoLogic.registrarAuditoriaDetallesDescuentoMonto(connexion,descuentomonto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDescuentoMonto(Connexion connexion,DescuentoMonto descuentomonto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(descuentomonto.getIsNew()||!descuentomonto.getid_empresa().equals(descuentomonto.getDescuentoMontoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentomonto.getDescuentoMontoOriginal().getid_empresa()!=null)
				{
					strValorActual=descuentomonto.getDescuentoMontoOriginal().getid_empresa().toString();
				}
				if(descuentomonto.getid_empresa()!=null)
				{
					strValorNuevo=descuentomonto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoMontoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(descuentomonto.getIsNew()||!descuentomonto.getid_sucursal().equals(descuentomonto.getDescuentoMontoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentomonto.getDescuentoMontoOriginal().getid_sucursal()!=null)
				{
					strValorActual=descuentomonto.getDescuentoMontoOriginal().getid_sucursal().toString();
				}
				if(descuentomonto.getid_sucursal()!=null)
				{
					strValorNuevo=descuentomonto.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoMontoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(descuentomonto.getIsNew()||!descuentomonto.getid_usuario().equals(descuentomonto.getDescuentoMontoOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentomonto.getDescuentoMontoOriginal().getid_usuario()!=null)
				{
					strValorActual=descuentomonto.getDescuentoMontoOriginal().getid_usuario().toString();
				}
				if(descuentomonto.getid_usuario()!=null)
				{
					strValorNuevo=descuentomonto.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoMontoConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(descuentomonto.getIsNew()||!descuentomonto.getid_bodega().equals(descuentomonto.getDescuentoMontoOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentomonto.getDescuentoMontoOriginal().getid_bodega()!=null)
				{
					strValorActual=descuentomonto.getDescuentoMontoOriginal().getid_bodega().toString();
				}
				if(descuentomonto.getid_bodega()!=null)
				{
					strValorNuevo=descuentomonto.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoMontoConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(descuentomonto.getIsNew()||!descuentomonto.getdescripcion().equals(descuentomonto.getDescuentoMontoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentomonto.getDescuentoMontoOriginal().getdescripcion()!=null)
				{
					strValorActual=descuentomonto.getDescuentoMontoOriginal().getdescripcion();
				}
				if(descuentomonto.getdescripcion()!=null)
				{
					strValorNuevo=descuentomonto.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoMontoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(descuentomonto.getIsNew()||!descuentomonto.getporcentaje().equals(descuentomonto.getDescuentoMontoOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentomonto.getDescuentoMontoOriginal().getporcentaje()!=null)
				{
					strValorActual=descuentomonto.getDescuentoMontoOriginal().getporcentaje().toString();
				}
				if(descuentomonto.getporcentaje()!=null)
				{
					strValorNuevo=descuentomonto.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoMontoConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(descuentomonto.getIsNew()||!descuentomonto.getvalor_inicio().equals(descuentomonto.getDescuentoMontoOriginal().getvalor_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentomonto.getDescuentoMontoOriginal().getvalor_inicio()!=null)
				{
					strValorActual=descuentomonto.getDescuentoMontoOriginal().getvalor_inicio().toString();
				}
				if(descuentomonto.getvalor_inicio()!=null)
				{
					strValorNuevo=descuentomonto.getvalor_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoMontoConstantesFunciones.VALORINICIO,strValorActual,strValorNuevo);
			}	
			
			if(descuentomonto.getIsNew()||!descuentomonto.getvalor_fin().equals(descuentomonto.getDescuentoMontoOriginal().getvalor_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentomonto.getDescuentoMontoOriginal().getvalor_fin()!=null)
				{
					strValorActual=descuentomonto.getDescuentoMontoOriginal().getvalor_fin().toString();
				}
				if(descuentomonto.getvalor_fin()!=null)
				{
					strValorNuevo=descuentomonto.getvalor_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoMontoConstantesFunciones.VALORFIN,strValorActual,strValorNuevo);
			}	
			
			if(descuentomonto.getIsNew()||!descuentomonto.getesta_activo().equals(descuentomonto.getDescuentoMontoOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentomonto.getDescuentoMontoOriginal().getesta_activo()!=null)
				{
					strValorActual=descuentomonto.getDescuentoMontoOriginal().getesta_activo().toString();
				}
				if(descuentomonto.getesta_activo()!=null)
				{
					strValorNuevo=descuentomonto.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoMontoConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDescuentoMontoRelacionesWithConnection(DescuentoMonto descuentomonto) throws Exception {

		if(!descuentomonto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDescuentoMontoRelacionesBase(descuentomonto,true);
		}
	}

	public void saveDescuentoMontoRelaciones(DescuentoMonto descuentomonto)throws Exception {

		if(!descuentomonto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDescuentoMontoRelacionesBase(descuentomonto,false);
		}
	}

	public void saveDescuentoMontoRelacionesBase(DescuentoMonto descuentomonto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DescuentoMonto-saveRelacionesWithConnection");}
	

			this.setDescuentoMonto(descuentomonto);

			if(DescuentoMontoLogicAdditional.validarSaveRelaciones(descuentomonto,this)) {

				DescuentoMontoLogicAdditional.updateRelacionesToSave(descuentomonto,this);

				if((descuentomonto.getIsNew()||descuentomonto.getIsChanged())&&!descuentomonto.getIsDeleted()) {
					this.saveDescuentoMonto();
					this.saveDescuentoMontoRelacionesDetalles();

				} else if(descuentomonto.getIsDeleted()) {
					this.saveDescuentoMontoRelacionesDetalles();
					this.saveDescuentoMonto();
				}

				DescuentoMontoLogicAdditional.updateRelacionesToSaveAfter(descuentomonto,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveDescuentoMontoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDescuentoMonto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DescuentoMontoConstantesFunciones.getClassesForeignKeysOfDescuentoMonto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDescuentoMonto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DescuentoMontoConstantesFunciones.getClassesRelationshipsOfDescuentoMonto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

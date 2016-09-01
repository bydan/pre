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
import com.bydan.erp.inventario.util.GrupoColorConstantesFunciones;
import com.bydan.erp.inventario.util.GrupoColorParameterReturnGeneral;
//import com.bydan.erp.inventario.util.GrupoColorParameterGeneral;
import com.bydan.erp.inventario.business.entity.GrupoColor;
import com.bydan.erp.inventario.business.logic.GrupoColorLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class GrupoColorLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(GrupoColorLogic.class);
	
	protected GrupoColorDataAccess grupocolorDataAccess; 	
	protected GrupoColor grupocolor;
	protected List<GrupoColor> grupocolors;
	protected Object grupocolorObject;	
	protected List<Object> grupocolorsObject;
	
	public static ClassValidator<GrupoColor> grupocolorValidator = new ClassValidator<GrupoColor>(GrupoColor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected GrupoColorLogicAdditional grupocolorLogicAdditional=null;
	
	public GrupoColorLogicAdditional getGrupoColorLogicAdditional() {
		return this.grupocolorLogicAdditional;
	}
	
	public void setGrupoColorLogicAdditional(GrupoColorLogicAdditional grupocolorLogicAdditional) {
		try {
			this.grupocolorLogicAdditional=grupocolorLogicAdditional;
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
	
	
	
	
	public  GrupoColorLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.grupocolorDataAccess = new GrupoColorDataAccess();
			
			this.grupocolors= new ArrayList<GrupoColor>();
			this.grupocolor= new GrupoColor();
			
			this.grupocolorObject=new Object();
			this.grupocolorsObject=new ArrayList<Object>();
				
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
			
			this.grupocolorDataAccess.setConnexionType(this.connexionType);
			this.grupocolorDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  GrupoColorLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.grupocolorDataAccess = new GrupoColorDataAccess();
			this.grupocolors= new ArrayList<GrupoColor>();
			this.grupocolor= new GrupoColor();
			this.grupocolorObject=new Object();
			this.grupocolorsObject=new ArrayList<Object>();
			
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
			
			this.grupocolorDataAccess.setConnexionType(this.connexionType);
			this.grupocolorDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public GrupoColor getGrupoColor() throws Exception {	
		GrupoColorLogicAdditional.checkGrupoColorToGet(grupocolor,this.datosCliente,this.arrDatoGeneral);
		GrupoColorLogicAdditional.updateGrupoColorToGet(grupocolor,this.arrDatoGeneral);
		
		return grupocolor;
	}
		
	public void setGrupoColor(GrupoColor newGrupoColor) {
		this.grupocolor = newGrupoColor;
	}
	
	public GrupoColorDataAccess getGrupoColorDataAccess() {
		return grupocolorDataAccess;
	}
	
	public void setGrupoColorDataAccess(GrupoColorDataAccess newgrupocolorDataAccess) {
		this.grupocolorDataAccess = newgrupocolorDataAccess;
	}
	
	public List<GrupoColor> getGrupoColors() throws Exception {		
		this.quitarGrupoColorsNulos();
		
		GrupoColorLogicAdditional.checkGrupoColorToGets(grupocolors,this.datosCliente,this.arrDatoGeneral);
		
		for (GrupoColor grupocolorLocal: grupocolors ) {
			GrupoColorLogicAdditional.updateGrupoColorToGet(grupocolorLocal,this.arrDatoGeneral);
		}
		
		return grupocolors;
	}
	
	public void setGrupoColors(List<GrupoColor> newGrupoColors) {
		this.grupocolors = newGrupoColors;
	}
	
	public Object getGrupoColorObject() {	
		this.grupocolorObject=this.grupocolorDataAccess.getEntityObject();
		return this.grupocolorObject;
	}
		
	public void setGrupoColorObject(Object newGrupoColorObject) {
		this.grupocolorObject = newGrupoColorObject;
	}
	
	public List<Object> getGrupoColorsObject() {		
		this.grupocolorsObject=this.grupocolorDataAccess.getEntitiesObject();
		return this.grupocolorsObject;
	}
		
	public void setGrupoColorsObject(List<Object> newGrupoColorsObject) {
		this.grupocolorsObject = newGrupoColorsObject;
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
		
		if(this.grupocolorDataAccess!=null) {
			this.grupocolorDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			grupocolorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			grupocolorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		grupocolor = new  GrupoColor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			grupocolor=grupocolorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupocolor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolor);
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
		grupocolor = new  GrupoColor();
		  		  
        try {
			
			grupocolor=grupocolorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupocolor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		grupocolor = new  GrupoColor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			grupocolor=grupocolorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupocolor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolor);
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
		grupocolor = new  GrupoColor();
		  		  
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
		grupocolor = new  GrupoColor();
		  		  
        try {
			
			grupocolor=grupocolorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupocolor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		grupocolor = new  GrupoColor();
		  		  
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
		grupocolor = new  GrupoColor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =grupocolorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupocolor = new  GrupoColor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=grupocolorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		grupocolor = new  GrupoColor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =grupocolorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupocolor = new  GrupoColor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=grupocolorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		grupocolor = new  GrupoColor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =grupocolorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupocolor = new  GrupoColor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=grupocolorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		grupocolors = new  ArrayList<GrupoColor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupocolors=grupocolorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoColor(grupocolors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
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
		grupocolors = new  ArrayList<GrupoColor>();
		  		  
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
		grupocolors = new  ArrayList<GrupoColor>();
		  		  
        try {			
			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupocolors=grupocolorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarGrupoColor(grupocolors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		grupocolors = new  ArrayList<GrupoColor>();
		  		  
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
		grupocolors = new  ArrayList<GrupoColor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupocolors=grupocolorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoColor(grupocolors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
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
		grupocolors = new  ArrayList<GrupoColor>();
		  		  
        try {
			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupocolors=grupocolorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoColor(grupocolors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
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
		grupocolors = new  ArrayList<GrupoColor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupocolors=grupocolorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoColor(grupocolors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
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
		grupocolors = new  ArrayList<GrupoColor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupocolors=grupocolorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoColor(grupocolors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		grupocolor = new  GrupoColor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupocolor=grupocolorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoColor(grupocolor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolor);
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
		grupocolor = new  GrupoColor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupocolor=grupocolorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoColor(grupocolor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		grupocolors = new  ArrayList<GrupoColor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupocolors=grupocolorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoColor(grupocolors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
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
		grupocolors = new  ArrayList<GrupoColor>();
		  		  
        try {
			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupocolors=grupocolorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoColor(grupocolors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosGrupoColorsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		grupocolors = new  ArrayList<GrupoColor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-getTodosGrupoColorsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupocolors=grupocolorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGrupoColor(grupocolors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
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
	
	public  void  getTodosGrupoColors(String sFinalQuery,Pagination pagination)throws Exception {
		grupocolors = new  ArrayList<GrupoColor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupocolors=grupocolorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGrupoColor(grupocolors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarGrupoColor(GrupoColor grupocolor) throws Exception {
		Boolean estaValidado=false;
		
		if(grupocolor.getIsNew() || grupocolor.getIsChanged()) { 
			this.invalidValues = grupocolorValidator.getInvalidValues(grupocolor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(grupocolor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarGrupoColor(List<GrupoColor> GrupoColors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(GrupoColor grupocolorLocal:grupocolors) {				
			estaValidadoObjeto=this.validarGuardarGrupoColor(grupocolorLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarGrupoColor(List<GrupoColor> GrupoColors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGrupoColor(grupocolors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarGrupoColor(GrupoColor GrupoColor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGrupoColor(grupocolor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(GrupoColor grupocolor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+grupocolor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=GrupoColorConstantesFunciones.getGrupoColorLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"grupocolor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(GrupoColorConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(GrupoColorConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveGrupoColorWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-saveGrupoColorWithConnection");connexion.begin();			
			
			GrupoColorLogicAdditional.checkGrupoColorToSave(this.grupocolor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GrupoColorLogicAdditional.updateGrupoColorToSave(this.grupocolor,this.arrDatoGeneral);
			
			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.grupocolor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowGrupoColor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGrupoColor(this.grupocolor)) {
				GrupoColorDataAccess.save(this.grupocolor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.grupocolor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GrupoColorLogicAdditional.checkGrupoColorToSaveAfter(this.grupocolor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGrupoColor();
			
			connexion.commit();			
			
			if(this.grupocolor.getIsDeleted()) {
				this.grupocolor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveGrupoColor()throws Exception {	
		try {	
			
			GrupoColorLogicAdditional.checkGrupoColorToSave(this.grupocolor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GrupoColorLogicAdditional.updateGrupoColorToSave(this.grupocolor,this.arrDatoGeneral);
			
			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.grupocolor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGrupoColor(this.grupocolor)) {			
				GrupoColorDataAccess.save(this.grupocolor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.grupocolor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GrupoColorLogicAdditional.checkGrupoColorToSaveAfter(this.grupocolor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.grupocolor.getIsDeleted()) {
				this.grupocolor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveGrupoColorsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-saveGrupoColorsWithConnection");connexion.begin();			
			
			GrupoColorLogicAdditional.checkGrupoColorToSaves(grupocolors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowGrupoColors();
			
			Boolean validadoTodosGrupoColor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GrupoColor grupocolorLocal:grupocolors) {		
				if(grupocolorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GrupoColorLogicAdditional.updateGrupoColorToSave(grupocolorLocal,this.arrDatoGeneral);
	        	
				GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),grupocolorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGrupoColor(grupocolorLocal)) {
					GrupoColorDataAccess.save(grupocolorLocal, connexion);				
				} else {
					validadoTodosGrupoColor=false;
				}
			}
			
			if(!validadoTodosGrupoColor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GrupoColorLogicAdditional.checkGrupoColorToSavesAfter(grupocolors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGrupoColors();
			
			connexion.commit();		
			
			this.quitarGrupoColorsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveGrupoColors()throws Exception {				
		 try {	
			GrupoColorLogicAdditional.checkGrupoColorToSaves(grupocolors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosGrupoColor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GrupoColor grupocolorLocal:grupocolors) {				
				if(grupocolorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GrupoColorLogicAdditional.updateGrupoColorToSave(grupocolorLocal,this.arrDatoGeneral);
	        	
				GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),grupocolorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGrupoColor(grupocolorLocal)) {				
					GrupoColorDataAccess.save(grupocolorLocal, connexion);				
				} else {
					validadoTodosGrupoColor=false;
				}
			}
			
			if(!validadoTodosGrupoColor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GrupoColorLogicAdditional.checkGrupoColorToSavesAfter(grupocolors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarGrupoColorsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GrupoColorParameterReturnGeneral procesarAccionGrupoColors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GrupoColor> grupocolors,GrupoColorParameterReturnGeneral grupocolorParameterGeneral)throws Exception {
		 try {	
			GrupoColorParameterReturnGeneral grupocolorReturnGeneral=new GrupoColorParameterReturnGeneral();
	
			GrupoColorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,grupocolors,grupocolorParameterGeneral,grupocolorReturnGeneral);
			
			return grupocolorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GrupoColorParameterReturnGeneral procesarAccionGrupoColorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GrupoColor> grupocolors,GrupoColorParameterReturnGeneral grupocolorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-procesarAccionGrupoColorsWithConnection");connexion.begin();			
			
			GrupoColorParameterReturnGeneral grupocolorReturnGeneral=new GrupoColorParameterReturnGeneral();
	
			GrupoColorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,grupocolors,grupocolorParameterGeneral,grupocolorReturnGeneral);
			
			this.connexion.commit();
			
			return grupocolorReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GrupoColorParameterReturnGeneral procesarEventosGrupoColors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GrupoColor> grupocolors,GrupoColor grupocolor,GrupoColorParameterReturnGeneral grupocolorParameterGeneral,Boolean isEsNuevoGrupoColor,ArrayList<Classe> clases)throws Exception {
		 try {	
			GrupoColorParameterReturnGeneral grupocolorReturnGeneral=new GrupoColorParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				grupocolorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GrupoColorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,grupocolors,grupocolor,grupocolorParameterGeneral,grupocolorReturnGeneral,isEsNuevoGrupoColor,clases);
			
			return grupocolorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public GrupoColorParameterReturnGeneral procesarEventosGrupoColorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GrupoColor> grupocolors,GrupoColor grupocolor,GrupoColorParameterReturnGeneral grupocolorParameterGeneral,Boolean isEsNuevoGrupoColor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-procesarEventosGrupoColorsWithConnection");connexion.begin();			
			
			GrupoColorParameterReturnGeneral grupocolorReturnGeneral=new GrupoColorParameterReturnGeneral();
	
			grupocolorReturnGeneral.setGrupoColor(grupocolor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				grupocolorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GrupoColorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,grupocolors,grupocolor,grupocolorParameterGeneral,grupocolorReturnGeneral,isEsNuevoGrupoColor,clases);
			
			this.connexion.commit();
			
			return grupocolorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GrupoColorParameterReturnGeneral procesarImportacionGrupoColorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,GrupoColorParameterReturnGeneral grupocolorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-procesarImportacionGrupoColorsWithConnection");connexion.begin();			
			
			GrupoColorParameterReturnGeneral grupocolorReturnGeneral=new GrupoColorParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.grupocolors=new ArrayList<GrupoColor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.grupocolor=new GrupoColor();
				
				
				if(conColumnasBase) {this.grupocolor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.grupocolor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.grupocolor.setcodigo(arrColumnas[iColumn++]);
				this.grupocolor.setnombre(arrColumnas[iColumn++]);
				
				this.grupocolors.add(this.grupocolor);
			}
			
			this.saveGrupoColors();
			
			this.connexion.commit();
			
			grupocolorReturnGeneral.setConRetornoEstaProcesado(true);
			grupocolorReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return grupocolorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarGrupoColorsEliminados() throws Exception {				
		
		List<GrupoColor> grupocolorsAux= new ArrayList<GrupoColor>();
		
		for(GrupoColor grupocolor:grupocolors) {
			if(!grupocolor.getIsDeleted()) {
				grupocolorsAux.add(grupocolor);
			}
		}
		
		grupocolors=grupocolorsAux;
	}
	
	public void quitarGrupoColorsNulos() throws Exception {				
		
		List<GrupoColor> grupocolorsAux= new ArrayList<GrupoColor>();
		
		for(GrupoColor grupocolor : this.grupocolors) {
			if(grupocolor==null) {
				grupocolorsAux.add(grupocolor);
			}
		}
		
		//this.grupocolors=grupocolorsAux;
		
		this.grupocolors.removeAll(grupocolorsAux);
	}
	
	public void getSetVersionRowGrupoColorWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(grupocolor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((grupocolor.getIsDeleted() || (grupocolor.getIsChanged()&&!grupocolor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=grupocolorDataAccess.getSetVersionRowGrupoColor(connexion,grupocolor.getId());
				
				if(!grupocolor.getVersionRow().equals(timestamp)) {	
					grupocolor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				grupocolor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowGrupoColor()throws Exception {	
		
		if(grupocolor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((grupocolor.getIsDeleted() || (grupocolor.getIsChanged()&&!grupocolor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=grupocolorDataAccess.getSetVersionRowGrupoColor(connexion,grupocolor.getId());
			
			try {							
				if(!grupocolor.getVersionRow().equals(timestamp)) {	
					grupocolor.setVersionRow(timestamp);
				}
				
				grupocolor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowGrupoColorsWithConnection()throws Exception {	
		if(grupocolors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(GrupoColor grupocolorAux:grupocolors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(grupocolorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(grupocolorAux.getIsDeleted() || (grupocolorAux.getIsChanged()&&!grupocolorAux.getIsNew())) {
						
						timestamp=grupocolorDataAccess.getSetVersionRowGrupoColor(connexion,grupocolorAux.getId());
						
						if(!grupocolor.getVersionRow().equals(timestamp)) {	
							grupocolorAux.setVersionRow(timestamp);
						}
								
						grupocolorAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowGrupoColors()throws Exception {	
		if(grupocolors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(GrupoColor grupocolorAux:grupocolors) {
					if(grupocolorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(grupocolorAux.getIsDeleted() || (grupocolorAux.getIsChanged()&&!grupocolorAux.getIsNew())) {
						
						timestamp=grupocolorDataAccess.getSetVersionRowGrupoColor(connexion,grupocolorAux.getId());
						
						if(!grupocolorAux.getVersionRow().equals(timestamp)) {	
							grupocolorAux.setVersionRow(timestamp);
						}
						
													
						grupocolorAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public GrupoColorParameterReturnGeneral cargarCombosLoteForeignKeyGrupoColorWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal) throws Exception {
		GrupoColorParameterReturnGeneral  grupocolorReturnGeneral =new GrupoColorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-cargarCombosLoteForeignKeyGrupoColorWithConnection");connexion.begin();
			
			grupocolorReturnGeneral =new GrupoColorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			grupocolorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			grupocolorReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return grupocolorReturnGeneral;
	}
	
	public GrupoColorParameterReturnGeneral cargarCombosLoteForeignKeyGrupoColor(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal) throws Exception {
		GrupoColorParameterReturnGeneral  grupocolorReturnGeneral =new GrupoColorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			grupocolorReturnGeneral =new GrupoColorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			grupocolorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			grupocolorReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return grupocolorReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyGrupoColorWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ColorProductoLogic colorproductoLogic=new ColorProductoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyGrupoColorWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ColorProducto.class));
											
			

			colorproductoLogic.setConnexion(this.getConnexion());
			colorproductoLogic.setDatosCliente(this.datosCliente);
			colorproductoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(GrupoColor grupocolor:this.grupocolors) {
				

				classes=new ArrayList<Classe>();
				classes=ColorProductoConstantesFunciones.getClassesForeignKeysOfColorProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				colorproductoLogic.setColorProductos(grupocolor.colorproductos);
				colorproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(GrupoColor grupocolor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			GrupoColorLogicAdditional.updateGrupoColorToGet(grupocolor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		grupocolor.setEmpresa(grupocolorDataAccess.getEmpresa(connexion,grupocolor));
		grupocolor.setSucursal(grupocolorDataAccess.getSucursal(connexion,grupocolor));
		grupocolor.setColorProductos(grupocolorDataAccess.getColorProductos(connexion,grupocolor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				grupocolor.setEmpresa(grupocolorDataAccess.getEmpresa(connexion,grupocolor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				grupocolor.setSucursal(grupocolorDataAccess.getSucursal(connexion,grupocolor));
				continue;
			}

			if(clas.clas.equals(ColorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupocolor.setColorProductos(grupocolorDataAccess.getColorProductos(connexion,grupocolor));

				if(this.isConDeep) {
					ColorProductoLogic colorproductoLogic= new ColorProductoLogic(this.connexion);
					colorproductoLogic.setColorProductos(grupocolor.getColorProductos());
					ArrayList<Classe> classesLocal=ColorProductoConstantesFunciones.getClassesForeignKeysOfColorProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					colorproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ColorProductoConstantesFunciones.refrescarForeignKeysDescripcionesColorProducto(colorproductoLogic.getColorProductos());
					grupocolor.setColorProductos(colorproductoLogic.getColorProductos());
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
			grupocolor.setEmpresa(grupocolorDataAccess.getEmpresa(connexion,grupocolor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupocolor.setSucursal(grupocolorDataAccess.getSucursal(connexion,grupocolor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ColorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ColorProducto.class));
			grupocolor.setColorProductos(grupocolorDataAccess.getColorProductos(connexion,grupocolor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		grupocolor.setEmpresa(grupocolorDataAccess.getEmpresa(connexion,grupocolor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(grupocolor.getEmpresa(),isDeep,deepLoadType,clases);
				
		grupocolor.setSucursal(grupocolorDataAccess.getSucursal(connexion,grupocolor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(grupocolor.getSucursal(),isDeep,deepLoadType,clases);
				

		grupocolor.setColorProductos(grupocolorDataAccess.getColorProductos(connexion,grupocolor));

		for(ColorProducto colorproducto:grupocolor.getColorProductos()) {
			ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
			colorproductoLogic.deepLoad(colorproducto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				grupocolor.setEmpresa(grupocolorDataAccess.getEmpresa(connexion,grupocolor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(grupocolor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				grupocolor.setSucursal(grupocolorDataAccess.getSucursal(connexion,grupocolor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(grupocolor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ColorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupocolor.setColorProductos(grupocolorDataAccess.getColorProductos(connexion,grupocolor));

				for(ColorProducto colorproducto:grupocolor.getColorProductos()) {
					ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
					colorproductoLogic.deepLoad(colorproducto,isDeep,deepLoadType,clases);
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
			grupocolor.setEmpresa(grupocolorDataAccess.getEmpresa(connexion,grupocolor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(grupocolor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupocolor.setSucursal(grupocolorDataAccess.getSucursal(connexion,grupocolor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(grupocolor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ColorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ColorProducto.class));
			grupocolor.setColorProductos(grupocolorDataAccess.getColorProductos(connexion,grupocolor));

			for(ColorProducto colorproducto:grupocolor.getColorProductos()) {
				ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
				colorproductoLogic.deepLoad(colorproducto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(GrupoColor grupocolor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			GrupoColorLogicAdditional.updateGrupoColorToSave(grupocolor,this.arrDatoGeneral);
			
GrupoColorDataAccess.save(grupocolor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(grupocolor.getEmpresa(),connexion);

		SucursalDataAccess.save(grupocolor.getSucursal(),connexion);

		for(ColorProducto colorproducto:grupocolor.getColorProductos()) {
			colorproducto.setid_grupo_color(grupocolor.getId());
			ColorProductoDataAccess.save(colorproducto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(grupocolor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(grupocolor.getSucursal(),connexion);
				continue;
			}


			if(clas.clas.equals(ColorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ColorProducto colorproducto:grupocolor.getColorProductos()) {
					colorproducto.setid_grupo_color(grupocolor.getId());
					ColorProductoDataAccess.save(colorproducto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(grupocolor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(grupocolor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(grupocolor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(grupocolor.getSucursal(),isDeep,deepLoadType,clases);
				

		for(ColorProducto colorproducto:grupocolor.getColorProductos()) {
			ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
			colorproducto.setid_grupo_color(grupocolor.getId());
			ColorProductoDataAccess.save(colorproducto,connexion);
			colorproductoLogic.deepSave(colorproducto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(grupocolor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(grupocolor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(grupocolor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(grupocolor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ColorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ColorProducto colorproducto:grupocolor.getColorProductos()) {
					ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
					colorproducto.setid_grupo_color(grupocolor.getId());
					ColorProductoDataAccess.save(colorproducto,connexion);
					colorproductoLogic.deepSave(colorproducto,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(GrupoColor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(grupocolor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(grupocolor);
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
			this.deepLoad(this.grupocolor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(GrupoColor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(grupocolors!=null) {
				for(GrupoColor grupocolor:grupocolors) {
					this.deepLoad(grupocolor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(grupocolors);
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
			if(grupocolors!=null) {
				for(GrupoColor grupocolor:grupocolors) {
					this.deepLoad(grupocolor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(grupocolors);
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
			this.getNewConnexionToDeep(GrupoColor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(grupocolor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(GrupoColor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(grupocolors!=null) {
				for(GrupoColor grupocolor:grupocolors) {
					this.deepSave(grupocolor,isDeep,deepLoadType,clases);
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
			if(grupocolors!=null) {
				for(GrupoColor grupocolor:grupocolors) {
					this.deepSave(grupocolor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getGrupoColorsBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",GrupoColorConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupocolors=grupocolorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoColorsBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",GrupoColorConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupocolors=grupocolorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoColorsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",GrupoColorConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupocolors=grupocolorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoColorsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",GrupoColorConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupocolors=grupocolorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoColorsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GrupoColorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupocolors=grupocolorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoColorsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GrupoColorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupocolors=grupocolorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoColorsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoColor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,GrupoColorConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupocolors=grupocolorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoColorsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,GrupoColorConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			GrupoColorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupocolors=grupocolorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoColorConstantesFunciones.refrescarForeignKeysDescripcionesGrupoColor(this.grupocolors);
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
			if(GrupoColorConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoColorDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,GrupoColor grupocolor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(GrupoColorConstantesFunciones.ISCONAUDITORIA) {
				if(grupocolor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoColorDataAccess.TABLENAME, grupocolor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GrupoColorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GrupoColorLogic.registrarAuditoriaDetallesGrupoColor(connexion,grupocolor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(grupocolor.getIsDeleted()) {
					/*if(!grupocolor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,GrupoColorDataAccess.TABLENAME, grupocolor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////GrupoColorLogic.registrarAuditoriaDetallesGrupoColor(connexion,grupocolor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoColorDataAccess.TABLENAME, grupocolor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(grupocolor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoColorDataAccess.TABLENAME, grupocolor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GrupoColorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GrupoColorLogic.registrarAuditoriaDetallesGrupoColor(connexion,grupocolor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesGrupoColor(Connexion connexion,GrupoColor grupocolor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(grupocolor.getIsNew()||!grupocolor.getid_empresa().equals(grupocolor.getGrupoColorOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupocolor.getGrupoColorOriginal().getid_empresa()!=null)
				{
					strValorActual=grupocolor.getGrupoColorOriginal().getid_empresa().toString();
				}
				if(grupocolor.getid_empresa()!=null)
				{
					strValorNuevo=grupocolor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoColorConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(grupocolor.getIsNew()||!grupocolor.getid_sucursal().equals(grupocolor.getGrupoColorOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupocolor.getGrupoColorOriginal().getid_sucursal()!=null)
				{
					strValorActual=grupocolor.getGrupoColorOriginal().getid_sucursal().toString();
				}
				if(grupocolor.getid_sucursal()!=null)
				{
					strValorNuevo=grupocolor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoColorConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(grupocolor.getIsNew()||!grupocolor.getcodigo().equals(grupocolor.getGrupoColorOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupocolor.getGrupoColorOriginal().getcodigo()!=null)
				{
					strValorActual=grupocolor.getGrupoColorOriginal().getcodigo();
				}
				if(grupocolor.getcodigo()!=null)
				{
					strValorNuevo=grupocolor.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoColorConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(grupocolor.getIsNew()||!grupocolor.getnombre().equals(grupocolor.getGrupoColorOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupocolor.getGrupoColorOriginal().getnombre()!=null)
				{
					strValorActual=grupocolor.getGrupoColorOriginal().getnombre();
				}
				if(grupocolor.getnombre()!=null)
				{
					strValorNuevo=grupocolor.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoColorConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveGrupoColorRelacionesWithConnection(GrupoColor grupocolor,List<ColorProducto> colorproductos) throws Exception {

		if(!grupocolor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGrupoColorRelacionesBase(grupocolor,colorproductos,true);
		}
	}

	public void saveGrupoColorRelaciones(GrupoColor grupocolor,List<ColorProducto> colorproductos)throws Exception {

		if(!grupocolor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGrupoColorRelacionesBase(grupocolor,colorproductos,false);
		}
	}

	public void saveGrupoColorRelacionesBase(GrupoColor grupocolor,List<ColorProducto> colorproductos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("GrupoColor-saveRelacionesWithConnection");}
	
			grupocolor.setColorProductos(colorproductos);

			this.setGrupoColor(grupocolor);

			if(GrupoColorLogicAdditional.validarSaveRelaciones(grupocolor,this)) {

				GrupoColorLogicAdditional.updateRelacionesToSave(grupocolor,this);

				if((grupocolor.getIsNew()||grupocolor.getIsChanged())&&!grupocolor.getIsDeleted()) {
					this.saveGrupoColor();
					this.saveGrupoColorRelacionesDetalles(colorproductos);

				} else if(grupocolor.getIsDeleted()) {
					this.saveGrupoColorRelacionesDetalles(colorproductos);
					this.saveGrupoColor();
				}

				GrupoColorLogicAdditional.updateRelacionesToSaveAfter(grupocolor,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ColorProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresColorProductos(colorproductos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveGrupoColorRelacionesDetalles(List<ColorProducto> colorproductos)throws Exception {
		try {
	

			Long idGrupoColorActual=this.getGrupoColor().getId();

			ColorProductoLogic colorproductoLogic_Desde_GrupoColor=new ColorProductoLogic();
			colorproductoLogic_Desde_GrupoColor.setColorProductos(colorproductos);

			colorproductoLogic_Desde_GrupoColor.setConnexion(this.getConnexion());
			colorproductoLogic_Desde_GrupoColor.setDatosCliente(this.datosCliente);

			for(ColorProducto colorproducto_Desde_GrupoColor:colorproductoLogic_Desde_GrupoColor.getColorProductos()) {
				colorproducto_Desde_GrupoColor.setid_grupo_color(idGrupoColorActual);

				colorproductoLogic_Desde_GrupoColor.setColorProducto(colorproducto_Desde_GrupoColor);
				colorproductoLogic_Desde_GrupoColor.saveColorProducto();

				Long idColorProductoActual=colorproducto_Desde_GrupoColor.getId();

				ParametroInventarioDefectoLogic parametroinventariodefectoLogic_Desde_ColorProducto=new ParametroInventarioDefectoLogic();

				if(colorproducto_Desde_GrupoColor.getParametroInventarioDefectos()==null){
					colorproducto_Desde_GrupoColor.setParametroInventarioDefectos(new ArrayList<ParametroInventarioDefecto>());
				}

				parametroinventariodefectoLogic_Desde_ColorProducto.setParametroInventarioDefectos(colorproducto_Desde_GrupoColor.getParametroInventarioDefectos());

				parametroinventariodefectoLogic_Desde_ColorProducto.setConnexion(this.getConnexion());
				parametroinventariodefectoLogic_Desde_ColorProducto.setDatosCliente(this.datosCliente);

				for(ParametroInventarioDefecto parametroinventariodefecto_Desde_ColorProducto:parametroinventariodefectoLogic_Desde_ColorProducto.getParametroInventarioDefectos()) {
					parametroinventariodefecto_Desde_ColorProducto.setid_color_producto(idColorProductoActual);
				}

				parametroinventariodefectoLogic_Desde_ColorProducto.saveParametroInventarioDefectos();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfGrupoColor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GrupoColorConstantesFunciones.getClassesForeignKeysOfGrupoColor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoColor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GrupoColorConstantesFunciones.getClassesRelationshipsOfGrupoColor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

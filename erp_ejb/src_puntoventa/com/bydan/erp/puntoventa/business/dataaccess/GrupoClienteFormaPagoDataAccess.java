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
package com.bydan.erp.puntoventa.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//GrupoClienteFormaPagoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class GrupoClienteFormaPagoDataAccess extends  GrupoClienteFormaPagoDataAccessAdditional{ //GrupoClienteFormaPagoDataAccessAdditional,DataAccessHelper<GrupoClienteFormaPago>
	//static Logger logger = Logger.getLogger(GrupoClienteFormaPagoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="grupo_cliente_forma_pago";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_grupo_cliente,id_tipo_forma_pago)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_grupo_cliente=?,id_tipo_forma_pago=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select grupoclienteformapago from "+GrupoClienteFormaPagoConstantesFunciones.SPERSISTENCENAME+" grupoclienteformapago";
	public static String QUERYSELECTNATIVE="select "+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME+".id,"+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME+".version_row,"+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME+".id_empresa,"+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME+".id_grupo_cliente,"+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME+".id_tipo_forma_pago from "+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME;//+" as "+GrupoClienteFormaPagoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME+".id,"+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME+".version_row from "+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME;//+" as "+GrupoClienteFormaPagoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_grupo_cliente=?,id_tipo_forma_pago=?";
	
	public static String STOREPROCEDUREINSERT="call SP_GRUPOCLIENTEFORMAPAGO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_GRUPOCLIENTEFORMAPAGO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_GRUPOCLIENTEFORMAPAGO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_GRUPOCLIENTEFORMAPAGO_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected GrupoClienteFormaPagoDataAccessAdditional grupoclienteformapagoDataAccessAdditional=null;
	
	public GrupoClienteFormaPagoDataAccessAdditional getGrupoClienteFormaPagoDataAccessAdditional() {
		return this.grupoclienteformapagoDataAccessAdditional;
	}
	
	public void setGrupoClienteFormaPagoDataAccessAdditional(GrupoClienteFormaPagoDataAccessAdditional grupoclienteformapagoDataAccessAdditional) {
		try {
			this.grupoclienteformapagoDataAccessAdditional=grupoclienteformapagoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public GrupoClienteFormaPagoDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		GrupoClienteFormaPagoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		GrupoClienteFormaPagoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		GrupoClienteFormaPagoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
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

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setGrupoClienteFormaPagoOriginal(GrupoClienteFormaPago grupoclienteformapago)throws Exception  {
		grupoclienteformapago.setGrupoClienteFormaPagoOriginal((GrupoClienteFormaPago)grupoclienteformapago.clone());		
	}
	
	public void setGrupoClienteFormaPagosOriginal(List<GrupoClienteFormaPago> grupoclienteformapagos)throws Exception  {
		
		for(GrupoClienteFormaPago grupoclienteformapago:grupoclienteformapagos){
			grupoclienteformapago.setGrupoClienteFormaPagoOriginal((GrupoClienteFormaPago)grupoclienteformapago.clone());
		}
	}
	
	public static void setGrupoClienteFormaPagoOriginalStatic(GrupoClienteFormaPago grupoclienteformapago)throws Exception  {
		grupoclienteformapago.setGrupoClienteFormaPagoOriginal((GrupoClienteFormaPago)grupoclienteformapago.clone());		
	}
	
	public static void setGrupoClienteFormaPagosOriginalStatic(List<GrupoClienteFormaPago> grupoclienteformapagos)throws Exception  {
		
		for(GrupoClienteFormaPago grupoclienteformapago:grupoclienteformapagos){
			grupoclienteformapago.setGrupoClienteFormaPagoOriginal((GrupoClienteFormaPago)grupoclienteformapago.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  GrupoClienteFormaPago getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  GrupoClienteFormaPago getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=GrupoClienteFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GrupoClienteFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.GrupoClienteFormaPago.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setGrupoClienteFormaPagoOriginal(new GrupoClienteFormaPago());
      	    	entity=super.getEntity("",entity,resultSet,GrupoClienteFormaPagoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityGrupoClienteFormaPago("",entity,resultSet); 
				
				//entity.setGrupoClienteFormaPagoOriginal(super.getEntity("",entity.getGrupoClienteFormaPagoOriginal(),resultSet,GrupoClienteFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGrupoClienteFormaPagoOriginal(this.getEntityGrupoClienteFormaPago("",entity.getGrupoClienteFormaPagoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseGrupoClienteFormaPago(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  GrupoClienteFormaPago getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  GrupoClienteFormaPago getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=GrupoClienteFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GrupoClienteFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoClienteFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.GrupoClienteFormaPago.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setGrupoClienteFormaPagoOriginal(new GrupoClienteFormaPago());
      	    	entity=super.getEntity("",entity,resultSet,GrupoClienteFormaPagoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityGrupoClienteFormaPago("",entity,resultSet);    
				
				//entity.setGrupoClienteFormaPagoOriginal(super.getEntity("",entity.getGrupoClienteFormaPagoOriginal(),resultSet,GrupoClienteFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGrupoClienteFormaPagoOriginal(this.getEntityGrupoClienteFormaPago("",entity.getGrupoClienteFormaPagoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseGrupoClienteFormaPago(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //GrupoClienteFormaPago
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GrupoClienteFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GrupoClienteFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoClienteFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.GrupoClienteFormaPago.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalseGrupoClienteFormaPago(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<GrupoClienteFormaPago> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<GrupoClienteFormaPago> entities = new  ArrayList<GrupoClienteFormaPago>();
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<GrupoClienteFormaPago> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<GrupoClienteFormaPago> entities = new  ArrayList<GrupoClienteFormaPago>();
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=GrupoClienteFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GrupoClienteFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoClienteFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoClienteFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,GrupoClienteFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGrupoClienteFormaPago("",entity,resultSet);
      	    	
				//entity.setGrupoClienteFormaPagoOriginal( new GrupoClienteFormaPago());
      	    	//entity.setGrupoClienteFormaPagoOriginal(super.getEntity("",entity.getGrupoClienteFormaPagoOriginal(),resultSet,GrupoClienteFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGrupoClienteFormaPagoOriginal(this.getEntityGrupoClienteFormaPago("",entity.getGrupoClienteFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGrupoClienteFormaPagos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoClienteFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<GrupoClienteFormaPago> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<GrupoClienteFormaPago> entities = new  ArrayList<GrupoClienteFormaPago>();
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<GrupoClienteFormaPago> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<GrupoClienteFormaPago> entities = new  ArrayList<GrupoClienteFormaPago>();
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoClienteFormaPago();
				
				if(conMapGenerico) {
					entity.inicializarMapGrupoClienteFormaPago();
					//entity.setMapGrupoClienteFormaPago(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapGrupoClienteFormaPagoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapGrupoClienteFormaPago().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GrupoClienteFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=GrupoClienteFormaPagoDataAccess.getEntityGrupoClienteFormaPago("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setGrupoClienteFormaPagoOriginal( new GrupoClienteFormaPago());
					////entity.setGrupoClienteFormaPagoOriginal(super.getEntity("",entity.getGrupoClienteFormaPagoOriginal(),resultSet,GrupoClienteFormaPagoDataAccess.ISWITHSCHEMA));         		
					////entity.setGrupoClienteFormaPagoOriginal(this.getEntityGrupoClienteFormaPago("",entity.getGrupoClienteFormaPagoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGrupoClienteFormaPagos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoClienteFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public GrupoClienteFormaPago getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  GrupoClienteFormaPago getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoClienteFormaPago();
				
				if(conMapGenerico) {
					entity.inicializarMapGrupoClienteFormaPago();
					//entity.setMapGrupoClienteFormaPago(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapGrupoClienteFormaPagoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapGrupoClienteFormaPago().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GrupoClienteFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=GrupoClienteFormaPagoDataAccess.getEntityGrupoClienteFormaPago("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setGrupoClienteFormaPagoOriginal( new GrupoClienteFormaPago());
					////entity.setGrupoClienteFormaPagoOriginal(super.getEntity("",entity.getGrupoClienteFormaPagoOriginal(),resultSet,GrupoClienteFormaPagoDataAccess.ISWITHSCHEMA));         		
					////entity.setGrupoClienteFormaPagoOriginal(this.getEntityGrupoClienteFormaPago("",entity.getGrupoClienteFormaPagoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseGrupoClienteFormaPago(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoClienteFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static GrupoClienteFormaPago getEntityGrupoClienteFormaPago(String strPrefijo,GrupoClienteFormaPago entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = GrupoClienteFormaPago.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = GrupoClienteFormaPago.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					GrupoClienteFormaPagoDataAccess.setFieldReflectionGrupoClienteFormaPago(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasGrupoClienteFormaPago=GrupoClienteFormaPagoConstantesFunciones.getTodosTiposColumnasGrupoClienteFormaPago();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasGrupoClienteFormaPago) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = GrupoClienteFormaPago.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = GrupoClienteFormaPago.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						GrupoClienteFormaPagoDataAccess.setFieldReflectionGrupoClienteFormaPago(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionGrupoClienteFormaPago(Field field,String strPrefijo,String sColumn,GrupoClienteFormaPago entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case GrupoClienteFormaPagoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoClienteFormaPagoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GrupoClienteFormaPagoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoClienteFormaPagoConstantesFunciones.IDGRUPOCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoClienteFormaPagoConstantesFunciones.IDTIPOFORMAPAGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<GrupoClienteFormaPago>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<GrupoClienteFormaPago> entities = new  ArrayList<GrupoClienteFormaPago>();
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GrupoClienteFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GrupoClienteFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoClienteFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new GrupoClienteFormaPago();
					entity=super.getEntity("",entity,resultSet,GrupoClienteFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityGrupoClienteFormaPago("",entity,resultSet);
					
					//entity.setGrupoClienteFormaPagoOriginal( new GrupoClienteFormaPago());
					//entity.setGrupoClienteFormaPagoOriginal(super.getEntity("",entity.getGrupoClienteFormaPagoOriginal(),resultSet,GrupoClienteFormaPagoDataAccess.ISWITHSCHEMA));         		
					//entity.setGrupoClienteFormaPagoOriginal(this.getEntityGrupoClienteFormaPago("",entity.getGrupoClienteFormaPagoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseGrupoClienteFormaPagos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoClienteFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<GrupoClienteFormaPago>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<GrupoClienteFormaPago> entities = new  ArrayList<GrupoClienteFormaPago>();
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GrupoClienteFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GrupoClienteFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoClienteFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<GrupoClienteFormaPago> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GrupoClienteFormaPago> entities = new  ArrayList<GrupoClienteFormaPago>();
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<GrupoClienteFormaPago> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GrupoClienteFormaPago> entities = new  ArrayList<GrupoClienteFormaPago>();
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoClienteFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,GrupoClienteFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGrupoClienteFormaPago("",entity,resultSet);
      	    	
				//entity.setGrupoClienteFormaPagoOriginal( new GrupoClienteFormaPago());
      	    	//entity.setGrupoClienteFormaPagoOriginal(super.getEntity("",entity.getGrupoClienteFormaPagoOriginal(),resultSet,GrupoClienteFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGrupoClienteFormaPagoOriginal(this.getEntityGrupoClienteFormaPago("",entity.getGrupoClienteFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseGrupoClienteFormaPagos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoClienteFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<GrupoClienteFormaPago> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GrupoClienteFormaPago> entities = new  ArrayList<GrupoClienteFormaPago>();
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<GrupoClienteFormaPago> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GrupoClienteFormaPago> entities = new  ArrayList<GrupoClienteFormaPago>();
		GrupoClienteFormaPago entity = new GrupoClienteFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoClienteFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,GrupoClienteFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGrupoClienteFormaPago("",entity,resultSet);
      	    	
				//entity.setGrupoClienteFormaPagoOriginal( new GrupoClienteFormaPago());
      	    	//entity.setGrupoClienteFormaPagoOriginal(super.getEntity("",entity.getGrupoClienteFormaPagoOriginal(),resultSet,GrupoClienteFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGrupoClienteFormaPagoOriginal(this.getEntityGrupoClienteFormaPago("",entity.getGrupoClienteFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGrupoClienteFormaPagos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public GrupoClienteFormaPago getEntityGrupoClienteFormaPago(String strPrefijo,GrupoClienteFormaPago entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+GrupoClienteFormaPagoConstantesFunciones.IDEMPRESA));
				entity.setid_grupo_cliente(resultSet.getLong(strPrefijo+GrupoClienteFormaPagoConstantesFunciones.IDGRUPOCLIENTE));
				entity.setid_tipo_forma_pago(resultSet.getLong(strPrefijo+GrupoClienteFormaPagoConstantesFunciones.IDTIPOFORMAPAGO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowGrupoClienteFormaPago(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(GrupoClienteFormaPago entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=GrupoClienteFormaPagoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=GrupoClienteFormaPagoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=GrupoClienteFormaPagoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=GrupoClienteFormaPagoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(GrupoClienteFormaPagoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,GrupoClienteFormaPagoDataAccess.TABLENAME,GrupoClienteFormaPagoDataAccess.ISWITHSTOREPROCEDURES);
			
			GrupoClienteFormaPagoDataAccess.setGrupoClienteFormaPagoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,GrupoClienteFormaPago relgrupoclienteformapago)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relgrupoclienteformapago.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public GrupoCliente getGrupoCliente(Connexion connexion,GrupoClienteFormaPago relgrupoclienteformapago)throws SQLException,Exception {

		GrupoCliente grupocliente= new GrupoCliente();

		try {
			GrupoClienteDataAccess grupoclienteDataAccess=new GrupoClienteDataAccess();

			grupoclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupoclienteDataAccess.setConnexionType(this.connexionType);
			grupoclienteDataAccess.setParameterDbType(this.parameterDbType);

			grupocliente=grupoclienteDataAccess.getEntity(connexion,relgrupoclienteformapago.getid_grupo_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupocliente;

	}

	public TipoFormaPago getTipoFormaPago(Connexion connexion,GrupoClienteFormaPago relgrupoclienteformapago)throws SQLException,Exception {

		TipoFormaPago tipoformapago= new TipoFormaPago();

		try {
			TipoFormaPagoDataAccess tipoformapagoDataAccess=new TipoFormaPagoDataAccess();

			tipoformapagoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoformapagoDataAccess.setConnexionType(this.connexionType);
			tipoformapagoDataAccess.setParameterDbType(this.parameterDbType);

			tipoformapago=tipoformapagoDataAccess.getEntity(connexion,relgrupoclienteformapago.getid_tipo_forma_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoformapago;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,GrupoClienteFormaPago grupoclienteformapago) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!grupoclienteformapago.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(grupoclienteformapago.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_grupo_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_grupo_cliente.setValue(grupoclienteformapago.getid_grupo_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_grupo_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_forma_pago=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_forma_pago.setValue(grupoclienteformapago.getid_tipo_forma_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_forma_pago);
					parametersTemp.add(parameterMaintenance);
					
						if(!grupoclienteformapago.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(grupoclienteformapago.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(grupoclienteformapago.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(grupoclienteformapago.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalseGrupoClienteFormaPago(GrupoClienteFormaPago grupoclienteformapago)throws Exception  {		
		grupoclienteformapago.setIsNew(false);
		grupoclienteformapago.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseGrupoClienteFormaPagos(List<GrupoClienteFormaPago> grupoclienteformapagos)throws Exception  {				
		for(GrupoClienteFormaPago grupoclienteformapago:grupoclienteformapagos) {
			grupoclienteformapago.setIsNew(false);
			grupoclienteformapago.setIsChanged(false);
		}
	}
	
	public void generarExportarGrupoClienteFormaPago(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   

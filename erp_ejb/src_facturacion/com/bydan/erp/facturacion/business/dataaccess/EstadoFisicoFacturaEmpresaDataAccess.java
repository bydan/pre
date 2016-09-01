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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//EstadoFisicoFacturaEmpresaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class EstadoFisicoFacturaEmpresaDataAccess extends  EstadoFisicoFacturaEmpresaDataAccessAdditional{ //EstadoFisicoFacturaEmpresaDataAccessAdditional,DataAccessHelper<EstadoFisicoFacturaEmpresa>
	//static Logger logger = Logger.getLogger(EstadoFisicoFacturaEmpresaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_fisico_factura_empresa";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre,es_pendiente)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,es_pendiente=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadofisicofacturaempresa from "+EstadoFisicoFacturaEmpresaConstantesFunciones.SPERSISTENCENAME+" estadofisicofacturaempresa";
	public static String QUERYSELECTNATIVE="select "+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+".id,"+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+".version_row,"+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+".codigo,"+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+".nombre,"+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+".es_pendiente from "+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME;//+" as "+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+".id,"+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+".version_row,"+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+".codigo from "+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME;//+" as "+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,es_pendiente=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOFISICOFACTURAEMPRESA_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOFISICOFACTURAEMPRESA_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOFISICOFACTURAEMPRESA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOFISICOFACTURAEMPRESA_SELECT(?,?)";
	
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
	
	
	protected EstadoFisicoFacturaEmpresaDataAccessAdditional estadofisicofacturaempresaDataAccessAdditional=null;
	
	public EstadoFisicoFacturaEmpresaDataAccessAdditional getEstadoFisicoFacturaEmpresaDataAccessAdditional() {
		return this.estadofisicofacturaempresaDataAccessAdditional;
	}
	
	public void setEstadoFisicoFacturaEmpresaDataAccessAdditional(EstadoFisicoFacturaEmpresaDataAccessAdditional estadofisicofacturaempresaDataAccessAdditional) {
		try {
			this.estadofisicofacturaempresaDataAccessAdditional=estadofisicofacturaempresaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EstadoFisicoFacturaEmpresaDataAccess() {
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
		EstadoFisicoFacturaEmpresaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoFisicoFacturaEmpresaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoFisicoFacturaEmpresaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoFisicoFacturaEmpresaOriginal(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa)throws Exception  {
		estadofisicofacturaempresa.setEstadoFisicoFacturaEmpresaOriginal((EstadoFisicoFacturaEmpresa)estadofisicofacturaempresa.clone());		
	}
	
	public void setEstadoFisicoFacturaEmpresasOriginal(List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresas)throws Exception  {
		
		for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa:estadofisicofacturaempresas){
			estadofisicofacturaempresa.setEstadoFisicoFacturaEmpresaOriginal((EstadoFisicoFacturaEmpresa)estadofisicofacturaempresa.clone());
		}
	}
	
	public static void setEstadoFisicoFacturaEmpresaOriginalStatic(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa)throws Exception  {
		estadofisicofacturaempresa.setEstadoFisicoFacturaEmpresaOriginal((EstadoFisicoFacturaEmpresa)estadofisicofacturaempresa.clone());		
	}
	
	public static void setEstadoFisicoFacturaEmpresasOriginalStatic(List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresas)throws Exception  {
		
		for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa:estadofisicofacturaempresas){
			estadofisicofacturaempresa.setEstadoFisicoFacturaEmpresaOriginal((EstadoFisicoFacturaEmpresa)estadofisicofacturaempresa.clone());
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
	
	public  EstadoFisicoFacturaEmpresa getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();		
		
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
	
	public  EstadoFisicoFacturaEmpresa getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoFisicoFacturaEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoFisicoFacturaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.EstadoFisicoFacturaEmpresa.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoFisicoFacturaEmpresaOriginal(new EstadoFisicoFacturaEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoFisicoFacturaEmpresa("",entity,resultSet); 
				
				//entity.setEstadoFisicoFacturaEmpresaOriginal(super.getEntity("",entity.getEstadoFisicoFacturaEmpresaOriginal(),resultSet,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoFisicoFacturaEmpresaOriginal(this.getEntityEstadoFisicoFacturaEmpresa("",entity.getEstadoFisicoFacturaEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoFisicoFacturaEmpresa(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoFisicoFacturaEmpresa getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();
				
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
	
	public  EstadoFisicoFacturaEmpresa getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoFisicoFacturaEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoFisicoFacturaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoFisicoFacturaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.EstadoFisicoFacturaEmpresa.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoFisicoFacturaEmpresaOriginal(new EstadoFisicoFacturaEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoFisicoFacturaEmpresa("",entity,resultSet);    
				
				//entity.setEstadoFisicoFacturaEmpresaOriginal(super.getEntity("",entity.getEstadoFisicoFacturaEmpresaOriginal(),resultSet,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoFisicoFacturaEmpresaOriginal(this.getEntityEstadoFisicoFacturaEmpresa("",entity.getEstadoFisicoFacturaEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoFisicoFacturaEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoFisicoFacturaEmpresa
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoFisicoFacturaEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoFisicoFacturaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoFisicoFacturaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.EstadoFisicoFacturaEmpresa.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoFisicoFacturaEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoFisicoFacturaEmpresa> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoFisicoFacturaEmpresa> entities = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();		  
		
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
	
	public  List<EstadoFisicoFacturaEmpresa> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoFisicoFacturaEmpresa> entities = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoFisicoFacturaEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoFisicoFacturaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoFisicoFacturaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoFisicoFacturaEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoFisicoFacturaEmpresa("",entity,resultSet);
      	    	
				//entity.setEstadoFisicoFacturaEmpresaOriginal( new EstadoFisicoFacturaEmpresa());
      	    	//entity.setEstadoFisicoFacturaEmpresaOriginal(super.getEntity("",entity.getEstadoFisicoFacturaEmpresaOriginal(),resultSet,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoFisicoFacturaEmpresaOriginal(this.getEntityEstadoFisicoFacturaEmpresa("",entity.getEstadoFisicoFacturaEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoFisicoFacturaEmpresas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoFisicoFacturaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoFisicoFacturaEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoFisicoFacturaEmpresa> entities = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();		  
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
	
	public  List<EstadoFisicoFacturaEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoFisicoFacturaEmpresa> entities = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoFisicoFacturaEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoFisicoFacturaEmpresa();
					//entity.setMapEstadoFisicoFacturaEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoFisicoFacturaEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoFisicoFacturaEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=EstadoFisicoFacturaEmpresaDataAccess.getEntityEstadoFisicoFacturaEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoFisicoFacturaEmpresaOriginal( new EstadoFisicoFacturaEmpresa());
					////entity.setEstadoFisicoFacturaEmpresaOriginal(super.getEntity("",entity.getEstadoFisicoFacturaEmpresaOriginal(),resultSet,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoFisicoFacturaEmpresaOriginal(this.getEntityEstadoFisicoFacturaEmpresa("",entity.getEstadoFisicoFacturaEmpresaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoFisicoFacturaEmpresas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoFisicoFacturaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoFisicoFacturaEmpresa getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();		  
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
	
	public  EstadoFisicoFacturaEmpresa getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoFisicoFacturaEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoFisicoFacturaEmpresa();
					//entity.setMapEstadoFisicoFacturaEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoFisicoFacturaEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoFisicoFacturaEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=EstadoFisicoFacturaEmpresaDataAccess.getEntityEstadoFisicoFacturaEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoFisicoFacturaEmpresaOriginal( new EstadoFisicoFacturaEmpresa());
					////entity.setEstadoFisicoFacturaEmpresaOriginal(super.getEntity("",entity.getEstadoFisicoFacturaEmpresaOriginal(),resultSet,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoFisicoFacturaEmpresaOriginal(this.getEntityEstadoFisicoFacturaEmpresa("",entity.getEstadoFisicoFacturaEmpresaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoFisicoFacturaEmpresa(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoFisicoFacturaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoFisicoFacturaEmpresa getEntityEstadoFisicoFacturaEmpresa(String strPrefijo,EstadoFisicoFacturaEmpresa entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoFisicoFacturaEmpresa.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoFisicoFacturaEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoFisicoFacturaEmpresaDataAccess.setFieldReflectionEstadoFisicoFacturaEmpresa(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoFisicoFacturaEmpresa=EstadoFisicoFacturaEmpresaConstantesFunciones.getTodosTiposColumnasEstadoFisicoFacturaEmpresa();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoFisicoFacturaEmpresa) {
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
							field = EstadoFisicoFacturaEmpresa.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoFisicoFacturaEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoFisicoFacturaEmpresaDataAccess.setFieldReflectionEstadoFisicoFacturaEmpresa(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoFisicoFacturaEmpresa(Field field,String strPrefijo,String sColumn,EstadoFisicoFacturaEmpresa entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoFisicoFacturaEmpresaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoFisicoFacturaEmpresaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoFisicoFacturaEmpresaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoFisicoFacturaEmpresaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoFisicoFacturaEmpresaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoFisicoFacturaEmpresaConstantesFunciones.ESPENDIENTE:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoFisicoFacturaEmpresa>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoFisicoFacturaEmpresa> entities = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoFisicoFacturaEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoFisicoFacturaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoFisicoFacturaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoFisicoFacturaEmpresa();
					entity=super.getEntity("",entity,resultSet,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoFisicoFacturaEmpresa("",entity,resultSet);
					
					//entity.setEstadoFisicoFacturaEmpresaOriginal( new EstadoFisicoFacturaEmpresa());
					//entity.setEstadoFisicoFacturaEmpresaOriginal(super.getEntity("",entity.getEstadoFisicoFacturaEmpresaOriginal(),resultSet,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoFisicoFacturaEmpresaOriginal(this.getEntityEstadoFisicoFacturaEmpresa("",entity.getEstadoFisicoFacturaEmpresaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoFisicoFacturaEmpresas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoFisicoFacturaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoFisicoFacturaEmpresa>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoFisicoFacturaEmpresa> entities = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoFisicoFacturaEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoFisicoFacturaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoFisicoFacturaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoFisicoFacturaEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoFisicoFacturaEmpresa> entities = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();		  
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
	
	public  List<EstadoFisicoFacturaEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoFisicoFacturaEmpresa> entities = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoFisicoFacturaEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoFisicoFacturaEmpresa("",entity,resultSet);
      	    	
				//entity.setEstadoFisicoFacturaEmpresaOriginal( new EstadoFisicoFacturaEmpresa());
      	    	//entity.setEstadoFisicoFacturaEmpresaOriginal(super.getEntity("",entity.getEstadoFisicoFacturaEmpresaOriginal(),resultSet,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoFisicoFacturaEmpresaOriginal(this.getEntityEstadoFisicoFacturaEmpresa("",entity.getEstadoFisicoFacturaEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoFisicoFacturaEmpresas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoFisicoFacturaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoFisicoFacturaEmpresa> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoFisicoFacturaEmpresa> entities = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();		  
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
	
	public  List<EstadoFisicoFacturaEmpresa> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoFisicoFacturaEmpresa> entities = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		EstadoFisicoFacturaEmpresa entity = new EstadoFisicoFacturaEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoFisicoFacturaEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoFisicoFacturaEmpresa("",entity,resultSet);
      	    	
				//entity.setEstadoFisicoFacturaEmpresaOriginal( new EstadoFisicoFacturaEmpresa());
      	    	//entity.setEstadoFisicoFacturaEmpresaOriginal(super.getEntity("",entity.getEstadoFisicoFacturaEmpresaOriginal(),resultSet,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoFisicoFacturaEmpresaOriginal(this.getEntityEstadoFisicoFacturaEmpresa("",entity.getEstadoFisicoFacturaEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoFisicoFacturaEmpresas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EstadoFisicoFacturaEmpresa getEntityEstadoFisicoFacturaEmpresa(String strPrefijo,EstadoFisicoFacturaEmpresa entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EstadoFisicoFacturaEmpresaConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoFisicoFacturaEmpresaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoFisicoFacturaEmpresaConstantesFunciones.NOMBRE));
				entity.setes_pendiente(resultSet.getBoolean(strPrefijo+EstadoFisicoFacturaEmpresaConstantesFunciones.ESPENDIENTE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoFisicoFacturaEmpresaConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoFisicoFacturaEmpresa(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoFisicoFacturaEmpresa entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoFisicoFacturaEmpresaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoFisicoFacturaEmpresaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoFisicoFacturaEmpresaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoFisicoFacturaEmpresaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoFisicoFacturaEmpresaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoFisicoFacturaEmpresaDataAccess.TABLENAME,EstadoFisicoFacturaEmpresaDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoFisicoFacturaEmpresaDataAccess.setEstadoFisicoFacturaEmpresaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,EstadoFisicoFacturaEmpresa relestadofisicofacturaempresa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relestadofisicofacturaempresa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<Factura> getFacturas(Connexion connexion,EstadoFisicoFacturaEmpresa estadofisicofacturaempresa)throws SQLException,Exception {

		List<Factura> facturas= new ArrayList<Factura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+".estado_fisico_factura_empresa ON "+FacturaConstantesFunciones.SCHEMA+".factura.id_estado_fisico_factura_empresa="+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+".estado_fisico_factura_empresa.id WHERE "+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+".estado_fisico_factura_empresa.id="+String.valueOf(estadofisicofacturaempresa.getId());
			} else {
				sQuery=" INNER JOIN factura.EstadoFisicoFacturaEmpresa WHERE factura.EstadoFisicoFacturaEmpresa.id="+String.valueOf(estadofisicofacturaempresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);
			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoFisicoFacturaEmpresa estadofisicofacturaempresa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadofisicofacturaempresa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(estadofisicofacturaempresa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadofisicofacturaempresa.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadofisicofacturaempresa.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_pendiente=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_pendiente.setValue(estadofisicofacturaempresa.getes_pendiente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_pendiente);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadofisicofacturaempresa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadofisicofacturaempresa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadofisicofacturaempresa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadofisicofacturaempresa.getId());
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
	
	public void setIsNewIsChangedFalseEstadoFisicoFacturaEmpresa(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa)throws Exception  {		
		estadofisicofacturaempresa.setIsNew(false);
		estadofisicofacturaempresa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoFisicoFacturaEmpresas(List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresas)throws Exception  {				
		for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa:estadofisicofacturaempresas) {
			estadofisicofacturaempresa.setIsNew(false);
			estadofisicofacturaempresa.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoFisicoFacturaEmpresa(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   

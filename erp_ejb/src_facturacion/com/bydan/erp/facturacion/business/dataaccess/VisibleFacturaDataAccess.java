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
import com.bydan.erp.facturacion.util.*;//VisibleFacturaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class VisibleFacturaDataAccess extends  VisibleFacturaDataAccessAdditional{ //VisibleFacturaDataAccessAdditional,DataAccessHelper<VisibleFactura>
	//static Logger logger = Logger.getLogger(VisibleFacturaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="visible_factura";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+"(version_row,id_empresa,cabe_consignatario,cabe_tipo_tasa,cabe_consultor,cabe_ice,cabe_transporte,cabe_fue,cabe_orden,deta_autori_precio,deta_area,deta_foto)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,cabe_consignatario=?,cabe_tipo_tasa=?,cabe_consultor=?,cabe_ice=?,cabe_transporte=?,cabe_fue=?,cabe_orden=?,deta_autori_precio=?,deta_area=?,deta_foto=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select visiblefactura from "+VisibleFacturaConstantesFunciones.SPERSISTENCENAME+" visiblefactura";
	public static String QUERYSELECTNATIVE="select "+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".id,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".version_row,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".id_empresa,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".cabe_consignatario,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".cabe_tipo_tasa,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".cabe_consultor,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".cabe_ice,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".cabe_transporte,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".cabe_fue,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".cabe_orden,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".deta_autori_precio,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".deta_area,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".deta_foto from "+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME;//+" as "+VisibleFacturaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".id,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".version_row from "+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME;//+" as "+VisibleFacturaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,cabe_consignatario=?,cabe_tipo_tasa=?,cabe_consultor=?,cabe_ice=?,cabe_transporte=?,cabe_fue=?,cabe_orden=?,deta_autori_precio=?,deta_area=?,deta_foto=?";
	
	public static String STOREPROCEDUREINSERT="call SP_VISIBLEFACTURA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_VISIBLEFACTURA_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_VISIBLEFACTURA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_VISIBLEFACTURA_SELECT(?,?)";
	
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
	
	
	protected VisibleFacturaDataAccessAdditional visiblefacturaDataAccessAdditional=null;
	
	public VisibleFacturaDataAccessAdditional getVisibleFacturaDataAccessAdditional() {
		return this.visiblefacturaDataAccessAdditional;
	}
	
	public void setVisibleFacturaDataAccessAdditional(VisibleFacturaDataAccessAdditional visiblefacturaDataAccessAdditional) {
		try {
			this.visiblefacturaDataAccessAdditional=visiblefacturaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public VisibleFacturaDataAccess() {
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
		VisibleFacturaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		VisibleFacturaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		VisibleFacturaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setVisibleFacturaOriginal(VisibleFactura visiblefactura)throws Exception  {
		visiblefactura.setVisibleFacturaOriginal((VisibleFactura)visiblefactura.clone());		
	}
	
	public void setVisibleFacturasOriginal(List<VisibleFactura> visiblefacturas)throws Exception  {
		
		for(VisibleFactura visiblefactura:visiblefacturas){
			visiblefactura.setVisibleFacturaOriginal((VisibleFactura)visiblefactura.clone());
		}
	}
	
	public static void setVisibleFacturaOriginalStatic(VisibleFactura visiblefactura)throws Exception  {
		visiblefactura.setVisibleFacturaOriginal((VisibleFactura)visiblefactura.clone());		
	}
	
	public static void setVisibleFacturasOriginalStatic(List<VisibleFactura> visiblefacturas)throws Exception  {
		
		for(VisibleFactura visiblefactura:visiblefacturas){
			visiblefactura.setVisibleFacturaOriginal((VisibleFactura)visiblefactura.clone());
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
	
	public  VisibleFactura getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		VisibleFactura entity = new VisibleFactura();		
		
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
	
	public  VisibleFactura getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		VisibleFactura entity = new VisibleFactura();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=VisibleFacturaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VisibleFacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.VisibleFactura.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setVisibleFacturaOriginal(new VisibleFactura());
      	    	entity=super.getEntity("",entity,resultSet,VisibleFacturaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityVisibleFactura("",entity,resultSet); 
				
				//entity.setVisibleFacturaOriginal(super.getEntity("",entity.getVisibleFacturaOriginal(),resultSet,VisibleFacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVisibleFacturaOriginal(this.getEntityVisibleFactura("",entity.getVisibleFacturaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseVisibleFactura(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  VisibleFactura getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		VisibleFactura entity = new VisibleFactura();
				
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
	
	public  VisibleFactura getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		VisibleFactura entity = new VisibleFactura();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=VisibleFacturaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VisibleFacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VisibleFacturaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.VisibleFactura.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setVisibleFacturaOriginal(new VisibleFactura());
      	    	entity=super.getEntity("",entity,resultSet,VisibleFacturaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityVisibleFactura("",entity,resultSet);    
				
				//entity.setVisibleFacturaOriginal(super.getEntity("",entity.getVisibleFacturaOriginal(),resultSet,VisibleFacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVisibleFacturaOriginal(this.getEntityVisibleFactura("",entity.getVisibleFacturaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseVisibleFactura(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //VisibleFactura
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		VisibleFactura entity = new VisibleFactura();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VisibleFacturaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VisibleFacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VisibleFacturaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.VisibleFactura.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseVisibleFactura(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<VisibleFactura> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<VisibleFactura> entities = new  ArrayList<VisibleFactura>();
		VisibleFactura entity = new VisibleFactura();		  
		
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
	
	public  List<VisibleFactura> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<VisibleFactura> entities = new  ArrayList<VisibleFactura>();
		VisibleFactura entity = new VisibleFactura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=VisibleFacturaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VisibleFacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VisibleFacturaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VisibleFactura();
      	    	entity=super.getEntity("",entity,resultSet,VisibleFacturaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVisibleFactura("",entity,resultSet);
      	    	
				//entity.setVisibleFacturaOriginal( new VisibleFactura());
      	    	//entity.setVisibleFacturaOriginal(super.getEntity("",entity.getVisibleFacturaOriginal(),resultSet,VisibleFacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVisibleFacturaOriginal(this.getEntityVisibleFactura("",entity.getVisibleFacturaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVisibleFacturas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVisibleFactura(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<VisibleFactura> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<VisibleFactura> entities = new  ArrayList<VisibleFactura>();
		VisibleFactura entity = new VisibleFactura();		  
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
	
	public  List<VisibleFactura> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<VisibleFactura> entities = new  ArrayList<VisibleFactura>();
		VisibleFactura entity = new VisibleFactura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VisibleFactura();
				
				if(conMapGenerico) {
					entity.inicializarMapVisibleFactura();
					//entity.setMapVisibleFactura(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapVisibleFacturaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapVisibleFactura().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VisibleFacturaDataAccess.ISWITHSCHEMA);         		
					entity=VisibleFacturaDataAccess.getEntityVisibleFactura("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setVisibleFacturaOriginal( new VisibleFactura());
					////entity.setVisibleFacturaOriginal(super.getEntity("",entity.getVisibleFacturaOriginal(),resultSet,VisibleFacturaDataAccess.ISWITHSCHEMA));         		
					////entity.setVisibleFacturaOriginal(this.getEntityVisibleFactura("",entity.getVisibleFacturaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVisibleFacturas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVisibleFactura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public VisibleFactura getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		VisibleFactura entity = new VisibleFactura();		  
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
	
	public  VisibleFactura getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		VisibleFactura entity = new VisibleFactura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VisibleFactura();
				
				if(conMapGenerico) {
					entity.inicializarMapVisibleFactura();
					//entity.setMapVisibleFactura(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapVisibleFacturaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapVisibleFactura().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VisibleFacturaDataAccess.ISWITHSCHEMA);         		
					entity=VisibleFacturaDataAccess.getEntityVisibleFactura("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setVisibleFacturaOriginal( new VisibleFactura());
					////entity.setVisibleFacturaOriginal(super.getEntity("",entity.getVisibleFacturaOriginal(),resultSet,VisibleFacturaDataAccess.ISWITHSCHEMA));         		
					////entity.setVisibleFacturaOriginal(this.getEntityVisibleFactura("",entity.getVisibleFacturaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseVisibleFactura(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVisibleFactura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static VisibleFactura getEntityVisibleFactura(String strPrefijo,VisibleFactura entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = VisibleFactura.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = VisibleFactura.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					VisibleFacturaDataAccess.setFieldReflectionVisibleFactura(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasVisibleFactura=VisibleFacturaConstantesFunciones.getTodosTiposColumnasVisibleFactura();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasVisibleFactura) {
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
							field = VisibleFactura.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = VisibleFactura.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						VisibleFacturaDataAccess.setFieldReflectionVisibleFactura(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionVisibleFactura(Field field,String strPrefijo,String sColumn,VisibleFactura entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case VisibleFacturaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VisibleFacturaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VisibleFacturaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VisibleFacturaConstantesFunciones.CABECONSIGNATARIO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case VisibleFacturaConstantesFunciones.CABETIPOTASA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case VisibleFacturaConstantesFunciones.CABECONSULTOR:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case VisibleFacturaConstantesFunciones.CABEICE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case VisibleFacturaConstantesFunciones.CABETRANSPORTE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case VisibleFacturaConstantesFunciones.CABEFUE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case VisibleFacturaConstantesFunciones.CABEORDEN:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case VisibleFacturaConstantesFunciones.DETAAUTORIPRECIO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case VisibleFacturaConstantesFunciones.DETAAREA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case VisibleFacturaConstantesFunciones.DETAFOTO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<VisibleFactura>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<VisibleFactura> entities = new  ArrayList<VisibleFactura>();
		VisibleFactura entity = new VisibleFactura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VisibleFacturaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VisibleFacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VisibleFacturaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new VisibleFactura();
					entity=super.getEntity("",entity,resultSet,VisibleFacturaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityVisibleFactura("",entity,resultSet);
					
					//entity.setVisibleFacturaOriginal( new VisibleFactura());
					//entity.setVisibleFacturaOriginal(super.getEntity("",entity.getVisibleFacturaOriginal(),resultSet,VisibleFacturaDataAccess.ISWITHSCHEMA));         		
					//entity.setVisibleFacturaOriginal(this.getEntityVisibleFactura("",entity.getVisibleFacturaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseVisibleFacturas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVisibleFactura(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<VisibleFactura>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<VisibleFactura> entities = new  ArrayList<VisibleFactura>();
		VisibleFactura entity = new VisibleFactura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VisibleFacturaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VisibleFacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VisibleFacturaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<VisibleFactura> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VisibleFactura> entities = new  ArrayList<VisibleFactura>();
		VisibleFactura entity = new VisibleFactura();		  
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
	
	public  List<VisibleFactura> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VisibleFactura> entities = new  ArrayList<VisibleFactura>();
		VisibleFactura entity = new VisibleFactura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VisibleFactura();
      	    	entity=super.getEntity("",entity,resultSet,VisibleFacturaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVisibleFactura("",entity,resultSet);
      	    	
				//entity.setVisibleFacturaOriginal( new VisibleFactura());
      	    	//entity.setVisibleFacturaOriginal(super.getEntity("",entity.getVisibleFacturaOriginal(),resultSet,VisibleFacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVisibleFacturaOriginal(this.getEntityVisibleFactura("",entity.getVisibleFacturaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseVisibleFacturas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVisibleFactura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<VisibleFactura> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VisibleFactura> entities = new  ArrayList<VisibleFactura>();
		VisibleFactura entity = new VisibleFactura();		  
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
	
	public  List<VisibleFactura> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VisibleFactura> entities = new  ArrayList<VisibleFactura>();
		VisibleFactura entity = new VisibleFactura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VisibleFactura();
      	    	entity=super.getEntity("",entity,resultSet,VisibleFacturaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVisibleFactura("",entity,resultSet);
      	    	
				//entity.setVisibleFacturaOriginal( new VisibleFactura());
      	    	//entity.setVisibleFacturaOriginal(super.getEntity("",entity.getVisibleFacturaOriginal(),resultSet,VisibleFacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVisibleFacturaOriginal(this.getEntityVisibleFactura("",entity.getVisibleFacturaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVisibleFacturas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public VisibleFactura getEntityVisibleFactura(String strPrefijo,VisibleFactura entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+VisibleFacturaConstantesFunciones.IDEMPRESA));
				entity.setcabe_consignatario(resultSet.getBoolean(strPrefijo+VisibleFacturaConstantesFunciones.CABECONSIGNATARIO));
				entity.setcabe_tipo_tasa(resultSet.getBoolean(strPrefijo+VisibleFacturaConstantesFunciones.CABETIPOTASA));
				entity.setcabe_consultor(resultSet.getBoolean(strPrefijo+VisibleFacturaConstantesFunciones.CABECONSULTOR));
				entity.setcabe_ice(resultSet.getBoolean(strPrefijo+VisibleFacturaConstantesFunciones.CABEICE));
				entity.setcabe_transporte(resultSet.getBoolean(strPrefijo+VisibleFacturaConstantesFunciones.CABETRANSPORTE));
				entity.setcabe_fue(resultSet.getBoolean(strPrefijo+VisibleFacturaConstantesFunciones.CABEFUE));
				entity.setcabe_orden(resultSet.getBoolean(strPrefijo+VisibleFacturaConstantesFunciones.CABEORDEN));
				entity.setdeta_autori_precio(resultSet.getBoolean(strPrefijo+VisibleFacturaConstantesFunciones.DETAAUTORIPRECIO));
				entity.setdeta_area(resultSet.getBoolean(strPrefijo+VisibleFacturaConstantesFunciones.DETAAREA));
				entity.setdeta_foto(resultSet.getBoolean(strPrefijo+VisibleFacturaConstantesFunciones.DETAFOTO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowVisibleFactura(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(VisibleFactura entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=VisibleFacturaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=VisibleFacturaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=VisibleFacturaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=VisibleFacturaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(VisibleFacturaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,VisibleFacturaDataAccess.TABLENAME,VisibleFacturaDataAccess.ISWITHSTOREPROCEDURES);
			
			VisibleFacturaDataAccess.setVisibleFacturaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,VisibleFactura relvisiblefactura)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relvisiblefactura.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,VisibleFactura visiblefactura) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!visiblefactura.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(visiblefactura.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecabe_consignatario=new ParameterValue<Boolean>();
					parameterMaintenanceValuecabe_consignatario.setValue(visiblefactura.getcabe_consignatario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecabe_consignatario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecabe_tipo_tasa=new ParameterValue<Boolean>();
					parameterMaintenanceValuecabe_tipo_tasa.setValue(visiblefactura.getcabe_tipo_tasa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecabe_tipo_tasa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecabe_consultor=new ParameterValue<Boolean>();
					parameterMaintenanceValuecabe_consultor.setValue(visiblefactura.getcabe_consultor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecabe_consultor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecabe_ice=new ParameterValue<Boolean>();
					parameterMaintenanceValuecabe_ice.setValue(visiblefactura.getcabe_ice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecabe_ice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecabe_transporte=new ParameterValue<Boolean>();
					parameterMaintenanceValuecabe_transporte.setValue(visiblefactura.getcabe_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecabe_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecabe_fue=new ParameterValue<Boolean>();
					parameterMaintenanceValuecabe_fue.setValue(visiblefactura.getcabe_fue());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecabe_fue);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecabe_orden=new ParameterValue<Boolean>();
					parameterMaintenanceValuecabe_orden.setValue(visiblefactura.getcabe_orden());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecabe_orden);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuedeta_autori_precio=new ParameterValue<Boolean>();
					parameterMaintenanceValuedeta_autori_precio.setValue(visiblefactura.getdeta_autori_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedeta_autori_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuedeta_area=new ParameterValue<Boolean>();
					parameterMaintenanceValuedeta_area.setValue(visiblefactura.getdeta_area());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedeta_area);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuedeta_foto=new ParameterValue<Boolean>();
					parameterMaintenanceValuedeta_foto.setValue(visiblefactura.getdeta_foto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedeta_foto);
					parametersTemp.add(parameterMaintenance);
					
						if(!visiblefactura.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(visiblefactura.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(visiblefactura.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(visiblefactura.getId());
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
	
	public void setIsNewIsChangedFalseVisibleFactura(VisibleFactura visiblefactura)throws Exception  {		
		visiblefactura.setIsNew(false);
		visiblefactura.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseVisibleFacturas(List<VisibleFactura> visiblefacturas)throws Exception  {				
		for(VisibleFactura visiblefactura:visiblefacturas) {
			visiblefactura.setIsNew(false);
			visiblefactura.setIsChanged(false);
		}
	}
	
	public void generarExportarVisibleFactura(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   

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
package com.bydan.erp.importaciones.business.dataaccess;

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

import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.importaciones.util.*;//ParametroImporConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class ParametroImporDataAccess extends  ParametroImporDataAccessAdditional{ //ParametroImporDataAccessAdditional,DataAccessHelper<ParametroImpor>
	//static Logger logger = Logger.getLogger(ParametroImporDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_impor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_pais,id_bodega,id_centro_costo,id_cuenta_contable,id_transaccion_orden_compra,id_transaccion_ingreso,id_formato_orden_compra,id_formato_ingreso,id_formato_pedido,id_formato_liquidacion,dias_llega_bodega,porcentaje_seguro,fodin,corpei,con_secuencial,secuencial,con_peso_precio,con_lote,con_unidad,con_conversion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_pais=?,id_bodega=?,id_centro_costo=?,id_cuenta_contable=?,id_transaccion_orden_compra=?,id_transaccion_ingreso=?,id_formato_orden_compra=?,id_formato_ingreso=?,id_formato_pedido=?,id_formato_liquidacion=?,dias_llega_bodega=?,porcentaje_seguro=?,fodin=?,corpei=?,con_secuencial=?,secuencial=?,con_peso_precio=?,con_lote=?,con_unidad=?,con_conversion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametroimpor from "+ParametroImporConstantesFunciones.SPERSISTENCENAME+" parametroimpor";
	public static String QUERYSELECTNATIVE="select "+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".version_row,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_empresa,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_pais,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_bodega,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_centro_costo,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_cuenta_contable,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_transaccion_orden_compra,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_transaccion_ingreso,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_formato_orden_compra,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_formato_ingreso,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_formato_pedido,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_formato_liquidacion,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".dias_llega_bodega,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".porcentaje_seguro,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".fodin,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".corpei,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".con_secuencial,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".secuencial,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".con_peso_precio,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".con_lote,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".con_unidad,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".con_conversion from "+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME;//+" as "+ParametroImporConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".version_row from "+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME;//+" as "+ParametroImporConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_pais=?,id_bodega=?,id_centro_costo=?,id_cuenta_contable=?,id_transaccion_orden_compra=?,id_transaccion_ingreso=?,id_formato_orden_compra=?,id_formato_ingreso=?,id_formato_pedido=?,id_formato_liquidacion=?,dias_llega_bodega=?,porcentaje_seguro=?,fodin=?,corpei=?,con_secuencial=?,secuencial=?,con_peso_precio=?,con_lote=?,con_unidad=?,con_conversion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROIMPOR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROIMPOR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROIMPOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROIMPOR_SELECT(?,?)";
	
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
	
	
	protected ParametroImporDataAccessAdditional parametroimporDataAccessAdditional=null;
	
	public ParametroImporDataAccessAdditional getParametroImporDataAccessAdditional() {
		return this.parametroimporDataAccessAdditional;
	}
	
	public void setParametroImporDataAccessAdditional(ParametroImporDataAccessAdditional parametroimporDataAccessAdditional) {
		try {
			this.parametroimporDataAccessAdditional=parametroimporDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroImporDataAccess() {
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
		ParametroImporDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroImporDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroImporDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroImporOriginal(ParametroImpor parametroimpor)throws Exception  {
		parametroimpor.setParametroImporOriginal((ParametroImpor)parametroimpor.clone());		
	}
	
	public void setParametroImporsOriginal(List<ParametroImpor> parametroimpors)throws Exception  {
		
		for(ParametroImpor parametroimpor:parametroimpors){
			parametroimpor.setParametroImporOriginal((ParametroImpor)parametroimpor.clone());
		}
	}
	
	public static void setParametroImporOriginalStatic(ParametroImpor parametroimpor)throws Exception  {
		parametroimpor.setParametroImporOriginal((ParametroImpor)parametroimpor.clone());		
	}
	
	public static void setParametroImporsOriginalStatic(List<ParametroImpor> parametroimpors)throws Exception  {
		
		for(ParametroImpor parametroimpor:parametroimpors){
			parametroimpor.setParametroImporOriginal((ParametroImpor)parametroimpor.clone());
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
	
	public  ParametroImpor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroImpor entity = new ParametroImpor();		
		
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
	
	public  ParametroImpor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroImpor entity = new ParametroImpor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Importaciones.ParametroImpor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroImporOriginal(new ParametroImpor());
      	    	entity=super.getEntity("",entity,resultSet,ParametroImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroImpor("",entity,resultSet); 
				
				//entity.setParametroImporOriginal(super.getEntity("",entity.getParametroImporOriginal(),resultSet,ParametroImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroImporOriginal(this.getEntityParametroImpor("",entity.getParametroImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroImpor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroImpor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroImpor entity = new ParametroImpor();
				
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
	
	public  ParametroImpor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroImpor entity = new ParametroImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.ParametroImpor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroImporOriginal(new ParametroImpor());
      	    	entity=super.getEntity("",entity,resultSet,ParametroImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroImpor("",entity,resultSet);    
				
				//entity.setParametroImporOriginal(super.getEntity("",entity.getParametroImporOriginal(),resultSet,ParametroImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroImporOriginal(this.getEntityParametroImpor("",entity.getParametroImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroImpor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroImpor entity = new ParametroImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.ParametroImpor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroImpor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroImpor> entities = new  ArrayList<ParametroImpor>();
		ParametroImpor entity = new ParametroImpor();		  
		
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
	
	public  List<ParametroImpor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroImpor> entities = new  ArrayList<ParametroImpor>();
		ParametroImpor entity = new ParametroImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroImpor();
      	    	entity=super.getEntity("",entity,resultSet,ParametroImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroImpor("",entity,resultSet);
      	    	
				//entity.setParametroImporOriginal( new ParametroImpor());
      	    	//entity.setParametroImporOriginal(super.getEntity("",entity.getParametroImporOriginal(),resultSet,ParametroImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroImporOriginal(this.getEntityParametroImpor("",entity.getParametroImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroImpors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroImpor> entities = new  ArrayList<ParametroImpor>();
		ParametroImpor entity = new ParametroImpor();		  
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
	
	public  List<ParametroImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroImpor> entities = new  ArrayList<ParametroImpor>();
		ParametroImpor entity = new ParametroImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroImpor();
					//entity.setMapParametroImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroImporDataAccess.ISWITHSCHEMA);         		
					entity=ParametroImporDataAccess.getEntityParametroImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroImporOriginal( new ParametroImpor());
					////entity.setParametroImporOriginal(super.getEntity("",entity.getParametroImporOriginal(),resultSet,ParametroImporDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroImporOriginal(this.getEntityParametroImpor("",entity.getParametroImporOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroImpors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroImpor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroImpor entity = new ParametroImpor();		  
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
	
	public  ParametroImpor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroImpor entity = new ParametroImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroImpor();
					//entity.setMapParametroImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroImporDataAccess.ISWITHSCHEMA);         		
					entity=ParametroImporDataAccess.getEntityParametroImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroImporOriginal( new ParametroImpor());
					////entity.setParametroImporOriginal(super.getEntity("",entity.getParametroImporOriginal(),resultSet,ParametroImporDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroImporOriginal(this.getEntityParametroImpor("",entity.getParametroImporOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroImpor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroImpor getEntityParametroImpor(String strPrefijo,ParametroImpor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroImpor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroImporDataAccess.setFieldReflectionParametroImpor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroImpor=ParametroImporConstantesFunciones.getTodosTiposColumnasParametroImpor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroImpor) {
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
							field = ParametroImpor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroImporDataAccess.setFieldReflectionParametroImpor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroImpor(Field field,String strPrefijo,String sColumn,ParametroImpor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroImporConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.IDTRANSACCIONORDENCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.IDTRANSACCIONINGRESO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.IDFORMATOORDENCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.IDFORMATOINGRESO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.IDFORMATOPEDIDO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.IDFORMATOLIQUIDACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.DIASLLEGABODEGA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.PORCENTAJESEGURO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.FODIN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.CORPEI:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.CONSECUENCIAL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.CONPESOPRECIO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.CONLOTE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.CONUNIDAD:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroImporConstantesFunciones.CONCONVERSION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroImpor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroImpor> entities = new  ArrayList<ParametroImpor>();
		ParametroImpor entity = new ParametroImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroImpor();
					entity=super.getEntity("",entity,resultSet,ParametroImporDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroImpor("",entity,resultSet);
					
					//entity.setParametroImporOriginal( new ParametroImpor());
					//entity.setParametroImporOriginal(super.getEntity("",entity.getParametroImporOriginal(),resultSet,ParametroImporDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroImporOriginal(this.getEntityParametroImpor("",entity.getParametroImporOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroImpors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroImpor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroImpor> entities = new  ArrayList<ParametroImpor>();
		ParametroImpor entity = new ParametroImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroImpor> entities = new  ArrayList<ParametroImpor>();
		ParametroImpor entity = new ParametroImpor();		  
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
	
	public  List<ParametroImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroImpor> entities = new  ArrayList<ParametroImpor>();
		ParametroImpor entity = new ParametroImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroImpor();
      	    	entity=super.getEntity("",entity,resultSet,ParametroImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroImpor("",entity,resultSet);
      	    	
				//entity.setParametroImporOriginal( new ParametroImpor());
      	    	//entity.setParametroImporOriginal(super.getEntity("",entity.getParametroImporOriginal(),resultSet,ParametroImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroImporOriginal(this.getEntityParametroImpor("",entity.getParametroImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroImpors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroImpor> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroImpor> entities = new  ArrayList<ParametroImpor>();
		ParametroImpor entity = new ParametroImpor();		  
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
	
	public  List<ParametroImpor> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroImpor> entities = new  ArrayList<ParametroImpor>();
		ParametroImpor entity = new ParametroImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroImpor();
      	    	entity=super.getEntity("",entity,resultSet,ParametroImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroImpor("",entity,resultSet);
      	    	
				//entity.setParametroImporOriginal( new ParametroImpor());
      	    	//entity.setParametroImporOriginal(super.getEntity("",entity.getParametroImporOriginal(),resultSet,ParametroImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroImporOriginal(this.getEntityParametroImpor("",entity.getParametroImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroImpors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroImpor getEntityParametroImpor(String strPrefijo,ParametroImpor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroImporConstantesFunciones.IDEMPRESA));
				entity.setid_pais(resultSet.getLong(strPrefijo+ParametroImporConstantesFunciones.IDPAIS));
				entity.setid_bodega(resultSet.getLong(strPrefijo+ParametroImporConstantesFunciones.IDBODEGA));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+ParametroImporConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+ParametroImporConstantesFunciones.IDCUENTACONTABLE));
				entity.setid_transaccion_orden_compra(resultSet.getLong(strPrefijo+ParametroImporConstantesFunciones.IDTRANSACCIONORDENCOMPRA));
				entity.setid_transaccion_ingreso(resultSet.getLong(strPrefijo+ParametroImporConstantesFunciones.IDTRANSACCIONINGRESO));
				entity.setid_formato_orden_compra(resultSet.getLong(strPrefijo+ParametroImporConstantesFunciones.IDFORMATOORDENCOMPRA));
				entity.setid_formato_ingreso(resultSet.getLong(strPrefijo+ParametroImporConstantesFunciones.IDFORMATOINGRESO));
				entity.setid_formato_pedido(resultSet.getLong(strPrefijo+ParametroImporConstantesFunciones.IDFORMATOPEDIDO));
				entity.setid_formato_liquidacion(resultSet.getLong(strPrefijo+ParametroImporConstantesFunciones.IDFORMATOLIQUIDACION));
				entity.setdias_llega_bodega(resultSet.getInt(strPrefijo+ParametroImporConstantesFunciones.DIASLLEGABODEGA));
				entity.setporcentaje_seguro(resultSet.getDouble(strPrefijo+ParametroImporConstantesFunciones.PORCENTAJESEGURO));
				entity.setfodin(resultSet.getDouble(strPrefijo+ParametroImporConstantesFunciones.FODIN));
				entity.setcorpei(resultSet.getDouble(strPrefijo+ParametroImporConstantesFunciones.CORPEI));
				entity.setcon_secuencial(resultSet.getBoolean(strPrefijo+ParametroImporConstantesFunciones.CONSECUENCIAL));
				entity.setsecuencial(resultSet.getString(strPrefijo+ParametroImporConstantesFunciones.SECUENCIAL));
				entity.setcon_peso_precio(resultSet.getBoolean(strPrefijo+ParametroImporConstantesFunciones.CONPESOPRECIO));
				entity.setcon_lote(resultSet.getBoolean(strPrefijo+ParametroImporConstantesFunciones.CONLOTE));
				entity.setcon_unidad(resultSet.getBoolean(strPrefijo+ParametroImporConstantesFunciones.CONUNIDAD));
				entity.setcon_conversion(resultSet.getBoolean(strPrefijo+ParametroImporConstantesFunciones.CONCONVERSION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroImpor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroImpor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroImporDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroImporDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroImporDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroImporDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroImporConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroImporDataAccess.TABLENAME,ParametroImporDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroImporDataAccess.setParametroImporOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroImpor relparametroimpor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametroimpor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Pais getPais(Connexion connexion,ParametroImpor relparametroimpor)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relparametroimpor.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Bodega getBodega(Connexion connexion,ParametroImpor relparametroimpor)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relparametroimpor.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public CentroCosto getCentroCosto(Connexion connexion,ParametroImpor relparametroimpor)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relparametroimpor.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public CuentaContable getCuentaContable(Connexion connexion,ParametroImpor relparametroimpor)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroimpor.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Transaccion getTransaccionOrdenCompra(Connexion connexion,ParametroImpor relparametroimpor)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametroimpor.getid_transaccion_orden_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionIngreso(Connexion connexion,ParametroImpor relparametroimpor)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametroimpor.getid_transaccion_ingreso());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Formato getFormatoOrdenCompra(Connexion connexion,ParametroImpor relparametroimpor)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametroimpor.getid_formato_orden_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Formato getFormatoIngreso(Connexion connexion,ParametroImpor relparametroimpor)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametroimpor.getid_formato_ingreso());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Formato getFormatoPedido(Connexion connexion,ParametroImpor relparametroimpor)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametroimpor.getid_formato_pedido());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Formato getFormatoLiquidacion(Connexion connexion,ParametroImpor relparametroimpor)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametroimpor.getid_formato_liquidacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroImpor parametroimpor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametroimpor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametroimpor.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(parametroimpor.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(parametroimpor.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(parametroimpor.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(parametroimpor.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_orden_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_orden_compra.setValue(parametroimpor.getid_transaccion_orden_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_orden_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_ingreso=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_ingreso.setValue(parametroimpor.getid_transaccion_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_orden_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_orden_compra.setValue(parametroimpor.getid_formato_orden_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_orden_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_ingreso=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_ingreso.setValue(parametroimpor.getid_formato_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_pedido=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_pedido.setValue(parametroimpor.getid_formato_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_liquidacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_liquidacion.setValue(parametroimpor.getid_formato_liquidacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_liquidacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedias_llega_bodega=new ParameterValue<Integer>();
					parameterMaintenanceValuedias_llega_bodega.setValue(parametroimpor.getdias_llega_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedias_llega_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_seguro=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_seguro.setValue(parametroimpor.getporcentaje_seguro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_seguro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefodin=new ParameterValue<Double>();
					parameterMaintenanceValuefodin.setValue(parametroimpor.getfodin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefodin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecorpei=new ParameterValue<Double>();
					parameterMaintenanceValuecorpei.setValue(parametroimpor.getcorpei());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecorpei);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_secuencial=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_secuencial.setValue(parametroimpor.getcon_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_secuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial.setValue(parametroimpor.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_peso_precio=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_peso_precio.setValue(parametroimpor.getcon_peso_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_peso_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_lote=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_lote.setValue(parametroimpor.getcon_lote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_lote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_unidad=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_unidad.setValue(parametroimpor.getcon_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_conversion=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_conversion.setValue(parametroimpor.getcon_conversion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_conversion);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametroimpor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametroimpor.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametroimpor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametroimpor.getId());
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
	
	public void setIsNewIsChangedFalseParametroImpor(ParametroImpor parametroimpor)throws Exception  {		
		parametroimpor.setIsNew(false);
		parametroimpor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroImpors(List<ParametroImpor> parametroimpors)throws Exception  {				
		for(ParametroImpor parametroimpor:parametroimpors) {
			parametroimpor.setIsNew(false);
			parametroimpor.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroImpor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   

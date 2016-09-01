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
import com.bydan.erp.facturacion.util.*;//ParametroFactuConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class ParametroFactuDataAccess extends  ParametroFactuDataAccessAdditional{ //ParametroFactuDataAccessAdditional,DataAccessHelper<ParametroFactu>
	//static Logger logger = Logger.getLogger(ParametroFactuDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_factu";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_cuenta_contable_factu,id_cuenta_contable_finan,id_cuenta_contable_otro,id_formato_proforma,id_formato_pedido,id_formato_factura,id_formato_nota_credito,id_formato_inventario,secuencial_proforma,secuancial_pedido,secuencial_factura,secuencial_nota_credito,item_proforma,item_pedido,item_factura,item_nota_credito,item_inventario,con_detalle_proforma,con_detalle_pedido,con_detalle_factura,con_detalle_nota_credito)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_cuenta_contable_factu=?,id_cuenta_contable_finan=?,id_cuenta_contable_otro=?,id_formato_proforma=?,id_formato_pedido=?,id_formato_factura=?,id_formato_nota_credito=?,id_formato_inventario=?,secuencial_proforma=?,secuancial_pedido=?,secuencial_factura=?,secuencial_nota_credito=?,item_proforma=?,item_pedido=?,item_factura=?,item_nota_credito=?,item_inventario=?,con_detalle_proforma=?,con_detalle_pedido=?,con_detalle_factura=?,con_detalle_nota_credito=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrofactu from "+ParametroFactuConstantesFunciones.SPERSISTENCENAME+" parametrofactu";
	public static String QUERYSELECTNATIVE="select "+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".version_row,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_empresa,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_cuenta_contable_factu,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_cuenta_contable_finan,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_cuenta_contable_otro,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_formato_proforma,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_formato_pedido,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_formato_factura,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_formato_nota_credito,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_formato_inventario,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".secuencial_proforma,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".secuancial_pedido,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".secuencial_factura,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".secuencial_nota_credito,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".item_proforma,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".item_pedido,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".item_factura,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".item_nota_credito,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".item_inventario,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".con_detalle_proforma,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".con_detalle_pedido,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".con_detalle_factura,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".con_detalle_nota_credito from "+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME;//+" as "+ParametroFactuConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".version_row from "+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME;//+" as "+ParametroFactuConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_cuenta_contable_factu=?,id_cuenta_contable_finan=?,id_cuenta_contable_otro=?,id_formato_proforma=?,id_formato_pedido=?,id_formato_factura=?,id_formato_nota_credito=?,id_formato_inventario=?,secuencial_proforma=?,secuancial_pedido=?,secuencial_factura=?,secuencial_nota_credito=?,item_proforma=?,item_pedido=?,item_factura=?,item_nota_credito=?,item_inventario=?,con_detalle_proforma=?,con_detalle_pedido=?,con_detalle_factura=?,con_detalle_nota_credito=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROFACTU_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROFACTU_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROFACTU_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROFACTU_SELECT(?,?)";
	
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
	
	
	protected ParametroFactuDataAccessAdditional parametrofactuDataAccessAdditional=null;
	
	public ParametroFactuDataAccessAdditional getParametroFactuDataAccessAdditional() {
		return this.parametrofactuDataAccessAdditional;
	}
	
	public void setParametroFactuDataAccessAdditional(ParametroFactuDataAccessAdditional parametrofactuDataAccessAdditional) {
		try {
			this.parametrofactuDataAccessAdditional=parametrofactuDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroFactuDataAccess() {
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
		ParametroFactuDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroFactuDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroFactuDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroFactuOriginal(ParametroFactu parametrofactu)throws Exception  {
		parametrofactu.setParametroFactuOriginal((ParametroFactu)parametrofactu.clone());		
	}
	
	public void setParametroFactusOriginal(List<ParametroFactu> parametrofactus)throws Exception  {
		
		for(ParametroFactu parametrofactu:parametrofactus){
			parametrofactu.setParametroFactuOriginal((ParametroFactu)parametrofactu.clone());
		}
	}
	
	public static void setParametroFactuOriginalStatic(ParametroFactu parametrofactu)throws Exception  {
		parametrofactu.setParametroFactuOriginal((ParametroFactu)parametrofactu.clone());		
	}
	
	public static void setParametroFactusOriginalStatic(List<ParametroFactu> parametrofactus)throws Exception  {
		
		for(ParametroFactu parametrofactu:parametrofactus){
			parametrofactu.setParametroFactuOriginal((ParametroFactu)parametrofactu.clone());
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
	
	public  ParametroFactu getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroFactu entity = new ParametroFactu();		
		
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
	
	public  ParametroFactu getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroFactu entity = new ParametroFactu();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFactuDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.ParametroFactu.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroFactuOriginal(new ParametroFactu());
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroFactu("",entity,resultSet); 
				
				//entity.setParametroFactuOriginal(super.getEntity("",entity.getParametroFactuOriginal(),resultSet,ParametroFactuDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuOriginal(this.getEntityParametroFactu("",entity.getParametroFactuOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroFactu(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroFactu getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroFactu entity = new ParametroFactu();
				
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
	
	public  ParametroFactu getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroFactu entity = new ParametroFactu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFactuDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.ParametroFactu.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroFactuOriginal(new ParametroFactu());
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroFactu("",entity,resultSet);    
				
				//entity.setParametroFactuOriginal(super.getEntity("",entity.getParametroFactuOriginal(),resultSet,ParametroFactuDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuOriginal(this.getEntityParametroFactu("",entity.getParametroFactuOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroFactu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroFactu
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroFactu entity = new ParametroFactu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFactuDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.ParametroFactu.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroFactu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroFactu> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroFactu> entities = new  ArrayList<ParametroFactu>();
		ParametroFactu entity = new ParametroFactu();		  
		
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
	
	public  List<ParametroFactu> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroFactu> entities = new  ArrayList<ParametroFactu>();
		ParametroFactu entity = new ParametroFactu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFactuDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactu();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFactu("",entity,resultSet);
      	    	
				//entity.setParametroFactuOriginal( new ParametroFactu());
      	    	//entity.setParametroFactuOriginal(super.getEntity("",entity.getParametroFactuOriginal(),resultSet,ParametroFactuDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuOriginal(this.getEntityParametroFactu("",entity.getParametroFactuOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFactus(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroFactu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroFactu> entities = new  ArrayList<ParametroFactu>();
		ParametroFactu entity = new ParametroFactu();		  
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
	
	public  List<ParametroFactu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroFactu> entities = new  ArrayList<ParametroFactu>();
		ParametroFactu entity = new ParametroFactu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactu();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroFactu();
					//entity.setMapParametroFactu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroFactuValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroFactu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroFactuDataAccess.ISWITHSCHEMA);         		
					entity=ParametroFactuDataAccess.getEntityParametroFactu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroFactuOriginal( new ParametroFactu());
					////entity.setParametroFactuOriginal(super.getEntity("",entity.getParametroFactuOriginal(),resultSet,ParametroFactuDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroFactuOriginal(this.getEntityParametroFactu("",entity.getParametroFactuOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFactus(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroFactu getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroFactu entity = new ParametroFactu();		  
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
	
	public  ParametroFactu getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroFactu entity = new ParametroFactu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactu();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroFactu();
					//entity.setMapParametroFactu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroFactuValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroFactu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroFactuDataAccess.ISWITHSCHEMA);         		
					entity=ParametroFactuDataAccess.getEntityParametroFactu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroFactuOriginal( new ParametroFactu());
					////entity.setParametroFactuOriginal(super.getEntity("",entity.getParametroFactuOriginal(),resultSet,ParametroFactuDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroFactuOriginal(this.getEntityParametroFactu("",entity.getParametroFactuOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroFactu(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroFactu getEntityParametroFactu(String strPrefijo,ParametroFactu entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroFactu.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroFactu.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroFactuDataAccess.setFieldReflectionParametroFactu(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroFactu=ParametroFactuConstantesFunciones.getTodosTiposColumnasParametroFactu();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroFactu) {
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
							field = ParametroFactu.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroFactu.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroFactuDataAccess.setFieldReflectionParametroFactu(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroFactu(Field field,String strPrefijo,String sColumn,ParametroFactu entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroFactuConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.IDCUENTACONTABLEFACTU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.IDCUENTACONTABLEFINAN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.IDCUENTACONTABLEOTRO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.IDFORMATOPROFORMA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.IDFORMATOPEDIDO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.IDFORMATOFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.IDFORMATONOTACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.IDFORMATOINVENTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.SECUENCIALPROFORMA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.SECUANCIALPEDIDO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.SECUENCIALFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.SECUENCIALNOTACREDITO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.ITEMPROFORMA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.ITEMPEDIDO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.ITEMFACTURA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.ITEMNOTACREDITO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.ITEMINVENTARIO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.CONDETALLEPROFORMA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.CONDETALLEPEDIDO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.CONDETALLEFACTURA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuConstantesFunciones.CONDETALLENOTACREDITO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroFactu>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroFactu> entities = new  ArrayList<ParametroFactu>();
		ParametroFactu entity = new ParametroFactu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFactuDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroFactu();
					entity=super.getEntity("",entity,resultSet,ParametroFactuDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroFactu("",entity,resultSet);
					
					//entity.setParametroFactuOriginal( new ParametroFactu());
					//entity.setParametroFactuOriginal(super.getEntity("",entity.getParametroFactuOriginal(),resultSet,ParametroFactuDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroFactuOriginal(this.getEntityParametroFactu("",entity.getParametroFactuOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroFactus(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroFactu>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroFactu> entities = new  ArrayList<ParametroFactu>();
		ParametroFactu entity = new ParametroFactu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFactuDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroFactu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactu> entities = new  ArrayList<ParametroFactu>();
		ParametroFactu entity = new ParametroFactu();		  
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
	
	public  List<ParametroFactu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactu> entities = new  ArrayList<ParametroFactu>();
		ParametroFactu entity = new ParametroFactu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactu();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFactu("",entity,resultSet);
      	    	
				//entity.setParametroFactuOriginal( new ParametroFactu());
      	    	//entity.setParametroFactuOriginal(super.getEntity("",entity.getParametroFactuOriginal(),resultSet,ParametroFactuDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuOriginal(this.getEntityParametroFactu("",entity.getParametroFactuOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroFactus(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroFactu> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactu> entities = new  ArrayList<ParametroFactu>();
		ParametroFactu entity = new ParametroFactu();		  
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
	
	public  List<ParametroFactu> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactu> entities = new  ArrayList<ParametroFactu>();
		ParametroFactu entity = new ParametroFactu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactu();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFactu("",entity,resultSet);
      	    	
				//entity.setParametroFactuOriginal( new ParametroFactu());
      	    	//entity.setParametroFactuOriginal(super.getEntity("",entity.getParametroFactuOriginal(),resultSet,ParametroFactuDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuOriginal(this.getEntityParametroFactu("",entity.getParametroFactuOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFactus(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroFactu getEntityParametroFactu(String strPrefijo,ParametroFactu entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroFactuConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ParametroFactuConstantesFunciones.IDSUCURSAL));
				entity.setid_cuenta_contable_factu(resultSet.getLong(strPrefijo+ParametroFactuConstantesFunciones.IDCUENTACONTABLEFACTU));
				entity.setid_cuenta_contable_finan(resultSet.getLong(strPrefijo+ParametroFactuConstantesFunciones.IDCUENTACONTABLEFINAN));
				entity.setid_cuenta_contable_otro(resultSet.getLong(strPrefijo+ParametroFactuConstantesFunciones.IDCUENTACONTABLEOTRO));
				entity.setid_formato_proforma(resultSet.getLong(strPrefijo+ParametroFactuConstantesFunciones.IDFORMATOPROFORMA));
				entity.setid_formato_pedido(resultSet.getLong(strPrefijo+ParametroFactuConstantesFunciones.IDFORMATOPEDIDO));
				entity.setid_formato_factura(resultSet.getLong(strPrefijo+ParametroFactuConstantesFunciones.IDFORMATOFACTURA));
				entity.setid_formato_nota_credito(resultSet.getLong(strPrefijo+ParametroFactuConstantesFunciones.IDFORMATONOTACREDITO));
				entity.setid_formato_inventario(resultSet.getLong(strPrefijo+ParametroFactuConstantesFunciones.IDFORMATOINVENTARIO));
				entity.setsecuencial_proforma(resultSet.getString(strPrefijo+ParametroFactuConstantesFunciones.SECUENCIALPROFORMA));
				entity.setsecuancial_pedido(resultSet.getString(strPrefijo+ParametroFactuConstantesFunciones.SECUANCIALPEDIDO));
				entity.setsecuencial_factura(resultSet.getString(strPrefijo+ParametroFactuConstantesFunciones.SECUENCIALFACTURA));
				entity.setsecuencial_nota_credito(resultSet.getString(strPrefijo+ParametroFactuConstantesFunciones.SECUENCIALNOTACREDITO));
				entity.setitem_proforma(resultSet.getInt(strPrefijo+ParametroFactuConstantesFunciones.ITEMPROFORMA));
				entity.setitem_pedido(resultSet.getInt(strPrefijo+ParametroFactuConstantesFunciones.ITEMPEDIDO));
				entity.setitem_factura(resultSet.getInt(strPrefijo+ParametroFactuConstantesFunciones.ITEMFACTURA));
				entity.setitem_nota_credito(resultSet.getInt(strPrefijo+ParametroFactuConstantesFunciones.ITEMNOTACREDITO));
				entity.setitem_inventario(resultSet.getInt(strPrefijo+ParametroFactuConstantesFunciones.ITEMINVENTARIO));
				entity.setcon_detalle_proforma(resultSet.getBoolean(strPrefijo+ParametroFactuConstantesFunciones.CONDETALLEPROFORMA));
				entity.setcon_detalle_pedido(resultSet.getBoolean(strPrefijo+ParametroFactuConstantesFunciones.CONDETALLEPEDIDO));
				entity.setcon_detalle_factura(resultSet.getBoolean(strPrefijo+ParametroFactuConstantesFunciones.CONDETALLEFACTURA));
				entity.setcon_detalle_nota_credito(resultSet.getBoolean(strPrefijo+ParametroFactuConstantesFunciones.CONDETALLENOTACREDITO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroFactu(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroFactu entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroFactuDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroFactuDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroFactuDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroFactuDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroFactuConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroFactuDataAccess.TABLENAME,ParametroFactuDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroFactuDataAccess.setParametroFactuOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroFactu relparametrofactu)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrofactu.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ParametroFactu relparametrofactu)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relparametrofactu.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public CuentaContable getCuentaContableFactu(Connexion connexion,ParametroFactu relparametrofactu)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrofactu.getid_cuenta_contable_factu());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableFinan(Connexion connexion,ParametroFactu relparametrofactu)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrofactu.getid_cuenta_contable_finan());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableOtro(Connexion connexion,ParametroFactu relparametrofactu)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrofactu.getid_cuenta_contable_otro());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Formato getFormatoProforma(Connexion connexion,ParametroFactu relparametrofactu)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametrofactu.getid_formato_proforma());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Formato getFormatoPedido(Connexion connexion,ParametroFactu relparametrofactu)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametrofactu.getid_formato_pedido());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Formato getFormatoFactura(Connexion connexion,ParametroFactu relparametrofactu)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametrofactu.getid_formato_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Formato getFormatoNotaCredito(Connexion connexion,ParametroFactu relparametrofactu)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametrofactu.getid_formato_nota_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Formato getFormatoInventario(Connexion connexion,ParametroFactu relparametrofactu)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametrofactu.getid_formato_inventario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroFactu parametrofactu) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrofactu.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametrofactu.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(parametrofactu.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_factu=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_factu.setValue(parametrofactu.getid_cuenta_contable_factu());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_factu);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_finan=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_finan.setValue(parametrofactu.getid_cuenta_contable_finan());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_finan);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_otro=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_otro.setValue(parametrofactu.getid_cuenta_contable_otro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_otro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_proforma=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_proforma.setValue(parametrofactu.getid_formato_proforma());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_proforma);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_pedido=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_pedido.setValue(parametrofactu.getid_formato_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_factura.setValue(parametrofactu.getid_formato_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_nota_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_nota_credito.setValue(parametrofactu.getid_formato_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_inventario=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_inventario.setValue(parametrofactu.getid_formato_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial_proforma=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial_proforma.setValue(parametrofactu.getsecuencial_proforma());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial_proforma);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuancial_pedido=new ParameterValue<String>();
					parameterMaintenanceValuesecuancial_pedido.setValue(parametrofactu.getsecuancial_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuancial_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial_factura=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial_factura.setValue(parametrofactu.getsecuencial_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial_nota_credito=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial_nota_credito.setValue(parametrofactu.getsecuencial_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueitem_proforma=new ParameterValue<Integer>();
					parameterMaintenanceValueitem_proforma.setValue(parametrofactu.getitem_proforma());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueitem_proforma);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueitem_pedido=new ParameterValue<Integer>();
					parameterMaintenanceValueitem_pedido.setValue(parametrofactu.getitem_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueitem_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueitem_factura=new ParameterValue<Integer>();
					parameterMaintenanceValueitem_factura.setValue(parametrofactu.getitem_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueitem_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueitem_nota_credito=new ParameterValue<Integer>();
					parameterMaintenanceValueitem_nota_credito.setValue(parametrofactu.getitem_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueitem_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueitem_inventario=new ParameterValue<Integer>();
					parameterMaintenanceValueitem_inventario.setValue(parametrofactu.getitem_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueitem_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_detalle_proforma=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_detalle_proforma.setValue(parametrofactu.getcon_detalle_proforma());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_detalle_proforma);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_detalle_pedido=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_detalle_pedido.setValue(parametrofactu.getcon_detalle_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_detalle_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_detalle_factura=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_detalle_factura.setValue(parametrofactu.getcon_detalle_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_detalle_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_detalle_nota_credito=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_detalle_nota_credito.setValue(parametrofactu.getcon_detalle_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_detalle_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrofactu.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrofactu.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrofactu.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrofactu.getId());
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
	
	public void setIsNewIsChangedFalseParametroFactu(ParametroFactu parametrofactu)throws Exception  {		
		parametrofactu.setIsNew(false);
		parametrofactu.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroFactus(List<ParametroFactu> parametrofactus)throws Exception  {				
		for(ParametroFactu parametrofactu:parametrofactus) {
			parametrofactu.setIsNew(false);
			parametrofactu.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroFactu(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   

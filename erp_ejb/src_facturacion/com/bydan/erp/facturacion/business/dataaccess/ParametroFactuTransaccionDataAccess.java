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
import com.bydan.erp.facturacion.util.*;//ParametroFactuTransaccionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class ParametroFactuTransaccionDataAccess extends  ParametroFactuTransaccionDataAccessAdditional{ //ParametroFactuTransaccionDataAccessAdditional,DataAccessHelper<ParametroFactuTransaccion>
	//static Logger logger = Logger.getLogger(ParametroFactuTransaccionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_factu_transaccion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_transaccion_inven_factura,id_transaccion_inven_nota_credito,id_transaccion_inven_nota_venta,id_transaccion_cuenta_co_factura,id_transaccion_cuenta_co_nota_credito,id_transaccion_cuenta_co_nota_venta,id_transaccion_cuenta_co_tarjeta,id_transaccion_cuenta_pa_factura,id_transaccion_cuenta_pa_nota_credito)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_transaccion_inven_factura=?,id_transaccion_inven_nota_credito=?,id_transaccion_inven_nota_venta=?,id_transaccion_cuenta_co_factura=?,id_transaccion_cuenta_co_nota_credito=?,id_transaccion_cuenta_co_nota_venta=?,id_transaccion_cuenta_co_tarjeta=?,id_transaccion_cuenta_pa_factura=?,id_transaccion_cuenta_pa_nota_credito=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrofactutransaccion from "+ParametroFactuTransaccionConstantesFunciones.SPERSISTENCENAME+" parametrofactutransaccion";
	public static String QUERYSELECTNATIVE="select "+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".version_row,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_empresa,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_inven_factura,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_inven_nota_credito,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_inven_nota_venta,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_cuenta_co_factura,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_cuenta_co_nota_credito,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_cuenta_co_nota_venta,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_cuenta_co_tarjeta,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_cuenta_pa_factura,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_cuenta_pa_nota_credito from "+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME;//+" as "+ParametroFactuTransaccionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".version_row from "+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME;//+" as "+ParametroFactuTransaccionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_transaccion_inven_factura=?,id_transaccion_inven_nota_credito=?,id_transaccion_inven_nota_venta=?,id_transaccion_cuenta_co_factura=?,id_transaccion_cuenta_co_nota_credito=?,id_transaccion_cuenta_co_nota_venta=?,id_transaccion_cuenta_co_tarjeta=?,id_transaccion_cuenta_pa_factura=?,id_transaccion_cuenta_pa_nota_credito=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROFACTUTRANSACCION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROFACTUTRANSACCION_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROFACTUTRANSACCION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROFACTUTRANSACCION_SELECT(?,?)";
	
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
	
	
	protected ParametroFactuTransaccionDataAccessAdditional parametrofactutransaccionDataAccessAdditional=null;
	
	public ParametroFactuTransaccionDataAccessAdditional getParametroFactuTransaccionDataAccessAdditional() {
		return this.parametrofactutransaccionDataAccessAdditional;
	}
	
	public void setParametroFactuTransaccionDataAccessAdditional(ParametroFactuTransaccionDataAccessAdditional parametrofactutransaccionDataAccessAdditional) {
		try {
			this.parametrofactutransaccionDataAccessAdditional=parametrofactutransaccionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroFactuTransaccionDataAccess() {
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
		ParametroFactuTransaccionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroFactuTransaccionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroFactuTransaccionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroFactuTransaccionOriginal(ParametroFactuTransaccion parametrofactutransaccion)throws Exception  {
		parametrofactutransaccion.setParametroFactuTransaccionOriginal((ParametroFactuTransaccion)parametrofactutransaccion.clone());		
	}
	
	public void setParametroFactuTransaccionsOriginal(List<ParametroFactuTransaccion> parametrofactutransaccions)throws Exception  {
		
		for(ParametroFactuTransaccion parametrofactutransaccion:parametrofactutransaccions){
			parametrofactutransaccion.setParametroFactuTransaccionOriginal((ParametroFactuTransaccion)parametrofactutransaccion.clone());
		}
	}
	
	public static void setParametroFactuTransaccionOriginalStatic(ParametroFactuTransaccion parametrofactutransaccion)throws Exception  {
		parametrofactutransaccion.setParametroFactuTransaccionOriginal((ParametroFactuTransaccion)parametrofactutransaccion.clone());		
	}
	
	public static void setParametroFactuTransaccionsOriginalStatic(List<ParametroFactuTransaccion> parametrofactutransaccions)throws Exception  {
		
		for(ParametroFactuTransaccion parametrofactutransaccion:parametrofactutransaccions){
			parametrofactutransaccion.setParametroFactuTransaccionOriginal((ParametroFactuTransaccion)parametrofactutransaccion.clone());
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
	
	public  ParametroFactuTransaccion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();		
		
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
	
	public  ParametroFactuTransaccion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFactuTransaccionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFactuTransaccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.ParametroFactuTransaccion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroFactuTransaccionOriginal(new ParametroFactuTransaccion());
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuTransaccionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroFactuTransaccion("",entity,resultSet); 
				
				//entity.setParametroFactuTransaccionOriginal(super.getEntity("",entity.getParametroFactuTransaccionOriginal(),resultSet,ParametroFactuTransaccionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuTransaccionOriginal(this.getEntityParametroFactuTransaccion("",entity.getParametroFactuTransaccionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroFactuTransaccion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroFactuTransaccion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();
				
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
	
	public  ParametroFactuTransaccion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFactuTransaccionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFactuTransaccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuTransaccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.ParametroFactuTransaccion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroFactuTransaccionOriginal(new ParametroFactuTransaccion());
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuTransaccionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroFactuTransaccion("",entity,resultSet);    
				
				//entity.setParametroFactuTransaccionOriginal(super.getEntity("",entity.getParametroFactuTransaccionOriginal(),resultSet,ParametroFactuTransaccionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuTransaccionOriginal(this.getEntityParametroFactuTransaccion("",entity.getParametroFactuTransaccionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroFactuTransaccion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroFactuTransaccion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFactuTransaccionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFactuTransaccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuTransaccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.ParametroFactuTransaccion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroFactuTransaccion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroFactuTransaccion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroFactuTransaccion> entities = new  ArrayList<ParametroFactuTransaccion>();
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();		  
		
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
	
	public  List<ParametroFactuTransaccion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroFactuTransaccion> entities = new  ArrayList<ParametroFactuTransaccion>();
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFactuTransaccionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFactuTransaccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuTransaccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuTransaccion();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuTransaccionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFactuTransaccion("",entity,resultSet);
      	    	
				//entity.setParametroFactuTransaccionOriginal( new ParametroFactuTransaccion());
      	    	//entity.setParametroFactuTransaccionOriginal(super.getEntity("",entity.getParametroFactuTransaccionOriginal(),resultSet,ParametroFactuTransaccionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuTransaccionOriginal(this.getEntityParametroFactuTransaccion("",entity.getParametroFactuTransaccionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFactuTransaccions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuTransaccion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroFactuTransaccion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroFactuTransaccion> entities = new  ArrayList<ParametroFactuTransaccion>();
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();		  
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
	
	public  List<ParametroFactuTransaccion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroFactuTransaccion> entities = new  ArrayList<ParametroFactuTransaccion>();
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuTransaccion();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroFactuTransaccion();
					//entity.setMapParametroFactuTransaccion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroFactuTransaccionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroFactuTransaccion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroFactuTransaccionDataAccess.ISWITHSCHEMA);         		
					entity=ParametroFactuTransaccionDataAccess.getEntityParametroFactuTransaccion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroFactuTransaccionOriginal( new ParametroFactuTransaccion());
					////entity.setParametroFactuTransaccionOriginal(super.getEntity("",entity.getParametroFactuTransaccionOriginal(),resultSet,ParametroFactuTransaccionDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroFactuTransaccionOriginal(this.getEntityParametroFactuTransaccion("",entity.getParametroFactuTransaccionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFactuTransaccions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuTransaccion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroFactuTransaccion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();		  
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
	
	public  ParametroFactuTransaccion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuTransaccion();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroFactuTransaccion();
					//entity.setMapParametroFactuTransaccion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroFactuTransaccionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroFactuTransaccion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroFactuTransaccionDataAccess.ISWITHSCHEMA);         		
					entity=ParametroFactuTransaccionDataAccess.getEntityParametroFactuTransaccion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroFactuTransaccionOriginal( new ParametroFactuTransaccion());
					////entity.setParametroFactuTransaccionOriginal(super.getEntity("",entity.getParametroFactuTransaccionOriginal(),resultSet,ParametroFactuTransaccionDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroFactuTransaccionOriginal(this.getEntityParametroFactuTransaccion("",entity.getParametroFactuTransaccionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroFactuTransaccion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuTransaccion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroFactuTransaccion getEntityParametroFactuTransaccion(String strPrefijo,ParametroFactuTransaccion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroFactuTransaccion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroFactuTransaccion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroFactuTransaccionDataAccess.setFieldReflectionParametroFactuTransaccion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroFactuTransaccion=ParametroFactuTransaccionConstantesFunciones.getTodosTiposColumnasParametroFactuTransaccion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroFactuTransaccion) {
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
							field = ParametroFactuTransaccion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroFactuTransaccion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroFactuTransaccionDataAccess.setFieldReflectionParametroFactuTransaccion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroFactuTransaccion(Field field,String strPrefijo,String sColumn,ParametroFactuTransaccion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroFactuTransaccionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuTransaccionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroFactuTransaccionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuTransaccionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTAVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTAVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOTARJETA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPAFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPANOTACREDITO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroFactuTransaccion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroFactuTransaccion> entities = new  ArrayList<ParametroFactuTransaccion>();
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFactuTransaccionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFactuTransaccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuTransaccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroFactuTransaccion();
					entity=super.getEntity("",entity,resultSet,ParametroFactuTransaccionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroFactuTransaccion("",entity,resultSet);
					
					//entity.setParametroFactuTransaccionOriginal( new ParametroFactuTransaccion());
					//entity.setParametroFactuTransaccionOriginal(super.getEntity("",entity.getParametroFactuTransaccionOriginal(),resultSet,ParametroFactuTransaccionDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroFactuTransaccionOriginal(this.getEntityParametroFactuTransaccion("",entity.getParametroFactuTransaccionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroFactuTransaccions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuTransaccion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroFactuTransaccion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroFactuTransaccion> entities = new  ArrayList<ParametroFactuTransaccion>();
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFactuTransaccionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFactuTransaccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuTransaccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroFactuTransaccion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactuTransaccion> entities = new  ArrayList<ParametroFactuTransaccion>();
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();		  
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
	
	public  List<ParametroFactuTransaccion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactuTransaccion> entities = new  ArrayList<ParametroFactuTransaccion>();
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuTransaccion();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuTransaccionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFactuTransaccion("",entity,resultSet);
      	    	
				//entity.setParametroFactuTransaccionOriginal( new ParametroFactuTransaccion());
      	    	//entity.setParametroFactuTransaccionOriginal(super.getEntity("",entity.getParametroFactuTransaccionOriginal(),resultSet,ParametroFactuTransaccionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuTransaccionOriginal(this.getEntityParametroFactuTransaccion("",entity.getParametroFactuTransaccionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroFactuTransaccions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuTransaccion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroFactuTransaccion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactuTransaccion> entities = new  ArrayList<ParametroFactuTransaccion>();
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();		  
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
	
	public  List<ParametroFactuTransaccion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactuTransaccion> entities = new  ArrayList<ParametroFactuTransaccion>();
		ParametroFactuTransaccion entity = new ParametroFactuTransaccion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuTransaccion();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuTransaccionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFactuTransaccion("",entity,resultSet);
      	    	
				//entity.setParametroFactuTransaccionOriginal( new ParametroFactuTransaccion());
      	    	//entity.setParametroFactuTransaccionOriginal(super.getEntity("",entity.getParametroFactuTransaccionOriginal(),resultSet,ParametroFactuTransaccionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuTransaccionOriginal(this.getEntityParametroFactuTransaccion("",entity.getParametroFactuTransaccionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFactuTransaccions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroFactuTransaccion getEntityParametroFactuTransaccion(String strPrefijo,ParametroFactuTransaccion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroFactuTransaccionConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ParametroFactuTransaccionConstantesFunciones.IDSUCURSAL));
				entity.setid_transaccion_inven_factura(resultSet.getLong(strPrefijo+ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENFACTURA));
				entity.setid_transaccion_inven_nota_credito(resultSet.getLong(strPrefijo+ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTACREDITO));
				entity.setid_transaccion_inven_nota_venta(resultSet.getLong(strPrefijo+ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTAVENTA));
				entity.setid_transaccion_cuenta_co_factura(resultSet.getLong(strPrefijo+ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOFACTURA));
				entity.setid_transaccion_cuenta_co_nota_credito(resultSet.getLong(strPrefijo+ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTACREDITO));
				entity.setid_transaccion_cuenta_co_nota_venta(resultSet.getLong(strPrefijo+ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTAVENTA));
				entity.setid_transaccion_cuenta_co_tarjeta(resultSet.getLong(strPrefijo+ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOTARJETA));
				entity.setid_transaccion_cuenta_pa_factura(resultSet.getLong(strPrefijo+ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPAFACTURA));
				entity.setid_transaccion_cuenta_pa_nota_credito(resultSet.getLong(strPrefijo+ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPANOTACREDITO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroFactuTransaccion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroFactuTransaccion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroFactuTransaccionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroFactuTransaccionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroFactuTransaccionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroFactuTransaccionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroFactuTransaccionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroFactuTransaccionDataAccess.TABLENAME,ParametroFactuTransaccionDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroFactuTransaccionDataAccess.setParametroFactuTransaccionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroFactuTransaccion relparametrofactutransaccion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrofactutransaccion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ParametroFactuTransaccion relparametrofactutransaccion)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relparametrofactutransaccion.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Transaccion getTransaccionInvenFactura(Connexion connexion,ParametroFactuTransaccion relparametrofactutransaccion)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrofactutransaccion.getid_transaccion_inven_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionInvenNotaCredito(Connexion connexion,ParametroFactuTransaccion relparametrofactutransaccion)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrofactutransaccion.getid_transaccion_inven_nota_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionInvenNotaVenta(Connexion connexion,ParametroFactuTransaccion relparametrofactutransaccion)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrofactutransaccion.getid_transaccion_inven_nota_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionCuentaCoFactura(Connexion connexion,ParametroFactuTransaccion relparametrofactutransaccion)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrofactutransaccion.getid_transaccion_cuenta_co_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionCuentaCoNotaCredito(Connexion connexion,ParametroFactuTransaccion relparametrofactutransaccion)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrofactutransaccion.getid_transaccion_cuenta_co_nota_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionCuentaCoNotaVenta(Connexion connexion,ParametroFactuTransaccion relparametrofactutransaccion)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrofactutransaccion.getid_transaccion_cuenta_co_nota_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionCuentaCoTarjeta(Connexion connexion,ParametroFactuTransaccion relparametrofactutransaccion)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrofactutransaccion.getid_transaccion_cuenta_co_tarjeta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionCuentaPaFactura(Connexion connexion,ParametroFactuTransaccion relparametrofactutransaccion)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrofactutransaccion.getid_transaccion_cuenta_pa_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionCuentaPaNotaCredito(Connexion connexion,ParametroFactuTransaccion relparametrofactutransaccion)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrofactutransaccion.getid_transaccion_cuenta_pa_nota_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroFactuTransaccion parametrofactutransaccion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrofactutransaccion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametrofactutransaccion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(parametrofactutransaccion.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_inven_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_inven_factura.setValue(parametrofactutransaccion.getid_transaccion_inven_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_inven_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_inven_nota_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_inven_nota_credito.setValue(parametrofactutransaccion.getid_transaccion_inven_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_inven_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_inven_nota_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_inven_nota_venta.setValue(parametrofactutransaccion.getid_transaccion_inven_nota_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_inven_nota_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_cuenta_co_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_cuenta_co_factura.setValue(parametrofactutransaccion.getid_transaccion_cuenta_co_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_cuenta_co_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_cuenta_co_nota_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_cuenta_co_nota_credito.setValue(parametrofactutransaccion.getid_transaccion_cuenta_co_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_cuenta_co_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_cuenta_co_nota_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_cuenta_co_nota_venta.setValue(parametrofactutransaccion.getid_transaccion_cuenta_co_nota_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_cuenta_co_nota_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_cuenta_co_tarjeta=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_cuenta_co_tarjeta.setValue(parametrofactutransaccion.getid_transaccion_cuenta_co_tarjeta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_cuenta_co_tarjeta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_cuenta_pa_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_cuenta_pa_factura.setValue(parametrofactutransaccion.getid_transaccion_cuenta_pa_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_cuenta_pa_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_cuenta_pa_nota_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_cuenta_pa_nota_credito.setValue(parametrofactutransaccion.getid_transaccion_cuenta_pa_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_cuenta_pa_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrofactutransaccion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrofactutransaccion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrofactutransaccion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrofactutransaccion.getId());
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
	
	public void setIsNewIsChangedFalseParametroFactuTransaccion(ParametroFactuTransaccion parametrofactutransaccion)throws Exception  {		
		parametrofactutransaccion.setIsNew(false);
		parametrofactutransaccion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroFactuTransaccions(List<ParametroFactuTransaccion> parametrofactutransaccions)throws Exception  {				
		for(ParametroFactuTransaccion parametrofactutransaccion:parametrofactutransaccions) {
			parametrofactutransaccion.setIsNew(false);
			parametrofactutransaccion.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroFactuTransaccion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   

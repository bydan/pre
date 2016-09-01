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
import com.bydan.erp.importaciones.util.*;//LiquidacionImpuestoImporConstantesFunciones;


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
final public class LiquidacionImpuestoImporDataAccess extends  LiquidacionImpuestoImporDataAccessAdditional{ //LiquidacionImpuestoImporDataAccessAdditional,DataAccessHelper<LiquidacionImpuestoImpor>
	//static Logger logger = Logger.getLogger(LiquidacionImpuestoImporDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="liquidacion_impuesto_impor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+"(version_row,id_pedido_compra_impor,id_empresa,id_sucursal,id_cliente,id_factura,numero_comprobante,numero_dui,fecha,fecha_pago,fob,seguro,flete,porcentaje_fodi,porcentaje_iva,tasa_control,cfr,cif,total)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pedido_compra_impor=?,id_empresa=?,id_sucursal=?,id_cliente=?,id_factura=?,numero_comprobante=?,numero_dui=?,fecha=?,fecha_pago=?,fob=?,seguro=?,flete=?,porcentaje_fodi=?,porcentaje_iva=?,tasa_control=?,cfr=?,cif=?,total=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select liquidacionimpuestoimpor from "+LiquidacionImpuestoImporConstantesFunciones.SPERSISTENCENAME+" liquidacionimpuestoimpor";
	public static String QUERYSELECTNATIVE="select "+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".version_row,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id_pedido_compra_impor,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id_empresa,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id_sucursal,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id_cliente,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id_factura,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".numero_comprobante,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".numero_dui,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".fecha,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".fecha_pago,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".fob,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".seguro,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".flete,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".porcentaje_fodi,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".porcentaje_iva,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".tasa_control,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".cfr,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".cif,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".total from "+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME;//+" as "+LiquidacionImpuestoImporConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".version_row from "+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME;//+" as "+LiquidacionImpuestoImporConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pedido_compra_impor=?,id_empresa=?,id_sucursal=?,id_cliente=?,id_factura=?,numero_comprobante=?,numero_dui=?,fecha=?,fecha_pago=?,fob=?,seguro=?,flete=?,porcentaje_fodi=?,porcentaje_iva=?,tasa_control=?,cfr=?,cif=?,total=?";
	
	public static String STOREPROCEDUREINSERT="call SP_LIQUIDACIONIMPUESTOIMPOR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_LIQUIDACIONIMPUESTOIMPOR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_LIQUIDACIONIMPUESTOIMPOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_LIQUIDACIONIMPUESTOIMPOR_SELECT(?,?)";
	
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
	
	
	protected LiquidacionImpuestoImporDataAccessAdditional liquidacionimpuestoimporDataAccessAdditional=null;
	
	public LiquidacionImpuestoImporDataAccessAdditional getLiquidacionImpuestoImporDataAccessAdditional() {
		return this.liquidacionimpuestoimporDataAccessAdditional;
	}
	
	public void setLiquidacionImpuestoImporDataAccessAdditional(LiquidacionImpuestoImporDataAccessAdditional liquidacionimpuestoimporDataAccessAdditional) {
		try {
			this.liquidacionimpuestoimporDataAccessAdditional=liquidacionimpuestoimporDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public LiquidacionImpuestoImporDataAccess() {
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
		LiquidacionImpuestoImporDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		LiquidacionImpuestoImporDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		LiquidacionImpuestoImporDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setLiquidacionImpuestoImporOriginal(LiquidacionImpuestoImpor liquidacionimpuestoimpor)throws Exception  {
		liquidacionimpuestoimpor.setLiquidacionImpuestoImporOriginal((LiquidacionImpuestoImpor)liquidacionimpuestoimpor.clone());		
	}
	
	public void setLiquidacionImpuestoImporsOriginal(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors)throws Exception  {
		
		for(LiquidacionImpuestoImpor liquidacionimpuestoimpor:liquidacionimpuestoimpors){
			liquidacionimpuestoimpor.setLiquidacionImpuestoImporOriginal((LiquidacionImpuestoImpor)liquidacionimpuestoimpor.clone());
		}
	}
	
	public static void setLiquidacionImpuestoImporOriginalStatic(LiquidacionImpuestoImpor liquidacionimpuestoimpor)throws Exception  {
		liquidacionimpuestoimpor.setLiquidacionImpuestoImporOriginal((LiquidacionImpuestoImpor)liquidacionimpuestoimpor.clone());		
	}
	
	public static void setLiquidacionImpuestoImporsOriginalStatic(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors)throws Exception  {
		
		for(LiquidacionImpuestoImpor liquidacionimpuestoimpor:liquidacionimpuestoimpors){
			liquidacionimpuestoimpor.setLiquidacionImpuestoImporOriginal((LiquidacionImpuestoImpor)liquidacionimpuestoimpor.clone());
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
	
	public  LiquidacionImpuestoImpor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();		
		
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
	
	public  LiquidacionImpuestoImpor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=LiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=LiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Importaciones.LiquidacionImpuestoImpor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setLiquidacionImpuestoImporOriginal(new LiquidacionImpuestoImpor());
      	    	entity=super.getEntity("",entity,resultSet,LiquidacionImpuestoImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityLiquidacionImpuestoImpor("",entity,resultSet); 
				
				//entity.setLiquidacionImpuestoImporOriginal(super.getEntity("",entity.getLiquidacionImpuestoImporOriginal(),resultSet,LiquidacionImpuestoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLiquidacionImpuestoImporOriginal(this.getEntityLiquidacionImpuestoImpor("",entity.getLiquidacionImpuestoImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseLiquidacionImpuestoImpor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  LiquidacionImpuestoImpor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();
				
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
	
	public  LiquidacionImpuestoImpor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=LiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=LiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LiquidacionImpuestoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.LiquidacionImpuestoImpor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setLiquidacionImpuestoImporOriginal(new LiquidacionImpuestoImpor());
      	    	entity=super.getEntity("",entity,resultSet,LiquidacionImpuestoImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityLiquidacionImpuestoImpor("",entity,resultSet);    
				
				//entity.setLiquidacionImpuestoImporOriginal(super.getEntity("",entity.getLiquidacionImpuestoImporOriginal(),resultSet,LiquidacionImpuestoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLiquidacionImpuestoImporOriginal(this.getEntityLiquidacionImpuestoImpor("",entity.getLiquidacionImpuestoImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseLiquidacionImpuestoImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //LiquidacionImpuestoImpor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=LiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=LiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LiquidacionImpuestoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.LiquidacionImpuestoImpor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseLiquidacionImpuestoImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<LiquidacionImpuestoImpor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<LiquidacionImpuestoImpor> entities = new  ArrayList<LiquidacionImpuestoImpor>();
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();		  
		
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
	
	public  List<LiquidacionImpuestoImpor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<LiquidacionImpuestoImpor> entities = new  ArrayList<LiquidacionImpuestoImpor>();
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=LiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=LiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LiquidacionImpuestoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LiquidacionImpuestoImpor();
      	    	entity=super.getEntity("",entity,resultSet,LiquidacionImpuestoImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityLiquidacionImpuestoImpor("",entity,resultSet);
      	    	
				//entity.setLiquidacionImpuestoImporOriginal( new LiquidacionImpuestoImpor());
      	    	//entity.setLiquidacionImpuestoImporOriginal(super.getEntity("",entity.getLiquidacionImpuestoImporOriginal(),resultSet,LiquidacionImpuestoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLiquidacionImpuestoImporOriginal(this.getEntityLiquidacionImpuestoImpor("",entity.getLiquidacionImpuestoImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseLiquidacionImpuestoImpors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLiquidacionImpuestoImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<LiquidacionImpuestoImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<LiquidacionImpuestoImpor> entities = new  ArrayList<LiquidacionImpuestoImpor>();
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();		  
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
	
	public  List<LiquidacionImpuestoImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<LiquidacionImpuestoImpor> entities = new  ArrayList<LiquidacionImpuestoImpor>();
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LiquidacionImpuestoImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapLiquidacionImpuestoImpor();
					//entity.setMapLiquidacionImpuestoImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapLiquidacionImpuestoImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapLiquidacionImpuestoImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,LiquidacionImpuestoImporDataAccess.ISWITHSCHEMA);         		
					entity=LiquidacionImpuestoImporDataAccess.getEntityLiquidacionImpuestoImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setLiquidacionImpuestoImporOriginal( new LiquidacionImpuestoImpor());
					////entity.setLiquidacionImpuestoImporOriginal(super.getEntity("",entity.getLiquidacionImpuestoImporOriginal(),resultSet,LiquidacionImpuestoImporDataAccess.ISWITHSCHEMA));         		
					////entity.setLiquidacionImpuestoImporOriginal(this.getEntityLiquidacionImpuestoImpor("",entity.getLiquidacionImpuestoImporOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseLiquidacionImpuestoImpors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLiquidacionImpuestoImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public LiquidacionImpuestoImpor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();		  
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
	
	public  LiquidacionImpuestoImpor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LiquidacionImpuestoImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapLiquidacionImpuestoImpor();
					//entity.setMapLiquidacionImpuestoImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapLiquidacionImpuestoImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapLiquidacionImpuestoImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,LiquidacionImpuestoImporDataAccess.ISWITHSCHEMA);         		
					entity=LiquidacionImpuestoImporDataAccess.getEntityLiquidacionImpuestoImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setLiquidacionImpuestoImporOriginal( new LiquidacionImpuestoImpor());
					////entity.setLiquidacionImpuestoImporOriginal(super.getEntity("",entity.getLiquidacionImpuestoImporOriginal(),resultSet,LiquidacionImpuestoImporDataAccess.ISWITHSCHEMA));         		
					////entity.setLiquidacionImpuestoImporOriginal(this.getEntityLiquidacionImpuestoImpor("",entity.getLiquidacionImpuestoImporOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseLiquidacionImpuestoImpor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLiquidacionImpuestoImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static LiquidacionImpuestoImpor getEntityLiquidacionImpuestoImpor(String strPrefijo,LiquidacionImpuestoImpor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = LiquidacionImpuestoImpor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = LiquidacionImpuestoImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					LiquidacionImpuestoImporDataAccess.setFieldReflectionLiquidacionImpuestoImpor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasLiquidacionImpuestoImpor=LiquidacionImpuestoImporConstantesFunciones.getTodosTiposColumnasLiquidacionImpuestoImpor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasLiquidacionImpuestoImpor) {
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
							field = LiquidacionImpuestoImpor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = LiquidacionImpuestoImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						LiquidacionImpuestoImporDataAccess.setFieldReflectionLiquidacionImpuestoImpor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionLiquidacionImpuestoImpor(Field field,String strPrefijo,String sColumn,LiquidacionImpuestoImpor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case LiquidacionImpuestoImporConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.NUMERODUI:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.FECHAPAGO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.FOB:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.SEGURO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.TASACONTROL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.CFR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.CIF:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case LiquidacionImpuestoImporConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<LiquidacionImpuestoImpor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<LiquidacionImpuestoImpor> entities = new  ArrayList<LiquidacionImpuestoImpor>();
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=LiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=LiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LiquidacionImpuestoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new LiquidacionImpuestoImpor();
					entity=super.getEntity("",entity,resultSet,LiquidacionImpuestoImporDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityLiquidacionImpuestoImpor("",entity,resultSet);
					
					//entity.setLiquidacionImpuestoImporOriginal( new LiquidacionImpuestoImpor());
					//entity.setLiquidacionImpuestoImporOriginal(super.getEntity("",entity.getLiquidacionImpuestoImporOriginal(),resultSet,LiquidacionImpuestoImporDataAccess.ISWITHSCHEMA));         		
					//entity.setLiquidacionImpuestoImporOriginal(this.getEntityLiquidacionImpuestoImpor("",entity.getLiquidacionImpuestoImporOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseLiquidacionImpuestoImpors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLiquidacionImpuestoImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<LiquidacionImpuestoImpor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<LiquidacionImpuestoImpor> entities = new  ArrayList<LiquidacionImpuestoImpor>();
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=LiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=LiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LiquidacionImpuestoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<LiquidacionImpuestoImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<LiquidacionImpuestoImpor> entities = new  ArrayList<LiquidacionImpuestoImpor>();
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();		  
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
	
	public  List<LiquidacionImpuestoImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<LiquidacionImpuestoImpor> entities = new  ArrayList<LiquidacionImpuestoImpor>();
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LiquidacionImpuestoImpor();
      	    	entity=super.getEntity("",entity,resultSet,LiquidacionImpuestoImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityLiquidacionImpuestoImpor("",entity,resultSet);
      	    	
				//entity.setLiquidacionImpuestoImporOriginal( new LiquidacionImpuestoImpor());
      	    	//entity.setLiquidacionImpuestoImporOriginal(super.getEntity("",entity.getLiquidacionImpuestoImporOriginal(),resultSet,LiquidacionImpuestoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLiquidacionImpuestoImporOriginal(this.getEntityLiquidacionImpuestoImpor("",entity.getLiquidacionImpuestoImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseLiquidacionImpuestoImpors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLiquidacionImpuestoImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<LiquidacionImpuestoImpor> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<LiquidacionImpuestoImpor> entities = new  ArrayList<LiquidacionImpuestoImpor>();
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();		  
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
	
	public  List<LiquidacionImpuestoImpor> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<LiquidacionImpuestoImpor> entities = new  ArrayList<LiquidacionImpuestoImpor>();
		LiquidacionImpuestoImpor entity = new LiquidacionImpuestoImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LiquidacionImpuestoImpor();
      	    	entity=super.getEntity("",entity,resultSet,LiquidacionImpuestoImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityLiquidacionImpuestoImpor("",entity,resultSet);
      	    	
				//entity.setLiquidacionImpuestoImporOriginal( new LiquidacionImpuestoImpor());
      	    	//entity.setLiquidacionImpuestoImporOriginal(super.getEntity("",entity.getLiquidacionImpuestoImporOriginal(),resultSet,LiquidacionImpuestoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLiquidacionImpuestoImporOriginal(this.getEntityLiquidacionImpuestoImpor("",entity.getLiquidacionImpuestoImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseLiquidacionImpuestoImpors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public LiquidacionImpuestoImpor getEntityLiquidacionImpuestoImpor(String strPrefijo,LiquidacionImpuestoImpor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_pedido_compra_impor(resultSet.getLong(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR));
				entity.setid_empresa(resultSet.getLong(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL));
				entity.setid_cliente(resultSet.getLong(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.IDCLIENTE));
				entity.setid_factura(resultSet.getLong(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.IDFACTURA));
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setnumero_dui(resultSet.getString(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.NUMERODUI));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.FECHA).getTime()));
				entity.setfecha_pago(new Date(resultSet.getDate(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.FECHAPAGO).getTime()));
				entity.setfob(resultSet.getDouble(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.FOB));
				entity.setseguro(resultSet.getDouble(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.SEGURO));
				entity.setflete(resultSet.getDouble(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.FLETE));
				entity.setporcentaje_fodi(resultSet.getDouble(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI));
				entity.setporcentaje_iva(resultSet.getDouble(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA));
				entity.settasa_control(resultSet.getDouble(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.TASACONTROL));
				entity.setcfr(resultSet.getDouble(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.CFR));
				entity.setcif(resultSet.getDouble(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.CIF));
				entity.settotal(resultSet.getDouble(strPrefijo+LiquidacionImpuestoImporConstantesFunciones.TOTAL));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowLiquidacionImpuestoImpor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(LiquidacionImpuestoImpor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=LiquidacionImpuestoImporDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=LiquidacionImpuestoImporDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=LiquidacionImpuestoImporDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=LiquidacionImpuestoImporDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(LiquidacionImpuestoImporConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,LiquidacionImpuestoImporDataAccess.TABLENAME,LiquidacionImpuestoImporDataAccess.ISWITHSTOREPROCEDURES);
			
			LiquidacionImpuestoImporDataAccess.setLiquidacionImpuestoImporOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public PedidoCompraImpor getPedidoCompraImpor(Connexion connexion,LiquidacionImpuestoImpor relliquidacionimpuestoimpor)throws SQLException,Exception {

		PedidoCompraImpor pedidocompraimpor= new PedidoCompraImpor();

		try {
			PedidoCompraImporDataAccess pedidocompraimporDataAccess=new PedidoCompraImporDataAccess();

			pedidocompraimporDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			pedidocompraimporDataAccess.setConnexionType(this.connexionType);
			pedidocompraimporDataAccess.setParameterDbType(this.parameterDbType);

			pedidocompraimpor=pedidocompraimporDataAccess.getEntity(connexion,relliquidacionimpuestoimpor.getid_pedido_compra_impor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompraimpor;

	}

	public Empresa getEmpresa(Connexion connexion,LiquidacionImpuestoImpor relliquidacionimpuestoimpor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relliquidacionimpuestoimpor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,LiquidacionImpuestoImpor relliquidacionimpuestoimpor)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relliquidacionimpuestoimpor.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Cliente getCliente(Connexion connexion,LiquidacionImpuestoImpor relliquidacionimpuestoimpor)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relliquidacionimpuestoimpor.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Factura getFactura(Connexion connexion,LiquidacionImpuestoImpor relliquidacionimpuestoimpor)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relliquidacionimpuestoimpor.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}


		
		public List<DetalleLiquidacionImpuestoImpor> getDetalleLiquidacionImpuestoImpors(Connexion connexion,LiquidacionImpuestoImpor liquidacionimpuestoimpor)throws SQLException,Exception {

		List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors= new ArrayList<DetalleLiquidacionImpuestoImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+".liquidacion_impuesto_impor ON "+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+".detalle_liquidacion_impuesto_impor.id_liquidacion_impuesto_impor="+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+".liquidacion_impuesto_impor.id WHERE "+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+".liquidacion_impuesto_impor.id="+String.valueOf(liquidacionimpuestoimpor.getId());
			} else {
				sQuery=" INNER JOIN detalleliquidacionimpuestoimpor.LiquidacionImpuestoImpor WHERE detalleliquidacionimpuestoimpor.LiquidacionImpuestoImpor.id="+String.valueOf(liquidacionimpuestoimpor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleLiquidacionImpuestoImporDataAccess detalleliquidacionimpuestoimporDataAccess=new DetalleLiquidacionImpuestoImporDataAccess();

			detalleliquidacionimpuestoimporDataAccess.setConnexionType(this.connexionType);
			detalleliquidacionimpuestoimporDataAccess.setParameterDbType(this.parameterDbType);
			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleliquidacionimpuestoimpors;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,LiquidacionImpuestoImpor liquidacionimpuestoimpor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!liquidacionimpuestoimpor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pedido_compra_impor=new ParameterValue<Long>();
					parameterMaintenanceValueid_pedido_compra_impor.setValue(liquidacionimpuestoimpor.getid_pedido_compra_impor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pedido_compra_impor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(liquidacionimpuestoimpor.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(liquidacionimpuestoimpor.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(liquidacionimpuestoimpor.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(liquidacionimpuestoimpor.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(liquidacionimpuestoimpor.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_dui=new ParameterValue<String>();
					parameterMaintenanceValuenumero_dui.setValue(liquidacionimpuestoimpor.getnumero_dui());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_dui);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(liquidacionimpuestoimpor.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_pago=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_pago.setValue(liquidacionimpuestoimpor.getfecha_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefob=new ParameterValue<Double>();
					parameterMaintenanceValuefob.setValue(liquidacionimpuestoimpor.getfob());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefob);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueseguro=new ParameterValue<Double>();
					parameterMaintenanceValueseguro.setValue(liquidacionimpuestoimpor.getseguro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueseguro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueflete=new ParameterValue<Double>();
					parameterMaintenanceValueflete.setValue(liquidacionimpuestoimpor.getflete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueflete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_fodi=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_fodi.setValue(liquidacionimpuestoimpor.getporcentaje_fodi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_fodi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_iva=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_iva.setValue(liquidacionimpuestoimpor.getporcentaje_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetasa_control=new ParameterValue<Double>();
					parameterMaintenanceValuetasa_control.setValue(liquidacionimpuestoimpor.gettasa_control());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetasa_control);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecfr=new ParameterValue<Double>();
					parameterMaintenanceValuecfr.setValue(liquidacionimpuestoimpor.getcfr());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecfr);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecif=new ParameterValue<Double>();
					parameterMaintenanceValuecif.setValue(liquidacionimpuestoimpor.getcif());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecif);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(liquidacionimpuestoimpor.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
						if(!liquidacionimpuestoimpor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(liquidacionimpuestoimpor.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(liquidacionimpuestoimpor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(liquidacionimpuestoimpor.getId());
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
	
	public void setIsNewIsChangedFalseLiquidacionImpuestoImpor(LiquidacionImpuestoImpor liquidacionimpuestoimpor)throws Exception  {		
		liquidacionimpuestoimpor.setIsNew(false);
		liquidacionimpuestoimpor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseLiquidacionImpuestoImpors(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors)throws Exception  {				
		for(LiquidacionImpuestoImpor liquidacionimpuestoimpor:liquidacionimpuestoimpors) {
			liquidacionimpuestoimpor.setIsNew(false);
			liquidacionimpuestoimpor.setIsChanged(false);
		}
	}
	
	public void generarExportarLiquidacionImpuestoImpor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   

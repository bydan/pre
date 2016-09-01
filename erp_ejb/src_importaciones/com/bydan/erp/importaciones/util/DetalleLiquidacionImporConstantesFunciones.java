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
package com.bydan.erp.importaciones.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.importaciones.util.DetalleLiquidacionImporConstantesFunciones;
import com.bydan.erp.importaciones.util.DetalleLiquidacionImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.DetalleLiquidacionImporParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleLiquidacionImporConstantesFunciones extends DetalleLiquidacionImporConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="DetalleLiquidacionImpor";
	public static final String SPATHOPCION="Importaciones";	
	public static final String SPATHMODULO="importaciones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleLiquidacionImpor"+DetalleLiquidacionImporConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleLiquidacionImporHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleLiquidacionImporHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleLiquidacionImporConstantesFunciones.SCHEMA+"_"+DetalleLiquidacionImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleLiquidacionImporHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleLiquidacionImporConstantesFunciones.SCHEMA+"_"+DetalleLiquidacionImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleLiquidacionImporConstantesFunciones.SCHEMA+"_"+DetalleLiquidacionImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleLiquidacionImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleLiquidacionImporConstantesFunciones.SCHEMA+"_"+DetalleLiquidacionImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleLiquidacionImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleLiquidacionImporHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleLiquidacionImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleLiquidacionImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleLiquidacionImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleLiquidacionImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleLiquidacionImporConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleLiquidacionImporConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleLiquidacionImporConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleLiquidacionImporConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Liquidacion Impores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Detalle Liquidacion Impor";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Liquidacion Impor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleLiquidacionImpor";
	public static final String OBJECTNAME="detalleliquidacionimpor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_IMPORTACIONES;	
	public static final String TABLENAME="detalle_liquidacion_impor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleliquidacionimpor from "+DetalleLiquidacionImporConstantesFunciones.SPERSISTENCENAME+" detalleliquidacionimpor";
	public static String QUERYSELECTNATIVE="select "+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".id,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".version_row,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".id_liquidacion_impor,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".id_empresa,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".id_usuario,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".id_costo_gasto_impor,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".valor,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".fecha,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".referencia,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".impuesto,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".impuesto2,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".impuesto3,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".impuesto4,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".impuesto5 from "+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME;//+" as "+DetalleLiquidacionImporConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleLiquidacionImporConstantesFuncionesAdditional detalleliquidacionimporConstantesFuncionesAdditional=null;
	
	public DetalleLiquidacionImporConstantesFuncionesAdditional getDetalleLiquidacionImporConstantesFuncionesAdditional() {
		return this.detalleliquidacionimporConstantesFuncionesAdditional;
	}
	
	public void setDetalleLiquidacionImporConstantesFuncionesAdditional(DetalleLiquidacionImporConstantesFuncionesAdditional detalleliquidacionimporConstantesFuncionesAdditional) {
		try {
			this.detalleliquidacionimporConstantesFuncionesAdditional=detalleliquidacionimporConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDLIQUIDACIONIMPOR= "id_liquidacion_impor";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDCOSTOGASTOIMPOR= "id_costo_gasto_impor";
    public static final String VALOR= "valor";
    public static final String FECHA= "fecha";
    public static final String REFERENCIA= "referencia";
    public static final String IMPUESTO= "impuesto";
    public static final String IMPUESTO2= "impuesto2";
    public static final String IMPUESTO3= "impuesto3";
    public static final String IMPUESTO4= "impuesto4";
    public static final String IMPUESTO5= "impuesto5";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDLIQUIDACIONIMPOR= "Liquacion Impor";
		public static final String LABEL_IDLIQUIDACIONIMPOR_LOWER= "Liquidacion Impor";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDCOSTOGASTOIMPOR= "Costo Gasto Impor";
		public static final String LABEL_IDCOSTOGASTOIMPOR_LOWER= "Costo Gasto Impor";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_REFERENCIA= "Referencia";
		public static final String LABEL_REFERENCIA_LOWER= "Referencia";
    	public static final String LABEL_IMPUESTO= "Impuesto";
		public static final String LABEL_IMPUESTO_LOWER= "Impuesto";
    	public static final String LABEL_IMPUESTO2= "Impuesto2";
		public static final String LABEL_IMPUESTO2_LOWER= "Impuesto2";
    	public static final String LABEL_IMPUESTO3= "Impuesto3";
		public static final String LABEL_IMPUESTO3_LOWER= "Impuesto3";
    	public static final String LABEL_IMPUESTO4= "Impuesto4";
		public static final String LABEL_IMPUESTO4_LOWER= "Impuesto4";
    	public static final String LABEL_IMPUESTO5= "Impuesto5";
		public static final String LABEL_IMPUESTO5_LOWER= "Impuesto5";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXREFERENCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXREFERENCIA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getDetalleLiquidacionImporLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleLiquidacionImporConstantesFunciones.IDLIQUIDACIONIMPOR)) {sLabelColumna=DetalleLiquidacionImporConstantesFunciones.LABEL_IDLIQUIDACIONIMPOR;}
		if(sNombreColumna.equals(DetalleLiquidacionImporConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleLiquidacionImporConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleLiquidacionImporConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleLiquidacionImporConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleLiquidacionImporConstantesFunciones.IDUSUARIO)) {sLabelColumna=DetalleLiquidacionImporConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(DetalleLiquidacionImporConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=DetalleLiquidacionImporConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(DetalleLiquidacionImporConstantesFunciones.IDCOSTOGASTOIMPOR)) {sLabelColumna=DetalleLiquidacionImporConstantesFunciones.LABEL_IDCOSTOGASTOIMPOR;}
		if(sNombreColumna.equals(DetalleLiquidacionImporConstantesFunciones.VALOR)) {sLabelColumna=DetalleLiquidacionImporConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(DetalleLiquidacionImporConstantesFunciones.FECHA)) {sLabelColumna=DetalleLiquidacionImporConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(DetalleLiquidacionImporConstantesFunciones.REFERENCIA)) {sLabelColumna=DetalleLiquidacionImporConstantesFunciones.LABEL_REFERENCIA;}
		if(sNombreColumna.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO)) {sLabelColumna=DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO;}
		if(sNombreColumna.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO2)) {sLabelColumna=DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO2;}
		if(sNombreColumna.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO3)) {sLabelColumna=DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO3;}
		if(sNombreColumna.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO4)) {sLabelColumna=DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO4;}
		if(sNombreColumna.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO5)) {sLabelColumna=DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO5;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleLiquidacionImporDescripcion(DetalleLiquidacionImpor detalleliquidacionimpor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleliquidacionimpor !=null/* && detalleliquidacionimpor.getId()!=0*/) {
			if(detalleliquidacionimpor.getId()!=null) {
				sDescripcion=detalleliquidacionimpor.getId().toString();
			}//detalleliquidacionimpordetalleliquidacionimpor.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleLiquidacionImporDescripcionDetallado(DetalleLiquidacionImpor detalleliquidacionimpor) {
		String sDescripcion="";
			
		sDescripcion+=DetalleLiquidacionImporConstantesFunciones.ID+"=";
		sDescripcion+=detalleliquidacionimpor.getId().toString()+",";
		sDescripcion+=DetalleLiquidacionImporConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleliquidacionimpor.getVersionRow().toString()+",";
		sDescripcion+=DetalleLiquidacionImporConstantesFunciones.IDLIQUIDACIONIMPOR+"=";
		sDescripcion+=detalleliquidacionimpor.getid_liquidacion_impor().toString()+",";
		sDescripcion+=DetalleLiquidacionImporConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleliquidacionimpor.getid_empresa().toString()+",";
		sDescripcion+=DetalleLiquidacionImporConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalleliquidacionimpor.getid_sucursal().toString()+",";
		sDescripcion+=DetalleLiquidacionImporConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=detalleliquidacionimpor.getid_usuario().toString()+",";
		sDescripcion+=DetalleLiquidacionImporConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=detalleliquidacionimpor.getid_centro_costo().toString()+",";
		sDescripcion+=DetalleLiquidacionImporConstantesFunciones.IDCOSTOGASTOIMPOR+"=";
		sDescripcion+=detalleliquidacionimpor.getid_costo_gasto_impor().toString()+",";
		sDescripcion+=DetalleLiquidacionImporConstantesFunciones.VALOR+"=";
		sDescripcion+=detalleliquidacionimpor.getvalor().toString()+",";
		sDescripcion+=DetalleLiquidacionImporConstantesFunciones.FECHA+"=";
		sDescripcion+=detalleliquidacionimpor.getfecha().toString()+",";
		sDescripcion+=DetalleLiquidacionImporConstantesFunciones.REFERENCIA+"=";
		sDescripcion+=detalleliquidacionimpor.getreferencia()+",";
		sDescripcion+=DetalleLiquidacionImporConstantesFunciones.IMPUESTO+"=";
		sDescripcion+=detalleliquidacionimpor.getimpuesto().toString()+",";
		sDescripcion+=DetalleLiquidacionImporConstantesFunciones.IMPUESTO2+"=";
		sDescripcion+=detalleliquidacionimpor.getimpuesto2().toString()+",";
		sDescripcion+=DetalleLiquidacionImporConstantesFunciones.IMPUESTO3+"=";
		sDescripcion+=detalleliquidacionimpor.getimpuesto3().toString()+",";
		sDescripcion+=DetalleLiquidacionImporConstantesFunciones.IMPUESTO4+"=";
		sDescripcion+=detalleliquidacionimpor.getimpuesto4().toString()+",";
		sDescripcion+=DetalleLiquidacionImporConstantesFunciones.IMPUESTO5+"=";
		sDescripcion+=detalleliquidacionimpor.getimpuesto5().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleLiquidacionImporDescripcion(DetalleLiquidacionImpor detalleliquidacionimpor,String sValor) throws Exception {			
		if(detalleliquidacionimpor !=null) {
			//detalleliquidacionimpordetalleliquidacionimpor.getId().toString();
		}		
	}
	
		

	public static String getLiquidacionImporDescripcion(LiquidacionImpor liquidacionimpor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(liquidacionimpor!=null/*&&liquidacionimpor.getId()>0*/) {
			sDescripcion=LiquidacionImporConstantesFunciones.getLiquidacionImporDescripcion(liquidacionimpor);
		}

		return sDescripcion;
	}

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
		}

		return sDescripcion;
	}

	public static String getCostoGastoImporDescripcion(CostoGastoImpor costogastoimpor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(costogastoimpor!=null/*&&costogastoimpor.getId()>0*/) {
			sDescripcion=CostoGastoImporConstantesFunciones.getCostoGastoImporDescripcion(costogastoimpor);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCostoGastoImpor")) {
			sNombreIndice="Tipo=  Por Costo Gasto Impor";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdLiquidacionImpor")) {
			sNombreIndice="Tipo=  Por Liquacion Impor";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCostoGastoImpor(Long id_costo_gasto_impor) {
		String sDetalleIndice=" Parametros->";
		if(id_costo_gasto_impor!=null) {sDetalleIndice+=" Codigo Unico De Costo Gasto Impor="+id_costo_gasto_impor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLiquidacionImpor(Long id_liquidacion_impor) {
		String sDetalleIndice=" Parametros->";
		if(id_liquidacion_impor!=null) {sDetalleIndice+=" Codigo Unico De Liquacion Impor="+id_liquidacion_impor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleLiquidacionImpor(DetalleLiquidacionImpor detalleliquidacionimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleliquidacionimpor.setreferencia(detalleliquidacionimpor.getreferencia().trim());
	}
	
	public static void quitarEspaciosDetalleLiquidacionImpors(List<DetalleLiquidacionImpor> detalleliquidacionimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleLiquidacionImpor detalleliquidacionimpor: detalleliquidacionimpors) {
			detalleliquidacionimpor.setreferencia(detalleliquidacionimpor.getreferencia().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleLiquidacionImpor(DetalleLiquidacionImpor detalleliquidacionimpor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleliquidacionimpor.getConCambioAuxiliar()) {
			detalleliquidacionimpor.setIsDeleted(detalleliquidacionimpor.getIsDeletedAuxiliar());	
			detalleliquidacionimpor.setIsNew(detalleliquidacionimpor.getIsNewAuxiliar());	
			detalleliquidacionimpor.setIsChanged(detalleliquidacionimpor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleliquidacionimpor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleliquidacionimpor.setIsDeletedAuxiliar(false);	
			detalleliquidacionimpor.setIsNewAuxiliar(false);	
			detalleliquidacionimpor.setIsChangedAuxiliar(false);
			
			detalleliquidacionimpor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleLiquidacionImpors(List<DetalleLiquidacionImpor> detalleliquidacionimpors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleLiquidacionImpor detalleliquidacionimpor : detalleliquidacionimpors) {
			if(conAsignarBase && detalleliquidacionimpor.getConCambioAuxiliar()) {
				detalleliquidacionimpor.setIsDeleted(detalleliquidacionimpor.getIsDeletedAuxiliar());	
				detalleliquidacionimpor.setIsNew(detalleliquidacionimpor.getIsNewAuxiliar());	
				detalleliquidacionimpor.setIsChanged(detalleliquidacionimpor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleliquidacionimpor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleliquidacionimpor.setIsDeletedAuxiliar(false);	
				detalleliquidacionimpor.setIsNewAuxiliar(false);	
				detalleliquidacionimpor.setIsChangedAuxiliar(false);
				
				detalleliquidacionimpor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleLiquidacionImpor(DetalleLiquidacionImpor detalleliquidacionimpor,Boolean conEnteros) throws Exception  {
		detalleliquidacionimpor.setvalor(0.0);
		detalleliquidacionimpor.setimpuesto(0.0);
		detalleliquidacionimpor.setimpuesto2(0.0);
		detalleliquidacionimpor.setimpuesto3(0.0);
		detalleliquidacionimpor.setimpuesto4(0.0);
		detalleliquidacionimpor.setimpuesto5(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleLiquidacionImpors(List<DetalleLiquidacionImpor> detalleliquidacionimpors,Boolean conEnteros) throws Exception  {
		
		for(DetalleLiquidacionImpor detalleliquidacionimpor: detalleliquidacionimpors) {
			detalleliquidacionimpor.setvalor(0.0);
			detalleliquidacionimpor.setimpuesto(0.0);
			detalleliquidacionimpor.setimpuesto2(0.0);
			detalleliquidacionimpor.setimpuesto3(0.0);
			detalleliquidacionimpor.setimpuesto4(0.0);
			detalleliquidacionimpor.setimpuesto5(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleLiquidacionImpor(List<DetalleLiquidacionImpor> detalleliquidacionimpors,DetalleLiquidacionImpor detalleliquidacionimporAux) throws Exception  {
		DetalleLiquidacionImporConstantesFunciones.InicializarValoresDetalleLiquidacionImpor(detalleliquidacionimporAux,true);
		
		for(DetalleLiquidacionImpor detalleliquidacionimpor: detalleliquidacionimpors) {
			if(detalleliquidacionimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleliquidacionimporAux.setvalor(detalleliquidacionimporAux.getvalor()+detalleliquidacionimpor.getvalor());			
			detalleliquidacionimporAux.setimpuesto(detalleliquidacionimporAux.getimpuesto()+detalleliquidacionimpor.getimpuesto());			
			detalleliquidacionimporAux.setimpuesto2(detalleliquidacionimporAux.getimpuesto2()+detalleliquidacionimpor.getimpuesto2());			
			detalleliquidacionimporAux.setimpuesto3(detalleliquidacionimporAux.getimpuesto3()+detalleliquidacionimpor.getimpuesto3());			
			detalleliquidacionimporAux.setimpuesto4(detalleliquidacionimporAux.getimpuesto4()+detalleliquidacionimpor.getimpuesto4());			
			detalleliquidacionimporAux.setimpuesto5(detalleliquidacionimporAux.getimpuesto5()+detalleliquidacionimpor.getimpuesto5());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleLiquidacionImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleLiquidacionImporConstantesFunciones.getArrayColumnasGlobalesDetalleLiquidacionImpor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleLiquidacionImpor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleLiquidacionImporConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleLiquidacionImporConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleLiquidacionImporConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleLiquidacionImporConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleLiquidacionImporConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleLiquidacionImporConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleLiquidacionImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleLiquidacionImpor> detalleliquidacionimpors,DetalleLiquidacionImpor detalleliquidacionimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleLiquidacionImpor detalleliquidacionimporAux: detalleliquidacionimpors) {
			if(detalleliquidacionimporAux!=null && detalleliquidacionimpor!=null) {
				if((detalleliquidacionimporAux.getId()==null && detalleliquidacionimpor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleliquidacionimporAux.getId()!=null && detalleliquidacionimpor.getId()!=null){
					if(detalleliquidacionimporAux.getId().equals(detalleliquidacionimpor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleLiquidacionImpor(List<DetalleLiquidacionImpor> detalleliquidacionimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double impuestoTotal=0.0;
		Double impuesto2Total=0.0;
		Double impuesto3Total=0.0;
		Double impuesto4Total=0.0;
		Double impuesto5Total=0.0;
	
		for(DetalleLiquidacionImpor detalleliquidacionimpor: detalleliquidacionimpors) {			
			if(detalleliquidacionimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=detalleliquidacionimpor.getvalor();
			impuestoTotal+=detalleliquidacionimpor.getimpuesto();
			impuesto2Total+=detalleliquidacionimpor.getimpuesto2();
			impuesto3Total+=detalleliquidacionimpor.getimpuesto3();
			impuesto4Total+=detalleliquidacionimpor.getimpuesto4();
			impuesto5Total+=detalleliquidacionimpor.getimpuesto5();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImporConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImporConstantesFunciones.IMPUESTO);
		datoGeneral.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO);
		datoGeneral.setdValorDouble(impuestoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImporConstantesFunciones.IMPUESTO2);
		datoGeneral.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO2);
		datoGeneral.setdValorDouble(impuesto2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImporConstantesFunciones.IMPUESTO3);
		datoGeneral.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO3);
		datoGeneral.setdValorDouble(impuesto3Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImporConstantesFunciones.IMPUESTO4);
		datoGeneral.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO4);
		datoGeneral.setdValorDouble(impuesto4Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImporConstantesFunciones.IMPUESTO5);
		datoGeneral.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO5);
		datoGeneral.setdValorDouble(impuesto5Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleLiquidacionImpor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleLiquidacionImporConstantesFunciones.LABEL_ID, DetalleLiquidacionImporConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImporConstantesFunciones.LABEL_VERSIONROW, DetalleLiquidacionImporConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImporConstantesFunciones.LABEL_IDLIQUIDACIONIMPOR, DetalleLiquidacionImporConstantesFunciones.IDLIQUIDACIONIMPOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImporConstantesFunciones.LABEL_IDEMPRESA, DetalleLiquidacionImporConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImporConstantesFunciones.LABEL_IDSUCURSAL, DetalleLiquidacionImporConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImporConstantesFunciones.LABEL_IDUSUARIO, DetalleLiquidacionImporConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImporConstantesFunciones.LABEL_IDCENTROCOSTO, DetalleLiquidacionImporConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImporConstantesFunciones.LABEL_IDCOSTOGASTOIMPOR, DetalleLiquidacionImporConstantesFunciones.IDCOSTOGASTOIMPOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImporConstantesFunciones.LABEL_VALOR, DetalleLiquidacionImporConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImporConstantesFunciones.LABEL_FECHA, DetalleLiquidacionImporConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImporConstantesFunciones.LABEL_REFERENCIA, DetalleLiquidacionImporConstantesFunciones.REFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO, DetalleLiquidacionImporConstantesFunciones.IMPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO2, DetalleLiquidacionImporConstantesFunciones.IMPUESTO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO3, DetalleLiquidacionImporConstantesFunciones.IMPUESTO3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO4, DetalleLiquidacionImporConstantesFunciones.IMPUESTO4,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO5, DetalleLiquidacionImporConstantesFunciones.IMPUESTO5,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleLiquidacionImpor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImporConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImporConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImporConstantesFunciones.IDLIQUIDACIONIMPOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImporConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImporConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImporConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImporConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImporConstantesFunciones.IDCOSTOGASTOIMPOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImporConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImporConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImporConstantesFunciones.REFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImporConstantesFunciones.IMPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImporConstantesFunciones.IMPUESTO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImporConstantesFunciones.IMPUESTO3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImporConstantesFunciones.IMPUESTO4;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImporConstantesFunciones.IMPUESTO5;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleLiquidacionImpor() throws Exception  {
		return DetalleLiquidacionImporConstantesFunciones.getTiposSeleccionarDetalleLiquidacionImpor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleLiquidacionImpor(Boolean conFk) throws Exception  {
		return DetalleLiquidacionImporConstantesFunciones.getTiposSeleccionarDetalleLiquidacionImpor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleLiquidacionImpor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImporConstantesFunciones.LABEL_IDLIQUIDACIONIMPOR);
			reporte.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IDLIQUIDACIONIMPOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImporConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImporConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImporConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImporConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImporConstantesFunciones.LABEL_IDCOSTOGASTOIMPOR);
			reporte.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IDCOSTOGASTOIMPOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImporConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImporConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImporConstantesFunciones.LABEL_REFERENCIA);
			reporte.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_REFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO);
			reporte.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO2);
			reporte.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO3);
			reporte.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO4);
			reporte.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO4);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO5);
			reporte.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO5);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleLiquidacionImpor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(DetalleLiquidacionImpor detalleliquidacionimporAux) throws Exception {
		
			detalleliquidacionimporAux.setliquidacionimpor_descripcion(LiquidacionImporConstantesFunciones.getLiquidacionImporDescripcion(detalleliquidacionimporAux.getLiquidacionImpor()));
			detalleliquidacionimporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleliquidacionimporAux.getEmpresa()));
			detalleliquidacionimporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleliquidacionimporAux.getSucursal()));
			detalleliquidacionimporAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(detalleliquidacionimporAux.getUsuario()));
			detalleliquidacionimporAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detalleliquidacionimporAux.getCentroCosto()));
			detalleliquidacionimporAux.setcostogastoimpor_descripcion(CostoGastoImporConstantesFunciones.getCostoGastoImporDescripcion(detalleliquidacionimporAux.getCostoGastoImpor()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(List<DetalleLiquidacionImpor> detalleliquidacionimporsTemp) throws Exception {
		for(DetalleLiquidacionImpor detalleliquidacionimporAux:detalleliquidacionimporsTemp) {
			
			detalleliquidacionimporAux.setliquidacionimpor_descripcion(LiquidacionImporConstantesFunciones.getLiquidacionImporDescripcion(detalleliquidacionimporAux.getLiquidacionImpor()));
			detalleliquidacionimporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleliquidacionimporAux.getEmpresa()));
			detalleliquidacionimporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleliquidacionimporAux.getSucursal()));
			detalleliquidacionimporAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(detalleliquidacionimporAux.getUsuario()));
			detalleliquidacionimporAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detalleliquidacionimporAux.getCentroCosto()));
			detalleliquidacionimporAux.setcostogastoimpor_descripcion(CostoGastoImporConstantesFunciones.getCostoGastoImporDescripcion(detalleliquidacionimporAux.getCostoGastoImpor()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleLiquidacionImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(LiquidacionImpor.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(CostoGastoImpor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(LiquidacionImpor.class)) {
						classes.add(new Classe(LiquidacionImpor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CostoGastoImpor.class)) {
						classes.add(new Classe(CostoGastoImpor.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleLiquidacionImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(LiquidacionImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LiquidacionImpor.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(CostoGastoImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CostoGastoImpor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(LiquidacionImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LiquidacionImpor.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(CostoGastoImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CostoGastoImpor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleLiquidacionImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleLiquidacionImporConstantesFunciones.getClassesRelationshipsOfDetalleLiquidacionImpor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleLiquidacionImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleLiquidacionImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleLiquidacionImporConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleLiquidacionImpor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleLiquidacionImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(DetalleLiquidacionImpor detalleliquidacionimpor,List<DetalleLiquidacionImpor> detalleliquidacionimpors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleLiquidacionImpor detalleliquidacionimporEncontrado=null;
			
			for(DetalleLiquidacionImpor detalleliquidacionimporLocal:detalleliquidacionimpors) {
				if(detalleliquidacionimporLocal.getId().equals(detalleliquidacionimpor.getId())) {
					detalleliquidacionimporEncontrado=detalleliquidacionimporLocal;
					
					detalleliquidacionimporLocal.setIsChanged(detalleliquidacionimpor.getIsChanged());
					detalleliquidacionimporLocal.setIsNew(detalleliquidacionimpor.getIsNew());
					detalleliquidacionimporLocal.setIsDeleted(detalleliquidacionimpor.getIsDeleted());
					
					detalleliquidacionimporLocal.setGeneralEntityOriginal(detalleliquidacionimpor.getGeneralEntityOriginal());
					
					detalleliquidacionimporLocal.setId(detalleliquidacionimpor.getId());	
					detalleliquidacionimporLocal.setVersionRow(detalleliquidacionimpor.getVersionRow());	
					detalleliquidacionimporLocal.setid_liquidacion_impor(detalleliquidacionimpor.getid_liquidacion_impor());	
					detalleliquidacionimporLocal.setid_empresa(detalleliquidacionimpor.getid_empresa());	
					detalleliquidacionimporLocal.setid_sucursal(detalleliquidacionimpor.getid_sucursal());	
					detalleliquidacionimporLocal.setid_usuario(detalleliquidacionimpor.getid_usuario());	
					detalleliquidacionimporLocal.setid_centro_costo(detalleliquidacionimpor.getid_centro_costo());	
					detalleliquidacionimporLocal.setid_costo_gasto_impor(detalleliquidacionimpor.getid_costo_gasto_impor());	
					detalleliquidacionimporLocal.setvalor(detalleliquidacionimpor.getvalor());	
					detalleliquidacionimporLocal.setfecha(detalleliquidacionimpor.getfecha());	
					detalleliquidacionimporLocal.setreferencia(detalleliquidacionimpor.getreferencia());	
					detalleliquidacionimporLocal.setimpuesto(detalleliquidacionimpor.getimpuesto());	
					detalleliquidacionimporLocal.setimpuesto2(detalleliquidacionimpor.getimpuesto2());	
					detalleliquidacionimporLocal.setimpuesto3(detalleliquidacionimpor.getimpuesto3());	
					detalleliquidacionimporLocal.setimpuesto4(detalleliquidacionimpor.getimpuesto4());	
					detalleliquidacionimporLocal.setimpuesto5(detalleliquidacionimpor.getimpuesto5());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleliquidacionimpor.getIsDeleted()) {
				if(!existe) {
					detalleliquidacionimpors.add(detalleliquidacionimpor);
				}
			} else {
				if(detalleliquidacionimporEncontrado!=null && permiteQuitar)  {
					detalleliquidacionimpors.remove(detalleliquidacionimporEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleLiquidacionImpor detalleliquidacionimpor,List<DetalleLiquidacionImpor> detalleliquidacionimpors) throws Exception {
		try	{			
			for(DetalleLiquidacionImpor detalleliquidacionimporLocal:detalleliquidacionimpors) {
				if(detalleliquidacionimporLocal.getId().equals(detalleliquidacionimpor.getId())) {
					detalleliquidacionimporLocal.setIsSelected(detalleliquidacionimpor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleLiquidacionImpor(List<DetalleLiquidacionImpor> detalleliquidacionimporsAux) throws Exception {
		//this.detalleliquidacionimporsAux=detalleliquidacionimporsAux;
		
		for(DetalleLiquidacionImpor detalleliquidacionimporAux:detalleliquidacionimporsAux) {
			if(detalleliquidacionimporAux.getIsChanged()) {
				detalleliquidacionimporAux.setIsChanged(false);
			}		
			
			if(detalleliquidacionimporAux.getIsNew()) {
				detalleliquidacionimporAux.setIsNew(false);
			}	
			
			if(detalleliquidacionimporAux.getIsDeleted()) {
				detalleliquidacionimporAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleLiquidacionImpor(DetalleLiquidacionImpor detalleliquidacionimporAux) throws Exception {
		//this.detalleliquidacionimporAux=detalleliquidacionimporAux;
		
			if(detalleliquidacionimporAux.getIsChanged()) {
				detalleliquidacionimporAux.setIsChanged(false);
			}		
			
			if(detalleliquidacionimporAux.getIsNew()) {
				detalleliquidacionimporAux.setIsNew(false);
			}	
			
			if(detalleliquidacionimporAux.getIsDeleted()) {
				detalleliquidacionimporAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleLiquidacionImpor detalleliquidacionimporAsignar,DetalleLiquidacionImpor detalleliquidacionimpor) throws Exception {
		detalleliquidacionimporAsignar.setId(detalleliquidacionimpor.getId());	
		detalleliquidacionimporAsignar.setVersionRow(detalleliquidacionimpor.getVersionRow());	
		detalleliquidacionimporAsignar.setid_liquidacion_impor(detalleliquidacionimpor.getid_liquidacion_impor());
		detalleliquidacionimporAsignar.setliquidacionimpor_descripcion(detalleliquidacionimpor.getliquidacionimpor_descripcion());	
		detalleliquidacionimporAsignar.setid_empresa(detalleliquidacionimpor.getid_empresa());
		detalleliquidacionimporAsignar.setempresa_descripcion(detalleliquidacionimpor.getempresa_descripcion());	
		detalleliquidacionimporAsignar.setid_sucursal(detalleliquidacionimpor.getid_sucursal());
		detalleliquidacionimporAsignar.setsucursal_descripcion(detalleliquidacionimpor.getsucursal_descripcion());	
		detalleliquidacionimporAsignar.setid_usuario(detalleliquidacionimpor.getid_usuario());
		detalleliquidacionimporAsignar.setusuario_descripcion(detalleliquidacionimpor.getusuario_descripcion());	
		detalleliquidacionimporAsignar.setid_centro_costo(detalleliquidacionimpor.getid_centro_costo());
		detalleliquidacionimporAsignar.setcentrocosto_descripcion(detalleliquidacionimpor.getcentrocosto_descripcion());	
		detalleliquidacionimporAsignar.setid_costo_gasto_impor(detalleliquidacionimpor.getid_costo_gasto_impor());
		detalleliquidacionimporAsignar.setcostogastoimpor_descripcion(detalleliquidacionimpor.getcostogastoimpor_descripcion());	
		detalleliquidacionimporAsignar.setvalor(detalleliquidacionimpor.getvalor());	
		detalleliquidacionimporAsignar.setfecha(detalleliquidacionimpor.getfecha());	
		detalleliquidacionimporAsignar.setreferencia(detalleliquidacionimpor.getreferencia());	
		detalleliquidacionimporAsignar.setimpuesto(detalleliquidacionimpor.getimpuesto());	
		detalleliquidacionimporAsignar.setimpuesto2(detalleliquidacionimpor.getimpuesto2());	
		detalleliquidacionimporAsignar.setimpuesto3(detalleliquidacionimpor.getimpuesto3());	
		detalleliquidacionimporAsignar.setimpuesto4(detalleliquidacionimpor.getimpuesto4());	
		detalleliquidacionimporAsignar.setimpuesto5(detalleliquidacionimpor.getimpuesto5());	
	}
	
	public static void inicializarDetalleLiquidacionImpor(DetalleLiquidacionImpor detalleliquidacionimpor) throws Exception {
		try {
				detalleliquidacionimpor.setId(0L);	
					
				detalleliquidacionimpor.setid_liquidacion_impor(-1L);	
				detalleliquidacionimpor.setid_empresa(-1L);	
				detalleliquidacionimpor.setid_sucursal(-1L);	
				detalleliquidacionimpor.setid_usuario(-1L);	
				detalleliquidacionimpor.setid_centro_costo(null);	
				detalleliquidacionimpor.setid_costo_gasto_impor(-1L);	
				detalleliquidacionimpor.setvalor(0.0);	
				detalleliquidacionimpor.setfecha(new Date());	
				detalleliquidacionimpor.setreferencia("");	
				detalleliquidacionimpor.setimpuesto(0.0);	
				detalleliquidacionimpor.setimpuesto2(0.0);	
				detalleliquidacionimpor.setimpuesto3(0.0);	
				detalleliquidacionimpor.setimpuesto4(0.0);	
				detalleliquidacionimpor.setimpuesto5(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleLiquidacionImpor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImporConstantesFunciones.LABEL_IDLIQUIDACIONIMPOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImporConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImporConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImporConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImporConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImporConstantesFunciones.LABEL_IDCOSTOGASTOIMPOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImporConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImporConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImporConstantesFunciones.LABEL_REFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO4);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO5);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleLiquidacionImpor(String sTipo,Row row,Workbook workbook,DetalleLiquidacionImpor detalleliquidacionimpor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpor.getliquidacionimpor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpor.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpor.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpor.getcostogastoimpor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpor.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpor.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpor.getreferencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpor.getimpuesto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpor.getimpuesto2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpor.getimpuesto3());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpor.getimpuesto4());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpor.getimpuesto5());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleLiquidacionImpor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleLiquidacionImpor() {
		return this.sFinalQueryDetalleLiquidacionImpor;
	}
	
	public void setsFinalQueryDetalleLiquidacionImpor(String sFinalQueryDetalleLiquidacionImpor) {
		this.sFinalQueryDetalleLiquidacionImpor= sFinalQueryDetalleLiquidacionImpor;
	}
	
	public Border resaltarSeleccionarDetalleLiquidacionImpor=null;
	
	public Border setResaltarSeleccionarDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleliquidacionimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleLiquidacionImpor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleLiquidacionImpor() {
		return this.resaltarSeleccionarDetalleLiquidacionImpor;
	}
	
	public void setResaltarSeleccionarDetalleLiquidacionImpor(Border borderResaltarSeleccionarDetalleLiquidacionImpor) {
		this.resaltarSeleccionarDetalleLiquidacionImpor= borderResaltarSeleccionarDetalleLiquidacionImpor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleLiquidacionImpor=null;
	public Boolean mostraridDetalleLiquidacionImpor=true;
	public Boolean activaridDetalleLiquidacionImpor=true;

	public Border resaltarid_liquidacion_imporDetalleLiquidacionImpor=null;
	public Boolean mostrarid_liquidacion_imporDetalleLiquidacionImpor=true;
	public Boolean activarid_liquidacion_imporDetalleLiquidacionImpor=true;
	public Boolean cargarid_liquidacion_imporDetalleLiquidacionImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_liquidacion_imporDetalleLiquidacionImpor=false;//ConEventDepend=true

	public Border resaltarid_empresaDetalleLiquidacionImpor=null;
	public Boolean mostrarid_empresaDetalleLiquidacionImpor=true;
	public Boolean activarid_empresaDetalleLiquidacionImpor=true;
	public Boolean cargarid_empresaDetalleLiquidacionImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleLiquidacionImpor=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleLiquidacionImpor=null;
	public Boolean mostrarid_sucursalDetalleLiquidacionImpor=true;
	public Boolean activarid_sucursalDetalleLiquidacionImpor=true;
	public Boolean cargarid_sucursalDetalleLiquidacionImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleLiquidacionImpor=false;//ConEventDepend=true

	public Border resaltarid_usuarioDetalleLiquidacionImpor=null;
	public Boolean mostrarid_usuarioDetalleLiquidacionImpor=true;
	public Boolean activarid_usuarioDetalleLiquidacionImpor=true;
	public Boolean cargarid_usuarioDetalleLiquidacionImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioDetalleLiquidacionImpor=false;//ConEventDepend=true

	public Border resaltarid_centro_costoDetalleLiquidacionImpor=null;
	public Boolean mostrarid_centro_costoDetalleLiquidacionImpor=true;
	public Boolean activarid_centro_costoDetalleLiquidacionImpor=true;
	public Boolean cargarid_centro_costoDetalleLiquidacionImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoDetalleLiquidacionImpor=false;//ConEventDepend=true

	public Border resaltarid_costo_gasto_imporDetalleLiquidacionImpor=null;
	public Boolean mostrarid_costo_gasto_imporDetalleLiquidacionImpor=true;
	public Boolean activarid_costo_gasto_imporDetalleLiquidacionImpor=true;
	public Boolean cargarid_costo_gasto_imporDetalleLiquidacionImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_costo_gasto_imporDetalleLiquidacionImpor=false;//ConEventDepend=true

	public Border resaltarvalorDetalleLiquidacionImpor=null;
	public Boolean mostrarvalorDetalleLiquidacionImpor=true;
	public Boolean activarvalorDetalleLiquidacionImpor=true;

	public Border resaltarfechaDetalleLiquidacionImpor=null;
	public Boolean mostrarfechaDetalleLiquidacionImpor=true;
	public Boolean activarfechaDetalleLiquidacionImpor=false;

	public Border resaltarreferenciaDetalleLiquidacionImpor=null;
	public Boolean mostrarreferenciaDetalleLiquidacionImpor=true;
	public Boolean activarreferenciaDetalleLiquidacionImpor=true;

	public Border resaltarimpuestoDetalleLiquidacionImpor=null;
	public Boolean mostrarimpuestoDetalleLiquidacionImpor=true;
	public Boolean activarimpuestoDetalleLiquidacionImpor=true;

	public Border resaltarimpuesto2DetalleLiquidacionImpor=null;
	public Boolean mostrarimpuesto2DetalleLiquidacionImpor=true;
	public Boolean activarimpuesto2DetalleLiquidacionImpor=true;

	public Border resaltarimpuesto3DetalleLiquidacionImpor=null;
	public Boolean mostrarimpuesto3DetalleLiquidacionImpor=true;
	public Boolean activarimpuesto3DetalleLiquidacionImpor=true;

	public Border resaltarimpuesto4DetalleLiquidacionImpor=null;
	public Boolean mostrarimpuesto4DetalleLiquidacionImpor=true;
	public Boolean activarimpuesto4DetalleLiquidacionImpor=true;

	public Border resaltarimpuesto5DetalleLiquidacionImpor=null;
	public Boolean mostrarimpuesto5DetalleLiquidacionImpor=true;
	public Boolean activarimpuesto5DetalleLiquidacionImpor=true;

	
	

	public Border setResaltaridDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltaridDetalleLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleLiquidacionImpor() {
		return this.resaltaridDetalleLiquidacionImpor;
	}

	public void setResaltaridDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltaridDetalleLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostraridDetalleLiquidacionImpor() {
		return this.mostraridDetalleLiquidacionImpor;
	}

	public void setMostraridDetalleLiquidacionImpor(Boolean mostraridDetalleLiquidacionImpor) {
		this.mostraridDetalleLiquidacionImpor= mostraridDetalleLiquidacionImpor;
	}

	public Boolean getActivaridDetalleLiquidacionImpor() {
		return this.activaridDetalleLiquidacionImpor;
	}

	public void setActivaridDetalleLiquidacionImpor(Boolean activaridDetalleLiquidacionImpor) {
		this.activaridDetalleLiquidacionImpor= activaridDetalleLiquidacionImpor;
	}

	public Border setResaltarid_liquidacion_imporDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarid_liquidacion_imporDetalleLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_liquidacion_imporDetalleLiquidacionImpor() {
		return this.resaltarid_liquidacion_imporDetalleLiquidacionImpor;
	}

	public void setResaltarid_liquidacion_imporDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarid_liquidacion_imporDetalleLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarid_liquidacion_imporDetalleLiquidacionImpor() {
		return this.mostrarid_liquidacion_imporDetalleLiquidacionImpor;
	}

	public void setMostrarid_liquidacion_imporDetalleLiquidacionImpor(Boolean mostrarid_liquidacion_imporDetalleLiquidacionImpor) {
		this.mostrarid_liquidacion_imporDetalleLiquidacionImpor= mostrarid_liquidacion_imporDetalleLiquidacionImpor;
	}

	public Boolean getActivarid_liquidacion_imporDetalleLiquidacionImpor() {
		return this.activarid_liquidacion_imporDetalleLiquidacionImpor;
	}

	public void setActivarid_liquidacion_imporDetalleLiquidacionImpor(Boolean activarid_liquidacion_imporDetalleLiquidacionImpor) {
		this.activarid_liquidacion_imporDetalleLiquidacionImpor= activarid_liquidacion_imporDetalleLiquidacionImpor;
	}

	public Boolean getCargarid_liquidacion_imporDetalleLiquidacionImpor() {
		return this.cargarid_liquidacion_imporDetalleLiquidacionImpor;
	}

	public void setCargarid_liquidacion_imporDetalleLiquidacionImpor(Boolean cargarid_liquidacion_imporDetalleLiquidacionImpor) {
		this.cargarid_liquidacion_imporDetalleLiquidacionImpor= cargarid_liquidacion_imporDetalleLiquidacionImpor;
	}

	public Border setResaltarid_empresaDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleLiquidacionImpor() {
		return this.resaltarid_empresaDetalleLiquidacionImpor;
	}

	public void setResaltarid_empresaDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarid_empresaDetalleLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleLiquidacionImpor() {
		return this.mostrarid_empresaDetalleLiquidacionImpor;
	}

	public void setMostrarid_empresaDetalleLiquidacionImpor(Boolean mostrarid_empresaDetalleLiquidacionImpor) {
		this.mostrarid_empresaDetalleLiquidacionImpor= mostrarid_empresaDetalleLiquidacionImpor;
	}

	public Boolean getActivarid_empresaDetalleLiquidacionImpor() {
		return this.activarid_empresaDetalleLiquidacionImpor;
	}

	public void setActivarid_empresaDetalleLiquidacionImpor(Boolean activarid_empresaDetalleLiquidacionImpor) {
		this.activarid_empresaDetalleLiquidacionImpor= activarid_empresaDetalleLiquidacionImpor;
	}

	public Boolean getCargarid_empresaDetalleLiquidacionImpor() {
		return this.cargarid_empresaDetalleLiquidacionImpor;
	}

	public void setCargarid_empresaDetalleLiquidacionImpor(Boolean cargarid_empresaDetalleLiquidacionImpor) {
		this.cargarid_empresaDetalleLiquidacionImpor= cargarid_empresaDetalleLiquidacionImpor;
	}

	public Border setResaltarid_sucursalDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleLiquidacionImpor() {
		return this.resaltarid_sucursalDetalleLiquidacionImpor;
	}

	public void setResaltarid_sucursalDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarid_sucursalDetalleLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleLiquidacionImpor() {
		return this.mostrarid_sucursalDetalleLiquidacionImpor;
	}

	public void setMostrarid_sucursalDetalleLiquidacionImpor(Boolean mostrarid_sucursalDetalleLiquidacionImpor) {
		this.mostrarid_sucursalDetalleLiquidacionImpor= mostrarid_sucursalDetalleLiquidacionImpor;
	}

	public Boolean getActivarid_sucursalDetalleLiquidacionImpor() {
		return this.activarid_sucursalDetalleLiquidacionImpor;
	}

	public void setActivarid_sucursalDetalleLiquidacionImpor(Boolean activarid_sucursalDetalleLiquidacionImpor) {
		this.activarid_sucursalDetalleLiquidacionImpor= activarid_sucursalDetalleLiquidacionImpor;
	}

	public Boolean getCargarid_sucursalDetalleLiquidacionImpor() {
		return this.cargarid_sucursalDetalleLiquidacionImpor;
	}

	public void setCargarid_sucursalDetalleLiquidacionImpor(Boolean cargarid_sucursalDetalleLiquidacionImpor) {
		this.cargarid_sucursalDetalleLiquidacionImpor= cargarid_sucursalDetalleLiquidacionImpor;
	}

	public Border setResaltarid_usuarioDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarid_usuarioDetalleLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioDetalleLiquidacionImpor() {
		return this.resaltarid_usuarioDetalleLiquidacionImpor;
	}

	public void setResaltarid_usuarioDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarid_usuarioDetalleLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarid_usuarioDetalleLiquidacionImpor() {
		return this.mostrarid_usuarioDetalleLiquidacionImpor;
	}

	public void setMostrarid_usuarioDetalleLiquidacionImpor(Boolean mostrarid_usuarioDetalleLiquidacionImpor) {
		this.mostrarid_usuarioDetalleLiquidacionImpor= mostrarid_usuarioDetalleLiquidacionImpor;
	}

	public Boolean getActivarid_usuarioDetalleLiquidacionImpor() {
		return this.activarid_usuarioDetalleLiquidacionImpor;
	}

	public void setActivarid_usuarioDetalleLiquidacionImpor(Boolean activarid_usuarioDetalleLiquidacionImpor) {
		this.activarid_usuarioDetalleLiquidacionImpor= activarid_usuarioDetalleLiquidacionImpor;
	}

	public Boolean getCargarid_usuarioDetalleLiquidacionImpor() {
		return this.cargarid_usuarioDetalleLiquidacionImpor;
	}

	public void setCargarid_usuarioDetalleLiquidacionImpor(Boolean cargarid_usuarioDetalleLiquidacionImpor) {
		this.cargarid_usuarioDetalleLiquidacionImpor= cargarid_usuarioDetalleLiquidacionImpor;
	}

	public Border setResaltarid_centro_costoDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoDetalleLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoDetalleLiquidacionImpor() {
		return this.resaltarid_centro_costoDetalleLiquidacionImpor;
	}

	public void setResaltarid_centro_costoDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarid_centro_costoDetalleLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoDetalleLiquidacionImpor() {
		return this.mostrarid_centro_costoDetalleLiquidacionImpor;
	}

	public void setMostrarid_centro_costoDetalleLiquidacionImpor(Boolean mostrarid_centro_costoDetalleLiquidacionImpor) {
		this.mostrarid_centro_costoDetalleLiquidacionImpor= mostrarid_centro_costoDetalleLiquidacionImpor;
	}

	public Boolean getActivarid_centro_costoDetalleLiquidacionImpor() {
		return this.activarid_centro_costoDetalleLiquidacionImpor;
	}

	public void setActivarid_centro_costoDetalleLiquidacionImpor(Boolean activarid_centro_costoDetalleLiquidacionImpor) {
		this.activarid_centro_costoDetalleLiquidacionImpor= activarid_centro_costoDetalleLiquidacionImpor;
	}

	public Boolean getCargarid_centro_costoDetalleLiquidacionImpor() {
		return this.cargarid_centro_costoDetalleLiquidacionImpor;
	}

	public void setCargarid_centro_costoDetalleLiquidacionImpor(Boolean cargarid_centro_costoDetalleLiquidacionImpor) {
		this.cargarid_centro_costoDetalleLiquidacionImpor= cargarid_centro_costoDetalleLiquidacionImpor;
	}

	public Border setResaltarid_costo_gasto_imporDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarid_costo_gasto_imporDetalleLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_costo_gasto_imporDetalleLiquidacionImpor() {
		return this.resaltarid_costo_gasto_imporDetalleLiquidacionImpor;
	}

	public void setResaltarid_costo_gasto_imporDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarid_costo_gasto_imporDetalleLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarid_costo_gasto_imporDetalleLiquidacionImpor() {
		return this.mostrarid_costo_gasto_imporDetalleLiquidacionImpor;
	}

	public void setMostrarid_costo_gasto_imporDetalleLiquidacionImpor(Boolean mostrarid_costo_gasto_imporDetalleLiquidacionImpor) {
		this.mostrarid_costo_gasto_imporDetalleLiquidacionImpor= mostrarid_costo_gasto_imporDetalleLiquidacionImpor;
	}

	public Boolean getActivarid_costo_gasto_imporDetalleLiquidacionImpor() {
		return this.activarid_costo_gasto_imporDetalleLiquidacionImpor;
	}

	public void setActivarid_costo_gasto_imporDetalleLiquidacionImpor(Boolean activarid_costo_gasto_imporDetalleLiquidacionImpor) {
		this.activarid_costo_gasto_imporDetalleLiquidacionImpor= activarid_costo_gasto_imporDetalleLiquidacionImpor;
	}

	public Boolean getCargarid_costo_gasto_imporDetalleLiquidacionImpor() {
		return this.cargarid_costo_gasto_imporDetalleLiquidacionImpor;
	}

	public void setCargarid_costo_gasto_imporDetalleLiquidacionImpor(Boolean cargarid_costo_gasto_imporDetalleLiquidacionImpor) {
		this.cargarid_costo_gasto_imporDetalleLiquidacionImpor= cargarid_costo_gasto_imporDetalleLiquidacionImpor;
	}

	public Border setResaltarvalorDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarvalorDetalleLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorDetalleLiquidacionImpor() {
		return this.resaltarvalorDetalleLiquidacionImpor;
	}

	public void setResaltarvalorDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarvalorDetalleLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarvalorDetalleLiquidacionImpor() {
		return this.mostrarvalorDetalleLiquidacionImpor;
	}

	public void setMostrarvalorDetalleLiquidacionImpor(Boolean mostrarvalorDetalleLiquidacionImpor) {
		this.mostrarvalorDetalleLiquidacionImpor= mostrarvalorDetalleLiquidacionImpor;
	}

	public Boolean getActivarvalorDetalleLiquidacionImpor() {
		return this.activarvalorDetalleLiquidacionImpor;
	}

	public void setActivarvalorDetalleLiquidacionImpor(Boolean activarvalorDetalleLiquidacionImpor) {
		this.activarvalorDetalleLiquidacionImpor= activarvalorDetalleLiquidacionImpor;
	}

	public Border setResaltarfechaDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarfechaDetalleLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaDetalleLiquidacionImpor() {
		return this.resaltarfechaDetalleLiquidacionImpor;
	}

	public void setResaltarfechaDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarfechaDetalleLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarfechaDetalleLiquidacionImpor() {
		return this.mostrarfechaDetalleLiquidacionImpor;
	}

	public void setMostrarfechaDetalleLiquidacionImpor(Boolean mostrarfechaDetalleLiquidacionImpor) {
		this.mostrarfechaDetalleLiquidacionImpor= mostrarfechaDetalleLiquidacionImpor;
	}

	public Boolean getActivarfechaDetalleLiquidacionImpor() {
		return this.activarfechaDetalleLiquidacionImpor;
	}

	public void setActivarfechaDetalleLiquidacionImpor(Boolean activarfechaDetalleLiquidacionImpor) {
		this.activarfechaDetalleLiquidacionImpor= activarfechaDetalleLiquidacionImpor;
	}

	public Border setResaltarreferenciaDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarreferenciaDetalleLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarreferenciaDetalleLiquidacionImpor() {
		return this.resaltarreferenciaDetalleLiquidacionImpor;
	}

	public void setResaltarreferenciaDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarreferenciaDetalleLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarreferenciaDetalleLiquidacionImpor() {
		return this.mostrarreferenciaDetalleLiquidacionImpor;
	}

	public void setMostrarreferenciaDetalleLiquidacionImpor(Boolean mostrarreferenciaDetalleLiquidacionImpor) {
		this.mostrarreferenciaDetalleLiquidacionImpor= mostrarreferenciaDetalleLiquidacionImpor;
	}

	public Boolean getActivarreferenciaDetalleLiquidacionImpor() {
		return this.activarreferenciaDetalleLiquidacionImpor;
	}

	public void setActivarreferenciaDetalleLiquidacionImpor(Boolean activarreferenciaDetalleLiquidacionImpor) {
		this.activarreferenciaDetalleLiquidacionImpor= activarreferenciaDetalleLiquidacionImpor;
	}

	public Border setResaltarimpuestoDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarimpuestoDetalleLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuestoDetalleLiquidacionImpor() {
		return this.resaltarimpuestoDetalleLiquidacionImpor;
	}

	public void setResaltarimpuestoDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarimpuestoDetalleLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarimpuestoDetalleLiquidacionImpor() {
		return this.mostrarimpuestoDetalleLiquidacionImpor;
	}

	public void setMostrarimpuestoDetalleLiquidacionImpor(Boolean mostrarimpuestoDetalleLiquidacionImpor) {
		this.mostrarimpuestoDetalleLiquidacionImpor= mostrarimpuestoDetalleLiquidacionImpor;
	}

	public Boolean getActivarimpuestoDetalleLiquidacionImpor() {
		return this.activarimpuestoDetalleLiquidacionImpor;
	}

	public void setActivarimpuestoDetalleLiquidacionImpor(Boolean activarimpuestoDetalleLiquidacionImpor) {
		this.activarimpuestoDetalleLiquidacionImpor= activarimpuestoDetalleLiquidacionImpor;
	}

	public Border setResaltarimpuesto2DetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarimpuesto2DetalleLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuesto2DetalleLiquidacionImpor() {
		return this.resaltarimpuesto2DetalleLiquidacionImpor;
	}

	public void setResaltarimpuesto2DetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarimpuesto2DetalleLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarimpuesto2DetalleLiquidacionImpor() {
		return this.mostrarimpuesto2DetalleLiquidacionImpor;
	}

	public void setMostrarimpuesto2DetalleLiquidacionImpor(Boolean mostrarimpuesto2DetalleLiquidacionImpor) {
		this.mostrarimpuesto2DetalleLiquidacionImpor= mostrarimpuesto2DetalleLiquidacionImpor;
	}

	public Boolean getActivarimpuesto2DetalleLiquidacionImpor() {
		return this.activarimpuesto2DetalleLiquidacionImpor;
	}

	public void setActivarimpuesto2DetalleLiquidacionImpor(Boolean activarimpuesto2DetalleLiquidacionImpor) {
		this.activarimpuesto2DetalleLiquidacionImpor= activarimpuesto2DetalleLiquidacionImpor;
	}

	public Border setResaltarimpuesto3DetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarimpuesto3DetalleLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuesto3DetalleLiquidacionImpor() {
		return this.resaltarimpuesto3DetalleLiquidacionImpor;
	}

	public void setResaltarimpuesto3DetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarimpuesto3DetalleLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarimpuesto3DetalleLiquidacionImpor() {
		return this.mostrarimpuesto3DetalleLiquidacionImpor;
	}

	public void setMostrarimpuesto3DetalleLiquidacionImpor(Boolean mostrarimpuesto3DetalleLiquidacionImpor) {
		this.mostrarimpuesto3DetalleLiquidacionImpor= mostrarimpuesto3DetalleLiquidacionImpor;
	}

	public Boolean getActivarimpuesto3DetalleLiquidacionImpor() {
		return this.activarimpuesto3DetalleLiquidacionImpor;
	}

	public void setActivarimpuesto3DetalleLiquidacionImpor(Boolean activarimpuesto3DetalleLiquidacionImpor) {
		this.activarimpuesto3DetalleLiquidacionImpor= activarimpuesto3DetalleLiquidacionImpor;
	}

	public Border setResaltarimpuesto4DetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarimpuesto4DetalleLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuesto4DetalleLiquidacionImpor() {
		return this.resaltarimpuesto4DetalleLiquidacionImpor;
	}

	public void setResaltarimpuesto4DetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarimpuesto4DetalleLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarimpuesto4DetalleLiquidacionImpor() {
		return this.mostrarimpuesto4DetalleLiquidacionImpor;
	}

	public void setMostrarimpuesto4DetalleLiquidacionImpor(Boolean mostrarimpuesto4DetalleLiquidacionImpor) {
		this.mostrarimpuesto4DetalleLiquidacionImpor= mostrarimpuesto4DetalleLiquidacionImpor;
	}

	public Boolean getActivarimpuesto4DetalleLiquidacionImpor() {
		return this.activarimpuesto4DetalleLiquidacionImpor;
	}

	public void setActivarimpuesto4DetalleLiquidacionImpor(Boolean activarimpuesto4DetalleLiquidacionImpor) {
		this.activarimpuesto4DetalleLiquidacionImpor= activarimpuesto4DetalleLiquidacionImpor;
	}

	public Border setResaltarimpuesto5DetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarimpuesto5DetalleLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuesto5DetalleLiquidacionImpor() {
		return this.resaltarimpuesto5DetalleLiquidacionImpor;
	}

	public void setResaltarimpuesto5DetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarimpuesto5DetalleLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarimpuesto5DetalleLiquidacionImpor() {
		return this.mostrarimpuesto5DetalleLiquidacionImpor;
	}

	public void setMostrarimpuesto5DetalleLiquidacionImpor(Boolean mostrarimpuesto5DetalleLiquidacionImpor) {
		this.mostrarimpuesto5DetalleLiquidacionImpor= mostrarimpuesto5DetalleLiquidacionImpor;
	}

	public Boolean getActivarimpuesto5DetalleLiquidacionImpor() {
		return this.activarimpuesto5DetalleLiquidacionImpor;
	}

	public void setActivarimpuesto5DetalleLiquidacionImpor(Boolean activarimpuesto5DetalleLiquidacionImpor) {
		this.activarimpuesto5DetalleLiquidacionImpor= activarimpuesto5DetalleLiquidacionImpor;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridDetalleLiquidacionImpor(esInicial);
		this.setMostrarid_liquidacion_imporDetalleLiquidacionImpor(esInicial);
		this.setMostrarid_empresaDetalleLiquidacionImpor(esInicial);
		this.setMostrarid_sucursalDetalleLiquidacionImpor(esInicial);
		this.setMostrarid_usuarioDetalleLiquidacionImpor(esInicial);
		this.setMostrarid_centro_costoDetalleLiquidacionImpor(esInicial);
		this.setMostrarid_costo_gasto_imporDetalleLiquidacionImpor(esInicial);
		this.setMostrarvalorDetalleLiquidacionImpor(esInicial);
		this.setMostrarfechaDetalleLiquidacionImpor(esInicial);
		this.setMostrarreferenciaDetalleLiquidacionImpor(esInicial);
		this.setMostrarimpuestoDetalleLiquidacionImpor(esInicial);
		this.setMostrarimpuesto2DetalleLiquidacionImpor(esInicial);
		this.setMostrarimpuesto3DetalleLiquidacionImpor(esInicial);
		this.setMostrarimpuesto4DetalleLiquidacionImpor(esInicial);
		this.setMostrarimpuesto5DetalleLiquidacionImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.ID)) {
				this.setMostraridDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDLIQUIDACIONIMPOR)) {
				this.setMostrarid_liquidacion_imporDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDCOSTOGASTOIMPOR)) {
				this.setMostrarid_costo_gasto_imporDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.VALOR)) {
				this.setMostrarvalorDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.FECHA)) {
				this.setMostrarfechaDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.REFERENCIA)) {
				this.setMostrarreferenciaDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO)) {
				this.setMostrarimpuestoDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO2)) {
				this.setMostrarimpuesto2DetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO3)) {
				this.setMostrarimpuesto3DetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO4)) {
				this.setMostrarimpuesto4DetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO5)) {
				this.setMostrarimpuesto5DetalleLiquidacionImpor(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridDetalleLiquidacionImpor(esInicial);
		this.setActivarid_liquidacion_imporDetalleLiquidacionImpor(esInicial);
		this.setActivarid_empresaDetalleLiquidacionImpor(esInicial);
		this.setActivarid_sucursalDetalleLiquidacionImpor(esInicial);
		this.setActivarid_usuarioDetalleLiquidacionImpor(esInicial);
		this.setActivarid_centro_costoDetalleLiquidacionImpor(esInicial);
		this.setActivarid_costo_gasto_imporDetalleLiquidacionImpor(esInicial);
		this.setActivarvalorDetalleLiquidacionImpor(esInicial);
		this.setActivarfechaDetalleLiquidacionImpor(esInicial);
		this.setActivarreferenciaDetalleLiquidacionImpor(esInicial);
		this.setActivarimpuestoDetalleLiquidacionImpor(esInicial);
		this.setActivarimpuesto2DetalleLiquidacionImpor(esInicial);
		this.setActivarimpuesto3DetalleLiquidacionImpor(esInicial);
		this.setActivarimpuesto4DetalleLiquidacionImpor(esInicial);
		this.setActivarimpuesto5DetalleLiquidacionImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.ID)) {
				this.setActivaridDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDLIQUIDACIONIMPOR)) {
				this.setActivarid_liquidacion_imporDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDCOSTOGASTOIMPOR)) {
				this.setActivarid_costo_gasto_imporDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.VALOR)) {
				this.setActivarvalorDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.FECHA)) {
				this.setActivarfechaDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.REFERENCIA)) {
				this.setActivarreferenciaDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO)) {
				this.setActivarimpuestoDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO2)) {
				this.setActivarimpuesto2DetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO3)) {
				this.setActivarimpuesto3DetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO4)) {
				this.setActivarimpuesto4DetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO5)) {
				this.setActivarimpuesto5DetalleLiquidacionImpor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleLiquidacionImpor(esInicial);
		this.setResaltarid_liquidacion_imporDetalleLiquidacionImpor(esInicial);
		this.setResaltarid_empresaDetalleLiquidacionImpor(esInicial);
		this.setResaltarid_sucursalDetalleLiquidacionImpor(esInicial);
		this.setResaltarid_usuarioDetalleLiquidacionImpor(esInicial);
		this.setResaltarid_centro_costoDetalleLiquidacionImpor(esInicial);
		this.setResaltarid_costo_gasto_imporDetalleLiquidacionImpor(esInicial);
		this.setResaltarvalorDetalleLiquidacionImpor(esInicial);
		this.setResaltarfechaDetalleLiquidacionImpor(esInicial);
		this.setResaltarreferenciaDetalleLiquidacionImpor(esInicial);
		this.setResaltarimpuestoDetalleLiquidacionImpor(esInicial);
		this.setResaltarimpuesto2DetalleLiquidacionImpor(esInicial);
		this.setResaltarimpuesto3DetalleLiquidacionImpor(esInicial);
		this.setResaltarimpuesto4DetalleLiquidacionImpor(esInicial);
		this.setResaltarimpuesto5DetalleLiquidacionImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.ID)) {
				this.setResaltaridDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDLIQUIDACIONIMPOR)) {
				this.setResaltarid_liquidacion_imporDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IDCOSTOGASTOIMPOR)) {
				this.setResaltarid_costo_gasto_imporDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.VALOR)) {
				this.setResaltarvalorDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.FECHA)) {
				this.setResaltarfechaDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.REFERENCIA)) {
				this.setResaltarreferenciaDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO)) {
				this.setResaltarimpuestoDetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO2)) {
				this.setResaltarimpuesto2DetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO3)) {
				this.setResaltarimpuesto3DetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO4)) {
				this.setResaltarimpuesto4DetalleLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImporConstantesFunciones.IMPUESTO5)) {
				this.setResaltarimpuesto5DetalleLiquidacionImpor(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarFK_IdCentroCostoDetalleLiquidacionImpor=true;

	public Boolean getMostrarFK_IdCentroCostoDetalleLiquidacionImpor() {
		return this.mostrarFK_IdCentroCostoDetalleLiquidacionImpor;
	}

	public void setMostrarFK_IdCentroCostoDetalleLiquidacionImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoDetalleLiquidacionImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCostoGastoImporDetalleLiquidacionImpor=true;

	public Boolean getMostrarFK_IdCostoGastoImporDetalleLiquidacionImpor() {
		return this.mostrarFK_IdCostoGastoImporDetalleLiquidacionImpor;
	}

	public void setMostrarFK_IdCostoGastoImporDetalleLiquidacionImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCostoGastoImporDetalleLiquidacionImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleLiquidacionImpor=true;

	public Boolean getMostrarFK_IdEmpresaDetalleLiquidacionImpor() {
		return this.mostrarFK_IdEmpresaDetalleLiquidacionImpor;
	}

	public void setMostrarFK_IdEmpresaDetalleLiquidacionImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleLiquidacionImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLiquidacionImporDetalleLiquidacionImpor=true;

	public Boolean getMostrarFK_IdLiquidacionImporDetalleLiquidacionImpor() {
		return this.mostrarFK_IdLiquidacionImporDetalleLiquidacionImpor;
	}

	public void setMostrarFK_IdLiquidacionImporDetalleLiquidacionImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLiquidacionImporDetalleLiquidacionImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleLiquidacionImpor=true;

	public Boolean getMostrarFK_IdSucursalDetalleLiquidacionImpor() {
		return this.mostrarFK_IdSucursalDetalleLiquidacionImpor;
	}

	public void setMostrarFK_IdSucursalDetalleLiquidacionImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleLiquidacionImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioDetalleLiquidacionImpor=true;

	public Boolean getMostrarFK_IdUsuarioDetalleLiquidacionImpor() {
		return this.mostrarFK_IdUsuarioDetalleLiquidacionImpor;
	}

	public void setMostrarFK_IdUsuarioDetalleLiquidacionImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioDetalleLiquidacionImpor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCentroCostoDetalleLiquidacionImpor=true;

	public Boolean getActivarFK_IdCentroCostoDetalleLiquidacionImpor() {
		return this.activarFK_IdCentroCostoDetalleLiquidacionImpor;
	}

	public void setActivarFK_IdCentroCostoDetalleLiquidacionImpor(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoDetalleLiquidacionImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdCostoGastoImporDetalleLiquidacionImpor=true;

	public Boolean getActivarFK_IdCostoGastoImporDetalleLiquidacionImpor() {
		return this.activarFK_IdCostoGastoImporDetalleLiquidacionImpor;
	}

	public void setActivarFK_IdCostoGastoImporDetalleLiquidacionImpor(Boolean habilitarResaltar) {
		this.activarFK_IdCostoGastoImporDetalleLiquidacionImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleLiquidacionImpor=true;

	public Boolean getActivarFK_IdEmpresaDetalleLiquidacionImpor() {
		return this.activarFK_IdEmpresaDetalleLiquidacionImpor;
	}

	public void setActivarFK_IdEmpresaDetalleLiquidacionImpor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleLiquidacionImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdLiquidacionImporDetalleLiquidacionImpor=true;

	public Boolean getActivarFK_IdLiquidacionImporDetalleLiquidacionImpor() {
		return this.activarFK_IdLiquidacionImporDetalleLiquidacionImpor;
	}

	public void setActivarFK_IdLiquidacionImporDetalleLiquidacionImpor(Boolean habilitarResaltar) {
		this.activarFK_IdLiquidacionImporDetalleLiquidacionImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleLiquidacionImpor=true;

	public Boolean getActivarFK_IdSucursalDetalleLiquidacionImpor() {
		return this.activarFK_IdSucursalDetalleLiquidacionImpor;
	}

	public void setActivarFK_IdSucursalDetalleLiquidacionImpor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleLiquidacionImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioDetalleLiquidacionImpor=true;

	public Boolean getActivarFK_IdUsuarioDetalleLiquidacionImpor() {
		return this.activarFK_IdUsuarioDetalleLiquidacionImpor;
	}

	public void setActivarFK_IdUsuarioDetalleLiquidacionImpor(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioDetalleLiquidacionImpor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCentroCostoDetalleLiquidacionImpor=null;

	public Border getResaltarFK_IdCentroCostoDetalleLiquidacionImpor() {
		return this.resaltarFK_IdCentroCostoDetalleLiquidacionImpor;
	}

	public void setResaltarFK_IdCentroCostoDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoDetalleLiquidacionImpor= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoDetalleLiquidacionImpor= borderResaltar;
	}

	public Border resaltarFK_IdCostoGastoImporDetalleLiquidacionImpor=null;

	public Border getResaltarFK_IdCostoGastoImporDetalleLiquidacionImpor() {
		return this.resaltarFK_IdCostoGastoImporDetalleLiquidacionImpor;
	}

	public void setResaltarFK_IdCostoGastoImporDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarFK_IdCostoGastoImporDetalleLiquidacionImpor= borderResaltar;
	}

	public void setResaltarFK_IdCostoGastoImporDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCostoGastoImporDetalleLiquidacionImpor= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleLiquidacionImpor=null;

	public Border getResaltarFK_IdEmpresaDetalleLiquidacionImpor() {
		return this.resaltarFK_IdEmpresaDetalleLiquidacionImpor;
	}

	public void setResaltarFK_IdEmpresaDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleLiquidacionImpor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleLiquidacionImpor= borderResaltar;
	}

	public Border resaltarFK_IdLiquidacionImporDetalleLiquidacionImpor=null;

	public Border getResaltarFK_IdLiquidacionImporDetalleLiquidacionImpor() {
		return this.resaltarFK_IdLiquidacionImporDetalleLiquidacionImpor;
	}

	public void setResaltarFK_IdLiquidacionImporDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarFK_IdLiquidacionImporDetalleLiquidacionImpor= borderResaltar;
	}

	public void setResaltarFK_IdLiquidacionImporDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLiquidacionImporDetalleLiquidacionImpor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleLiquidacionImpor=null;

	public Border getResaltarFK_IdSucursalDetalleLiquidacionImpor() {
		return this.resaltarFK_IdSucursalDetalleLiquidacionImpor;
	}

	public void setResaltarFK_IdSucursalDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleLiquidacionImpor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleLiquidacionImpor= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioDetalleLiquidacionImpor=null;

	public Border getResaltarFK_IdUsuarioDetalleLiquidacionImpor() {
		return this.resaltarFK_IdUsuarioDetalleLiquidacionImpor;
	}

	public void setResaltarFK_IdUsuarioDetalleLiquidacionImpor(Border borderResaltar) {
		this.resaltarFK_IdUsuarioDetalleLiquidacionImpor= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioDetalleLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImporBeanSwingJInternalFrame detalleliquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioDetalleLiquidacionImpor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
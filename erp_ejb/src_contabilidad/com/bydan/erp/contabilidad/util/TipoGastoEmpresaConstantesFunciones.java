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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.TipoGastoEmpresaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoGastoEmpresaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoGastoEmpresaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoGastoEmpresaConstantesFunciones extends TipoGastoEmpresaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoGastoEmpresa";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoGastoEmpresa"+TipoGastoEmpresaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoGastoEmpresaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoGastoEmpresaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoGastoEmpresaConstantesFunciones.SCHEMA+"_"+TipoGastoEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoGastoEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoGastoEmpresaConstantesFunciones.SCHEMA+"_"+TipoGastoEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoGastoEmpresaConstantesFunciones.SCHEMA+"_"+TipoGastoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoGastoEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoGastoEmpresaConstantesFunciones.SCHEMA+"_"+TipoGastoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGastoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGastoEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGastoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGastoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGastoEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGastoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoGastoEmpresaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoGastoEmpresaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoGastoEmpresaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoGastoEmpresaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Gasto Empresas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Gasto Empresa";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Gasto Empresa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoGastoEmpresa";
	public static final String OBJECTNAME="tipogastoempresa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_gasto_empresa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipogastoempresa from "+TipoGastoEmpresaConstantesFunciones.SPERSISTENCENAME+" tipogastoempresa";
	public static String QUERYSELECTNATIVE="select "+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_sucursal,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".nombre,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_formato,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".descripcion,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_gasto,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_fiscal_bien,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_fiscal_servicio,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_retencion_bien,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_retencion_servicio,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_iva_bien,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_iva_servicio from "+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoGastoEmpresaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoGastoEmpresaConstantesFuncionesAdditional tipogastoempresaConstantesFuncionesAdditional=null;
	
	public TipoGastoEmpresaConstantesFuncionesAdditional getTipoGastoEmpresaConstantesFuncionesAdditional() {
		return this.tipogastoempresaConstantesFuncionesAdditional;
	}
	
	public void setTipoGastoEmpresaConstantesFuncionesAdditional(TipoGastoEmpresaConstantesFuncionesAdditional tipogastoempresaConstantesFuncionesAdditional) {
		try {
			this.tipogastoempresaConstantesFuncionesAdditional=tipogastoempresaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String NOMBRE= "nombre";
    public static final String IDFORMATO= "id_formato";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDCUENTACONTABLEGASTO= "id_cuenta_contable_gasto";
    public static final String IDCUENTACONTABLEFISCALBIEN= "id_cuenta_contable_fiscal_bien";
    public static final String IDCUENTACONTABLEFISCALSERVICIO= "id_cuenta_contable_fiscal_servicio";
    public static final String IDCUENTACONTABLERETENCIONBIEN= "id_cuenta_contable_retencion_bien";
    public static final String IDCUENTACONTABLERETENCIONSERVICIO= "id_cuenta_contable_retencion_servicio";
    public static final String IDCUENTACONTABLEIVABIEN= "id_cuenta_contable_iva_bien";
    public static final String IDCUENTACONTABLEIVASERVICIO= "id_cuenta_contable_iva_servicio";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDCUENTACONTABLEGASTO= "Cuenta C. Gasto";
		public static final String LABEL_IDCUENTACONTABLEGASTO_LOWER= "Cuenta Contable Gasto";
    	public static final String LABEL_IDCUENTACONTABLEFISCALBIEN= "Cuenta C. Fiscal Bien";
		public static final String LABEL_IDCUENTACONTABLEFISCALBIEN_LOWER= "Cuenta Contable Fiscal Bien";
    	public static final String LABEL_IDCUENTACONTABLEFISCALSERVICIO= "Cuenta C. Fiscal Servicio";
		public static final String LABEL_IDCUENTACONTABLEFISCALSERVICIO_LOWER= "Cuenta Contable Fiscal Servicio";
    	public static final String LABEL_IDCUENTACONTABLERETENCIONBIEN= "Cuenta C. Retencion Bien";
		public static final String LABEL_IDCUENTACONTABLERETENCIONBIEN_LOWER= "Cuenta Contable Retencion Bien";
    	public static final String LABEL_IDCUENTACONTABLERETENCIONSERVICIO= "Cuenta C. Retencion Servicio";
		public static final String LABEL_IDCUENTACONTABLERETENCIONSERVICIO_LOWER= "Cuenta Contable Retencion Servicio";
    	public static final String LABEL_IDCUENTACONTABLEIVABIEN= "Cuenta C. Iva Bien";
		public static final String LABEL_IDCUENTACONTABLEIVABIEN_LOWER= "Cuenta Contable Iva Bien";
    	public static final String LABEL_IDCUENTACONTABLEIVASERVICIO= "Cuenta C. Iva Servicio";
		public static final String LABEL_IDCUENTACONTABLEIVASERVICIO_LOWER= "Cuenta Contable Iva Servicio";
	
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	
	public static String getTipoGastoEmpresaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoGastoEmpresaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoGastoEmpresaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoGastoEmpresaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=TipoGastoEmpresaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(TipoGastoEmpresaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoGastoEmpresaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoGastoEmpresaConstantesFunciones.IDFORMATO)) {sLabelColumna=TipoGastoEmpresaConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(TipoGastoEmpresaConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoGastoEmpresaConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEGASTO)) {sLabelColumna=TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO;}
		if(sNombreColumna.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALBIEN)) {sLabelColumna=TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEFISCALBIEN;}
		if(sNombreColumna.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALSERVICIO)) {sLabelColumna=TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEFISCALSERVICIO;}
		if(sNombreColumna.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONBIEN)) {sLabelColumna=TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLERETENCIONBIEN;}
		if(sNombreColumna.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONSERVICIO)) {sLabelColumna=TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLERETENCIONSERVICIO;}
		if(sNombreColumna.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVABIEN)) {sLabelColumna=TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEIVABIEN;}
		if(sNombreColumna.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVASERVICIO)) {sLabelColumna=TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEIVASERVICIO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getTipoGastoEmpresaDescripcion(TipoGastoEmpresa tipogastoempresa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipogastoempresa !=null/* && tipogastoempresa.getId()!=0*/) {
			sDescripcion=tipogastoempresa.getnombre();//tipogastoempresatipogastoempresa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoGastoEmpresaDescripcionDetallado(TipoGastoEmpresa tipogastoempresa) {
		String sDescripcion="";
			
		sDescripcion+=TipoGastoEmpresaConstantesFunciones.ID+"=";
		sDescripcion+=tipogastoempresa.getId().toString()+",";
		sDescripcion+=TipoGastoEmpresaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipogastoempresa.getVersionRow().toString()+",";
		sDescripcion+=TipoGastoEmpresaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipogastoempresa.getid_empresa().toString()+",";
		sDescripcion+=TipoGastoEmpresaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=tipogastoempresa.getid_sucursal().toString()+",";
		sDescripcion+=TipoGastoEmpresaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipogastoempresa.getnombre()+",";
		sDescripcion+=TipoGastoEmpresaConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=tipogastoempresa.getid_formato().toString()+",";
		sDescripcion+=TipoGastoEmpresaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipogastoempresa.getdescripcion()+",";
		sDescripcion+=TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEGASTO+"=";
		sDescripcion+=tipogastoempresa.getid_cuenta_contable_gasto().toString()+",";
		sDescripcion+=TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALBIEN+"=";
		sDescripcion+=tipogastoempresa.getid_cuenta_contable_fiscal_bien().toString()+",";
		sDescripcion+=TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALSERVICIO+"=";
		sDescripcion+=tipogastoempresa.getid_cuenta_contable_fiscal_servicio().toString()+",";
		sDescripcion+=TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONBIEN+"=";
		sDescripcion+=tipogastoempresa.getid_cuenta_contable_retencion_bien().toString()+",";
		sDescripcion+=TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONSERVICIO+"=";
		sDescripcion+=tipogastoempresa.getid_cuenta_contable_retencion_servicio().toString()+",";
		sDescripcion+=TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVABIEN+"=";
		sDescripcion+=tipogastoempresa.getid_cuenta_contable_iva_bien().toString()+",";
		sDescripcion+=TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVASERVICIO+"=";
		sDescripcion+=tipogastoempresa.getid_cuenta_contable_iva_servicio().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoGastoEmpresaDescripcion(TipoGastoEmpresa tipogastoempresa,String sValor) throws Exception {			
		if(tipogastoempresa !=null) {
			tipogastoempresa.setnombre(sValor);//tipogastoempresatipogastoempresa.getId().toString();
		}		
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

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getCuentaContableGastoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableFiscalBienDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableFiscalServicioDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableRetencionBienDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableRetencionServicioDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableIvaBienDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableIvaServicioDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdCuentaContableFiscalBien")) {
			sNombreIndice="Tipo=  Por Cuenta C. Fiscal Bien";
		} else if(sNombreIndice.equals("FK_IdCuentaContableFiscalServicio")) {
			sNombreIndice="Tipo=  Por Cuenta C. Fiscal Servicio";
		} else if(sNombreIndice.equals("FK_IdCuentaContableGasto")) {
			sNombreIndice="Tipo=  Por Cuenta C. Gasto";
		} else if(sNombreIndice.equals("FK_IdCuentaContableIvaBien")) {
			sNombreIndice="Tipo=  Por Cuenta C. Iva Bien";
		} else if(sNombreIndice.equals("FK_IdCuentaContableIvaServicio")) {
			sNombreIndice="Tipo=  Por Cuenta C. Iva Servicio";
		} else if(sNombreIndice.equals("FK_IdCuentaContableRetencionBien")) {
			sNombreIndice="Tipo=  Por Cuenta C. Retencion Bien";
		} else if(sNombreIndice.equals("FK_IdCuentaContableRetencionServicio")) {
			sNombreIndice="Tipo=  Por Cuenta C. Retencion Servicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableFiscalBien(Long id_cuenta_contable_fiscal_bien) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_fiscal_bien!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Fiscal Bien="+id_cuenta_contable_fiscal_bien.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableFiscalServicio(Long id_cuenta_contable_fiscal_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_fiscal_servicio!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Fiscal Servicio="+id_cuenta_contable_fiscal_servicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableGasto(Long id_cuenta_contable_gasto) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_gasto!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Gasto="+id_cuenta_contable_gasto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableIvaBien(Long id_cuenta_contable_iva_bien) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_iva_bien!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Iva Bien="+id_cuenta_contable_iva_bien.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableIvaServicio(Long id_cuenta_contable_iva_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_iva_servicio!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Iva Servicio="+id_cuenta_contable_iva_servicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableRetencionBien(Long id_cuenta_contable_retencion_bien) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_retencion_bien!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Retencion Bien="+id_cuenta_contable_retencion_bien.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableRetencionServicio(Long id_cuenta_contable_retencion_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_retencion_servicio!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Retencion Servicio="+id_cuenta_contable_retencion_servicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoGastoEmpresa(TipoGastoEmpresa tipogastoempresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipogastoempresa.setnombre(tipogastoempresa.getnombre().trim());
		tipogastoempresa.setdescripcion(tipogastoempresa.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoGastoEmpresas(List<TipoGastoEmpresa> tipogastoempresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoGastoEmpresa tipogastoempresa: tipogastoempresas) {
			tipogastoempresa.setnombre(tipogastoempresa.getnombre().trim());
			tipogastoempresa.setdescripcion(tipogastoempresa.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGastoEmpresa(TipoGastoEmpresa tipogastoempresa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipogastoempresa.getConCambioAuxiliar()) {
			tipogastoempresa.setIsDeleted(tipogastoempresa.getIsDeletedAuxiliar());	
			tipogastoempresa.setIsNew(tipogastoempresa.getIsNewAuxiliar());	
			tipogastoempresa.setIsChanged(tipogastoempresa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipogastoempresa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipogastoempresa.setIsDeletedAuxiliar(false);	
			tipogastoempresa.setIsNewAuxiliar(false);	
			tipogastoempresa.setIsChangedAuxiliar(false);
			
			tipogastoempresa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGastoEmpresas(List<TipoGastoEmpresa> tipogastoempresas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoGastoEmpresa tipogastoempresa : tipogastoempresas) {
			if(conAsignarBase && tipogastoempresa.getConCambioAuxiliar()) {
				tipogastoempresa.setIsDeleted(tipogastoempresa.getIsDeletedAuxiliar());	
				tipogastoempresa.setIsNew(tipogastoempresa.getIsNewAuxiliar());	
				tipogastoempresa.setIsChanged(tipogastoempresa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipogastoempresa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipogastoempresa.setIsDeletedAuxiliar(false);	
				tipogastoempresa.setIsNewAuxiliar(false);	
				tipogastoempresa.setIsChangedAuxiliar(false);
				
				tipogastoempresa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoGastoEmpresa(TipoGastoEmpresa tipogastoempresa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoGastoEmpresas(List<TipoGastoEmpresa> tipogastoempresas,Boolean conEnteros) throws Exception  {
		
		for(TipoGastoEmpresa tipogastoempresa: tipogastoempresas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoGastoEmpresa(List<TipoGastoEmpresa> tipogastoempresas,TipoGastoEmpresa tipogastoempresaAux) throws Exception  {
		TipoGastoEmpresaConstantesFunciones.InicializarValoresTipoGastoEmpresa(tipogastoempresaAux,true);
		
		for(TipoGastoEmpresa tipogastoempresa: tipogastoempresas) {
			if(tipogastoempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGastoEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoGastoEmpresaConstantesFunciones.getArrayColumnasGlobalesTipoGastoEmpresa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGastoEmpresa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoGastoEmpresaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoGastoEmpresaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoGastoEmpresaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoGastoEmpresaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoGastoEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoGastoEmpresa> tipogastoempresas,TipoGastoEmpresa tipogastoempresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoGastoEmpresa tipogastoempresaAux: tipogastoempresas) {
			if(tipogastoempresaAux!=null && tipogastoempresa!=null) {
				if((tipogastoempresaAux.getId()==null && tipogastoempresa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipogastoempresaAux.getId()!=null && tipogastoempresa.getId()!=null){
					if(tipogastoempresaAux.getId().equals(tipogastoempresa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoGastoEmpresa(List<TipoGastoEmpresa> tipogastoempresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoGastoEmpresa tipogastoempresa: tipogastoempresas) {			
			if(tipogastoempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoGastoEmpresa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoGastoEmpresaConstantesFunciones.LABEL_ID, TipoGastoEmpresaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoEmpresaConstantesFunciones.LABEL_VERSIONROW, TipoGastoEmpresaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoEmpresaConstantesFunciones.LABEL_IDEMPRESA, TipoGastoEmpresaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoEmpresaConstantesFunciones.LABEL_IDSUCURSAL, TipoGastoEmpresaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoEmpresaConstantesFunciones.LABEL_NOMBRE, TipoGastoEmpresaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoEmpresaConstantesFunciones.LABEL_IDFORMATO, TipoGastoEmpresaConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoEmpresaConstantesFunciones.LABEL_DESCRIPCION, TipoGastoEmpresaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO, TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEGASTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEFISCALBIEN, TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALBIEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEFISCALSERVICIO, TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALSERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLERETENCIONBIEN, TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONBIEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLERETENCIONSERVICIO, TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONSERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEIVABIEN, TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVABIEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEIVASERVICIO, TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVASERVICIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoGastoEmpresa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoGastoEmpresaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoEmpresaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoEmpresaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoEmpresaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoEmpresaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoEmpresaConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoEmpresaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEGASTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALBIEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALSERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONBIEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONSERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVABIEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVASERVICIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGastoEmpresa() throws Exception  {
		return TipoGastoEmpresaConstantesFunciones.getTiposSeleccionarTipoGastoEmpresa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGastoEmpresa(Boolean conFk) throws Exception  {
		return TipoGastoEmpresaConstantesFunciones.getTiposSeleccionarTipoGastoEmpresa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGastoEmpresa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoEmpresaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoGastoEmpresaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoEmpresaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(TipoGastoEmpresaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoEmpresaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoGastoEmpresaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoEmpresaConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(TipoGastoEmpresaConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoEmpresaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoGastoEmpresaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO);
			reporte.setsDescripcion(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEFISCALBIEN);
			reporte.setsDescripcion(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEFISCALBIEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEFISCALSERVICIO);
			reporte.setsDescripcion(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEFISCALSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLERETENCIONBIEN);
			reporte.setsDescripcion(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLERETENCIONBIEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLERETENCIONSERVICIO);
			reporte.setsDescripcion(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLERETENCIONSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEIVABIEN);
			reporte.setsDescripcion(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEIVABIEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEIVASERVICIO);
			reporte.setsDescripcion(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEIVASERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoGastoEmpresa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGastoEmpresa(TipoGastoEmpresa tipogastoempresaAux) throws Exception {
		
			tipogastoempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipogastoempresaAux.getEmpresa()));
			tipogastoempresaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tipogastoempresaAux.getSucursal()));
			tipogastoempresaAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(tipogastoempresaAux.getFormato()));
			tipogastoempresaAux.setcuentacontablegasto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipogastoempresaAux.getCuentaContableGasto()));
			tipogastoempresaAux.setcuentacontablefiscalbien_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipogastoempresaAux.getCuentaContableFiscalBien()));
			tipogastoempresaAux.setcuentacontablefiscalservicio_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipogastoempresaAux.getCuentaContableFiscalServicio()));
			tipogastoempresaAux.setcuentacontableretencionbien_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipogastoempresaAux.getCuentaContableRetencionBien()));
			tipogastoempresaAux.setcuentacontableretencionservicio_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipogastoempresaAux.getCuentaContableRetencionServicio()));
			tipogastoempresaAux.setcuentacontableivabien_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipogastoempresaAux.getCuentaContableIvaBien()));
			tipogastoempresaAux.setcuentacontableivaservicio_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipogastoempresaAux.getCuentaContableIvaServicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGastoEmpresa(List<TipoGastoEmpresa> tipogastoempresasTemp) throws Exception {
		for(TipoGastoEmpresa tipogastoempresaAux:tipogastoempresasTemp) {
			
			tipogastoempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipogastoempresaAux.getEmpresa()));
			tipogastoempresaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tipogastoempresaAux.getSucursal()));
			tipogastoempresaAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(tipogastoempresaAux.getFormato()));
			tipogastoempresaAux.setcuentacontablegasto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipogastoempresaAux.getCuentaContableGasto()));
			tipogastoempresaAux.setcuentacontablefiscalbien_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipogastoempresaAux.getCuentaContableFiscalBien()));
			tipogastoempresaAux.setcuentacontablefiscalservicio_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipogastoempresaAux.getCuentaContableFiscalServicio()));
			tipogastoempresaAux.setcuentacontableretencionbien_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipogastoempresaAux.getCuentaContableRetencionBien()));
			tipogastoempresaAux.setcuentacontableretencionservicio_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipogastoempresaAux.getCuentaContableRetencionServicio()));
			tipogastoempresaAux.setcuentacontableivabien_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipogastoempresaAux.getCuentaContableIvaBien()));
			tipogastoempresaAux.setcuentacontableivaservicio_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipogastoempresaAux.getCuentaContableIvaServicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGastoEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoGastoEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGastoEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGastoEmpresaConstantesFunciones.getClassesRelationshipsOfTipoGastoEmpresa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGastoEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleAsientoContableCajaChica.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleAsientoContableCajaChica.class)) {
						classes.add(new Classe(DetalleAsientoContableCajaChica.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGastoEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGastoEmpresaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoGastoEmpresa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGastoEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleAsientoContableCajaChica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleAsientoContableCajaChica.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleAsientoContableCajaChica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleAsientoContableCajaChica.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoGastoEmpresa tipogastoempresa,List<TipoGastoEmpresa> tipogastoempresas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoGastoEmpresa tipogastoempresaEncontrado=null;
			
			for(TipoGastoEmpresa tipogastoempresaLocal:tipogastoempresas) {
				if(tipogastoempresaLocal.getId().equals(tipogastoempresa.getId())) {
					tipogastoempresaEncontrado=tipogastoempresaLocal;
					
					tipogastoempresaLocal.setIsChanged(tipogastoempresa.getIsChanged());
					tipogastoempresaLocal.setIsNew(tipogastoempresa.getIsNew());
					tipogastoempresaLocal.setIsDeleted(tipogastoempresa.getIsDeleted());
					
					tipogastoempresaLocal.setGeneralEntityOriginal(tipogastoempresa.getGeneralEntityOriginal());
					
					tipogastoempresaLocal.setId(tipogastoempresa.getId());	
					tipogastoempresaLocal.setVersionRow(tipogastoempresa.getVersionRow());	
					tipogastoempresaLocal.setid_empresa(tipogastoempresa.getid_empresa());	
					tipogastoempresaLocal.setid_sucursal(tipogastoempresa.getid_sucursal());	
					tipogastoempresaLocal.setnombre(tipogastoempresa.getnombre());	
					tipogastoempresaLocal.setid_formato(tipogastoempresa.getid_formato());	
					tipogastoempresaLocal.setdescripcion(tipogastoempresa.getdescripcion());	
					tipogastoempresaLocal.setid_cuenta_contable_gasto(tipogastoempresa.getid_cuenta_contable_gasto());	
					tipogastoempresaLocal.setid_cuenta_contable_fiscal_bien(tipogastoempresa.getid_cuenta_contable_fiscal_bien());	
					tipogastoempresaLocal.setid_cuenta_contable_fiscal_servicio(tipogastoempresa.getid_cuenta_contable_fiscal_servicio());	
					tipogastoempresaLocal.setid_cuenta_contable_retencion_bien(tipogastoempresa.getid_cuenta_contable_retencion_bien());	
					tipogastoempresaLocal.setid_cuenta_contable_retencion_servicio(tipogastoempresa.getid_cuenta_contable_retencion_servicio());	
					tipogastoempresaLocal.setid_cuenta_contable_iva_bien(tipogastoempresa.getid_cuenta_contable_iva_bien());	
					tipogastoempresaLocal.setid_cuenta_contable_iva_servicio(tipogastoempresa.getid_cuenta_contable_iva_servicio());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipogastoempresa.getIsDeleted()) {
				if(!existe) {
					tipogastoempresas.add(tipogastoempresa);
				}
			} else {
				if(tipogastoempresaEncontrado!=null && permiteQuitar)  {
					tipogastoempresas.remove(tipogastoempresaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoGastoEmpresa tipogastoempresa,List<TipoGastoEmpresa> tipogastoempresas) throws Exception {
		try	{			
			for(TipoGastoEmpresa tipogastoempresaLocal:tipogastoempresas) {
				if(tipogastoempresaLocal.getId().equals(tipogastoempresa.getId())) {
					tipogastoempresaLocal.setIsSelected(tipogastoempresa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoGastoEmpresa(List<TipoGastoEmpresa> tipogastoempresasAux) throws Exception {
		//this.tipogastoempresasAux=tipogastoempresasAux;
		
		for(TipoGastoEmpresa tipogastoempresaAux:tipogastoempresasAux) {
			if(tipogastoempresaAux.getIsChanged()) {
				tipogastoempresaAux.setIsChanged(false);
			}		
			
			if(tipogastoempresaAux.getIsNew()) {
				tipogastoempresaAux.setIsNew(false);
			}	
			
			if(tipogastoempresaAux.getIsDeleted()) {
				tipogastoempresaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoGastoEmpresa(TipoGastoEmpresa tipogastoempresaAux) throws Exception {
		//this.tipogastoempresaAux=tipogastoempresaAux;
		
			if(tipogastoempresaAux.getIsChanged()) {
				tipogastoempresaAux.setIsChanged(false);
			}		
			
			if(tipogastoempresaAux.getIsNew()) {
				tipogastoempresaAux.setIsNew(false);
			}	
			
			if(tipogastoempresaAux.getIsDeleted()) {
				tipogastoempresaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoGastoEmpresa tipogastoempresaAsignar,TipoGastoEmpresa tipogastoempresa) throws Exception {
		tipogastoempresaAsignar.setId(tipogastoempresa.getId());	
		tipogastoempresaAsignar.setVersionRow(tipogastoempresa.getVersionRow());	
		tipogastoempresaAsignar.setid_empresa(tipogastoempresa.getid_empresa());
		tipogastoempresaAsignar.setempresa_descripcion(tipogastoempresa.getempresa_descripcion());	
		tipogastoempresaAsignar.setid_sucursal(tipogastoempresa.getid_sucursal());
		tipogastoempresaAsignar.setsucursal_descripcion(tipogastoempresa.getsucursal_descripcion());	
		tipogastoempresaAsignar.setnombre(tipogastoempresa.getnombre());	
		tipogastoempresaAsignar.setid_formato(tipogastoempresa.getid_formato());
		tipogastoempresaAsignar.setformato_descripcion(tipogastoempresa.getformato_descripcion());	
		tipogastoempresaAsignar.setdescripcion(tipogastoempresa.getdescripcion());	
		tipogastoempresaAsignar.setid_cuenta_contable_gasto(tipogastoempresa.getid_cuenta_contable_gasto());
		tipogastoempresaAsignar.setcuentacontablegasto_descripcion(tipogastoempresa.getcuentacontablegasto_descripcion());	
		tipogastoempresaAsignar.setid_cuenta_contable_fiscal_bien(tipogastoempresa.getid_cuenta_contable_fiscal_bien());
		tipogastoempresaAsignar.setcuentacontablefiscalbien_descripcion(tipogastoempresa.getcuentacontablefiscalbien_descripcion());	
		tipogastoempresaAsignar.setid_cuenta_contable_fiscal_servicio(tipogastoempresa.getid_cuenta_contable_fiscal_servicio());
		tipogastoempresaAsignar.setcuentacontablefiscalservicio_descripcion(tipogastoempresa.getcuentacontablefiscalservicio_descripcion());	
		tipogastoempresaAsignar.setid_cuenta_contable_retencion_bien(tipogastoempresa.getid_cuenta_contable_retencion_bien());
		tipogastoempresaAsignar.setcuentacontableretencionbien_descripcion(tipogastoempresa.getcuentacontableretencionbien_descripcion());	
		tipogastoempresaAsignar.setid_cuenta_contable_retencion_servicio(tipogastoempresa.getid_cuenta_contable_retencion_servicio());
		tipogastoempresaAsignar.setcuentacontableretencionservicio_descripcion(tipogastoempresa.getcuentacontableretencionservicio_descripcion());	
		tipogastoempresaAsignar.setid_cuenta_contable_iva_bien(tipogastoempresa.getid_cuenta_contable_iva_bien());
		tipogastoempresaAsignar.setcuentacontableivabien_descripcion(tipogastoempresa.getcuentacontableivabien_descripcion());	
		tipogastoempresaAsignar.setid_cuenta_contable_iva_servicio(tipogastoempresa.getid_cuenta_contable_iva_servicio());
		tipogastoempresaAsignar.setcuentacontableivaservicio_descripcion(tipogastoempresa.getcuentacontableivaservicio_descripcion());	
	}
	
	public static void inicializarTipoGastoEmpresa(TipoGastoEmpresa tipogastoempresa) throws Exception {
		try {
				tipogastoempresa.setId(0L);	
					
				tipogastoempresa.setid_empresa(-1L);	
				tipogastoempresa.setid_sucursal(-1L);	
				tipogastoempresa.setnombre("");	
				tipogastoempresa.setid_formato(-1L);	
				tipogastoempresa.setdescripcion("");	
				tipogastoempresa.setid_cuenta_contable_gasto(null);	
				tipogastoempresa.setid_cuenta_contable_fiscal_bien(null);	
				tipogastoempresa.setid_cuenta_contable_fiscal_servicio(null);	
				tipogastoempresa.setid_cuenta_contable_retencion_bien(null);	
				tipogastoempresa.setid_cuenta_contable_retencion_servicio(null);	
				tipogastoempresa.setid_cuenta_contable_iva_bien(null);	
				tipogastoempresa.setid_cuenta_contable_iva_servicio(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoGastoEmpresa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoEmpresaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoEmpresaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoEmpresaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoEmpresaConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoEmpresaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEFISCALBIEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEFISCALSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLERETENCIONBIEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLERETENCIONSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEIVABIEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEIVASERVICIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoGastoEmpresa(String sTipo,Row row,Workbook workbook,TipoGastoEmpresa tipogastoempresa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoempresa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoempresa.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoempresa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoempresa.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoempresa.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoempresa.getcuentacontablegasto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoempresa.getcuentacontablefiscalbien_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoempresa.getcuentacontablefiscalservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoempresa.getcuentacontableretencionbien_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoempresa.getcuentacontableretencionservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoempresa.getcuentacontableivabien_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoempresa.getcuentacontableivaservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoGastoEmpresa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoGastoEmpresa() {
		return this.sFinalQueryTipoGastoEmpresa;
	}
	
	public void setsFinalQueryTipoGastoEmpresa(String sFinalQueryTipoGastoEmpresa) {
		this.sFinalQueryTipoGastoEmpresa= sFinalQueryTipoGastoEmpresa;
	}
	
	public Border resaltarSeleccionarTipoGastoEmpresa=null;
	
	public Border setResaltarSeleccionarTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipogastoempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoEmpresa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoGastoEmpresa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoGastoEmpresa() {
		return this.resaltarSeleccionarTipoGastoEmpresa;
	}
	
	public void setResaltarSeleccionarTipoGastoEmpresa(Border borderResaltarSeleccionarTipoGastoEmpresa) {
		this.resaltarSeleccionarTipoGastoEmpresa= borderResaltarSeleccionarTipoGastoEmpresa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoGastoEmpresa=null;
	public Boolean mostraridTipoGastoEmpresa=true;
	public Boolean activaridTipoGastoEmpresa=true;

	public Border resaltarid_empresaTipoGastoEmpresa=null;
	public Boolean mostrarid_empresaTipoGastoEmpresa=true;
	public Boolean activarid_empresaTipoGastoEmpresa=true;
	public Boolean cargarid_empresaTipoGastoEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoGastoEmpresa=false;//ConEventDepend=true

	public Border resaltarid_sucursalTipoGastoEmpresa=null;
	public Boolean mostrarid_sucursalTipoGastoEmpresa=true;
	public Boolean activarid_sucursalTipoGastoEmpresa=true;
	public Boolean cargarid_sucursalTipoGastoEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalTipoGastoEmpresa=false;//ConEventDepend=true

	public Border resaltarnombreTipoGastoEmpresa=null;
	public Boolean mostrarnombreTipoGastoEmpresa=true;
	public Boolean activarnombreTipoGastoEmpresa=true;

	public Border resaltarid_formatoTipoGastoEmpresa=null;
	public Boolean mostrarid_formatoTipoGastoEmpresa=true;
	public Boolean activarid_formatoTipoGastoEmpresa=true;
	public Boolean cargarid_formatoTipoGastoEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoTipoGastoEmpresa=false;//ConEventDepend=true

	public Border resaltardescripcionTipoGastoEmpresa=null;
	public Boolean mostrardescripcionTipoGastoEmpresa=true;
	public Boolean activardescripcionTipoGastoEmpresa=true;

	public Border resaltarid_cuenta_contable_gastoTipoGastoEmpresa=null;
	public Boolean mostrarid_cuenta_contable_gastoTipoGastoEmpresa=true;
	public Boolean activarid_cuenta_contable_gastoTipoGastoEmpresa=true;
	public Boolean cargarid_cuenta_contable_gastoTipoGastoEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_gastoTipoGastoEmpresa=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_fiscal_bienTipoGastoEmpresa=null;
	public Boolean mostrarid_cuenta_contable_fiscal_bienTipoGastoEmpresa=true;
	public Boolean activarid_cuenta_contable_fiscal_bienTipoGastoEmpresa=true;
	public Boolean cargarid_cuenta_contable_fiscal_bienTipoGastoEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_fiscal_bienTipoGastoEmpresa=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa=null;
	public Boolean mostrarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa=true;
	public Boolean activarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa=true;
	public Boolean cargarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_fiscal_servicioTipoGastoEmpresa=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_retencion_bienTipoGastoEmpresa=null;
	public Boolean mostrarid_cuenta_contable_retencion_bienTipoGastoEmpresa=true;
	public Boolean activarid_cuenta_contable_retencion_bienTipoGastoEmpresa=true;
	public Boolean cargarid_cuenta_contable_retencion_bienTipoGastoEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_retencion_bienTipoGastoEmpresa=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_retencion_servicioTipoGastoEmpresa=null;
	public Boolean mostrarid_cuenta_contable_retencion_servicioTipoGastoEmpresa=true;
	public Boolean activarid_cuenta_contable_retencion_servicioTipoGastoEmpresa=true;
	public Boolean cargarid_cuenta_contable_retencion_servicioTipoGastoEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_retencion_servicioTipoGastoEmpresa=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_iva_bienTipoGastoEmpresa=null;
	public Boolean mostrarid_cuenta_contable_iva_bienTipoGastoEmpresa=true;
	public Boolean activarid_cuenta_contable_iva_bienTipoGastoEmpresa=true;
	public Boolean cargarid_cuenta_contable_iva_bienTipoGastoEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_iva_bienTipoGastoEmpresa=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_iva_servicioTipoGastoEmpresa=null;
	public Boolean mostrarid_cuenta_contable_iva_servicioTipoGastoEmpresa=true;
	public Boolean activarid_cuenta_contable_iva_servicioTipoGastoEmpresa=true;
	public Boolean cargarid_cuenta_contable_iva_servicioTipoGastoEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_iva_servicioTipoGastoEmpresa=false;//ConEventDepend=true

	
	

	public Border setResaltaridTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoEmpresa.setBorder(borderResaltar);
		
		this.resaltaridTipoGastoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoGastoEmpresa() {
		return this.resaltaridTipoGastoEmpresa;
	}

	public void setResaltaridTipoGastoEmpresa(Border borderResaltar) {
		this.resaltaridTipoGastoEmpresa= borderResaltar;
	}

	public Boolean getMostraridTipoGastoEmpresa() {
		return this.mostraridTipoGastoEmpresa;
	}

	public void setMostraridTipoGastoEmpresa(Boolean mostraridTipoGastoEmpresa) {
		this.mostraridTipoGastoEmpresa= mostraridTipoGastoEmpresa;
	}

	public Boolean getActivaridTipoGastoEmpresa() {
		return this.activaridTipoGastoEmpresa;
	}

	public void setActivaridTipoGastoEmpresa(Boolean activaridTipoGastoEmpresa) {
		this.activaridTipoGastoEmpresa= activaridTipoGastoEmpresa;
	}

	public Border setResaltarid_empresaTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoGastoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoGastoEmpresa() {
		return this.resaltarid_empresaTipoGastoEmpresa;
	}

	public void setResaltarid_empresaTipoGastoEmpresa(Border borderResaltar) {
		this.resaltarid_empresaTipoGastoEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoGastoEmpresa() {
		return this.mostrarid_empresaTipoGastoEmpresa;
	}

	public void setMostrarid_empresaTipoGastoEmpresa(Boolean mostrarid_empresaTipoGastoEmpresa) {
		this.mostrarid_empresaTipoGastoEmpresa= mostrarid_empresaTipoGastoEmpresa;
	}

	public Boolean getActivarid_empresaTipoGastoEmpresa() {
		return this.activarid_empresaTipoGastoEmpresa;
	}

	public void setActivarid_empresaTipoGastoEmpresa(Boolean activarid_empresaTipoGastoEmpresa) {
		this.activarid_empresaTipoGastoEmpresa= activarid_empresaTipoGastoEmpresa;
	}

	public Boolean getCargarid_empresaTipoGastoEmpresa() {
		return this.cargarid_empresaTipoGastoEmpresa;
	}

	public void setCargarid_empresaTipoGastoEmpresa(Boolean cargarid_empresaTipoGastoEmpresa) {
		this.cargarid_empresaTipoGastoEmpresa= cargarid_empresaTipoGastoEmpresa;
	}

	public Border setResaltarid_sucursalTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_sucursalTipoGastoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalTipoGastoEmpresa() {
		return this.resaltarid_sucursalTipoGastoEmpresa;
	}

	public void setResaltarid_sucursalTipoGastoEmpresa(Border borderResaltar) {
		this.resaltarid_sucursalTipoGastoEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_sucursalTipoGastoEmpresa() {
		return this.mostrarid_sucursalTipoGastoEmpresa;
	}

	public void setMostrarid_sucursalTipoGastoEmpresa(Boolean mostrarid_sucursalTipoGastoEmpresa) {
		this.mostrarid_sucursalTipoGastoEmpresa= mostrarid_sucursalTipoGastoEmpresa;
	}

	public Boolean getActivarid_sucursalTipoGastoEmpresa() {
		return this.activarid_sucursalTipoGastoEmpresa;
	}

	public void setActivarid_sucursalTipoGastoEmpresa(Boolean activarid_sucursalTipoGastoEmpresa) {
		this.activarid_sucursalTipoGastoEmpresa= activarid_sucursalTipoGastoEmpresa;
	}

	public Boolean getCargarid_sucursalTipoGastoEmpresa() {
		return this.cargarid_sucursalTipoGastoEmpresa;
	}

	public void setCargarid_sucursalTipoGastoEmpresa(Boolean cargarid_sucursalTipoGastoEmpresa) {
		this.cargarid_sucursalTipoGastoEmpresa= cargarid_sucursalTipoGastoEmpresa;
	}

	public Border setResaltarnombreTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoEmpresa.setBorder(borderResaltar);
		
		this.resaltarnombreTipoGastoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoGastoEmpresa() {
		return this.resaltarnombreTipoGastoEmpresa;
	}

	public void setResaltarnombreTipoGastoEmpresa(Border borderResaltar) {
		this.resaltarnombreTipoGastoEmpresa= borderResaltar;
	}

	public Boolean getMostrarnombreTipoGastoEmpresa() {
		return this.mostrarnombreTipoGastoEmpresa;
	}

	public void setMostrarnombreTipoGastoEmpresa(Boolean mostrarnombreTipoGastoEmpresa) {
		this.mostrarnombreTipoGastoEmpresa= mostrarnombreTipoGastoEmpresa;
	}

	public Boolean getActivarnombreTipoGastoEmpresa() {
		return this.activarnombreTipoGastoEmpresa;
	}

	public void setActivarnombreTipoGastoEmpresa(Boolean activarnombreTipoGastoEmpresa) {
		this.activarnombreTipoGastoEmpresa= activarnombreTipoGastoEmpresa;
	}

	public Border setResaltarid_formatoTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_formatoTipoGastoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoTipoGastoEmpresa() {
		return this.resaltarid_formatoTipoGastoEmpresa;
	}

	public void setResaltarid_formatoTipoGastoEmpresa(Border borderResaltar) {
		this.resaltarid_formatoTipoGastoEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_formatoTipoGastoEmpresa() {
		return this.mostrarid_formatoTipoGastoEmpresa;
	}

	public void setMostrarid_formatoTipoGastoEmpresa(Boolean mostrarid_formatoTipoGastoEmpresa) {
		this.mostrarid_formatoTipoGastoEmpresa= mostrarid_formatoTipoGastoEmpresa;
	}

	public Boolean getActivarid_formatoTipoGastoEmpresa() {
		return this.activarid_formatoTipoGastoEmpresa;
	}

	public void setActivarid_formatoTipoGastoEmpresa(Boolean activarid_formatoTipoGastoEmpresa) {
		this.activarid_formatoTipoGastoEmpresa= activarid_formatoTipoGastoEmpresa;
	}

	public Boolean getCargarid_formatoTipoGastoEmpresa() {
		return this.cargarid_formatoTipoGastoEmpresa;
	}

	public void setCargarid_formatoTipoGastoEmpresa(Boolean cargarid_formatoTipoGastoEmpresa) {
		this.cargarid_formatoTipoGastoEmpresa= cargarid_formatoTipoGastoEmpresa;
	}

	public Border setResaltardescripcionTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoEmpresa.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoGastoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoGastoEmpresa() {
		return this.resaltardescripcionTipoGastoEmpresa;
	}

	public void setResaltardescripcionTipoGastoEmpresa(Border borderResaltar) {
		this.resaltardescripcionTipoGastoEmpresa= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoGastoEmpresa() {
		return this.mostrardescripcionTipoGastoEmpresa;
	}

	public void setMostrardescripcionTipoGastoEmpresa(Boolean mostrardescripcionTipoGastoEmpresa) {
		this.mostrardescripcionTipoGastoEmpresa= mostrardescripcionTipoGastoEmpresa;
	}

	public Boolean getActivardescripcionTipoGastoEmpresa() {
		return this.activardescripcionTipoGastoEmpresa;
	}

	public void setActivardescripcionTipoGastoEmpresa(Boolean activardescripcionTipoGastoEmpresa) {
		this.activardescripcionTipoGastoEmpresa= activardescripcionTipoGastoEmpresa;
	}

	public Border setResaltarid_cuenta_contable_gastoTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_gastoTipoGastoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_gastoTipoGastoEmpresa() {
		return this.resaltarid_cuenta_contable_gastoTipoGastoEmpresa;
	}

	public void setResaltarid_cuenta_contable_gastoTipoGastoEmpresa(Border borderResaltar) {
		this.resaltarid_cuenta_contable_gastoTipoGastoEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_gastoTipoGastoEmpresa() {
		return this.mostrarid_cuenta_contable_gastoTipoGastoEmpresa;
	}

	public void setMostrarid_cuenta_contable_gastoTipoGastoEmpresa(Boolean mostrarid_cuenta_contable_gastoTipoGastoEmpresa) {
		this.mostrarid_cuenta_contable_gastoTipoGastoEmpresa= mostrarid_cuenta_contable_gastoTipoGastoEmpresa;
	}

	public Boolean getActivarid_cuenta_contable_gastoTipoGastoEmpresa() {
		return this.activarid_cuenta_contable_gastoTipoGastoEmpresa;
	}

	public void setActivarid_cuenta_contable_gastoTipoGastoEmpresa(Boolean activarid_cuenta_contable_gastoTipoGastoEmpresa) {
		this.activarid_cuenta_contable_gastoTipoGastoEmpresa= activarid_cuenta_contable_gastoTipoGastoEmpresa;
	}

	public Boolean getCargarid_cuenta_contable_gastoTipoGastoEmpresa() {
		return this.cargarid_cuenta_contable_gastoTipoGastoEmpresa;
	}

	public void setCargarid_cuenta_contable_gastoTipoGastoEmpresa(Boolean cargarid_cuenta_contable_gastoTipoGastoEmpresa) {
		this.cargarid_cuenta_contable_gastoTipoGastoEmpresa= cargarid_cuenta_contable_gastoTipoGastoEmpresa;
	}

	public Border setResaltarid_cuenta_contable_fiscal_bienTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_fiscal_bienTipoGastoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_fiscal_bienTipoGastoEmpresa() {
		return this.resaltarid_cuenta_contable_fiscal_bienTipoGastoEmpresa;
	}

	public void setResaltarid_cuenta_contable_fiscal_bienTipoGastoEmpresa(Border borderResaltar) {
		this.resaltarid_cuenta_contable_fiscal_bienTipoGastoEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_fiscal_bienTipoGastoEmpresa() {
		return this.mostrarid_cuenta_contable_fiscal_bienTipoGastoEmpresa;
	}

	public void setMostrarid_cuenta_contable_fiscal_bienTipoGastoEmpresa(Boolean mostrarid_cuenta_contable_fiscal_bienTipoGastoEmpresa) {
		this.mostrarid_cuenta_contable_fiscal_bienTipoGastoEmpresa= mostrarid_cuenta_contable_fiscal_bienTipoGastoEmpresa;
	}

	public Boolean getActivarid_cuenta_contable_fiscal_bienTipoGastoEmpresa() {
		return this.activarid_cuenta_contable_fiscal_bienTipoGastoEmpresa;
	}

	public void setActivarid_cuenta_contable_fiscal_bienTipoGastoEmpresa(Boolean activarid_cuenta_contable_fiscal_bienTipoGastoEmpresa) {
		this.activarid_cuenta_contable_fiscal_bienTipoGastoEmpresa= activarid_cuenta_contable_fiscal_bienTipoGastoEmpresa;
	}

	public Boolean getCargarid_cuenta_contable_fiscal_bienTipoGastoEmpresa() {
		return this.cargarid_cuenta_contable_fiscal_bienTipoGastoEmpresa;
	}

	public void setCargarid_cuenta_contable_fiscal_bienTipoGastoEmpresa(Boolean cargarid_cuenta_contable_fiscal_bienTipoGastoEmpresa) {
		this.cargarid_cuenta_contable_fiscal_bienTipoGastoEmpresa= cargarid_cuenta_contable_fiscal_bienTipoGastoEmpresa;
	}

	public Border setResaltarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa() {
		return this.resaltarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa;
	}

	public void setResaltarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa(Border borderResaltar) {
		this.resaltarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa() {
		return this.mostrarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa;
	}

	public void setMostrarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa(Boolean mostrarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa) {
		this.mostrarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa= mostrarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa;
	}

	public Boolean getActivarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa() {
		return this.activarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa;
	}

	public void setActivarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa(Boolean activarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa) {
		this.activarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa= activarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa;
	}

	public Boolean getCargarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa() {
		return this.cargarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa;
	}

	public void setCargarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa(Boolean cargarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa) {
		this.cargarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa= cargarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa;
	}

	public Border setResaltarid_cuenta_contable_retencion_bienTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_retencion_bienTipoGastoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_retencion_bienTipoGastoEmpresa() {
		return this.resaltarid_cuenta_contable_retencion_bienTipoGastoEmpresa;
	}

	public void setResaltarid_cuenta_contable_retencion_bienTipoGastoEmpresa(Border borderResaltar) {
		this.resaltarid_cuenta_contable_retencion_bienTipoGastoEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_retencion_bienTipoGastoEmpresa() {
		return this.mostrarid_cuenta_contable_retencion_bienTipoGastoEmpresa;
	}

	public void setMostrarid_cuenta_contable_retencion_bienTipoGastoEmpresa(Boolean mostrarid_cuenta_contable_retencion_bienTipoGastoEmpresa) {
		this.mostrarid_cuenta_contable_retencion_bienTipoGastoEmpresa= mostrarid_cuenta_contable_retencion_bienTipoGastoEmpresa;
	}

	public Boolean getActivarid_cuenta_contable_retencion_bienTipoGastoEmpresa() {
		return this.activarid_cuenta_contable_retencion_bienTipoGastoEmpresa;
	}

	public void setActivarid_cuenta_contable_retencion_bienTipoGastoEmpresa(Boolean activarid_cuenta_contable_retencion_bienTipoGastoEmpresa) {
		this.activarid_cuenta_contable_retencion_bienTipoGastoEmpresa= activarid_cuenta_contable_retencion_bienTipoGastoEmpresa;
	}

	public Boolean getCargarid_cuenta_contable_retencion_bienTipoGastoEmpresa() {
		return this.cargarid_cuenta_contable_retencion_bienTipoGastoEmpresa;
	}

	public void setCargarid_cuenta_contable_retencion_bienTipoGastoEmpresa(Boolean cargarid_cuenta_contable_retencion_bienTipoGastoEmpresa) {
		this.cargarid_cuenta_contable_retencion_bienTipoGastoEmpresa= cargarid_cuenta_contable_retencion_bienTipoGastoEmpresa;
	}

	public Border setResaltarid_cuenta_contable_retencion_servicioTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_retencion_servicioTipoGastoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_retencion_servicioTipoGastoEmpresa() {
		return this.resaltarid_cuenta_contable_retencion_servicioTipoGastoEmpresa;
	}

	public void setResaltarid_cuenta_contable_retencion_servicioTipoGastoEmpresa(Border borderResaltar) {
		this.resaltarid_cuenta_contable_retencion_servicioTipoGastoEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_retencion_servicioTipoGastoEmpresa() {
		return this.mostrarid_cuenta_contable_retencion_servicioTipoGastoEmpresa;
	}

	public void setMostrarid_cuenta_contable_retencion_servicioTipoGastoEmpresa(Boolean mostrarid_cuenta_contable_retencion_servicioTipoGastoEmpresa) {
		this.mostrarid_cuenta_contable_retencion_servicioTipoGastoEmpresa= mostrarid_cuenta_contable_retencion_servicioTipoGastoEmpresa;
	}

	public Boolean getActivarid_cuenta_contable_retencion_servicioTipoGastoEmpresa() {
		return this.activarid_cuenta_contable_retencion_servicioTipoGastoEmpresa;
	}

	public void setActivarid_cuenta_contable_retencion_servicioTipoGastoEmpresa(Boolean activarid_cuenta_contable_retencion_servicioTipoGastoEmpresa) {
		this.activarid_cuenta_contable_retencion_servicioTipoGastoEmpresa= activarid_cuenta_contable_retencion_servicioTipoGastoEmpresa;
	}

	public Boolean getCargarid_cuenta_contable_retencion_servicioTipoGastoEmpresa() {
		return this.cargarid_cuenta_contable_retencion_servicioTipoGastoEmpresa;
	}

	public void setCargarid_cuenta_contable_retencion_servicioTipoGastoEmpresa(Boolean cargarid_cuenta_contable_retencion_servicioTipoGastoEmpresa) {
		this.cargarid_cuenta_contable_retencion_servicioTipoGastoEmpresa= cargarid_cuenta_contable_retencion_servicioTipoGastoEmpresa;
	}

	public Border setResaltarid_cuenta_contable_iva_bienTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_iva_bienTipoGastoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_iva_bienTipoGastoEmpresa() {
		return this.resaltarid_cuenta_contable_iva_bienTipoGastoEmpresa;
	}

	public void setResaltarid_cuenta_contable_iva_bienTipoGastoEmpresa(Border borderResaltar) {
		this.resaltarid_cuenta_contable_iva_bienTipoGastoEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_iva_bienTipoGastoEmpresa() {
		return this.mostrarid_cuenta_contable_iva_bienTipoGastoEmpresa;
	}

	public void setMostrarid_cuenta_contable_iva_bienTipoGastoEmpresa(Boolean mostrarid_cuenta_contable_iva_bienTipoGastoEmpresa) {
		this.mostrarid_cuenta_contable_iva_bienTipoGastoEmpresa= mostrarid_cuenta_contable_iva_bienTipoGastoEmpresa;
	}

	public Boolean getActivarid_cuenta_contable_iva_bienTipoGastoEmpresa() {
		return this.activarid_cuenta_contable_iva_bienTipoGastoEmpresa;
	}

	public void setActivarid_cuenta_contable_iva_bienTipoGastoEmpresa(Boolean activarid_cuenta_contable_iva_bienTipoGastoEmpresa) {
		this.activarid_cuenta_contable_iva_bienTipoGastoEmpresa= activarid_cuenta_contable_iva_bienTipoGastoEmpresa;
	}

	public Boolean getCargarid_cuenta_contable_iva_bienTipoGastoEmpresa() {
		return this.cargarid_cuenta_contable_iva_bienTipoGastoEmpresa;
	}

	public void setCargarid_cuenta_contable_iva_bienTipoGastoEmpresa(Boolean cargarid_cuenta_contable_iva_bienTipoGastoEmpresa) {
		this.cargarid_cuenta_contable_iva_bienTipoGastoEmpresa= cargarid_cuenta_contable_iva_bienTipoGastoEmpresa;
	}

	public Border setResaltarid_cuenta_contable_iva_servicioTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_iva_servicioTipoGastoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_iva_servicioTipoGastoEmpresa() {
		return this.resaltarid_cuenta_contable_iva_servicioTipoGastoEmpresa;
	}

	public void setResaltarid_cuenta_contable_iva_servicioTipoGastoEmpresa(Border borderResaltar) {
		this.resaltarid_cuenta_contable_iva_servicioTipoGastoEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_iva_servicioTipoGastoEmpresa() {
		return this.mostrarid_cuenta_contable_iva_servicioTipoGastoEmpresa;
	}

	public void setMostrarid_cuenta_contable_iva_servicioTipoGastoEmpresa(Boolean mostrarid_cuenta_contable_iva_servicioTipoGastoEmpresa) {
		this.mostrarid_cuenta_contable_iva_servicioTipoGastoEmpresa= mostrarid_cuenta_contable_iva_servicioTipoGastoEmpresa;
	}

	public Boolean getActivarid_cuenta_contable_iva_servicioTipoGastoEmpresa() {
		return this.activarid_cuenta_contable_iva_servicioTipoGastoEmpresa;
	}

	public void setActivarid_cuenta_contable_iva_servicioTipoGastoEmpresa(Boolean activarid_cuenta_contable_iva_servicioTipoGastoEmpresa) {
		this.activarid_cuenta_contable_iva_servicioTipoGastoEmpresa= activarid_cuenta_contable_iva_servicioTipoGastoEmpresa;
	}

	public Boolean getCargarid_cuenta_contable_iva_servicioTipoGastoEmpresa() {
		return this.cargarid_cuenta_contable_iva_servicioTipoGastoEmpresa;
	}

	public void setCargarid_cuenta_contable_iva_servicioTipoGastoEmpresa(Boolean cargarid_cuenta_contable_iva_servicioTipoGastoEmpresa) {
		this.cargarid_cuenta_contable_iva_servicioTipoGastoEmpresa= cargarid_cuenta_contable_iva_servicioTipoGastoEmpresa;
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
		
		
		this.setMostraridTipoGastoEmpresa(esInicial);
		this.setMostrarid_empresaTipoGastoEmpresa(esInicial);
		this.setMostrarid_sucursalTipoGastoEmpresa(esInicial);
		this.setMostrarnombreTipoGastoEmpresa(esInicial);
		this.setMostrarid_formatoTipoGastoEmpresa(esInicial);
		this.setMostrardescripcionTipoGastoEmpresa(esInicial);
		this.setMostrarid_cuenta_contable_gastoTipoGastoEmpresa(esInicial);
		this.setMostrarid_cuenta_contable_fiscal_bienTipoGastoEmpresa(esInicial);
		this.setMostrarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa(esInicial);
		this.setMostrarid_cuenta_contable_retencion_bienTipoGastoEmpresa(esInicial);
		this.setMostrarid_cuenta_contable_retencion_servicioTipoGastoEmpresa(esInicial);
		this.setMostrarid_cuenta_contable_iva_bienTipoGastoEmpresa(esInicial);
		this.setMostrarid_cuenta_contable_iva_servicioTipoGastoEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.ID)) {
				this.setMostraridTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEGASTO)) {
				this.setMostrarid_cuenta_contable_gastoTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALBIEN)) {
				this.setMostrarid_cuenta_contable_fiscal_bienTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALSERVICIO)) {
				this.setMostrarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONBIEN)) {
				this.setMostrarid_cuenta_contable_retencion_bienTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONSERVICIO)) {
				this.setMostrarid_cuenta_contable_retencion_servicioTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVABIEN)) {
				this.setMostrarid_cuenta_contable_iva_bienTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVASERVICIO)) {
				this.setMostrarid_cuenta_contable_iva_servicioTipoGastoEmpresa(esAsigna);
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
		
		
		this.setActivaridTipoGastoEmpresa(esInicial);
		this.setActivarid_empresaTipoGastoEmpresa(esInicial);
		this.setActivarid_sucursalTipoGastoEmpresa(esInicial);
		this.setActivarnombreTipoGastoEmpresa(esInicial);
		this.setActivarid_formatoTipoGastoEmpresa(esInicial);
		this.setActivardescripcionTipoGastoEmpresa(esInicial);
		this.setActivarid_cuenta_contable_gastoTipoGastoEmpresa(esInicial);
		this.setActivarid_cuenta_contable_fiscal_bienTipoGastoEmpresa(esInicial);
		this.setActivarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa(esInicial);
		this.setActivarid_cuenta_contable_retencion_bienTipoGastoEmpresa(esInicial);
		this.setActivarid_cuenta_contable_retencion_servicioTipoGastoEmpresa(esInicial);
		this.setActivarid_cuenta_contable_iva_bienTipoGastoEmpresa(esInicial);
		this.setActivarid_cuenta_contable_iva_servicioTipoGastoEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.ID)) {
				this.setActivaridTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEGASTO)) {
				this.setActivarid_cuenta_contable_gastoTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALBIEN)) {
				this.setActivarid_cuenta_contable_fiscal_bienTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALSERVICIO)) {
				this.setActivarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONBIEN)) {
				this.setActivarid_cuenta_contable_retencion_bienTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONSERVICIO)) {
				this.setActivarid_cuenta_contable_retencion_servicioTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVABIEN)) {
				this.setActivarid_cuenta_contable_iva_bienTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVASERVICIO)) {
				this.setActivarid_cuenta_contable_iva_servicioTipoGastoEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoGastoEmpresa(esInicial);
		this.setResaltarid_empresaTipoGastoEmpresa(esInicial);
		this.setResaltarid_sucursalTipoGastoEmpresa(esInicial);
		this.setResaltarnombreTipoGastoEmpresa(esInicial);
		this.setResaltarid_formatoTipoGastoEmpresa(esInicial);
		this.setResaltardescripcionTipoGastoEmpresa(esInicial);
		this.setResaltarid_cuenta_contable_gastoTipoGastoEmpresa(esInicial);
		this.setResaltarid_cuenta_contable_fiscal_bienTipoGastoEmpresa(esInicial);
		this.setResaltarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa(esInicial);
		this.setResaltarid_cuenta_contable_retencion_bienTipoGastoEmpresa(esInicial);
		this.setResaltarid_cuenta_contable_retencion_servicioTipoGastoEmpresa(esInicial);
		this.setResaltarid_cuenta_contable_iva_bienTipoGastoEmpresa(esInicial);
		this.setResaltarid_cuenta_contable_iva_servicioTipoGastoEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.ID)) {
				this.setResaltaridTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEGASTO)) {
				this.setResaltarid_cuenta_contable_gastoTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALBIEN)) {
				this.setResaltarid_cuenta_contable_fiscal_bienTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALSERVICIO)) {
				this.setResaltarid_cuenta_contable_fiscal_servicioTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONBIEN)) {
				this.setResaltarid_cuenta_contable_retencion_bienTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONSERVICIO)) {
				this.setResaltarid_cuenta_contable_retencion_servicioTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVABIEN)) {
				this.setResaltarid_cuenta_contable_iva_bienTipoGastoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVASERVICIO)) {
				this.setResaltarid_cuenta_contable_iva_servicioTipoGastoEmpresa(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreTipoGastoEmpresa=true;

	public Boolean getMostrarBusquedaPorNombreTipoGastoEmpresa() {
		return this.mostrarBusquedaPorNombreTipoGastoEmpresa;
	}

	public void setMostrarBusquedaPorNombreTipoGastoEmpresa(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoGastoEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoGastoEmpresa=true;

	public Boolean getMostrarFK_IdEmpresaTipoGastoEmpresa() {
		return this.mostrarFK_IdEmpresaTipoGastoEmpresa;
	}

	public void setMostrarFK_IdEmpresaTipoGastoEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoGastoEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalTipoGastoEmpresa=true;

	public Boolean getMostrarFK_IdSucursalTipoGastoEmpresa() {
		return this.mostrarFK_IdSucursalTipoGastoEmpresa;
	}

	public void setMostrarFK_IdSucursalTipoGastoEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalTipoGastoEmpresa= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoGastoEmpresa=true;

	public Boolean getActivarBusquedaPorNombreTipoGastoEmpresa() {
		return this.activarBusquedaPorNombreTipoGastoEmpresa;
	}

	public void setActivarBusquedaPorNombreTipoGastoEmpresa(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoGastoEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoGastoEmpresa=true;

	public Boolean getActivarFK_IdEmpresaTipoGastoEmpresa() {
		return this.activarFK_IdEmpresaTipoGastoEmpresa;
	}

	public void setActivarFK_IdEmpresaTipoGastoEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoGastoEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalTipoGastoEmpresa=true;

	public Boolean getActivarFK_IdSucursalTipoGastoEmpresa() {
		return this.activarFK_IdSucursalTipoGastoEmpresa;
	}

	public void setActivarFK_IdSucursalTipoGastoEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalTipoGastoEmpresa= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoGastoEmpresa=null;

	public Border getResaltarBusquedaPorNombreTipoGastoEmpresa() {
		return this.resaltarBusquedaPorNombreTipoGastoEmpresa;
	}

	public void setResaltarBusquedaPorNombreTipoGastoEmpresa(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoGastoEmpresa= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoGastoEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoGastoEmpresa=null;

	public Border getResaltarFK_IdEmpresaTipoGastoEmpresa() {
		return this.resaltarFK_IdEmpresaTipoGastoEmpresa;
	}

	public void setResaltarFK_IdEmpresaTipoGastoEmpresa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoGastoEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoGastoEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdSucursalTipoGastoEmpresa=null;

	public Border getResaltarFK_IdSucursalTipoGastoEmpresa() {
		return this.resaltarFK_IdSucursalTipoGastoEmpresa;
	}

	public void setResaltarFK_IdSucursalTipoGastoEmpresa(Border borderResaltar) {
		this.resaltarFK_IdSucursalTipoGastoEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdSucursalTipoGastoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoEmpresaBeanSwingJInternalFrame tipogastoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalTipoGastoEmpresa= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
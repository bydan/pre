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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.RetencionInvenConstantesFunciones;
import com.bydan.erp.nomina.util.RetencionInvenParameterReturnGeneral;
//import com.bydan.erp.nomina.util.RetencionInvenParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RetencionInvenConstantesFunciones extends RetencionInvenConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,-20);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,-20);	
	
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
	public static final String SNOMBREOPCION="RetencionInven";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RetencionInven"+RetencionInvenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RetencionInvenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RetencionInvenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RetencionInvenConstantesFunciones.SCHEMA+"_"+RetencionInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RetencionInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RetencionInvenConstantesFunciones.SCHEMA+"_"+RetencionInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RetencionInvenConstantesFunciones.SCHEMA+"_"+RetencionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RetencionInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RetencionInvenConstantesFunciones.SCHEMA+"_"+RetencionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RetencionInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RetencionInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RetencionInvenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RetencionInvenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RetencionInvenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RetencionInvenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Retenciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Retencion";
	public static final String SCLASSWEBTITULO_LOWER="Retencion Inven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RetencionInven";
	public static final String OBJECTNAME="retencioninven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="retencion_inven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select retencioninven from "+RetencionInvenConstantesFunciones.SPERSISTENCENAME+" retencioninven";
	public static String QUERYSELECTNATIVE="select "+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".id,"+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".version_row,"+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".id_empresa,"+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".id_sucursal,"+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".id_ejercicio,"+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".id_periodo,"+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".id_compra,"+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".id_tipo_retencion,"+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".porcentaje,"+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".base_imponible,"+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".retencion,"+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".numero_retencion,"+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".id_cuenta_contable,"+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".id_anio,"+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".id_mes,"+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".numero_serie_retencion,"+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME+".codigo from "+RetencionInvenConstantesFunciones.SCHEMA+"."+RetencionInvenConstantesFunciones.TABLENAME;//+" as "+RetencionInvenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RetencionInvenConstantesFuncionesAdditional retencioninvenConstantesFuncionesAdditional=null;
	
	public RetencionInvenConstantesFuncionesAdditional getRetencionInvenConstantesFuncionesAdditional() {
		return this.retencioninvenConstantesFuncionesAdditional;
	}
	
	public void setRetencionInvenConstantesFuncionesAdditional(RetencionInvenConstantesFuncionesAdditional retencioninvenConstantesFuncionesAdditional) {
		try {
			this.retencioninvenConstantesFuncionesAdditional=retencioninvenConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDCOMPRA= "id_compra";
    public static final String IDTIPORETENCION= "id_tipo_retencion";
    public static final String PORCENTAJE= "porcentaje";
    public static final String BASEIMPONIBLE= "base_imponible";
    public static final String RETENCION= "retencion";
    public static final String NUMERORETENCION= "numero_retencion";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String NUMEROSERIERETENCION= "numero_serie_retencion";
    public static final String CODIGO= "codigo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDCOMPRA= "Compra";
		public static final String LABEL_IDCOMPRA_LOWER= "Compra";
    	public static final String LABEL_IDTIPORETENCION= "Tipo Retencion";
		public static final String LABEL_IDTIPORETENCION_LOWER= "Tipo Retencion";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_BASEIMPONIBLE= "Base Imponible";
		public static final String LABEL_BASEIMPONIBLE_LOWER= "Base Imponible";
    	public static final String LABEL_RETENCION= "Retencion";
		public static final String LABEL_RETENCION_LOWER= "Retencion";
    	public static final String LABEL_NUMERORETENCION= "Numero Retencion";
		public static final String LABEL_NUMERORETENCION_LOWER= "Numero Retencion";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_NUMEROSERIERETENCION= "Numero Serie Retencion";
		public static final String LABEL_NUMEROSERIERETENCION_LOWER= "Numero Serie Retencion";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_RETENCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_RETENCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getRetencionInvenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RetencionInvenConstantesFunciones.IDEMPRESA)) {sLabelColumna=RetencionInvenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RetencionInvenConstantesFunciones.IDSUCURSAL)) {sLabelColumna=RetencionInvenConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(RetencionInvenConstantesFunciones.IDEJERCICIO)) {sLabelColumna=RetencionInvenConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(RetencionInvenConstantesFunciones.IDPERIODO)) {sLabelColumna=RetencionInvenConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(RetencionInvenConstantesFunciones.IDCOMPRA)) {sLabelColumna=RetencionInvenConstantesFunciones.LABEL_IDCOMPRA;}
		if(sNombreColumna.equals(RetencionInvenConstantesFunciones.IDTIPORETENCION)) {sLabelColumna=RetencionInvenConstantesFunciones.LABEL_IDTIPORETENCION;}
		if(sNombreColumna.equals(RetencionInvenConstantesFunciones.PORCENTAJE)) {sLabelColumna=RetencionInvenConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(RetencionInvenConstantesFunciones.BASEIMPONIBLE)) {sLabelColumna=RetencionInvenConstantesFunciones.LABEL_BASEIMPONIBLE;}
		if(sNombreColumna.equals(RetencionInvenConstantesFunciones.RETENCION)) {sLabelColumna=RetencionInvenConstantesFunciones.LABEL_RETENCION;}
		if(sNombreColumna.equals(RetencionInvenConstantesFunciones.NUMERORETENCION)) {sLabelColumna=RetencionInvenConstantesFunciones.LABEL_NUMERORETENCION;}
		if(sNombreColumna.equals(RetencionInvenConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=RetencionInvenConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(RetencionInvenConstantesFunciones.IDANIO)) {sLabelColumna=RetencionInvenConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(RetencionInvenConstantesFunciones.IDMES)) {sLabelColumna=RetencionInvenConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(RetencionInvenConstantesFunciones.NUMEROSERIERETENCION)) {sLabelColumna=RetencionInvenConstantesFunciones.LABEL_NUMEROSERIERETENCION;}
		if(sNombreColumna.equals(RetencionInvenConstantesFunciones.CODIGO)) {sLabelColumna=RetencionInvenConstantesFunciones.LABEL_CODIGO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getRetencionInvenDescripcion(RetencionInven retencioninven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(retencioninven !=null/* && retencioninven.getId()!=0*/) {
			sDescripcion=retencioninven.getcodigo();//retencioninvenretencioninven.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getRetencionInvenDescripcionDetallado(RetencionInven retencioninven) {
		String sDescripcion="";
			
		sDescripcion+=RetencionInvenConstantesFunciones.ID+"=";
		sDescripcion+=retencioninven.getId().toString()+",";
		sDescripcion+=RetencionInvenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=retencioninven.getVersionRow().toString()+",";
		sDescripcion+=RetencionInvenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=retencioninven.getid_empresa().toString()+",";
		sDescripcion+=RetencionInvenConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=retencioninven.getid_sucursal().toString()+",";
		sDescripcion+=RetencionInvenConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=retencioninven.getid_ejercicio().toString()+",";
		sDescripcion+=RetencionInvenConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=retencioninven.getid_periodo().toString()+",";
		sDescripcion+=RetencionInvenConstantesFunciones.IDCOMPRA+"=";
		sDescripcion+=retencioninven.getid_compra().toString()+",";
		sDescripcion+=RetencionInvenConstantesFunciones.IDTIPORETENCION+"=";
		sDescripcion+=retencioninven.getid_tipo_retencion().toString()+",";
		sDescripcion+=RetencionInvenConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=retencioninven.getporcentaje().toString()+",";
		sDescripcion+=RetencionInvenConstantesFunciones.BASEIMPONIBLE+"=";
		sDescripcion+=retencioninven.getbase_imponible().toString()+",";
		sDescripcion+=RetencionInvenConstantesFunciones.RETENCION+"=";
		sDescripcion+=retencioninven.getretencion().toString()+",";
		sDescripcion+=RetencionInvenConstantesFunciones.NUMERORETENCION+"=";
		sDescripcion+=retencioninven.getnumero_retencion()+",";
		sDescripcion+=RetencionInvenConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=retencioninven.getid_cuenta_contable().toString()+",";
		sDescripcion+=RetencionInvenConstantesFunciones.IDANIO+"=";
		sDescripcion+=retencioninven.getid_anio().toString()+",";
		sDescripcion+=RetencionInvenConstantesFunciones.IDMES+"=";
		sDescripcion+=retencioninven.getid_mes().toString()+",";
		sDescripcion+=RetencionInvenConstantesFunciones.NUMEROSERIERETENCION+"=";
		sDescripcion+=retencioninven.getnumero_serie_retencion().toString()+",";
		sDescripcion+=RetencionInvenConstantesFunciones.CODIGO+"=";
		sDescripcion+=retencioninven.getcodigo()+",";
			
		return sDescripcion;
	}
	
	public static void setRetencionInvenDescripcion(RetencionInven retencioninven,String sValor) throws Exception {			
		if(retencioninven !=null) {
			retencioninven.setcodigo(sValor);;//retencioninvenretencioninven.getcodigo().trim();
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getCompraDescripcion(Compra compra) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(compra!=null/*&&compra.getId()>0*/) {
			sDescripcion=CompraConstantesFunciones.getCompraDescripcion(compra);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdCompra")) {
			sNombreIndice="Tipo=  Por Compra";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoRetencion")) {
			sNombreIndice="Tipo=  Por Tipo Retencion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCompra(Long id_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_compra!=null) {sDetalleIndice+=" Codigo Unico De Compra="+id_compra.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencion(Long id_tipo_retencion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion="+id_tipo_retencion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRetencionInven(RetencionInven retencioninven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		retencioninven.setnumero_retencion(retencioninven.getnumero_retencion().trim());
		retencioninven.setcodigo(retencioninven.getcodigo().trim());
	}
	
	public static void quitarEspaciosRetencionInvens(List<RetencionInven> retencioninvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RetencionInven retencioninven: retencioninvens) {
			retencioninven.setnumero_retencion(retencioninven.getnumero_retencion().trim());
			retencioninven.setcodigo(retencioninven.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRetencionInven(RetencionInven retencioninven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && retencioninven.getConCambioAuxiliar()) {
			retencioninven.setIsDeleted(retencioninven.getIsDeletedAuxiliar());	
			retencioninven.setIsNew(retencioninven.getIsNewAuxiliar());	
			retencioninven.setIsChanged(retencioninven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			retencioninven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			retencioninven.setIsDeletedAuxiliar(false);	
			retencioninven.setIsNewAuxiliar(false);	
			retencioninven.setIsChangedAuxiliar(false);
			
			retencioninven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRetencionInvens(List<RetencionInven> retencioninvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RetencionInven retencioninven : retencioninvens) {
			if(conAsignarBase && retencioninven.getConCambioAuxiliar()) {
				retencioninven.setIsDeleted(retencioninven.getIsDeletedAuxiliar());	
				retencioninven.setIsNew(retencioninven.getIsNewAuxiliar());	
				retencioninven.setIsChanged(retencioninven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				retencioninven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				retencioninven.setIsDeletedAuxiliar(false);	
				retencioninven.setIsNewAuxiliar(false);	
				retencioninven.setIsChangedAuxiliar(false);
				
				retencioninven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRetencionInven(RetencionInven retencioninven,Boolean conEnteros) throws Exception  {
		retencioninven.setporcentaje(0.0);
		retencioninven.setbase_imponible(0.0);
		retencioninven.setretencion(0.0);
		retencioninven.setnumero_serie_retencion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRetencionInvens(List<RetencionInven> retencioninvens,Boolean conEnteros) throws Exception  {
		
		for(RetencionInven retencioninven: retencioninvens) {
			retencioninven.setporcentaje(0.0);
			retencioninven.setbase_imponible(0.0);
			retencioninven.setretencion(0.0);
			retencioninven.setnumero_serie_retencion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRetencionInven(List<RetencionInven> retencioninvens,RetencionInven retencioninvenAux) throws Exception  {
		RetencionInvenConstantesFunciones.InicializarValoresRetencionInven(retencioninvenAux,true);
		
		for(RetencionInven retencioninven: retencioninvens) {
			if(retencioninven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			retencioninvenAux.setporcentaje(retencioninvenAux.getporcentaje()+retencioninven.getporcentaje());			
			retencioninvenAux.setbase_imponible(retencioninvenAux.getbase_imponible()+retencioninven.getbase_imponible());			
			retencioninvenAux.setretencion(retencioninvenAux.getretencion()+retencioninven.getretencion());			
			retencioninvenAux.setnumero_serie_retencion(retencioninvenAux.getnumero_serie_retencion()+retencioninven.getnumero_serie_retencion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRetencionInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RetencionInvenConstantesFunciones.getArrayColumnasGlobalesRetencionInven(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRetencionInven(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionInvenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionInvenConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionInvenConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionInvenConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionInvenConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionInvenConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionInvenConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionInvenConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRetencionInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RetencionInven> retencioninvens,RetencionInven retencioninven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RetencionInven retencioninvenAux: retencioninvens) {
			if(retencioninvenAux!=null && retencioninven!=null) {
				if((retencioninvenAux.getId()==null && retencioninven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(retencioninvenAux.getId()!=null && retencioninven.getId()!=null){
					if(retencioninvenAux.getId().equals(retencioninven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRetencionInven(List<RetencionInven> retencioninvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double base_imponibleTotal=0.0;
		Double retencionTotal=0.0;
		Double numero_serie_retencionTotal=0.0;
	
		for(RetencionInven retencioninven: retencioninvens) {			
			if(retencioninven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=retencioninven.getporcentaje();
			base_imponibleTotal+=retencioninven.getbase_imponible();
			retencionTotal+=retencioninven.getretencion();
			numero_serie_retencionTotal+=retencioninven.getnumero_serie_retencion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionInvenConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionInvenConstantesFunciones.BASEIMPONIBLE);
		datoGeneral.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_BASEIMPONIBLE);
		datoGeneral.setdValorDouble(base_imponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionInvenConstantesFunciones.RETENCION);
		datoGeneral.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_RETENCION);
		datoGeneral.setdValorDouble(retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionInvenConstantesFunciones.NUMEROSERIERETENCION);
		datoGeneral.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_NUMEROSERIERETENCION);
		datoGeneral.setdValorDouble(numero_serie_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRetencionInven() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_ID, RetencionInvenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_VERSIONROW, RetencionInvenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_IDEMPRESA, RetencionInvenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_IDSUCURSAL, RetencionInvenConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_IDEJERCICIO, RetencionInvenConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_IDPERIODO, RetencionInvenConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_IDCOMPRA, RetencionInvenConstantesFunciones.IDCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_IDTIPORETENCION, RetencionInvenConstantesFunciones.IDTIPORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_PORCENTAJE, RetencionInvenConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_BASEIMPONIBLE, RetencionInvenConstantesFunciones.BASEIMPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_RETENCION, RetencionInvenConstantesFunciones.RETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_NUMERORETENCION, RetencionInvenConstantesFunciones.NUMERORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_IDCUENTACONTABLE, RetencionInvenConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_IDANIO, RetencionInvenConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_IDMES, RetencionInvenConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_NUMEROSERIERETENCION, RetencionInvenConstantesFunciones.NUMEROSERIERETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionInvenConstantesFunciones.LABEL_CODIGO, RetencionInvenConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRetencionInven() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.IDCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.IDTIPORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.BASEIMPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.RETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.NUMERORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.NUMEROSERIERETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionInvenConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRetencionInven() throws Exception  {
		return RetencionInvenConstantesFunciones.getTiposSeleccionarRetencionInven(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRetencionInven(Boolean conFk) throws Exception  {
		return RetencionInvenConstantesFunciones.getTiposSeleccionarRetencionInven(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRetencionInven(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionInvenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionInvenConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionInvenConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionInvenConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionInvenConstantesFunciones.LABEL_IDCOMPRA);
			reporte.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_IDCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionInvenConstantesFunciones.LABEL_IDTIPORETENCION);
			reporte.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_IDTIPORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionInvenConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionInvenConstantesFunciones.LABEL_BASEIMPONIBLE);
			reporte.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_BASEIMPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionInvenConstantesFunciones.LABEL_RETENCION);
			reporte.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_RETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionInvenConstantesFunciones.LABEL_NUMERORETENCION);
			reporte.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_NUMERORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionInvenConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionInvenConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionInvenConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionInvenConstantesFunciones.LABEL_NUMEROSERIERETENCION);
			reporte.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_NUMEROSERIERETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionInvenConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(RetencionInvenConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRetencionInven(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRetencionInven(RetencionInven retencioninvenAux) throws Exception {
		
			retencioninvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(retencioninvenAux.getEmpresa()));
			retencioninvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(retencioninvenAux.getSucursal()));
			retencioninvenAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(retencioninvenAux.getEjercicio()));
			retencioninvenAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(retencioninvenAux.getPeriodo()));
			retencioninvenAux.setcompra_descripcion(CompraConstantesFunciones.getCompraDescripcion(retencioninvenAux.getCompra()));
			retencioninvenAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(retencioninvenAux.getTipoRetencion()));
			retencioninvenAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(retencioninvenAux.getCuentaContable()));
			retencioninvenAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(retencioninvenAux.getAnio()));
			retencioninvenAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(retencioninvenAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRetencionInven(List<RetencionInven> retencioninvensTemp) throws Exception {
		for(RetencionInven retencioninvenAux:retencioninvensTemp) {
			
			retencioninvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(retencioninvenAux.getEmpresa()));
			retencioninvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(retencioninvenAux.getSucursal()));
			retencioninvenAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(retencioninvenAux.getEjercicio()));
			retencioninvenAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(retencioninvenAux.getPeriodo()));
			retencioninvenAux.setcompra_descripcion(CompraConstantesFunciones.getCompraDescripcion(retencioninvenAux.getCompra()));
			retencioninvenAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(retencioninvenAux.getTipoRetencion()));
			retencioninvenAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(retencioninvenAux.getCuentaContable()));
			retencioninvenAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(retencioninvenAux.getAnio()));
			retencioninvenAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(retencioninvenAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRetencionInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Compra.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Compra.class)) {
						classes.add(new Classe(Compra.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRetencionInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Compra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Compra.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Compra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Compra.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRetencionInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RetencionInvenConstantesFunciones.getClassesRelationshipsOfRetencionInven(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRetencionInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRetencionInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RetencionInvenConstantesFunciones.getClassesRelationshipsFromStringsOfRetencionInven(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRetencionInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(RetencionInven retencioninven,List<RetencionInven> retencioninvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			RetencionInven retencioninvenEncontrado=null;
			
			for(RetencionInven retencioninvenLocal:retencioninvens) {
				if(retencioninvenLocal.getId().equals(retencioninven.getId())) {
					retencioninvenEncontrado=retencioninvenLocal;
					
					retencioninvenLocal.setIsChanged(retencioninven.getIsChanged());
					retencioninvenLocal.setIsNew(retencioninven.getIsNew());
					retencioninvenLocal.setIsDeleted(retencioninven.getIsDeleted());
					
					retencioninvenLocal.setGeneralEntityOriginal(retencioninven.getGeneralEntityOriginal());
					
					retencioninvenLocal.setId(retencioninven.getId());	
					retencioninvenLocal.setVersionRow(retencioninven.getVersionRow());	
					retencioninvenLocal.setid_empresa(retencioninven.getid_empresa());	
					retencioninvenLocal.setid_sucursal(retencioninven.getid_sucursal());	
					retencioninvenLocal.setid_ejercicio(retencioninven.getid_ejercicio());	
					retencioninvenLocal.setid_periodo(retencioninven.getid_periodo());	
					retencioninvenLocal.setid_compra(retencioninven.getid_compra());	
					retencioninvenLocal.setid_tipo_retencion(retencioninven.getid_tipo_retencion());	
					retencioninvenLocal.setporcentaje(retencioninven.getporcentaje());	
					retencioninvenLocal.setbase_imponible(retencioninven.getbase_imponible());	
					retencioninvenLocal.setretencion(retencioninven.getretencion());	
					retencioninvenLocal.setnumero_retencion(retencioninven.getnumero_retencion());	
					retencioninvenLocal.setid_cuenta_contable(retencioninven.getid_cuenta_contable());	
					retencioninvenLocal.setid_anio(retencioninven.getid_anio());	
					retencioninvenLocal.setid_mes(retencioninven.getid_mes());	
					retencioninvenLocal.setnumero_serie_retencion(retencioninven.getnumero_serie_retencion());	
					retencioninvenLocal.setcodigo(retencioninven.getcodigo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!retencioninven.getIsDeleted()) {
				if(!existe) {
					retencioninvens.add(retencioninven);
				}
			} else {
				if(retencioninvenEncontrado!=null && permiteQuitar)  {
					retencioninvens.remove(retencioninvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(RetencionInven retencioninven,List<RetencionInven> retencioninvens) throws Exception {
		try	{			
			for(RetencionInven retencioninvenLocal:retencioninvens) {
				if(retencioninvenLocal.getId().equals(retencioninven.getId())) {
					retencioninvenLocal.setIsSelected(retencioninven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRetencionInven(List<RetencionInven> retencioninvensAux) throws Exception {
		//this.retencioninvensAux=retencioninvensAux;
		
		for(RetencionInven retencioninvenAux:retencioninvensAux) {
			if(retencioninvenAux.getIsChanged()) {
				retencioninvenAux.setIsChanged(false);
			}		
			
			if(retencioninvenAux.getIsNew()) {
				retencioninvenAux.setIsNew(false);
			}	
			
			if(retencioninvenAux.getIsDeleted()) {
				retencioninvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRetencionInven(RetencionInven retencioninvenAux) throws Exception {
		//this.retencioninvenAux=retencioninvenAux;
		
			if(retencioninvenAux.getIsChanged()) {
				retencioninvenAux.setIsChanged(false);
			}		
			
			if(retencioninvenAux.getIsNew()) {
				retencioninvenAux.setIsNew(false);
			}	
			
			if(retencioninvenAux.getIsDeleted()) {
				retencioninvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RetencionInven retencioninvenAsignar,RetencionInven retencioninven) throws Exception {
		retencioninvenAsignar.setId(retencioninven.getId());	
		retencioninvenAsignar.setVersionRow(retencioninven.getVersionRow());	
		retencioninvenAsignar.setid_empresa(retencioninven.getid_empresa());
		retencioninvenAsignar.setempresa_descripcion(retencioninven.getempresa_descripcion());	
		retencioninvenAsignar.setid_sucursal(retencioninven.getid_sucursal());
		retencioninvenAsignar.setsucursal_descripcion(retencioninven.getsucursal_descripcion());	
		retencioninvenAsignar.setid_ejercicio(retencioninven.getid_ejercicio());
		retencioninvenAsignar.setejercicio_descripcion(retencioninven.getejercicio_descripcion());	
		retencioninvenAsignar.setid_periodo(retencioninven.getid_periodo());
		retencioninvenAsignar.setperiodo_descripcion(retencioninven.getperiodo_descripcion());	
		retencioninvenAsignar.setid_compra(retencioninven.getid_compra());
		retencioninvenAsignar.setcompra_descripcion(retencioninven.getcompra_descripcion());	
		retencioninvenAsignar.setid_tipo_retencion(retencioninven.getid_tipo_retencion());
		retencioninvenAsignar.settiporetencion_descripcion(retencioninven.gettiporetencion_descripcion());	
		retencioninvenAsignar.setporcentaje(retencioninven.getporcentaje());	
		retencioninvenAsignar.setbase_imponible(retencioninven.getbase_imponible());	
		retencioninvenAsignar.setretencion(retencioninven.getretencion());	
		retencioninvenAsignar.setnumero_retencion(retencioninven.getnumero_retencion());	
		retencioninvenAsignar.setid_cuenta_contable(retencioninven.getid_cuenta_contable());
		retencioninvenAsignar.setcuentacontable_descripcion(retencioninven.getcuentacontable_descripcion());	
		retencioninvenAsignar.setid_anio(retencioninven.getid_anio());
		retencioninvenAsignar.setanio_descripcion(retencioninven.getanio_descripcion());	
		retencioninvenAsignar.setid_mes(retencioninven.getid_mes());
		retencioninvenAsignar.setmes_descripcion(retencioninven.getmes_descripcion());	
		retencioninvenAsignar.setnumero_serie_retencion(retencioninven.getnumero_serie_retencion());	
		retencioninvenAsignar.setcodigo(retencioninven.getcodigo());	
	}
	
	public static void inicializarRetencionInven(RetencionInven retencioninven) throws Exception {
		try {
				retencioninven.setId(0L);	
					
				retencioninven.setid_empresa(-1L);	
				retencioninven.setid_sucursal(-1L);	
				retencioninven.setid_ejercicio(-1L);	
				retencioninven.setid_periodo(-1L);	
				retencioninven.setid_compra(-1L);	
				retencioninven.setid_tipo_retencion(-1L);	
				retencioninven.setporcentaje(0.0);	
				retencioninven.setbase_imponible(0.0);	
				retencioninven.setretencion(0.0);	
				retencioninven.setnumero_retencion("");	
				retencioninven.setid_cuenta_contable(null);	
				retencioninven.setid_anio(null);	
				retencioninven.setid_mes(null);	
				retencioninven.setnumero_serie_retencion(0.0);	
				retencioninven.setcodigo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRetencionInven(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionInvenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionInvenConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionInvenConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionInvenConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionInvenConstantesFunciones.LABEL_IDCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionInvenConstantesFunciones.LABEL_IDTIPORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionInvenConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionInvenConstantesFunciones.LABEL_BASEIMPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionInvenConstantesFunciones.LABEL_RETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionInvenConstantesFunciones.LABEL_NUMERORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionInvenConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionInvenConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionInvenConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionInvenConstantesFunciones.LABEL_NUMEROSERIERETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionInvenConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRetencionInven(String sTipo,Row row,Workbook workbook,RetencionInven retencioninven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(retencioninven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencioninven.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencioninven.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencioninven.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencioninven.getcompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencioninven.gettiporetencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencioninven.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencioninven.getbase_imponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencioninven.getretencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencioninven.getnumero_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencioninven.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencioninven.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencioninven.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencioninven.getnumero_serie_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencioninven.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRetencionInven=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRetencionInven() {
		return this.sFinalQueryRetencionInven;
	}
	
	public void setsFinalQueryRetencionInven(String sFinalQueryRetencionInven) {
		this.sFinalQueryRetencionInven= sFinalQueryRetencionInven;
	}
	
	public Border resaltarSeleccionarRetencionInven=null;
	
	public Border setResaltarSeleccionarRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRetencionInven= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRetencionInven() {
		return this.resaltarSeleccionarRetencionInven;
	}
	
	public void setResaltarSeleccionarRetencionInven(Border borderResaltarSeleccionarRetencionInven) {
		this.resaltarSeleccionarRetencionInven= borderResaltarSeleccionarRetencionInven;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRetencionInven=null;
	public Boolean mostraridRetencionInven=true;
	public Boolean activaridRetencionInven=true;

	public Border resaltarid_empresaRetencionInven=null;
	public Boolean mostrarid_empresaRetencionInven=true;
	public Boolean activarid_empresaRetencionInven=true;
	public Boolean cargarid_empresaRetencionInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRetencionInven=false;//ConEventDepend=true

	public Border resaltarid_sucursalRetencionInven=null;
	public Boolean mostrarid_sucursalRetencionInven=true;
	public Boolean activarid_sucursalRetencionInven=true;
	public Boolean cargarid_sucursalRetencionInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalRetencionInven=false;//ConEventDepend=true

	public Border resaltarid_ejercicioRetencionInven=null;
	public Boolean mostrarid_ejercicioRetencionInven=true;
	public Boolean activarid_ejercicioRetencionInven=true;
	public Boolean cargarid_ejercicioRetencionInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioRetencionInven=false;//ConEventDepend=true

	public Border resaltarid_periodoRetencionInven=null;
	public Boolean mostrarid_periodoRetencionInven=true;
	public Boolean activarid_periodoRetencionInven=true;
	public Boolean cargarid_periodoRetencionInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoRetencionInven=false;//ConEventDepend=true

	public Border resaltarid_compraRetencionInven=null;
	public Boolean mostrarid_compraRetencionInven=true;
	public Boolean activarid_compraRetencionInven=true;
	public Boolean cargarid_compraRetencionInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_compraRetencionInven=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencionRetencionInven=null;
	public Boolean mostrarid_tipo_retencionRetencionInven=true;
	public Boolean activarid_tipo_retencionRetencionInven=true;
	public Boolean cargarid_tipo_retencionRetencionInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencionRetencionInven=false;//ConEventDepend=true

	public Border resaltarporcentajeRetencionInven=null;
	public Boolean mostrarporcentajeRetencionInven=true;
	public Boolean activarporcentajeRetencionInven=true;

	public Border resaltarbase_imponibleRetencionInven=null;
	public Boolean mostrarbase_imponibleRetencionInven=true;
	public Boolean activarbase_imponibleRetencionInven=true;

	public Border resaltarretencionRetencionInven=null;
	public Boolean mostrarretencionRetencionInven=true;
	public Boolean activarretencionRetencionInven=true;

	public Border resaltarnumero_retencionRetencionInven=null;
	public Boolean mostrarnumero_retencionRetencionInven=true;
	public Boolean activarnumero_retencionRetencionInven=true;

	public Border resaltarid_cuenta_contableRetencionInven=null;
	public Boolean mostrarid_cuenta_contableRetencionInven=true;
	public Boolean activarid_cuenta_contableRetencionInven=true;
	public Boolean cargarid_cuenta_contableRetencionInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableRetencionInven=false;//ConEventDepend=true

	public Border resaltarid_anioRetencionInven=null;
	public Boolean mostrarid_anioRetencionInven=true;
	public Boolean activarid_anioRetencionInven=false;
	public Boolean cargarid_anioRetencionInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioRetencionInven=false;//ConEventDepend=true

	public Border resaltarid_mesRetencionInven=null;
	public Boolean mostrarid_mesRetencionInven=true;
	public Boolean activarid_mesRetencionInven=false;
	public Boolean cargarid_mesRetencionInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesRetencionInven=false;//ConEventDepend=true

	public Border resaltarnumero_serie_retencionRetencionInven=null;
	public Boolean mostrarnumero_serie_retencionRetencionInven=true;
	public Boolean activarnumero_serie_retencionRetencionInven=false;

	public Border resaltarcodigoRetencionInven=null;
	public Boolean mostrarcodigoRetencionInven=true;
	public Boolean activarcodigoRetencionInven=false;

	
	

	public Border setResaltaridRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltaridRetencionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRetencionInven() {
		return this.resaltaridRetencionInven;
	}

	public void setResaltaridRetencionInven(Border borderResaltar) {
		this.resaltaridRetencionInven= borderResaltar;
	}

	public Boolean getMostraridRetencionInven() {
		return this.mostraridRetencionInven;
	}

	public void setMostraridRetencionInven(Boolean mostraridRetencionInven) {
		this.mostraridRetencionInven= mostraridRetencionInven;
	}

	public Boolean getActivaridRetencionInven() {
		return this.activaridRetencionInven;
	}

	public void setActivaridRetencionInven(Boolean activaridRetencionInven) {
		this.activaridRetencionInven= activaridRetencionInven;
	}

	public Border setResaltarid_empresaRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltarid_empresaRetencionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRetencionInven() {
		return this.resaltarid_empresaRetencionInven;
	}

	public void setResaltarid_empresaRetencionInven(Border borderResaltar) {
		this.resaltarid_empresaRetencionInven= borderResaltar;
	}

	public Boolean getMostrarid_empresaRetencionInven() {
		return this.mostrarid_empresaRetencionInven;
	}

	public void setMostrarid_empresaRetencionInven(Boolean mostrarid_empresaRetencionInven) {
		this.mostrarid_empresaRetencionInven= mostrarid_empresaRetencionInven;
	}

	public Boolean getActivarid_empresaRetencionInven() {
		return this.activarid_empresaRetencionInven;
	}

	public void setActivarid_empresaRetencionInven(Boolean activarid_empresaRetencionInven) {
		this.activarid_empresaRetencionInven= activarid_empresaRetencionInven;
	}

	public Boolean getCargarid_empresaRetencionInven() {
		return this.cargarid_empresaRetencionInven;
	}

	public void setCargarid_empresaRetencionInven(Boolean cargarid_empresaRetencionInven) {
		this.cargarid_empresaRetencionInven= cargarid_empresaRetencionInven;
	}

	public Border setResaltarid_sucursalRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltarid_sucursalRetencionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalRetencionInven() {
		return this.resaltarid_sucursalRetencionInven;
	}

	public void setResaltarid_sucursalRetencionInven(Border borderResaltar) {
		this.resaltarid_sucursalRetencionInven= borderResaltar;
	}

	public Boolean getMostrarid_sucursalRetencionInven() {
		return this.mostrarid_sucursalRetencionInven;
	}

	public void setMostrarid_sucursalRetencionInven(Boolean mostrarid_sucursalRetencionInven) {
		this.mostrarid_sucursalRetencionInven= mostrarid_sucursalRetencionInven;
	}

	public Boolean getActivarid_sucursalRetencionInven() {
		return this.activarid_sucursalRetencionInven;
	}

	public void setActivarid_sucursalRetencionInven(Boolean activarid_sucursalRetencionInven) {
		this.activarid_sucursalRetencionInven= activarid_sucursalRetencionInven;
	}

	public Boolean getCargarid_sucursalRetencionInven() {
		return this.cargarid_sucursalRetencionInven;
	}

	public void setCargarid_sucursalRetencionInven(Boolean cargarid_sucursalRetencionInven) {
		this.cargarid_sucursalRetencionInven= cargarid_sucursalRetencionInven;
	}

	public Border setResaltarid_ejercicioRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioRetencionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioRetencionInven() {
		return this.resaltarid_ejercicioRetencionInven;
	}

	public void setResaltarid_ejercicioRetencionInven(Border borderResaltar) {
		this.resaltarid_ejercicioRetencionInven= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioRetencionInven() {
		return this.mostrarid_ejercicioRetencionInven;
	}

	public void setMostrarid_ejercicioRetencionInven(Boolean mostrarid_ejercicioRetencionInven) {
		this.mostrarid_ejercicioRetencionInven= mostrarid_ejercicioRetencionInven;
	}

	public Boolean getActivarid_ejercicioRetencionInven() {
		return this.activarid_ejercicioRetencionInven;
	}

	public void setActivarid_ejercicioRetencionInven(Boolean activarid_ejercicioRetencionInven) {
		this.activarid_ejercicioRetencionInven= activarid_ejercicioRetencionInven;
	}

	public Boolean getCargarid_ejercicioRetencionInven() {
		return this.cargarid_ejercicioRetencionInven;
	}

	public void setCargarid_ejercicioRetencionInven(Boolean cargarid_ejercicioRetencionInven) {
		this.cargarid_ejercicioRetencionInven= cargarid_ejercicioRetencionInven;
	}

	public Border setResaltarid_periodoRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltarid_periodoRetencionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoRetencionInven() {
		return this.resaltarid_periodoRetencionInven;
	}

	public void setResaltarid_periodoRetencionInven(Border borderResaltar) {
		this.resaltarid_periodoRetencionInven= borderResaltar;
	}

	public Boolean getMostrarid_periodoRetencionInven() {
		return this.mostrarid_periodoRetencionInven;
	}

	public void setMostrarid_periodoRetencionInven(Boolean mostrarid_periodoRetencionInven) {
		this.mostrarid_periodoRetencionInven= mostrarid_periodoRetencionInven;
	}

	public Boolean getActivarid_periodoRetencionInven() {
		return this.activarid_periodoRetencionInven;
	}

	public void setActivarid_periodoRetencionInven(Boolean activarid_periodoRetencionInven) {
		this.activarid_periodoRetencionInven= activarid_periodoRetencionInven;
	}

	public Boolean getCargarid_periodoRetencionInven() {
		return this.cargarid_periodoRetencionInven;
	}

	public void setCargarid_periodoRetencionInven(Boolean cargarid_periodoRetencionInven) {
		this.cargarid_periodoRetencionInven= cargarid_periodoRetencionInven;
	}

	public Border setResaltarid_compraRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltarid_compraRetencionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_compraRetencionInven() {
		return this.resaltarid_compraRetencionInven;
	}

	public void setResaltarid_compraRetencionInven(Border borderResaltar) {
		this.resaltarid_compraRetencionInven= borderResaltar;
	}

	public Boolean getMostrarid_compraRetencionInven() {
		return this.mostrarid_compraRetencionInven;
	}

	public void setMostrarid_compraRetencionInven(Boolean mostrarid_compraRetencionInven) {
		this.mostrarid_compraRetencionInven= mostrarid_compraRetencionInven;
	}

	public Boolean getActivarid_compraRetencionInven() {
		return this.activarid_compraRetencionInven;
	}

	public void setActivarid_compraRetencionInven(Boolean activarid_compraRetencionInven) {
		this.activarid_compraRetencionInven= activarid_compraRetencionInven;
	}

	public Boolean getCargarid_compraRetencionInven() {
		return this.cargarid_compraRetencionInven;
	}

	public void setCargarid_compraRetencionInven(Boolean cargarid_compraRetencionInven) {
		this.cargarid_compraRetencionInven= cargarid_compraRetencionInven;
	}

	public Border setResaltarid_tipo_retencionRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencionRetencionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencionRetencionInven() {
		return this.resaltarid_tipo_retencionRetencionInven;
	}

	public void setResaltarid_tipo_retencionRetencionInven(Border borderResaltar) {
		this.resaltarid_tipo_retencionRetencionInven= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencionRetencionInven() {
		return this.mostrarid_tipo_retencionRetencionInven;
	}

	public void setMostrarid_tipo_retencionRetencionInven(Boolean mostrarid_tipo_retencionRetencionInven) {
		this.mostrarid_tipo_retencionRetencionInven= mostrarid_tipo_retencionRetencionInven;
	}

	public Boolean getActivarid_tipo_retencionRetencionInven() {
		return this.activarid_tipo_retencionRetencionInven;
	}

	public void setActivarid_tipo_retencionRetencionInven(Boolean activarid_tipo_retencionRetencionInven) {
		this.activarid_tipo_retencionRetencionInven= activarid_tipo_retencionRetencionInven;
	}

	public Boolean getCargarid_tipo_retencionRetencionInven() {
		return this.cargarid_tipo_retencionRetencionInven;
	}

	public void setCargarid_tipo_retencionRetencionInven(Boolean cargarid_tipo_retencionRetencionInven) {
		this.cargarid_tipo_retencionRetencionInven= cargarid_tipo_retencionRetencionInven;
	}

	public Border setResaltarporcentajeRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltarporcentajeRetencionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeRetencionInven() {
		return this.resaltarporcentajeRetencionInven;
	}

	public void setResaltarporcentajeRetencionInven(Border borderResaltar) {
		this.resaltarporcentajeRetencionInven= borderResaltar;
	}

	public Boolean getMostrarporcentajeRetencionInven() {
		return this.mostrarporcentajeRetencionInven;
	}

	public void setMostrarporcentajeRetencionInven(Boolean mostrarporcentajeRetencionInven) {
		this.mostrarporcentajeRetencionInven= mostrarporcentajeRetencionInven;
	}

	public Boolean getActivarporcentajeRetencionInven() {
		return this.activarporcentajeRetencionInven;
	}

	public void setActivarporcentajeRetencionInven(Boolean activarporcentajeRetencionInven) {
		this.activarporcentajeRetencionInven= activarporcentajeRetencionInven;
	}

	public Border setResaltarbase_imponibleRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltarbase_imponibleRetencionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_imponibleRetencionInven() {
		return this.resaltarbase_imponibleRetencionInven;
	}

	public void setResaltarbase_imponibleRetencionInven(Border borderResaltar) {
		this.resaltarbase_imponibleRetencionInven= borderResaltar;
	}

	public Boolean getMostrarbase_imponibleRetencionInven() {
		return this.mostrarbase_imponibleRetencionInven;
	}

	public void setMostrarbase_imponibleRetencionInven(Boolean mostrarbase_imponibleRetencionInven) {
		this.mostrarbase_imponibleRetencionInven= mostrarbase_imponibleRetencionInven;
	}

	public Boolean getActivarbase_imponibleRetencionInven() {
		return this.activarbase_imponibleRetencionInven;
	}

	public void setActivarbase_imponibleRetencionInven(Boolean activarbase_imponibleRetencionInven) {
		this.activarbase_imponibleRetencionInven= activarbase_imponibleRetencionInven;
	}

	public Border setResaltarretencionRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltarretencionRetencionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarretencionRetencionInven() {
		return this.resaltarretencionRetencionInven;
	}

	public void setResaltarretencionRetencionInven(Border borderResaltar) {
		this.resaltarretencionRetencionInven= borderResaltar;
	}

	public Boolean getMostrarretencionRetencionInven() {
		return this.mostrarretencionRetencionInven;
	}

	public void setMostrarretencionRetencionInven(Boolean mostrarretencionRetencionInven) {
		this.mostrarretencionRetencionInven= mostrarretencionRetencionInven;
	}

	public Boolean getActivarretencionRetencionInven() {
		return this.activarretencionRetencionInven;
	}

	public void setActivarretencionRetencionInven(Boolean activarretencionRetencionInven) {
		this.activarretencionRetencionInven= activarretencionRetencionInven;
	}

	public Border setResaltarnumero_retencionRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltarnumero_retencionRetencionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_retencionRetencionInven() {
		return this.resaltarnumero_retencionRetencionInven;
	}

	public void setResaltarnumero_retencionRetencionInven(Border borderResaltar) {
		this.resaltarnumero_retencionRetencionInven= borderResaltar;
	}

	public Boolean getMostrarnumero_retencionRetencionInven() {
		return this.mostrarnumero_retencionRetencionInven;
	}

	public void setMostrarnumero_retencionRetencionInven(Boolean mostrarnumero_retencionRetencionInven) {
		this.mostrarnumero_retencionRetencionInven= mostrarnumero_retencionRetencionInven;
	}

	public Boolean getActivarnumero_retencionRetencionInven() {
		return this.activarnumero_retencionRetencionInven;
	}

	public void setActivarnumero_retencionRetencionInven(Boolean activarnumero_retencionRetencionInven) {
		this.activarnumero_retencionRetencionInven= activarnumero_retencionRetencionInven;
	}

	public Border setResaltarid_cuenta_contableRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableRetencionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableRetencionInven() {
		return this.resaltarid_cuenta_contableRetencionInven;
	}

	public void setResaltarid_cuenta_contableRetencionInven(Border borderResaltar) {
		this.resaltarid_cuenta_contableRetencionInven= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableRetencionInven() {
		return this.mostrarid_cuenta_contableRetencionInven;
	}

	public void setMostrarid_cuenta_contableRetencionInven(Boolean mostrarid_cuenta_contableRetencionInven) {
		this.mostrarid_cuenta_contableRetencionInven= mostrarid_cuenta_contableRetencionInven;
	}

	public Boolean getActivarid_cuenta_contableRetencionInven() {
		return this.activarid_cuenta_contableRetencionInven;
	}

	public void setActivarid_cuenta_contableRetencionInven(Boolean activarid_cuenta_contableRetencionInven) {
		this.activarid_cuenta_contableRetencionInven= activarid_cuenta_contableRetencionInven;
	}

	public Boolean getCargarid_cuenta_contableRetencionInven() {
		return this.cargarid_cuenta_contableRetencionInven;
	}

	public void setCargarid_cuenta_contableRetencionInven(Boolean cargarid_cuenta_contableRetencionInven) {
		this.cargarid_cuenta_contableRetencionInven= cargarid_cuenta_contableRetencionInven;
	}

	public Border setResaltarid_anioRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltarid_anioRetencionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioRetencionInven() {
		return this.resaltarid_anioRetencionInven;
	}

	public void setResaltarid_anioRetencionInven(Border borderResaltar) {
		this.resaltarid_anioRetencionInven= borderResaltar;
	}

	public Boolean getMostrarid_anioRetencionInven() {
		return this.mostrarid_anioRetencionInven;
	}

	public void setMostrarid_anioRetencionInven(Boolean mostrarid_anioRetencionInven) {
		this.mostrarid_anioRetencionInven= mostrarid_anioRetencionInven;
	}

	public Boolean getActivarid_anioRetencionInven() {
		return this.activarid_anioRetencionInven;
	}

	public void setActivarid_anioRetencionInven(Boolean activarid_anioRetencionInven) {
		this.activarid_anioRetencionInven= activarid_anioRetencionInven;
	}

	public Boolean getCargarid_anioRetencionInven() {
		return this.cargarid_anioRetencionInven;
	}

	public void setCargarid_anioRetencionInven(Boolean cargarid_anioRetencionInven) {
		this.cargarid_anioRetencionInven= cargarid_anioRetencionInven;
	}

	public Border setResaltarid_mesRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltarid_mesRetencionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesRetencionInven() {
		return this.resaltarid_mesRetencionInven;
	}

	public void setResaltarid_mesRetencionInven(Border borderResaltar) {
		this.resaltarid_mesRetencionInven= borderResaltar;
	}

	public Boolean getMostrarid_mesRetencionInven() {
		return this.mostrarid_mesRetencionInven;
	}

	public void setMostrarid_mesRetencionInven(Boolean mostrarid_mesRetencionInven) {
		this.mostrarid_mesRetencionInven= mostrarid_mesRetencionInven;
	}

	public Boolean getActivarid_mesRetencionInven() {
		return this.activarid_mesRetencionInven;
	}

	public void setActivarid_mesRetencionInven(Boolean activarid_mesRetencionInven) {
		this.activarid_mesRetencionInven= activarid_mesRetencionInven;
	}

	public Boolean getCargarid_mesRetencionInven() {
		return this.cargarid_mesRetencionInven;
	}

	public void setCargarid_mesRetencionInven(Boolean cargarid_mesRetencionInven) {
		this.cargarid_mesRetencionInven= cargarid_mesRetencionInven;
	}

	public Border setResaltarnumero_serie_retencionRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltarnumero_serie_retencionRetencionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_serie_retencionRetencionInven() {
		return this.resaltarnumero_serie_retencionRetencionInven;
	}

	public void setResaltarnumero_serie_retencionRetencionInven(Border borderResaltar) {
		this.resaltarnumero_serie_retencionRetencionInven= borderResaltar;
	}

	public Boolean getMostrarnumero_serie_retencionRetencionInven() {
		return this.mostrarnumero_serie_retencionRetencionInven;
	}

	public void setMostrarnumero_serie_retencionRetencionInven(Boolean mostrarnumero_serie_retencionRetencionInven) {
		this.mostrarnumero_serie_retencionRetencionInven= mostrarnumero_serie_retencionRetencionInven;
	}

	public Boolean getActivarnumero_serie_retencionRetencionInven() {
		return this.activarnumero_serie_retencionRetencionInven;
	}

	public void setActivarnumero_serie_retencionRetencionInven(Boolean activarnumero_serie_retencionRetencionInven) {
		this.activarnumero_serie_retencionRetencionInven= activarnumero_serie_retencionRetencionInven;
	}

	public Border setResaltarcodigoRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencioninvenBeanSwingJInternalFrame.jTtoolBarRetencionInven.setBorder(borderResaltar);
		
		this.resaltarcodigoRetencionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoRetencionInven() {
		return this.resaltarcodigoRetencionInven;
	}

	public void setResaltarcodigoRetencionInven(Border borderResaltar) {
		this.resaltarcodigoRetencionInven= borderResaltar;
	}

	public Boolean getMostrarcodigoRetencionInven() {
		return this.mostrarcodigoRetencionInven;
	}

	public void setMostrarcodigoRetencionInven(Boolean mostrarcodigoRetencionInven) {
		this.mostrarcodigoRetencionInven= mostrarcodigoRetencionInven;
	}

	public Boolean getActivarcodigoRetencionInven() {
		return this.activarcodigoRetencionInven;
	}

	public void setActivarcodigoRetencionInven(Boolean activarcodigoRetencionInven) {
		this.activarcodigoRetencionInven= activarcodigoRetencionInven;
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
		
		
		this.setMostraridRetencionInven(esInicial);
		this.setMostrarid_empresaRetencionInven(esInicial);
		this.setMostrarid_sucursalRetencionInven(esInicial);
		this.setMostrarid_ejercicioRetencionInven(esInicial);
		this.setMostrarid_periodoRetencionInven(esInicial);
		this.setMostrarid_compraRetencionInven(esInicial);
		this.setMostrarid_tipo_retencionRetencionInven(esInicial);
		this.setMostrarporcentajeRetencionInven(esInicial);
		this.setMostrarbase_imponibleRetencionInven(esInicial);
		this.setMostrarretencionRetencionInven(esInicial);
		this.setMostrarnumero_retencionRetencionInven(esInicial);
		this.setMostrarid_cuenta_contableRetencionInven(esInicial);
		this.setMostrarid_anioRetencionInven(esInicial);
		this.setMostrarid_mesRetencionInven(esInicial);
		this.setMostrarnumero_serie_retencionRetencionInven(esInicial);
		this.setMostrarcodigoRetencionInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RetencionInvenConstantesFunciones.ID)) {
				this.setMostraridRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDCOMPRA)) {
				this.setMostrarid_compraRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDTIPORETENCION)) {
				this.setMostrarid_tipo_retencionRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.BASEIMPONIBLE)) {
				this.setMostrarbase_imponibleRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.RETENCION)) {
				this.setMostrarretencionRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.NUMERORETENCION)) {
				this.setMostrarnumero_retencionRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDMES)) {
				this.setMostrarid_mesRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.NUMEROSERIERETENCION)) {
				this.setMostrarnumero_serie_retencionRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoRetencionInven(esAsigna);
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
		
		
		this.setActivaridRetencionInven(esInicial);
		this.setActivarid_empresaRetencionInven(esInicial);
		this.setActivarid_sucursalRetencionInven(esInicial);
		this.setActivarid_ejercicioRetencionInven(esInicial);
		this.setActivarid_periodoRetencionInven(esInicial);
		this.setActivarid_compraRetencionInven(esInicial);
		this.setActivarid_tipo_retencionRetencionInven(esInicial);
		this.setActivarporcentajeRetencionInven(esInicial);
		this.setActivarbase_imponibleRetencionInven(esInicial);
		this.setActivarretencionRetencionInven(esInicial);
		this.setActivarnumero_retencionRetencionInven(esInicial);
		this.setActivarid_cuenta_contableRetencionInven(esInicial);
		this.setActivarid_anioRetencionInven(esInicial);
		this.setActivarid_mesRetencionInven(esInicial);
		this.setActivarnumero_serie_retencionRetencionInven(esInicial);
		this.setActivarcodigoRetencionInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RetencionInvenConstantesFunciones.ID)) {
				this.setActivaridRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDCOMPRA)) {
				this.setActivarid_compraRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDTIPORETENCION)) {
				this.setActivarid_tipo_retencionRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.BASEIMPONIBLE)) {
				this.setActivarbase_imponibleRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.RETENCION)) {
				this.setActivarretencionRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.NUMERORETENCION)) {
				this.setActivarnumero_retencionRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDANIO)) {
				this.setActivarid_anioRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDMES)) {
				this.setActivarid_mesRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.NUMEROSERIERETENCION)) {
				this.setActivarnumero_serie_retencionRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.CODIGO)) {
				this.setActivarcodigoRetencionInven(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRetencionInven(esInicial);
		this.setResaltarid_empresaRetencionInven(esInicial);
		this.setResaltarid_sucursalRetencionInven(esInicial);
		this.setResaltarid_ejercicioRetencionInven(esInicial);
		this.setResaltarid_periodoRetencionInven(esInicial);
		this.setResaltarid_compraRetencionInven(esInicial);
		this.setResaltarid_tipo_retencionRetencionInven(esInicial);
		this.setResaltarporcentajeRetencionInven(esInicial);
		this.setResaltarbase_imponibleRetencionInven(esInicial);
		this.setResaltarretencionRetencionInven(esInicial);
		this.setResaltarnumero_retencionRetencionInven(esInicial);
		this.setResaltarid_cuenta_contableRetencionInven(esInicial);
		this.setResaltarid_anioRetencionInven(esInicial);
		this.setResaltarid_mesRetencionInven(esInicial);
		this.setResaltarnumero_serie_retencionRetencionInven(esInicial);
		this.setResaltarcodigoRetencionInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RetencionInvenConstantesFunciones.ID)) {
				this.setResaltaridRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDCOMPRA)) {
				this.setResaltarid_compraRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDTIPORETENCION)) {
				this.setResaltarid_tipo_retencionRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.BASEIMPONIBLE)) {
				this.setResaltarbase_imponibleRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.RETENCION)) {
				this.setResaltarretencionRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.NUMERORETENCION)) {
				this.setResaltarnumero_retencionRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.IDMES)) {
				this.setResaltarid_mesRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.NUMEROSERIERETENCION)) {
				this.setResaltarnumero_serie_retencionRetencionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionInvenConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoRetencionInven(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCompraRetencionInven=true;

	public Boolean getMostrarFK_IdCompraRetencionInven() {
		return this.mostrarFK_IdCompraRetencionInven;
	}

	public void setMostrarFK_IdCompraRetencionInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCompraRetencionInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableRetencionInven=true;

	public Boolean getMostrarFK_IdCuentaContableRetencionInven() {
		return this.mostrarFK_IdCuentaContableRetencionInven;
	}

	public void setMostrarFK_IdCuentaContableRetencionInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableRetencionInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioRetencionInven=true;

	public Boolean getMostrarFK_IdEjercicioRetencionInven() {
		return this.mostrarFK_IdEjercicioRetencionInven;
	}

	public void setMostrarFK_IdEjercicioRetencionInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioRetencionInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaRetencionInven=true;

	public Boolean getMostrarFK_IdEmpresaRetencionInven() {
		return this.mostrarFK_IdEmpresaRetencionInven;
	}

	public void setMostrarFK_IdEmpresaRetencionInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRetencionInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoRetencionInven=true;

	public Boolean getMostrarFK_IdPeriodoRetencionInven() {
		return this.mostrarFK_IdPeriodoRetencionInven;
	}

	public void setMostrarFK_IdPeriodoRetencionInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoRetencionInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalRetencionInven=true;

	public Boolean getMostrarFK_IdSucursalRetencionInven() {
		return this.mostrarFK_IdSucursalRetencionInven;
	}

	public void setMostrarFK_IdSucursalRetencionInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalRetencionInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionRetencionInven=true;

	public Boolean getMostrarFK_IdTipoRetencionRetencionInven() {
		return this.mostrarFK_IdTipoRetencionRetencionInven;
	}

	public void setMostrarFK_IdTipoRetencionRetencionInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionRetencionInven= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCompraRetencionInven=true;

	public Boolean getActivarFK_IdCompraRetencionInven() {
		return this.activarFK_IdCompraRetencionInven;
	}

	public void setActivarFK_IdCompraRetencionInven(Boolean habilitarResaltar) {
		this.activarFK_IdCompraRetencionInven= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableRetencionInven=true;

	public Boolean getActivarFK_IdCuentaContableRetencionInven() {
		return this.activarFK_IdCuentaContableRetencionInven;
	}

	public void setActivarFK_IdCuentaContableRetencionInven(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableRetencionInven= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioRetencionInven=true;

	public Boolean getActivarFK_IdEjercicioRetencionInven() {
		return this.activarFK_IdEjercicioRetencionInven;
	}

	public void setActivarFK_IdEjercicioRetencionInven(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioRetencionInven= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaRetencionInven=true;

	public Boolean getActivarFK_IdEmpresaRetencionInven() {
		return this.activarFK_IdEmpresaRetencionInven;
	}

	public void setActivarFK_IdEmpresaRetencionInven(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRetencionInven= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoRetencionInven=true;

	public Boolean getActivarFK_IdPeriodoRetencionInven() {
		return this.activarFK_IdPeriodoRetencionInven;
	}

	public void setActivarFK_IdPeriodoRetencionInven(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoRetencionInven= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalRetencionInven=true;

	public Boolean getActivarFK_IdSucursalRetencionInven() {
		return this.activarFK_IdSucursalRetencionInven;
	}

	public void setActivarFK_IdSucursalRetencionInven(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalRetencionInven= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionRetencionInven=true;

	public Boolean getActivarFK_IdTipoRetencionRetencionInven() {
		return this.activarFK_IdTipoRetencionRetencionInven;
	}

	public void setActivarFK_IdTipoRetencionRetencionInven(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionRetencionInven= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCompraRetencionInven=null;

	public Border getResaltarFK_IdCompraRetencionInven() {
		return this.resaltarFK_IdCompraRetencionInven;
	}

	public void setResaltarFK_IdCompraRetencionInven(Border borderResaltar) {
		this.resaltarFK_IdCompraRetencionInven= borderResaltar;
	}

	public void setResaltarFK_IdCompraRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCompraRetencionInven= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableRetencionInven=null;

	public Border getResaltarFK_IdCuentaContableRetencionInven() {
		return this.resaltarFK_IdCuentaContableRetencionInven;
	}

	public void setResaltarFK_IdCuentaContableRetencionInven(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableRetencionInven= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableRetencionInven= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioRetencionInven=null;

	public Border getResaltarFK_IdEjercicioRetencionInven() {
		return this.resaltarFK_IdEjercicioRetencionInven;
	}

	public void setResaltarFK_IdEjercicioRetencionInven(Border borderResaltar) {
		this.resaltarFK_IdEjercicioRetencionInven= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioRetencionInven= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaRetencionInven=null;

	public Border getResaltarFK_IdEmpresaRetencionInven() {
		return this.resaltarFK_IdEmpresaRetencionInven;
	}

	public void setResaltarFK_IdEmpresaRetencionInven(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRetencionInven= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRetencionInven= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoRetencionInven=null;

	public Border getResaltarFK_IdPeriodoRetencionInven() {
		return this.resaltarFK_IdPeriodoRetencionInven;
	}

	public void setResaltarFK_IdPeriodoRetencionInven(Border borderResaltar) {
		this.resaltarFK_IdPeriodoRetencionInven= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoRetencionInven= borderResaltar;
	}

	public Border resaltarFK_IdSucursalRetencionInven=null;

	public Border getResaltarFK_IdSucursalRetencionInven() {
		return this.resaltarFK_IdSucursalRetencionInven;
	}

	public void setResaltarFK_IdSucursalRetencionInven(Border borderResaltar) {
		this.resaltarFK_IdSucursalRetencionInven= borderResaltar;
	}

	public void setResaltarFK_IdSucursalRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalRetencionInven= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionRetencionInven=null;

	public Border getResaltarFK_IdTipoRetencionRetencionInven() {
		return this.resaltarFK_IdTipoRetencionRetencionInven;
	}

	public void setResaltarFK_IdTipoRetencionRetencionInven(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionRetencionInven= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionRetencionInven(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionInvenBeanSwingJInternalFrame retencioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionRetencionInven= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
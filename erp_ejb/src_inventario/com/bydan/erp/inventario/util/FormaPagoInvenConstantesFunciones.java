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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.FormaPagoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.FormaPagoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.FormaPagoInvenParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FormaPagoInvenConstantesFunciones extends FormaPagoInvenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="FormaPagoInven";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FormaPagoInven"+FormaPagoInvenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FormaPagoInvenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FormaPagoInvenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FormaPagoInvenConstantesFunciones.SCHEMA+"_"+FormaPagoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FormaPagoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FormaPagoInvenConstantesFunciones.SCHEMA+"_"+FormaPagoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FormaPagoInvenConstantesFunciones.SCHEMA+"_"+FormaPagoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FormaPagoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FormaPagoInvenConstantesFunciones.SCHEMA+"_"+FormaPagoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormaPagoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormaPagoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormaPagoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormaPagoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormaPagoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormaPagoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FormaPagoInvenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FormaPagoInvenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FormaPagoInvenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FormaPagoInvenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Forma Pagoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Forma Pago";
	public static final String SCLASSWEBTITULO_LOWER="Forma Pago Inven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FormaPagoInven";
	public static final String OBJECTNAME="formapagoinven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="forma_pago_inven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select formapagoinven from "+FormaPagoInvenConstantesFunciones.SPERSISTENCENAME+" formapagoinven";
	public static String QUERYSELECTNATIVE="select "+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".id,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".version_row,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".id_empresa,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".id_sucursal,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".id_ejercicio,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".id_periodo,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".id_tipo_forma_pago,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".fecha_inicio,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".numero_dias,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".fecha_fin,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".porcentaje,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".valor,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".detalle,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".id_compra,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".id_anio,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".id_mes,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".id_cuenta_contable,"+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME+".fecha from "+FormaPagoInvenConstantesFunciones.SCHEMA+"."+FormaPagoInvenConstantesFunciones.TABLENAME;//+" as "+FormaPagoInvenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FormaPagoInvenConstantesFuncionesAdditional formapagoinvenConstantesFuncionesAdditional=null;
	
	public FormaPagoInvenConstantesFuncionesAdditional getFormaPagoInvenConstantesFuncionesAdditional() {
		return this.formapagoinvenConstantesFuncionesAdditional;
	}
	
	public void setFormaPagoInvenConstantesFuncionesAdditional(FormaPagoInvenConstantesFuncionesAdditional formapagoinvenConstantesFuncionesAdditional) {
		try {
			this.formapagoinvenConstantesFuncionesAdditional=formapagoinvenConstantesFuncionesAdditional;
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
    public static final String IDTIPOFORMAPAGO= "id_tipo_forma_pago";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String NUMERODIAS= "numero_dias";
    public static final String FECHAFIN= "fecha_fin";
    public static final String PORCENTAJE= "porcentaje";
    public static final String VALOR= "valor";
    public static final String DETALLE= "detalle";
    public static final String IDCOMPRA= "id_compra";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String FECHA= "fecha";
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
    	public static final String LABEL_IDTIPOFORMAPAGO= "Tipo Forma Pago";
		public static final String LABEL_IDTIPOFORMAPAGO_LOWER= "Tipo Forma Pago";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_NUMERODIAS= "Numero Dias";
		public static final String LABEL_NUMERODIAS_LOWER= "Numero Dias";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
    	public static final String LABEL_IDCOMPRA= "Compra";
		public static final String LABEL_IDCOMPRA_LOWER= "Compra";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getFormaPagoInvenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FormaPagoInvenConstantesFunciones.IDEMPRESA)) {sLabelColumna=FormaPagoInvenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FormaPagoInvenConstantesFunciones.IDSUCURSAL)) {sLabelColumna=FormaPagoInvenConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(FormaPagoInvenConstantesFunciones.IDEJERCICIO)) {sLabelColumna=FormaPagoInvenConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(FormaPagoInvenConstantesFunciones.IDPERIODO)) {sLabelColumna=FormaPagoInvenConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(FormaPagoInvenConstantesFunciones.IDTIPOFORMAPAGO)) {sLabelColumna=FormaPagoInvenConstantesFunciones.LABEL_IDTIPOFORMAPAGO;}
		if(sNombreColumna.equals(FormaPagoInvenConstantesFunciones.FECHAINICIO)) {sLabelColumna=FormaPagoInvenConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(FormaPagoInvenConstantesFunciones.NUMERODIAS)) {sLabelColumna=FormaPagoInvenConstantesFunciones.LABEL_NUMERODIAS;}
		if(sNombreColumna.equals(FormaPagoInvenConstantesFunciones.FECHAFIN)) {sLabelColumna=FormaPagoInvenConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(FormaPagoInvenConstantesFunciones.PORCENTAJE)) {sLabelColumna=FormaPagoInvenConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(FormaPagoInvenConstantesFunciones.VALOR)) {sLabelColumna=FormaPagoInvenConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(FormaPagoInvenConstantesFunciones.DETALLE)) {sLabelColumna=FormaPagoInvenConstantesFunciones.LABEL_DETALLE;}
		if(sNombreColumna.equals(FormaPagoInvenConstantesFunciones.IDCOMPRA)) {sLabelColumna=FormaPagoInvenConstantesFunciones.LABEL_IDCOMPRA;}
		if(sNombreColumna.equals(FormaPagoInvenConstantesFunciones.IDANIO)) {sLabelColumna=FormaPagoInvenConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(FormaPagoInvenConstantesFunciones.IDMES)) {sLabelColumna=FormaPagoInvenConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(FormaPagoInvenConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=FormaPagoInvenConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(FormaPagoInvenConstantesFunciones.FECHA)) {sLabelColumna=FormaPagoInvenConstantesFunciones.LABEL_FECHA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getFormaPagoInvenDescripcion(FormaPagoInven formapagoinven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(formapagoinven !=null/* && formapagoinven.getId()!=0*/) {
			if(formapagoinven.getId()!=null) {
				sDescripcion=formapagoinven.getId().toString();
			}//formapagoinvenformapagoinven.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFormaPagoInvenDescripcionDetallado(FormaPagoInven formapagoinven) {
		String sDescripcion="";
			
		sDescripcion+=FormaPagoInvenConstantesFunciones.ID+"=";
		sDescripcion+=formapagoinven.getId().toString()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=formapagoinven.getVersionRow().toString()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=formapagoinven.getid_empresa().toString()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=formapagoinven.getid_sucursal().toString()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=formapagoinven.getid_ejercicio().toString()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=formapagoinven.getid_periodo().toString()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.IDTIPOFORMAPAGO+"=";
		sDescripcion+=formapagoinven.getid_tipo_forma_pago().toString()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=formapagoinven.getfecha_inicio().toString()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.NUMERODIAS+"=";
		sDescripcion+=formapagoinven.getnumero_dias().toString()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=formapagoinven.getfecha_fin().toString()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=formapagoinven.getporcentaje().toString()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.VALOR+"=";
		sDescripcion+=formapagoinven.getvalor().toString()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.DETALLE+"=";
		sDescripcion+=formapagoinven.getdetalle()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.IDCOMPRA+"=";
		sDescripcion+=formapagoinven.getid_compra().toString()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.IDANIO+"=";
		sDescripcion+=formapagoinven.getid_anio().toString()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.IDMES+"=";
		sDescripcion+=formapagoinven.getid_mes().toString()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=formapagoinven.getid_cuenta_contable().toString()+",";
		sDescripcion+=FormaPagoInvenConstantesFunciones.FECHA+"=";
		sDescripcion+=formapagoinven.getfecha().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFormaPagoInvenDescripcion(FormaPagoInven formapagoinven,String sValor) throws Exception {			
		if(formapagoinven !=null) {
			//formapagoinvenformapagoinven.getId().toString();
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

	public static String getTipoFormaPagoDescripcion(TipoFormaPago tipoformapago) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoformapago!=null/*&&tipoformapago.getId()>0*/) {
			sDescripcion=TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(tipoformapago);
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

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
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
		} else if(sNombreIndice.equals("FK_IdTipoFormaPago")) {
			sNombreIndice="Tipo=  Por Tipo Forma Pago";
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

	public static String getDetalleIndiceFK_IdTipoFormaPago(Long id_tipo_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De Tipo Forma Pago="+id_tipo_forma_pago.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFormaPagoInven(FormaPagoInven formapagoinven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		formapagoinven.setdetalle(formapagoinven.getdetalle().trim());
	}
	
	public static void quitarEspaciosFormaPagoInvens(List<FormaPagoInven> formapagoinvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FormaPagoInven formapagoinven: formapagoinvens) {
			formapagoinven.setdetalle(formapagoinven.getdetalle().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormaPagoInven(FormaPagoInven formapagoinven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && formapagoinven.getConCambioAuxiliar()) {
			formapagoinven.setIsDeleted(formapagoinven.getIsDeletedAuxiliar());	
			formapagoinven.setIsNew(formapagoinven.getIsNewAuxiliar());	
			formapagoinven.setIsChanged(formapagoinven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			formapagoinven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			formapagoinven.setIsDeletedAuxiliar(false);	
			formapagoinven.setIsNewAuxiliar(false);	
			formapagoinven.setIsChangedAuxiliar(false);
			
			formapagoinven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormaPagoInvens(List<FormaPagoInven> formapagoinvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FormaPagoInven formapagoinven : formapagoinvens) {
			if(conAsignarBase && formapagoinven.getConCambioAuxiliar()) {
				formapagoinven.setIsDeleted(formapagoinven.getIsDeletedAuxiliar());	
				formapagoinven.setIsNew(formapagoinven.getIsNewAuxiliar());	
				formapagoinven.setIsChanged(formapagoinven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				formapagoinven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				formapagoinven.setIsDeletedAuxiliar(false);	
				formapagoinven.setIsNewAuxiliar(false);	
				formapagoinven.setIsChangedAuxiliar(false);
				
				formapagoinven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFormaPagoInven(FormaPagoInven formapagoinven,Boolean conEnteros) throws Exception  {
		formapagoinven.setporcentaje(0.0);
		formapagoinven.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			formapagoinven.setnumero_dias(0);
		}
	}		
	
	public static void InicializarValoresFormaPagoInvens(List<FormaPagoInven> formapagoinvens,Boolean conEnteros) throws Exception  {
		
		for(FormaPagoInven formapagoinven: formapagoinvens) {
			formapagoinven.setporcentaje(0.0);
			formapagoinven.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				formapagoinven.setnumero_dias(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaFormaPagoInven(List<FormaPagoInven> formapagoinvens,FormaPagoInven formapagoinvenAux) throws Exception  {
		FormaPagoInvenConstantesFunciones.InicializarValoresFormaPagoInven(formapagoinvenAux,true);
		
		for(FormaPagoInven formapagoinven: formapagoinvens) {
			if(formapagoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			formapagoinvenAux.setnumero_dias(formapagoinvenAux.getnumero_dias()+formapagoinven.getnumero_dias());			
			formapagoinvenAux.setporcentaje(formapagoinvenAux.getporcentaje()+formapagoinven.getporcentaje());			
			formapagoinvenAux.setvalor(formapagoinvenAux.getvalor()+formapagoinven.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFormaPagoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FormaPagoInvenConstantesFunciones.getArrayColumnasGlobalesFormaPagoInven(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFormaPagoInven(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormaPagoInvenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormaPagoInvenConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormaPagoInvenConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormaPagoInvenConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormaPagoInvenConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormaPagoInvenConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormaPagoInvenConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormaPagoInvenConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFormaPagoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FormaPagoInven> formapagoinvens,FormaPagoInven formapagoinven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FormaPagoInven formapagoinvenAux: formapagoinvens) {
			if(formapagoinvenAux!=null && formapagoinven!=null) {
				if((formapagoinvenAux.getId()==null && formapagoinven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(formapagoinvenAux.getId()!=null && formapagoinven.getId()!=null){
					if(formapagoinvenAux.getId().equals(formapagoinven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFormaPagoInven(List<FormaPagoInven> formapagoinvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double valorTotal=0.0;
	
		for(FormaPagoInven formapagoinven: formapagoinvens) {			
			if(formapagoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=formapagoinven.getporcentaje();
			valorTotal+=formapagoinven.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormaPagoInvenConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormaPagoInvenConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFormaPagoInven() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_ID, FormaPagoInvenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_VERSIONROW, FormaPagoInvenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_IDEMPRESA, FormaPagoInvenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_IDSUCURSAL, FormaPagoInvenConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_IDEJERCICIO, FormaPagoInvenConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_IDPERIODO, FormaPagoInvenConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_IDTIPOFORMAPAGO, FormaPagoInvenConstantesFunciones.IDTIPOFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_FECHAINICIO, FormaPagoInvenConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_NUMERODIAS, FormaPagoInvenConstantesFunciones.NUMERODIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_FECHAFIN, FormaPagoInvenConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_PORCENTAJE, FormaPagoInvenConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_VALOR, FormaPagoInvenConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_DETALLE, FormaPagoInvenConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_IDCOMPRA, FormaPagoInvenConstantesFunciones.IDCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_IDANIO, FormaPagoInvenConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_IDMES, FormaPagoInvenConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_IDCUENTACONTABLE, FormaPagoInvenConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoInvenConstantesFunciones.LABEL_FECHA, FormaPagoInvenConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFormaPagoInven() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.IDTIPOFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.NUMERODIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.IDCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoInvenConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormaPagoInven() throws Exception  {
		return FormaPagoInvenConstantesFunciones.getTiposSeleccionarFormaPagoInven(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormaPagoInven(Boolean conFk) throws Exception  {
		return FormaPagoInvenConstantesFunciones.getTiposSeleccionarFormaPagoInven(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormaPagoInven(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoInvenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoInvenConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoInvenConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoInvenConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoInvenConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
			reporte.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_IDTIPOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoInvenConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoInvenConstantesFunciones.LABEL_NUMERODIAS);
			reporte.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_NUMERODIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoInvenConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoInvenConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoInvenConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoInvenConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoInvenConstantesFunciones.LABEL_IDCOMPRA);
			reporte.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_IDCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoInvenConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoInvenConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoInvenConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoInvenConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(FormaPagoInvenConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFormaPagoInven(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFormaPagoInven(FormaPagoInven formapagoinvenAux) throws Exception {
		
			formapagoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formapagoinvenAux.getEmpresa()));
			formapagoinvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(formapagoinvenAux.getSucursal()));
			formapagoinvenAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(formapagoinvenAux.getEjercicio()));
			formapagoinvenAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(formapagoinvenAux.getPeriodo()));
			formapagoinvenAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(formapagoinvenAux.getTipoFormaPago()));
			formapagoinvenAux.setcompra_descripcion(CompraConstantesFunciones.getCompraDescripcion(formapagoinvenAux.getCompra()));
			formapagoinvenAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(formapagoinvenAux.getAnio()));
			formapagoinvenAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(formapagoinvenAux.getMes()));
			formapagoinvenAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(formapagoinvenAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFormaPagoInven(List<FormaPagoInven> formapagoinvensTemp) throws Exception {
		for(FormaPagoInven formapagoinvenAux:formapagoinvensTemp) {
			
			formapagoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formapagoinvenAux.getEmpresa()));
			formapagoinvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(formapagoinvenAux.getSucursal()));
			formapagoinvenAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(formapagoinvenAux.getEjercicio()));
			formapagoinvenAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(formapagoinvenAux.getPeriodo()));
			formapagoinvenAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(formapagoinvenAux.getTipoFormaPago()));
			formapagoinvenAux.setcompra_descripcion(CompraConstantesFunciones.getCompraDescripcion(formapagoinvenAux.getCompra()));
			formapagoinvenAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(formapagoinvenAux.getAnio()));
			formapagoinvenAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(formapagoinvenAux.getMes()));
			formapagoinvenAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(formapagoinvenAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFormaPagoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(TipoFormaPago.class));
				classes.add(new Classe(Compra.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
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
					if(clas.clas.equals(TipoFormaPago.class)) {
						classes.add(new Classe(TipoFormaPago.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Compra.class)) {
						classes.add(new Classe(Compra.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFormaPagoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
					}

					if(Compra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Compra.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
					}

					if(Compra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Compra.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormaPagoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormaPagoInvenConstantesFunciones.getClassesRelationshipsOfFormaPagoInven(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormaPagoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormaPagoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormaPagoInvenConstantesFunciones.getClassesRelationshipsFromStringsOfFormaPagoInven(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormaPagoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(FormaPagoInven formapagoinven,List<FormaPagoInven> formapagoinvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FormaPagoInven formapagoinvenEncontrado=null;
			
			for(FormaPagoInven formapagoinvenLocal:formapagoinvens) {
				if(formapagoinvenLocal.getId().equals(formapagoinven.getId())) {
					formapagoinvenEncontrado=formapagoinvenLocal;
					
					formapagoinvenLocal.setIsChanged(formapagoinven.getIsChanged());
					formapagoinvenLocal.setIsNew(formapagoinven.getIsNew());
					formapagoinvenLocal.setIsDeleted(formapagoinven.getIsDeleted());
					
					formapagoinvenLocal.setGeneralEntityOriginal(formapagoinven.getGeneralEntityOriginal());
					
					formapagoinvenLocal.setId(formapagoinven.getId());	
					formapagoinvenLocal.setVersionRow(formapagoinven.getVersionRow());	
					formapagoinvenLocal.setid_empresa(formapagoinven.getid_empresa());	
					formapagoinvenLocal.setid_sucursal(formapagoinven.getid_sucursal());	
					formapagoinvenLocal.setid_ejercicio(formapagoinven.getid_ejercicio());	
					formapagoinvenLocal.setid_periodo(formapagoinven.getid_periodo());	
					formapagoinvenLocal.setid_tipo_forma_pago(formapagoinven.getid_tipo_forma_pago());	
					formapagoinvenLocal.setfecha_inicio(formapagoinven.getfecha_inicio());	
					formapagoinvenLocal.setnumero_dias(formapagoinven.getnumero_dias());	
					formapagoinvenLocal.setfecha_fin(formapagoinven.getfecha_fin());	
					formapagoinvenLocal.setporcentaje(formapagoinven.getporcentaje());	
					formapagoinvenLocal.setvalor(formapagoinven.getvalor());	
					formapagoinvenLocal.setdetalle(formapagoinven.getdetalle());	
					formapagoinvenLocal.setid_compra(formapagoinven.getid_compra());	
					formapagoinvenLocal.setid_anio(formapagoinven.getid_anio());	
					formapagoinvenLocal.setid_mes(formapagoinven.getid_mes());	
					formapagoinvenLocal.setid_cuenta_contable(formapagoinven.getid_cuenta_contable());	
					formapagoinvenLocal.setfecha(formapagoinven.getfecha());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!formapagoinven.getIsDeleted()) {
				if(!existe) {
					formapagoinvens.add(formapagoinven);
				}
			} else {
				if(formapagoinvenEncontrado!=null && permiteQuitar)  {
					formapagoinvens.remove(formapagoinvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FormaPagoInven formapagoinven,List<FormaPagoInven> formapagoinvens) throws Exception {
		try	{			
			for(FormaPagoInven formapagoinvenLocal:formapagoinvens) {
				if(formapagoinvenLocal.getId().equals(formapagoinven.getId())) {
					formapagoinvenLocal.setIsSelected(formapagoinven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFormaPagoInven(List<FormaPagoInven> formapagoinvensAux) throws Exception {
		//this.formapagoinvensAux=formapagoinvensAux;
		
		for(FormaPagoInven formapagoinvenAux:formapagoinvensAux) {
			if(formapagoinvenAux.getIsChanged()) {
				formapagoinvenAux.setIsChanged(false);
			}		
			
			if(formapagoinvenAux.getIsNew()) {
				formapagoinvenAux.setIsNew(false);
			}	
			
			if(formapagoinvenAux.getIsDeleted()) {
				formapagoinvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFormaPagoInven(FormaPagoInven formapagoinvenAux) throws Exception {
		//this.formapagoinvenAux=formapagoinvenAux;
		
			if(formapagoinvenAux.getIsChanged()) {
				formapagoinvenAux.setIsChanged(false);
			}		
			
			if(formapagoinvenAux.getIsNew()) {
				formapagoinvenAux.setIsNew(false);
			}	
			
			if(formapagoinvenAux.getIsDeleted()) {
				formapagoinvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FormaPagoInven formapagoinvenAsignar,FormaPagoInven formapagoinven) throws Exception {
		formapagoinvenAsignar.setId(formapagoinven.getId());	
		formapagoinvenAsignar.setVersionRow(formapagoinven.getVersionRow());	
		formapagoinvenAsignar.setid_empresa(formapagoinven.getid_empresa());
		formapagoinvenAsignar.setempresa_descripcion(formapagoinven.getempresa_descripcion());	
		formapagoinvenAsignar.setid_sucursal(formapagoinven.getid_sucursal());
		formapagoinvenAsignar.setsucursal_descripcion(formapagoinven.getsucursal_descripcion());	
		formapagoinvenAsignar.setid_ejercicio(formapagoinven.getid_ejercicio());
		formapagoinvenAsignar.setejercicio_descripcion(formapagoinven.getejercicio_descripcion());	
		formapagoinvenAsignar.setid_periodo(formapagoinven.getid_periodo());
		formapagoinvenAsignar.setperiodo_descripcion(formapagoinven.getperiodo_descripcion());	
		formapagoinvenAsignar.setid_tipo_forma_pago(formapagoinven.getid_tipo_forma_pago());
		formapagoinvenAsignar.settipoformapago_descripcion(formapagoinven.gettipoformapago_descripcion());	
		formapagoinvenAsignar.setfecha_inicio(formapagoinven.getfecha_inicio());	
		formapagoinvenAsignar.setnumero_dias(formapagoinven.getnumero_dias());	
		formapagoinvenAsignar.setfecha_fin(formapagoinven.getfecha_fin());	
		formapagoinvenAsignar.setporcentaje(formapagoinven.getporcentaje());	
		formapagoinvenAsignar.setvalor(formapagoinven.getvalor());	
		formapagoinvenAsignar.setdetalle(formapagoinven.getdetalle());	
		formapagoinvenAsignar.setid_compra(formapagoinven.getid_compra());
		formapagoinvenAsignar.setcompra_descripcion(formapagoinven.getcompra_descripcion());	
		formapagoinvenAsignar.setid_anio(formapagoinven.getid_anio());
		formapagoinvenAsignar.setanio_descripcion(formapagoinven.getanio_descripcion());	
		formapagoinvenAsignar.setid_mes(formapagoinven.getid_mes());
		formapagoinvenAsignar.setmes_descripcion(formapagoinven.getmes_descripcion());	
		formapagoinvenAsignar.setid_cuenta_contable(formapagoinven.getid_cuenta_contable());
		formapagoinvenAsignar.setcuentacontable_descripcion(formapagoinven.getcuentacontable_descripcion());	
		formapagoinvenAsignar.setfecha(formapagoinven.getfecha());	
	}
	
	public static void inicializarFormaPagoInven(FormaPagoInven formapagoinven) throws Exception {
		try {
				formapagoinven.setId(0L);	
					
				formapagoinven.setid_empresa(-1L);	
				formapagoinven.setid_sucursal(-1L);	
				formapagoinven.setid_ejercicio(-1L);	
				formapagoinven.setid_periodo(-1L);	
				formapagoinven.setid_tipo_forma_pago(-1L);	
				formapagoinven.setfecha_inicio(new Date());	
				formapagoinven.setnumero_dias(0);	
				formapagoinven.setfecha_fin(new Date());	
				formapagoinven.setporcentaje(0.0);	
				formapagoinven.setvalor(0.0);	
				formapagoinven.setdetalle("");	
				formapagoinven.setid_compra(-1L);	
				formapagoinven.setid_anio(null);	
				formapagoinven.setid_mes(null);	
				formapagoinven.setid_cuenta_contable(null);	
				formapagoinven.setfecha(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFormaPagoInven(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoInvenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoInvenConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoInvenConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoInvenConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoInvenConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoInvenConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoInvenConstantesFunciones.LABEL_NUMERODIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoInvenConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoInvenConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoInvenConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoInvenConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoInvenConstantesFunciones.LABEL_IDCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoInvenConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoInvenConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoInvenConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoInvenConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFormaPagoInven(String sTipo,Row row,Workbook workbook,FormaPagoInven formapagoinven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagoinven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagoinven.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagoinven.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagoinven.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagoinven.gettipoformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagoinven.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagoinven.getnumero_dias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagoinven.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagoinven.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagoinven.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagoinven.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagoinven.getcompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagoinven.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagoinven.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagoinven.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagoinven.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFormaPagoInven=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFormaPagoInven() {
		return this.sFinalQueryFormaPagoInven;
	}
	
	public void setsFinalQueryFormaPagoInven(String sFinalQueryFormaPagoInven) {
		this.sFinalQueryFormaPagoInven= sFinalQueryFormaPagoInven;
	}
	
	public Border resaltarSeleccionarFormaPagoInven=null;
	
	public Border setResaltarSeleccionarFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltarSeleccionarFormaPagoInven= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFormaPagoInven() {
		return this.resaltarSeleccionarFormaPagoInven;
	}
	
	public void setResaltarSeleccionarFormaPagoInven(Border borderResaltarSeleccionarFormaPagoInven) {
		this.resaltarSeleccionarFormaPagoInven= borderResaltarSeleccionarFormaPagoInven;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFormaPagoInven=null;
	public Boolean mostraridFormaPagoInven=true;
	public Boolean activaridFormaPagoInven=true;

	public Border resaltarid_empresaFormaPagoInven=null;
	public Boolean mostrarid_empresaFormaPagoInven=true;
	public Boolean activarid_empresaFormaPagoInven=true;
	public Boolean cargarid_empresaFormaPagoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFormaPagoInven=false;//ConEventDepend=true

	public Border resaltarid_sucursalFormaPagoInven=null;
	public Boolean mostrarid_sucursalFormaPagoInven=true;
	public Boolean activarid_sucursalFormaPagoInven=true;
	public Boolean cargarid_sucursalFormaPagoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalFormaPagoInven=false;//ConEventDepend=true

	public Border resaltarid_ejercicioFormaPagoInven=null;
	public Boolean mostrarid_ejercicioFormaPagoInven=true;
	public Boolean activarid_ejercicioFormaPagoInven=true;
	public Boolean cargarid_ejercicioFormaPagoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioFormaPagoInven=false;//ConEventDepend=true

	public Border resaltarid_periodoFormaPagoInven=null;
	public Boolean mostrarid_periodoFormaPagoInven=true;
	public Boolean activarid_periodoFormaPagoInven=true;
	public Boolean cargarid_periodoFormaPagoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoFormaPagoInven=false;//ConEventDepend=true

	public Border resaltarid_tipo_forma_pagoFormaPagoInven=null;
	public Boolean mostrarid_tipo_forma_pagoFormaPagoInven=true;
	public Boolean activarid_tipo_forma_pagoFormaPagoInven=true;
	public Boolean cargarid_tipo_forma_pagoFormaPagoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_forma_pagoFormaPagoInven=false;//ConEventDepend=true

	public Border resaltarfecha_inicioFormaPagoInven=null;
	public Boolean mostrarfecha_inicioFormaPagoInven=true;
	public Boolean activarfecha_inicioFormaPagoInven=true;

	public Border resaltarnumero_diasFormaPagoInven=null;
	public Boolean mostrarnumero_diasFormaPagoInven=true;
	public Boolean activarnumero_diasFormaPagoInven=true;

	public Border resaltarfecha_finFormaPagoInven=null;
	public Boolean mostrarfecha_finFormaPagoInven=true;
	public Boolean activarfecha_finFormaPagoInven=true;

	public Border resaltarporcentajeFormaPagoInven=null;
	public Boolean mostrarporcentajeFormaPagoInven=true;
	public Boolean activarporcentajeFormaPagoInven=true;

	public Border resaltarvalorFormaPagoInven=null;
	public Boolean mostrarvalorFormaPagoInven=true;
	public Boolean activarvalorFormaPagoInven=true;

	public Border resaltardetalleFormaPagoInven=null;
	public Boolean mostrardetalleFormaPagoInven=true;
	public Boolean activardetalleFormaPagoInven=true;

	public Border resaltarid_compraFormaPagoInven=null;
	public Boolean mostrarid_compraFormaPagoInven=true;
	public Boolean activarid_compraFormaPagoInven=false;
	public Boolean cargarid_compraFormaPagoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_compraFormaPagoInven=false;//ConEventDepend=true

	public Border resaltarid_anioFormaPagoInven=null;
	public Boolean mostrarid_anioFormaPagoInven=true;
	public Boolean activarid_anioFormaPagoInven=false;
	public Boolean cargarid_anioFormaPagoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioFormaPagoInven=false;//ConEventDepend=true

	public Border resaltarid_mesFormaPagoInven=null;
	public Boolean mostrarid_mesFormaPagoInven=true;
	public Boolean activarid_mesFormaPagoInven=false;
	public Boolean cargarid_mesFormaPagoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesFormaPagoInven=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableFormaPagoInven=null;
	public Boolean mostrarid_cuenta_contableFormaPagoInven=true;
	public Boolean activarid_cuenta_contableFormaPagoInven=false;
	public Boolean cargarid_cuenta_contableFormaPagoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableFormaPagoInven=false;//ConEventDepend=true

	public Border resaltarfechaFormaPagoInven=null;
	public Boolean mostrarfechaFormaPagoInven=true;
	public Boolean activarfechaFormaPagoInven=false;

	
	

	public Border setResaltaridFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltaridFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFormaPagoInven() {
		return this.resaltaridFormaPagoInven;
	}

	public void setResaltaridFormaPagoInven(Border borderResaltar) {
		this.resaltaridFormaPagoInven= borderResaltar;
	}

	public Boolean getMostraridFormaPagoInven() {
		return this.mostraridFormaPagoInven;
	}

	public void setMostraridFormaPagoInven(Boolean mostraridFormaPagoInven) {
		this.mostraridFormaPagoInven= mostraridFormaPagoInven;
	}

	public Boolean getActivaridFormaPagoInven() {
		return this.activaridFormaPagoInven;
	}

	public void setActivaridFormaPagoInven(Boolean activaridFormaPagoInven) {
		this.activaridFormaPagoInven= activaridFormaPagoInven;
	}

	public Border setResaltarid_empresaFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltarid_empresaFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFormaPagoInven() {
		return this.resaltarid_empresaFormaPagoInven;
	}

	public void setResaltarid_empresaFormaPagoInven(Border borderResaltar) {
		this.resaltarid_empresaFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarid_empresaFormaPagoInven() {
		return this.mostrarid_empresaFormaPagoInven;
	}

	public void setMostrarid_empresaFormaPagoInven(Boolean mostrarid_empresaFormaPagoInven) {
		this.mostrarid_empresaFormaPagoInven= mostrarid_empresaFormaPagoInven;
	}

	public Boolean getActivarid_empresaFormaPagoInven() {
		return this.activarid_empresaFormaPagoInven;
	}

	public void setActivarid_empresaFormaPagoInven(Boolean activarid_empresaFormaPagoInven) {
		this.activarid_empresaFormaPagoInven= activarid_empresaFormaPagoInven;
	}

	public Boolean getCargarid_empresaFormaPagoInven() {
		return this.cargarid_empresaFormaPagoInven;
	}

	public void setCargarid_empresaFormaPagoInven(Boolean cargarid_empresaFormaPagoInven) {
		this.cargarid_empresaFormaPagoInven= cargarid_empresaFormaPagoInven;
	}

	public Border setResaltarid_sucursalFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltarid_sucursalFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalFormaPagoInven() {
		return this.resaltarid_sucursalFormaPagoInven;
	}

	public void setResaltarid_sucursalFormaPagoInven(Border borderResaltar) {
		this.resaltarid_sucursalFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarid_sucursalFormaPagoInven() {
		return this.mostrarid_sucursalFormaPagoInven;
	}

	public void setMostrarid_sucursalFormaPagoInven(Boolean mostrarid_sucursalFormaPagoInven) {
		this.mostrarid_sucursalFormaPagoInven= mostrarid_sucursalFormaPagoInven;
	}

	public Boolean getActivarid_sucursalFormaPagoInven() {
		return this.activarid_sucursalFormaPagoInven;
	}

	public void setActivarid_sucursalFormaPagoInven(Boolean activarid_sucursalFormaPagoInven) {
		this.activarid_sucursalFormaPagoInven= activarid_sucursalFormaPagoInven;
	}

	public Boolean getCargarid_sucursalFormaPagoInven() {
		return this.cargarid_sucursalFormaPagoInven;
	}

	public void setCargarid_sucursalFormaPagoInven(Boolean cargarid_sucursalFormaPagoInven) {
		this.cargarid_sucursalFormaPagoInven= cargarid_sucursalFormaPagoInven;
	}

	public Border setResaltarid_ejercicioFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltarid_ejercicioFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioFormaPagoInven() {
		return this.resaltarid_ejercicioFormaPagoInven;
	}

	public void setResaltarid_ejercicioFormaPagoInven(Border borderResaltar) {
		this.resaltarid_ejercicioFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioFormaPagoInven() {
		return this.mostrarid_ejercicioFormaPagoInven;
	}

	public void setMostrarid_ejercicioFormaPagoInven(Boolean mostrarid_ejercicioFormaPagoInven) {
		this.mostrarid_ejercicioFormaPagoInven= mostrarid_ejercicioFormaPagoInven;
	}

	public Boolean getActivarid_ejercicioFormaPagoInven() {
		return this.activarid_ejercicioFormaPagoInven;
	}

	public void setActivarid_ejercicioFormaPagoInven(Boolean activarid_ejercicioFormaPagoInven) {
		this.activarid_ejercicioFormaPagoInven= activarid_ejercicioFormaPagoInven;
	}

	public Boolean getCargarid_ejercicioFormaPagoInven() {
		return this.cargarid_ejercicioFormaPagoInven;
	}

	public void setCargarid_ejercicioFormaPagoInven(Boolean cargarid_ejercicioFormaPagoInven) {
		this.cargarid_ejercicioFormaPagoInven= cargarid_ejercicioFormaPagoInven;
	}

	public Border setResaltarid_periodoFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltarid_periodoFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoFormaPagoInven() {
		return this.resaltarid_periodoFormaPagoInven;
	}

	public void setResaltarid_periodoFormaPagoInven(Border borderResaltar) {
		this.resaltarid_periodoFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarid_periodoFormaPagoInven() {
		return this.mostrarid_periodoFormaPagoInven;
	}

	public void setMostrarid_periodoFormaPagoInven(Boolean mostrarid_periodoFormaPagoInven) {
		this.mostrarid_periodoFormaPagoInven= mostrarid_periodoFormaPagoInven;
	}

	public Boolean getActivarid_periodoFormaPagoInven() {
		return this.activarid_periodoFormaPagoInven;
	}

	public void setActivarid_periodoFormaPagoInven(Boolean activarid_periodoFormaPagoInven) {
		this.activarid_periodoFormaPagoInven= activarid_periodoFormaPagoInven;
	}

	public Boolean getCargarid_periodoFormaPagoInven() {
		return this.cargarid_periodoFormaPagoInven;
	}

	public void setCargarid_periodoFormaPagoInven(Boolean cargarid_periodoFormaPagoInven) {
		this.cargarid_periodoFormaPagoInven= cargarid_periodoFormaPagoInven;
	}

	public Border setResaltarid_tipo_forma_pagoFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_forma_pagoFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_forma_pagoFormaPagoInven() {
		return this.resaltarid_tipo_forma_pagoFormaPagoInven;
	}

	public void setResaltarid_tipo_forma_pagoFormaPagoInven(Border borderResaltar) {
		this.resaltarid_tipo_forma_pagoFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarid_tipo_forma_pagoFormaPagoInven() {
		return this.mostrarid_tipo_forma_pagoFormaPagoInven;
	}

	public void setMostrarid_tipo_forma_pagoFormaPagoInven(Boolean mostrarid_tipo_forma_pagoFormaPagoInven) {
		this.mostrarid_tipo_forma_pagoFormaPagoInven= mostrarid_tipo_forma_pagoFormaPagoInven;
	}

	public Boolean getActivarid_tipo_forma_pagoFormaPagoInven() {
		return this.activarid_tipo_forma_pagoFormaPagoInven;
	}

	public void setActivarid_tipo_forma_pagoFormaPagoInven(Boolean activarid_tipo_forma_pagoFormaPagoInven) {
		this.activarid_tipo_forma_pagoFormaPagoInven= activarid_tipo_forma_pagoFormaPagoInven;
	}

	public Boolean getCargarid_tipo_forma_pagoFormaPagoInven() {
		return this.cargarid_tipo_forma_pagoFormaPagoInven;
	}

	public void setCargarid_tipo_forma_pagoFormaPagoInven(Boolean cargarid_tipo_forma_pagoFormaPagoInven) {
		this.cargarid_tipo_forma_pagoFormaPagoInven= cargarid_tipo_forma_pagoFormaPagoInven;
	}

	public Border setResaltarfecha_inicioFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltarfecha_inicioFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioFormaPagoInven() {
		return this.resaltarfecha_inicioFormaPagoInven;
	}

	public void setResaltarfecha_inicioFormaPagoInven(Border borderResaltar) {
		this.resaltarfecha_inicioFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioFormaPagoInven() {
		return this.mostrarfecha_inicioFormaPagoInven;
	}

	public void setMostrarfecha_inicioFormaPagoInven(Boolean mostrarfecha_inicioFormaPagoInven) {
		this.mostrarfecha_inicioFormaPagoInven= mostrarfecha_inicioFormaPagoInven;
	}

	public Boolean getActivarfecha_inicioFormaPagoInven() {
		return this.activarfecha_inicioFormaPagoInven;
	}

	public void setActivarfecha_inicioFormaPagoInven(Boolean activarfecha_inicioFormaPagoInven) {
		this.activarfecha_inicioFormaPagoInven= activarfecha_inicioFormaPagoInven;
	}

	public Border setResaltarnumero_diasFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltarnumero_diasFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_diasFormaPagoInven() {
		return this.resaltarnumero_diasFormaPagoInven;
	}

	public void setResaltarnumero_diasFormaPagoInven(Border borderResaltar) {
		this.resaltarnumero_diasFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarnumero_diasFormaPagoInven() {
		return this.mostrarnumero_diasFormaPagoInven;
	}

	public void setMostrarnumero_diasFormaPagoInven(Boolean mostrarnumero_diasFormaPagoInven) {
		this.mostrarnumero_diasFormaPagoInven= mostrarnumero_diasFormaPagoInven;
	}

	public Boolean getActivarnumero_diasFormaPagoInven() {
		return this.activarnumero_diasFormaPagoInven;
	}

	public void setActivarnumero_diasFormaPagoInven(Boolean activarnumero_diasFormaPagoInven) {
		this.activarnumero_diasFormaPagoInven= activarnumero_diasFormaPagoInven;
	}

	public Border setResaltarfecha_finFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltarfecha_finFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finFormaPagoInven() {
		return this.resaltarfecha_finFormaPagoInven;
	}

	public void setResaltarfecha_finFormaPagoInven(Border borderResaltar) {
		this.resaltarfecha_finFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarfecha_finFormaPagoInven() {
		return this.mostrarfecha_finFormaPagoInven;
	}

	public void setMostrarfecha_finFormaPagoInven(Boolean mostrarfecha_finFormaPagoInven) {
		this.mostrarfecha_finFormaPagoInven= mostrarfecha_finFormaPagoInven;
	}

	public Boolean getActivarfecha_finFormaPagoInven() {
		return this.activarfecha_finFormaPagoInven;
	}

	public void setActivarfecha_finFormaPagoInven(Boolean activarfecha_finFormaPagoInven) {
		this.activarfecha_finFormaPagoInven= activarfecha_finFormaPagoInven;
	}

	public Border setResaltarporcentajeFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltarporcentajeFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeFormaPagoInven() {
		return this.resaltarporcentajeFormaPagoInven;
	}

	public void setResaltarporcentajeFormaPagoInven(Border borderResaltar) {
		this.resaltarporcentajeFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarporcentajeFormaPagoInven() {
		return this.mostrarporcentajeFormaPagoInven;
	}

	public void setMostrarporcentajeFormaPagoInven(Boolean mostrarporcentajeFormaPagoInven) {
		this.mostrarporcentajeFormaPagoInven= mostrarporcentajeFormaPagoInven;
	}

	public Boolean getActivarporcentajeFormaPagoInven() {
		return this.activarporcentajeFormaPagoInven;
	}

	public void setActivarporcentajeFormaPagoInven(Boolean activarporcentajeFormaPagoInven) {
		this.activarporcentajeFormaPagoInven= activarporcentajeFormaPagoInven;
	}

	public Border setResaltarvalorFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltarvalorFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorFormaPagoInven() {
		return this.resaltarvalorFormaPagoInven;
	}

	public void setResaltarvalorFormaPagoInven(Border borderResaltar) {
		this.resaltarvalorFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarvalorFormaPagoInven() {
		return this.mostrarvalorFormaPagoInven;
	}

	public void setMostrarvalorFormaPagoInven(Boolean mostrarvalorFormaPagoInven) {
		this.mostrarvalorFormaPagoInven= mostrarvalorFormaPagoInven;
	}

	public Boolean getActivarvalorFormaPagoInven() {
		return this.activarvalorFormaPagoInven;
	}

	public void setActivarvalorFormaPagoInven(Boolean activarvalorFormaPagoInven) {
		this.activarvalorFormaPagoInven= activarvalorFormaPagoInven;
	}

	public Border setResaltardetalleFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltardetalleFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleFormaPagoInven() {
		return this.resaltardetalleFormaPagoInven;
	}

	public void setResaltardetalleFormaPagoInven(Border borderResaltar) {
		this.resaltardetalleFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrardetalleFormaPagoInven() {
		return this.mostrardetalleFormaPagoInven;
	}

	public void setMostrardetalleFormaPagoInven(Boolean mostrardetalleFormaPagoInven) {
		this.mostrardetalleFormaPagoInven= mostrardetalleFormaPagoInven;
	}

	public Boolean getActivardetalleFormaPagoInven() {
		return this.activardetalleFormaPagoInven;
	}

	public void setActivardetalleFormaPagoInven(Boolean activardetalleFormaPagoInven) {
		this.activardetalleFormaPagoInven= activardetalleFormaPagoInven;
	}

	public Border setResaltarid_compraFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltarid_compraFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_compraFormaPagoInven() {
		return this.resaltarid_compraFormaPagoInven;
	}

	public void setResaltarid_compraFormaPagoInven(Border borderResaltar) {
		this.resaltarid_compraFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarid_compraFormaPagoInven() {
		return this.mostrarid_compraFormaPagoInven;
	}

	public void setMostrarid_compraFormaPagoInven(Boolean mostrarid_compraFormaPagoInven) {
		this.mostrarid_compraFormaPagoInven= mostrarid_compraFormaPagoInven;
	}

	public Boolean getActivarid_compraFormaPagoInven() {
		return this.activarid_compraFormaPagoInven;
	}

	public void setActivarid_compraFormaPagoInven(Boolean activarid_compraFormaPagoInven) {
		this.activarid_compraFormaPagoInven= activarid_compraFormaPagoInven;
	}

	public Boolean getCargarid_compraFormaPagoInven() {
		return this.cargarid_compraFormaPagoInven;
	}

	public void setCargarid_compraFormaPagoInven(Boolean cargarid_compraFormaPagoInven) {
		this.cargarid_compraFormaPagoInven= cargarid_compraFormaPagoInven;
	}

	public Border setResaltarid_anioFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltarid_anioFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioFormaPagoInven() {
		return this.resaltarid_anioFormaPagoInven;
	}

	public void setResaltarid_anioFormaPagoInven(Border borderResaltar) {
		this.resaltarid_anioFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarid_anioFormaPagoInven() {
		return this.mostrarid_anioFormaPagoInven;
	}

	public void setMostrarid_anioFormaPagoInven(Boolean mostrarid_anioFormaPagoInven) {
		this.mostrarid_anioFormaPagoInven= mostrarid_anioFormaPagoInven;
	}

	public Boolean getActivarid_anioFormaPagoInven() {
		return this.activarid_anioFormaPagoInven;
	}

	public void setActivarid_anioFormaPagoInven(Boolean activarid_anioFormaPagoInven) {
		this.activarid_anioFormaPagoInven= activarid_anioFormaPagoInven;
	}

	public Boolean getCargarid_anioFormaPagoInven() {
		return this.cargarid_anioFormaPagoInven;
	}

	public void setCargarid_anioFormaPagoInven(Boolean cargarid_anioFormaPagoInven) {
		this.cargarid_anioFormaPagoInven= cargarid_anioFormaPagoInven;
	}

	public Border setResaltarid_mesFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltarid_mesFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesFormaPagoInven() {
		return this.resaltarid_mesFormaPagoInven;
	}

	public void setResaltarid_mesFormaPagoInven(Border borderResaltar) {
		this.resaltarid_mesFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarid_mesFormaPagoInven() {
		return this.mostrarid_mesFormaPagoInven;
	}

	public void setMostrarid_mesFormaPagoInven(Boolean mostrarid_mesFormaPagoInven) {
		this.mostrarid_mesFormaPagoInven= mostrarid_mesFormaPagoInven;
	}

	public Boolean getActivarid_mesFormaPagoInven() {
		return this.activarid_mesFormaPagoInven;
	}

	public void setActivarid_mesFormaPagoInven(Boolean activarid_mesFormaPagoInven) {
		this.activarid_mesFormaPagoInven= activarid_mesFormaPagoInven;
	}

	public Boolean getCargarid_mesFormaPagoInven() {
		return this.cargarid_mesFormaPagoInven;
	}

	public void setCargarid_mesFormaPagoInven(Boolean cargarid_mesFormaPagoInven) {
		this.cargarid_mesFormaPagoInven= cargarid_mesFormaPagoInven;
	}

	public Border setResaltarid_cuenta_contableFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltarid_cuenta_contableFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableFormaPagoInven() {
		return this.resaltarid_cuenta_contableFormaPagoInven;
	}

	public void setResaltarid_cuenta_contableFormaPagoInven(Border borderResaltar) {
		this.resaltarid_cuenta_contableFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableFormaPagoInven() {
		return this.mostrarid_cuenta_contableFormaPagoInven;
	}

	public void setMostrarid_cuenta_contableFormaPagoInven(Boolean mostrarid_cuenta_contableFormaPagoInven) {
		this.mostrarid_cuenta_contableFormaPagoInven= mostrarid_cuenta_contableFormaPagoInven;
	}

	public Boolean getActivarid_cuenta_contableFormaPagoInven() {
		return this.activarid_cuenta_contableFormaPagoInven;
	}

	public void setActivarid_cuenta_contableFormaPagoInven(Boolean activarid_cuenta_contableFormaPagoInven) {
		this.activarid_cuenta_contableFormaPagoInven= activarid_cuenta_contableFormaPagoInven;
	}

	public Boolean getCargarid_cuenta_contableFormaPagoInven() {
		return this.cargarid_cuenta_contableFormaPagoInven;
	}

	public void setCargarid_cuenta_contableFormaPagoInven(Boolean cargarid_cuenta_contableFormaPagoInven) {
		this.cargarid_cuenta_contableFormaPagoInven= cargarid_cuenta_contableFormaPagoInven;
	}

	public Border setResaltarfechaFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagoinvenBeanSwingJInternalFrame.jTtoolBarFormaPagoInven.setBorder(borderResaltar);
		*/
		this.resaltarfechaFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaFormaPagoInven() {
		return this.resaltarfechaFormaPagoInven;
	}

	public void setResaltarfechaFormaPagoInven(Border borderResaltar) {
		this.resaltarfechaFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarfechaFormaPagoInven() {
		return this.mostrarfechaFormaPagoInven;
	}

	public void setMostrarfechaFormaPagoInven(Boolean mostrarfechaFormaPagoInven) {
		this.mostrarfechaFormaPagoInven= mostrarfechaFormaPagoInven;
	}

	public Boolean getActivarfechaFormaPagoInven() {
		return this.activarfechaFormaPagoInven;
	}

	public void setActivarfechaFormaPagoInven(Boolean activarfechaFormaPagoInven) {
		this.activarfechaFormaPagoInven= activarfechaFormaPagoInven;
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
		
		
		this.setMostraridFormaPagoInven(esInicial);
		this.setMostrarid_empresaFormaPagoInven(esInicial);
		this.setMostrarid_sucursalFormaPagoInven(esInicial);
		this.setMostrarid_ejercicioFormaPagoInven(esInicial);
		this.setMostrarid_periodoFormaPagoInven(esInicial);
		this.setMostrarid_tipo_forma_pagoFormaPagoInven(esInicial);
		this.setMostrarfecha_inicioFormaPagoInven(esInicial);
		this.setMostrarnumero_diasFormaPagoInven(esInicial);
		this.setMostrarfecha_finFormaPagoInven(esInicial);
		this.setMostrarporcentajeFormaPagoInven(esInicial);
		this.setMostrarvalorFormaPagoInven(esInicial);
		this.setMostrardetalleFormaPagoInven(esInicial);
		this.setMostrarid_compraFormaPagoInven(esInicial);
		this.setMostrarid_anioFormaPagoInven(esInicial);
		this.setMostrarid_mesFormaPagoInven(esInicial);
		this.setMostrarid_cuenta_contableFormaPagoInven(esInicial);
		this.setMostrarfechaFormaPagoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.ID)) {
				this.setMostraridFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setMostrarid_tipo_forma_pagoFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.NUMERODIAS)) {
				this.setMostrarnumero_diasFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.VALOR)) {
				this.setMostrarvalorFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.DETALLE)) {
				this.setMostrardetalleFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDCOMPRA)) {
				this.setMostrarid_compraFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDMES)) {
				this.setMostrarid_mesFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.FECHA)) {
				this.setMostrarfechaFormaPagoInven(esAsigna);
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
		
		
		this.setActivaridFormaPagoInven(esInicial);
		this.setActivarid_empresaFormaPagoInven(esInicial);
		this.setActivarid_sucursalFormaPagoInven(esInicial);
		this.setActivarid_ejercicioFormaPagoInven(esInicial);
		this.setActivarid_periodoFormaPagoInven(esInicial);
		this.setActivarid_tipo_forma_pagoFormaPagoInven(esInicial);
		this.setActivarfecha_inicioFormaPagoInven(esInicial);
		this.setActivarnumero_diasFormaPagoInven(esInicial);
		this.setActivarfecha_finFormaPagoInven(esInicial);
		this.setActivarporcentajeFormaPagoInven(esInicial);
		this.setActivarvalorFormaPagoInven(esInicial);
		this.setActivardetalleFormaPagoInven(esInicial);
		this.setActivarid_compraFormaPagoInven(esInicial);
		this.setActivarid_anioFormaPagoInven(esInicial);
		this.setActivarid_mesFormaPagoInven(esInicial);
		this.setActivarid_cuenta_contableFormaPagoInven(esInicial);
		this.setActivarfechaFormaPagoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.ID)) {
				this.setActivaridFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setActivarid_tipo_forma_pagoFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.NUMERODIAS)) {
				this.setActivarnumero_diasFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.VALOR)) {
				this.setActivarvalorFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.DETALLE)) {
				this.setActivardetalleFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDCOMPRA)) {
				this.setActivarid_compraFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDANIO)) {
				this.setActivarid_anioFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDMES)) {
				this.setActivarid_mesFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.FECHA)) {
				this.setActivarfechaFormaPagoInven(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFormaPagoInven(esInicial);
		this.setResaltarid_empresaFormaPagoInven(esInicial);
		this.setResaltarid_sucursalFormaPagoInven(esInicial);
		this.setResaltarid_ejercicioFormaPagoInven(esInicial);
		this.setResaltarid_periodoFormaPagoInven(esInicial);
		this.setResaltarid_tipo_forma_pagoFormaPagoInven(esInicial);
		this.setResaltarfecha_inicioFormaPagoInven(esInicial);
		this.setResaltarnumero_diasFormaPagoInven(esInicial);
		this.setResaltarfecha_finFormaPagoInven(esInicial);
		this.setResaltarporcentajeFormaPagoInven(esInicial);
		this.setResaltarvalorFormaPagoInven(esInicial);
		this.setResaltardetalleFormaPagoInven(esInicial);
		this.setResaltarid_compraFormaPagoInven(esInicial);
		this.setResaltarid_anioFormaPagoInven(esInicial);
		this.setResaltarid_mesFormaPagoInven(esInicial);
		this.setResaltarid_cuenta_contableFormaPagoInven(esInicial);
		this.setResaltarfechaFormaPagoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.ID)) {
				this.setResaltaridFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setResaltarid_tipo_forma_pagoFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.NUMERODIAS)) {
				this.setResaltarnumero_diasFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.VALOR)) {
				this.setResaltarvalorFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.DETALLE)) {
				this.setResaltardetalleFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDCOMPRA)) {
				this.setResaltarid_compraFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDMES)) {
				this.setResaltarid_mesFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoInvenConstantesFunciones.FECHA)) {
				this.setResaltarfechaFormaPagoInven(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCompraFormaPagoInven=true;

	public Boolean getMostrarFK_IdCompraFormaPagoInven() {
		return this.mostrarFK_IdCompraFormaPagoInven;
	}

	public void setMostrarFK_IdCompraFormaPagoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCompraFormaPagoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableFormaPagoInven=true;

	public Boolean getMostrarFK_IdCuentaContableFormaPagoInven() {
		return this.mostrarFK_IdCuentaContableFormaPagoInven;
	}

	public void setMostrarFK_IdCuentaContableFormaPagoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableFormaPagoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioFormaPagoInven=true;

	public Boolean getMostrarFK_IdEjercicioFormaPagoInven() {
		return this.mostrarFK_IdEjercicioFormaPagoInven;
	}

	public void setMostrarFK_IdEjercicioFormaPagoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioFormaPagoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaFormaPagoInven=true;

	public Boolean getMostrarFK_IdEmpresaFormaPagoInven() {
		return this.mostrarFK_IdEmpresaFormaPagoInven;
	}

	public void setMostrarFK_IdEmpresaFormaPagoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFormaPagoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoFormaPagoInven=true;

	public Boolean getMostrarFK_IdPeriodoFormaPagoInven() {
		return this.mostrarFK_IdPeriodoFormaPagoInven;
	}

	public void setMostrarFK_IdPeriodoFormaPagoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoFormaPagoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalFormaPagoInven=true;

	public Boolean getMostrarFK_IdSucursalFormaPagoInven() {
		return this.mostrarFK_IdSucursalFormaPagoInven;
	}

	public void setMostrarFK_IdSucursalFormaPagoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalFormaPagoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFormaPagoFormaPagoInven=true;

	public Boolean getMostrarFK_IdTipoFormaPagoFormaPagoInven() {
		return this.mostrarFK_IdTipoFormaPagoFormaPagoInven;
	}

	public void setMostrarFK_IdTipoFormaPagoFormaPagoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFormaPagoFormaPagoInven= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCompraFormaPagoInven=true;

	public Boolean getActivarFK_IdCompraFormaPagoInven() {
		return this.activarFK_IdCompraFormaPagoInven;
	}

	public void setActivarFK_IdCompraFormaPagoInven(Boolean habilitarResaltar) {
		this.activarFK_IdCompraFormaPagoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableFormaPagoInven=true;

	public Boolean getActivarFK_IdCuentaContableFormaPagoInven() {
		return this.activarFK_IdCuentaContableFormaPagoInven;
	}

	public void setActivarFK_IdCuentaContableFormaPagoInven(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableFormaPagoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioFormaPagoInven=true;

	public Boolean getActivarFK_IdEjercicioFormaPagoInven() {
		return this.activarFK_IdEjercicioFormaPagoInven;
	}

	public void setActivarFK_IdEjercicioFormaPagoInven(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioFormaPagoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaFormaPagoInven=true;

	public Boolean getActivarFK_IdEmpresaFormaPagoInven() {
		return this.activarFK_IdEmpresaFormaPagoInven;
	}

	public void setActivarFK_IdEmpresaFormaPagoInven(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFormaPagoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoFormaPagoInven=true;

	public Boolean getActivarFK_IdPeriodoFormaPagoInven() {
		return this.activarFK_IdPeriodoFormaPagoInven;
	}

	public void setActivarFK_IdPeriodoFormaPagoInven(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoFormaPagoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalFormaPagoInven=true;

	public Boolean getActivarFK_IdSucursalFormaPagoInven() {
		return this.activarFK_IdSucursalFormaPagoInven;
	}

	public void setActivarFK_IdSucursalFormaPagoInven(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalFormaPagoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFormaPagoFormaPagoInven=true;

	public Boolean getActivarFK_IdTipoFormaPagoFormaPagoInven() {
		return this.activarFK_IdTipoFormaPagoFormaPagoInven;
	}

	public void setActivarFK_IdTipoFormaPagoFormaPagoInven(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFormaPagoFormaPagoInven= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCompraFormaPagoInven=null;

	public Border getResaltarFK_IdCompraFormaPagoInven() {
		return this.resaltarFK_IdCompraFormaPagoInven;
	}

	public void setResaltarFK_IdCompraFormaPagoInven(Border borderResaltar) {
		this.resaltarFK_IdCompraFormaPagoInven= borderResaltar;
	}

	public void setResaltarFK_IdCompraFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCompraFormaPagoInven= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableFormaPagoInven=null;

	public Border getResaltarFK_IdCuentaContableFormaPagoInven() {
		return this.resaltarFK_IdCuentaContableFormaPagoInven;
	}

	public void setResaltarFK_IdCuentaContableFormaPagoInven(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableFormaPagoInven= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableFormaPagoInven= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioFormaPagoInven=null;

	public Border getResaltarFK_IdEjercicioFormaPagoInven() {
		return this.resaltarFK_IdEjercicioFormaPagoInven;
	}

	public void setResaltarFK_IdEjercicioFormaPagoInven(Border borderResaltar) {
		this.resaltarFK_IdEjercicioFormaPagoInven= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioFormaPagoInven= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaFormaPagoInven=null;

	public Border getResaltarFK_IdEmpresaFormaPagoInven() {
		return this.resaltarFK_IdEmpresaFormaPagoInven;
	}

	public void setResaltarFK_IdEmpresaFormaPagoInven(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFormaPagoInven= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFormaPagoInven= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoFormaPagoInven=null;

	public Border getResaltarFK_IdPeriodoFormaPagoInven() {
		return this.resaltarFK_IdPeriodoFormaPagoInven;
	}

	public void setResaltarFK_IdPeriodoFormaPagoInven(Border borderResaltar) {
		this.resaltarFK_IdPeriodoFormaPagoInven= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoFormaPagoInven= borderResaltar;
	}

	public Border resaltarFK_IdSucursalFormaPagoInven=null;

	public Border getResaltarFK_IdSucursalFormaPagoInven() {
		return this.resaltarFK_IdSucursalFormaPagoInven;
	}

	public void setResaltarFK_IdSucursalFormaPagoInven(Border borderResaltar) {
		this.resaltarFK_IdSucursalFormaPagoInven= borderResaltar;
	}

	public void setResaltarFK_IdSucursalFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalFormaPagoInven= borderResaltar;
	}

	public Border resaltarFK_IdTipoFormaPagoFormaPagoInven=null;

	public Border getResaltarFK_IdTipoFormaPagoFormaPagoInven() {
		return this.resaltarFK_IdTipoFormaPagoFormaPagoInven;
	}

	public void setResaltarFK_IdTipoFormaPagoFormaPagoInven(Border borderResaltar) {
		this.resaltarFK_IdTipoFormaPagoFormaPagoInven= borderResaltar;
	}

	public void setResaltarFK_IdTipoFormaPagoFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoInvenBeanSwingJInternalFrame formapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFormaPagoFormaPagoInven= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.DetalleChequeGiradoConstantesFunciones;
import com.bydan.erp.tesoreria.util.DetalleChequeGiradoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.DetalleChequeGiradoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleChequeGiradoConstantesFunciones extends DetalleChequeGiradoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleChequeGirado";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleChequeGirado"+DetalleChequeGiradoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleChequeGiradoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleChequeGiradoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleChequeGiradoConstantesFunciones.SCHEMA+"_"+DetalleChequeGiradoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleChequeGiradoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleChequeGiradoConstantesFunciones.SCHEMA+"_"+DetalleChequeGiradoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleChequeGiradoConstantesFunciones.SCHEMA+"_"+DetalleChequeGiradoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleChequeGiradoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleChequeGiradoConstantesFunciones.SCHEMA+"_"+DetalleChequeGiradoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleChequeGiradoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleChequeGiradoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleChequeGiradoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleChequeGiradoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleChequeGiradoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleChequeGiradoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleChequeGiradoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleChequeGiradoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleChequeGiradoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleChequeGiradoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Cheque Girados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Cheque Girado";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Cheque Girado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleChequeGirado";
	public static final String OBJECTNAME="detallechequegirado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="detalle_cheque_girado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallechequegirado from "+DetalleChequeGiradoConstantesFunciones.SPERSISTENCENAME+" detallechequegirado";
	public static String QUERYSELECTNATIVE="select "+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".version_row,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_empresa,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_periodo,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_asiento_contable,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_empleado,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_cuenta_banco,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".numero_cheque,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".valor,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".cuenta,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".fecha,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".con,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".beneficiario,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".codigo,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".nombre_banco,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_anio,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_mes from "+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME;//+" as "+DetalleChequeGiradoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleChequeGiradoConstantesFuncionesAdditional detallechequegiradoConstantesFuncionesAdditional=null;
	
	public DetalleChequeGiradoConstantesFuncionesAdditional getDetalleChequeGiradoConstantesFuncionesAdditional() {
		return this.detallechequegiradoConstantesFuncionesAdditional;
	}
	
	public void setDetalleChequeGiradoConstantesFuncionesAdditional(DetalleChequeGiradoConstantesFuncionesAdditional detallechequegiradoConstantesFuncionesAdditional) {
		try {
			this.detallechequegiradoConstantesFuncionesAdditional=detallechequegiradoConstantesFuncionesAdditional;
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
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDCUENTABANCO= "id_cuenta_banco";
    public static final String NUMEROCHEQUE= "numero_cheque";
    public static final String VALOR= "valor";
    public static final String CUENTA= "cuenta";
    public static final String FECHA= "fecha";
    public static final String CON= "con";
    public static final String BENEFICIARIO= "beneficiario";
    public static final String CODIGO= "codigo";
    public static final String NOMBREBANCO= "nombre_banco";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
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
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDCUENTABANCO= "Cuenta Banco";
		public static final String LABEL_IDCUENTABANCO_LOWER= "Cuenta Banco";
    	public static final String LABEL_NUMEROCHEQUE= "Numero Cheque";
		public static final String LABEL_NUMEROCHEQUE_LOWER= "Numero Cheque";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_CUENTA= "Cuenta";
		public static final String LABEL_CUENTA_LOWER= "Cuenta";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_CON= "Con";
		public static final String LABEL_CON_LOWER= "Con";
    	public static final String LABEL_BENEFICIARIO= "Beneficiario";
		public static final String LABEL_BENEFICIARIO_LOWER= "Beneficiario";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBREBANCO= "Nombre Banco";
		public static final String LABEL_NOMBREBANCO_LOWER= "Nombre Banco";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_CHEQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHEQUE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXCUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXBENEFICIARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_BANCO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BANCO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getDetalleChequeGiradoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.IDCUENTABANCO)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_IDCUENTABANCO;}
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.NUMEROCHEQUE)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_NUMEROCHEQUE;}
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.VALOR)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.CUENTA)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_CUENTA;}
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.FECHA)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.CON)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_CON;}
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.BENEFICIARIO)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_BENEFICIARIO;}
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.CODIGO)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.NOMBREBANCO)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_NOMBREBANCO;}
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.IDANIO)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleChequeGiradoConstantesFunciones.IDMES)) {sLabelColumna=DetalleChequeGiradoConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getconDescripcion(DetalleChequeGirado detallechequegirado) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detallechequegirado.getcon()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getconHtmlDescripcion(DetalleChequeGirado detallechequegirado) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detallechequegirado.getId(),detallechequegirado.getcon());

		return sDescripcion;
	}	
			
			
			
			
			
	
	public static String getDetalleChequeGiradoDescripcion(DetalleChequeGirado detallechequegirado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallechequegirado !=null/* && detallechequegirado.getId()!=0*/) {
			sDescripcion=detallechequegirado.getcodigo();//detallechequegiradodetallechequegirado.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleChequeGiradoDescripcionDetallado(DetalleChequeGirado detallechequegirado) {
		String sDescripcion="";
			
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.ID+"=";
		sDescripcion+=detallechequegirado.getId().toString()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallechequegirado.getVersionRow().toString()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallechequegirado.getid_empresa().toString()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallechequegirado.getid_sucursal().toString()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallechequegirado.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detallechequegirado.getid_periodo().toString()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=detallechequegirado.getid_asiento_contable().toString()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=detallechequegirado.getid_empleado().toString()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.IDCUENTABANCO+"=";
		sDescripcion+=detallechequegirado.getid_cuenta_banco().toString()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.NUMEROCHEQUE+"=";
		sDescripcion+=detallechequegirado.getnumero_cheque()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.VALOR+"=";
		sDescripcion+=detallechequegirado.getvalor().toString()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.CUENTA+"=";
		sDescripcion+=detallechequegirado.getcuenta()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.FECHA+"=";
		sDescripcion+=detallechequegirado.getfecha().toString()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.CON+"=";
		sDescripcion+=detallechequegirado.getcon().toString()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.BENEFICIARIO+"=";
		sDescripcion+=detallechequegirado.getbeneficiario()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.CODIGO+"=";
		sDescripcion+=detallechequegirado.getcodigo()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.NOMBREBANCO+"=";
		sDescripcion+=detallechequegirado.getnombre_banco()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.IDANIO+"=";
		sDescripcion+=detallechequegirado.getid_anio().toString()+",";
		sDescripcion+=DetalleChequeGiradoConstantesFunciones.IDMES+"=";
		sDescripcion+=detallechequegirado.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleChequeGiradoDescripcion(DetalleChequeGirado detallechequegirado,String sValor) throws Exception {			
		if(detallechequegirado !=null) {
			detallechequegirado.setcodigo(sValor);;//detallechequegiradodetallechequegirado.getcodigo().trim();
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

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getCuentaBancoDescripcion(CuentaBanco cuentabanco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentabanco!=null/*&&cuentabanco.getId()>0*/) {
			sDescripcion=CuentaBancoConstantesFunciones.getCuentaBancoDescripcion(cuentabanco);
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
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdCuentaBanco")) {
			sNombreIndice="Tipo=  Por Cuenta Banco";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaBanco(Long id_cuenta_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_banco!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Banco="+id_cuenta_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetalleChequeGirado(DetalleChequeGirado detallechequegirado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallechequegirado.setnumero_cheque(detallechequegirado.getnumero_cheque().trim());
		detallechequegirado.setcuenta(detallechequegirado.getcuenta().trim());
		detallechequegirado.setbeneficiario(detallechequegirado.getbeneficiario().trim());
		detallechequegirado.setcodigo(detallechequegirado.getcodigo().trim());
		detallechequegirado.setnombre_banco(detallechequegirado.getnombre_banco().trim());
	}
	
	public static void quitarEspaciosDetalleChequeGirados(List<DetalleChequeGirado> detallechequegirados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleChequeGirado detallechequegirado: detallechequegirados) {
			detallechequegirado.setnumero_cheque(detallechequegirado.getnumero_cheque().trim());
			detallechequegirado.setcuenta(detallechequegirado.getcuenta().trim());
			detallechequegirado.setbeneficiario(detallechequegirado.getbeneficiario().trim());
			detallechequegirado.setcodigo(detallechequegirado.getcodigo().trim());
			detallechequegirado.setnombre_banco(detallechequegirado.getnombre_banco().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleChequeGirado(DetalleChequeGirado detallechequegirado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallechequegirado.getConCambioAuxiliar()) {
			detallechequegirado.setIsDeleted(detallechequegirado.getIsDeletedAuxiliar());	
			detallechequegirado.setIsNew(detallechequegirado.getIsNewAuxiliar());	
			detallechequegirado.setIsChanged(detallechequegirado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallechequegirado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallechequegirado.setIsDeletedAuxiliar(false);	
			detallechequegirado.setIsNewAuxiliar(false);	
			detallechequegirado.setIsChangedAuxiliar(false);
			
			detallechequegirado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleChequeGirados(List<DetalleChequeGirado> detallechequegirados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleChequeGirado detallechequegirado : detallechequegirados) {
			if(conAsignarBase && detallechequegirado.getConCambioAuxiliar()) {
				detallechequegirado.setIsDeleted(detallechequegirado.getIsDeletedAuxiliar());	
				detallechequegirado.setIsNew(detallechequegirado.getIsNewAuxiliar());	
				detallechequegirado.setIsChanged(detallechequegirado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallechequegirado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallechequegirado.setIsDeletedAuxiliar(false);	
				detallechequegirado.setIsNewAuxiliar(false);	
				detallechequegirado.setIsChangedAuxiliar(false);
				
				detallechequegirado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleChequeGirado(DetalleChequeGirado detallechequegirado,Boolean conEnteros) throws Exception  {
		detallechequegirado.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleChequeGirados(List<DetalleChequeGirado> detallechequegirados,Boolean conEnteros) throws Exception  {
		
		for(DetalleChequeGirado detallechequegirado: detallechequegirados) {
			detallechequegirado.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleChequeGirado(List<DetalleChequeGirado> detallechequegirados,DetalleChequeGirado detallechequegiradoAux) throws Exception  {
		DetalleChequeGiradoConstantesFunciones.InicializarValoresDetalleChequeGirado(detallechequegiradoAux,true);
		
		for(DetalleChequeGirado detallechequegirado: detallechequegirados) {
			if(detallechequegirado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallechequegiradoAux.setvalor(detallechequegiradoAux.getvalor()+detallechequegirado.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleChequeGirado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleChequeGiradoConstantesFunciones.getArrayColumnasGlobalesDetalleChequeGirado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleChequeGirado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleChequeGiradoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleChequeGiradoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleChequeGiradoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleChequeGiradoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleChequeGiradoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleChequeGiradoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleChequeGiradoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleChequeGiradoConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleChequeGirado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleChequeGirado> detallechequegirados,DetalleChequeGirado detallechequegirado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleChequeGirado detallechequegiradoAux: detallechequegirados) {
			if(detallechequegiradoAux!=null && detallechequegirado!=null) {
				if((detallechequegiradoAux.getId()==null && detallechequegirado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallechequegiradoAux.getId()!=null && detallechequegirado.getId()!=null){
					if(detallechequegiradoAux.getId().equals(detallechequegirado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleChequeGirado(List<DetalleChequeGirado> detallechequegirados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(DetalleChequeGirado detallechequegirado: detallechequegirados) {			
			if(detallechequegirado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=detallechequegirado.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleChequeGiradoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleChequeGirado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_ID, DetalleChequeGiradoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_VERSIONROW, DetalleChequeGiradoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_IDEMPRESA, DetalleChequeGiradoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_IDSUCURSAL, DetalleChequeGiradoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_IDEJERCICIO, DetalleChequeGiradoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_IDPERIODO, DetalleChequeGiradoConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_IDASIENTOCONTABLE, DetalleChequeGiradoConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_IDEMPLEADO, DetalleChequeGiradoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_IDCUENTABANCO, DetalleChequeGiradoConstantesFunciones.IDCUENTABANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_NUMEROCHEQUE, DetalleChequeGiradoConstantesFunciones.NUMEROCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_VALOR, DetalleChequeGiradoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_CUENTA, DetalleChequeGiradoConstantesFunciones.CUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_FECHA, DetalleChequeGiradoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_CON, DetalleChequeGiradoConstantesFunciones.CON,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_BENEFICIARIO, DetalleChequeGiradoConstantesFunciones.BENEFICIARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_CODIGO, DetalleChequeGiradoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_NOMBREBANCO, DetalleChequeGiradoConstantesFunciones.NOMBREBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_IDANIO, DetalleChequeGiradoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleChequeGiradoConstantesFunciones.LABEL_IDMES, DetalleChequeGiradoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleChequeGirado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.IDCUENTABANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.NUMEROCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.CUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.CON;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.BENEFICIARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.NOMBREBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleChequeGiradoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleChequeGirado() throws Exception  {
		return DetalleChequeGiradoConstantesFunciones.getTiposSeleccionarDetalleChequeGirado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleChequeGirado(Boolean conFk) throws Exception  {
		return DetalleChequeGiradoConstantesFunciones.getTiposSeleccionarDetalleChequeGirado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleChequeGirado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_IDCUENTABANCO);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_IDCUENTABANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_NUMEROCHEQUE);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_NUMEROCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_CUENTA);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_CUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_CON);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_CON);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_BENEFICIARIO);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_BENEFICIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_NOMBREBANCO);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_NOMBREBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleChequeGiradoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleChequeGirado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleChequeGirado(DetalleChequeGirado detallechequegiradoAux) throws Exception {
		
			detallechequegiradoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallechequegiradoAux.getEmpresa()));
			detallechequegiradoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallechequegiradoAux.getSucursal()));
			detallechequegiradoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallechequegiradoAux.getEjercicio()));
			detallechequegiradoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallechequegiradoAux.getPeriodo()));
			detallechequegiradoAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(detallechequegiradoAux.getAsientoContable()));
			detallechequegiradoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(detallechequegiradoAux.getEmpleado()));
			detallechequegiradoAux.setcuentabanco_descripcion(CuentaBancoConstantesFunciones.getCuentaBancoDescripcion(detallechequegiradoAux.getCuentaBanco()));
			detallechequegiradoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallechequegiradoAux.getAnio()));
			detallechequegiradoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallechequegiradoAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleChequeGirado(List<DetalleChequeGirado> detallechequegiradosTemp) throws Exception {
		for(DetalleChequeGirado detallechequegiradoAux:detallechequegiradosTemp) {
			
			detallechequegiradoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallechequegiradoAux.getEmpresa()));
			detallechequegiradoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallechequegiradoAux.getSucursal()));
			detallechequegiradoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallechequegiradoAux.getEjercicio()));
			detallechequegiradoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallechequegiradoAux.getPeriodo()));
			detallechequegiradoAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(detallechequegiradoAux.getAsientoContable()));
			detallechequegiradoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(detallechequegiradoAux.getEmpleado()));
			detallechequegiradoAux.setcuentabanco_descripcion(CuentaBancoConstantesFunciones.getCuentaBancoDescripcion(detallechequegiradoAux.getCuentaBanco()));
			detallechequegiradoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallechequegiradoAux.getAnio()));
			detallechequegiradoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallechequegiradoAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleChequeGirado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(CuentaBanco.class));
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
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaBanco.class)) {
						classes.add(new Classe(CuentaBanco.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleChequeGirado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(CuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBanco.class)); continue;
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

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(CuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBanco.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleChequeGirado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleChequeGiradoConstantesFunciones.getClassesRelationshipsOfDetalleChequeGirado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleChequeGirado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleChequeGirado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleChequeGiradoConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleChequeGirado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleChequeGirado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleChequeGirado detallechequegirado,List<DetalleChequeGirado> detallechequegirados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleChequeGirado detallechequegiradoEncontrado=null;
			
			for(DetalleChequeGirado detallechequegiradoLocal:detallechequegirados) {
				if(detallechequegiradoLocal.getId().equals(detallechequegirado.getId())) {
					detallechequegiradoEncontrado=detallechequegiradoLocal;
					
					detallechequegiradoLocal.setIsChanged(detallechequegirado.getIsChanged());
					detallechequegiradoLocal.setIsNew(detallechequegirado.getIsNew());
					detallechequegiradoLocal.setIsDeleted(detallechequegirado.getIsDeleted());
					
					detallechequegiradoLocal.setGeneralEntityOriginal(detallechequegirado.getGeneralEntityOriginal());
					
					detallechequegiradoLocal.setId(detallechequegirado.getId());	
					detallechequegiradoLocal.setVersionRow(detallechequegirado.getVersionRow());	
					detallechequegiradoLocal.setid_empresa(detallechequegirado.getid_empresa());	
					detallechequegiradoLocal.setid_sucursal(detallechequegirado.getid_sucursal());	
					detallechequegiradoLocal.setid_ejercicio(detallechequegirado.getid_ejercicio());	
					detallechequegiradoLocal.setid_periodo(detallechequegirado.getid_periodo());	
					detallechequegiradoLocal.setid_asiento_contable(detallechequegirado.getid_asiento_contable());	
					detallechequegiradoLocal.setid_empleado(detallechequegirado.getid_empleado());	
					detallechequegiradoLocal.setid_cuenta_banco(detallechequegirado.getid_cuenta_banco());	
					detallechequegiradoLocal.setnumero_cheque(detallechequegirado.getnumero_cheque());	
					detallechequegiradoLocal.setvalor(detallechequegirado.getvalor());	
					detallechequegiradoLocal.setcuenta(detallechequegirado.getcuenta());	
					detallechequegiradoLocal.setfecha(detallechequegirado.getfecha());	
					detallechequegiradoLocal.setcon(detallechequegirado.getcon());	
					detallechequegiradoLocal.setbeneficiario(detallechequegirado.getbeneficiario());	
					detallechequegiradoLocal.setcodigo(detallechequegirado.getcodigo());	
					detallechequegiradoLocal.setnombre_banco(detallechequegirado.getnombre_banco());	
					detallechequegiradoLocal.setid_anio(detallechequegirado.getid_anio());	
					detallechequegiradoLocal.setid_mes(detallechequegirado.getid_mes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallechequegirado.getIsDeleted()) {
				if(!existe) {
					detallechequegirados.add(detallechequegirado);
				}
			} else {
				if(detallechequegiradoEncontrado!=null && permiteQuitar)  {
					detallechequegirados.remove(detallechequegiradoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleChequeGirado detallechequegirado,List<DetalleChequeGirado> detallechequegirados) throws Exception {
		try	{			
			for(DetalleChequeGirado detallechequegiradoLocal:detallechequegirados) {
				if(detallechequegiradoLocal.getId().equals(detallechequegirado.getId())) {
					detallechequegiradoLocal.setIsSelected(detallechequegirado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleChequeGirado(List<DetalleChequeGirado> detallechequegiradosAux) throws Exception {
		//this.detallechequegiradosAux=detallechequegiradosAux;
		
		for(DetalleChequeGirado detallechequegiradoAux:detallechequegiradosAux) {
			if(detallechequegiradoAux.getIsChanged()) {
				detallechequegiradoAux.setIsChanged(false);
			}		
			
			if(detallechequegiradoAux.getIsNew()) {
				detallechequegiradoAux.setIsNew(false);
			}	
			
			if(detallechequegiradoAux.getIsDeleted()) {
				detallechequegiradoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleChequeGirado(DetalleChequeGirado detallechequegiradoAux) throws Exception {
		//this.detallechequegiradoAux=detallechequegiradoAux;
		
			if(detallechequegiradoAux.getIsChanged()) {
				detallechequegiradoAux.setIsChanged(false);
			}		
			
			if(detallechequegiradoAux.getIsNew()) {
				detallechequegiradoAux.setIsNew(false);
			}	
			
			if(detallechequegiradoAux.getIsDeleted()) {
				detallechequegiradoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleChequeGirado detallechequegiradoAsignar,DetalleChequeGirado detallechequegirado) throws Exception {
		detallechequegiradoAsignar.setId(detallechequegirado.getId());	
		detallechequegiradoAsignar.setVersionRow(detallechequegirado.getVersionRow());	
		detallechequegiradoAsignar.setid_empresa(detallechequegirado.getid_empresa());
		detallechequegiradoAsignar.setempresa_descripcion(detallechequegirado.getempresa_descripcion());	
		detallechequegiradoAsignar.setid_sucursal(detallechequegirado.getid_sucursal());
		detallechequegiradoAsignar.setsucursal_descripcion(detallechequegirado.getsucursal_descripcion());	
		detallechequegiradoAsignar.setid_ejercicio(detallechequegirado.getid_ejercicio());
		detallechequegiradoAsignar.setejercicio_descripcion(detallechequegirado.getejercicio_descripcion());	
		detallechequegiradoAsignar.setid_periodo(detallechequegirado.getid_periodo());
		detallechequegiradoAsignar.setperiodo_descripcion(detallechequegirado.getperiodo_descripcion());	
		detallechequegiradoAsignar.setid_asiento_contable(detallechequegirado.getid_asiento_contable());
		detallechequegiradoAsignar.setasientocontable_descripcion(detallechequegirado.getasientocontable_descripcion());	
		detallechequegiradoAsignar.setid_empleado(detallechequegirado.getid_empleado());
		detallechequegiradoAsignar.setempleado_descripcion(detallechequegirado.getempleado_descripcion());	
		detallechequegiradoAsignar.setid_cuenta_banco(detallechequegirado.getid_cuenta_banco());
		detallechequegiradoAsignar.setcuentabanco_descripcion(detallechequegirado.getcuentabanco_descripcion());	
		detallechequegiradoAsignar.setnumero_cheque(detallechequegirado.getnumero_cheque());	
		detallechequegiradoAsignar.setvalor(detallechequegirado.getvalor());	
		detallechequegiradoAsignar.setcuenta(detallechequegirado.getcuenta());	
		detallechequegiradoAsignar.setfecha(detallechequegirado.getfecha());	
		detallechequegiradoAsignar.setcon(detallechequegirado.getcon());	
		detallechequegiradoAsignar.setbeneficiario(detallechequegirado.getbeneficiario());	
		detallechequegiradoAsignar.setcodigo(detallechequegirado.getcodigo());	
		detallechequegiradoAsignar.setnombre_banco(detallechequegirado.getnombre_banco());	
		detallechequegiradoAsignar.setid_anio(detallechequegirado.getid_anio());
		detallechequegiradoAsignar.setanio_descripcion(detallechequegirado.getanio_descripcion());	
		detallechequegiradoAsignar.setid_mes(detallechequegirado.getid_mes());
		detallechequegiradoAsignar.setmes_descripcion(detallechequegirado.getmes_descripcion());	
	}
	
	public static void inicializarDetalleChequeGirado(DetalleChequeGirado detallechequegirado) throws Exception {
		try {
				detallechequegirado.setId(0L);	
					
				detallechequegirado.setid_empresa(-1L);	
				detallechequegirado.setid_sucursal(-1L);	
				detallechequegirado.setid_ejercicio(-1L);	
				detallechequegirado.setid_periodo(-1L);	
				detallechequegirado.setid_asiento_contable(-1L);	
				detallechequegirado.setid_empleado(-1L);	
				detallechequegirado.setid_cuenta_banco(-1L);	
				detallechequegirado.setnumero_cheque("");	
				detallechequegirado.setvalor(0.0);	
				detallechequegirado.setcuenta("");	
				detallechequegirado.setfecha(new Date());	
				detallechequegirado.setcon(false);	
				detallechequegirado.setbeneficiario("");	
				detallechequegirado.setcodigo("");	
				detallechequegirado.setnombre_banco("");	
				detallechequegirado.setid_anio(null);	
				detallechequegirado.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleChequeGirado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_IDCUENTABANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_NUMEROCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_CUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_CON);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_BENEFICIARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_NOMBREBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleChequeGiradoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleChequeGirado(String sTipo,Row row,Workbook workbook,DetalleChequeGirado detallechequegirado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallechequegirado.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallechequegirado.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallechequegirado.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallechequegirado.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallechequegirado.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallechequegirado.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallechequegirado.getcuentabanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallechequegirado.getnumero_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallechequegirado.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallechequegirado.getcuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallechequegirado.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detallechequegirado.getcon()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallechequegirado.getbeneficiario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallechequegirado.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallechequegirado.getnombre_banco());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallechequegirado.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallechequegirado.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleChequeGirado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleChequeGirado() {
		return this.sFinalQueryDetalleChequeGirado;
	}
	
	public void setsFinalQueryDetalleChequeGirado(String sFinalQueryDetalleChequeGirado) {
		this.sFinalQueryDetalleChequeGirado= sFinalQueryDetalleChequeGirado;
	}
	
	public Border resaltarSeleccionarDetalleChequeGirado=null;
	
	public Border setResaltarSeleccionarDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleChequeGirado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleChequeGirado() {
		return this.resaltarSeleccionarDetalleChequeGirado;
	}
	
	public void setResaltarSeleccionarDetalleChequeGirado(Border borderResaltarSeleccionarDetalleChequeGirado) {
		this.resaltarSeleccionarDetalleChequeGirado= borderResaltarSeleccionarDetalleChequeGirado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleChequeGirado=null;
	public Boolean mostraridDetalleChequeGirado=true;
	public Boolean activaridDetalleChequeGirado=true;

	public Border resaltarid_empresaDetalleChequeGirado=null;
	public Boolean mostrarid_empresaDetalleChequeGirado=true;
	public Boolean activarid_empresaDetalleChequeGirado=true;
	public Boolean cargarid_empresaDetalleChequeGirado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleChequeGirado=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleChequeGirado=null;
	public Boolean mostrarid_sucursalDetalleChequeGirado=true;
	public Boolean activarid_sucursalDetalleChequeGirado=true;
	public Boolean cargarid_sucursalDetalleChequeGirado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleChequeGirado=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleChequeGirado=null;
	public Boolean mostrarid_ejercicioDetalleChequeGirado=true;
	public Boolean activarid_ejercicioDetalleChequeGirado=true;
	public Boolean cargarid_ejercicioDetalleChequeGirado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleChequeGirado=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleChequeGirado=null;
	public Boolean mostrarid_periodoDetalleChequeGirado=true;
	public Boolean activarid_periodoDetalleChequeGirado=true;
	public Boolean cargarid_periodoDetalleChequeGirado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleChequeGirado=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableDetalleChequeGirado=null;
	public Boolean mostrarid_asiento_contableDetalleChequeGirado=true;
	public Boolean activarid_asiento_contableDetalleChequeGirado=true;
	public Boolean cargarid_asiento_contableDetalleChequeGirado=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableDetalleChequeGirado=false;//ConEventDepend=true

	public Border resaltarid_empleadoDetalleChequeGirado=null;
	public Boolean mostrarid_empleadoDetalleChequeGirado=true;
	public Boolean activarid_empleadoDetalleChequeGirado=true;
	public Boolean cargarid_empleadoDetalleChequeGirado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoDetalleChequeGirado=false;//ConEventDepend=true

	public Border resaltarid_cuenta_bancoDetalleChequeGirado=null;
	public Boolean mostrarid_cuenta_bancoDetalleChequeGirado=true;
	public Boolean activarid_cuenta_bancoDetalleChequeGirado=true;
	public Boolean cargarid_cuenta_bancoDetalleChequeGirado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_bancoDetalleChequeGirado=false;//ConEventDepend=true

	public Border resaltarnumero_chequeDetalleChequeGirado=null;
	public Boolean mostrarnumero_chequeDetalleChequeGirado=true;
	public Boolean activarnumero_chequeDetalleChequeGirado=true;

	public Border resaltarvalorDetalleChequeGirado=null;
	public Boolean mostrarvalorDetalleChequeGirado=true;
	public Boolean activarvalorDetalleChequeGirado=true;

	public Border resaltarcuentaDetalleChequeGirado=null;
	public Boolean mostrarcuentaDetalleChequeGirado=true;
	public Boolean activarcuentaDetalleChequeGirado=true;

	public Border resaltarfechaDetalleChequeGirado=null;
	public Boolean mostrarfechaDetalleChequeGirado=true;
	public Boolean activarfechaDetalleChequeGirado=false;

	public Border resaltarconDetalleChequeGirado=null;
	public Boolean mostrarconDetalleChequeGirado=true;
	public Boolean activarconDetalleChequeGirado=true;

	public Border resaltarbeneficiarioDetalleChequeGirado=null;
	public Boolean mostrarbeneficiarioDetalleChequeGirado=true;
	public Boolean activarbeneficiarioDetalleChequeGirado=true;

	public Border resaltarcodigoDetalleChequeGirado=null;
	public Boolean mostrarcodigoDetalleChequeGirado=true;
	public Boolean activarcodigoDetalleChequeGirado=true;

	public Border resaltarnombre_bancoDetalleChequeGirado=null;
	public Boolean mostrarnombre_bancoDetalleChequeGirado=true;
	public Boolean activarnombre_bancoDetalleChequeGirado=true;

	public Border resaltarid_anioDetalleChequeGirado=null;
	public Boolean mostrarid_anioDetalleChequeGirado=true;
	public Boolean activarid_anioDetalleChequeGirado=false;
	public Boolean cargarid_anioDetalleChequeGirado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleChequeGirado=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleChequeGirado=null;
	public Boolean mostrarid_mesDetalleChequeGirado=true;
	public Boolean activarid_mesDetalleChequeGirado=false;
	public Boolean cargarid_mesDetalleChequeGirado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleChequeGirado=false;//ConEventDepend=true

	
	

	public Border setResaltaridDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltaridDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleChequeGirado() {
		return this.resaltaridDetalleChequeGirado;
	}

	public void setResaltaridDetalleChequeGirado(Border borderResaltar) {
		this.resaltaridDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostraridDetalleChequeGirado() {
		return this.mostraridDetalleChequeGirado;
	}

	public void setMostraridDetalleChequeGirado(Boolean mostraridDetalleChequeGirado) {
		this.mostraridDetalleChequeGirado= mostraridDetalleChequeGirado;
	}

	public Boolean getActivaridDetalleChequeGirado() {
		return this.activaridDetalleChequeGirado;
	}

	public void setActivaridDetalleChequeGirado(Boolean activaridDetalleChequeGirado) {
		this.activaridDetalleChequeGirado= activaridDetalleChequeGirado;
	}

	public Border setResaltarid_empresaDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleChequeGirado() {
		return this.resaltarid_empresaDetalleChequeGirado;
	}

	public void setResaltarid_empresaDetalleChequeGirado(Border borderResaltar) {
		this.resaltarid_empresaDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleChequeGirado() {
		return this.mostrarid_empresaDetalleChequeGirado;
	}

	public void setMostrarid_empresaDetalleChequeGirado(Boolean mostrarid_empresaDetalleChequeGirado) {
		this.mostrarid_empresaDetalleChequeGirado= mostrarid_empresaDetalleChequeGirado;
	}

	public Boolean getActivarid_empresaDetalleChequeGirado() {
		return this.activarid_empresaDetalleChequeGirado;
	}

	public void setActivarid_empresaDetalleChequeGirado(Boolean activarid_empresaDetalleChequeGirado) {
		this.activarid_empresaDetalleChequeGirado= activarid_empresaDetalleChequeGirado;
	}

	public Boolean getCargarid_empresaDetalleChequeGirado() {
		return this.cargarid_empresaDetalleChequeGirado;
	}

	public void setCargarid_empresaDetalleChequeGirado(Boolean cargarid_empresaDetalleChequeGirado) {
		this.cargarid_empresaDetalleChequeGirado= cargarid_empresaDetalleChequeGirado;
	}

	public Border setResaltarid_sucursalDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleChequeGirado() {
		return this.resaltarid_sucursalDetalleChequeGirado;
	}

	public void setResaltarid_sucursalDetalleChequeGirado(Border borderResaltar) {
		this.resaltarid_sucursalDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleChequeGirado() {
		return this.mostrarid_sucursalDetalleChequeGirado;
	}

	public void setMostrarid_sucursalDetalleChequeGirado(Boolean mostrarid_sucursalDetalleChequeGirado) {
		this.mostrarid_sucursalDetalleChequeGirado= mostrarid_sucursalDetalleChequeGirado;
	}

	public Boolean getActivarid_sucursalDetalleChequeGirado() {
		return this.activarid_sucursalDetalleChequeGirado;
	}

	public void setActivarid_sucursalDetalleChequeGirado(Boolean activarid_sucursalDetalleChequeGirado) {
		this.activarid_sucursalDetalleChequeGirado= activarid_sucursalDetalleChequeGirado;
	}

	public Boolean getCargarid_sucursalDetalleChequeGirado() {
		return this.cargarid_sucursalDetalleChequeGirado;
	}

	public void setCargarid_sucursalDetalleChequeGirado(Boolean cargarid_sucursalDetalleChequeGirado) {
		this.cargarid_sucursalDetalleChequeGirado= cargarid_sucursalDetalleChequeGirado;
	}

	public Border setResaltarid_ejercicioDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleChequeGirado() {
		return this.resaltarid_ejercicioDetalleChequeGirado;
	}

	public void setResaltarid_ejercicioDetalleChequeGirado(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleChequeGirado() {
		return this.mostrarid_ejercicioDetalleChequeGirado;
	}

	public void setMostrarid_ejercicioDetalleChequeGirado(Boolean mostrarid_ejercicioDetalleChequeGirado) {
		this.mostrarid_ejercicioDetalleChequeGirado= mostrarid_ejercicioDetalleChequeGirado;
	}

	public Boolean getActivarid_ejercicioDetalleChequeGirado() {
		return this.activarid_ejercicioDetalleChequeGirado;
	}

	public void setActivarid_ejercicioDetalleChequeGirado(Boolean activarid_ejercicioDetalleChequeGirado) {
		this.activarid_ejercicioDetalleChequeGirado= activarid_ejercicioDetalleChequeGirado;
	}

	public Boolean getCargarid_ejercicioDetalleChequeGirado() {
		return this.cargarid_ejercicioDetalleChequeGirado;
	}

	public void setCargarid_ejercicioDetalleChequeGirado(Boolean cargarid_ejercicioDetalleChequeGirado) {
		this.cargarid_ejercicioDetalleChequeGirado= cargarid_ejercicioDetalleChequeGirado;
	}

	public Border setResaltarid_periodoDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleChequeGirado() {
		return this.resaltarid_periodoDetalleChequeGirado;
	}

	public void setResaltarid_periodoDetalleChequeGirado(Border borderResaltar) {
		this.resaltarid_periodoDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleChequeGirado() {
		return this.mostrarid_periodoDetalleChequeGirado;
	}

	public void setMostrarid_periodoDetalleChequeGirado(Boolean mostrarid_periodoDetalleChequeGirado) {
		this.mostrarid_periodoDetalleChequeGirado= mostrarid_periodoDetalleChequeGirado;
	}

	public Boolean getActivarid_periodoDetalleChequeGirado() {
		return this.activarid_periodoDetalleChequeGirado;
	}

	public void setActivarid_periodoDetalleChequeGirado(Boolean activarid_periodoDetalleChequeGirado) {
		this.activarid_periodoDetalleChequeGirado= activarid_periodoDetalleChequeGirado;
	}

	public Boolean getCargarid_periodoDetalleChequeGirado() {
		return this.cargarid_periodoDetalleChequeGirado;
	}

	public void setCargarid_periodoDetalleChequeGirado(Boolean cargarid_periodoDetalleChequeGirado) {
		this.cargarid_periodoDetalleChequeGirado= cargarid_periodoDetalleChequeGirado;
	}

	public Border setResaltarid_asiento_contableDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableDetalleChequeGirado() {
		return this.resaltarid_asiento_contableDetalleChequeGirado;
	}

	public void setResaltarid_asiento_contableDetalleChequeGirado(Border borderResaltar) {
		this.resaltarid_asiento_contableDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableDetalleChequeGirado() {
		return this.mostrarid_asiento_contableDetalleChequeGirado;
	}

	public void setMostrarid_asiento_contableDetalleChequeGirado(Boolean mostrarid_asiento_contableDetalleChequeGirado) {
		this.mostrarid_asiento_contableDetalleChequeGirado= mostrarid_asiento_contableDetalleChequeGirado;
	}

	public Boolean getActivarid_asiento_contableDetalleChequeGirado() {
		return this.activarid_asiento_contableDetalleChequeGirado;
	}

	public void setActivarid_asiento_contableDetalleChequeGirado(Boolean activarid_asiento_contableDetalleChequeGirado) {
		this.activarid_asiento_contableDetalleChequeGirado= activarid_asiento_contableDetalleChequeGirado;
	}

	public Boolean getCargarid_asiento_contableDetalleChequeGirado() {
		return this.cargarid_asiento_contableDetalleChequeGirado;
	}

	public void setCargarid_asiento_contableDetalleChequeGirado(Boolean cargarid_asiento_contableDetalleChequeGirado) {
		this.cargarid_asiento_contableDetalleChequeGirado= cargarid_asiento_contableDetalleChequeGirado;
	}

	public Border setResaltarid_empleadoDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarid_empleadoDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoDetalleChequeGirado() {
		return this.resaltarid_empleadoDetalleChequeGirado;
	}

	public void setResaltarid_empleadoDetalleChequeGirado(Border borderResaltar) {
		this.resaltarid_empleadoDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarid_empleadoDetalleChequeGirado() {
		return this.mostrarid_empleadoDetalleChequeGirado;
	}

	public void setMostrarid_empleadoDetalleChequeGirado(Boolean mostrarid_empleadoDetalleChequeGirado) {
		this.mostrarid_empleadoDetalleChequeGirado= mostrarid_empleadoDetalleChequeGirado;
	}

	public Boolean getActivarid_empleadoDetalleChequeGirado() {
		return this.activarid_empleadoDetalleChequeGirado;
	}

	public void setActivarid_empleadoDetalleChequeGirado(Boolean activarid_empleadoDetalleChequeGirado) {
		this.activarid_empleadoDetalleChequeGirado= activarid_empleadoDetalleChequeGirado;
	}

	public Boolean getCargarid_empleadoDetalleChequeGirado() {
		return this.cargarid_empleadoDetalleChequeGirado;
	}

	public void setCargarid_empleadoDetalleChequeGirado(Boolean cargarid_empleadoDetalleChequeGirado) {
		this.cargarid_empleadoDetalleChequeGirado= cargarid_empleadoDetalleChequeGirado;
	}

	public Border setResaltarid_cuenta_bancoDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_bancoDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_bancoDetalleChequeGirado() {
		return this.resaltarid_cuenta_bancoDetalleChequeGirado;
	}

	public void setResaltarid_cuenta_bancoDetalleChequeGirado(Border borderResaltar) {
		this.resaltarid_cuenta_bancoDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_bancoDetalleChequeGirado() {
		return this.mostrarid_cuenta_bancoDetalleChequeGirado;
	}

	public void setMostrarid_cuenta_bancoDetalleChequeGirado(Boolean mostrarid_cuenta_bancoDetalleChequeGirado) {
		this.mostrarid_cuenta_bancoDetalleChequeGirado= mostrarid_cuenta_bancoDetalleChequeGirado;
	}

	public Boolean getActivarid_cuenta_bancoDetalleChequeGirado() {
		return this.activarid_cuenta_bancoDetalleChequeGirado;
	}

	public void setActivarid_cuenta_bancoDetalleChequeGirado(Boolean activarid_cuenta_bancoDetalleChequeGirado) {
		this.activarid_cuenta_bancoDetalleChequeGirado= activarid_cuenta_bancoDetalleChequeGirado;
	}

	public Boolean getCargarid_cuenta_bancoDetalleChequeGirado() {
		return this.cargarid_cuenta_bancoDetalleChequeGirado;
	}

	public void setCargarid_cuenta_bancoDetalleChequeGirado(Boolean cargarid_cuenta_bancoDetalleChequeGirado) {
		this.cargarid_cuenta_bancoDetalleChequeGirado= cargarid_cuenta_bancoDetalleChequeGirado;
	}

	public Border setResaltarnumero_chequeDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarnumero_chequeDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chequeDetalleChequeGirado() {
		return this.resaltarnumero_chequeDetalleChequeGirado;
	}

	public void setResaltarnumero_chequeDetalleChequeGirado(Border borderResaltar) {
		this.resaltarnumero_chequeDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarnumero_chequeDetalleChequeGirado() {
		return this.mostrarnumero_chequeDetalleChequeGirado;
	}

	public void setMostrarnumero_chequeDetalleChequeGirado(Boolean mostrarnumero_chequeDetalleChequeGirado) {
		this.mostrarnumero_chequeDetalleChequeGirado= mostrarnumero_chequeDetalleChequeGirado;
	}

	public Boolean getActivarnumero_chequeDetalleChequeGirado() {
		return this.activarnumero_chequeDetalleChequeGirado;
	}

	public void setActivarnumero_chequeDetalleChequeGirado(Boolean activarnumero_chequeDetalleChequeGirado) {
		this.activarnumero_chequeDetalleChequeGirado= activarnumero_chequeDetalleChequeGirado;
	}

	public Border setResaltarvalorDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarvalorDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorDetalleChequeGirado() {
		return this.resaltarvalorDetalleChequeGirado;
	}

	public void setResaltarvalorDetalleChequeGirado(Border borderResaltar) {
		this.resaltarvalorDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarvalorDetalleChequeGirado() {
		return this.mostrarvalorDetalleChequeGirado;
	}

	public void setMostrarvalorDetalleChequeGirado(Boolean mostrarvalorDetalleChequeGirado) {
		this.mostrarvalorDetalleChequeGirado= mostrarvalorDetalleChequeGirado;
	}

	public Boolean getActivarvalorDetalleChequeGirado() {
		return this.activarvalorDetalleChequeGirado;
	}

	public void setActivarvalorDetalleChequeGirado(Boolean activarvalorDetalleChequeGirado) {
		this.activarvalorDetalleChequeGirado= activarvalorDetalleChequeGirado;
	}

	public Border setResaltarcuentaDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarcuentaDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcuentaDetalleChequeGirado() {
		return this.resaltarcuentaDetalleChequeGirado;
	}

	public void setResaltarcuentaDetalleChequeGirado(Border borderResaltar) {
		this.resaltarcuentaDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarcuentaDetalleChequeGirado() {
		return this.mostrarcuentaDetalleChequeGirado;
	}

	public void setMostrarcuentaDetalleChequeGirado(Boolean mostrarcuentaDetalleChequeGirado) {
		this.mostrarcuentaDetalleChequeGirado= mostrarcuentaDetalleChequeGirado;
	}

	public Boolean getActivarcuentaDetalleChequeGirado() {
		return this.activarcuentaDetalleChequeGirado;
	}

	public void setActivarcuentaDetalleChequeGirado(Boolean activarcuentaDetalleChequeGirado) {
		this.activarcuentaDetalleChequeGirado= activarcuentaDetalleChequeGirado;
	}

	public Border setResaltarfechaDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarfechaDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaDetalleChequeGirado() {
		return this.resaltarfechaDetalleChequeGirado;
	}

	public void setResaltarfechaDetalleChequeGirado(Border borderResaltar) {
		this.resaltarfechaDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarfechaDetalleChequeGirado() {
		return this.mostrarfechaDetalleChequeGirado;
	}

	public void setMostrarfechaDetalleChequeGirado(Boolean mostrarfechaDetalleChequeGirado) {
		this.mostrarfechaDetalleChequeGirado= mostrarfechaDetalleChequeGirado;
	}

	public Boolean getActivarfechaDetalleChequeGirado() {
		return this.activarfechaDetalleChequeGirado;
	}

	public void setActivarfechaDetalleChequeGirado(Boolean activarfechaDetalleChequeGirado) {
		this.activarfechaDetalleChequeGirado= activarfechaDetalleChequeGirado;
	}

	public Border setResaltarconDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarconDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarconDetalleChequeGirado() {
		return this.resaltarconDetalleChequeGirado;
	}

	public void setResaltarconDetalleChequeGirado(Border borderResaltar) {
		this.resaltarconDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarconDetalleChequeGirado() {
		return this.mostrarconDetalleChequeGirado;
	}

	public void setMostrarconDetalleChequeGirado(Boolean mostrarconDetalleChequeGirado) {
		this.mostrarconDetalleChequeGirado= mostrarconDetalleChequeGirado;
	}

	public Boolean getActivarconDetalleChequeGirado() {
		return this.activarconDetalleChequeGirado;
	}

	public void setActivarconDetalleChequeGirado(Boolean activarconDetalleChequeGirado) {
		this.activarconDetalleChequeGirado= activarconDetalleChequeGirado;
	}

	public Border setResaltarbeneficiarioDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarbeneficiarioDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiarioDetalleChequeGirado() {
		return this.resaltarbeneficiarioDetalleChequeGirado;
	}

	public void setResaltarbeneficiarioDetalleChequeGirado(Border borderResaltar) {
		this.resaltarbeneficiarioDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarbeneficiarioDetalleChequeGirado() {
		return this.mostrarbeneficiarioDetalleChequeGirado;
	}

	public void setMostrarbeneficiarioDetalleChequeGirado(Boolean mostrarbeneficiarioDetalleChequeGirado) {
		this.mostrarbeneficiarioDetalleChequeGirado= mostrarbeneficiarioDetalleChequeGirado;
	}

	public Boolean getActivarbeneficiarioDetalleChequeGirado() {
		return this.activarbeneficiarioDetalleChequeGirado;
	}

	public void setActivarbeneficiarioDetalleChequeGirado(Boolean activarbeneficiarioDetalleChequeGirado) {
		this.activarbeneficiarioDetalleChequeGirado= activarbeneficiarioDetalleChequeGirado;
	}

	public Border setResaltarcodigoDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarcodigoDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoDetalleChequeGirado() {
		return this.resaltarcodigoDetalleChequeGirado;
	}

	public void setResaltarcodigoDetalleChequeGirado(Border borderResaltar) {
		this.resaltarcodigoDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarcodigoDetalleChequeGirado() {
		return this.mostrarcodigoDetalleChequeGirado;
	}

	public void setMostrarcodigoDetalleChequeGirado(Boolean mostrarcodigoDetalleChequeGirado) {
		this.mostrarcodigoDetalleChequeGirado= mostrarcodigoDetalleChequeGirado;
	}

	public Boolean getActivarcodigoDetalleChequeGirado() {
		return this.activarcodigoDetalleChequeGirado;
	}

	public void setActivarcodigoDetalleChequeGirado(Boolean activarcodigoDetalleChequeGirado) {
		this.activarcodigoDetalleChequeGirado= activarcodigoDetalleChequeGirado;
	}

	public Border setResaltarnombre_bancoDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarnombre_bancoDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bancoDetalleChequeGirado() {
		return this.resaltarnombre_bancoDetalleChequeGirado;
	}

	public void setResaltarnombre_bancoDetalleChequeGirado(Border borderResaltar) {
		this.resaltarnombre_bancoDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarnombre_bancoDetalleChequeGirado() {
		return this.mostrarnombre_bancoDetalleChequeGirado;
	}

	public void setMostrarnombre_bancoDetalleChequeGirado(Boolean mostrarnombre_bancoDetalleChequeGirado) {
		this.mostrarnombre_bancoDetalleChequeGirado= mostrarnombre_bancoDetalleChequeGirado;
	}

	public Boolean getActivarnombre_bancoDetalleChequeGirado() {
		return this.activarnombre_bancoDetalleChequeGirado;
	}

	public void setActivarnombre_bancoDetalleChequeGirado(Boolean activarnombre_bancoDetalleChequeGirado) {
		this.activarnombre_bancoDetalleChequeGirado= activarnombre_bancoDetalleChequeGirado;
	}

	public Border setResaltarid_anioDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarid_anioDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleChequeGirado() {
		return this.resaltarid_anioDetalleChequeGirado;
	}

	public void setResaltarid_anioDetalleChequeGirado(Border borderResaltar) {
		this.resaltarid_anioDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleChequeGirado() {
		return this.mostrarid_anioDetalleChequeGirado;
	}

	public void setMostrarid_anioDetalleChequeGirado(Boolean mostrarid_anioDetalleChequeGirado) {
		this.mostrarid_anioDetalleChequeGirado= mostrarid_anioDetalleChequeGirado;
	}

	public Boolean getActivarid_anioDetalleChequeGirado() {
		return this.activarid_anioDetalleChequeGirado;
	}

	public void setActivarid_anioDetalleChequeGirado(Boolean activarid_anioDetalleChequeGirado) {
		this.activarid_anioDetalleChequeGirado= activarid_anioDetalleChequeGirado;
	}

	public Boolean getCargarid_anioDetalleChequeGirado() {
		return this.cargarid_anioDetalleChequeGirado;
	}

	public void setCargarid_anioDetalleChequeGirado(Boolean cargarid_anioDetalleChequeGirado) {
		this.cargarid_anioDetalleChequeGirado= cargarid_anioDetalleChequeGirado;
	}

	public Border setResaltarid_mesDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallechequegiradoBeanSwingJInternalFrame.jTtoolBarDetalleChequeGirado.setBorder(borderResaltar);
		
		this.resaltarid_mesDetalleChequeGirado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleChequeGirado() {
		return this.resaltarid_mesDetalleChequeGirado;
	}

	public void setResaltarid_mesDetalleChequeGirado(Border borderResaltar) {
		this.resaltarid_mesDetalleChequeGirado= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleChequeGirado() {
		return this.mostrarid_mesDetalleChequeGirado;
	}

	public void setMostrarid_mesDetalleChequeGirado(Boolean mostrarid_mesDetalleChequeGirado) {
		this.mostrarid_mesDetalleChequeGirado= mostrarid_mesDetalleChequeGirado;
	}

	public Boolean getActivarid_mesDetalleChequeGirado() {
		return this.activarid_mesDetalleChequeGirado;
	}

	public void setActivarid_mesDetalleChequeGirado(Boolean activarid_mesDetalleChequeGirado) {
		this.activarid_mesDetalleChequeGirado= activarid_mesDetalleChequeGirado;
	}

	public Boolean getCargarid_mesDetalleChequeGirado() {
		return this.cargarid_mesDetalleChequeGirado;
	}

	public void setCargarid_mesDetalleChequeGirado(Boolean cargarid_mesDetalleChequeGirado) {
		this.cargarid_mesDetalleChequeGirado= cargarid_mesDetalleChequeGirado;
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
		
		
		this.setMostraridDetalleChequeGirado(esInicial);
		this.setMostrarid_empresaDetalleChequeGirado(esInicial);
		this.setMostrarid_sucursalDetalleChequeGirado(esInicial);
		this.setMostrarid_ejercicioDetalleChequeGirado(esInicial);
		this.setMostrarid_periodoDetalleChequeGirado(esInicial);
		this.setMostrarid_asiento_contableDetalleChequeGirado(esInicial);
		this.setMostrarid_empleadoDetalleChequeGirado(esInicial);
		this.setMostrarid_cuenta_bancoDetalleChequeGirado(esInicial);
		this.setMostrarnumero_chequeDetalleChequeGirado(esInicial);
		this.setMostrarvalorDetalleChequeGirado(esInicial);
		this.setMostrarcuentaDetalleChequeGirado(esInicial);
		this.setMostrarfechaDetalleChequeGirado(esInicial);
		this.setMostrarconDetalleChequeGirado(esInicial);
		this.setMostrarbeneficiarioDetalleChequeGirado(esInicial);
		this.setMostrarcodigoDetalleChequeGirado(esInicial);
		this.setMostrarnombre_bancoDetalleChequeGirado(esInicial);
		this.setMostrarid_anioDetalleChequeGirado(esInicial);
		this.setMostrarid_mesDetalleChequeGirado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.ID)) {
				this.setMostraridDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDCUENTABANCO)) {
				this.setMostrarid_cuenta_bancoDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.NUMEROCHEQUE)) {
				this.setMostrarnumero_chequeDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.VALOR)) {
				this.setMostrarvalorDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.CUENTA)) {
				this.setMostrarcuentaDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.FECHA)) {
				this.setMostrarfechaDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.CON)) {
				this.setMostrarconDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.BENEFICIARIO)) {
				this.setMostrarbeneficiarioDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.NOMBREBANCO)) {
				this.setMostrarnombre_bancoDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleChequeGirado(esAsigna);
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
		
		
		this.setActivaridDetalleChequeGirado(esInicial);
		this.setActivarid_empresaDetalleChequeGirado(esInicial);
		this.setActivarid_sucursalDetalleChequeGirado(esInicial);
		this.setActivarid_ejercicioDetalleChequeGirado(esInicial);
		this.setActivarid_periodoDetalleChequeGirado(esInicial);
		this.setActivarid_asiento_contableDetalleChequeGirado(esInicial);
		this.setActivarid_empleadoDetalleChequeGirado(esInicial);
		this.setActivarid_cuenta_bancoDetalleChequeGirado(esInicial);
		this.setActivarnumero_chequeDetalleChequeGirado(esInicial);
		this.setActivarvalorDetalleChequeGirado(esInicial);
		this.setActivarcuentaDetalleChequeGirado(esInicial);
		this.setActivarfechaDetalleChequeGirado(esInicial);
		this.setActivarconDetalleChequeGirado(esInicial);
		this.setActivarbeneficiarioDetalleChequeGirado(esInicial);
		this.setActivarcodigoDetalleChequeGirado(esInicial);
		this.setActivarnombre_bancoDetalleChequeGirado(esInicial);
		this.setActivarid_anioDetalleChequeGirado(esInicial);
		this.setActivarid_mesDetalleChequeGirado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.ID)) {
				this.setActivaridDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDCUENTABANCO)) {
				this.setActivarid_cuenta_bancoDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.NUMEROCHEQUE)) {
				this.setActivarnumero_chequeDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.VALOR)) {
				this.setActivarvalorDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.CUENTA)) {
				this.setActivarcuentaDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.FECHA)) {
				this.setActivarfechaDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.CON)) {
				this.setActivarconDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.BENEFICIARIO)) {
				this.setActivarbeneficiarioDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.NOMBREBANCO)) {
				this.setActivarnombre_bancoDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleChequeGirado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleChequeGirado(esInicial);
		this.setResaltarid_empresaDetalleChequeGirado(esInicial);
		this.setResaltarid_sucursalDetalleChequeGirado(esInicial);
		this.setResaltarid_ejercicioDetalleChequeGirado(esInicial);
		this.setResaltarid_periodoDetalleChequeGirado(esInicial);
		this.setResaltarid_asiento_contableDetalleChequeGirado(esInicial);
		this.setResaltarid_empleadoDetalleChequeGirado(esInicial);
		this.setResaltarid_cuenta_bancoDetalleChequeGirado(esInicial);
		this.setResaltarnumero_chequeDetalleChequeGirado(esInicial);
		this.setResaltarvalorDetalleChequeGirado(esInicial);
		this.setResaltarcuentaDetalleChequeGirado(esInicial);
		this.setResaltarfechaDetalleChequeGirado(esInicial);
		this.setResaltarconDetalleChequeGirado(esInicial);
		this.setResaltarbeneficiarioDetalleChequeGirado(esInicial);
		this.setResaltarcodigoDetalleChequeGirado(esInicial);
		this.setResaltarnombre_bancoDetalleChequeGirado(esInicial);
		this.setResaltarid_anioDetalleChequeGirado(esInicial);
		this.setResaltarid_mesDetalleChequeGirado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.ID)) {
				this.setResaltaridDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDCUENTABANCO)) {
				this.setResaltarid_cuenta_bancoDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.NUMEROCHEQUE)) {
				this.setResaltarnumero_chequeDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.VALOR)) {
				this.setResaltarvalorDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.CUENTA)) {
				this.setResaltarcuentaDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.FECHA)) {
				this.setResaltarfechaDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.CON)) {
				this.setResaltarconDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.BENEFICIARIO)) {
				this.setResaltarbeneficiarioDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.NOMBREBANCO)) {
				this.setResaltarnombre_bancoDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleChequeGirado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleChequeGiradoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleChequeGirado(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableDetalleChequeGirado=true;

	public Boolean getMostrarFK_IdAsientoContableDetalleChequeGirado() {
		return this.mostrarFK_IdAsientoContableDetalleChequeGirado;
	}

	public void setMostrarFK_IdAsientoContableDetalleChequeGirado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableDetalleChequeGirado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaBancoDetalleChequeGirado=true;

	public Boolean getMostrarFK_IdCuentaBancoDetalleChequeGirado() {
		return this.mostrarFK_IdCuentaBancoDetalleChequeGirado;
	}

	public void setMostrarFK_IdCuentaBancoDetalleChequeGirado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaBancoDetalleChequeGirado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleChequeGirado=true;

	public Boolean getMostrarFK_IdEjercicioDetalleChequeGirado() {
		return this.mostrarFK_IdEjercicioDetalleChequeGirado;
	}

	public void setMostrarFK_IdEjercicioDetalleChequeGirado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleChequeGirado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoDetalleChequeGirado=true;

	public Boolean getMostrarFK_IdEmpleadoDetalleChequeGirado() {
		return this.mostrarFK_IdEmpleadoDetalleChequeGirado;
	}

	public void setMostrarFK_IdEmpleadoDetalleChequeGirado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoDetalleChequeGirado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleChequeGirado=true;

	public Boolean getMostrarFK_IdEmpresaDetalleChequeGirado() {
		return this.mostrarFK_IdEmpresaDetalleChequeGirado;
	}

	public void setMostrarFK_IdEmpresaDetalleChequeGirado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleChequeGirado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleChequeGirado=true;

	public Boolean getMostrarFK_IdPeriodoDetalleChequeGirado() {
		return this.mostrarFK_IdPeriodoDetalleChequeGirado;
	}

	public void setMostrarFK_IdPeriodoDetalleChequeGirado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleChequeGirado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleChequeGirado=true;

	public Boolean getMostrarFK_IdSucursalDetalleChequeGirado() {
		return this.mostrarFK_IdSucursalDetalleChequeGirado;
	}

	public void setMostrarFK_IdSucursalDetalleChequeGirado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleChequeGirado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableDetalleChequeGirado=true;

	public Boolean getActivarFK_IdAsientoContableDetalleChequeGirado() {
		return this.activarFK_IdAsientoContableDetalleChequeGirado;
	}

	public void setActivarFK_IdAsientoContableDetalleChequeGirado(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableDetalleChequeGirado= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaBancoDetalleChequeGirado=true;

	public Boolean getActivarFK_IdCuentaBancoDetalleChequeGirado() {
		return this.activarFK_IdCuentaBancoDetalleChequeGirado;
	}

	public void setActivarFK_IdCuentaBancoDetalleChequeGirado(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaBancoDetalleChequeGirado= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleChequeGirado=true;

	public Boolean getActivarFK_IdEjercicioDetalleChequeGirado() {
		return this.activarFK_IdEjercicioDetalleChequeGirado;
	}

	public void setActivarFK_IdEjercicioDetalleChequeGirado(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleChequeGirado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoDetalleChequeGirado=true;

	public Boolean getActivarFK_IdEmpleadoDetalleChequeGirado() {
		return this.activarFK_IdEmpleadoDetalleChequeGirado;
	}

	public void setActivarFK_IdEmpleadoDetalleChequeGirado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoDetalleChequeGirado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleChequeGirado=true;

	public Boolean getActivarFK_IdEmpresaDetalleChequeGirado() {
		return this.activarFK_IdEmpresaDetalleChequeGirado;
	}

	public void setActivarFK_IdEmpresaDetalleChequeGirado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleChequeGirado= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleChequeGirado=true;

	public Boolean getActivarFK_IdPeriodoDetalleChequeGirado() {
		return this.activarFK_IdPeriodoDetalleChequeGirado;
	}

	public void setActivarFK_IdPeriodoDetalleChequeGirado(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleChequeGirado= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleChequeGirado=true;

	public Boolean getActivarFK_IdSucursalDetalleChequeGirado() {
		return this.activarFK_IdSucursalDetalleChequeGirado;
	}

	public void setActivarFK_IdSucursalDetalleChequeGirado(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleChequeGirado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableDetalleChequeGirado=null;

	public Border getResaltarFK_IdAsientoContableDetalleChequeGirado() {
		return this.resaltarFK_IdAsientoContableDetalleChequeGirado;
	}

	public void setResaltarFK_IdAsientoContableDetalleChequeGirado(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableDetalleChequeGirado= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableDetalleChequeGirado= borderResaltar;
	}

	public Border resaltarFK_IdCuentaBancoDetalleChequeGirado=null;

	public Border getResaltarFK_IdCuentaBancoDetalleChequeGirado() {
		return this.resaltarFK_IdCuentaBancoDetalleChequeGirado;
	}

	public void setResaltarFK_IdCuentaBancoDetalleChequeGirado(Border borderResaltar) {
		this.resaltarFK_IdCuentaBancoDetalleChequeGirado= borderResaltar;
	}

	public void setResaltarFK_IdCuentaBancoDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaBancoDetalleChequeGirado= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleChequeGirado=null;

	public Border getResaltarFK_IdEjercicioDetalleChequeGirado() {
		return this.resaltarFK_IdEjercicioDetalleChequeGirado;
	}

	public void setResaltarFK_IdEjercicioDetalleChequeGirado(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleChequeGirado= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleChequeGirado= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoDetalleChequeGirado=null;

	public Border getResaltarFK_IdEmpleadoDetalleChequeGirado() {
		return this.resaltarFK_IdEmpleadoDetalleChequeGirado;
	}

	public void setResaltarFK_IdEmpleadoDetalleChequeGirado(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoDetalleChequeGirado= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoDetalleChequeGirado= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleChequeGirado=null;

	public Border getResaltarFK_IdEmpresaDetalleChequeGirado() {
		return this.resaltarFK_IdEmpresaDetalleChequeGirado;
	}

	public void setResaltarFK_IdEmpresaDetalleChequeGirado(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleChequeGirado= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleChequeGirado= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleChequeGirado=null;

	public Border getResaltarFK_IdPeriodoDetalleChequeGirado() {
		return this.resaltarFK_IdPeriodoDetalleChequeGirado;
	}

	public void setResaltarFK_IdPeriodoDetalleChequeGirado(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleChequeGirado= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleChequeGirado= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleChequeGirado=null;

	public Border getResaltarFK_IdSucursalDetalleChequeGirado() {
		return this.resaltarFK_IdSucursalDetalleChequeGirado;
	}

	public void setResaltarFK_IdSucursalDetalleChequeGirado(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleChequeGirado= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleChequeGirado(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleChequeGiradoBeanSwingJInternalFrame detallechequegiradoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleChequeGirado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
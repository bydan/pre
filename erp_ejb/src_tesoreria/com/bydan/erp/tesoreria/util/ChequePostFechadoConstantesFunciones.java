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


import com.bydan.erp.tesoreria.util.ChequePostFechadoConstantesFunciones;
import com.bydan.erp.tesoreria.util.ChequePostFechadoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.ChequePostFechadoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ChequePostFechadoConstantesFunciones extends ChequePostFechadoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ChequePostFechado";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ChequePostFechado"+ChequePostFechadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ChequePostFechadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ChequePostFechadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ChequePostFechadoConstantesFunciones.SCHEMA+"_"+ChequePostFechadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ChequePostFechadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ChequePostFechadoConstantesFunciones.SCHEMA+"_"+ChequePostFechadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ChequePostFechadoConstantesFunciones.SCHEMA+"_"+ChequePostFechadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ChequePostFechadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ChequePostFechadoConstantesFunciones.SCHEMA+"_"+ChequePostFechadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ChequePostFechadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ChequePostFechadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ChequePostFechadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ChequePostFechadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ChequePostFechadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ChequePostFechadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ChequePostFechadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ChequePostFechadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ChequePostFechadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ChequePostFechadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cheque Post Fechados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Cheque Post Fechado";
	public static final String SCLASSWEBTITULO_LOWER="Cheque Post Fechado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ChequePostFechado";
	public static final String OBJECTNAME="chequepostfechado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="cheque_post_fechado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select chequepostfechado from "+ChequePostFechadoConstantesFunciones.SPERSISTENCENAME+" chequepostfechado";
	public static String QUERYSELECTNATIVE="select "+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".id,"+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".version_row,"+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".id_empresa,"+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".id_sucursal,"+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".id_cliente,"+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".id_asiento_contable,"+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".id_ejercicio,"+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".id_periodo,"+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".id_tipo_forma_pago,"+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".nombre_gira,"+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".fecha_vencimiento,"+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".fecha_vencimiento_original,"+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".numero,"+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".numero_cheque,"+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".descripcion,"+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".id_anio,"+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME+".id_mes from "+ChequePostFechadoConstantesFunciones.SCHEMA+"."+ChequePostFechadoConstantesFunciones.TABLENAME;//+" as "+ChequePostFechadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ChequePostFechadoConstantesFuncionesAdditional chequepostfechadoConstantesFuncionesAdditional=null;
	
	public ChequePostFechadoConstantesFuncionesAdditional getChequePostFechadoConstantesFuncionesAdditional() {
		return this.chequepostfechadoConstantesFuncionesAdditional;
	}
	
	public void setChequePostFechadoConstantesFuncionesAdditional(ChequePostFechadoConstantesFuncionesAdditional chequepostfechadoConstantesFuncionesAdditional) {
		try {
			this.chequepostfechadoConstantesFuncionesAdditional=chequepostfechadoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDTIPOFORMAPAGO= "id_tipo_forma_pago";
    public static final String NOMBREGIRA= "nombre_gira";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String FECHAVENCIMIENTOORIGINAL= "fecha_vencimiento_original";
    public static final String NUMERO= "numero";
    public static final String NUMEROCHEQUE= "numero_cheque";
    public static final String DESCRIPCION= "descripcion";
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
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDTIPOFORMAPAGO= "Tipo Forma Pago";
		public static final String LABEL_IDTIPOFORMAPAGO_LOWER= "Tipo Forma Pago";
    	public static final String LABEL_NOMBREGIRA= "Nombre Gira";
		public static final String LABEL_NOMBREGIRA_LOWER= "Nombre Gira";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_FECHAVENCIMIENTOORIGINAL= "Fecha Vencimiento Original";
		public static final String LABEL_FECHAVENCIMIENTOORIGINAL_LOWER= "Fecha Vencimiento Original";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_NUMEROCHEQUE= "Numero Cheque";
		public static final String LABEL_NUMEROCHEQUE_LOWER= "Numero Cheque";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_GIRA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_GIRA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CHEQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHEQUE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getChequePostFechadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ChequePostFechadoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ChequePostFechadoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ChequePostFechadoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ChequePostFechadoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ChequePostFechadoConstantesFunciones.IDCLIENTE)) {sLabelColumna=ChequePostFechadoConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ChequePostFechadoConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=ChequePostFechadoConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(ChequePostFechadoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ChequePostFechadoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ChequePostFechadoConstantesFunciones.IDPERIODO)) {sLabelColumna=ChequePostFechadoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(ChequePostFechadoConstantesFunciones.IDTIPOFORMAPAGO)) {sLabelColumna=ChequePostFechadoConstantesFunciones.LABEL_IDTIPOFORMAPAGO;}
		if(sNombreColumna.equals(ChequePostFechadoConstantesFunciones.NOMBREGIRA)) {sLabelColumna=ChequePostFechadoConstantesFunciones.LABEL_NOMBREGIRA;}
		if(sNombreColumna.equals(ChequePostFechadoConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=ChequePostFechadoConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(ChequePostFechadoConstantesFunciones.FECHAVENCIMIENTOORIGINAL)) {sLabelColumna=ChequePostFechadoConstantesFunciones.LABEL_FECHAVENCIMIENTOORIGINAL;}
		if(sNombreColumna.equals(ChequePostFechadoConstantesFunciones.NUMERO)) {sLabelColumna=ChequePostFechadoConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(ChequePostFechadoConstantesFunciones.NUMEROCHEQUE)) {sLabelColumna=ChequePostFechadoConstantesFunciones.LABEL_NUMEROCHEQUE;}
		if(sNombreColumna.equals(ChequePostFechadoConstantesFunciones.DESCRIPCION)) {sLabelColumna=ChequePostFechadoConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(ChequePostFechadoConstantesFunciones.IDANIO)) {sLabelColumna=ChequePostFechadoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(ChequePostFechadoConstantesFunciones.IDMES)) {sLabelColumna=ChequePostFechadoConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getChequePostFechadoDescripcion(ChequePostFechado chequepostfechado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(chequepostfechado !=null/* && chequepostfechado.getId()!=0*/) {
			if(chequepostfechado.getId()!=null) {
				sDescripcion=chequepostfechado.getId().toString();
			}//chequepostfechadochequepostfechado.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getChequePostFechadoDescripcionDetallado(ChequePostFechado chequepostfechado) {
		String sDescripcion="";
			
		sDescripcion+=ChequePostFechadoConstantesFunciones.ID+"=";
		sDescripcion+=chequepostfechado.getId().toString()+",";
		sDescripcion+=ChequePostFechadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=chequepostfechado.getVersionRow().toString()+",";
		sDescripcion+=ChequePostFechadoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=chequepostfechado.getid_empresa().toString()+",";
		sDescripcion+=ChequePostFechadoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=chequepostfechado.getid_sucursal().toString()+",";
		sDescripcion+=ChequePostFechadoConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=chequepostfechado.getid_cliente().toString()+",";
		sDescripcion+=ChequePostFechadoConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=chequepostfechado.getid_asiento_contable().toString()+",";
		sDescripcion+=ChequePostFechadoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=chequepostfechado.getid_ejercicio().toString()+",";
		sDescripcion+=ChequePostFechadoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=chequepostfechado.getid_periodo().toString()+",";
		sDescripcion+=ChequePostFechadoConstantesFunciones.IDTIPOFORMAPAGO+"=";
		sDescripcion+=chequepostfechado.getid_tipo_forma_pago().toString()+",";
		sDescripcion+=ChequePostFechadoConstantesFunciones.NOMBREGIRA+"=";
		sDescripcion+=chequepostfechado.getnombre_gira()+",";
		sDescripcion+=ChequePostFechadoConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=chequepostfechado.getfecha_vencimiento().toString()+",";
		sDescripcion+=ChequePostFechadoConstantesFunciones.FECHAVENCIMIENTOORIGINAL+"=";
		sDescripcion+=chequepostfechado.getfecha_vencimiento_original().toString()+",";
		sDescripcion+=ChequePostFechadoConstantesFunciones.NUMERO+"=";
		sDescripcion+=chequepostfechado.getnumero()+",";
		sDescripcion+=ChequePostFechadoConstantesFunciones.NUMEROCHEQUE+"=";
		sDescripcion+=chequepostfechado.getnumero_cheque()+",";
		sDescripcion+=ChequePostFechadoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=chequepostfechado.getdescripcion()+",";
		sDescripcion+=ChequePostFechadoConstantesFunciones.IDANIO+"=";
		sDescripcion+=chequepostfechado.getid_anio().toString()+",";
		sDescripcion+=ChequePostFechadoConstantesFunciones.IDMES+"=";
		sDescripcion+=chequepostfechado.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setChequePostFechadoDescripcion(ChequePostFechado chequepostfechado,String sValor) throws Exception {			
		if(chequepostfechado !=null) {
			//chequepostfechadochequepostfechado.getId().toString();
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
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
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
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

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosChequePostFechado(ChequePostFechado chequepostfechado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		chequepostfechado.setnombre_gira(chequepostfechado.getnombre_gira().trim());
		chequepostfechado.setnumero(chequepostfechado.getnumero().trim());
		chequepostfechado.setnumero_cheque(chequepostfechado.getnumero_cheque().trim());
		chequepostfechado.setdescripcion(chequepostfechado.getdescripcion().trim());
	}
	
	public static void quitarEspaciosChequePostFechados(List<ChequePostFechado> chequepostfechados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ChequePostFechado chequepostfechado: chequepostfechados) {
			chequepostfechado.setnombre_gira(chequepostfechado.getnombre_gira().trim());
			chequepostfechado.setnumero(chequepostfechado.getnumero().trim());
			chequepostfechado.setnumero_cheque(chequepostfechado.getnumero_cheque().trim());
			chequepostfechado.setdescripcion(chequepostfechado.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresChequePostFechado(ChequePostFechado chequepostfechado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && chequepostfechado.getConCambioAuxiliar()) {
			chequepostfechado.setIsDeleted(chequepostfechado.getIsDeletedAuxiliar());	
			chequepostfechado.setIsNew(chequepostfechado.getIsNewAuxiliar());	
			chequepostfechado.setIsChanged(chequepostfechado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			chequepostfechado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			chequepostfechado.setIsDeletedAuxiliar(false);	
			chequepostfechado.setIsNewAuxiliar(false);	
			chequepostfechado.setIsChangedAuxiliar(false);
			
			chequepostfechado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresChequePostFechados(List<ChequePostFechado> chequepostfechados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ChequePostFechado chequepostfechado : chequepostfechados) {
			if(conAsignarBase && chequepostfechado.getConCambioAuxiliar()) {
				chequepostfechado.setIsDeleted(chequepostfechado.getIsDeletedAuxiliar());	
				chequepostfechado.setIsNew(chequepostfechado.getIsNewAuxiliar());	
				chequepostfechado.setIsChanged(chequepostfechado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				chequepostfechado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				chequepostfechado.setIsDeletedAuxiliar(false);	
				chequepostfechado.setIsNewAuxiliar(false);	
				chequepostfechado.setIsChangedAuxiliar(false);
				
				chequepostfechado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresChequePostFechado(ChequePostFechado chequepostfechado,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresChequePostFechados(List<ChequePostFechado> chequepostfechados,Boolean conEnteros) throws Exception  {
		
		for(ChequePostFechado chequepostfechado: chequepostfechados) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaChequePostFechado(List<ChequePostFechado> chequepostfechados,ChequePostFechado chequepostfechadoAux) throws Exception  {
		ChequePostFechadoConstantesFunciones.InicializarValoresChequePostFechado(chequepostfechadoAux,true);
		
		for(ChequePostFechado chequepostfechado: chequepostfechados) {
			if(chequepostfechado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesChequePostFechado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ChequePostFechadoConstantesFunciones.getArrayColumnasGlobalesChequePostFechado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesChequePostFechado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ChequePostFechadoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ChequePostFechadoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ChequePostFechadoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ChequePostFechadoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ChequePostFechadoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ChequePostFechadoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ChequePostFechadoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ChequePostFechadoConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoChequePostFechado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ChequePostFechado> chequepostfechados,ChequePostFechado chequepostfechado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ChequePostFechado chequepostfechadoAux: chequepostfechados) {
			if(chequepostfechadoAux!=null && chequepostfechado!=null) {
				if((chequepostfechadoAux.getId()==null && chequepostfechado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(chequepostfechadoAux.getId()!=null && chequepostfechado.getId()!=null){
					if(chequepostfechadoAux.getId().equals(chequepostfechado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaChequePostFechado(List<ChequePostFechado> chequepostfechados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ChequePostFechado chequepostfechado: chequepostfechados) {			
			if(chequepostfechado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaChequePostFechado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_ID, ChequePostFechadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_VERSIONROW, ChequePostFechadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_IDEMPRESA, ChequePostFechadoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_IDSUCURSAL, ChequePostFechadoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_IDCLIENTE, ChequePostFechadoConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_IDASIENTOCONTABLE, ChequePostFechadoConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_IDEJERCICIO, ChequePostFechadoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_IDPERIODO, ChequePostFechadoConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_IDTIPOFORMAPAGO, ChequePostFechadoConstantesFunciones.IDTIPOFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_NOMBREGIRA, ChequePostFechadoConstantesFunciones.NOMBREGIRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_FECHAVENCIMIENTO, ChequePostFechadoConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_FECHAVENCIMIENTOORIGINAL, ChequePostFechadoConstantesFunciones.FECHAVENCIMIENTOORIGINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_NUMERO, ChequePostFechadoConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_NUMEROCHEQUE, ChequePostFechadoConstantesFunciones.NUMEROCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_DESCRIPCION, ChequePostFechadoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_IDANIO, ChequePostFechadoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequePostFechadoConstantesFunciones.LABEL_IDMES, ChequePostFechadoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasChequePostFechado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.IDTIPOFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.NOMBREGIRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.FECHAVENCIMIENTOORIGINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.NUMEROCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequePostFechadoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarChequePostFechado() throws Exception  {
		return ChequePostFechadoConstantesFunciones.getTiposSeleccionarChequePostFechado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarChequePostFechado(Boolean conFk) throws Exception  {
		return ChequePostFechadoConstantesFunciones.getTiposSeleccionarChequePostFechado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarChequePostFechado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequePostFechadoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ChequePostFechadoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequePostFechadoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ChequePostFechadoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequePostFechadoConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ChequePostFechadoConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequePostFechadoConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(ChequePostFechadoConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequePostFechadoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ChequePostFechadoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequePostFechadoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(ChequePostFechadoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequePostFechadoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
			reporte.setsDescripcion(ChequePostFechadoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequePostFechadoConstantesFunciones.LABEL_NOMBREGIRA);
			reporte.setsDescripcion(ChequePostFechadoConstantesFunciones.LABEL_NOMBREGIRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequePostFechadoConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(ChequePostFechadoConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequePostFechadoConstantesFunciones.LABEL_FECHAVENCIMIENTOORIGINAL);
			reporte.setsDescripcion(ChequePostFechadoConstantesFunciones.LABEL_FECHAVENCIMIENTOORIGINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequePostFechadoConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(ChequePostFechadoConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequePostFechadoConstantesFunciones.LABEL_NUMEROCHEQUE);
			reporte.setsDescripcion(ChequePostFechadoConstantesFunciones.LABEL_NUMEROCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequePostFechadoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ChequePostFechadoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequePostFechadoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(ChequePostFechadoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequePostFechadoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(ChequePostFechadoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesChequePostFechado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesChequePostFechado(ChequePostFechado chequepostfechadoAux) throws Exception {
		
			chequepostfechadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(chequepostfechadoAux.getEmpresa()));
			chequepostfechadoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(chequepostfechadoAux.getSucursal()));
			chequepostfechadoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(chequepostfechadoAux.getCliente()));
			chequepostfechadoAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(chequepostfechadoAux.getAsientoContable()));
			chequepostfechadoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(chequepostfechadoAux.getEjercicio()));
			chequepostfechadoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(chequepostfechadoAux.getPeriodo()));
			chequepostfechadoAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(chequepostfechadoAux.getTipoFormaPago()));
			chequepostfechadoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(chequepostfechadoAux.getAnio()));
			chequepostfechadoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(chequepostfechadoAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesChequePostFechado(List<ChequePostFechado> chequepostfechadosTemp) throws Exception {
		for(ChequePostFechado chequepostfechadoAux:chequepostfechadosTemp) {
			
			chequepostfechadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(chequepostfechadoAux.getEmpresa()));
			chequepostfechadoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(chequepostfechadoAux.getSucursal()));
			chequepostfechadoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(chequepostfechadoAux.getCliente()));
			chequepostfechadoAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(chequepostfechadoAux.getAsientoContable()));
			chequepostfechadoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(chequepostfechadoAux.getEjercicio()));
			chequepostfechadoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(chequepostfechadoAux.getPeriodo()));
			chequepostfechadoAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(chequepostfechadoAux.getTipoFormaPago()));
			chequepostfechadoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(chequepostfechadoAux.getAnio()));
			chequepostfechadoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(chequepostfechadoAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfChequePostFechado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(TipoFormaPago.class));
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
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfChequePostFechado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfChequePostFechado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ChequePostFechadoConstantesFunciones.getClassesRelationshipsOfChequePostFechado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfChequePostFechado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfChequePostFechado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ChequePostFechadoConstantesFunciones.getClassesRelationshipsFromStringsOfChequePostFechado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfChequePostFechado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ChequePostFechado chequepostfechado,List<ChequePostFechado> chequepostfechados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ChequePostFechado chequepostfechadoEncontrado=null;
			
			for(ChequePostFechado chequepostfechadoLocal:chequepostfechados) {
				if(chequepostfechadoLocal.getId().equals(chequepostfechado.getId())) {
					chequepostfechadoEncontrado=chequepostfechadoLocal;
					
					chequepostfechadoLocal.setIsChanged(chequepostfechado.getIsChanged());
					chequepostfechadoLocal.setIsNew(chequepostfechado.getIsNew());
					chequepostfechadoLocal.setIsDeleted(chequepostfechado.getIsDeleted());
					
					chequepostfechadoLocal.setGeneralEntityOriginal(chequepostfechado.getGeneralEntityOriginal());
					
					chequepostfechadoLocal.setId(chequepostfechado.getId());	
					chequepostfechadoLocal.setVersionRow(chequepostfechado.getVersionRow());	
					chequepostfechadoLocal.setid_empresa(chequepostfechado.getid_empresa());	
					chequepostfechadoLocal.setid_sucursal(chequepostfechado.getid_sucursal());	
					chequepostfechadoLocal.setid_cliente(chequepostfechado.getid_cliente());	
					chequepostfechadoLocal.setid_asiento_contable(chequepostfechado.getid_asiento_contable());	
					chequepostfechadoLocal.setid_ejercicio(chequepostfechado.getid_ejercicio());	
					chequepostfechadoLocal.setid_periodo(chequepostfechado.getid_periodo());	
					chequepostfechadoLocal.setid_tipo_forma_pago(chequepostfechado.getid_tipo_forma_pago());	
					chequepostfechadoLocal.setnombre_gira(chequepostfechado.getnombre_gira());	
					chequepostfechadoLocal.setfecha_vencimiento(chequepostfechado.getfecha_vencimiento());	
					chequepostfechadoLocal.setfecha_vencimiento_original(chequepostfechado.getfecha_vencimiento_original());	
					chequepostfechadoLocal.setnumero(chequepostfechado.getnumero());	
					chequepostfechadoLocal.setnumero_cheque(chequepostfechado.getnumero_cheque());	
					chequepostfechadoLocal.setdescripcion(chequepostfechado.getdescripcion());	
					chequepostfechadoLocal.setid_anio(chequepostfechado.getid_anio());	
					chequepostfechadoLocal.setid_mes(chequepostfechado.getid_mes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!chequepostfechado.getIsDeleted()) {
				if(!existe) {
					chequepostfechados.add(chequepostfechado);
				}
			} else {
				if(chequepostfechadoEncontrado!=null && permiteQuitar)  {
					chequepostfechados.remove(chequepostfechadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ChequePostFechado chequepostfechado,List<ChequePostFechado> chequepostfechados) throws Exception {
		try	{			
			for(ChequePostFechado chequepostfechadoLocal:chequepostfechados) {
				if(chequepostfechadoLocal.getId().equals(chequepostfechado.getId())) {
					chequepostfechadoLocal.setIsSelected(chequepostfechado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesChequePostFechado(List<ChequePostFechado> chequepostfechadosAux) throws Exception {
		//this.chequepostfechadosAux=chequepostfechadosAux;
		
		for(ChequePostFechado chequepostfechadoAux:chequepostfechadosAux) {
			if(chequepostfechadoAux.getIsChanged()) {
				chequepostfechadoAux.setIsChanged(false);
			}		
			
			if(chequepostfechadoAux.getIsNew()) {
				chequepostfechadoAux.setIsNew(false);
			}	
			
			if(chequepostfechadoAux.getIsDeleted()) {
				chequepostfechadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesChequePostFechado(ChequePostFechado chequepostfechadoAux) throws Exception {
		//this.chequepostfechadoAux=chequepostfechadoAux;
		
			if(chequepostfechadoAux.getIsChanged()) {
				chequepostfechadoAux.setIsChanged(false);
			}		
			
			if(chequepostfechadoAux.getIsNew()) {
				chequepostfechadoAux.setIsNew(false);
			}	
			
			if(chequepostfechadoAux.getIsDeleted()) {
				chequepostfechadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ChequePostFechado chequepostfechadoAsignar,ChequePostFechado chequepostfechado) throws Exception {
		chequepostfechadoAsignar.setId(chequepostfechado.getId());	
		chequepostfechadoAsignar.setVersionRow(chequepostfechado.getVersionRow());	
		chequepostfechadoAsignar.setid_empresa(chequepostfechado.getid_empresa());
		chequepostfechadoAsignar.setempresa_descripcion(chequepostfechado.getempresa_descripcion());	
		chequepostfechadoAsignar.setid_sucursal(chequepostfechado.getid_sucursal());
		chequepostfechadoAsignar.setsucursal_descripcion(chequepostfechado.getsucursal_descripcion());	
		chequepostfechadoAsignar.setid_cliente(chequepostfechado.getid_cliente());
		chequepostfechadoAsignar.setcliente_descripcion(chequepostfechado.getcliente_descripcion());	
		chequepostfechadoAsignar.setid_asiento_contable(chequepostfechado.getid_asiento_contable());
		chequepostfechadoAsignar.setasientocontable_descripcion(chequepostfechado.getasientocontable_descripcion());	
		chequepostfechadoAsignar.setid_ejercicio(chequepostfechado.getid_ejercicio());
		chequepostfechadoAsignar.setejercicio_descripcion(chequepostfechado.getejercicio_descripcion());	
		chequepostfechadoAsignar.setid_periodo(chequepostfechado.getid_periodo());
		chequepostfechadoAsignar.setperiodo_descripcion(chequepostfechado.getperiodo_descripcion());	
		chequepostfechadoAsignar.setid_tipo_forma_pago(chequepostfechado.getid_tipo_forma_pago());
		chequepostfechadoAsignar.settipoformapago_descripcion(chequepostfechado.gettipoformapago_descripcion());	
		chequepostfechadoAsignar.setnombre_gira(chequepostfechado.getnombre_gira());	
		chequepostfechadoAsignar.setfecha_vencimiento(chequepostfechado.getfecha_vencimiento());	
		chequepostfechadoAsignar.setfecha_vencimiento_original(chequepostfechado.getfecha_vencimiento_original());	
		chequepostfechadoAsignar.setnumero(chequepostfechado.getnumero());	
		chequepostfechadoAsignar.setnumero_cheque(chequepostfechado.getnumero_cheque());	
		chequepostfechadoAsignar.setdescripcion(chequepostfechado.getdescripcion());	
		chequepostfechadoAsignar.setid_anio(chequepostfechado.getid_anio());
		chequepostfechadoAsignar.setanio_descripcion(chequepostfechado.getanio_descripcion());	
		chequepostfechadoAsignar.setid_mes(chequepostfechado.getid_mes());
		chequepostfechadoAsignar.setmes_descripcion(chequepostfechado.getmes_descripcion());	
	}
	
	public static void inicializarChequePostFechado(ChequePostFechado chequepostfechado) throws Exception {
		try {
				chequepostfechado.setId(0L);	
					
				chequepostfechado.setid_empresa(-1L);	
				chequepostfechado.setid_sucursal(-1L);	
				chequepostfechado.setid_cliente(-1L);	
				chequepostfechado.setid_asiento_contable(-1L);	
				chequepostfechado.setid_ejercicio(-1L);	
				chequepostfechado.setid_periodo(-1L);	
				chequepostfechado.setid_tipo_forma_pago(-1L);	
				chequepostfechado.setnombre_gira("");	
				chequepostfechado.setfecha_vencimiento(new Date());	
				chequepostfechado.setfecha_vencimiento_original(new Date());	
				chequepostfechado.setnumero("");	
				chequepostfechado.setnumero_cheque("");	
				chequepostfechado.setdescripcion("");	
				chequepostfechado.setid_anio(null);	
				chequepostfechado.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderChequePostFechado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequePostFechadoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequePostFechadoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequePostFechadoConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequePostFechadoConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequePostFechadoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequePostFechadoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequePostFechadoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequePostFechadoConstantesFunciones.LABEL_NOMBREGIRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequePostFechadoConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequePostFechadoConstantesFunciones.LABEL_FECHAVENCIMIENTOORIGINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequePostFechadoConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequePostFechadoConstantesFunciones.LABEL_NUMEROCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequePostFechadoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequePostFechadoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequePostFechadoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataChequePostFechado(String sTipo,Row row,Workbook workbook,ChequePostFechado chequepostfechado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(chequepostfechado.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequepostfechado.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequepostfechado.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequepostfechado.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequepostfechado.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequepostfechado.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequepostfechado.gettipoformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequepostfechado.getnombre_gira());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequepostfechado.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequepostfechado.getfecha_vencimiento_original());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequepostfechado.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequepostfechado.getnumero_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequepostfechado.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequepostfechado.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequepostfechado.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryChequePostFechado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryChequePostFechado() {
		return this.sFinalQueryChequePostFechado;
	}
	
	public void setsFinalQueryChequePostFechado(String sFinalQueryChequePostFechado) {
		this.sFinalQueryChequePostFechado= sFinalQueryChequePostFechado;
	}
	
	public Border resaltarSeleccionarChequePostFechado=null;
	
	public Border setResaltarSeleccionarChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarChequePostFechado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarChequePostFechado() {
		return this.resaltarSeleccionarChequePostFechado;
	}
	
	public void setResaltarSeleccionarChequePostFechado(Border borderResaltarSeleccionarChequePostFechado) {
		this.resaltarSeleccionarChequePostFechado= borderResaltarSeleccionarChequePostFechado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridChequePostFechado=null;
	public Boolean mostraridChequePostFechado=true;
	public Boolean activaridChequePostFechado=true;

	public Border resaltarid_empresaChequePostFechado=null;
	public Boolean mostrarid_empresaChequePostFechado=true;
	public Boolean activarid_empresaChequePostFechado=true;
	public Boolean cargarid_empresaChequePostFechado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaChequePostFechado=false;//ConEventDepend=true

	public Border resaltarid_sucursalChequePostFechado=null;
	public Boolean mostrarid_sucursalChequePostFechado=true;
	public Boolean activarid_sucursalChequePostFechado=true;
	public Boolean cargarid_sucursalChequePostFechado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalChequePostFechado=false;//ConEventDepend=true

	public Border resaltarid_clienteChequePostFechado=null;
	public Boolean mostrarid_clienteChequePostFechado=true;
	public Boolean activarid_clienteChequePostFechado=true;
	public Boolean cargarid_clienteChequePostFechado=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteChequePostFechado=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableChequePostFechado=null;
	public Boolean mostrarid_asiento_contableChequePostFechado=true;
	public Boolean activarid_asiento_contableChequePostFechado=true;
	public Boolean cargarid_asiento_contableChequePostFechado=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableChequePostFechado=false;//ConEventDepend=true

	public Border resaltarid_ejercicioChequePostFechado=null;
	public Boolean mostrarid_ejercicioChequePostFechado=true;
	public Boolean activarid_ejercicioChequePostFechado=true;
	public Boolean cargarid_ejercicioChequePostFechado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioChequePostFechado=false;//ConEventDepend=true

	public Border resaltarid_periodoChequePostFechado=null;
	public Boolean mostrarid_periodoChequePostFechado=true;
	public Boolean activarid_periodoChequePostFechado=true;
	public Boolean cargarid_periodoChequePostFechado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoChequePostFechado=false;//ConEventDepend=true

	public Border resaltarid_tipo_forma_pagoChequePostFechado=null;
	public Boolean mostrarid_tipo_forma_pagoChequePostFechado=true;
	public Boolean activarid_tipo_forma_pagoChequePostFechado=true;
	public Boolean cargarid_tipo_forma_pagoChequePostFechado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_forma_pagoChequePostFechado=false;//ConEventDepend=true

	public Border resaltarnombre_giraChequePostFechado=null;
	public Boolean mostrarnombre_giraChequePostFechado=true;
	public Boolean activarnombre_giraChequePostFechado=true;

	public Border resaltarfecha_vencimientoChequePostFechado=null;
	public Boolean mostrarfecha_vencimientoChequePostFechado=true;
	public Boolean activarfecha_vencimientoChequePostFechado=false;

	public Border resaltarfecha_vencimiento_originalChequePostFechado=null;
	public Boolean mostrarfecha_vencimiento_originalChequePostFechado=true;
	public Boolean activarfecha_vencimiento_originalChequePostFechado=false;

	public Border resaltarnumeroChequePostFechado=null;
	public Boolean mostrarnumeroChequePostFechado=true;
	public Boolean activarnumeroChequePostFechado=true;

	public Border resaltarnumero_chequeChequePostFechado=null;
	public Boolean mostrarnumero_chequeChequePostFechado=true;
	public Boolean activarnumero_chequeChequePostFechado=true;

	public Border resaltardescripcionChequePostFechado=null;
	public Boolean mostrardescripcionChequePostFechado=true;
	public Boolean activardescripcionChequePostFechado=true;

	public Border resaltarid_anioChequePostFechado=null;
	public Boolean mostrarid_anioChequePostFechado=true;
	public Boolean activarid_anioChequePostFechado=false;
	public Boolean cargarid_anioChequePostFechado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioChequePostFechado=false;//ConEventDepend=true

	public Border resaltarid_mesChequePostFechado=null;
	public Boolean mostrarid_mesChequePostFechado=true;
	public Boolean activarid_mesChequePostFechado=false;
	public Boolean cargarid_mesChequePostFechado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesChequePostFechado=false;//ConEventDepend=true

	
	

	public Border setResaltaridChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltaridChequePostFechado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridChequePostFechado() {
		return this.resaltaridChequePostFechado;
	}

	public void setResaltaridChequePostFechado(Border borderResaltar) {
		this.resaltaridChequePostFechado= borderResaltar;
	}

	public Boolean getMostraridChequePostFechado() {
		return this.mostraridChequePostFechado;
	}

	public void setMostraridChequePostFechado(Boolean mostraridChequePostFechado) {
		this.mostraridChequePostFechado= mostraridChequePostFechado;
	}

	public Boolean getActivaridChequePostFechado() {
		return this.activaridChequePostFechado;
	}

	public void setActivaridChequePostFechado(Boolean activaridChequePostFechado) {
		this.activaridChequePostFechado= activaridChequePostFechado;
	}

	public Border setResaltarid_empresaChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltarid_empresaChequePostFechado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaChequePostFechado() {
		return this.resaltarid_empresaChequePostFechado;
	}

	public void setResaltarid_empresaChequePostFechado(Border borderResaltar) {
		this.resaltarid_empresaChequePostFechado= borderResaltar;
	}

	public Boolean getMostrarid_empresaChequePostFechado() {
		return this.mostrarid_empresaChequePostFechado;
	}

	public void setMostrarid_empresaChequePostFechado(Boolean mostrarid_empresaChequePostFechado) {
		this.mostrarid_empresaChequePostFechado= mostrarid_empresaChequePostFechado;
	}

	public Boolean getActivarid_empresaChequePostFechado() {
		return this.activarid_empresaChequePostFechado;
	}

	public void setActivarid_empresaChequePostFechado(Boolean activarid_empresaChequePostFechado) {
		this.activarid_empresaChequePostFechado= activarid_empresaChequePostFechado;
	}

	public Boolean getCargarid_empresaChequePostFechado() {
		return this.cargarid_empresaChequePostFechado;
	}

	public void setCargarid_empresaChequePostFechado(Boolean cargarid_empresaChequePostFechado) {
		this.cargarid_empresaChequePostFechado= cargarid_empresaChequePostFechado;
	}

	public Border setResaltarid_sucursalChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltarid_sucursalChequePostFechado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalChequePostFechado() {
		return this.resaltarid_sucursalChequePostFechado;
	}

	public void setResaltarid_sucursalChequePostFechado(Border borderResaltar) {
		this.resaltarid_sucursalChequePostFechado= borderResaltar;
	}

	public Boolean getMostrarid_sucursalChequePostFechado() {
		return this.mostrarid_sucursalChequePostFechado;
	}

	public void setMostrarid_sucursalChequePostFechado(Boolean mostrarid_sucursalChequePostFechado) {
		this.mostrarid_sucursalChequePostFechado= mostrarid_sucursalChequePostFechado;
	}

	public Boolean getActivarid_sucursalChequePostFechado() {
		return this.activarid_sucursalChequePostFechado;
	}

	public void setActivarid_sucursalChequePostFechado(Boolean activarid_sucursalChequePostFechado) {
		this.activarid_sucursalChequePostFechado= activarid_sucursalChequePostFechado;
	}

	public Boolean getCargarid_sucursalChequePostFechado() {
		return this.cargarid_sucursalChequePostFechado;
	}

	public void setCargarid_sucursalChequePostFechado(Boolean cargarid_sucursalChequePostFechado) {
		this.cargarid_sucursalChequePostFechado= cargarid_sucursalChequePostFechado;
	}

	public Border setResaltarid_clienteChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltarid_clienteChequePostFechado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteChequePostFechado() {
		return this.resaltarid_clienteChequePostFechado;
	}

	public void setResaltarid_clienteChequePostFechado(Border borderResaltar) {
		this.resaltarid_clienteChequePostFechado= borderResaltar;
	}

	public Boolean getMostrarid_clienteChequePostFechado() {
		return this.mostrarid_clienteChequePostFechado;
	}

	public void setMostrarid_clienteChequePostFechado(Boolean mostrarid_clienteChequePostFechado) {
		this.mostrarid_clienteChequePostFechado= mostrarid_clienteChequePostFechado;
	}

	public Boolean getActivarid_clienteChequePostFechado() {
		return this.activarid_clienteChequePostFechado;
	}

	public void setActivarid_clienteChequePostFechado(Boolean activarid_clienteChequePostFechado) {
		this.activarid_clienteChequePostFechado= activarid_clienteChequePostFechado;
	}

	public Boolean getCargarid_clienteChequePostFechado() {
		return this.cargarid_clienteChequePostFechado;
	}

	public void setCargarid_clienteChequePostFechado(Boolean cargarid_clienteChequePostFechado) {
		this.cargarid_clienteChequePostFechado= cargarid_clienteChequePostFechado;
	}

	public Border setResaltarid_asiento_contableChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableChequePostFechado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableChequePostFechado() {
		return this.resaltarid_asiento_contableChequePostFechado;
	}

	public void setResaltarid_asiento_contableChequePostFechado(Border borderResaltar) {
		this.resaltarid_asiento_contableChequePostFechado= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableChequePostFechado() {
		return this.mostrarid_asiento_contableChequePostFechado;
	}

	public void setMostrarid_asiento_contableChequePostFechado(Boolean mostrarid_asiento_contableChequePostFechado) {
		this.mostrarid_asiento_contableChequePostFechado= mostrarid_asiento_contableChequePostFechado;
	}

	public Boolean getActivarid_asiento_contableChequePostFechado() {
		return this.activarid_asiento_contableChequePostFechado;
	}

	public void setActivarid_asiento_contableChequePostFechado(Boolean activarid_asiento_contableChequePostFechado) {
		this.activarid_asiento_contableChequePostFechado= activarid_asiento_contableChequePostFechado;
	}

	public Boolean getCargarid_asiento_contableChequePostFechado() {
		return this.cargarid_asiento_contableChequePostFechado;
	}

	public void setCargarid_asiento_contableChequePostFechado(Boolean cargarid_asiento_contableChequePostFechado) {
		this.cargarid_asiento_contableChequePostFechado= cargarid_asiento_contableChequePostFechado;
	}

	public Border setResaltarid_ejercicioChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioChequePostFechado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioChequePostFechado() {
		return this.resaltarid_ejercicioChequePostFechado;
	}

	public void setResaltarid_ejercicioChequePostFechado(Border borderResaltar) {
		this.resaltarid_ejercicioChequePostFechado= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioChequePostFechado() {
		return this.mostrarid_ejercicioChequePostFechado;
	}

	public void setMostrarid_ejercicioChequePostFechado(Boolean mostrarid_ejercicioChequePostFechado) {
		this.mostrarid_ejercicioChequePostFechado= mostrarid_ejercicioChequePostFechado;
	}

	public Boolean getActivarid_ejercicioChequePostFechado() {
		return this.activarid_ejercicioChequePostFechado;
	}

	public void setActivarid_ejercicioChequePostFechado(Boolean activarid_ejercicioChequePostFechado) {
		this.activarid_ejercicioChequePostFechado= activarid_ejercicioChequePostFechado;
	}

	public Boolean getCargarid_ejercicioChequePostFechado() {
		return this.cargarid_ejercicioChequePostFechado;
	}

	public void setCargarid_ejercicioChequePostFechado(Boolean cargarid_ejercicioChequePostFechado) {
		this.cargarid_ejercicioChequePostFechado= cargarid_ejercicioChequePostFechado;
	}

	public Border setResaltarid_periodoChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltarid_periodoChequePostFechado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoChequePostFechado() {
		return this.resaltarid_periodoChequePostFechado;
	}

	public void setResaltarid_periodoChequePostFechado(Border borderResaltar) {
		this.resaltarid_periodoChequePostFechado= borderResaltar;
	}

	public Boolean getMostrarid_periodoChequePostFechado() {
		return this.mostrarid_periodoChequePostFechado;
	}

	public void setMostrarid_periodoChequePostFechado(Boolean mostrarid_periodoChequePostFechado) {
		this.mostrarid_periodoChequePostFechado= mostrarid_periodoChequePostFechado;
	}

	public Boolean getActivarid_periodoChequePostFechado() {
		return this.activarid_periodoChequePostFechado;
	}

	public void setActivarid_periodoChequePostFechado(Boolean activarid_periodoChequePostFechado) {
		this.activarid_periodoChequePostFechado= activarid_periodoChequePostFechado;
	}

	public Boolean getCargarid_periodoChequePostFechado() {
		return this.cargarid_periodoChequePostFechado;
	}

	public void setCargarid_periodoChequePostFechado(Boolean cargarid_periodoChequePostFechado) {
		this.cargarid_periodoChequePostFechado= cargarid_periodoChequePostFechado;
	}

	public Border setResaltarid_tipo_forma_pagoChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltarid_tipo_forma_pagoChequePostFechado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_forma_pagoChequePostFechado() {
		return this.resaltarid_tipo_forma_pagoChequePostFechado;
	}

	public void setResaltarid_tipo_forma_pagoChequePostFechado(Border borderResaltar) {
		this.resaltarid_tipo_forma_pagoChequePostFechado= borderResaltar;
	}

	public Boolean getMostrarid_tipo_forma_pagoChequePostFechado() {
		return this.mostrarid_tipo_forma_pagoChequePostFechado;
	}

	public void setMostrarid_tipo_forma_pagoChequePostFechado(Boolean mostrarid_tipo_forma_pagoChequePostFechado) {
		this.mostrarid_tipo_forma_pagoChequePostFechado= mostrarid_tipo_forma_pagoChequePostFechado;
	}

	public Boolean getActivarid_tipo_forma_pagoChequePostFechado() {
		return this.activarid_tipo_forma_pagoChequePostFechado;
	}

	public void setActivarid_tipo_forma_pagoChequePostFechado(Boolean activarid_tipo_forma_pagoChequePostFechado) {
		this.activarid_tipo_forma_pagoChequePostFechado= activarid_tipo_forma_pagoChequePostFechado;
	}

	public Boolean getCargarid_tipo_forma_pagoChequePostFechado() {
		return this.cargarid_tipo_forma_pagoChequePostFechado;
	}

	public void setCargarid_tipo_forma_pagoChequePostFechado(Boolean cargarid_tipo_forma_pagoChequePostFechado) {
		this.cargarid_tipo_forma_pagoChequePostFechado= cargarid_tipo_forma_pagoChequePostFechado;
	}

	public Border setResaltarnombre_giraChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltarnombre_giraChequePostFechado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_giraChequePostFechado() {
		return this.resaltarnombre_giraChequePostFechado;
	}

	public void setResaltarnombre_giraChequePostFechado(Border borderResaltar) {
		this.resaltarnombre_giraChequePostFechado= borderResaltar;
	}

	public Boolean getMostrarnombre_giraChequePostFechado() {
		return this.mostrarnombre_giraChequePostFechado;
	}

	public void setMostrarnombre_giraChequePostFechado(Boolean mostrarnombre_giraChequePostFechado) {
		this.mostrarnombre_giraChequePostFechado= mostrarnombre_giraChequePostFechado;
	}

	public Boolean getActivarnombre_giraChequePostFechado() {
		return this.activarnombre_giraChequePostFechado;
	}

	public void setActivarnombre_giraChequePostFechado(Boolean activarnombre_giraChequePostFechado) {
		this.activarnombre_giraChequePostFechado= activarnombre_giraChequePostFechado;
	}

	public Border setResaltarfecha_vencimientoChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoChequePostFechado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoChequePostFechado() {
		return this.resaltarfecha_vencimientoChequePostFechado;
	}

	public void setResaltarfecha_vencimientoChequePostFechado(Border borderResaltar) {
		this.resaltarfecha_vencimientoChequePostFechado= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoChequePostFechado() {
		return this.mostrarfecha_vencimientoChequePostFechado;
	}

	public void setMostrarfecha_vencimientoChequePostFechado(Boolean mostrarfecha_vencimientoChequePostFechado) {
		this.mostrarfecha_vencimientoChequePostFechado= mostrarfecha_vencimientoChequePostFechado;
	}

	public Boolean getActivarfecha_vencimientoChequePostFechado() {
		return this.activarfecha_vencimientoChequePostFechado;
	}

	public void setActivarfecha_vencimientoChequePostFechado(Boolean activarfecha_vencimientoChequePostFechado) {
		this.activarfecha_vencimientoChequePostFechado= activarfecha_vencimientoChequePostFechado;
	}

	public Border setResaltarfecha_vencimiento_originalChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimiento_originalChequePostFechado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimiento_originalChequePostFechado() {
		return this.resaltarfecha_vencimiento_originalChequePostFechado;
	}

	public void setResaltarfecha_vencimiento_originalChequePostFechado(Border borderResaltar) {
		this.resaltarfecha_vencimiento_originalChequePostFechado= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimiento_originalChequePostFechado() {
		return this.mostrarfecha_vencimiento_originalChequePostFechado;
	}

	public void setMostrarfecha_vencimiento_originalChequePostFechado(Boolean mostrarfecha_vencimiento_originalChequePostFechado) {
		this.mostrarfecha_vencimiento_originalChequePostFechado= mostrarfecha_vencimiento_originalChequePostFechado;
	}

	public Boolean getActivarfecha_vencimiento_originalChequePostFechado() {
		return this.activarfecha_vencimiento_originalChequePostFechado;
	}

	public void setActivarfecha_vencimiento_originalChequePostFechado(Boolean activarfecha_vencimiento_originalChequePostFechado) {
		this.activarfecha_vencimiento_originalChequePostFechado= activarfecha_vencimiento_originalChequePostFechado;
	}

	public Border setResaltarnumeroChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltarnumeroChequePostFechado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroChequePostFechado() {
		return this.resaltarnumeroChequePostFechado;
	}

	public void setResaltarnumeroChequePostFechado(Border borderResaltar) {
		this.resaltarnumeroChequePostFechado= borderResaltar;
	}

	public Boolean getMostrarnumeroChequePostFechado() {
		return this.mostrarnumeroChequePostFechado;
	}

	public void setMostrarnumeroChequePostFechado(Boolean mostrarnumeroChequePostFechado) {
		this.mostrarnumeroChequePostFechado= mostrarnumeroChequePostFechado;
	}

	public Boolean getActivarnumeroChequePostFechado() {
		return this.activarnumeroChequePostFechado;
	}

	public void setActivarnumeroChequePostFechado(Boolean activarnumeroChequePostFechado) {
		this.activarnumeroChequePostFechado= activarnumeroChequePostFechado;
	}

	public Border setResaltarnumero_chequeChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltarnumero_chequeChequePostFechado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chequeChequePostFechado() {
		return this.resaltarnumero_chequeChequePostFechado;
	}

	public void setResaltarnumero_chequeChequePostFechado(Border borderResaltar) {
		this.resaltarnumero_chequeChequePostFechado= borderResaltar;
	}

	public Boolean getMostrarnumero_chequeChequePostFechado() {
		return this.mostrarnumero_chequeChequePostFechado;
	}

	public void setMostrarnumero_chequeChequePostFechado(Boolean mostrarnumero_chequeChequePostFechado) {
		this.mostrarnumero_chequeChequePostFechado= mostrarnumero_chequeChequePostFechado;
	}

	public Boolean getActivarnumero_chequeChequePostFechado() {
		return this.activarnumero_chequeChequePostFechado;
	}

	public void setActivarnumero_chequeChequePostFechado(Boolean activarnumero_chequeChequePostFechado) {
		this.activarnumero_chequeChequePostFechado= activarnumero_chequeChequePostFechado;
	}

	public Border setResaltardescripcionChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltardescripcionChequePostFechado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionChequePostFechado() {
		return this.resaltardescripcionChequePostFechado;
	}

	public void setResaltardescripcionChequePostFechado(Border borderResaltar) {
		this.resaltardescripcionChequePostFechado= borderResaltar;
	}

	public Boolean getMostrardescripcionChequePostFechado() {
		return this.mostrardescripcionChequePostFechado;
	}

	public void setMostrardescripcionChequePostFechado(Boolean mostrardescripcionChequePostFechado) {
		this.mostrardescripcionChequePostFechado= mostrardescripcionChequePostFechado;
	}

	public Boolean getActivardescripcionChequePostFechado() {
		return this.activardescripcionChequePostFechado;
	}

	public void setActivardescripcionChequePostFechado(Boolean activardescripcionChequePostFechado) {
		this.activardescripcionChequePostFechado= activardescripcionChequePostFechado;
	}

	public Border setResaltarid_anioChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltarid_anioChequePostFechado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioChequePostFechado() {
		return this.resaltarid_anioChequePostFechado;
	}

	public void setResaltarid_anioChequePostFechado(Border borderResaltar) {
		this.resaltarid_anioChequePostFechado= borderResaltar;
	}

	public Boolean getMostrarid_anioChequePostFechado() {
		return this.mostrarid_anioChequePostFechado;
	}

	public void setMostrarid_anioChequePostFechado(Boolean mostrarid_anioChequePostFechado) {
		this.mostrarid_anioChequePostFechado= mostrarid_anioChequePostFechado;
	}

	public Boolean getActivarid_anioChequePostFechado() {
		return this.activarid_anioChequePostFechado;
	}

	public void setActivarid_anioChequePostFechado(Boolean activarid_anioChequePostFechado) {
		this.activarid_anioChequePostFechado= activarid_anioChequePostFechado;
	}

	public Boolean getCargarid_anioChequePostFechado() {
		return this.cargarid_anioChequePostFechado;
	}

	public void setCargarid_anioChequePostFechado(Boolean cargarid_anioChequePostFechado) {
		this.cargarid_anioChequePostFechado= cargarid_anioChequePostFechado;
	}

	public Border setResaltarid_mesChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequepostfechadoBeanSwingJInternalFrame.jTtoolBarChequePostFechado.setBorder(borderResaltar);
		
		this.resaltarid_mesChequePostFechado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesChequePostFechado() {
		return this.resaltarid_mesChequePostFechado;
	}

	public void setResaltarid_mesChequePostFechado(Border borderResaltar) {
		this.resaltarid_mesChequePostFechado= borderResaltar;
	}

	public Boolean getMostrarid_mesChequePostFechado() {
		return this.mostrarid_mesChequePostFechado;
	}

	public void setMostrarid_mesChequePostFechado(Boolean mostrarid_mesChequePostFechado) {
		this.mostrarid_mesChequePostFechado= mostrarid_mesChequePostFechado;
	}

	public Boolean getActivarid_mesChequePostFechado() {
		return this.activarid_mesChequePostFechado;
	}

	public void setActivarid_mesChequePostFechado(Boolean activarid_mesChequePostFechado) {
		this.activarid_mesChequePostFechado= activarid_mesChequePostFechado;
	}

	public Boolean getCargarid_mesChequePostFechado() {
		return this.cargarid_mesChequePostFechado;
	}

	public void setCargarid_mesChequePostFechado(Boolean cargarid_mesChequePostFechado) {
		this.cargarid_mesChequePostFechado= cargarid_mesChequePostFechado;
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
		
		
		this.setMostraridChequePostFechado(esInicial);
		this.setMostrarid_empresaChequePostFechado(esInicial);
		this.setMostrarid_sucursalChequePostFechado(esInicial);
		this.setMostrarid_clienteChequePostFechado(esInicial);
		this.setMostrarid_asiento_contableChequePostFechado(esInicial);
		this.setMostrarid_ejercicioChequePostFechado(esInicial);
		this.setMostrarid_periodoChequePostFechado(esInicial);
		this.setMostrarid_tipo_forma_pagoChequePostFechado(esInicial);
		this.setMostrarnombre_giraChequePostFechado(esInicial);
		this.setMostrarfecha_vencimientoChequePostFechado(esInicial);
		this.setMostrarfecha_vencimiento_originalChequePostFechado(esInicial);
		this.setMostrarnumeroChequePostFechado(esInicial);
		this.setMostrarnumero_chequeChequePostFechado(esInicial);
		this.setMostrardescripcionChequePostFechado(esInicial);
		this.setMostrarid_anioChequePostFechado(esInicial);
		this.setMostrarid_mesChequePostFechado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.ID)) {
				this.setMostraridChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setMostrarid_tipo_forma_pagoChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.NOMBREGIRA)) {
				this.setMostrarnombre_giraChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.FECHAVENCIMIENTOORIGINAL)) {
				this.setMostrarfecha_vencimiento_originalChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.NUMEROCHEQUE)) {
				this.setMostrarnumero_chequeChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesChequePostFechado(esAsigna);
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
		
		
		this.setActivaridChequePostFechado(esInicial);
		this.setActivarid_empresaChequePostFechado(esInicial);
		this.setActivarid_sucursalChequePostFechado(esInicial);
		this.setActivarid_clienteChequePostFechado(esInicial);
		this.setActivarid_asiento_contableChequePostFechado(esInicial);
		this.setActivarid_ejercicioChequePostFechado(esInicial);
		this.setActivarid_periodoChequePostFechado(esInicial);
		this.setActivarid_tipo_forma_pagoChequePostFechado(esInicial);
		this.setActivarnombre_giraChequePostFechado(esInicial);
		this.setActivarfecha_vencimientoChequePostFechado(esInicial);
		this.setActivarfecha_vencimiento_originalChequePostFechado(esInicial);
		this.setActivarnumeroChequePostFechado(esInicial);
		this.setActivarnumero_chequeChequePostFechado(esInicial);
		this.setActivardescripcionChequePostFechado(esInicial);
		this.setActivarid_anioChequePostFechado(esInicial);
		this.setActivarid_mesChequePostFechado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.ID)) {
				this.setActivaridChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setActivarid_tipo_forma_pagoChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.NOMBREGIRA)) {
				this.setActivarnombre_giraChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.FECHAVENCIMIENTOORIGINAL)) {
				this.setActivarfecha_vencimiento_originalChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.NUMERO)) {
				this.setActivarnumeroChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.NUMEROCHEQUE)) {
				this.setActivarnumero_chequeChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDMES)) {
				this.setActivarid_mesChequePostFechado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridChequePostFechado(esInicial);
		this.setResaltarid_empresaChequePostFechado(esInicial);
		this.setResaltarid_sucursalChequePostFechado(esInicial);
		this.setResaltarid_clienteChequePostFechado(esInicial);
		this.setResaltarid_asiento_contableChequePostFechado(esInicial);
		this.setResaltarid_ejercicioChequePostFechado(esInicial);
		this.setResaltarid_periodoChequePostFechado(esInicial);
		this.setResaltarid_tipo_forma_pagoChequePostFechado(esInicial);
		this.setResaltarnombre_giraChequePostFechado(esInicial);
		this.setResaltarfecha_vencimientoChequePostFechado(esInicial);
		this.setResaltarfecha_vencimiento_originalChequePostFechado(esInicial);
		this.setResaltarnumeroChequePostFechado(esInicial);
		this.setResaltarnumero_chequeChequePostFechado(esInicial);
		this.setResaltardescripcionChequePostFechado(esInicial);
		this.setResaltarid_anioChequePostFechado(esInicial);
		this.setResaltarid_mesChequePostFechado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.ID)) {
				this.setResaltaridChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setResaltarid_tipo_forma_pagoChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.NOMBREGIRA)) {
				this.setResaltarnombre_giraChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.FECHAVENCIMIENTOORIGINAL)) {
				this.setResaltarfecha_vencimiento_originalChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.NUMEROCHEQUE)) {
				this.setResaltarnumero_chequeChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioChequePostFechado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequePostFechadoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesChequePostFechado(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableChequePostFechado=true;

	public Boolean getMostrarFK_IdAsientoContableChequePostFechado() {
		return this.mostrarFK_IdAsientoContableChequePostFechado;
	}

	public void setMostrarFK_IdAsientoContableChequePostFechado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableChequePostFechado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteChequePostFechado=true;

	public Boolean getMostrarFK_IdClienteChequePostFechado() {
		return this.mostrarFK_IdClienteChequePostFechado;
	}

	public void setMostrarFK_IdClienteChequePostFechado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteChequePostFechado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioChequePostFechado=true;

	public Boolean getMostrarFK_IdEjercicioChequePostFechado() {
		return this.mostrarFK_IdEjercicioChequePostFechado;
	}

	public void setMostrarFK_IdEjercicioChequePostFechado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioChequePostFechado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaChequePostFechado=true;

	public Boolean getMostrarFK_IdEmpresaChequePostFechado() {
		return this.mostrarFK_IdEmpresaChequePostFechado;
	}

	public void setMostrarFK_IdEmpresaChequePostFechado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaChequePostFechado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoChequePostFechado=true;

	public Boolean getMostrarFK_IdPeriodoChequePostFechado() {
		return this.mostrarFK_IdPeriodoChequePostFechado;
	}

	public void setMostrarFK_IdPeriodoChequePostFechado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoChequePostFechado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalChequePostFechado=true;

	public Boolean getMostrarFK_IdSucursalChequePostFechado() {
		return this.mostrarFK_IdSucursalChequePostFechado;
	}

	public void setMostrarFK_IdSucursalChequePostFechado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalChequePostFechado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFormaPagoChequePostFechado=true;

	public Boolean getMostrarFK_IdTipoFormaPagoChequePostFechado() {
		return this.mostrarFK_IdTipoFormaPagoChequePostFechado;
	}

	public void setMostrarFK_IdTipoFormaPagoChequePostFechado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFormaPagoChequePostFechado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableChequePostFechado=true;

	public Boolean getActivarFK_IdAsientoContableChequePostFechado() {
		return this.activarFK_IdAsientoContableChequePostFechado;
	}

	public void setActivarFK_IdAsientoContableChequePostFechado(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableChequePostFechado= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteChequePostFechado=true;

	public Boolean getActivarFK_IdClienteChequePostFechado() {
		return this.activarFK_IdClienteChequePostFechado;
	}

	public void setActivarFK_IdClienteChequePostFechado(Boolean habilitarResaltar) {
		this.activarFK_IdClienteChequePostFechado= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioChequePostFechado=true;

	public Boolean getActivarFK_IdEjercicioChequePostFechado() {
		return this.activarFK_IdEjercicioChequePostFechado;
	}

	public void setActivarFK_IdEjercicioChequePostFechado(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioChequePostFechado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaChequePostFechado=true;

	public Boolean getActivarFK_IdEmpresaChequePostFechado() {
		return this.activarFK_IdEmpresaChequePostFechado;
	}

	public void setActivarFK_IdEmpresaChequePostFechado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaChequePostFechado= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoChequePostFechado=true;

	public Boolean getActivarFK_IdPeriodoChequePostFechado() {
		return this.activarFK_IdPeriodoChequePostFechado;
	}

	public void setActivarFK_IdPeriodoChequePostFechado(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoChequePostFechado= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalChequePostFechado=true;

	public Boolean getActivarFK_IdSucursalChequePostFechado() {
		return this.activarFK_IdSucursalChequePostFechado;
	}

	public void setActivarFK_IdSucursalChequePostFechado(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalChequePostFechado= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFormaPagoChequePostFechado=true;

	public Boolean getActivarFK_IdTipoFormaPagoChequePostFechado() {
		return this.activarFK_IdTipoFormaPagoChequePostFechado;
	}

	public void setActivarFK_IdTipoFormaPagoChequePostFechado(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFormaPagoChequePostFechado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableChequePostFechado=null;

	public Border getResaltarFK_IdAsientoContableChequePostFechado() {
		return this.resaltarFK_IdAsientoContableChequePostFechado;
	}

	public void setResaltarFK_IdAsientoContableChequePostFechado(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableChequePostFechado= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableChequePostFechado= borderResaltar;
	}

	public Border resaltarFK_IdClienteChequePostFechado=null;

	public Border getResaltarFK_IdClienteChequePostFechado() {
		return this.resaltarFK_IdClienteChequePostFechado;
	}

	public void setResaltarFK_IdClienteChequePostFechado(Border borderResaltar) {
		this.resaltarFK_IdClienteChequePostFechado= borderResaltar;
	}

	public void setResaltarFK_IdClienteChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteChequePostFechado= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioChequePostFechado=null;

	public Border getResaltarFK_IdEjercicioChequePostFechado() {
		return this.resaltarFK_IdEjercicioChequePostFechado;
	}

	public void setResaltarFK_IdEjercicioChequePostFechado(Border borderResaltar) {
		this.resaltarFK_IdEjercicioChequePostFechado= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioChequePostFechado= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaChequePostFechado=null;

	public Border getResaltarFK_IdEmpresaChequePostFechado() {
		return this.resaltarFK_IdEmpresaChequePostFechado;
	}

	public void setResaltarFK_IdEmpresaChequePostFechado(Border borderResaltar) {
		this.resaltarFK_IdEmpresaChequePostFechado= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaChequePostFechado= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoChequePostFechado=null;

	public Border getResaltarFK_IdPeriodoChequePostFechado() {
		return this.resaltarFK_IdPeriodoChequePostFechado;
	}

	public void setResaltarFK_IdPeriodoChequePostFechado(Border borderResaltar) {
		this.resaltarFK_IdPeriodoChequePostFechado= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoChequePostFechado= borderResaltar;
	}

	public Border resaltarFK_IdSucursalChequePostFechado=null;

	public Border getResaltarFK_IdSucursalChequePostFechado() {
		return this.resaltarFK_IdSucursalChequePostFechado;
	}

	public void setResaltarFK_IdSucursalChequePostFechado(Border borderResaltar) {
		this.resaltarFK_IdSucursalChequePostFechado= borderResaltar;
	}

	public void setResaltarFK_IdSucursalChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalChequePostFechado= borderResaltar;
	}

	public Border resaltarFK_IdTipoFormaPagoChequePostFechado=null;

	public Border getResaltarFK_IdTipoFormaPagoChequePostFechado() {
		return this.resaltarFK_IdTipoFormaPagoChequePostFechado;
	}

	public void setResaltarFK_IdTipoFormaPagoChequePostFechado(Border borderResaltar) {
		this.resaltarFK_IdTipoFormaPagoChequePostFechado= borderResaltar;
	}

	public void setResaltarFK_IdTipoFormaPagoChequePostFechado(ParametroGeneralUsuario parametroGeneralUsuario/*ChequePostFechadoBeanSwingJInternalFrame chequepostfechadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFormaPagoChequePostFechado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
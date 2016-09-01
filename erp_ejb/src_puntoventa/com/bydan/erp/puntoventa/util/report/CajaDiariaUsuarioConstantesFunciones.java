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
package com.bydan.erp.puntoventa.util.report;

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


import com.bydan.erp.puntoventa.util.report.CajaDiariaUsuarioConstantesFunciones;
import com.bydan.erp.puntoventa.util.report.CajaDiariaUsuarioParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.CajaDiariaUsuarioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.puntoventa.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CajaDiariaUsuarioConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="CajaDiariaUsuario";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CajaDiariaUsuario"+CajaDiariaUsuarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CajaDiariaUsuarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CajaDiariaUsuarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CajaDiariaUsuarioConstantesFunciones.SCHEMA+"_"+CajaDiariaUsuarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CajaDiariaUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CajaDiariaUsuarioConstantesFunciones.SCHEMA+"_"+CajaDiariaUsuarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CajaDiariaUsuarioConstantesFunciones.SCHEMA+"_"+CajaDiariaUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CajaDiariaUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CajaDiariaUsuarioConstantesFunciones.SCHEMA+"_"+CajaDiariaUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaDiariaUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajaDiariaUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaDiariaUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaDiariaUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajaDiariaUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaDiariaUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CajaDiariaUsuarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CajaDiariaUsuarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CajaDiariaUsuarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CajaDiariaUsuarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Caja Diaria Usuarios";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Caja Diaria Usuario";
	public static final String SCLASSWEBTITULO_LOWER="Caja Diaria Usuario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CajaDiariaUsuario";
	public static final String OBJECTNAME="cajadiariausuario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="factura_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cajadiariausuario from "+CajaDiariaUsuarioConstantesFunciones.SPERSISTENCENAME+" cajadiariausuario";
	public static String QUERYSELECTNATIVE="select "+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".id,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".version_row,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".id_empresa,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".id_cliente,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".id_caja,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".id_usuario,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".fecha_inicio,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".fecha_fin,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".nombre_caja,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".nombre_usuario,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".secuencial,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".codigo_cliente,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".nombre_cliente,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".subtotal,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".iva,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".descuento,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".financiamiento,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".flete,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".ice,"+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME+".total from "+CajaDiariaUsuarioConstantesFunciones.SCHEMA+"."+CajaDiariaUsuarioConstantesFunciones.TABLENAME;//+" as "+CajaDiariaUsuarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDCAJA= "id_caja";
    public static final String IDUSUARIO= "id_usuario";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String NOMBRECAJA= "nombre_caja";
    public static final String NOMBREUSUARIO= "nombre_usuario";
    public static final String SECUENCIAL= "secuencial";
    public static final String CODIGOCLIENTE= "codigo_cliente";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String SUBTOTAL= "subtotal";
    public static final String IVA= "iva";
    public static final String DESCUENTO= "descuento";
    public static final String FINANCIAMIENTO= "financiamiento";
    public static final String FLETE= "flete";
    public static final String ICE= "ice";
    public static final String TOTAL= "total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDCAJA= "Caja";
		public static final String LABEL_IDCAJA_LOWER= "Caja";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_NOMBRECAJA= "Nombre Caja";
		public static final String LABEL_NOMBRECAJA_LOWER= "Nombre Caja";
    	public static final String LABEL_NOMBREUSUARIO= "Nombre Usuario";
		public static final String LABEL_NOMBREUSUARIO_LOWER= "Nombre Usuario";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_CODIGOCLIENTE= "Codigo Cliente";
		public static final String LABEL_CODIGOCLIENTE_LOWER= "Codigo Cliente";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_SUBTOTAL= "Subtotal";
		public static final String LABEL_SUBTOTAL_LOWER= "Subtotal";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_FINANCIAMIENTO= "Financiamiento";
		public static final String LABEL_FINANCIAMIENTO_LOWER= "Financiamiento";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_CAJA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CAJA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_USUARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_USUARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	
	public static String getCajaDiariaUsuarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.IDEMPRESA)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.IDCLIENTE)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.IDCAJA)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_IDCAJA;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.IDUSUARIO)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.FECHAINICIO)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.FECHAFIN)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.NOMBRECAJA)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_NOMBRECAJA;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.NOMBREUSUARIO)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_NOMBREUSUARIO;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.SECUENCIAL)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.CODIGOCLIENTE)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_CODIGOCLIENTE;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.SUBTOTAL)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.IVA)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.DESCUENTO)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.FINANCIAMIENTO)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_FINANCIAMIENTO;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.FLETE)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.ICE)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(CajaDiariaUsuarioConstantesFunciones.TOTAL)) {sLabelColumna=CajaDiariaUsuarioConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCajaDiariaUsuarioDescripcion(CajaDiariaUsuario cajadiariausuario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cajadiariausuario !=null/* && cajadiariausuario.getId()!=0*/) {
			sDescripcion=cajadiariausuario.getsecuencial();//cajadiariausuariocajadiariausuario.getsecuencial().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCajaDiariaUsuarioDescripcionDetallado(CajaDiariaUsuario cajadiariausuario) {
		String sDescripcion="";
			
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.ID+"=";
		sDescripcion+=cajadiariausuario.getId().toString()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cajadiariausuario.getVersionRow().toString()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cajadiariausuario.getid_empresa().toString()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=cajadiariausuario.getid_cliente().toString()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.IDCAJA+"=";
		sDescripcion+=cajadiariausuario.getid_caja().toString()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=cajadiariausuario.getid_usuario().toString()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=cajadiariausuario.getfecha_inicio().toString()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=cajadiariausuario.getfecha_fin().toString()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.NOMBRECAJA+"=";
		sDescripcion+=cajadiariausuario.getnombre_caja()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.NOMBREUSUARIO+"=";
		sDescripcion+=cajadiariausuario.getnombre_usuario()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=cajadiariausuario.getsecuencial()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.CODIGOCLIENTE+"=";
		sDescripcion+=cajadiariausuario.getcodigo_cliente()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=cajadiariausuario.getnombre_cliente()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=cajadiariausuario.getsubtotal().toString()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.IVA+"=";
		sDescripcion+=cajadiariausuario.getiva().toString()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=cajadiariausuario.getdescuento().toString()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.FINANCIAMIENTO+"=";
		sDescripcion+=cajadiariausuario.getfinanciamiento().toString()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.FLETE+"=";
		sDescripcion+=cajadiariausuario.getflete().toString()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.ICE+"=";
		sDescripcion+=cajadiariausuario.getice().toString()+",";
		sDescripcion+=CajaDiariaUsuarioConstantesFunciones.TOTAL+"=";
		sDescripcion+=cajadiariausuario.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCajaDiariaUsuarioDescripcion(CajaDiariaUsuario cajadiariausuario,String sValor) throws Exception {			
		if(cajadiariausuario !=null) {
			cajadiariausuario.setsecuencial(sValor);;//cajadiariausuariocajadiariausuario.getsecuencial().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getCajaDescripcion(Caja caja) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(caja!=null/*&&caja.getId()>0*/) {
			sDescripcion=CajaConstantesFunciones.getCajaDescripcion(caja);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCajaDiariaUsuario")) {
			sNombreIndice="Tipo=  Por Usuario Por Fecha Inicio Por Fecha Fin";
		} else if(sNombreIndice.equals("FK_IdCaja")) {
			sNombreIndice="Tipo=  Por Caja";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCajaDiariaUsuario(Long id_usuario,Date fecha_inicio,Date fecha_fin) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();}
		if(fecha_inicio!=null) {sDetalleIndice+=" Fecha Inicio="+fecha_inicio.toString();}
		if(fecha_fin!=null) {sDetalleIndice+=" Fecha Fin="+fecha_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCaja(Long id_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCajaDiariaUsuario(CajaDiariaUsuario cajadiariausuario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cajadiariausuario.setnombre_caja(cajadiariausuario.getnombre_caja().trim());
		cajadiariausuario.setnombre_usuario(cajadiariausuario.getnombre_usuario().trim());
		cajadiariausuario.setsecuencial(cajadiariausuario.getsecuencial().trim());
		cajadiariausuario.setcodigo_cliente(cajadiariausuario.getcodigo_cliente().trim());
		cajadiariausuario.setnombre_cliente(cajadiariausuario.getnombre_cliente().trim());
	}
	
	public static void quitarEspaciosCajaDiariaUsuarios(List<CajaDiariaUsuario> cajadiariausuarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CajaDiariaUsuario cajadiariausuario: cajadiariausuarios) {
			cajadiariausuario.setnombre_caja(cajadiariausuario.getnombre_caja().trim());
			cajadiariausuario.setnombre_usuario(cajadiariausuario.getnombre_usuario().trim());
			cajadiariausuario.setsecuencial(cajadiariausuario.getsecuencial().trim());
			cajadiariausuario.setcodigo_cliente(cajadiariausuario.getcodigo_cliente().trim());
			cajadiariausuario.setnombre_cliente(cajadiariausuario.getnombre_cliente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajaDiariaUsuario(CajaDiariaUsuario cajadiariausuario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cajadiariausuario.getConCambioAuxiliar()) {
			cajadiariausuario.setIsDeleted(cajadiariausuario.getIsDeletedAuxiliar());	
			cajadiariausuario.setIsNew(cajadiariausuario.getIsNewAuxiliar());	
			cajadiariausuario.setIsChanged(cajadiariausuario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cajadiariausuario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cajadiariausuario.setIsDeletedAuxiliar(false);	
			cajadiariausuario.setIsNewAuxiliar(false);	
			cajadiariausuario.setIsChangedAuxiliar(false);
			
			cajadiariausuario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajaDiariaUsuarios(List<CajaDiariaUsuario> cajadiariausuarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CajaDiariaUsuario cajadiariausuario : cajadiariausuarios) {
			if(conAsignarBase && cajadiariausuario.getConCambioAuxiliar()) {
				cajadiariausuario.setIsDeleted(cajadiariausuario.getIsDeletedAuxiliar());	
				cajadiariausuario.setIsNew(cajadiariausuario.getIsNewAuxiliar());	
				cajadiariausuario.setIsChanged(cajadiariausuario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cajadiariausuario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cajadiariausuario.setIsDeletedAuxiliar(false);	
				cajadiariausuario.setIsNewAuxiliar(false);	
				cajadiariausuario.setIsChangedAuxiliar(false);
				
				cajadiariausuario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCajaDiariaUsuario(CajaDiariaUsuario cajadiariausuario,Boolean conEnteros) throws Exception  {
		cajadiariausuario.setsubtotal(0.0);
		cajadiariausuario.setiva(0.0);
		cajadiariausuario.setdescuento(0.0);
		cajadiariausuario.setfinanciamiento(0.0);
		cajadiariausuario.setflete(0.0);
		cajadiariausuario.setice(0.0);
		cajadiariausuario.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCajaDiariaUsuarios(List<CajaDiariaUsuario> cajadiariausuarios,Boolean conEnteros) throws Exception  {
		
		for(CajaDiariaUsuario cajadiariausuario: cajadiariausuarios) {
			cajadiariausuario.setsubtotal(0.0);
			cajadiariausuario.setiva(0.0);
			cajadiariausuario.setdescuento(0.0);
			cajadiariausuario.setfinanciamiento(0.0);
			cajadiariausuario.setflete(0.0);
			cajadiariausuario.setice(0.0);
			cajadiariausuario.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCajaDiariaUsuario(List<CajaDiariaUsuario> cajadiariausuarios,CajaDiariaUsuario cajadiariausuarioAux) throws Exception  {
		CajaDiariaUsuarioConstantesFunciones.InicializarValoresCajaDiariaUsuario(cajadiariausuarioAux,true);
		
		for(CajaDiariaUsuario cajadiariausuario: cajadiariausuarios) {
			if(cajadiariausuario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cajadiariausuarioAux.setsubtotal(cajadiariausuarioAux.getsubtotal()+cajadiariausuario.getsubtotal());			
			cajadiariausuarioAux.setiva(cajadiariausuarioAux.getiva()+cajadiariausuario.getiva());			
			cajadiariausuarioAux.setdescuento(cajadiariausuarioAux.getdescuento()+cajadiariausuario.getdescuento());			
			cajadiariausuarioAux.setfinanciamiento(cajadiariausuarioAux.getfinanciamiento()+cajadiariausuario.getfinanciamiento());			
			cajadiariausuarioAux.setflete(cajadiariausuarioAux.getflete()+cajadiariausuario.getflete());			
			cajadiariausuarioAux.setice(cajadiariausuarioAux.getice()+cajadiariausuario.getice());			
			cajadiariausuarioAux.settotal(cajadiariausuarioAux.gettotal()+cajadiariausuario.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaDiariaUsuario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CajaDiariaUsuarioConstantesFunciones.getArrayColumnasGlobalesCajaDiariaUsuario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaDiariaUsuario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaDiariaUsuarioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaDiariaUsuarioConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaDiariaUsuarioConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaDiariaUsuarioConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCajaDiariaUsuario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CajaDiariaUsuario> cajadiariausuarios,CajaDiariaUsuario cajadiariausuario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CajaDiariaUsuario cajadiariausuarioAux: cajadiariausuarios) {
			if(cajadiariausuarioAux!=null && cajadiariausuario!=null) {
				if((cajadiariausuarioAux.getId()==null && cajadiariausuario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cajadiariausuarioAux.getId()!=null && cajadiariausuario.getId()!=null){
					if(cajadiariausuarioAux.getId().equals(cajadiariausuario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCajaDiariaUsuario(List<CajaDiariaUsuario> cajadiariausuarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double subtotalTotal=0.0;
		Double ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double financiamientoTotal=0.0;
		Double fleteTotal=0.0;
		Double iceTotal=0.0;
		Double totalTotal=0.0;
	
		for(CajaDiariaUsuario cajadiariausuario: cajadiariausuarios) {			
			if(cajadiariausuario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			subtotalTotal+=cajadiariausuario.getsubtotal();
			ivaTotal+=cajadiariausuario.getiva();
			descuentoTotal+=cajadiariausuario.getdescuento();
			financiamientoTotal+=cajadiariausuario.getfinanciamiento();
			fleteTotal+=cajadiariausuario.getflete();
			iceTotal+=cajadiariausuario.getice();
			totalTotal+=cajadiariausuario.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaUsuarioConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaUsuarioConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaUsuarioConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaUsuarioConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaUsuarioConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaUsuarioConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaUsuarioConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCajaDiariaUsuario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_ID, CajaDiariaUsuarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_VERSIONROW, CajaDiariaUsuarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_IDCLIENTE, CajaDiariaUsuarioConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_IDCAJA, CajaDiariaUsuarioConstantesFunciones.IDCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_IDUSUARIO, CajaDiariaUsuarioConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_NOMBRECAJA, CajaDiariaUsuarioConstantesFunciones.NOMBRECAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_NOMBREUSUARIO, CajaDiariaUsuarioConstantesFunciones.NOMBREUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_SECUENCIAL, CajaDiariaUsuarioConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_CODIGOCLIENTE, CajaDiariaUsuarioConstantesFunciones.CODIGOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_NOMBRECLIENTE, CajaDiariaUsuarioConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_SUBTOTAL, CajaDiariaUsuarioConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_IVA, CajaDiariaUsuarioConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_DESCUENTO, CajaDiariaUsuarioConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_FINANCIAMIENTO, CajaDiariaUsuarioConstantesFunciones.FINANCIAMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_FLETE, CajaDiariaUsuarioConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_ICE, CajaDiariaUsuarioConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaUsuarioConstantesFunciones.LABEL_TOTAL, CajaDiariaUsuarioConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCajaDiariaUsuario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.IDCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.NOMBRECAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.NOMBREUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.CODIGOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.FINANCIAMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaUsuarioConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaDiariaUsuario() throws Exception  {
		return CajaDiariaUsuarioConstantesFunciones.getTiposSeleccionarCajaDiariaUsuario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaDiariaUsuario(Boolean conFk) throws Exception  {
		return CajaDiariaUsuarioConstantesFunciones.getTiposSeleccionarCajaDiariaUsuario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaDiariaUsuario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_IDCAJA);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_IDCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_NOMBRECAJA);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_NOMBRECAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_NOMBREUSUARIO);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_NOMBREUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_CODIGOCLIENTE);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_CODIGOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_FINANCIAMIENTO);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_FINANCIAMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaUsuarioConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCajaDiariaUsuario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCajaDiariaUsuario(CajaDiariaUsuario cajadiariausuarioAux) throws Exception {
		
			cajadiariausuarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajadiariausuarioAux.getEmpresa()));
			cajadiariausuarioAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(cajadiariausuarioAux.getCliente()));
			cajadiariausuarioAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(cajadiariausuarioAux.getCaja()));
			cajadiariausuarioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(cajadiariausuarioAux.getUsuario()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCajaDiariaUsuario(List<CajaDiariaUsuario> cajadiariausuariosTemp) throws Exception {
		for(CajaDiariaUsuario cajadiariausuarioAux:cajadiariausuariosTemp) {
			
			cajadiariausuarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajadiariausuarioAux.getEmpresa()));
			cajadiariausuarioAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(cajadiariausuarioAux.getCliente()));
			cajadiariausuarioAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(cajadiariausuarioAux.getCaja()));
			cajadiariausuarioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(cajadiariausuarioAux.getUsuario()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCajaDiariaUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Caja.class));
				classes.add(new Classe(Usuario.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Caja.class)) {
						classes.add(new Classe(Caja.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCajaDiariaUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaDiariaUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajaDiariaUsuarioConstantesFunciones.getClassesRelationshipsOfCajaDiariaUsuario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaDiariaUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajaDiariaUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajaDiariaUsuarioConstantesFunciones.getClassesRelationshipsFromStringsOfCajaDiariaUsuario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajaDiariaUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CajaDiariaUsuario cajadiariausuario,List<CajaDiariaUsuario> cajadiariausuarios,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CajaDiariaUsuario cajadiariausuario,List<CajaDiariaUsuario> cajadiariausuarios) throws Exception {
		try	{			
			for(CajaDiariaUsuario cajadiariausuarioLocal:cajadiariausuarios) {
				if(cajadiariausuarioLocal.getId().equals(cajadiariausuario.getId())) {
					cajadiariausuarioLocal.setIsSelected(cajadiariausuario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCajaDiariaUsuario(List<CajaDiariaUsuario> cajadiariausuariosAux) throws Exception {
		//this.cajadiariausuariosAux=cajadiariausuariosAux;
		
		for(CajaDiariaUsuario cajadiariausuarioAux:cajadiariausuariosAux) {
			if(cajadiariausuarioAux.getIsChanged()) {
				cajadiariausuarioAux.setIsChanged(false);
			}		
			
			if(cajadiariausuarioAux.getIsNew()) {
				cajadiariausuarioAux.setIsNew(false);
			}	
			
			if(cajadiariausuarioAux.getIsDeleted()) {
				cajadiariausuarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCajaDiariaUsuario(CajaDiariaUsuario cajadiariausuarioAux) throws Exception {
		//this.cajadiariausuarioAux=cajadiariausuarioAux;
		
			if(cajadiariausuarioAux.getIsChanged()) {
				cajadiariausuarioAux.setIsChanged(false);
			}		
			
			if(cajadiariausuarioAux.getIsNew()) {
				cajadiariausuarioAux.setIsNew(false);
			}	
			
			if(cajadiariausuarioAux.getIsDeleted()) {
				cajadiariausuarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CajaDiariaUsuario cajadiariausuarioAsignar,CajaDiariaUsuario cajadiariausuario) throws Exception {
		cajadiariausuarioAsignar.setId(cajadiariausuario.getId());	
		cajadiariausuarioAsignar.setVersionRow(cajadiariausuario.getVersionRow());	
		cajadiariausuarioAsignar.setid_cliente(cajadiariausuario.getid_cliente());
		cajadiariausuarioAsignar.setcliente_descripcion(cajadiariausuario.getcliente_descripcion());	
		cajadiariausuarioAsignar.setid_caja(cajadiariausuario.getid_caja());
		cajadiariausuarioAsignar.setcaja_descripcion(cajadiariausuario.getcaja_descripcion());	
		cajadiariausuarioAsignar.setid_usuario(cajadiariausuario.getid_usuario());
		cajadiariausuarioAsignar.setusuario_descripcion(cajadiariausuario.getusuario_descripcion());	
		cajadiariausuarioAsignar.setnombre_caja(cajadiariausuario.getnombre_caja());	
		cajadiariausuarioAsignar.setnombre_usuario(cajadiariausuario.getnombre_usuario());	
		cajadiariausuarioAsignar.setsecuencial(cajadiariausuario.getsecuencial());	
		cajadiariausuarioAsignar.setcodigo_cliente(cajadiariausuario.getcodigo_cliente());	
		cajadiariausuarioAsignar.setnombre_cliente(cajadiariausuario.getnombre_cliente());	
		cajadiariausuarioAsignar.setsubtotal(cajadiariausuario.getsubtotal());	
		cajadiariausuarioAsignar.setiva(cajadiariausuario.getiva());	
		cajadiariausuarioAsignar.setdescuento(cajadiariausuario.getdescuento());	
		cajadiariausuarioAsignar.setfinanciamiento(cajadiariausuario.getfinanciamiento());	
		cajadiariausuarioAsignar.setflete(cajadiariausuario.getflete());	
		cajadiariausuarioAsignar.setice(cajadiariausuario.getice());	
		cajadiariausuarioAsignar.settotal(cajadiariausuario.gettotal());	
	}
	
	public static void inicializarCajaDiariaUsuario(CajaDiariaUsuario cajadiariausuario) throws Exception {
		try {
				cajadiariausuario.setId(0L);	
					
				cajadiariausuario.setid_cliente(-1L);	
				cajadiariausuario.setid_caja(-1L);	
				cajadiariausuario.setid_usuario(-1L);	
				cajadiariausuario.setnombre_caja("");	
				cajadiariausuario.setnombre_usuario("");	
				cajadiariausuario.setsecuencial("");	
				cajadiariausuario.setcodigo_cliente("");	
				cajadiariausuario.setnombre_cliente("");	
				cajadiariausuario.setsubtotal(0.0);	
				cajadiariausuario.setiva(0.0);	
				cajadiariausuario.setdescuento(0.0);	
				cajadiariausuario.setfinanciamiento(0.0);	
				cajadiariausuario.setflete(0.0);	
				cajadiariausuario.setice(0.0);	
				cajadiariausuario.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCajaDiariaUsuario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_IDCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_NOMBRECAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_NOMBREUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_CODIGOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_FINANCIAMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaUsuarioConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCajaDiariaUsuario(String sTipo,Row row,Workbook workbook,CajaDiariaUsuario cajadiariausuario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getcaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getnombre_caja());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getnombre_usuario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getcodigo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getsubtotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getfinanciamiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariausuario.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCajaDiariaUsuario="";
	
	public String getsFinalQueryCajaDiariaUsuario() {
		return this.sFinalQueryCajaDiariaUsuario;
	}
	
	public void setsFinalQueryCajaDiariaUsuario(String sFinalQueryCajaDiariaUsuario) {
		this.sFinalQueryCajaDiariaUsuario= sFinalQueryCajaDiariaUsuario;
	}
	
	public Border resaltarSeleccionarCajaDiariaUsuario=null;
	
	public Border setResaltarSeleccionarCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCajaDiariaUsuario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCajaDiariaUsuario() {
		return this.resaltarSeleccionarCajaDiariaUsuario;
	}
	
	public void setResaltarSeleccionarCajaDiariaUsuario(Border borderResaltarSeleccionarCajaDiariaUsuario) {
		this.resaltarSeleccionarCajaDiariaUsuario= borderResaltarSeleccionarCajaDiariaUsuario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCajaDiariaUsuario=null;
	public Boolean mostraridCajaDiariaUsuario=true;
	public Boolean activaridCajaDiariaUsuario=true;

	public Border resaltarid_empresaCajaDiariaUsuario=null;
	public Boolean mostrarid_empresaCajaDiariaUsuario=true;
	public Boolean activarid_empresaCajaDiariaUsuario=true;
	public Boolean cargarid_empresaCajaDiariaUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCajaDiariaUsuario=false;//ConEventDepend=true

	public Border resaltarid_clienteCajaDiariaUsuario=null;
	public Boolean mostrarid_clienteCajaDiariaUsuario=true;
	public Boolean activarid_clienteCajaDiariaUsuario=false;
	public Boolean cargarid_clienteCajaDiariaUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteCajaDiariaUsuario=false;//ConEventDepend=true

	public Border resaltarid_cajaCajaDiariaUsuario=null;
	public Boolean mostrarid_cajaCajaDiariaUsuario=true;
	public Boolean activarid_cajaCajaDiariaUsuario=false;
	public Boolean cargarid_cajaCajaDiariaUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cajaCajaDiariaUsuario=false;//ConEventDepend=true

	public Border resaltarid_usuarioCajaDiariaUsuario=null;
	public Boolean mostrarid_usuarioCajaDiariaUsuario=true;
	public Boolean activarid_usuarioCajaDiariaUsuario=false;
	public Boolean cargarid_usuarioCajaDiariaUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioCajaDiariaUsuario=false;//ConEventDepend=true

	public Border resaltarfecha_inicioCajaDiariaUsuario=null;
	public Boolean mostrarfecha_inicioCajaDiariaUsuario=true;
	public Boolean activarfecha_inicioCajaDiariaUsuario=true;

	public Border resaltarfecha_finCajaDiariaUsuario=null;
	public Boolean mostrarfecha_finCajaDiariaUsuario=true;
	public Boolean activarfecha_finCajaDiariaUsuario=true;

	public Border resaltarnombre_cajaCajaDiariaUsuario=null;
	public Boolean mostrarnombre_cajaCajaDiariaUsuario=true;
	public Boolean activarnombre_cajaCajaDiariaUsuario=true;

	public Border resaltarnombre_usuarioCajaDiariaUsuario=null;
	public Boolean mostrarnombre_usuarioCajaDiariaUsuario=true;
	public Boolean activarnombre_usuarioCajaDiariaUsuario=true;

	public Border resaltarsecuencialCajaDiariaUsuario=null;
	public Boolean mostrarsecuencialCajaDiariaUsuario=true;
	public Boolean activarsecuencialCajaDiariaUsuario=true;

	public Border resaltarcodigo_clienteCajaDiariaUsuario=null;
	public Boolean mostrarcodigo_clienteCajaDiariaUsuario=true;
	public Boolean activarcodigo_clienteCajaDiariaUsuario=true;

	public Border resaltarnombre_clienteCajaDiariaUsuario=null;
	public Boolean mostrarnombre_clienteCajaDiariaUsuario=true;
	public Boolean activarnombre_clienteCajaDiariaUsuario=true;

	public Border resaltarsubtotalCajaDiariaUsuario=null;
	public Boolean mostrarsubtotalCajaDiariaUsuario=true;
	public Boolean activarsubtotalCajaDiariaUsuario=true;

	public Border resaltarivaCajaDiariaUsuario=null;
	public Boolean mostrarivaCajaDiariaUsuario=true;
	public Boolean activarivaCajaDiariaUsuario=true;

	public Border resaltardescuentoCajaDiariaUsuario=null;
	public Boolean mostrardescuentoCajaDiariaUsuario=true;
	public Boolean activardescuentoCajaDiariaUsuario=true;

	public Border resaltarfinanciamientoCajaDiariaUsuario=null;
	public Boolean mostrarfinanciamientoCajaDiariaUsuario=true;
	public Boolean activarfinanciamientoCajaDiariaUsuario=true;

	public Border resaltarfleteCajaDiariaUsuario=null;
	public Boolean mostrarfleteCajaDiariaUsuario=true;
	public Boolean activarfleteCajaDiariaUsuario=true;

	public Border resaltariceCajaDiariaUsuario=null;
	public Boolean mostrariceCajaDiariaUsuario=true;
	public Boolean activariceCajaDiariaUsuario=true;

	public Border resaltartotalCajaDiariaUsuario=null;
	public Boolean mostrartotalCajaDiariaUsuario=true;
	public Boolean activartotalCajaDiariaUsuario=true;

	
	

	public Border setResaltaridCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltaridCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCajaDiariaUsuario() {
		return this.resaltaridCajaDiariaUsuario;
	}

	public void setResaltaridCajaDiariaUsuario(Border borderResaltar) {
		this.resaltaridCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostraridCajaDiariaUsuario() {
		return this.mostraridCajaDiariaUsuario;
	}

	public void setMostraridCajaDiariaUsuario(Boolean mostraridCajaDiariaUsuario) {
		this.mostraridCajaDiariaUsuario= mostraridCajaDiariaUsuario;
	}

	public Boolean getActivaridCajaDiariaUsuario() {
		return this.activaridCajaDiariaUsuario;
	}

	public void setActivaridCajaDiariaUsuario(Boolean activaridCajaDiariaUsuario) {
		this.activaridCajaDiariaUsuario= activaridCajaDiariaUsuario;
	}

	public Border setResaltarid_empresaCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltarid_empresaCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCajaDiariaUsuario() {
		return this.resaltarid_empresaCajaDiariaUsuario;
	}

	public void setResaltarid_empresaCajaDiariaUsuario(Border borderResaltar) {
		this.resaltarid_empresaCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrarid_empresaCajaDiariaUsuario() {
		return this.mostrarid_empresaCajaDiariaUsuario;
	}

	public void setMostrarid_empresaCajaDiariaUsuario(Boolean mostrarid_empresaCajaDiariaUsuario) {
		this.mostrarid_empresaCajaDiariaUsuario= mostrarid_empresaCajaDiariaUsuario;
	}

	public Boolean getActivarid_empresaCajaDiariaUsuario() {
		return this.activarid_empresaCajaDiariaUsuario;
	}

	public void setActivarid_empresaCajaDiariaUsuario(Boolean activarid_empresaCajaDiariaUsuario) {
		this.activarid_empresaCajaDiariaUsuario= activarid_empresaCajaDiariaUsuario;
	}

	public Boolean getCargarid_empresaCajaDiariaUsuario() {
		return this.cargarid_empresaCajaDiariaUsuario;
	}

	public void setCargarid_empresaCajaDiariaUsuario(Boolean cargarid_empresaCajaDiariaUsuario) {
		this.cargarid_empresaCajaDiariaUsuario= cargarid_empresaCajaDiariaUsuario;
	}

	public Border setResaltarid_clienteCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltarid_clienteCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteCajaDiariaUsuario() {
		return this.resaltarid_clienteCajaDiariaUsuario;
	}

	public void setResaltarid_clienteCajaDiariaUsuario(Border borderResaltar) {
		this.resaltarid_clienteCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrarid_clienteCajaDiariaUsuario() {
		return this.mostrarid_clienteCajaDiariaUsuario;
	}

	public void setMostrarid_clienteCajaDiariaUsuario(Boolean mostrarid_clienteCajaDiariaUsuario) {
		this.mostrarid_clienteCajaDiariaUsuario= mostrarid_clienteCajaDiariaUsuario;
	}

	public Boolean getActivarid_clienteCajaDiariaUsuario() {
		return this.activarid_clienteCajaDiariaUsuario;
	}

	public void setActivarid_clienteCajaDiariaUsuario(Boolean activarid_clienteCajaDiariaUsuario) {
		this.activarid_clienteCajaDiariaUsuario= activarid_clienteCajaDiariaUsuario;
	}

	public Boolean getCargarid_clienteCajaDiariaUsuario() {
		return this.cargarid_clienteCajaDiariaUsuario;
	}

	public void setCargarid_clienteCajaDiariaUsuario(Boolean cargarid_clienteCajaDiariaUsuario) {
		this.cargarid_clienteCajaDiariaUsuario= cargarid_clienteCajaDiariaUsuario;
	}

	public Border setResaltarid_cajaCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltarid_cajaCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cajaCajaDiariaUsuario() {
		return this.resaltarid_cajaCajaDiariaUsuario;
	}

	public void setResaltarid_cajaCajaDiariaUsuario(Border borderResaltar) {
		this.resaltarid_cajaCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrarid_cajaCajaDiariaUsuario() {
		return this.mostrarid_cajaCajaDiariaUsuario;
	}

	public void setMostrarid_cajaCajaDiariaUsuario(Boolean mostrarid_cajaCajaDiariaUsuario) {
		this.mostrarid_cajaCajaDiariaUsuario= mostrarid_cajaCajaDiariaUsuario;
	}

	public Boolean getActivarid_cajaCajaDiariaUsuario() {
		return this.activarid_cajaCajaDiariaUsuario;
	}

	public void setActivarid_cajaCajaDiariaUsuario(Boolean activarid_cajaCajaDiariaUsuario) {
		this.activarid_cajaCajaDiariaUsuario= activarid_cajaCajaDiariaUsuario;
	}

	public Boolean getCargarid_cajaCajaDiariaUsuario() {
		return this.cargarid_cajaCajaDiariaUsuario;
	}

	public void setCargarid_cajaCajaDiariaUsuario(Boolean cargarid_cajaCajaDiariaUsuario) {
		this.cargarid_cajaCajaDiariaUsuario= cargarid_cajaCajaDiariaUsuario;
	}

	public Border setResaltarid_usuarioCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltarid_usuarioCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioCajaDiariaUsuario() {
		return this.resaltarid_usuarioCajaDiariaUsuario;
	}

	public void setResaltarid_usuarioCajaDiariaUsuario(Border borderResaltar) {
		this.resaltarid_usuarioCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrarid_usuarioCajaDiariaUsuario() {
		return this.mostrarid_usuarioCajaDiariaUsuario;
	}

	public void setMostrarid_usuarioCajaDiariaUsuario(Boolean mostrarid_usuarioCajaDiariaUsuario) {
		this.mostrarid_usuarioCajaDiariaUsuario= mostrarid_usuarioCajaDiariaUsuario;
	}

	public Boolean getActivarid_usuarioCajaDiariaUsuario() {
		return this.activarid_usuarioCajaDiariaUsuario;
	}

	public void setActivarid_usuarioCajaDiariaUsuario(Boolean activarid_usuarioCajaDiariaUsuario) {
		this.activarid_usuarioCajaDiariaUsuario= activarid_usuarioCajaDiariaUsuario;
	}

	public Boolean getCargarid_usuarioCajaDiariaUsuario() {
		return this.cargarid_usuarioCajaDiariaUsuario;
	}

	public void setCargarid_usuarioCajaDiariaUsuario(Boolean cargarid_usuarioCajaDiariaUsuario) {
		this.cargarid_usuarioCajaDiariaUsuario= cargarid_usuarioCajaDiariaUsuario;
	}

	public Border setResaltarfecha_inicioCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioCajaDiariaUsuario() {
		return this.resaltarfecha_inicioCajaDiariaUsuario;
	}

	public void setResaltarfecha_inicioCajaDiariaUsuario(Border borderResaltar) {
		this.resaltarfecha_inicioCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioCajaDiariaUsuario() {
		return this.mostrarfecha_inicioCajaDiariaUsuario;
	}

	public void setMostrarfecha_inicioCajaDiariaUsuario(Boolean mostrarfecha_inicioCajaDiariaUsuario) {
		this.mostrarfecha_inicioCajaDiariaUsuario= mostrarfecha_inicioCajaDiariaUsuario;
	}

	public Boolean getActivarfecha_inicioCajaDiariaUsuario() {
		return this.activarfecha_inicioCajaDiariaUsuario;
	}

	public void setActivarfecha_inicioCajaDiariaUsuario(Boolean activarfecha_inicioCajaDiariaUsuario) {
		this.activarfecha_inicioCajaDiariaUsuario= activarfecha_inicioCajaDiariaUsuario;
	}

	public Border setResaltarfecha_finCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltarfecha_finCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finCajaDiariaUsuario() {
		return this.resaltarfecha_finCajaDiariaUsuario;
	}

	public void setResaltarfecha_finCajaDiariaUsuario(Border borderResaltar) {
		this.resaltarfecha_finCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrarfecha_finCajaDiariaUsuario() {
		return this.mostrarfecha_finCajaDiariaUsuario;
	}

	public void setMostrarfecha_finCajaDiariaUsuario(Boolean mostrarfecha_finCajaDiariaUsuario) {
		this.mostrarfecha_finCajaDiariaUsuario= mostrarfecha_finCajaDiariaUsuario;
	}

	public Boolean getActivarfecha_finCajaDiariaUsuario() {
		return this.activarfecha_finCajaDiariaUsuario;
	}

	public void setActivarfecha_finCajaDiariaUsuario(Boolean activarfecha_finCajaDiariaUsuario) {
		this.activarfecha_finCajaDiariaUsuario= activarfecha_finCajaDiariaUsuario;
	}

	public Border setResaltarnombre_cajaCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltarnombre_cajaCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cajaCajaDiariaUsuario() {
		return this.resaltarnombre_cajaCajaDiariaUsuario;
	}

	public void setResaltarnombre_cajaCajaDiariaUsuario(Border borderResaltar) {
		this.resaltarnombre_cajaCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrarnombre_cajaCajaDiariaUsuario() {
		return this.mostrarnombre_cajaCajaDiariaUsuario;
	}

	public void setMostrarnombre_cajaCajaDiariaUsuario(Boolean mostrarnombre_cajaCajaDiariaUsuario) {
		this.mostrarnombre_cajaCajaDiariaUsuario= mostrarnombre_cajaCajaDiariaUsuario;
	}

	public Boolean getActivarnombre_cajaCajaDiariaUsuario() {
		return this.activarnombre_cajaCajaDiariaUsuario;
	}

	public void setActivarnombre_cajaCajaDiariaUsuario(Boolean activarnombre_cajaCajaDiariaUsuario) {
		this.activarnombre_cajaCajaDiariaUsuario= activarnombre_cajaCajaDiariaUsuario;
	}

	public Border setResaltarnombre_usuarioCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltarnombre_usuarioCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_usuarioCajaDiariaUsuario() {
		return this.resaltarnombre_usuarioCajaDiariaUsuario;
	}

	public void setResaltarnombre_usuarioCajaDiariaUsuario(Border borderResaltar) {
		this.resaltarnombre_usuarioCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrarnombre_usuarioCajaDiariaUsuario() {
		return this.mostrarnombre_usuarioCajaDiariaUsuario;
	}

	public void setMostrarnombre_usuarioCajaDiariaUsuario(Boolean mostrarnombre_usuarioCajaDiariaUsuario) {
		this.mostrarnombre_usuarioCajaDiariaUsuario= mostrarnombre_usuarioCajaDiariaUsuario;
	}

	public Boolean getActivarnombre_usuarioCajaDiariaUsuario() {
		return this.activarnombre_usuarioCajaDiariaUsuario;
	}

	public void setActivarnombre_usuarioCajaDiariaUsuario(Boolean activarnombre_usuarioCajaDiariaUsuario) {
		this.activarnombre_usuarioCajaDiariaUsuario= activarnombre_usuarioCajaDiariaUsuario;
	}

	public Border setResaltarsecuencialCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltarsecuencialCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialCajaDiariaUsuario() {
		return this.resaltarsecuencialCajaDiariaUsuario;
	}

	public void setResaltarsecuencialCajaDiariaUsuario(Border borderResaltar) {
		this.resaltarsecuencialCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrarsecuencialCajaDiariaUsuario() {
		return this.mostrarsecuencialCajaDiariaUsuario;
	}

	public void setMostrarsecuencialCajaDiariaUsuario(Boolean mostrarsecuencialCajaDiariaUsuario) {
		this.mostrarsecuencialCajaDiariaUsuario= mostrarsecuencialCajaDiariaUsuario;
	}

	public Boolean getActivarsecuencialCajaDiariaUsuario() {
		return this.activarsecuencialCajaDiariaUsuario;
	}

	public void setActivarsecuencialCajaDiariaUsuario(Boolean activarsecuencialCajaDiariaUsuario) {
		this.activarsecuencialCajaDiariaUsuario= activarsecuencialCajaDiariaUsuario;
	}

	public Border setResaltarcodigo_clienteCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltarcodigo_clienteCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_clienteCajaDiariaUsuario() {
		return this.resaltarcodigo_clienteCajaDiariaUsuario;
	}

	public void setResaltarcodigo_clienteCajaDiariaUsuario(Border borderResaltar) {
		this.resaltarcodigo_clienteCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrarcodigo_clienteCajaDiariaUsuario() {
		return this.mostrarcodigo_clienteCajaDiariaUsuario;
	}

	public void setMostrarcodigo_clienteCajaDiariaUsuario(Boolean mostrarcodigo_clienteCajaDiariaUsuario) {
		this.mostrarcodigo_clienteCajaDiariaUsuario= mostrarcodigo_clienteCajaDiariaUsuario;
	}

	public Boolean getActivarcodigo_clienteCajaDiariaUsuario() {
		return this.activarcodigo_clienteCajaDiariaUsuario;
	}

	public void setActivarcodigo_clienteCajaDiariaUsuario(Boolean activarcodigo_clienteCajaDiariaUsuario) {
		this.activarcodigo_clienteCajaDiariaUsuario= activarcodigo_clienteCajaDiariaUsuario;
	}

	public Border setResaltarnombre_clienteCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteCajaDiariaUsuario() {
		return this.resaltarnombre_clienteCajaDiariaUsuario;
	}

	public void setResaltarnombre_clienteCajaDiariaUsuario(Border borderResaltar) {
		this.resaltarnombre_clienteCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteCajaDiariaUsuario() {
		return this.mostrarnombre_clienteCajaDiariaUsuario;
	}

	public void setMostrarnombre_clienteCajaDiariaUsuario(Boolean mostrarnombre_clienteCajaDiariaUsuario) {
		this.mostrarnombre_clienteCajaDiariaUsuario= mostrarnombre_clienteCajaDiariaUsuario;
	}

	public Boolean getActivarnombre_clienteCajaDiariaUsuario() {
		return this.activarnombre_clienteCajaDiariaUsuario;
	}

	public void setActivarnombre_clienteCajaDiariaUsuario(Boolean activarnombre_clienteCajaDiariaUsuario) {
		this.activarnombre_clienteCajaDiariaUsuario= activarnombre_clienteCajaDiariaUsuario;
	}

	public Border setResaltarsubtotalCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltarsubtotalCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsubtotalCajaDiariaUsuario() {
		return this.resaltarsubtotalCajaDiariaUsuario;
	}

	public void setResaltarsubtotalCajaDiariaUsuario(Border borderResaltar) {
		this.resaltarsubtotalCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrarsubtotalCajaDiariaUsuario() {
		return this.mostrarsubtotalCajaDiariaUsuario;
	}

	public void setMostrarsubtotalCajaDiariaUsuario(Boolean mostrarsubtotalCajaDiariaUsuario) {
		this.mostrarsubtotalCajaDiariaUsuario= mostrarsubtotalCajaDiariaUsuario;
	}

	public Boolean getActivarsubtotalCajaDiariaUsuario() {
		return this.activarsubtotalCajaDiariaUsuario;
	}

	public void setActivarsubtotalCajaDiariaUsuario(Boolean activarsubtotalCajaDiariaUsuario) {
		this.activarsubtotalCajaDiariaUsuario= activarsubtotalCajaDiariaUsuario;
	}

	public Border setResaltarivaCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltarivaCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaCajaDiariaUsuario() {
		return this.resaltarivaCajaDiariaUsuario;
	}

	public void setResaltarivaCajaDiariaUsuario(Border borderResaltar) {
		this.resaltarivaCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrarivaCajaDiariaUsuario() {
		return this.mostrarivaCajaDiariaUsuario;
	}

	public void setMostrarivaCajaDiariaUsuario(Boolean mostrarivaCajaDiariaUsuario) {
		this.mostrarivaCajaDiariaUsuario= mostrarivaCajaDiariaUsuario;
	}

	public Boolean getActivarivaCajaDiariaUsuario() {
		return this.activarivaCajaDiariaUsuario;
	}

	public void setActivarivaCajaDiariaUsuario(Boolean activarivaCajaDiariaUsuario) {
		this.activarivaCajaDiariaUsuario= activarivaCajaDiariaUsuario;
	}

	public Border setResaltardescuentoCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltardescuentoCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoCajaDiariaUsuario() {
		return this.resaltardescuentoCajaDiariaUsuario;
	}

	public void setResaltardescuentoCajaDiariaUsuario(Border borderResaltar) {
		this.resaltardescuentoCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrardescuentoCajaDiariaUsuario() {
		return this.mostrardescuentoCajaDiariaUsuario;
	}

	public void setMostrardescuentoCajaDiariaUsuario(Boolean mostrardescuentoCajaDiariaUsuario) {
		this.mostrardescuentoCajaDiariaUsuario= mostrardescuentoCajaDiariaUsuario;
	}

	public Boolean getActivardescuentoCajaDiariaUsuario() {
		return this.activardescuentoCajaDiariaUsuario;
	}

	public void setActivardescuentoCajaDiariaUsuario(Boolean activardescuentoCajaDiariaUsuario) {
		this.activardescuentoCajaDiariaUsuario= activardescuentoCajaDiariaUsuario;
	}

	public Border setResaltarfinanciamientoCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltarfinanciamientoCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinanciamientoCajaDiariaUsuario() {
		return this.resaltarfinanciamientoCajaDiariaUsuario;
	}

	public void setResaltarfinanciamientoCajaDiariaUsuario(Border borderResaltar) {
		this.resaltarfinanciamientoCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrarfinanciamientoCajaDiariaUsuario() {
		return this.mostrarfinanciamientoCajaDiariaUsuario;
	}

	public void setMostrarfinanciamientoCajaDiariaUsuario(Boolean mostrarfinanciamientoCajaDiariaUsuario) {
		this.mostrarfinanciamientoCajaDiariaUsuario= mostrarfinanciamientoCajaDiariaUsuario;
	}

	public Boolean getActivarfinanciamientoCajaDiariaUsuario() {
		return this.activarfinanciamientoCajaDiariaUsuario;
	}

	public void setActivarfinanciamientoCajaDiariaUsuario(Boolean activarfinanciamientoCajaDiariaUsuario) {
		this.activarfinanciamientoCajaDiariaUsuario= activarfinanciamientoCajaDiariaUsuario;
	}

	public Border setResaltarfleteCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltarfleteCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteCajaDiariaUsuario() {
		return this.resaltarfleteCajaDiariaUsuario;
	}

	public void setResaltarfleteCajaDiariaUsuario(Border borderResaltar) {
		this.resaltarfleteCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrarfleteCajaDiariaUsuario() {
		return this.mostrarfleteCajaDiariaUsuario;
	}

	public void setMostrarfleteCajaDiariaUsuario(Boolean mostrarfleteCajaDiariaUsuario) {
		this.mostrarfleteCajaDiariaUsuario= mostrarfleteCajaDiariaUsuario;
	}

	public Boolean getActivarfleteCajaDiariaUsuario() {
		return this.activarfleteCajaDiariaUsuario;
	}

	public void setActivarfleteCajaDiariaUsuario(Boolean activarfleteCajaDiariaUsuario) {
		this.activarfleteCajaDiariaUsuario= activarfleteCajaDiariaUsuario;
	}

	public Border setResaltariceCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltariceCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceCajaDiariaUsuario() {
		return this.resaltariceCajaDiariaUsuario;
	}

	public void setResaltariceCajaDiariaUsuario(Border borderResaltar) {
		this.resaltariceCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrariceCajaDiariaUsuario() {
		return this.mostrariceCajaDiariaUsuario;
	}

	public void setMostrariceCajaDiariaUsuario(Boolean mostrariceCajaDiariaUsuario) {
		this.mostrariceCajaDiariaUsuario= mostrariceCajaDiariaUsuario;
	}

	public Boolean getActivariceCajaDiariaUsuario() {
		return this.activariceCajaDiariaUsuario;
	}

	public void setActivariceCajaDiariaUsuario(Boolean activariceCajaDiariaUsuario) {
		this.activariceCajaDiariaUsuario= activariceCajaDiariaUsuario;
	}

	public Border setResaltartotalCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariausuarioBeanSwingJInternalFrame.jTtoolBarCajaDiariaUsuario.setBorder(borderResaltar);
		
		this.resaltartotalCajaDiariaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalCajaDiariaUsuario() {
		return this.resaltartotalCajaDiariaUsuario;
	}

	public void setResaltartotalCajaDiariaUsuario(Border borderResaltar) {
		this.resaltartotalCajaDiariaUsuario= borderResaltar;
	}

	public Boolean getMostrartotalCajaDiariaUsuario() {
		return this.mostrartotalCajaDiariaUsuario;
	}

	public void setMostrartotalCajaDiariaUsuario(Boolean mostrartotalCajaDiariaUsuario) {
		this.mostrartotalCajaDiariaUsuario= mostrartotalCajaDiariaUsuario;
	}

	public Boolean getActivartotalCajaDiariaUsuario() {
		return this.activartotalCajaDiariaUsuario;
	}

	public void setActivartotalCajaDiariaUsuario(Boolean activartotalCajaDiariaUsuario) {
		this.activartotalCajaDiariaUsuario= activartotalCajaDiariaUsuario;
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
		
		
		this.setMostraridCajaDiariaUsuario(esInicial);
		this.setMostrarid_empresaCajaDiariaUsuario(esInicial);
		this.setMostrarid_clienteCajaDiariaUsuario(esInicial);
		this.setMostrarid_cajaCajaDiariaUsuario(esInicial);
		this.setMostrarid_usuarioCajaDiariaUsuario(esInicial);
		this.setMostrarfecha_inicioCajaDiariaUsuario(esInicial);
		this.setMostrarfecha_finCajaDiariaUsuario(esInicial);
		this.setMostrarnombre_cajaCajaDiariaUsuario(esInicial);
		this.setMostrarnombre_usuarioCajaDiariaUsuario(esInicial);
		this.setMostrarsecuencialCajaDiariaUsuario(esInicial);
		this.setMostrarcodigo_clienteCajaDiariaUsuario(esInicial);
		this.setMostrarnombre_clienteCajaDiariaUsuario(esInicial);
		this.setMostrarsubtotalCajaDiariaUsuario(esInicial);
		this.setMostrarivaCajaDiariaUsuario(esInicial);
		this.setMostrardescuentoCajaDiariaUsuario(esInicial);
		this.setMostrarfinanciamientoCajaDiariaUsuario(esInicial);
		this.setMostrarfleteCajaDiariaUsuario(esInicial);
		this.setMostrariceCajaDiariaUsuario(esInicial);
		this.setMostrartotalCajaDiariaUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.ID)) {
				this.setMostraridCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.IDCAJA)) {
				this.setMostrarid_cajaCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.NOMBRECAJA)) {
				this.setMostrarnombre_cajaCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.NOMBREUSUARIO)) {
				this.setMostrarnombre_usuarioCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.CODIGOCLIENTE)) {
				this.setMostrarcodigo_clienteCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsubtotalCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.IVA)) {
				this.setMostrarivaCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.FINANCIAMIENTO)) {
				this.setMostrarfinanciamientoCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.FLETE)) {
				this.setMostrarfleteCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.ICE)) {
				this.setMostrariceCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.TOTAL)) {
				this.setMostrartotalCajaDiariaUsuario(esAsigna);
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
		
		
		this.setActivaridCajaDiariaUsuario(esInicial);
		this.setActivarid_empresaCajaDiariaUsuario(esInicial);
		this.setActivarid_clienteCajaDiariaUsuario(esInicial);
		this.setActivarid_cajaCajaDiariaUsuario(esInicial);
		this.setActivarid_usuarioCajaDiariaUsuario(esInicial);
		this.setActivarfecha_inicioCajaDiariaUsuario(esInicial);
		this.setActivarfecha_finCajaDiariaUsuario(esInicial);
		this.setActivarnombre_cajaCajaDiariaUsuario(esInicial);
		this.setActivarnombre_usuarioCajaDiariaUsuario(esInicial);
		this.setActivarsecuencialCajaDiariaUsuario(esInicial);
		this.setActivarcodigo_clienteCajaDiariaUsuario(esInicial);
		this.setActivarnombre_clienteCajaDiariaUsuario(esInicial);
		this.setActivarsubtotalCajaDiariaUsuario(esInicial);
		this.setActivarivaCajaDiariaUsuario(esInicial);
		this.setActivardescuentoCajaDiariaUsuario(esInicial);
		this.setActivarfinanciamientoCajaDiariaUsuario(esInicial);
		this.setActivarfleteCajaDiariaUsuario(esInicial);
		this.setActivariceCajaDiariaUsuario(esInicial);
		this.setActivartotalCajaDiariaUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.ID)) {
				this.setActivaridCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.IDCAJA)) {
				this.setActivarid_cajaCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.NOMBRECAJA)) {
				this.setActivarnombre_cajaCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.NOMBREUSUARIO)) {
				this.setActivarnombre_usuarioCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.CODIGOCLIENTE)) {
				this.setActivarcodigo_clienteCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.SUBTOTAL)) {
				this.setActivarsubtotalCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.IVA)) {
				this.setActivarivaCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.FINANCIAMIENTO)) {
				this.setActivarfinanciamientoCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.FLETE)) {
				this.setActivarfleteCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.ICE)) {
				this.setActivariceCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.TOTAL)) {
				this.setActivartotalCajaDiariaUsuario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCajaDiariaUsuario(esInicial);
		this.setResaltarid_empresaCajaDiariaUsuario(esInicial);
		this.setResaltarid_clienteCajaDiariaUsuario(esInicial);
		this.setResaltarid_cajaCajaDiariaUsuario(esInicial);
		this.setResaltarid_usuarioCajaDiariaUsuario(esInicial);
		this.setResaltarfecha_inicioCajaDiariaUsuario(esInicial);
		this.setResaltarfecha_finCajaDiariaUsuario(esInicial);
		this.setResaltarnombre_cajaCajaDiariaUsuario(esInicial);
		this.setResaltarnombre_usuarioCajaDiariaUsuario(esInicial);
		this.setResaltarsecuencialCajaDiariaUsuario(esInicial);
		this.setResaltarcodigo_clienteCajaDiariaUsuario(esInicial);
		this.setResaltarnombre_clienteCajaDiariaUsuario(esInicial);
		this.setResaltarsubtotalCajaDiariaUsuario(esInicial);
		this.setResaltarivaCajaDiariaUsuario(esInicial);
		this.setResaltardescuentoCajaDiariaUsuario(esInicial);
		this.setResaltarfinanciamientoCajaDiariaUsuario(esInicial);
		this.setResaltarfleteCajaDiariaUsuario(esInicial);
		this.setResaltariceCajaDiariaUsuario(esInicial);
		this.setResaltartotalCajaDiariaUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.ID)) {
				this.setResaltaridCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.IDCAJA)) {
				this.setResaltarid_cajaCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.NOMBRECAJA)) {
				this.setResaltarnombre_cajaCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.NOMBREUSUARIO)) {
				this.setResaltarnombre_usuarioCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.CODIGOCLIENTE)) {
				this.setResaltarcodigo_clienteCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsubtotalCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.IVA)) {
				this.setResaltarivaCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.FINANCIAMIENTO)) {
				this.setResaltarfinanciamientoCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.FLETE)) {
				this.setResaltarfleteCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.ICE)) {
				this.setResaltariceCajaDiariaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaUsuarioConstantesFunciones.TOTAL)) {
				this.setResaltartotalCajaDiariaUsuario(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaCajaDiariaUsuarioCajaDiariaUsuario=true;

	public Boolean getMostrarBusquedaCajaDiariaUsuarioCajaDiariaUsuario() {
		return this.mostrarBusquedaCajaDiariaUsuarioCajaDiariaUsuario;
	}

	public void setMostrarBusquedaCajaDiariaUsuarioCajaDiariaUsuario(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCajaDiariaUsuarioCajaDiariaUsuario= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCajaDiariaUsuarioCajaDiariaUsuario=true;

	public Boolean getActivarBusquedaCajaDiariaUsuarioCajaDiariaUsuario() {
		return this.activarBusquedaCajaDiariaUsuarioCajaDiariaUsuario;
	}

	public void setActivarBusquedaCajaDiariaUsuarioCajaDiariaUsuario(Boolean habilitarResaltar) {
		this.activarBusquedaCajaDiariaUsuarioCajaDiariaUsuario= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCajaDiariaUsuarioCajaDiariaUsuario=null;

	public Border getResaltarBusquedaCajaDiariaUsuarioCajaDiariaUsuario() {
		return this.resaltarBusquedaCajaDiariaUsuarioCajaDiariaUsuario;
	}

	public void setResaltarBusquedaCajaDiariaUsuarioCajaDiariaUsuario(Border borderResaltar) {
		this.resaltarBusquedaCajaDiariaUsuarioCajaDiariaUsuario= borderResaltar;
	}

	public void setResaltarBusquedaCajaDiariaUsuarioCajaDiariaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaUsuarioBeanSwingJInternalFrame cajadiariausuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCajaDiariaUsuarioCajaDiariaUsuario= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
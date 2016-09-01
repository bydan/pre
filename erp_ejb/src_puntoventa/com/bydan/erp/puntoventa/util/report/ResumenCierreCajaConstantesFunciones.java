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


import com.bydan.erp.puntoventa.util.report.ResumenCierreCajaConstantesFunciones;
import com.bydan.erp.puntoventa.util.report.ResumenCierreCajaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.ResumenCierreCajaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.puntoventa.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ResumenCierreCajaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ResumenCierreCaja";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ResumenCierreCaja"+ResumenCierreCajaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ResumenCierreCajaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ResumenCierreCajaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ResumenCierreCajaConstantesFunciones.SCHEMA+"_"+ResumenCierreCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ResumenCierreCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ResumenCierreCajaConstantesFunciones.SCHEMA+"_"+ResumenCierreCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ResumenCierreCajaConstantesFunciones.SCHEMA+"_"+ResumenCierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ResumenCierreCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ResumenCierreCajaConstantesFunciones.SCHEMA+"_"+ResumenCierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResumenCierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ResumenCierreCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResumenCierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResumenCierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ResumenCierreCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResumenCierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ResumenCierreCajaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ResumenCierreCajaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ResumenCierreCajaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ResumenCierreCajaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Resumen Cierre Cajas";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Resumen Cierre Caja";
	public static final String SCLASSWEBTITULO_LOWER="Resumen Cierre Caja";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ResumenCierreCaja";
	public static final String OBJECTNAME="resumencierrecaja";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="resumen_cierre_caja";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select resumencierrecaja from "+ResumenCierreCajaConstantesFunciones.SPERSISTENCENAME+" resumencierrecaja";
	public static String QUERYSELECTNATIVE="select "+ResumenCierreCajaConstantesFunciones.SCHEMA+"."+ResumenCierreCajaConstantesFunciones.TABLENAME+".id,"+ResumenCierreCajaConstantesFunciones.SCHEMA+"."+ResumenCierreCajaConstantesFunciones.TABLENAME+".version_row,"+ResumenCierreCajaConstantesFunciones.SCHEMA+"."+ResumenCierreCajaConstantesFunciones.TABLENAME+".id_empresa,"+ResumenCierreCajaConstantesFunciones.SCHEMA+"."+ResumenCierreCajaConstantesFunciones.TABLENAME+".id_sucursal,"+ResumenCierreCajaConstantesFunciones.SCHEMA+"."+ResumenCierreCajaConstantesFunciones.TABLENAME+".id_usuario,"+ResumenCierreCajaConstantesFunciones.SCHEMA+"."+ResumenCierreCajaConstantesFunciones.TABLENAME+".id_caja,"+ResumenCierreCajaConstantesFunciones.SCHEMA+"."+ResumenCierreCajaConstantesFunciones.TABLENAME+".fecha,"+ResumenCierreCajaConstantesFunciones.SCHEMA+"."+ResumenCierreCajaConstantesFunciones.TABLENAME+".tipo_pago,"+ResumenCierreCajaConstantesFunciones.SCHEMA+"."+ResumenCierreCajaConstantesFunciones.TABLENAME+".nombre_usuario,"+ResumenCierreCajaConstantesFunciones.SCHEMA+"."+ResumenCierreCajaConstantesFunciones.TABLENAME+".nombre_caja,"+ResumenCierreCajaConstantesFunciones.SCHEMA+"."+ResumenCierreCajaConstantesFunciones.TABLENAME+".valor,"+ResumenCierreCajaConstantesFunciones.SCHEMA+"."+ResumenCierreCajaConstantesFunciones.TABLENAME+".total from "+ResumenCierreCajaConstantesFunciones.SCHEMA+"."+ResumenCierreCajaConstantesFunciones.TABLENAME;//+" as "+ResumenCierreCajaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDCAJA= "id_caja";
    public static final String FECHA= "fecha";
    public static final String TIPOPAGO= "tipo_pago";
    public static final String NOMBREUSUARIO= "nombre_usuario";
    public static final String NOMBRECAJA= "nombre_caja";
    public static final String VALOR= "valor";
    public static final String TOTAL= "total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDCAJA= "Caja";
		public static final String LABEL_IDCAJA_LOWER= "Caja";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_TIPOPAGO= "Tipo Pago";
		public static final String LABEL_TIPOPAGO_LOWER= "Tipo Pago";
    	public static final String LABEL_NOMBREUSUARIO= "Nombre Usuario";
		public static final String LABEL_NOMBREUSUARIO_LOWER= "Nombre Usuario";
    	public static final String LABEL_NOMBRECAJA= "Nombre Caja";
		public static final String LABEL_NOMBRECAJA_LOWER= "Nombre Caja";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
		
		
		
	public static final String SREGEXTIPO_PAGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO_PAGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_USUARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_USUARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CAJA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CAJA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getResumenCierreCajaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ResumenCierreCajaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ResumenCierreCajaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ResumenCierreCajaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ResumenCierreCajaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ResumenCierreCajaConstantesFunciones.IDUSUARIO)) {sLabelColumna=ResumenCierreCajaConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(ResumenCierreCajaConstantesFunciones.IDCAJA)) {sLabelColumna=ResumenCierreCajaConstantesFunciones.LABEL_IDCAJA;}
		if(sNombreColumna.equals(ResumenCierreCajaConstantesFunciones.FECHA)) {sLabelColumna=ResumenCierreCajaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ResumenCierreCajaConstantesFunciones.TIPOPAGO)) {sLabelColumna=ResumenCierreCajaConstantesFunciones.LABEL_TIPOPAGO;}
		if(sNombreColumna.equals(ResumenCierreCajaConstantesFunciones.NOMBREUSUARIO)) {sLabelColumna=ResumenCierreCajaConstantesFunciones.LABEL_NOMBREUSUARIO;}
		if(sNombreColumna.equals(ResumenCierreCajaConstantesFunciones.NOMBRECAJA)) {sLabelColumna=ResumenCierreCajaConstantesFunciones.LABEL_NOMBRECAJA;}
		if(sNombreColumna.equals(ResumenCierreCajaConstantesFunciones.VALOR)) {sLabelColumna=ResumenCierreCajaConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(ResumenCierreCajaConstantesFunciones.TOTAL)) {sLabelColumna=ResumenCierreCajaConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getResumenCierreCajaDescripcion(ResumenCierreCaja resumencierrecaja) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(resumencierrecaja !=null/* && resumencierrecaja.getId()!=0*/) {
			if(resumencierrecaja.getId()!=null) {
				sDescripcion=resumencierrecaja.getId().toString();
			}//resumencierrecajaresumencierrecaja.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getResumenCierreCajaDescripcionDetallado(ResumenCierreCaja resumencierrecaja) {
		String sDescripcion="";
			
		sDescripcion+=ResumenCierreCajaConstantesFunciones.ID+"=";
		sDescripcion+=resumencierrecaja.getId().toString()+",";
		sDescripcion+=ResumenCierreCajaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=resumencierrecaja.getVersionRow().toString()+",";
		sDescripcion+=ResumenCierreCajaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=resumencierrecaja.getid_empresa().toString()+",";
		sDescripcion+=ResumenCierreCajaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=resumencierrecaja.getid_sucursal().toString()+",";
		sDescripcion+=ResumenCierreCajaConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=resumencierrecaja.getid_usuario().toString()+",";
		sDescripcion+=ResumenCierreCajaConstantesFunciones.IDCAJA+"=";
		sDescripcion+=resumencierrecaja.getid_caja().toString()+",";
		sDescripcion+=ResumenCierreCajaConstantesFunciones.FECHA+"=";
		sDescripcion+=resumencierrecaja.getfecha().toString()+",";
		sDescripcion+=ResumenCierreCajaConstantesFunciones.TIPOPAGO+"=";
		sDescripcion+=resumencierrecaja.gettipo_pago()+",";
		sDescripcion+=ResumenCierreCajaConstantesFunciones.NOMBREUSUARIO+"=";
		sDescripcion+=resumencierrecaja.getnombre_usuario()+",";
		sDescripcion+=ResumenCierreCajaConstantesFunciones.NOMBRECAJA+"=";
		sDescripcion+=resumencierrecaja.getnombre_caja()+",";
		sDescripcion+=ResumenCierreCajaConstantesFunciones.VALOR+"=";
		sDescripcion+=resumencierrecaja.getvalor().toString()+",";
		sDescripcion+=ResumenCierreCajaConstantesFunciones.TOTAL+"=";
		sDescripcion+=resumencierrecaja.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setResumenCierreCajaDescripcion(ResumenCierreCaja resumencierrecaja,String sValor) throws Exception {			
		if(resumencierrecaja !=null) {
			//resumencierrecajaresumencierrecaja.getId().toString();
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaResumenCierreCaja")) {
			sNombreIndice="Tipo=  Por Usuario Por Caja Por Fecha";
		} else if(sNombreIndice.equals("FK_IdCaja")) {
			sNombreIndice="Tipo=  Por Caja";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
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

	public static String getDetalleIndiceBusquedaResumenCierreCaja(Long id_usuario,Long id_caja,Date fecha) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();}
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();}
		if(fecha!=null) {sDetalleIndice+=" Fecha="+fecha.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCaja(Long id_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosResumenCierreCaja(ResumenCierreCaja resumencierrecaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		resumencierrecaja.settipo_pago(resumencierrecaja.gettipo_pago().trim());
		resumencierrecaja.setnombre_usuario(resumencierrecaja.getnombre_usuario().trim());
		resumencierrecaja.setnombre_caja(resumencierrecaja.getnombre_caja().trim());
	}
	
	public static void quitarEspaciosResumenCierreCajas(List<ResumenCierreCaja> resumencierrecajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ResumenCierreCaja resumencierrecaja: resumencierrecajas) {
			resumencierrecaja.settipo_pago(resumencierrecaja.gettipo_pago().trim());
			resumencierrecaja.setnombre_usuario(resumencierrecaja.getnombre_usuario().trim());
			resumencierrecaja.setnombre_caja(resumencierrecaja.getnombre_caja().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresResumenCierreCaja(ResumenCierreCaja resumencierrecaja,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && resumencierrecaja.getConCambioAuxiliar()) {
			resumencierrecaja.setIsDeleted(resumencierrecaja.getIsDeletedAuxiliar());	
			resumencierrecaja.setIsNew(resumencierrecaja.getIsNewAuxiliar());	
			resumencierrecaja.setIsChanged(resumencierrecaja.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			resumencierrecaja.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			resumencierrecaja.setIsDeletedAuxiliar(false);	
			resumencierrecaja.setIsNewAuxiliar(false);	
			resumencierrecaja.setIsChangedAuxiliar(false);
			
			resumencierrecaja.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresResumenCierreCajas(List<ResumenCierreCaja> resumencierrecajas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ResumenCierreCaja resumencierrecaja : resumencierrecajas) {
			if(conAsignarBase && resumencierrecaja.getConCambioAuxiliar()) {
				resumencierrecaja.setIsDeleted(resumencierrecaja.getIsDeletedAuxiliar());	
				resumencierrecaja.setIsNew(resumencierrecaja.getIsNewAuxiliar());	
				resumencierrecaja.setIsChanged(resumencierrecaja.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				resumencierrecaja.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				resumencierrecaja.setIsDeletedAuxiliar(false);	
				resumencierrecaja.setIsNewAuxiliar(false);	
				resumencierrecaja.setIsChangedAuxiliar(false);
				
				resumencierrecaja.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresResumenCierreCaja(ResumenCierreCaja resumencierrecaja,Boolean conEnteros) throws Exception  {
		resumencierrecaja.setvalor(0.0);
		resumencierrecaja.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresResumenCierreCajas(List<ResumenCierreCaja> resumencierrecajas,Boolean conEnteros) throws Exception  {
		
		for(ResumenCierreCaja resumencierrecaja: resumencierrecajas) {
			resumencierrecaja.setvalor(0.0);
			resumencierrecaja.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaResumenCierreCaja(List<ResumenCierreCaja> resumencierrecajas,ResumenCierreCaja resumencierrecajaAux) throws Exception  {
		ResumenCierreCajaConstantesFunciones.InicializarValoresResumenCierreCaja(resumencierrecajaAux,true);
		
		for(ResumenCierreCaja resumencierrecaja: resumencierrecajas) {
			if(resumencierrecaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			resumencierrecajaAux.setvalor(resumencierrecajaAux.getvalor()+resumencierrecaja.getvalor());			
			resumencierrecajaAux.settotal(resumencierrecajaAux.gettotal()+resumencierrecaja.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesResumenCierreCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ResumenCierreCajaConstantesFunciones.getArrayColumnasGlobalesResumenCierreCaja(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesResumenCierreCaja(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ResumenCierreCajaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ResumenCierreCajaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ResumenCierreCajaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ResumenCierreCajaConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ResumenCierreCajaConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ResumenCierreCajaConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoResumenCierreCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ResumenCierreCaja> resumencierrecajas,ResumenCierreCaja resumencierrecaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ResumenCierreCaja resumencierrecajaAux: resumencierrecajas) {
			if(resumencierrecajaAux!=null && resumencierrecaja!=null) {
				if((resumencierrecajaAux.getId()==null && resumencierrecaja.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(resumencierrecajaAux.getId()!=null && resumencierrecaja.getId()!=null){
					if(resumencierrecajaAux.getId().equals(resumencierrecaja.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaResumenCierreCaja(List<ResumenCierreCaja> resumencierrecajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double totalTotal=0.0;
	
		for(ResumenCierreCaja resumencierrecaja: resumencierrecajas) {			
			if(resumencierrecaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=resumencierrecaja.getvalor();
			totalTotal+=resumencierrecaja.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ResumenCierreCajaConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ResumenCierreCajaConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ResumenCierreCajaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ResumenCierreCajaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaResumenCierreCaja() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ResumenCierreCajaConstantesFunciones.LABEL_ID, ResumenCierreCajaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenCierreCajaConstantesFunciones.LABEL_VERSIONROW, ResumenCierreCajaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenCierreCajaConstantesFunciones.LABEL_IDUSUARIO, ResumenCierreCajaConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenCierreCajaConstantesFunciones.LABEL_IDCAJA, ResumenCierreCajaConstantesFunciones.IDCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenCierreCajaConstantesFunciones.LABEL_TIPOPAGO, ResumenCierreCajaConstantesFunciones.TIPOPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenCierreCajaConstantesFunciones.LABEL_NOMBREUSUARIO, ResumenCierreCajaConstantesFunciones.NOMBREUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenCierreCajaConstantesFunciones.LABEL_NOMBRECAJA, ResumenCierreCajaConstantesFunciones.NOMBRECAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenCierreCajaConstantesFunciones.LABEL_VALOR, ResumenCierreCajaConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenCierreCajaConstantesFunciones.LABEL_TOTAL, ResumenCierreCajaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasResumenCierreCaja() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ResumenCierreCajaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenCierreCajaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenCierreCajaConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenCierreCajaConstantesFunciones.IDCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenCierreCajaConstantesFunciones.TIPOPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenCierreCajaConstantesFunciones.NOMBREUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenCierreCajaConstantesFunciones.NOMBRECAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenCierreCajaConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenCierreCajaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResumenCierreCaja() throws Exception  {
		return ResumenCierreCajaConstantesFunciones.getTiposSeleccionarResumenCierreCaja(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResumenCierreCaja(Boolean conFk) throws Exception  {
		return ResumenCierreCajaConstantesFunciones.getTiposSeleccionarResumenCierreCaja(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResumenCierreCaja(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenCierreCajaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ResumenCierreCajaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenCierreCajaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ResumenCierreCajaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenCierreCajaConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(ResumenCierreCajaConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenCierreCajaConstantesFunciones.LABEL_IDCAJA);
			reporte.setsDescripcion(ResumenCierreCajaConstantesFunciones.LABEL_IDCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenCierreCajaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ResumenCierreCajaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenCierreCajaConstantesFunciones.LABEL_TIPOPAGO);
			reporte.setsDescripcion(ResumenCierreCajaConstantesFunciones.LABEL_TIPOPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenCierreCajaConstantesFunciones.LABEL_NOMBREUSUARIO);
			reporte.setsDescripcion(ResumenCierreCajaConstantesFunciones.LABEL_NOMBREUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenCierreCajaConstantesFunciones.LABEL_NOMBRECAJA);
			reporte.setsDescripcion(ResumenCierreCajaConstantesFunciones.LABEL_NOMBRECAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenCierreCajaConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ResumenCierreCajaConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenCierreCajaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(ResumenCierreCajaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesResumenCierreCaja(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesResumenCierreCaja(ResumenCierreCaja resumencierrecajaAux) throws Exception {
		
			resumencierrecajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(resumencierrecajaAux.getEmpresa()));
			resumencierrecajaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(resumencierrecajaAux.getSucursal()));
			resumencierrecajaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(resumencierrecajaAux.getUsuario()));
			resumencierrecajaAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(resumencierrecajaAux.getCaja()));		
	}
	
	public static void refrescarForeignKeysDescripcionesResumenCierreCaja(List<ResumenCierreCaja> resumencierrecajasTemp) throws Exception {
		for(ResumenCierreCaja resumencierrecajaAux:resumencierrecajasTemp) {
			
			resumencierrecajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(resumencierrecajaAux.getEmpresa()));
			resumencierrecajaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(resumencierrecajaAux.getSucursal()));
			resumencierrecajaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(resumencierrecajaAux.getUsuario()));
			resumencierrecajaAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(resumencierrecajaAux.getCaja()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfResumenCierreCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Caja.class));
				
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
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Caja.class)) {
						classes.add(new Classe(Caja.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfResumenCierreCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfResumenCierreCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ResumenCierreCajaConstantesFunciones.getClassesRelationshipsOfResumenCierreCaja(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfResumenCierreCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfResumenCierreCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ResumenCierreCajaConstantesFunciones.getClassesRelationshipsFromStringsOfResumenCierreCaja(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfResumenCierreCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ResumenCierreCaja resumencierrecaja,List<ResumenCierreCaja> resumencierrecajas,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ResumenCierreCaja resumencierrecaja,List<ResumenCierreCaja> resumencierrecajas) throws Exception {
		try	{			
			for(ResumenCierreCaja resumencierrecajaLocal:resumencierrecajas) {
				if(resumencierrecajaLocal.getId().equals(resumencierrecaja.getId())) {
					resumencierrecajaLocal.setIsSelected(resumencierrecaja.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesResumenCierreCaja(List<ResumenCierreCaja> resumencierrecajasAux) throws Exception {
		//this.resumencierrecajasAux=resumencierrecajasAux;
		
		for(ResumenCierreCaja resumencierrecajaAux:resumencierrecajasAux) {
			if(resumencierrecajaAux.getIsChanged()) {
				resumencierrecajaAux.setIsChanged(false);
			}		
			
			if(resumencierrecajaAux.getIsNew()) {
				resumencierrecajaAux.setIsNew(false);
			}	
			
			if(resumencierrecajaAux.getIsDeleted()) {
				resumencierrecajaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesResumenCierreCaja(ResumenCierreCaja resumencierrecajaAux) throws Exception {
		//this.resumencierrecajaAux=resumencierrecajaAux;
		
			if(resumencierrecajaAux.getIsChanged()) {
				resumencierrecajaAux.setIsChanged(false);
			}		
			
			if(resumencierrecajaAux.getIsNew()) {
				resumencierrecajaAux.setIsNew(false);
			}	
			
			if(resumencierrecajaAux.getIsDeleted()) {
				resumencierrecajaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ResumenCierreCaja resumencierrecajaAsignar,ResumenCierreCaja resumencierrecaja) throws Exception {
		resumencierrecajaAsignar.setId(resumencierrecaja.getId());	
		resumencierrecajaAsignar.setVersionRow(resumencierrecaja.getVersionRow());	
		resumencierrecajaAsignar.setid_usuario(resumencierrecaja.getid_usuario());
		resumencierrecajaAsignar.setusuario_descripcion(resumencierrecaja.getusuario_descripcion());	
		resumencierrecajaAsignar.setid_caja(resumencierrecaja.getid_caja());
		resumencierrecajaAsignar.setcaja_descripcion(resumencierrecaja.getcaja_descripcion());	
		resumencierrecajaAsignar.settipo_pago(resumencierrecaja.gettipo_pago());	
		resumencierrecajaAsignar.setnombre_usuario(resumencierrecaja.getnombre_usuario());	
		resumencierrecajaAsignar.setnombre_caja(resumencierrecaja.getnombre_caja());	
		resumencierrecajaAsignar.setvalor(resumencierrecaja.getvalor());	
		resumencierrecajaAsignar.settotal(resumencierrecaja.gettotal());	
	}
	
	public static void inicializarResumenCierreCaja(ResumenCierreCaja resumencierrecaja) throws Exception {
		try {
				resumencierrecaja.setId(0L);	
					
				resumencierrecaja.setid_usuario(-1L);	
				resumencierrecaja.setid_caja(-1L);	
				resumencierrecaja.settipo_pago("");	
				resumencierrecaja.setnombre_usuario("");	
				resumencierrecaja.setnombre_caja("");	
				resumencierrecaja.setvalor(0.0);	
				resumencierrecaja.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderResumenCierreCaja(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenCierreCajaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenCierreCajaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenCierreCajaConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenCierreCajaConstantesFunciones.LABEL_IDCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenCierreCajaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenCierreCajaConstantesFunciones.LABEL_TIPOPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenCierreCajaConstantesFunciones.LABEL_NOMBREUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenCierreCajaConstantesFunciones.LABEL_NOMBRECAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenCierreCajaConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenCierreCajaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataResumenCierreCaja(String sTipo,Row row,Workbook workbook,ResumenCierreCaja resumencierrecaja,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(resumencierrecaja.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumencierrecaja.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumencierrecaja.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumencierrecaja.getcaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumencierrecaja.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumencierrecaja.gettipo_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumencierrecaja.getnombre_usuario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumencierrecaja.getnombre_caja());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumencierrecaja.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumencierrecaja.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryResumenCierreCaja="";
	
	public String getsFinalQueryResumenCierreCaja() {
		return this.sFinalQueryResumenCierreCaja;
	}
	
	public void setsFinalQueryResumenCierreCaja(String sFinalQueryResumenCierreCaja) {
		this.sFinalQueryResumenCierreCaja= sFinalQueryResumenCierreCaja;
	}
	
	public Border resaltarSeleccionarResumenCierreCaja=null;
	
	public Border setResaltarSeleccionarResumenCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenCierreCajaBeanSwingJInternalFrame resumencierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//resumencierrecajaBeanSwingJInternalFrame.jTtoolBarResumenCierreCaja.setBorder(borderResaltar);
		
		this.resaltarSeleccionarResumenCierreCaja= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarResumenCierreCaja() {
		return this.resaltarSeleccionarResumenCierreCaja;
	}
	
	public void setResaltarSeleccionarResumenCierreCaja(Border borderResaltarSeleccionarResumenCierreCaja) {
		this.resaltarSeleccionarResumenCierreCaja= borderResaltarSeleccionarResumenCierreCaja;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridResumenCierreCaja=null;
	public Boolean mostraridResumenCierreCaja=true;
	public Boolean activaridResumenCierreCaja=true;

	public Border resaltarid_empresaResumenCierreCaja=null;
	public Boolean mostrarid_empresaResumenCierreCaja=true;
	public Boolean activarid_empresaResumenCierreCaja=true;
	public Boolean cargarid_empresaResumenCierreCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaResumenCierreCaja=false;//ConEventDepend=true

	public Border resaltarid_sucursalResumenCierreCaja=null;
	public Boolean mostrarid_sucursalResumenCierreCaja=true;
	public Boolean activarid_sucursalResumenCierreCaja=true;
	public Boolean cargarid_sucursalResumenCierreCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalResumenCierreCaja=false;//ConEventDepend=true

	public Border resaltarid_usuarioResumenCierreCaja=null;
	public Boolean mostrarid_usuarioResumenCierreCaja=true;
	public Boolean activarid_usuarioResumenCierreCaja=false;
	public Boolean cargarid_usuarioResumenCierreCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioResumenCierreCaja=false;//ConEventDepend=true

	public Border resaltarid_cajaResumenCierreCaja=null;
	public Boolean mostrarid_cajaResumenCierreCaja=true;
	public Boolean activarid_cajaResumenCierreCaja=false;
	public Boolean cargarid_cajaResumenCierreCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cajaResumenCierreCaja=false;//ConEventDepend=true

	public Border resaltarfechaResumenCierreCaja=null;
	public Boolean mostrarfechaResumenCierreCaja=true;
	public Boolean activarfechaResumenCierreCaja=true;

	public Border resaltartipo_pagoResumenCierreCaja=null;
	public Boolean mostrartipo_pagoResumenCierreCaja=true;
	public Boolean activartipo_pagoResumenCierreCaja=true;

	public Border resaltarnombre_usuarioResumenCierreCaja=null;
	public Boolean mostrarnombre_usuarioResumenCierreCaja=true;
	public Boolean activarnombre_usuarioResumenCierreCaja=true;

	public Border resaltarnombre_cajaResumenCierreCaja=null;
	public Boolean mostrarnombre_cajaResumenCierreCaja=true;
	public Boolean activarnombre_cajaResumenCierreCaja=true;

	public Border resaltarvalorResumenCierreCaja=null;
	public Boolean mostrarvalorResumenCierreCaja=true;
	public Boolean activarvalorResumenCierreCaja=true;

	public Border resaltartotalResumenCierreCaja=null;
	public Boolean mostrartotalResumenCierreCaja=true;
	public Boolean activartotalResumenCierreCaja=true;

	
	

	public Border setResaltaridResumenCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenCierreCajaBeanSwingJInternalFrame resumencierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumencierrecajaBeanSwingJInternalFrame.jTtoolBarResumenCierreCaja.setBorder(borderResaltar);
		
		this.resaltaridResumenCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridResumenCierreCaja() {
		return this.resaltaridResumenCierreCaja;
	}

	public void setResaltaridResumenCierreCaja(Border borderResaltar) {
		this.resaltaridResumenCierreCaja= borderResaltar;
	}

	public Boolean getMostraridResumenCierreCaja() {
		return this.mostraridResumenCierreCaja;
	}

	public void setMostraridResumenCierreCaja(Boolean mostraridResumenCierreCaja) {
		this.mostraridResumenCierreCaja= mostraridResumenCierreCaja;
	}

	public Boolean getActivaridResumenCierreCaja() {
		return this.activaridResumenCierreCaja;
	}

	public void setActivaridResumenCierreCaja(Boolean activaridResumenCierreCaja) {
		this.activaridResumenCierreCaja= activaridResumenCierreCaja;
	}

	public Border setResaltarid_empresaResumenCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenCierreCajaBeanSwingJInternalFrame resumencierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumencierrecajaBeanSwingJInternalFrame.jTtoolBarResumenCierreCaja.setBorder(borderResaltar);
		
		this.resaltarid_empresaResumenCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaResumenCierreCaja() {
		return this.resaltarid_empresaResumenCierreCaja;
	}

	public void setResaltarid_empresaResumenCierreCaja(Border borderResaltar) {
		this.resaltarid_empresaResumenCierreCaja= borderResaltar;
	}

	public Boolean getMostrarid_empresaResumenCierreCaja() {
		return this.mostrarid_empresaResumenCierreCaja;
	}

	public void setMostrarid_empresaResumenCierreCaja(Boolean mostrarid_empresaResumenCierreCaja) {
		this.mostrarid_empresaResumenCierreCaja= mostrarid_empresaResumenCierreCaja;
	}

	public Boolean getActivarid_empresaResumenCierreCaja() {
		return this.activarid_empresaResumenCierreCaja;
	}

	public void setActivarid_empresaResumenCierreCaja(Boolean activarid_empresaResumenCierreCaja) {
		this.activarid_empresaResumenCierreCaja= activarid_empresaResumenCierreCaja;
	}

	public Boolean getCargarid_empresaResumenCierreCaja() {
		return this.cargarid_empresaResumenCierreCaja;
	}

	public void setCargarid_empresaResumenCierreCaja(Boolean cargarid_empresaResumenCierreCaja) {
		this.cargarid_empresaResumenCierreCaja= cargarid_empresaResumenCierreCaja;
	}

	public Border setResaltarid_sucursalResumenCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenCierreCajaBeanSwingJInternalFrame resumencierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumencierrecajaBeanSwingJInternalFrame.jTtoolBarResumenCierreCaja.setBorder(borderResaltar);
		
		this.resaltarid_sucursalResumenCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalResumenCierreCaja() {
		return this.resaltarid_sucursalResumenCierreCaja;
	}

	public void setResaltarid_sucursalResumenCierreCaja(Border borderResaltar) {
		this.resaltarid_sucursalResumenCierreCaja= borderResaltar;
	}

	public Boolean getMostrarid_sucursalResumenCierreCaja() {
		return this.mostrarid_sucursalResumenCierreCaja;
	}

	public void setMostrarid_sucursalResumenCierreCaja(Boolean mostrarid_sucursalResumenCierreCaja) {
		this.mostrarid_sucursalResumenCierreCaja= mostrarid_sucursalResumenCierreCaja;
	}

	public Boolean getActivarid_sucursalResumenCierreCaja() {
		return this.activarid_sucursalResumenCierreCaja;
	}

	public void setActivarid_sucursalResumenCierreCaja(Boolean activarid_sucursalResumenCierreCaja) {
		this.activarid_sucursalResumenCierreCaja= activarid_sucursalResumenCierreCaja;
	}

	public Boolean getCargarid_sucursalResumenCierreCaja() {
		return this.cargarid_sucursalResumenCierreCaja;
	}

	public void setCargarid_sucursalResumenCierreCaja(Boolean cargarid_sucursalResumenCierreCaja) {
		this.cargarid_sucursalResumenCierreCaja= cargarid_sucursalResumenCierreCaja;
	}

	public Border setResaltarid_usuarioResumenCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenCierreCajaBeanSwingJInternalFrame resumencierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumencierrecajaBeanSwingJInternalFrame.jTtoolBarResumenCierreCaja.setBorder(borderResaltar);
		
		this.resaltarid_usuarioResumenCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioResumenCierreCaja() {
		return this.resaltarid_usuarioResumenCierreCaja;
	}

	public void setResaltarid_usuarioResumenCierreCaja(Border borderResaltar) {
		this.resaltarid_usuarioResumenCierreCaja= borderResaltar;
	}

	public Boolean getMostrarid_usuarioResumenCierreCaja() {
		return this.mostrarid_usuarioResumenCierreCaja;
	}

	public void setMostrarid_usuarioResumenCierreCaja(Boolean mostrarid_usuarioResumenCierreCaja) {
		this.mostrarid_usuarioResumenCierreCaja= mostrarid_usuarioResumenCierreCaja;
	}

	public Boolean getActivarid_usuarioResumenCierreCaja() {
		return this.activarid_usuarioResumenCierreCaja;
	}

	public void setActivarid_usuarioResumenCierreCaja(Boolean activarid_usuarioResumenCierreCaja) {
		this.activarid_usuarioResumenCierreCaja= activarid_usuarioResumenCierreCaja;
	}

	public Boolean getCargarid_usuarioResumenCierreCaja() {
		return this.cargarid_usuarioResumenCierreCaja;
	}

	public void setCargarid_usuarioResumenCierreCaja(Boolean cargarid_usuarioResumenCierreCaja) {
		this.cargarid_usuarioResumenCierreCaja= cargarid_usuarioResumenCierreCaja;
	}

	public Border setResaltarid_cajaResumenCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenCierreCajaBeanSwingJInternalFrame resumencierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumencierrecajaBeanSwingJInternalFrame.jTtoolBarResumenCierreCaja.setBorder(borderResaltar);
		
		this.resaltarid_cajaResumenCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cajaResumenCierreCaja() {
		return this.resaltarid_cajaResumenCierreCaja;
	}

	public void setResaltarid_cajaResumenCierreCaja(Border borderResaltar) {
		this.resaltarid_cajaResumenCierreCaja= borderResaltar;
	}

	public Boolean getMostrarid_cajaResumenCierreCaja() {
		return this.mostrarid_cajaResumenCierreCaja;
	}

	public void setMostrarid_cajaResumenCierreCaja(Boolean mostrarid_cajaResumenCierreCaja) {
		this.mostrarid_cajaResumenCierreCaja= mostrarid_cajaResumenCierreCaja;
	}

	public Boolean getActivarid_cajaResumenCierreCaja() {
		return this.activarid_cajaResumenCierreCaja;
	}

	public void setActivarid_cajaResumenCierreCaja(Boolean activarid_cajaResumenCierreCaja) {
		this.activarid_cajaResumenCierreCaja= activarid_cajaResumenCierreCaja;
	}

	public Boolean getCargarid_cajaResumenCierreCaja() {
		return this.cargarid_cajaResumenCierreCaja;
	}

	public void setCargarid_cajaResumenCierreCaja(Boolean cargarid_cajaResumenCierreCaja) {
		this.cargarid_cajaResumenCierreCaja= cargarid_cajaResumenCierreCaja;
	}

	public Border setResaltarfechaResumenCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenCierreCajaBeanSwingJInternalFrame resumencierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumencierrecajaBeanSwingJInternalFrame.jTtoolBarResumenCierreCaja.setBorder(borderResaltar);
		
		this.resaltarfechaResumenCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaResumenCierreCaja() {
		return this.resaltarfechaResumenCierreCaja;
	}

	public void setResaltarfechaResumenCierreCaja(Border borderResaltar) {
		this.resaltarfechaResumenCierreCaja= borderResaltar;
	}

	public Boolean getMostrarfechaResumenCierreCaja() {
		return this.mostrarfechaResumenCierreCaja;
	}

	public void setMostrarfechaResumenCierreCaja(Boolean mostrarfechaResumenCierreCaja) {
		this.mostrarfechaResumenCierreCaja= mostrarfechaResumenCierreCaja;
	}

	public Boolean getActivarfechaResumenCierreCaja() {
		return this.activarfechaResumenCierreCaja;
	}

	public void setActivarfechaResumenCierreCaja(Boolean activarfechaResumenCierreCaja) {
		this.activarfechaResumenCierreCaja= activarfechaResumenCierreCaja;
	}

	public Border setResaltartipo_pagoResumenCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenCierreCajaBeanSwingJInternalFrame resumencierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumencierrecajaBeanSwingJInternalFrame.jTtoolBarResumenCierreCaja.setBorder(borderResaltar);
		
		this.resaltartipo_pagoResumenCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_pagoResumenCierreCaja() {
		return this.resaltartipo_pagoResumenCierreCaja;
	}

	public void setResaltartipo_pagoResumenCierreCaja(Border borderResaltar) {
		this.resaltartipo_pagoResumenCierreCaja= borderResaltar;
	}

	public Boolean getMostrartipo_pagoResumenCierreCaja() {
		return this.mostrartipo_pagoResumenCierreCaja;
	}

	public void setMostrartipo_pagoResumenCierreCaja(Boolean mostrartipo_pagoResumenCierreCaja) {
		this.mostrartipo_pagoResumenCierreCaja= mostrartipo_pagoResumenCierreCaja;
	}

	public Boolean getActivartipo_pagoResumenCierreCaja() {
		return this.activartipo_pagoResumenCierreCaja;
	}

	public void setActivartipo_pagoResumenCierreCaja(Boolean activartipo_pagoResumenCierreCaja) {
		this.activartipo_pagoResumenCierreCaja= activartipo_pagoResumenCierreCaja;
	}

	public Border setResaltarnombre_usuarioResumenCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenCierreCajaBeanSwingJInternalFrame resumencierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumencierrecajaBeanSwingJInternalFrame.jTtoolBarResumenCierreCaja.setBorder(borderResaltar);
		
		this.resaltarnombre_usuarioResumenCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_usuarioResumenCierreCaja() {
		return this.resaltarnombre_usuarioResumenCierreCaja;
	}

	public void setResaltarnombre_usuarioResumenCierreCaja(Border borderResaltar) {
		this.resaltarnombre_usuarioResumenCierreCaja= borderResaltar;
	}

	public Boolean getMostrarnombre_usuarioResumenCierreCaja() {
		return this.mostrarnombre_usuarioResumenCierreCaja;
	}

	public void setMostrarnombre_usuarioResumenCierreCaja(Boolean mostrarnombre_usuarioResumenCierreCaja) {
		this.mostrarnombre_usuarioResumenCierreCaja= mostrarnombre_usuarioResumenCierreCaja;
	}

	public Boolean getActivarnombre_usuarioResumenCierreCaja() {
		return this.activarnombre_usuarioResumenCierreCaja;
	}

	public void setActivarnombre_usuarioResumenCierreCaja(Boolean activarnombre_usuarioResumenCierreCaja) {
		this.activarnombre_usuarioResumenCierreCaja= activarnombre_usuarioResumenCierreCaja;
	}

	public Border setResaltarnombre_cajaResumenCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenCierreCajaBeanSwingJInternalFrame resumencierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumencierrecajaBeanSwingJInternalFrame.jTtoolBarResumenCierreCaja.setBorder(borderResaltar);
		
		this.resaltarnombre_cajaResumenCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cajaResumenCierreCaja() {
		return this.resaltarnombre_cajaResumenCierreCaja;
	}

	public void setResaltarnombre_cajaResumenCierreCaja(Border borderResaltar) {
		this.resaltarnombre_cajaResumenCierreCaja= borderResaltar;
	}

	public Boolean getMostrarnombre_cajaResumenCierreCaja() {
		return this.mostrarnombre_cajaResumenCierreCaja;
	}

	public void setMostrarnombre_cajaResumenCierreCaja(Boolean mostrarnombre_cajaResumenCierreCaja) {
		this.mostrarnombre_cajaResumenCierreCaja= mostrarnombre_cajaResumenCierreCaja;
	}

	public Boolean getActivarnombre_cajaResumenCierreCaja() {
		return this.activarnombre_cajaResumenCierreCaja;
	}

	public void setActivarnombre_cajaResumenCierreCaja(Boolean activarnombre_cajaResumenCierreCaja) {
		this.activarnombre_cajaResumenCierreCaja= activarnombre_cajaResumenCierreCaja;
	}

	public Border setResaltarvalorResumenCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenCierreCajaBeanSwingJInternalFrame resumencierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumencierrecajaBeanSwingJInternalFrame.jTtoolBarResumenCierreCaja.setBorder(borderResaltar);
		
		this.resaltarvalorResumenCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorResumenCierreCaja() {
		return this.resaltarvalorResumenCierreCaja;
	}

	public void setResaltarvalorResumenCierreCaja(Border borderResaltar) {
		this.resaltarvalorResumenCierreCaja= borderResaltar;
	}

	public Boolean getMostrarvalorResumenCierreCaja() {
		return this.mostrarvalorResumenCierreCaja;
	}

	public void setMostrarvalorResumenCierreCaja(Boolean mostrarvalorResumenCierreCaja) {
		this.mostrarvalorResumenCierreCaja= mostrarvalorResumenCierreCaja;
	}

	public Boolean getActivarvalorResumenCierreCaja() {
		return this.activarvalorResumenCierreCaja;
	}

	public void setActivarvalorResumenCierreCaja(Boolean activarvalorResumenCierreCaja) {
		this.activarvalorResumenCierreCaja= activarvalorResumenCierreCaja;
	}

	public Border setResaltartotalResumenCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenCierreCajaBeanSwingJInternalFrame resumencierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumencierrecajaBeanSwingJInternalFrame.jTtoolBarResumenCierreCaja.setBorder(borderResaltar);
		
		this.resaltartotalResumenCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalResumenCierreCaja() {
		return this.resaltartotalResumenCierreCaja;
	}

	public void setResaltartotalResumenCierreCaja(Border borderResaltar) {
		this.resaltartotalResumenCierreCaja= borderResaltar;
	}

	public Boolean getMostrartotalResumenCierreCaja() {
		return this.mostrartotalResumenCierreCaja;
	}

	public void setMostrartotalResumenCierreCaja(Boolean mostrartotalResumenCierreCaja) {
		this.mostrartotalResumenCierreCaja= mostrartotalResumenCierreCaja;
	}

	public Boolean getActivartotalResumenCierreCaja() {
		return this.activartotalResumenCierreCaja;
	}

	public void setActivartotalResumenCierreCaja(Boolean activartotalResumenCierreCaja) {
		this.activartotalResumenCierreCaja= activartotalResumenCierreCaja;
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
		
		
		this.setMostraridResumenCierreCaja(esInicial);
		this.setMostrarid_empresaResumenCierreCaja(esInicial);
		this.setMostrarid_sucursalResumenCierreCaja(esInicial);
		this.setMostrarid_usuarioResumenCierreCaja(esInicial);
		this.setMostrarid_cajaResumenCierreCaja(esInicial);
		this.setMostrarfechaResumenCierreCaja(esInicial);
		this.setMostrartipo_pagoResumenCierreCaja(esInicial);
		this.setMostrarnombre_usuarioResumenCierreCaja(esInicial);
		this.setMostrarnombre_cajaResumenCierreCaja(esInicial);
		this.setMostrarvalorResumenCierreCaja(esInicial);
		this.setMostrartotalResumenCierreCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.ID)) {
				this.setMostraridResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.IDCAJA)) {
				this.setMostrarid_cajaResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.FECHA)) {
				this.setMostrarfechaResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.TIPOPAGO)) {
				this.setMostrartipo_pagoResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.NOMBREUSUARIO)) {
				this.setMostrarnombre_usuarioResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.NOMBRECAJA)) {
				this.setMostrarnombre_cajaResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.VALOR)) {
				this.setMostrarvalorResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.TOTAL)) {
				this.setMostrartotalResumenCierreCaja(esAsigna);
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
		
		
		this.setActivaridResumenCierreCaja(esInicial);
		this.setActivarid_empresaResumenCierreCaja(esInicial);
		this.setActivarid_sucursalResumenCierreCaja(esInicial);
		this.setActivarid_usuarioResumenCierreCaja(esInicial);
		this.setActivarid_cajaResumenCierreCaja(esInicial);
		this.setActivarfechaResumenCierreCaja(esInicial);
		this.setActivartipo_pagoResumenCierreCaja(esInicial);
		this.setActivarnombre_usuarioResumenCierreCaja(esInicial);
		this.setActivarnombre_cajaResumenCierreCaja(esInicial);
		this.setActivarvalorResumenCierreCaja(esInicial);
		this.setActivartotalResumenCierreCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.ID)) {
				this.setActivaridResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.IDCAJA)) {
				this.setActivarid_cajaResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.FECHA)) {
				this.setActivarfechaResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.TIPOPAGO)) {
				this.setActivartipo_pagoResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.NOMBREUSUARIO)) {
				this.setActivarnombre_usuarioResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.NOMBRECAJA)) {
				this.setActivarnombre_cajaResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.VALOR)) {
				this.setActivarvalorResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.TOTAL)) {
				this.setActivartotalResumenCierreCaja(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ResumenCierreCajaBeanSwingJInternalFrame resumencierrecajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridResumenCierreCaja(esInicial);
		this.setResaltarid_empresaResumenCierreCaja(esInicial);
		this.setResaltarid_sucursalResumenCierreCaja(esInicial);
		this.setResaltarid_usuarioResumenCierreCaja(esInicial);
		this.setResaltarid_cajaResumenCierreCaja(esInicial);
		this.setResaltarfechaResumenCierreCaja(esInicial);
		this.setResaltartipo_pagoResumenCierreCaja(esInicial);
		this.setResaltarnombre_usuarioResumenCierreCaja(esInicial);
		this.setResaltarnombre_cajaResumenCierreCaja(esInicial);
		this.setResaltarvalorResumenCierreCaja(esInicial);
		this.setResaltartotalResumenCierreCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.ID)) {
				this.setResaltaridResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.IDCAJA)) {
				this.setResaltarid_cajaResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.FECHA)) {
				this.setResaltarfechaResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.TIPOPAGO)) {
				this.setResaltartipo_pagoResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.NOMBREUSUARIO)) {
				this.setResaltarnombre_usuarioResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.NOMBRECAJA)) {
				this.setResaltarnombre_cajaResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.VALOR)) {
				this.setResaltarvalorResumenCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenCierreCajaConstantesFunciones.TOTAL)) {
				this.setResaltartotalResumenCierreCaja(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ResumenCierreCajaBeanSwingJInternalFrame resumencierrecajaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaResumenCierreCajaResumenCierreCaja=true;

	public Boolean getMostrarBusquedaResumenCierreCajaResumenCierreCaja() {
		return this.mostrarBusquedaResumenCierreCajaResumenCierreCaja;
	}

	public void setMostrarBusquedaResumenCierreCajaResumenCierreCaja(Boolean visibilidadResaltar) {
		this.mostrarBusquedaResumenCierreCajaResumenCierreCaja= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaResumenCierreCajaResumenCierreCaja=true;

	public Boolean getActivarBusquedaResumenCierreCajaResumenCierreCaja() {
		return this.activarBusquedaResumenCierreCajaResumenCierreCaja;
	}

	public void setActivarBusquedaResumenCierreCajaResumenCierreCaja(Boolean habilitarResaltar) {
		this.activarBusquedaResumenCierreCajaResumenCierreCaja= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaResumenCierreCajaResumenCierreCaja=null;

	public Border getResaltarBusquedaResumenCierreCajaResumenCierreCaja() {
		return this.resaltarBusquedaResumenCierreCajaResumenCierreCaja;
	}

	public void setResaltarBusquedaResumenCierreCajaResumenCierreCaja(Border borderResaltar) {
		this.resaltarBusquedaResumenCierreCajaResumenCierreCaja= borderResaltar;
	}

	public void setResaltarBusquedaResumenCierreCajaResumenCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenCierreCajaBeanSwingJInternalFrame resumencierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaResumenCierreCajaResumenCierreCaja= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
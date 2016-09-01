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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.ConsultorConstantesFunciones;
import com.bydan.erp.facturacion.util.ConsultorParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ConsultorParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.importaciones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ConsultorConstantesFunciones extends ConsultorConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Consultor";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Consultor"+ConsultorConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ConsultorHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ConsultorHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ConsultorConstantesFunciones.SCHEMA+"_"+ConsultorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ConsultorHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ConsultorConstantesFunciones.SCHEMA+"_"+ConsultorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ConsultorConstantesFunciones.SCHEMA+"_"+ConsultorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ConsultorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ConsultorConstantesFunciones.SCHEMA+"_"+ConsultorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsultorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConsultorHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsultorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsultorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConsultorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsultorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ConsultorConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ConsultorConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ConsultorConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ConsultorConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Consultores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Consultor";
	public static final String SCLASSWEBTITULO_LOWER="Consultor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Consultor";
	public static final String OBJECTNAME="consultor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="consultor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select consultor from "+ConsultorConstantesFunciones.SPERSISTENCENAME+" consultor";
	public static String QUERYSELECTNATIVE="select "+ConsultorConstantesFunciones.SCHEMA+"."+ConsultorConstantesFunciones.TABLENAME+".id,"+ConsultorConstantesFunciones.SCHEMA+"."+ConsultorConstantesFunciones.TABLENAME+".version_row,"+ConsultorConstantesFunciones.SCHEMA+"."+ConsultorConstantesFunciones.TABLENAME+".id_empresa,"+ConsultorConstantesFunciones.SCHEMA+"."+ConsultorConstantesFunciones.TABLENAME+".identificacion,"+ConsultorConstantesFunciones.SCHEMA+"."+ConsultorConstantesFunciones.TABLENAME+".apellido,"+ConsultorConstantesFunciones.SCHEMA+"."+ConsultorConstantesFunciones.TABLENAME+".nombre,"+ConsultorConstantesFunciones.SCHEMA+"."+ConsultorConstantesFunciones.TABLENAME+".nombre_completo,"+ConsultorConstantesFunciones.SCHEMA+"."+ConsultorConstantesFunciones.TABLENAME+".telefono,"+ConsultorConstantesFunciones.SCHEMA+"."+ConsultorConstantesFunciones.TABLENAME+".e_mail,"+ConsultorConstantesFunciones.SCHEMA+"."+ConsultorConstantesFunciones.TABLENAME+".direccion,"+ConsultorConstantesFunciones.SCHEMA+"."+ConsultorConstantesFunciones.TABLENAME+".descripcion from "+ConsultorConstantesFunciones.SCHEMA+"."+ConsultorConstantesFunciones.TABLENAME;//+" as "+ConsultorConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ConsultorConstantesFuncionesAdditional consultorConstantesFuncionesAdditional=null;
	
	public ConsultorConstantesFuncionesAdditional getConsultorConstantesFuncionesAdditional() {
		return this.consultorConstantesFuncionesAdditional;
	}
	
	public void setConsultorConstantesFuncionesAdditional(ConsultorConstantesFuncionesAdditional consultorConstantesFuncionesAdditional) {
		try {
			this.consultorConstantesFuncionesAdditional=consultorConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDENTIFICACION= "identificacion";
    public static final String APELLIDO= "apellido";
    public static final String NOMBRE= "nombre";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String TELEFONO= "telefono";
    public static final String EMAIL= "e_mail";
    public static final String DIRECCION= "direccion";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDENTIFICACION= "Identificacion";
		public static final String LABEL_IDENTIFICACION_LOWER= "Identificacion";
    	public static final String LABEL_APELLIDO= "Apellido";
		public static final String LABEL_APELLIDO_LOWER= "Apellido";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_EMAIL= "E Mail";
		public static final String LABEL_EMAIL_LOWER= "E Mail";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXIDENTIFICACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXIDENTIFICACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXE_MAIL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXE_MAIL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getConsultorLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ConsultorConstantesFunciones.IDEMPRESA)) {sLabelColumna=ConsultorConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ConsultorConstantesFunciones.IDENTIFICACION)) {sLabelColumna=ConsultorConstantesFunciones.LABEL_IDENTIFICACION;}
		if(sNombreColumna.equals(ConsultorConstantesFunciones.APELLIDO)) {sLabelColumna=ConsultorConstantesFunciones.LABEL_APELLIDO;}
		if(sNombreColumna.equals(ConsultorConstantesFunciones.NOMBRE)) {sLabelColumna=ConsultorConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ConsultorConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=ConsultorConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(ConsultorConstantesFunciones.TELEFONO)) {sLabelColumna=ConsultorConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(ConsultorConstantesFunciones.EMAIL)) {sLabelColumna=ConsultorConstantesFunciones.LABEL_EMAIL;}
		if(sNombreColumna.equals(ConsultorConstantesFunciones.DIRECCION)) {sLabelColumna=ConsultorConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(ConsultorConstantesFunciones.DESCRIPCION)) {sLabelColumna=ConsultorConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getConsultorDescripcion(Consultor consultor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(consultor !=null/* && consultor.getId()!=0*/) {
			sDescripcion=consultor.getnombre();//consultorconsultor.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getConsultorDescripcionDetallado(Consultor consultor) {
		String sDescripcion="";
			
		sDescripcion+=ConsultorConstantesFunciones.ID+"=";
		sDescripcion+=consultor.getId().toString()+",";
		sDescripcion+=ConsultorConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=consultor.getVersionRow().toString()+",";
		sDescripcion+=ConsultorConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=consultor.getid_empresa().toString()+",";
		sDescripcion+=ConsultorConstantesFunciones.IDENTIFICACION+"=";
		sDescripcion+=consultor.getidentificacion()+",";
		sDescripcion+=ConsultorConstantesFunciones.APELLIDO+"=";
		sDescripcion+=consultor.getapellido()+",";
		sDescripcion+=ConsultorConstantesFunciones.NOMBRE+"=";
		sDescripcion+=consultor.getnombre()+",";
		sDescripcion+=ConsultorConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=consultor.getnombre_completo()+",";
		sDescripcion+=ConsultorConstantesFunciones.TELEFONO+"=";
		sDescripcion+=consultor.gettelefono()+",";
		sDescripcion+=ConsultorConstantesFunciones.EMAIL+"=";
		sDescripcion+=consultor.gete_mail()+",";
		sDescripcion+=ConsultorConstantesFunciones.DIRECCION+"=";
		sDescripcion+=consultor.getdireccion()+",";
		sDescripcion+=ConsultorConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=consultor.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setConsultorDescripcion(Consultor consultor,String sValor) throws Exception {			
		if(consultor !=null) {
			consultor.setnombre(sValor);;//consultorconsultor.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosConsultor(Consultor consultor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		consultor.setidentificacion(consultor.getidentificacion().trim());
		consultor.setapellido(consultor.getapellido().trim());
		consultor.setnombre(consultor.getnombre().trim());
		consultor.setnombre_completo(consultor.getnombre_completo().trim());
		consultor.settelefono(consultor.gettelefono().trim());
		consultor.sete_mail(consultor.gete_mail().trim());
		consultor.setdireccion(consultor.getdireccion().trim());
		consultor.setdescripcion(consultor.getdescripcion().trim());
	}
	
	public static void quitarEspaciosConsultors(List<Consultor> consultors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Consultor consultor: consultors) {
			consultor.setidentificacion(consultor.getidentificacion().trim());
			consultor.setapellido(consultor.getapellido().trim());
			consultor.setnombre(consultor.getnombre().trim());
			consultor.setnombre_completo(consultor.getnombre_completo().trim());
			consultor.settelefono(consultor.gettelefono().trim());
			consultor.sete_mail(consultor.gete_mail().trim());
			consultor.setdireccion(consultor.getdireccion().trim());
			consultor.setdescripcion(consultor.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConsultor(Consultor consultor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && consultor.getConCambioAuxiliar()) {
			consultor.setIsDeleted(consultor.getIsDeletedAuxiliar());	
			consultor.setIsNew(consultor.getIsNewAuxiliar());	
			consultor.setIsChanged(consultor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			consultor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			consultor.setIsDeletedAuxiliar(false);	
			consultor.setIsNewAuxiliar(false);	
			consultor.setIsChangedAuxiliar(false);
			
			consultor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConsultors(List<Consultor> consultors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Consultor consultor : consultors) {
			if(conAsignarBase && consultor.getConCambioAuxiliar()) {
				consultor.setIsDeleted(consultor.getIsDeletedAuxiliar());	
				consultor.setIsNew(consultor.getIsNewAuxiliar());	
				consultor.setIsChanged(consultor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				consultor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				consultor.setIsDeletedAuxiliar(false);	
				consultor.setIsNewAuxiliar(false);	
				consultor.setIsChangedAuxiliar(false);
				
				consultor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresConsultor(Consultor consultor,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresConsultors(List<Consultor> consultors,Boolean conEnteros) throws Exception  {
		
		for(Consultor consultor: consultors) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaConsultor(List<Consultor> consultors,Consultor consultorAux) throws Exception  {
		ConsultorConstantesFunciones.InicializarValoresConsultor(consultorAux,true);
		
		for(Consultor consultor: consultors) {
			if(consultor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConsultor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ConsultorConstantesFunciones.getArrayColumnasGlobalesConsultor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesConsultor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConsultorConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConsultorConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoConsultor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Consultor> consultors,Consultor consultor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Consultor consultorAux: consultors) {
			if(consultorAux!=null && consultor!=null) {
				if((consultorAux.getId()==null && consultor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(consultorAux.getId()!=null && consultor.getId()!=null){
					if(consultorAux.getId().equals(consultor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConsultor(List<Consultor> consultors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Consultor consultor: consultors) {			
			if(consultor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaConsultor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ConsultorConstantesFunciones.LABEL_ID, ConsultorConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsultorConstantesFunciones.LABEL_VERSIONROW, ConsultorConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsultorConstantesFunciones.LABEL_IDEMPRESA, ConsultorConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsultorConstantesFunciones.LABEL_IDENTIFICACION, ConsultorConstantesFunciones.IDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsultorConstantesFunciones.LABEL_APELLIDO, ConsultorConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsultorConstantesFunciones.LABEL_NOMBRE, ConsultorConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsultorConstantesFunciones.LABEL_NOMBRECOMPLETO, ConsultorConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsultorConstantesFunciones.LABEL_TELEFONO, ConsultorConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsultorConstantesFunciones.LABEL_EMAIL, ConsultorConstantesFunciones.EMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsultorConstantesFunciones.LABEL_DIRECCION, ConsultorConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsultorConstantesFunciones.LABEL_DESCRIPCION, ConsultorConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasConsultor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ConsultorConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsultorConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsultorConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsultorConstantesFunciones.IDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsultorConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsultorConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsultorConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsultorConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsultorConstantesFunciones.EMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsultorConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsultorConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsultor() throws Exception  {
		return ConsultorConstantesFunciones.getTiposSeleccionarConsultor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsultor(Boolean conFk) throws Exception  {
		return ConsultorConstantesFunciones.getTiposSeleccionarConsultor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsultor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsultorConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ConsultorConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsultorConstantesFunciones.LABEL_IDENTIFICACION);
			reporte.setsDescripcion(ConsultorConstantesFunciones.LABEL_IDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsultorConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(ConsultorConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsultorConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ConsultorConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsultorConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(ConsultorConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsultorConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(ConsultorConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsultorConstantesFunciones.LABEL_EMAIL);
			reporte.setsDescripcion(ConsultorConstantesFunciones.LABEL_EMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsultorConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(ConsultorConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsultorConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ConsultorConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesConsultor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesConsultor(Consultor consultorAux) throws Exception {
		
			consultorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(consultorAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesConsultor(List<Consultor> consultorsTemp) throws Exception {
		for(Consultor consultorAux:consultorsTemp) {
			
			consultorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(consultorAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfConsultor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfConsultor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsultor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConsultorConstantesFunciones.getClassesRelationshipsOfConsultor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsultor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(GuiaRemision.class));
				classes.add(new Classe(PedidoExpor.class));
				classes.add(new Classe(Pedido.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(GuiaRemision.class)) {
						classes.add(new Classe(GuiaRemision.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoExpor.class)) {
						classes.add(new Classe(PedidoExpor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pedido.class)) {
						classes.add(new Classe(Pedido.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConsultor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConsultorConstantesFunciones.getClassesRelationshipsFromStringsOfConsultor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConsultor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(GuiaRemision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GuiaRemision.class)); continue;
					}

					if(PedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoExpor.class)); continue;
					}

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(GuiaRemision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GuiaRemision.class)); continue;
					}

					if(PedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoExpor.class)); continue;
					}

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
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
	public static void actualizarLista(Consultor consultor,List<Consultor> consultors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Consultor consultorEncontrado=null;
			
			for(Consultor consultorLocal:consultors) {
				if(consultorLocal.getId().equals(consultor.getId())) {
					consultorEncontrado=consultorLocal;
					
					consultorLocal.setIsChanged(consultor.getIsChanged());
					consultorLocal.setIsNew(consultor.getIsNew());
					consultorLocal.setIsDeleted(consultor.getIsDeleted());
					
					consultorLocal.setGeneralEntityOriginal(consultor.getGeneralEntityOriginal());
					
					consultorLocal.setId(consultor.getId());	
					consultorLocal.setVersionRow(consultor.getVersionRow());	
					consultorLocal.setid_empresa(consultor.getid_empresa());	
					consultorLocal.setidentificacion(consultor.getidentificacion());	
					consultorLocal.setapellido(consultor.getapellido());	
					consultorLocal.setnombre(consultor.getnombre());	
					consultorLocal.setnombre_completo(consultor.getnombre_completo());	
					consultorLocal.settelefono(consultor.gettelefono());	
					consultorLocal.sete_mail(consultor.gete_mail());	
					consultorLocal.setdireccion(consultor.getdireccion());	
					consultorLocal.setdescripcion(consultor.getdescripcion());	
					
					
					consultorLocal.setGuiaRemisions(consultor.getGuiaRemisions());
					consultorLocal.setPedidoExpors(consultor.getPedidoExpors());
					consultorLocal.setPedidos(consultor.getPedidos());
					
					existe=true;
					break;
				}
			}
			
			if(!consultor.getIsDeleted()) {
				if(!existe) {
					consultors.add(consultor);
				}
			} else {
				if(consultorEncontrado!=null && permiteQuitar)  {
					consultors.remove(consultorEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Consultor consultor,List<Consultor> consultors) throws Exception {
		try	{			
			for(Consultor consultorLocal:consultors) {
				if(consultorLocal.getId().equals(consultor.getId())) {
					consultorLocal.setIsSelected(consultor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesConsultor(List<Consultor> consultorsAux) throws Exception {
		//this.consultorsAux=consultorsAux;
		
		for(Consultor consultorAux:consultorsAux) {
			if(consultorAux.getIsChanged()) {
				consultorAux.setIsChanged(false);
			}		
			
			if(consultorAux.getIsNew()) {
				consultorAux.setIsNew(false);
			}	
			
			if(consultorAux.getIsDeleted()) {
				consultorAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesConsultor(Consultor consultorAux) throws Exception {
		//this.consultorAux=consultorAux;
		
			if(consultorAux.getIsChanged()) {
				consultorAux.setIsChanged(false);
			}		
			
			if(consultorAux.getIsNew()) {
				consultorAux.setIsNew(false);
			}	
			
			if(consultorAux.getIsDeleted()) {
				consultorAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Consultor consultorAsignar,Consultor consultor) throws Exception {
		consultorAsignar.setId(consultor.getId());	
		consultorAsignar.setVersionRow(consultor.getVersionRow());	
		consultorAsignar.setid_empresa(consultor.getid_empresa());
		consultorAsignar.setempresa_descripcion(consultor.getempresa_descripcion());	
		consultorAsignar.setidentificacion(consultor.getidentificacion());	
		consultorAsignar.setapellido(consultor.getapellido());	
		consultorAsignar.setnombre(consultor.getnombre());	
		consultorAsignar.setnombre_completo(consultor.getnombre_completo());	
		consultorAsignar.settelefono(consultor.gettelefono());	
		consultorAsignar.sete_mail(consultor.gete_mail());	
		consultorAsignar.setdireccion(consultor.getdireccion());	
		consultorAsignar.setdescripcion(consultor.getdescripcion());	
	}
	
	public static void inicializarConsultor(Consultor consultor) throws Exception {
		try {
				consultor.setId(0L);	
					
				consultor.setid_empresa(-1L);	
				consultor.setidentificacion("");	
				consultor.setapellido("");	
				consultor.setnombre("");	
				consultor.setnombre_completo("");	
				consultor.settelefono("");	
				consultor.sete_mail("");	
				consultor.setdireccion("");	
				consultor.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderConsultor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsultorConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsultorConstantesFunciones.LABEL_IDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsultorConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsultorConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsultorConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsultorConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsultorConstantesFunciones.LABEL_EMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsultorConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsultorConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataConsultor(String sTipo,Row row,Workbook workbook,Consultor consultor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(consultor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consultor.getidentificacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consultor.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consultor.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consultor.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consultor.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consultor.gete_mail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consultor.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consultor.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryConsultor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryConsultor() {
		return this.sFinalQueryConsultor;
	}
	
	public void setsFinalQueryConsultor(String sFinalQueryConsultor) {
		this.sFinalQueryConsultor= sFinalQueryConsultor;
	}
	
	public Border resaltarSeleccionarConsultor=null;
	
	public Border setResaltarSeleccionarConsultor(ParametroGeneralUsuario parametroGeneralUsuario/*ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//consultorBeanSwingJInternalFrame.jTtoolBarConsultor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarConsultor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarConsultor() {
		return this.resaltarSeleccionarConsultor;
	}
	
	public void setResaltarSeleccionarConsultor(Border borderResaltarSeleccionarConsultor) {
		this.resaltarSeleccionarConsultor= borderResaltarSeleccionarConsultor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridConsultor=null;
	public Boolean mostraridConsultor=true;
	public Boolean activaridConsultor=true;

	public Border resaltarid_empresaConsultor=null;
	public Boolean mostrarid_empresaConsultor=true;
	public Boolean activarid_empresaConsultor=true;
	public Boolean cargarid_empresaConsultor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaConsultor=false;//ConEventDepend=true

	public Border resaltaridentificacionConsultor=null;
	public Boolean mostraridentificacionConsultor=true;
	public Boolean activaridentificacionConsultor=true;

	public Border resaltarapellidoConsultor=null;
	public Boolean mostrarapellidoConsultor=true;
	public Boolean activarapellidoConsultor=true;

	public Border resaltarnombreConsultor=null;
	public Boolean mostrarnombreConsultor=true;
	public Boolean activarnombreConsultor=true;

	public Border resaltarnombre_completoConsultor=null;
	public Boolean mostrarnombre_completoConsultor=true;
	public Boolean activarnombre_completoConsultor=true;

	public Border resaltartelefonoConsultor=null;
	public Boolean mostrartelefonoConsultor=true;
	public Boolean activartelefonoConsultor=true;

	public Border resaltare_mailConsultor=null;
	public Boolean mostrare_mailConsultor=true;
	public Boolean activare_mailConsultor=true;

	public Border resaltardireccionConsultor=null;
	public Boolean mostrardireccionConsultor=true;
	public Boolean activardireccionConsultor=true;

	public Border resaltardescripcionConsultor=null;
	public Boolean mostrardescripcionConsultor=true;
	public Boolean activardescripcionConsultor=true;

	
	

	public Border setResaltaridConsultor(ParametroGeneralUsuario parametroGeneralUsuario/*ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consultorBeanSwingJInternalFrame.jTtoolBarConsultor.setBorder(borderResaltar);
		
		this.resaltaridConsultor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridConsultor() {
		return this.resaltaridConsultor;
	}

	public void setResaltaridConsultor(Border borderResaltar) {
		this.resaltaridConsultor= borderResaltar;
	}

	public Boolean getMostraridConsultor() {
		return this.mostraridConsultor;
	}

	public void setMostraridConsultor(Boolean mostraridConsultor) {
		this.mostraridConsultor= mostraridConsultor;
	}

	public Boolean getActivaridConsultor() {
		return this.activaridConsultor;
	}

	public void setActivaridConsultor(Boolean activaridConsultor) {
		this.activaridConsultor= activaridConsultor;
	}

	public Border setResaltarid_empresaConsultor(ParametroGeneralUsuario parametroGeneralUsuario/*ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consultorBeanSwingJInternalFrame.jTtoolBarConsultor.setBorder(borderResaltar);
		
		this.resaltarid_empresaConsultor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaConsultor() {
		return this.resaltarid_empresaConsultor;
	}

	public void setResaltarid_empresaConsultor(Border borderResaltar) {
		this.resaltarid_empresaConsultor= borderResaltar;
	}

	public Boolean getMostrarid_empresaConsultor() {
		return this.mostrarid_empresaConsultor;
	}

	public void setMostrarid_empresaConsultor(Boolean mostrarid_empresaConsultor) {
		this.mostrarid_empresaConsultor= mostrarid_empresaConsultor;
	}

	public Boolean getActivarid_empresaConsultor() {
		return this.activarid_empresaConsultor;
	}

	public void setActivarid_empresaConsultor(Boolean activarid_empresaConsultor) {
		this.activarid_empresaConsultor= activarid_empresaConsultor;
	}

	public Boolean getCargarid_empresaConsultor() {
		return this.cargarid_empresaConsultor;
	}

	public void setCargarid_empresaConsultor(Boolean cargarid_empresaConsultor) {
		this.cargarid_empresaConsultor= cargarid_empresaConsultor;
	}

	public Border setResaltaridentificacionConsultor(ParametroGeneralUsuario parametroGeneralUsuario/*ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consultorBeanSwingJInternalFrame.jTtoolBarConsultor.setBorder(borderResaltar);
		
		this.resaltaridentificacionConsultor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridentificacionConsultor() {
		return this.resaltaridentificacionConsultor;
	}

	public void setResaltaridentificacionConsultor(Border borderResaltar) {
		this.resaltaridentificacionConsultor= borderResaltar;
	}

	public Boolean getMostraridentificacionConsultor() {
		return this.mostraridentificacionConsultor;
	}

	public void setMostraridentificacionConsultor(Boolean mostraridentificacionConsultor) {
		this.mostraridentificacionConsultor= mostraridentificacionConsultor;
	}

	public Boolean getActivaridentificacionConsultor() {
		return this.activaridentificacionConsultor;
	}

	public void setActivaridentificacionConsultor(Boolean activaridentificacionConsultor) {
		this.activaridentificacionConsultor= activaridentificacionConsultor;
	}

	public Border setResaltarapellidoConsultor(ParametroGeneralUsuario parametroGeneralUsuario/*ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consultorBeanSwingJInternalFrame.jTtoolBarConsultor.setBorder(borderResaltar);
		
		this.resaltarapellidoConsultor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoConsultor() {
		return this.resaltarapellidoConsultor;
	}

	public void setResaltarapellidoConsultor(Border borderResaltar) {
		this.resaltarapellidoConsultor= borderResaltar;
	}

	public Boolean getMostrarapellidoConsultor() {
		return this.mostrarapellidoConsultor;
	}

	public void setMostrarapellidoConsultor(Boolean mostrarapellidoConsultor) {
		this.mostrarapellidoConsultor= mostrarapellidoConsultor;
	}

	public Boolean getActivarapellidoConsultor() {
		return this.activarapellidoConsultor;
	}

	public void setActivarapellidoConsultor(Boolean activarapellidoConsultor) {
		this.activarapellidoConsultor= activarapellidoConsultor;
	}

	public Border setResaltarnombreConsultor(ParametroGeneralUsuario parametroGeneralUsuario/*ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consultorBeanSwingJInternalFrame.jTtoolBarConsultor.setBorder(borderResaltar);
		
		this.resaltarnombreConsultor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreConsultor() {
		return this.resaltarnombreConsultor;
	}

	public void setResaltarnombreConsultor(Border borderResaltar) {
		this.resaltarnombreConsultor= borderResaltar;
	}

	public Boolean getMostrarnombreConsultor() {
		return this.mostrarnombreConsultor;
	}

	public void setMostrarnombreConsultor(Boolean mostrarnombreConsultor) {
		this.mostrarnombreConsultor= mostrarnombreConsultor;
	}

	public Boolean getActivarnombreConsultor() {
		return this.activarnombreConsultor;
	}

	public void setActivarnombreConsultor(Boolean activarnombreConsultor) {
		this.activarnombreConsultor= activarnombreConsultor;
	}

	public Border setResaltarnombre_completoConsultor(ParametroGeneralUsuario parametroGeneralUsuario/*ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consultorBeanSwingJInternalFrame.jTtoolBarConsultor.setBorder(borderResaltar);
		
		this.resaltarnombre_completoConsultor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoConsultor() {
		return this.resaltarnombre_completoConsultor;
	}

	public void setResaltarnombre_completoConsultor(Border borderResaltar) {
		this.resaltarnombre_completoConsultor= borderResaltar;
	}

	public Boolean getMostrarnombre_completoConsultor() {
		return this.mostrarnombre_completoConsultor;
	}

	public void setMostrarnombre_completoConsultor(Boolean mostrarnombre_completoConsultor) {
		this.mostrarnombre_completoConsultor= mostrarnombre_completoConsultor;
	}

	public Boolean getActivarnombre_completoConsultor() {
		return this.activarnombre_completoConsultor;
	}

	public void setActivarnombre_completoConsultor(Boolean activarnombre_completoConsultor) {
		this.activarnombre_completoConsultor= activarnombre_completoConsultor;
	}

	public Border setResaltartelefonoConsultor(ParametroGeneralUsuario parametroGeneralUsuario/*ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consultorBeanSwingJInternalFrame.jTtoolBarConsultor.setBorder(borderResaltar);
		
		this.resaltartelefonoConsultor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoConsultor() {
		return this.resaltartelefonoConsultor;
	}

	public void setResaltartelefonoConsultor(Border borderResaltar) {
		this.resaltartelefonoConsultor= borderResaltar;
	}

	public Boolean getMostrartelefonoConsultor() {
		return this.mostrartelefonoConsultor;
	}

	public void setMostrartelefonoConsultor(Boolean mostrartelefonoConsultor) {
		this.mostrartelefonoConsultor= mostrartelefonoConsultor;
	}

	public Boolean getActivartelefonoConsultor() {
		return this.activartelefonoConsultor;
	}

	public void setActivartelefonoConsultor(Boolean activartelefonoConsultor) {
		this.activartelefonoConsultor= activartelefonoConsultor;
	}

	public Border setResaltare_mailConsultor(ParametroGeneralUsuario parametroGeneralUsuario/*ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consultorBeanSwingJInternalFrame.jTtoolBarConsultor.setBorder(borderResaltar);
		
		this.resaltare_mailConsultor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltare_mailConsultor() {
		return this.resaltare_mailConsultor;
	}

	public void setResaltare_mailConsultor(Border borderResaltar) {
		this.resaltare_mailConsultor= borderResaltar;
	}

	public Boolean getMostrare_mailConsultor() {
		return this.mostrare_mailConsultor;
	}

	public void setMostrare_mailConsultor(Boolean mostrare_mailConsultor) {
		this.mostrare_mailConsultor= mostrare_mailConsultor;
	}

	public Boolean getActivare_mailConsultor() {
		return this.activare_mailConsultor;
	}

	public void setActivare_mailConsultor(Boolean activare_mailConsultor) {
		this.activare_mailConsultor= activare_mailConsultor;
	}

	public Border setResaltardireccionConsultor(ParametroGeneralUsuario parametroGeneralUsuario/*ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consultorBeanSwingJInternalFrame.jTtoolBarConsultor.setBorder(borderResaltar);
		
		this.resaltardireccionConsultor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionConsultor() {
		return this.resaltardireccionConsultor;
	}

	public void setResaltardireccionConsultor(Border borderResaltar) {
		this.resaltardireccionConsultor= borderResaltar;
	}

	public Boolean getMostrardireccionConsultor() {
		return this.mostrardireccionConsultor;
	}

	public void setMostrardireccionConsultor(Boolean mostrardireccionConsultor) {
		this.mostrardireccionConsultor= mostrardireccionConsultor;
	}

	public Boolean getActivardireccionConsultor() {
		return this.activardireccionConsultor;
	}

	public void setActivardireccionConsultor(Boolean activardireccionConsultor) {
		this.activardireccionConsultor= activardireccionConsultor;
	}

	public Border setResaltardescripcionConsultor(ParametroGeneralUsuario parametroGeneralUsuario/*ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consultorBeanSwingJInternalFrame.jTtoolBarConsultor.setBorder(borderResaltar);
		
		this.resaltardescripcionConsultor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionConsultor() {
		return this.resaltardescripcionConsultor;
	}

	public void setResaltardescripcionConsultor(Border borderResaltar) {
		this.resaltardescripcionConsultor= borderResaltar;
	}

	public Boolean getMostrardescripcionConsultor() {
		return this.mostrardescripcionConsultor;
	}

	public void setMostrardescripcionConsultor(Boolean mostrardescripcionConsultor) {
		this.mostrardescripcionConsultor= mostrardescripcionConsultor;
	}

	public Boolean getActivardescripcionConsultor() {
		return this.activardescripcionConsultor;
	}

	public void setActivardescripcionConsultor(Boolean activardescripcionConsultor) {
		this.activardescripcionConsultor= activardescripcionConsultor;
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
		
		
		this.setMostraridConsultor(esInicial);
		this.setMostrarid_empresaConsultor(esInicial);
		this.setMostraridentificacionConsultor(esInicial);
		this.setMostrarapellidoConsultor(esInicial);
		this.setMostrarnombreConsultor(esInicial);
		this.setMostrarnombre_completoConsultor(esInicial);
		this.setMostrartelefonoConsultor(esInicial);
		this.setMostrare_mailConsultor(esInicial);
		this.setMostrardireccionConsultor(esInicial);
		this.setMostrardescripcionConsultor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsultorConstantesFunciones.ID)) {
				this.setMostraridConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.IDENTIFICACION)) {
				this.setMostraridentificacionConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.EMAIL)) {
				this.setMostrare_mailConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionConsultor(esAsigna);
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
		
		
		this.setActivaridConsultor(esInicial);
		this.setActivarid_empresaConsultor(esInicial);
		this.setActivaridentificacionConsultor(esInicial);
		this.setActivarapellidoConsultor(esInicial);
		this.setActivarnombreConsultor(esInicial);
		this.setActivarnombre_completoConsultor(esInicial);
		this.setActivartelefonoConsultor(esInicial);
		this.setActivare_mailConsultor(esInicial);
		this.setActivardireccionConsultor(esInicial);
		this.setActivardescripcionConsultor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsultorConstantesFunciones.ID)) {
				this.setActivaridConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.IDENTIFICACION)) {
				this.setActivaridentificacionConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.NOMBRE)) {
				this.setActivarnombreConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.EMAIL)) {
				this.setActivare_mailConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.DIRECCION)) {
				this.setActivardireccionConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionConsultor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridConsultor(esInicial);
		this.setResaltarid_empresaConsultor(esInicial);
		this.setResaltaridentificacionConsultor(esInicial);
		this.setResaltarapellidoConsultor(esInicial);
		this.setResaltarnombreConsultor(esInicial);
		this.setResaltarnombre_completoConsultor(esInicial);
		this.setResaltartelefonoConsultor(esInicial);
		this.setResaltare_mailConsultor(esInicial);
		this.setResaltardireccionConsultor(esInicial);
		this.setResaltardescripcionConsultor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsultorConstantesFunciones.ID)) {
				this.setResaltaridConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.IDENTIFICACION)) {
				this.setResaltaridentificacionConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.EMAIL)) {
				this.setResaltare_mailConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionConsultor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsultorConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionConsultor(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarGuiaRemisionConsultor=null;

	public Border getResaltarGuiaRemisionConsultor() {
		return this.resaltarGuiaRemisionConsultor;
	}

	public void setResaltarGuiaRemisionConsultor(Border borderResaltarGuiaRemision) {
		if(borderResaltarGuiaRemision!=null) {
			this.resaltarGuiaRemisionConsultor= borderResaltarGuiaRemision;
		}
	}

	public Border setResaltarGuiaRemisionConsultor(ParametroGeneralUsuario parametroGeneralUsuario/*ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/) {
		Border borderResaltarGuiaRemision=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//consultorBeanSwingJInternalFrame.jTtoolBarConsultor.setBorder(borderResaltarGuiaRemision);
			
		this.resaltarGuiaRemisionConsultor= borderResaltarGuiaRemision;

		 return borderResaltarGuiaRemision;
	}



	public Boolean mostrarGuiaRemisionConsultor=true;

	public Boolean getMostrarGuiaRemisionConsultor() {
		return this.mostrarGuiaRemisionConsultor;
	}

	public void setMostrarGuiaRemisionConsultor(Boolean visibilidadResaltarGuiaRemision) {
		this.mostrarGuiaRemisionConsultor= visibilidadResaltarGuiaRemision;
	}



	public Boolean activarGuiaRemisionConsultor=true;

	public Boolean gethabilitarResaltarGuiaRemisionConsultor() {
		return this.activarGuiaRemisionConsultor;
	}

	public void setActivarGuiaRemisionConsultor(Boolean habilitarResaltarGuiaRemision) {
		this.activarGuiaRemisionConsultor= habilitarResaltarGuiaRemision;
	}


	public Border resaltarPedidoExporConsultor=null;

	public Border getResaltarPedidoExporConsultor() {
		return this.resaltarPedidoExporConsultor;
	}

	public void setResaltarPedidoExporConsultor(Border borderResaltarPedidoExpor) {
		if(borderResaltarPedidoExpor!=null) {
			this.resaltarPedidoExporConsultor= borderResaltarPedidoExpor;
		}
	}

	public Border setResaltarPedidoExporConsultor(ParametroGeneralUsuario parametroGeneralUsuario/*ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoExpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//consultorBeanSwingJInternalFrame.jTtoolBarConsultor.setBorder(borderResaltarPedidoExpor);
			
		this.resaltarPedidoExporConsultor= borderResaltarPedidoExpor;

		 return borderResaltarPedidoExpor;
	}



	public Boolean mostrarPedidoExporConsultor=true;

	public Boolean getMostrarPedidoExporConsultor() {
		return this.mostrarPedidoExporConsultor;
	}

	public void setMostrarPedidoExporConsultor(Boolean visibilidadResaltarPedidoExpor) {
		this.mostrarPedidoExporConsultor= visibilidadResaltarPedidoExpor;
	}



	public Boolean activarPedidoExporConsultor=true;

	public Boolean gethabilitarResaltarPedidoExporConsultor() {
		return this.activarPedidoExporConsultor;
	}

	public void setActivarPedidoExporConsultor(Boolean habilitarResaltarPedidoExpor) {
		this.activarPedidoExporConsultor= habilitarResaltarPedidoExpor;
	}


	public Border resaltarPedidoConsultor=null;

	public Border getResaltarPedidoConsultor() {
		return this.resaltarPedidoConsultor;
	}

	public void setResaltarPedidoConsultor(Border borderResaltarPedido) {
		if(borderResaltarPedido!=null) {
			this.resaltarPedidoConsultor= borderResaltarPedido;
		}
	}

	public Border setResaltarPedidoConsultor(ParametroGeneralUsuario parametroGeneralUsuario/*ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/) {
		Border borderResaltarPedido=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//consultorBeanSwingJInternalFrame.jTtoolBarConsultor.setBorder(borderResaltarPedido);
			
		this.resaltarPedidoConsultor= borderResaltarPedido;

		 return borderResaltarPedido;
	}



	public Boolean mostrarPedidoConsultor=true;

	public Boolean getMostrarPedidoConsultor() {
		return this.mostrarPedidoConsultor;
	}

	public void setMostrarPedidoConsultor(Boolean visibilidadResaltarPedido) {
		this.mostrarPedidoConsultor= visibilidadResaltarPedido;
	}



	public Boolean activarPedidoConsultor=true;

	public Boolean gethabilitarResaltarPedidoConsultor() {
		return this.activarPedidoConsultor;
	}

	public void setActivarPedidoConsultor(Boolean habilitarResaltarPedido) {
		this.activarPedidoConsultor= habilitarResaltarPedido;
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

		this.setMostrarGuiaRemisionConsultor(esInicial);
		this.setMostrarPedidoExporConsultor(esInicial);
		this.setMostrarPedidoConsultor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(GuiaRemision.class)) {
				this.setMostrarGuiaRemisionConsultor(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setMostrarPedidoExporConsultor(esAsigna);
				continue;
			}

			if(clase.clas.equals(Pedido.class)) {
				this.setMostrarPedidoConsultor(esAsigna);
				continue;
			}
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

		this.setActivarGuiaRemisionConsultor(esInicial);
		this.setActivarPedidoExporConsultor(esInicial);
		this.setActivarPedidoConsultor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(GuiaRemision.class)) {
				this.setActivarGuiaRemisionConsultor(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setActivarPedidoExporConsultor(esAsigna);
				continue;
			}

			if(clase.clas.equals(Pedido.class)) {
				this.setActivarPedidoConsultor(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarGuiaRemisionConsultor(esInicial);
		this.setResaltarPedidoExporConsultor(esInicial);
		this.setResaltarPedidoConsultor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(GuiaRemision.class)) {
				this.setResaltarGuiaRemisionConsultor(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setResaltarPedidoExporConsultor(esAsigna);
				continue;
			}

			if(clase.clas.equals(Pedido.class)) {
				this.setResaltarPedidoConsultor(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaConsultor=true;

	public Boolean getMostrarFK_IdEmpresaConsultor() {
		return this.mostrarFK_IdEmpresaConsultor;
	}

	public void setMostrarFK_IdEmpresaConsultor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaConsultor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaConsultor=true;

	public Boolean getActivarFK_IdEmpresaConsultor() {
		return this.activarFK_IdEmpresaConsultor;
	}

	public void setActivarFK_IdEmpresaConsultor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaConsultor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaConsultor=null;

	public Border getResaltarFK_IdEmpresaConsultor() {
		return this.resaltarFK_IdEmpresaConsultor;
	}

	public void setResaltarFK_IdEmpresaConsultor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaConsultor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaConsultor(ParametroGeneralUsuario parametroGeneralUsuario/*ConsultorBeanSwingJInternalFrame consultorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaConsultor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.ConsignatarioConstantesFunciones;
import com.bydan.erp.cartera.util.ConsignatarioParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ConsignatarioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ConsignatarioConstantesFunciones extends ConsignatarioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Consignatario";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Consignatario"+ConsignatarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ConsignatarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ConsignatarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ConsignatarioConstantesFunciones.SCHEMA+"_"+ConsignatarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ConsignatarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ConsignatarioConstantesFunciones.SCHEMA+"_"+ConsignatarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ConsignatarioConstantesFunciones.SCHEMA+"_"+ConsignatarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ConsignatarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ConsignatarioConstantesFunciones.SCHEMA+"_"+ConsignatarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsignatarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConsignatarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsignatarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsignatarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConsignatarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsignatarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ConsignatarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ConsignatarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ConsignatarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ConsignatarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Consignatarios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Consignatario";
	public static final String SCLASSWEBTITULO_LOWER="Consignatario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Consignatario";
	public static final String OBJECTNAME="consignatario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="consignatario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select consignatario from "+ConsignatarioConstantesFunciones.SPERSISTENCENAME+" consignatario";
	public static String QUERYSELECTNATIVE="select "+ConsignatarioConstantesFunciones.SCHEMA+"."+ConsignatarioConstantesFunciones.TABLENAME+".id,"+ConsignatarioConstantesFunciones.SCHEMA+"."+ConsignatarioConstantesFunciones.TABLENAME+".version_row,"+ConsignatarioConstantesFunciones.SCHEMA+"."+ConsignatarioConstantesFunciones.TABLENAME+".id_empresa,"+ConsignatarioConstantesFunciones.SCHEMA+"."+ConsignatarioConstantesFunciones.TABLENAME+".id_sucursal,"+ConsignatarioConstantesFunciones.SCHEMA+"."+ConsignatarioConstantesFunciones.TABLENAME+".id_cliente,"+ConsignatarioConstantesFunciones.SCHEMA+"."+ConsignatarioConstantesFunciones.TABLENAME+".id_usuario,"+ConsignatarioConstantesFunciones.SCHEMA+"."+ConsignatarioConstantesFunciones.TABLENAME+".nombre_completo,"+ConsignatarioConstantesFunciones.SCHEMA+"."+ConsignatarioConstantesFunciones.TABLENAME+".nombre,"+ConsignatarioConstantesFunciones.SCHEMA+"."+ConsignatarioConstantesFunciones.TABLENAME+".apellido from "+ConsignatarioConstantesFunciones.SCHEMA+"."+ConsignatarioConstantesFunciones.TABLENAME;//+" as "+ConsignatarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ConsignatarioConstantesFuncionesAdditional consignatarioConstantesFuncionesAdditional=null;
	
	public ConsignatarioConstantesFuncionesAdditional getConsignatarioConstantesFuncionesAdditional() {
		return this.consignatarioConstantesFuncionesAdditional;
	}
	
	public void setConsignatarioConstantesFuncionesAdditional(ConsignatarioConstantesFuncionesAdditional consignatarioConstantesFuncionesAdditional) {
		try {
			this.consignatarioConstantesFuncionesAdditional=consignatarioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDUSUARIO= "id_usuario";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String NOMBRE= "nombre";
    public static final String APELLIDO= "apellido";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_APELLIDO= "Apello";
		public static final String LABEL_APELLIDO_LOWER= "Apellido";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getConsignatarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ConsignatarioConstantesFunciones.IDEMPRESA)) {sLabelColumna=ConsignatarioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ConsignatarioConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ConsignatarioConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ConsignatarioConstantesFunciones.IDCLIENTE)) {sLabelColumna=ConsignatarioConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ConsignatarioConstantesFunciones.IDUSUARIO)) {sLabelColumna=ConsignatarioConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(ConsignatarioConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=ConsignatarioConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(ConsignatarioConstantesFunciones.NOMBRE)) {sLabelColumna=ConsignatarioConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ConsignatarioConstantesFunciones.APELLIDO)) {sLabelColumna=ConsignatarioConstantesFunciones.LABEL_APELLIDO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getConsignatarioDescripcion(Consignatario consignatario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(consignatario !=null/* && consignatario.getId()!=0*/) {
			sDescripcion=consignatario.getnombre();//consignatarioconsignatario.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getConsignatarioDescripcionDetallado(Consignatario consignatario) {
		String sDescripcion="";
			
		sDescripcion+=ConsignatarioConstantesFunciones.ID+"=";
		sDescripcion+=consignatario.getId().toString()+",";
		sDescripcion+=ConsignatarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=consignatario.getVersionRow().toString()+",";
		sDescripcion+=ConsignatarioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=consignatario.getid_empresa().toString()+",";
		sDescripcion+=ConsignatarioConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=consignatario.getid_sucursal().toString()+",";
		sDescripcion+=ConsignatarioConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=consignatario.getid_cliente().toString()+",";
		sDescripcion+=ConsignatarioConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=consignatario.getid_usuario().toString()+",";
		sDescripcion+=ConsignatarioConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=consignatario.getnombre_completo()+",";
		sDescripcion+=ConsignatarioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=consignatario.getnombre()+",";
		sDescripcion+=ConsignatarioConstantesFunciones.APELLIDO+"=";
		sDescripcion+=consignatario.getapellido()+",";
			
		return sDescripcion;
	}
	
	public static void setConsignatarioDescripcion(Consignatario consignatario,String sValor) throws Exception {			
		if(consignatario !=null) {
			consignatario.setnombre(sValor);;//consignatarioconsignatario.getnombre().trim();
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
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
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
	
	
	
	
	
	
	public static void quitarEspaciosConsignatario(Consignatario consignatario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		consignatario.setnombre_completo(consignatario.getnombre_completo().trim());
		consignatario.setnombre(consignatario.getnombre().trim());
		consignatario.setapellido(consignatario.getapellido().trim());
	}
	
	public static void quitarEspaciosConsignatarios(List<Consignatario> consignatarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Consignatario consignatario: consignatarios) {
			consignatario.setnombre_completo(consignatario.getnombre_completo().trim());
			consignatario.setnombre(consignatario.getnombre().trim());
			consignatario.setapellido(consignatario.getapellido().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConsignatario(Consignatario consignatario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && consignatario.getConCambioAuxiliar()) {
			consignatario.setIsDeleted(consignatario.getIsDeletedAuxiliar());	
			consignatario.setIsNew(consignatario.getIsNewAuxiliar());	
			consignatario.setIsChanged(consignatario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			consignatario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			consignatario.setIsDeletedAuxiliar(false);	
			consignatario.setIsNewAuxiliar(false);	
			consignatario.setIsChangedAuxiliar(false);
			
			consignatario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConsignatarios(List<Consignatario> consignatarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Consignatario consignatario : consignatarios) {
			if(conAsignarBase && consignatario.getConCambioAuxiliar()) {
				consignatario.setIsDeleted(consignatario.getIsDeletedAuxiliar());	
				consignatario.setIsNew(consignatario.getIsNewAuxiliar());	
				consignatario.setIsChanged(consignatario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				consignatario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				consignatario.setIsDeletedAuxiliar(false);	
				consignatario.setIsNewAuxiliar(false);	
				consignatario.setIsChangedAuxiliar(false);
				
				consignatario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresConsignatario(Consignatario consignatario,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresConsignatarios(List<Consignatario> consignatarios,Boolean conEnteros) throws Exception  {
		
		for(Consignatario consignatario: consignatarios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaConsignatario(List<Consignatario> consignatarios,Consignatario consignatarioAux) throws Exception  {
		ConsignatarioConstantesFunciones.InicializarValoresConsignatario(consignatarioAux,true);
		
		for(Consignatario consignatario: consignatarios) {
			if(consignatario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConsignatario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ConsignatarioConstantesFunciones.getArrayColumnasGlobalesConsignatario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesConsignatario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConsignatarioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConsignatarioConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConsignatarioConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConsignatarioConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConsignatarioConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConsignatarioConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoConsignatario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Consignatario> consignatarios,Consignatario consignatario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Consignatario consignatarioAux: consignatarios) {
			if(consignatarioAux!=null && consignatario!=null) {
				if((consignatarioAux.getId()==null && consignatario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(consignatarioAux.getId()!=null && consignatario.getId()!=null){
					if(consignatarioAux.getId().equals(consignatario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConsignatario(List<Consignatario> consignatarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Consignatario consignatario: consignatarios) {			
			if(consignatario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaConsignatario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ConsignatarioConstantesFunciones.LABEL_ID, ConsignatarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignatarioConstantesFunciones.LABEL_VERSIONROW, ConsignatarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignatarioConstantesFunciones.LABEL_IDEMPRESA, ConsignatarioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignatarioConstantesFunciones.LABEL_IDSUCURSAL, ConsignatarioConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignatarioConstantesFunciones.LABEL_IDCLIENTE, ConsignatarioConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignatarioConstantesFunciones.LABEL_IDUSUARIO, ConsignatarioConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignatarioConstantesFunciones.LABEL_NOMBRECOMPLETO, ConsignatarioConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignatarioConstantesFunciones.LABEL_NOMBRE, ConsignatarioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignatarioConstantesFunciones.LABEL_APELLIDO, ConsignatarioConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasConsignatario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ConsignatarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignatarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignatarioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignatarioConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignatarioConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignatarioConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignatarioConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignatarioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignatarioConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsignatario() throws Exception  {
		return ConsignatarioConstantesFunciones.getTiposSeleccionarConsignatario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsignatario(Boolean conFk) throws Exception  {
		return ConsignatarioConstantesFunciones.getTiposSeleccionarConsignatario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsignatario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignatarioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ConsignatarioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignatarioConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ConsignatarioConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignatarioConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ConsignatarioConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignatarioConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(ConsignatarioConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignatarioConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(ConsignatarioConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignatarioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ConsignatarioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignatarioConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(ConsignatarioConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesConsignatario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesConsignatario(Consignatario consignatarioAux) throws Exception {
		
			consignatarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(consignatarioAux.getEmpresa()));
			consignatarioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(consignatarioAux.getSucursal()));
			consignatarioAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(consignatarioAux.getCliente()));
			consignatarioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(consignatarioAux.getUsuario()));		
	}
	
	public static void refrescarForeignKeysDescripcionesConsignatario(List<Consignatario> consignatariosTemp) throws Exception {
		for(Consignatario consignatarioAux:consignatariosTemp) {
			
			consignatarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(consignatarioAux.getEmpresa()));
			consignatarioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(consignatarioAux.getSucursal()));
			consignatarioAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(consignatarioAux.getCliente()));
			consignatarioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(consignatarioAux.getUsuario()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfConsignatario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Usuario.class));
				
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfConsignatario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsignatario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConsignatarioConstantesFunciones.getClassesRelationshipsOfConsignatario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsignatario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Proforma.class));
				classes.add(new Classe(Consignacion.class));
				classes.add(new Classe(PedidoExpor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Proforma.class)) {
						classes.add(new Classe(Proforma.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Consignacion.class)) {
						classes.add(new Classe(Consignacion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoExpor.class)) {
						classes.add(new Classe(PedidoExpor.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConsignatario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConsignatarioConstantesFunciones.getClassesRelationshipsFromStringsOfConsignatario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConsignatario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Proforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Proforma.class)); continue;
					}

					if(Consignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignacion.class)); continue;
					}

					if(PedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoExpor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Proforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Proforma.class)); continue;
					}

					if(Consignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignacion.class)); continue;
					}

					if(PedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoExpor.class)); continue;
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
	public static void actualizarLista(Consignatario consignatario,List<Consignatario> consignatarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Consignatario consignatarioEncontrado=null;
			
			for(Consignatario consignatarioLocal:consignatarios) {
				if(consignatarioLocal.getId().equals(consignatario.getId())) {
					consignatarioEncontrado=consignatarioLocal;
					
					consignatarioLocal.setIsChanged(consignatario.getIsChanged());
					consignatarioLocal.setIsNew(consignatario.getIsNew());
					consignatarioLocal.setIsDeleted(consignatario.getIsDeleted());
					
					consignatarioLocal.setGeneralEntityOriginal(consignatario.getGeneralEntityOriginal());
					
					consignatarioLocal.setId(consignatario.getId());	
					consignatarioLocal.setVersionRow(consignatario.getVersionRow());	
					consignatarioLocal.setid_empresa(consignatario.getid_empresa());	
					consignatarioLocal.setid_sucursal(consignatario.getid_sucursal());	
					consignatarioLocal.setid_cliente(consignatario.getid_cliente());	
					consignatarioLocal.setid_usuario(consignatario.getid_usuario());	
					consignatarioLocal.setnombre_completo(consignatario.getnombre_completo());	
					consignatarioLocal.setnombre(consignatario.getnombre());	
					consignatarioLocal.setapellido(consignatario.getapellido());	
					
					
					consignatarioLocal.setProformas(consignatario.getProformas());
					consignatarioLocal.setConsignacions(consignatario.getConsignacions());
					consignatarioLocal.setPedidoExpors(consignatario.getPedidoExpors());
					
					existe=true;
					break;
				}
			}
			
			if(!consignatario.getIsDeleted()) {
				if(!existe) {
					consignatarios.add(consignatario);
				}
			} else {
				if(consignatarioEncontrado!=null && permiteQuitar)  {
					consignatarios.remove(consignatarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Consignatario consignatario,List<Consignatario> consignatarios) throws Exception {
		try	{			
			for(Consignatario consignatarioLocal:consignatarios) {
				if(consignatarioLocal.getId().equals(consignatario.getId())) {
					consignatarioLocal.setIsSelected(consignatario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesConsignatario(List<Consignatario> consignatariosAux) throws Exception {
		//this.consignatariosAux=consignatariosAux;
		
		for(Consignatario consignatarioAux:consignatariosAux) {
			if(consignatarioAux.getIsChanged()) {
				consignatarioAux.setIsChanged(false);
			}		
			
			if(consignatarioAux.getIsNew()) {
				consignatarioAux.setIsNew(false);
			}	
			
			if(consignatarioAux.getIsDeleted()) {
				consignatarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesConsignatario(Consignatario consignatarioAux) throws Exception {
		//this.consignatarioAux=consignatarioAux;
		
			if(consignatarioAux.getIsChanged()) {
				consignatarioAux.setIsChanged(false);
			}		
			
			if(consignatarioAux.getIsNew()) {
				consignatarioAux.setIsNew(false);
			}	
			
			if(consignatarioAux.getIsDeleted()) {
				consignatarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Consignatario consignatarioAsignar,Consignatario consignatario) throws Exception {
		consignatarioAsignar.setId(consignatario.getId());	
		consignatarioAsignar.setVersionRow(consignatario.getVersionRow());	
		consignatarioAsignar.setid_empresa(consignatario.getid_empresa());
		consignatarioAsignar.setempresa_descripcion(consignatario.getempresa_descripcion());	
		consignatarioAsignar.setid_sucursal(consignatario.getid_sucursal());
		consignatarioAsignar.setsucursal_descripcion(consignatario.getsucursal_descripcion());	
		consignatarioAsignar.setid_cliente(consignatario.getid_cliente());
		consignatarioAsignar.setcliente_descripcion(consignatario.getcliente_descripcion());	
		consignatarioAsignar.setid_usuario(consignatario.getid_usuario());
		consignatarioAsignar.setusuario_descripcion(consignatario.getusuario_descripcion());	
		consignatarioAsignar.setnombre_completo(consignatario.getnombre_completo());	
		consignatarioAsignar.setnombre(consignatario.getnombre());	
		consignatarioAsignar.setapellido(consignatario.getapellido());	
	}
	
	public static void inicializarConsignatario(Consignatario consignatario) throws Exception {
		try {
				consignatario.setId(0L);	
					
				consignatario.setid_empresa(-1L);	
				consignatario.setid_sucursal(-1L);	
				consignatario.setid_cliente(-1L);	
				consignatario.setid_usuario(-1L);	
				consignatario.setnombre_completo("");	
				consignatario.setnombre("");	
				consignatario.setapellido("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderConsignatario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignatarioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignatarioConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignatarioConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignatarioConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignatarioConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignatarioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignatarioConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataConsignatario(String sTipo,Row row,Workbook workbook,Consignatario consignatario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(consignatario.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignatario.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignatario.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignatario.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignatario.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignatario.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignatario.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryConsignatario=Constantes.SFINALQUERY;
	
	public String getsFinalQueryConsignatario() {
		return this.sFinalQueryConsignatario;
	}
	
	public void setsFinalQueryConsignatario(String sFinalQueryConsignatario) {
		this.sFinalQueryConsignatario= sFinalQueryConsignatario;
	}
	
	public Border resaltarSeleccionarConsignatario=null;
	
	public Border setResaltarSeleccionarConsignatario(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//consignatarioBeanSwingJInternalFrame.jTtoolBarConsignatario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarConsignatario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarConsignatario() {
		return this.resaltarSeleccionarConsignatario;
	}
	
	public void setResaltarSeleccionarConsignatario(Border borderResaltarSeleccionarConsignatario) {
		this.resaltarSeleccionarConsignatario= borderResaltarSeleccionarConsignatario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridConsignatario=null;
	public Boolean mostraridConsignatario=true;
	public Boolean activaridConsignatario=true;

	public Border resaltarid_empresaConsignatario=null;
	public Boolean mostrarid_empresaConsignatario=true;
	public Boolean activarid_empresaConsignatario=true;
	public Boolean cargarid_empresaConsignatario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaConsignatario=false;//ConEventDepend=true

	public Border resaltarid_sucursalConsignatario=null;
	public Boolean mostrarid_sucursalConsignatario=true;
	public Boolean activarid_sucursalConsignatario=true;
	public Boolean cargarid_sucursalConsignatario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalConsignatario=false;//ConEventDepend=true

	public Border resaltarid_clienteConsignatario=null;
	public Boolean mostrarid_clienteConsignatario=true;
	public Boolean activarid_clienteConsignatario=true;
	public Boolean cargarid_clienteConsignatario=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteConsignatario=false;//ConEventDepend=true

	public Border resaltarid_usuarioConsignatario=null;
	public Boolean mostrarid_usuarioConsignatario=true;
	public Boolean activarid_usuarioConsignatario=true;
	public Boolean cargarid_usuarioConsignatario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioConsignatario=false;//ConEventDepend=true

	public Border resaltarnombre_completoConsignatario=null;
	public Boolean mostrarnombre_completoConsignatario=true;
	public Boolean activarnombre_completoConsignatario=true;

	public Border resaltarnombreConsignatario=null;
	public Boolean mostrarnombreConsignatario=true;
	public Boolean activarnombreConsignatario=true;

	public Border resaltarapellidoConsignatario=null;
	public Boolean mostrarapellidoConsignatario=true;
	public Boolean activarapellidoConsignatario=true;

	
	

	public Border setResaltaridConsignatario(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignatarioBeanSwingJInternalFrame.jTtoolBarConsignatario.setBorder(borderResaltar);
		
		this.resaltaridConsignatario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridConsignatario() {
		return this.resaltaridConsignatario;
	}

	public void setResaltaridConsignatario(Border borderResaltar) {
		this.resaltaridConsignatario= borderResaltar;
	}

	public Boolean getMostraridConsignatario() {
		return this.mostraridConsignatario;
	}

	public void setMostraridConsignatario(Boolean mostraridConsignatario) {
		this.mostraridConsignatario= mostraridConsignatario;
	}

	public Boolean getActivaridConsignatario() {
		return this.activaridConsignatario;
	}

	public void setActivaridConsignatario(Boolean activaridConsignatario) {
		this.activaridConsignatario= activaridConsignatario;
	}

	public Border setResaltarid_empresaConsignatario(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignatarioBeanSwingJInternalFrame.jTtoolBarConsignatario.setBorder(borderResaltar);
		
		this.resaltarid_empresaConsignatario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaConsignatario() {
		return this.resaltarid_empresaConsignatario;
	}

	public void setResaltarid_empresaConsignatario(Border borderResaltar) {
		this.resaltarid_empresaConsignatario= borderResaltar;
	}

	public Boolean getMostrarid_empresaConsignatario() {
		return this.mostrarid_empresaConsignatario;
	}

	public void setMostrarid_empresaConsignatario(Boolean mostrarid_empresaConsignatario) {
		this.mostrarid_empresaConsignatario= mostrarid_empresaConsignatario;
	}

	public Boolean getActivarid_empresaConsignatario() {
		return this.activarid_empresaConsignatario;
	}

	public void setActivarid_empresaConsignatario(Boolean activarid_empresaConsignatario) {
		this.activarid_empresaConsignatario= activarid_empresaConsignatario;
	}

	public Boolean getCargarid_empresaConsignatario() {
		return this.cargarid_empresaConsignatario;
	}

	public void setCargarid_empresaConsignatario(Boolean cargarid_empresaConsignatario) {
		this.cargarid_empresaConsignatario= cargarid_empresaConsignatario;
	}

	public Border setResaltarid_sucursalConsignatario(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignatarioBeanSwingJInternalFrame.jTtoolBarConsignatario.setBorder(borderResaltar);
		
		this.resaltarid_sucursalConsignatario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalConsignatario() {
		return this.resaltarid_sucursalConsignatario;
	}

	public void setResaltarid_sucursalConsignatario(Border borderResaltar) {
		this.resaltarid_sucursalConsignatario= borderResaltar;
	}

	public Boolean getMostrarid_sucursalConsignatario() {
		return this.mostrarid_sucursalConsignatario;
	}

	public void setMostrarid_sucursalConsignatario(Boolean mostrarid_sucursalConsignatario) {
		this.mostrarid_sucursalConsignatario= mostrarid_sucursalConsignatario;
	}

	public Boolean getActivarid_sucursalConsignatario() {
		return this.activarid_sucursalConsignatario;
	}

	public void setActivarid_sucursalConsignatario(Boolean activarid_sucursalConsignatario) {
		this.activarid_sucursalConsignatario= activarid_sucursalConsignatario;
	}

	public Boolean getCargarid_sucursalConsignatario() {
		return this.cargarid_sucursalConsignatario;
	}

	public void setCargarid_sucursalConsignatario(Boolean cargarid_sucursalConsignatario) {
		this.cargarid_sucursalConsignatario= cargarid_sucursalConsignatario;
	}

	public Border setResaltarid_clienteConsignatario(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignatarioBeanSwingJInternalFrame.jTtoolBarConsignatario.setBorder(borderResaltar);
		
		this.resaltarid_clienteConsignatario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteConsignatario() {
		return this.resaltarid_clienteConsignatario;
	}

	public void setResaltarid_clienteConsignatario(Border borderResaltar) {
		this.resaltarid_clienteConsignatario= borderResaltar;
	}

	public Boolean getMostrarid_clienteConsignatario() {
		return this.mostrarid_clienteConsignatario;
	}

	public void setMostrarid_clienteConsignatario(Boolean mostrarid_clienteConsignatario) {
		this.mostrarid_clienteConsignatario= mostrarid_clienteConsignatario;
	}

	public Boolean getActivarid_clienteConsignatario() {
		return this.activarid_clienteConsignatario;
	}

	public void setActivarid_clienteConsignatario(Boolean activarid_clienteConsignatario) {
		this.activarid_clienteConsignatario= activarid_clienteConsignatario;
	}

	public Boolean getCargarid_clienteConsignatario() {
		return this.cargarid_clienteConsignatario;
	}

	public void setCargarid_clienteConsignatario(Boolean cargarid_clienteConsignatario) {
		this.cargarid_clienteConsignatario= cargarid_clienteConsignatario;
	}

	public Border setResaltarid_usuarioConsignatario(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignatarioBeanSwingJInternalFrame.jTtoolBarConsignatario.setBorder(borderResaltar);
		
		this.resaltarid_usuarioConsignatario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioConsignatario() {
		return this.resaltarid_usuarioConsignatario;
	}

	public void setResaltarid_usuarioConsignatario(Border borderResaltar) {
		this.resaltarid_usuarioConsignatario= borderResaltar;
	}

	public Boolean getMostrarid_usuarioConsignatario() {
		return this.mostrarid_usuarioConsignatario;
	}

	public void setMostrarid_usuarioConsignatario(Boolean mostrarid_usuarioConsignatario) {
		this.mostrarid_usuarioConsignatario= mostrarid_usuarioConsignatario;
	}

	public Boolean getActivarid_usuarioConsignatario() {
		return this.activarid_usuarioConsignatario;
	}

	public void setActivarid_usuarioConsignatario(Boolean activarid_usuarioConsignatario) {
		this.activarid_usuarioConsignatario= activarid_usuarioConsignatario;
	}

	public Boolean getCargarid_usuarioConsignatario() {
		return this.cargarid_usuarioConsignatario;
	}

	public void setCargarid_usuarioConsignatario(Boolean cargarid_usuarioConsignatario) {
		this.cargarid_usuarioConsignatario= cargarid_usuarioConsignatario;
	}

	public Border setResaltarnombre_completoConsignatario(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignatarioBeanSwingJInternalFrame.jTtoolBarConsignatario.setBorder(borderResaltar);
		
		this.resaltarnombre_completoConsignatario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoConsignatario() {
		return this.resaltarnombre_completoConsignatario;
	}

	public void setResaltarnombre_completoConsignatario(Border borderResaltar) {
		this.resaltarnombre_completoConsignatario= borderResaltar;
	}

	public Boolean getMostrarnombre_completoConsignatario() {
		return this.mostrarnombre_completoConsignatario;
	}

	public void setMostrarnombre_completoConsignatario(Boolean mostrarnombre_completoConsignatario) {
		this.mostrarnombre_completoConsignatario= mostrarnombre_completoConsignatario;
	}

	public Boolean getActivarnombre_completoConsignatario() {
		return this.activarnombre_completoConsignatario;
	}

	public void setActivarnombre_completoConsignatario(Boolean activarnombre_completoConsignatario) {
		this.activarnombre_completoConsignatario= activarnombre_completoConsignatario;
	}

	public Border setResaltarnombreConsignatario(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignatarioBeanSwingJInternalFrame.jTtoolBarConsignatario.setBorder(borderResaltar);
		
		this.resaltarnombreConsignatario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreConsignatario() {
		return this.resaltarnombreConsignatario;
	}

	public void setResaltarnombreConsignatario(Border borderResaltar) {
		this.resaltarnombreConsignatario= borderResaltar;
	}

	public Boolean getMostrarnombreConsignatario() {
		return this.mostrarnombreConsignatario;
	}

	public void setMostrarnombreConsignatario(Boolean mostrarnombreConsignatario) {
		this.mostrarnombreConsignatario= mostrarnombreConsignatario;
	}

	public Boolean getActivarnombreConsignatario() {
		return this.activarnombreConsignatario;
	}

	public void setActivarnombreConsignatario(Boolean activarnombreConsignatario) {
		this.activarnombreConsignatario= activarnombreConsignatario;
	}

	public Border setResaltarapellidoConsignatario(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignatarioBeanSwingJInternalFrame.jTtoolBarConsignatario.setBorder(borderResaltar);
		
		this.resaltarapellidoConsignatario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoConsignatario() {
		return this.resaltarapellidoConsignatario;
	}

	public void setResaltarapellidoConsignatario(Border borderResaltar) {
		this.resaltarapellidoConsignatario= borderResaltar;
	}

	public Boolean getMostrarapellidoConsignatario() {
		return this.mostrarapellidoConsignatario;
	}

	public void setMostrarapellidoConsignatario(Boolean mostrarapellidoConsignatario) {
		this.mostrarapellidoConsignatario= mostrarapellidoConsignatario;
	}

	public Boolean getActivarapellidoConsignatario() {
		return this.activarapellidoConsignatario;
	}

	public void setActivarapellidoConsignatario(Boolean activarapellidoConsignatario) {
		this.activarapellidoConsignatario= activarapellidoConsignatario;
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
		
		
		this.setMostraridConsignatario(esInicial);
		this.setMostrarid_empresaConsignatario(esInicial);
		this.setMostrarid_sucursalConsignatario(esInicial);
		this.setMostrarid_clienteConsignatario(esInicial);
		this.setMostrarid_usuarioConsignatario(esInicial);
		this.setMostrarnombre_completoConsignatario(esInicial);
		this.setMostrarnombreConsignatario(esInicial);
		this.setMostrarapellidoConsignatario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsignatarioConstantesFunciones.ID)) {
				this.setMostraridConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoConsignatario(esAsigna);
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
		
		
		this.setActivaridConsignatario(esInicial);
		this.setActivarid_empresaConsignatario(esInicial);
		this.setActivarid_sucursalConsignatario(esInicial);
		this.setActivarid_clienteConsignatario(esInicial);
		this.setActivarid_usuarioConsignatario(esInicial);
		this.setActivarnombre_completoConsignatario(esInicial);
		this.setActivarnombreConsignatario(esInicial);
		this.setActivarapellidoConsignatario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsignatarioConstantesFunciones.ID)) {
				this.setActivaridConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoConsignatario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridConsignatario(esInicial);
		this.setResaltarid_empresaConsignatario(esInicial);
		this.setResaltarid_sucursalConsignatario(esInicial);
		this.setResaltarid_clienteConsignatario(esInicial);
		this.setResaltarid_usuarioConsignatario(esInicial);
		this.setResaltarnombre_completoConsignatario(esInicial);
		this.setResaltarnombreConsignatario(esInicial);
		this.setResaltarapellidoConsignatario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsignatarioConstantesFunciones.ID)) {
				this.setResaltaridConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreConsignatario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignatarioConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoConsignatario(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProformaConsignatario=null;

	public Border getResaltarProformaConsignatario() {
		return this.resaltarProformaConsignatario;
	}

	public void setResaltarProformaConsignatario(Border borderResaltarProforma) {
		if(borderResaltarProforma!=null) {
			this.resaltarProformaConsignatario= borderResaltarProforma;
		}
	}

	public Border setResaltarProformaConsignatario(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/) {
		Border borderResaltarProforma=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//consignatarioBeanSwingJInternalFrame.jTtoolBarConsignatario.setBorder(borderResaltarProforma);
			
		this.resaltarProformaConsignatario= borderResaltarProforma;

		 return borderResaltarProforma;
	}



	public Boolean mostrarProformaConsignatario=true;

	public Boolean getMostrarProformaConsignatario() {
		return this.mostrarProformaConsignatario;
	}

	public void setMostrarProformaConsignatario(Boolean visibilidadResaltarProforma) {
		this.mostrarProformaConsignatario= visibilidadResaltarProforma;
	}



	public Boolean activarProformaConsignatario=true;

	public Boolean gethabilitarResaltarProformaConsignatario() {
		return this.activarProformaConsignatario;
	}

	public void setActivarProformaConsignatario(Boolean habilitarResaltarProforma) {
		this.activarProformaConsignatario= habilitarResaltarProforma;
	}


	public Border resaltarConsignacionConsignatario=null;

	public Border getResaltarConsignacionConsignatario() {
		return this.resaltarConsignacionConsignatario;
	}

	public void setResaltarConsignacionConsignatario(Border borderResaltarConsignacion) {
		if(borderResaltarConsignacion!=null) {
			this.resaltarConsignacionConsignatario= borderResaltarConsignacion;
		}
	}

	public Border setResaltarConsignacionConsignatario(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/) {
		Border borderResaltarConsignacion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//consignatarioBeanSwingJInternalFrame.jTtoolBarConsignatario.setBorder(borderResaltarConsignacion);
			
		this.resaltarConsignacionConsignatario= borderResaltarConsignacion;

		 return borderResaltarConsignacion;
	}



	public Boolean mostrarConsignacionConsignatario=true;

	public Boolean getMostrarConsignacionConsignatario() {
		return this.mostrarConsignacionConsignatario;
	}

	public void setMostrarConsignacionConsignatario(Boolean visibilidadResaltarConsignacion) {
		this.mostrarConsignacionConsignatario= visibilidadResaltarConsignacion;
	}



	public Boolean activarConsignacionConsignatario=true;

	public Boolean gethabilitarResaltarConsignacionConsignatario() {
		return this.activarConsignacionConsignatario;
	}

	public void setActivarConsignacionConsignatario(Boolean habilitarResaltarConsignacion) {
		this.activarConsignacionConsignatario= habilitarResaltarConsignacion;
	}


	public Border resaltarPedidoExporConsignatario=null;

	public Border getResaltarPedidoExporConsignatario() {
		return this.resaltarPedidoExporConsignatario;
	}

	public void setResaltarPedidoExporConsignatario(Border borderResaltarPedidoExpor) {
		if(borderResaltarPedidoExpor!=null) {
			this.resaltarPedidoExporConsignatario= borderResaltarPedidoExpor;
		}
	}

	public Border setResaltarPedidoExporConsignatario(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoExpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//consignatarioBeanSwingJInternalFrame.jTtoolBarConsignatario.setBorder(borderResaltarPedidoExpor);
			
		this.resaltarPedidoExporConsignatario= borderResaltarPedidoExpor;

		 return borderResaltarPedidoExpor;
	}



	public Boolean mostrarPedidoExporConsignatario=true;

	public Boolean getMostrarPedidoExporConsignatario() {
		return this.mostrarPedidoExporConsignatario;
	}

	public void setMostrarPedidoExporConsignatario(Boolean visibilidadResaltarPedidoExpor) {
		this.mostrarPedidoExporConsignatario= visibilidadResaltarPedidoExpor;
	}



	public Boolean activarPedidoExporConsignatario=true;

	public Boolean gethabilitarResaltarPedidoExporConsignatario() {
		return this.activarPedidoExporConsignatario;
	}

	public void setActivarPedidoExporConsignatario(Boolean habilitarResaltarPedidoExpor) {
		this.activarPedidoExporConsignatario= habilitarResaltarPedidoExpor;
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

		this.setMostrarProformaConsignatario(esInicial);
		this.setMostrarConsignacionConsignatario(esInicial);
		this.setMostrarPedidoExporConsignatario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Proforma.class)) {
				this.setMostrarProformaConsignatario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignacion.class)) {
				this.setMostrarConsignacionConsignatario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setMostrarPedidoExporConsignatario(esAsigna);
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

		this.setActivarProformaConsignatario(esInicial);
		this.setActivarConsignacionConsignatario(esInicial);
		this.setActivarPedidoExporConsignatario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Proforma.class)) {
				this.setActivarProformaConsignatario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignacion.class)) {
				this.setActivarConsignacionConsignatario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setActivarPedidoExporConsignatario(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProformaConsignatario(esInicial);
		this.setResaltarConsignacionConsignatario(esInicial);
		this.setResaltarPedidoExporConsignatario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Proforma.class)) {
				this.setResaltarProformaConsignatario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignacion.class)) {
				this.setResaltarConsignacionConsignatario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setResaltarPedidoExporConsignatario(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdClienteConsignatario=true;

	public Boolean getMostrarFK_IdClienteConsignatario() {
		return this.mostrarFK_IdClienteConsignatario;
	}

	public void setMostrarFK_IdClienteConsignatario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteConsignatario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaConsignatario=true;

	public Boolean getMostrarFK_IdEmpresaConsignatario() {
		return this.mostrarFK_IdEmpresaConsignatario;
	}

	public void setMostrarFK_IdEmpresaConsignatario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaConsignatario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalConsignatario=true;

	public Boolean getMostrarFK_IdSucursalConsignatario() {
		return this.mostrarFK_IdSucursalConsignatario;
	}

	public void setMostrarFK_IdSucursalConsignatario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalConsignatario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioConsignatario=true;

	public Boolean getMostrarFK_IdUsuarioConsignatario() {
		return this.mostrarFK_IdUsuarioConsignatario;
	}

	public void setMostrarFK_IdUsuarioConsignatario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioConsignatario= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteConsignatario=true;

	public Boolean getActivarFK_IdClienteConsignatario() {
		return this.activarFK_IdClienteConsignatario;
	}

	public void setActivarFK_IdClienteConsignatario(Boolean habilitarResaltar) {
		this.activarFK_IdClienteConsignatario= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaConsignatario=true;

	public Boolean getActivarFK_IdEmpresaConsignatario() {
		return this.activarFK_IdEmpresaConsignatario;
	}

	public void setActivarFK_IdEmpresaConsignatario(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaConsignatario= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalConsignatario=true;

	public Boolean getActivarFK_IdSucursalConsignatario() {
		return this.activarFK_IdSucursalConsignatario;
	}

	public void setActivarFK_IdSucursalConsignatario(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalConsignatario= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioConsignatario=true;

	public Boolean getActivarFK_IdUsuarioConsignatario() {
		return this.activarFK_IdUsuarioConsignatario;
	}

	public void setActivarFK_IdUsuarioConsignatario(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioConsignatario= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteConsignatario=null;

	public Border getResaltarFK_IdClienteConsignatario() {
		return this.resaltarFK_IdClienteConsignatario;
	}

	public void setResaltarFK_IdClienteConsignatario(Border borderResaltar) {
		this.resaltarFK_IdClienteConsignatario= borderResaltar;
	}

	public void setResaltarFK_IdClienteConsignatario(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteConsignatario= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaConsignatario=null;

	public Border getResaltarFK_IdEmpresaConsignatario() {
		return this.resaltarFK_IdEmpresaConsignatario;
	}

	public void setResaltarFK_IdEmpresaConsignatario(Border borderResaltar) {
		this.resaltarFK_IdEmpresaConsignatario= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaConsignatario(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaConsignatario= borderResaltar;
	}

	public Border resaltarFK_IdSucursalConsignatario=null;

	public Border getResaltarFK_IdSucursalConsignatario() {
		return this.resaltarFK_IdSucursalConsignatario;
	}

	public void setResaltarFK_IdSucursalConsignatario(Border borderResaltar) {
		this.resaltarFK_IdSucursalConsignatario= borderResaltar;
	}

	public void setResaltarFK_IdSucursalConsignatario(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalConsignatario= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioConsignatario=null;

	public Border getResaltarFK_IdUsuarioConsignatario() {
		return this.resaltarFK_IdUsuarioConsignatario;
	}

	public void setResaltarFK_IdUsuarioConsignatario(Border borderResaltar) {
		this.resaltarFK_IdUsuarioConsignatario= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioConsignatario(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignatarioBeanSwingJInternalFrame consignatarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioConsignatario= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
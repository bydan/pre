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


import com.bydan.erp.importaciones.util.ContenedorConstantesFunciones;
import com.bydan.erp.importaciones.util.ContenedorParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.ContenedorParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ContenedorConstantesFunciones extends ContenedorConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Contenedor";
	public static final String SPATHOPCION="Importaciones";	
	public static final String SPATHMODULO="importaciones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Contenedor"+ContenedorConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ContenedorHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ContenedorHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ContenedorConstantesFunciones.SCHEMA+"_"+ContenedorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ContenedorHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ContenedorConstantesFunciones.SCHEMA+"_"+ContenedorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ContenedorConstantesFunciones.SCHEMA+"_"+ContenedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ContenedorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ContenedorConstantesFunciones.SCHEMA+"_"+ContenedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ContenedorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ContenedorHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ContenedorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ContenedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ContenedorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ContenedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ContenedorConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ContenedorConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ContenedorConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ContenedorConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Contenedores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Contenedor";
	public static final String SCLASSWEBTITULO_LOWER="Contenedor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Contenedor";
	public static final String OBJECTNAME="contenedor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_IMPORTACIONES;	
	public static final String TABLENAME="contenedor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select contenedor from "+ContenedorConstantesFunciones.SPERSISTENCENAME+" contenedor";
	public static String QUERYSELECTNATIVE="select "+ContenedorConstantesFunciones.SCHEMA+"."+ContenedorConstantesFunciones.TABLENAME+".id,"+ContenedorConstantesFunciones.SCHEMA+"."+ContenedorConstantesFunciones.TABLENAME+".version_row,"+ContenedorConstantesFunciones.SCHEMA+"."+ContenedorConstantesFunciones.TABLENAME+".id_empresa,"+ContenedorConstantesFunciones.SCHEMA+"."+ContenedorConstantesFunciones.TABLENAME+".id_sucursal,"+ContenedorConstantesFunciones.SCHEMA+"."+ContenedorConstantesFunciones.TABLENAME+".id_pedido,"+ContenedorConstantesFunciones.SCHEMA+"."+ContenedorConstantesFunciones.TABLENAME+".numero,"+ContenedorConstantesFunciones.SCHEMA+"."+ContenedorConstantesFunciones.TABLENAME+".numero_bl,"+ContenedorConstantesFunciones.SCHEMA+"."+ContenedorConstantesFunciones.TABLENAME+".descripcion from "+ContenedorConstantesFunciones.SCHEMA+"."+ContenedorConstantesFunciones.TABLENAME;//+" as "+ContenedorConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ContenedorConstantesFuncionesAdditional contenedorConstantesFuncionesAdditional=null;
	
	public ContenedorConstantesFuncionesAdditional getContenedorConstantesFuncionesAdditional() {
		return this.contenedorConstantesFuncionesAdditional;
	}
	
	public void setContenedorConstantesFuncionesAdditional(ContenedorConstantesFuncionesAdditional contenedorConstantesFuncionesAdditional) {
		try {
			this.contenedorConstantesFuncionesAdditional=contenedorConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDPEDIDO= "id_pedido";
    public static final String NUMERO= "numero";
    public static final String NUMEROBL= "numero_bl";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDPEDIDO= "Pedido";
		public static final String LABEL_IDPEDIDO_LOWER= "Pedido";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_NUMEROBL= "Numero Bl";
		public static final String LABEL_NUMEROBL_LOWER= "Numero Bl";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_BL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_BL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getContenedorLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ContenedorConstantesFunciones.IDEMPRESA)) {sLabelColumna=ContenedorConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ContenedorConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ContenedorConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ContenedorConstantesFunciones.IDPEDIDO)) {sLabelColumna=ContenedorConstantesFunciones.LABEL_IDPEDIDO;}
		if(sNombreColumna.equals(ContenedorConstantesFunciones.NUMERO)) {sLabelColumna=ContenedorConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(ContenedorConstantesFunciones.NUMEROBL)) {sLabelColumna=ContenedorConstantesFunciones.LABEL_NUMEROBL;}
		if(sNombreColumna.equals(ContenedorConstantesFunciones.DESCRIPCION)) {sLabelColumna=ContenedorConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getContenedorDescripcion(Contenedor contenedor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(contenedor !=null/* && contenedor.getId()!=0*/) {
			if(contenedor.getId()!=null) {
				sDescripcion=contenedor.getId().toString();
			}//contenedorcontenedor.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getContenedorDescripcionDetallado(Contenedor contenedor) {
		String sDescripcion="";
			
		sDescripcion+=ContenedorConstantesFunciones.ID+"=";
		sDescripcion+=contenedor.getId().toString()+",";
		sDescripcion+=ContenedorConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=contenedor.getVersionRow().toString()+",";
		sDescripcion+=ContenedorConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=contenedor.getid_empresa().toString()+",";
		sDescripcion+=ContenedorConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=contenedor.getid_sucursal().toString()+",";
		sDescripcion+=ContenedorConstantesFunciones.IDPEDIDO+"=";
		sDescripcion+=contenedor.getid_pedido().toString()+",";
		sDescripcion+=ContenedorConstantesFunciones.NUMERO+"=";
		sDescripcion+=contenedor.getnumero()+",";
		sDescripcion+=ContenedorConstantesFunciones.NUMEROBL+"=";
		sDescripcion+=contenedor.getnumero_bl()+",";
		sDescripcion+=ContenedorConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=contenedor.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setContenedorDescripcion(Contenedor contenedor,String sValor) throws Exception {			
		if(contenedor !=null) {
			//contenedorcontenedor.getId().toString();
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

	public static String getPedidoDescripcion(Pedido pedido) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pedido!=null/*&&pedido.getId()>0*/) {
			sDescripcion=PedidoConstantesFunciones.getPedidoDescripcion(pedido);
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
		} else if(sNombreIndice.equals("FK_IdPedido")) {
			sNombreIndice="Tipo=  Por Pedido";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdPedido(Long id_pedido) {
		String sDetalleIndice=" Parametros->";
		if(id_pedido!=null) {sDetalleIndice+=" Codigo Unico De Pedido="+id_pedido.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosContenedor(Contenedor contenedor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		contenedor.setnumero(contenedor.getnumero().trim());
		contenedor.setnumero_bl(contenedor.getnumero_bl().trim());
		contenedor.setdescripcion(contenedor.getdescripcion().trim());
	}
	
	public static void quitarEspaciosContenedors(List<Contenedor> contenedors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Contenedor contenedor: contenedors) {
			contenedor.setnumero(contenedor.getnumero().trim());
			contenedor.setnumero_bl(contenedor.getnumero_bl().trim());
			contenedor.setdescripcion(contenedor.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresContenedor(Contenedor contenedor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && contenedor.getConCambioAuxiliar()) {
			contenedor.setIsDeleted(contenedor.getIsDeletedAuxiliar());	
			contenedor.setIsNew(contenedor.getIsNewAuxiliar());	
			contenedor.setIsChanged(contenedor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			contenedor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			contenedor.setIsDeletedAuxiliar(false);	
			contenedor.setIsNewAuxiliar(false);	
			contenedor.setIsChangedAuxiliar(false);
			
			contenedor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresContenedors(List<Contenedor> contenedors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Contenedor contenedor : contenedors) {
			if(conAsignarBase && contenedor.getConCambioAuxiliar()) {
				contenedor.setIsDeleted(contenedor.getIsDeletedAuxiliar());	
				contenedor.setIsNew(contenedor.getIsNewAuxiliar());	
				contenedor.setIsChanged(contenedor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				contenedor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				contenedor.setIsDeletedAuxiliar(false);	
				contenedor.setIsNewAuxiliar(false);	
				contenedor.setIsChangedAuxiliar(false);
				
				contenedor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresContenedor(Contenedor contenedor,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresContenedors(List<Contenedor> contenedors,Boolean conEnteros) throws Exception  {
		
		for(Contenedor contenedor: contenedors) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaContenedor(List<Contenedor> contenedors,Contenedor contenedorAux) throws Exception  {
		ContenedorConstantesFunciones.InicializarValoresContenedor(contenedorAux,true);
		
		for(Contenedor contenedor: contenedors) {
			if(contenedor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesContenedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ContenedorConstantesFunciones.getArrayColumnasGlobalesContenedor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesContenedor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ContenedorConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ContenedorConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ContenedorConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ContenedorConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoContenedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Contenedor> contenedors,Contenedor contenedor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Contenedor contenedorAux: contenedors) {
			if(contenedorAux!=null && contenedor!=null) {
				if((contenedorAux.getId()==null && contenedor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(contenedorAux.getId()!=null && contenedor.getId()!=null){
					if(contenedorAux.getId().equals(contenedor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaContenedor(List<Contenedor> contenedors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Contenedor contenedor: contenedors) {			
			if(contenedor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaContenedor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ContenedorConstantesFunciones.LABEL_ID, ContenedorConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContenedorConstantesFunciones.LABEL_VERSIONROW, ContenedorConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContenedorConstantesFunciones.LABEL_IDEMPRESA, ContenedorConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContenedorConstantesFunciones.LABEL_IDSUCURSAL, ContenedorConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContenedorConstantesFunciones.LABEL_IDPEDIDO, ContenedorConstantesFunciones.IDPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContenedorConstantesFunciones.LABEL_NUMERO, ContenedorConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContenedorConstantesFunciones.LABEL_NUMEROBL, ContenedorConstantesFunciones.NUMEROBL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContenedorConstantesFunciones.LABEL_DESCRIPCION, ContenedorConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasContenedor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ContenedorConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContenedorConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContenedorConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContenedorConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContenedorConstantesFunciones.IDPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContenedorConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContenedorConstantesFunciones.NUMEROBL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContenedorConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarContenedor() throws Exception  {
		return ContenedorConstantesFunciones.getTiposSeleccionarContenedor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarContenedor(Boolean conFk) throws Exception  {
		return ContenedorConstantesFunciones.getTiposSeleccionarContenedor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarContenedor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ContenedorConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ContenedorConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ContenedorConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ContenedorConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ContenedorConstantesFunciones.LABEL_IDPEDIDO);
			reporte.setsDescripcion(ContenedorConstantesFunciones.LABEL_IDPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ContenedorConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(ContenedorConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ContenedorConstantesFunciones.LABEL_NUMEROBL);
			reporte.setsDescripcion(ContenedorConstantesFunciones.LABEL_NUMEROBL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ContenedorConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ContenedorConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesContenedor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesContenedor(Contenedor contenedorAux) throws Exception {
		
			contenedorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(contenedorAux.getEmpresa()));
			contenedorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(contenedorAux.getSucursal()));
			contenedorAux.setpedido_descripcion(PedidoConstantesFunciones.getPedidoDescripcion(contenedorAux.getPedido()));		
	}
	
	public static void refrescarForeignKeysDescripcionesContenedor(List<Contenedor> contenedorsTemp) throws Exception {
		for(Contenedor contenedorAux:contenedorsTemp) {
			
			contenedorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(contenedorAux.getEmpresa()));
			contenedorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(contenedorAux.getSucursal()));
			contenedorAux.setpedido_descripcion(PedidoConstantesFunciones.getPedidoDescripcion(contenedorAux.getPedido()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfContenedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Pedido.class));
				
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
					if(clas.clas.equals(Pedido.class)) {
						classes.add(new Classe(Pedido.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfContenedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfContenedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ContenedorConstantesFunciones.getClassesRelationshipsOfContenedor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfContenedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfContenedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ContenedorConstantesFunciones.getClassesRelationshipsFromStringsOfContenedor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfContenedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Contenedor contenedor,List<Contenedor> contenedors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Contenedor contenedorEncontrado=null;
			
			for(Contenedor contenedorLocal:contenedors) {
				if(contenedorLocal.getId().equals(contenedor.getId())) {
					contenedorEncontrado=contenedorLocal;
					
					contenedorLocal.setIsChanged(contenedor.getIsChanged());
					contenedorLocal.setIsNew(contenedor.getIsNew());
					contenedorLocal.setIsDeleted(contenedor.getIsDeleted());
					
					contenedorLocal.setGeneralEntityOriginal(contenedor.getGeneralEntityOriginal());
					
					contenedorLocal.setId(contenedor.getId());	
					contenedorLocal.setVersionRow(contenedor.getVersionRow());	
					contenedorLocal.setid_empresa(contenedor.getid_empresa());	
					contenedorLocal.setid_sucursal(contenedor.getid_sucursal());	
					contenedorLocal.setid_pedido(contenedor.getid_pedido());	
					contenedorLocal.setnumero(contenedor.getnumero());	
					contenedorLocal.setnumero_bl(contenedor.getnumero_bl());	
					contenedorLocal.setdescripcion(contenedor.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!contenedor.getIsDeleted()) {
				if(!existe) {
					contenedors.add(contenedor);
				}
			} else {
				if(contenedorEncontrado!=null && permiteQuitar)  {
					contenedors.remove(contenedorEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Contenedor contenedor,List<Contenedor> contenedors) throws Exception {
		try	{			
			for(Contenedor contenedorLocal:contenedors) {
				if(contenedorLocal.getId().equals(contenedor.getId())) {
					contenedorLocal.setIsSelected(contenedor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesContenedor(List<Contenedor> contenedorsAux) throws Exception {
		//this.contenedorsAux=contenedorsAux;
		
		for(Contenedor contenedorAux:contenedorsAux) {
			if(contenedorAux.getIsChanged()) {
				contenedorAux.setIsChanged(false);
			}		
			
			if(contenedorAux.getIsNew()) {
				contenedorAux.setIsNew(false);
			}	
			
			if(contenedorAux.getIsDeleted()) {
				contenedorAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesContenedor(Contenedor contenedorAux) throws Exception {
		//this.contenedorAux=contenedorAux;
		
			if(contenedorAux.getIsChanged()) {
				contenedorAux.setIsChanged(false);
			}		
			
			if(contenedorAux.getIsNew()) {
				contenedorAux.setIsNew(false);
			}	
			
			if(contenedorAux.getIsDeleted()) {
				contenedorAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Contenedor contenedorAsignar,Contenedor contenedor) throws Exception {
		contenedorAsignar.setId(contenedor.getId());	
		contenedorAsignar.setVersionRow(contenedor.getVersionRow());	
		contenedorAsignar.setid_empresa(contenedor.getid_empresa());
		contenedorAsignar.setempresa_descripcion(contenedor.getempresa_descripcion());	
		contenedorAsignar.setid_sucursal(contenedor.getid_sucursal());
		contenedorAsignar.setsucursal_descripcion(contenedor.getsucursal_descripcion());	
		contenedorAsignar.setid_pedido(contenedor.getid_pedido());
		contenedorAsignar.setpedido_descripcion(contenedor.getpedido_descripcion());	
		contenedorAsignar.setnumero(contenedor.getnumero());	
		contenedorAsignar.setnumero_bl(contenedor.getnumero_bl());	
		contenedorAsignar.setdescripcion(contenedor.getdescripcion());	
	}
	
	public static void inicializarContenedor(Contenedor contenedor) throws Exception {
		try {
				contenedor.setId(0L);	
					
				contenedor.setid_empresa(-1L);	
				contenedor.setid_sucursal(-1L);	
				contenedor.setid_pedido(-1L);	
				contenedor.setnumero("");	
				contenedor.setnumero_bl("");	
				contenedor.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderContenedor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ContenedorConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ContenedorConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ContenedorConstantesFunciones.LABEL_IDPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ContenedorConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ContenedorConstantesFunciones.LABEL_NUMEROBL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ContenedorConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataContenedor(String sTipo,Row row,Workbook workbook,Contenedor contenedor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(contenedor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(contenedor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(contenedor.getpedido_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(contenedor.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(contenedor.getnumero_bl());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(contenedor.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryContenedor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryContenedor() {
		return this.sFinalQueryContenedor;
	}
	
	public void setsFinalQueryContenedor(String sFinalQueryContenedor) {
		this.sFinalQueryContenedor= sFinalQueryContenedor;
	}
	
	public Border resaltarSeleccionarContenedor=null;
	
	public Border setResaltarSeleccionarContenedor(ParametroGeneralUsuario parametroGeneralUsuario/*ContenedorBeanSwingJInternalFrame contenedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//contenedorBeanSwingJInternalFrame.jTtoolBarContenedor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarContenedor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarContenedor() {
		return this.resaltarSeleccionarContenedor;
	}
	
	public void setResaltarSeleccionarContenedor(Border borderResaltarSeleccionarContenedor) {
		this.resaltarSeleccionarContenedor= borderResaltarSeleccionarContenedor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridContenedor=null;
	public Boolean mostraridContenedor=true;
	public Boolean activaridContenedor=true;

	public Border resaltarid_empresaContenedor=null;
	public Boolean mostrarid_empresaContenedor=true;
	public Boolean activarid_empresaContenedor=true;
	public Boolean cargarid_empresaContenedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaContenedor=false;//ConEventDepend=true

	public Border resaltarid_sucursalContenedor=null;
	public Boolean mostrarid_sucursalContenedor=true;
	public Boolean activarid_sucursalContenedor=true;
	public Boolean cargarid_sucursalContenedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalContenedor=false;//ConEventDepend=true

	public Border resaltarid_pedidoContenedor=null;
	public Boolean mostrarid_pedidoContenedor=true;
	public Boolean activarid_pedidoContenedor=true;
	public Boolean cargarid_pedidoContenedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pedidoContenedor=false;//ConEventDepend=true

	public Border resaltarnumeroContenedor=null;
	public Boolean mostrarnumeroContenedor=true;
	public Boolean activarnumeroContenedor=true;

	public Border resaltarnumero_blContenedor=null;
	public Boolean mostrarnumero_blContenedor=true;
	public Boolean activarnumero_blContenedor=true;

	public Border resaltardescripcionContenedor=null;
	public Boolean mostrardescripcionContenedor=true;
	public Boolean activardescripcionContenedor=true;

	
	

	public Border setResaltaridContenedor(ParametroGeneralUsuario parametroGeneralUsuario/*ContenedorBeanSwingJInternalFrame contenedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contenedorBeanSwingJInternalFrame.jTtoolBarContenedor.setBorder(borderResaltar);
		
		this.resaltaridContenedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridContenedor() {
		return this.resaltaridContenedor;
	}

	public void setResaltaridContenedor(Border borderResaltar) {
		this.resaltaridContenedor= borderResaltar;
	}

	public Boolean getMostraridContenedor() {
		return this.mostraridContenedor;
	}

	public void setMostraridContenedor(Boolean mostraridContenedor) {
		this.mostraridContenedor= mostraridContenedor;
	}

	public Boolean getActivaridContenedor() {
		return this.activaridContenedor;
	}

	public void setActivaridContenedor(Boolean activaridContenedor) {
		this.activaridContenedor= activaridContenedor;
	}

	public Border setResaltarid_empresaContenedor(ParametroGeneralUsuario parametroGeneralUsuario/*ContenedorBeanSwingJInternalFrame contenedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contenedorBeanSwingJInternalFrame.jTtoolBarContenedor.setBorder(borderResaltar);
		
		this.resaltarid_empresaContenedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaContenedor() {
		return this.resaltarid_empresaContenedor;
	}

	public void setResaltarid_empresaContenedor(Border borderResaltar) {
		this.resaltarid_empresaContenedor= borderResaltar;
	}

	public Boolean getMostrarid_empresaContenedor() {
		return this.mostrarid_empresaContenedor;
	}

	public void setMostrarid_empresaContenedor(Boolean mostrarid_empresaContenedor) {
		this.mostrarid_empresaContenedor= mostrarid_empresaContenedor;
	}

	public Boolean getActivarid_empresaContenedor() {
		return this.activarid_empresaContenedor;
	}

	public void setActivarid_empresaContenedor(Boolean activarid_empresaContenedor) {
		this.activarid_empresaContenedor= activarid_empresaContenedor;
	}

	public Boolean getCargarid_empresaContenedor() {
		return this.cargarid_empresaContenedor;
	}

	public void setCargarid_empresaContenedor(Boolean cargarid_empresaContenedor) {
		this.cargarid_empresaContenedor= cargarid_empresaContenedor;
	}

	public Border setResaltarid_sucursalContenedor(ParametroGeneralUsuario parametroGeneralUsuario/*ContenedorBeanSwingJInternalFrame contenedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contenedorBeanSwingJInternalFrame.jTtoolBarContenedor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalContenedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalContenedor() {
		return this.resaltarid_sucursalContenedor;
	}

	public void setResaltarid_sucursalContenedor(Border borderResaltar) {
		this.resaltarid_sucursalContenedor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalContenedor() {
		return this.mostrarid_sucursalContenedor;
	}

	public void setMostrarid_sucursalContenedor(Boolean mostrarid_sucursalContenedor) {
		this.mostrarid_sucursalContenedor= mostrarid_sucursalContenedor;
	}

	public Boolean getActivarid_sucursalContenedor() {
		return this.activarid_sucursalContenedor;
	}

	public void setActivarid_sucursalContenedor(Boolean activarid_sucursalContenedor) {
		this.activarid_sucursalContenedor= activarid_sucursalContenedor;
	}

	public Boolean getCargarid_sucursalContenedor() {
		return this.cargarid_sucursalContenedor;
	}

	public void setCargarid_sucursalContenedor(Boolean cargarid_sucursalContenedor) {
		this.cargarid_sucursalContenedor= cargarid_sucursalContenedor;
	}

	public Border setResaltarid_pedidoContenedor(ParametroGeneralUsuario parametroGeneralUsuario/*ContenedorBeanSwingJInternalFrame contenedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contenedorBeanSwingJInternalFrame.jTtoolBarContenedor.setBorder(borderResaltar);
		
		this.resaltarid_pedidoContenedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pedidoContenedor() {
		return this.resaltarid_pedidoContenedor;
	}

	public void setResaltarid_pedidoContenedor(Border borderResaltar) {
		this.resaltarid_pedidoContenedor= borderResaltar;
	}

	public Boolean getMostrarid_pedidoContenedor() {
		return this.mostrarid_pedidoContenedor;
	}

	public void setMostrarid_pedidoContenedor(Boolean mostrarid_pedidoContenedor) {
		this.mostrarid_pedidoContenedor= mostrarid_pedidoContenedor;
	}

	public Boolean getActivarid_pedidoContenedor() {
		return this.activarid_pedidoContenedor;
	}

	public void setActivarid_pedidoContenedor(Boolean activarid_pedidoContenedor) {
		this.activarid_pedidoContenedor= activarid_pedidoContenedor;
	}

	public Boolean getCargarid_pedidoContenedor() {
		return this.cargarid_pedidoContenedor;
	}

	public void setCargarid_pedidoContenedor(Boolean cargarid_pedidoContenedor) {
		this.cargarid_pedidoContenedor= cargarid_pedidoContenedor;
	}

	public Border setResaltarnumeroContenedor(ParametroGeneralUsuario parametroGeneralUsuario/*ContenedorBeanSwingJInternalFrame contenedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contenedorBeanSwingJInternalFrame.jTtoolBarContenedor.setBorder(borderResaltar);
		
		this.resaltarnumeroContenedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroContenedor() {
		return this.resaltarnumeroContenedor;
	}

	public void setResaltarnumeroContenedor(Border borderResaltar) {
		this.resaltarnumeroContenedor= borderResaltar;
	}

	public Boolean getMostrarnumeroContenedor() {
		return this.mostrarnumeroContenedor;
	}

	public void setMostrarnumeroContenedor(Boolean mostrarnumeroContenedor) {
		this.mostrarnumeroContenedor= mostrarnumeroContenedor;
	}

	public Boolean getActivarnumeroContenedor() {
		return this.activarnumeroContenedor;
	}

	public void setActivarnumeroContenedor(Boolean activarnumeroContenedor) {
		this.activarnumeroContenedor= activarnumeroContenedor;
	}

	public Border setResaltarnumero_blContenedor(ParametroGeneralUsuario parametroGeneralUsuario/*ContenedorBeanSwingJInternalFrame contenedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contenedorBeanSwingJInternalFrame.jTtoolBarContenedor.setBorder(borderResaltar);
		
		this.resaltarnumero_blContenedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_blContenedor() {
		return this.resaltarnumero_blContenedor;
	}

	public void setResaltarnumero_blContenedor(Border borderResaltar) {
		this.resaltarnumero_blContenedor= borderResaltar;
	}

	public Boolean getMostrarnumero_blContenedor() {
		return this.mostrarnumero_blContenedor;
	}

	public void setMostrarnumero_blContenedor(Boolean mostrarnumero_blContenedor) {
		this.mostrarnumero_blContenedor= mostrarnumero_blContenedor;
	}

	public Boolean getActivarnumero_blContenedor() {
		return this.activarnumero_blContenedor;
	}

	public void setActivarnumero_blContenedor(Boolean activarnumero_blContenedor) {
		this.activarnumero_blContenedor= activarnumero_blContenedor;
	}

	public Border setResaltardescripcionContenedor(ParametroGeneralUsuario parametroGeneralUsuario/*ContenedorBeanSwingJInternalFrame contenedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contenedorBeanSwingJInternalFrame.jTtoolBarContenedor.setBorder(borderResaltar);
		
		this.resaltardescripcionContenedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionContenedor() {
		return this.resaltardescripcionContenedor;
	}

	public void setResaltardescripcionContenedor(Border borderResaltar) {
		this.resaltardescripcionContenedor= borderResaltar;
	}

	public Boolean getMostrardescripcionContenedor() {
		return this.mostrardescripcionContenedor;
	}

	public void setMostrardescripcionContenedor(Boolean mostrardescripcionContenedor) {
		this.mostrardescripcionContenedor= mostrardescripcionContenedor;
	}

	public Boolean getActivardescripcionContenedor() {
		return this.activardescripcionContenedor;
	}

	public void setActivardescripcionContenedor(Boolean activardescripcionContenedor) {
		this.activardescripcionContenedor= activardescripcionContenedor;
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
		
		
		this.setMostraridContenedor(esInicial);
		this.setMostrarid_empresaContenedor(esInicial);
		this.setMostrarid_sucursalContenedor(esInicial);
		this.setMostrarid_pedidoContenedor(esInicial);
		this.setMostrarnumeroContenedor(esInicial);
		this.setMostrarnumero_blContenedor(esInicial);
		this.setMostrardescripcionContenedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ContenedorConstantesFunciones.ID)) {
				this.setMostraridContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.IDPEDIDO)) {
				this.setMostrarid_pedidoContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.NUMEROBL)) {
				this.setMostrarnumero_blContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionContenedor(esAsigna);
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
		
		
		this.setActivaridContenedor(esInicial);
		this.setActivarid_empresaContenedor(esInicial);
		this.setActivarid_sucursalContenedor(esInicial);
		this.setActivarid_pedidoContenedor(esInicial);
		this.setActivarnumeroContenedor(esInicial);
		this.setActivarnumero_blContenedor(esInicial);
		this.setActivardescripcionContenedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ContenedorConstantesFunciones.ID)) {
				this.setActivaridContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.IDPEDIDO)) {
				this.setActivarid_pedidoContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.NUMERO)) {
				this.setActivarnumeroContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.NUMEROBL)) {
				this.setActivarnumero_blContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionContenedor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ContenedorBeanSwingJInternalFrame contenedorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridContenedor(esInicial);
		this.setResaltarid_empresaContenedor(esInicial);
		this.setResaltarid_sucursalContenedor(esInicial);
		this.setResaltarid_pedidoContenedor(esInicial);
		this.setResaltarnumeroContenedor(esInicial);
		this.setResaltarnumero_blContenedor(esInicial);
		this.setResaltardescripcionContenedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ContenedorConstantesFunciones.ID)) {
				this.setResaltaridContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.IDPEDIDO)) {
				this.setResaltarid_pedidoContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.NUMEROBL)) {
				this.setResaltarnumero_blContenedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContenedorConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionContenedor(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ContenedorBeanSwingJInternalFrame contenedorBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaContenedor=true;

	public Boolean getMostrarFK_IdEmpresaContenedor() {
		return this.mostrarFK_IdEmpresaContenedor;
	}

	public void setMostrarFK_IdEmpresaContenedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaContenedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPedidoContenedor=true;

	public Boolean getMostrarFK_IdPedidoContenedor() {
		return this.mostrarFK_IdPedidoContenedor;
	}

	public void setMostrarFK_IdPedidoContenedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPedidoContenedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalContenedor=true;

	public Boolean getMostrarFK_IdSucursalContenedor() {
		return this.mostrarFK_IdSucursalContenedor;
	}

	public void setMostrarFK_IdSucursalContenedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalContenedor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaContenedor=true;

	public Boolean getActivarFK_IdEmpresaContenedor() {
		return this.activarFK_IdEmpresaContenedor;
	}

	public void setActivarFK_IdEmpresaContenedor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaContenedor= habilitarResaltar;
	}

	public Boolean activarFK_IdPedidoContenedor=true;

	public Boolean getActivarFK_IdPedidoContenedor() {
		return this.activarFK_IdPedidoContenedor;
	}

	public void setActivarFK_IdPedidoContenedor(Boolean habilitarResaltar) {
		this.activarFK_IdPedidoContenedor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalContenedor=true;

	public Boolean getActivarFK_IdSucursalContenedor() {
		return this.activarFK_IdSucursalContenedor;
	}

	public void setActivarFK_IdSucursalContenedor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalContenedor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaContenedor=null;

	public Border getResaltarFK_IdEmpresaContenedor() {
		return this.resaltarFK_IdEmpresaContenedor;
	}

	public void setResaltarFK_IdEmpresaContenedor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaContenedor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaContenedor(ParametroGeneralUsuario parametroGeneralUsuario/*ContenedorBeanSwingJInternalFrame contenedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaContenedor= borderResaltar;
	}

	public Border resaltarFK_IdPedidoContenedor=null;

	public Border getResaltarFK_IdPedidoContenedor() {
		return this.resaltarFK_IdPedidoContenedor;
	}

	public void setResaltarFK_IdPedidoContenedor(Border borderResaltar) {
		this.resaltarFK_IdPedidoContenedor= borderResaltar;
	}

	public void setResaltarFK_IdPedidoContenedor(ParametroGeneralUsuario parametroGeneralUsuario/*ContenedorBeanSwingJInternalFrame contenedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPedidoContenedor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalContenedor=null;

	public Border getResaltarFK_IdSucursalContenedor() {
		return this.resaltarFK_IdSucursalContenedor;
	}

	public void setResaltarFK_IdSucursalContenedor(Border borderResaltar) {
		this.resaltarFK_IdSucursalContenedor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalContenedor(ParametroGeneralUsuario parametroGeneralUsuario/*ContenedorBeanSwingJInternalFrame contenedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalContenedor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
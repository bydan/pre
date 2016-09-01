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


import com.bydan.erp.cartera.util.CobradorConstantesFunciones;
import com.bydan.erp.cartera.util.CobradorParameterReturnGeneral;
//import com.bydan.erp.cartera.util.CobradorParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CobradorConstantesFunciones extends CobradorConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Cobrador";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Cobrador"+CobradorConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CobradorHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CobradorHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CobradorConstantesFunciones.SCHEMA+"_"+CobradorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CobradorHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CobradorConstantesFunciones.SCHEMA+"_"+CobradorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CobradorConstantesFunciones.SCHEMA+"_"+CobradorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CobradorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CobradorConstantesFunciones.SCHEMA+"_"+CobradorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobradorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobradorHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobradorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobradorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobradorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobradorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CobradorConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CobradorConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CobradorConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CobradorConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cobradores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cobrador";
	public static final String SCLASSWEBTITULO_LOWER="Cobrador";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Cobrador";
	public static final String OBJECTNAME="cobrador";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cobrador";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cobrador from "+CobradorConstantesFunciones.SPERSISTENCENAME+" cobrador";
	public static String QUERYSELECTNATIVE="select "+CobradorConstantesFunciones.SCHEMA+"."+CobradorConstantesFunciones.TABLENAME+".id,"+CobradorConstantesFunciones.SCHEMA+"."+CobradorConstantesFunciones.TABLENAME+".version_row,"+CobradorConstantesFunciones.SCHEMA+"."+CobradorConstantesFunciones.TABLENAME+".id_tipo_identificacion,"+CobradorConstantesFunciones.SCHEMA+"."+CobradorConstantesFunciones.TABLENAME+".identificacion,"+CobradorConstantesFunciones.SCHEMA+"."+CobradorConstantesFunciones.TABLENAME+".apellido,"+CobradorConstantesFunciones.SCHEMA+"."+CobradorConstantesFunciones.TABLENAME+".nombre,"+CobradorConstantesFunciones.SCHEMA+"."+CobradorConstantesFunciones.TABLENAME+".direccion,"+CobradorConstantesFunciones.SCHEMA+"."+CobradorConstantesFunciones.TABLENAME+".telefono from "+CobradorConstantesFunciones.SCHEMA+"."+CobradorConstantesFunciones.TABLENAME;//+" as "+CobradorConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CobradorConstantesFuncionesAdditional cobradorConstantesFuncionesAdditional=null;
	
	public CobradorConstantesFuncionesAdditional getCobradorConstantesFuncionesAdditional() {
		return this.cobradorConstantesFuncionesAdditional;
	}
	
	public void setCobradorConstantesFuncionesAdditional(CobradorConstantesFuncionesAdditional cobradorConstantesFuncionesAdditional) {
		try {
			this.cobradorConstantesFuncionesAdditional=cobradorConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDTIPOIDENTIFICACION= "id_tipo_identificacion";
    public static final String IDENTIFICACION= "identificacion";
    public static final String APELLIDO= "apellido";
    public static final String NOMBRE= "nombre";
    public static final String DIRECCION= "direccion";
    public static final String TELEFONO= "telefono";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDTIPOIDENTIFICACION= "Tipo Identificacion";
		public static final String LABEL_IDTIPOIDENTIFICACION_LOWER= "Tipo Identificacion";
    	public static final String LABEL_IDENTIFICACION= "Identificacion";
		public static final String LABEL_IDENTIFICACION_LOWER= "Identificacion";
    	public static final String LABEL_APELLIDO= "Apellido";
		public static final String LABEL_APELLIDO_LOWER= "Apellido";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
	
		
		
		
	public static final String SREGEXIDENTIFICACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXIDENTIFICACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	
	public static String getCobradorLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CobradorConstantesFunciones.IDTIPOIDENTIFICACION)) {sLabelColumna=CobradorConstantesFunciones.LABEL_IDTIPOIDENTIFICACION;}
		if(sNombreColumna.equals(CobradorConstantesFunciones.IDENTIFICACION)) {sLabelColumna=CobradorConstantesFunciones.LABEL_IDENTIFICACION;}
		if(sNombreColumna.equals(CobradorConstantesFunciones.APELLIDO)) {sLabelColumna=CobradorConstantesFunciones.LABEL_APELLIDO;}
		if(sNombreColumna.equals(CobradorConstantesFunciones.NOMBRE)) {sLabelColumna=CobradorConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CobradorConstantesFunciones.DIRECCION)) {sLabelColumna=CobradorConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(CobradorConstantesFunciones.TELEFONO)) {sLabelColumna=CobradorConstantesFunciones.LABEL_TELEFONO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getCobradorDescripcion(Cobrador cobrador) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cobrador !=null/* && cobrador.getId()!=0*/) {
			sDescripcion=cobrador.getnombre();//cobradorcobrador.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCobradorDescripcionDetallado(Cobrador cobrador) {
		String sDescripcion="";
			
		sDescripcion+=CobradorConstantesFunciones.ID+"=";
		sDescripcion+=cobrador.getId().toString()+",";
		sDescripcion+=CobradorConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cobrador.getVersionRow().toString()+",";
		sDescripcion+=CobradorConstantesFunciones.IDTIPOIDENTIFICACION+"=";
		sDescripcion+=cobrador.getid_tipo_identificacion().toString()+",";
		sDescripcion+=CobradorConstantesFunciones.IDENTIFICACION+"=";
		sDescripcion+=cobrador.getidentificacion()+",";
		sDescripcion+=CobradorConstantesFunciones.APELLIDO+"=";
		sDescripcion+=cobrador.getapellido()+",";
		sDescripcion+=CobradorConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cobrador.getnombre()+",";
		sDescripcion+=CobradorConstantesFunciones.DIRECCION+"=";
		sDescripcion+=cobrador.getdireccion()+",";
		sDescripcion+=CobradorConstantesFunciones.TELEFONO+"=";
		sDescripcion+=cobrador.gettelefono()+",";
			
		return sDescripcion;
	}
	
	public static void setCobradorDescripcion(Cobrador cobrador,String sValor) throws Exception {			
		if(cobrador !=null) {
			cobrador.setnombre(sValor);;//cobradorcobrador.getnombre().trim();
		}		
	}
	
		

	public static String getTipoIdentificacionDescripcion(TipoIdentificacion tipoidentificacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoidentificacion!=null/*&&tipoidentificacion.getId()>0*/) {
			sDescripcion=TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(tipoidentificacion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdTipoIdentificacion")) {
			sNombreIndice="Tipo=  Por Tipo Identificacion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdTipoIdentificacion(Long id_tipo_identificacion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_identificacion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Identificacion="+id_tipo_identificacion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCobrador(Cobrador cobrador,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrador.setidentificacion(cobrador.getidentificacion().trim());
		cobrador.setapellido(cobrador.getapellido().trim());
		cobrador.setnombre(cobrador.getnombre().trim());
		cobrador.setdireccion(cobrador.getdireccion().trim());
		cobrador.settelefono(cobrador.gettelefono().trim());
	}
	
	public static void quitarEspaciosCobradors(List<Cobrador> cobradors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Cobrador cobrador: cobradors) {
			cobrador.setidentificacion(cobrador.getidentificacion().trim());
			cobrador.setapellido(cobrador.getapellido().trim());
			cobrador.setnombre(cobrador.getnombre().trim());
			cobrador.setdireccion(cobrador.getdireccion().trim());
			cobrador.settelefono(cobrador.gettelefono().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrador(Cobrador cobrador,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cobrador.getConCambioAuxiliar()) {
			cobrador.setIsDeleted(cobrador.getIsDeletedAuxiliar());	
			cobrador.setIsNew(cobrador.getIsNewAuxiliar());	
			cobrador.setIsChanged(cobrador.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cobrador.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cobrador.setIsDeletedAuxiliar(false);	
			cobrador.setIsNewAuxiliar(false);	
			cobrador.setIsChangedAuxiliar(false);
			
			cobrador.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobradors(List<Cobrador> cobradors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Cobrador cobrador : cobradors) {
			if(conAsignarBase && cobrador.getConCambioAuxiliar()) {
				cobrador.setIsDeleted(cobrador.getIsDeletedAuxiliar());	
				cobrador.setIsNew(cobrador.getIsNewAuxiliar());	
				cobrador.setIsChanged(cobrador.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cobrador.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cobrador.setIsDeletedAuxiliar(false);	
				cobrador.setIsNewAuxiliar(false);	
				cobrador.setIsChangedAuxiliar(false);
				
				cobrador.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCobrador(Cobrador cobrador,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCobradors(List<Cobrador> cobradors,Boolean conEnteros) throws Exception  {
		
		for(Cobrador cobrador: cobradors) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCobrador(List<Cobrador> cobradors,Cobrador cobradorAux) throws Exception  {
		CobradorConstantesFunciones.InicializarValoresCobrador(cobradorAux,true);
		
		for(Cobrador cobrador: cobradors) {
			if(cobrador.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrador(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CobradorConstantesFunciones.getArrayColumnasGlobalesCobrador(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrador(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCobrador(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Cobrador> cobradors,Cobrador cobrador,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Cobrador cobradorAux: cobradors) {
			if(cobradorAux!=null && cobrador!=null) {
				if((cobradorAux.getId()==null && cobrador.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cobradorAux.getId()!=null && cobrador.getId()!=null){
					if(cobradorAux.getId().equals(cobrador.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrador(List<Cobrador> cobradors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Cobrador cobrador: cobradors) {			
			if(cobrador.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCobrador() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CobradorConstantesFunciones.LABEL_ID, CobradorConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobradorConstantesFunciones.LABEL_VERSIONROW, CobradorConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobradorConstantesFunciones.LABEL_IDTIPOIDENTIFICACION, CobradorConstantesFunciones.IDTIPOIDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobradorConstantesFunciones.LABEL_IDENTIFICACION, CobradorConstantesFunciones.IDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobradorConstantesFunciones.LABEL_APELLIDO, CobradorConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobradorConstantesFunciones.LABEL_NOMBRE, CobradorConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobradorConstantesFunciones.LABEL_DIRECCION, CobradorConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobradorConstantesFunciones.LABEL_TELEFONO, CobradorConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCobrador() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CobradorConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobradorConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobradorConstantesFunciones.IDTIPOIDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobradorConstantesFunciones.IDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobradorConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobradorConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobradorConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobradorConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrador() throws Exception  {
		return CobradorConstantesFunciones.getTiposSeleccionarCobrador(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrador(Boolean conFk) throws Exception  {
		return CobradorConstantesFunciones.getTiposSeleccionarCobrador(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrador(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobradorConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);
			reporte.setsDescripcion(CobradorConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobradorConstantesFunciones.LABEL_IDENTIFICACION);
			reporte.setsDescripcion(CobradorConstantesFunciones.LABEL_IDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobradorConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(CobradorConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobradorConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CobradorConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobradorConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(CobradorConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobradorConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(CobradorConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCobrador(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCobrador(Cobrador cobradorAux) throws Exception {
		
			cobradorAux.settipoidentificacion_descripcion(TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(cobradorAux.getTipoIdentificacion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCobrador(List<Cobrador> cobradorsTemp) throws Exception {
		for(Cobrador cobradorAux:cobradorsTemp) {
			
			cobradorAux.settipoidentificacion_descripcion(TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(cobradorAux.getTipoIdentificacion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCobrador(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TipoIdentificacion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoIdentificacion.class)) {
						classes.add(new Classe(TipoIdentificacion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCobrador(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoIdentificacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIdentificacion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoIdentificacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIdentificacion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrador(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobradorConstantesFunciones.getClassesRelationshipsOfCobrador(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrador(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrador(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobradorConstantesFunciones.getClassesRelationshipsFromStringsOfCobrador(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrador(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Cobrador cobrador,List<Cobrador> cobradors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Cobrador cobradorEncontrado=null;
			
			for(Cobrador cobradorLocal:cobradors) {
				if(cobradorLocal.getId().equals(cobrador.getId())) {
					cobradorEncontrado=cobradorLocal;
					
					cobradorLocal.setIsChanged(cobrador.getIsChanged());
					cobradorLocal.setIsNew(cobrador.getIsNew());
					cobradorLocal.setIsDeleted(cobrador.getIsDeleted());
					
					cobradorLocal.setGeneralEntityOriginal(cobrador.getGeneralEntityOriginal());
					
					cobradorLocal.setId(cobrador.getId());	
					cobradorLocal.setVersionRow(cobrador.getVersionRow());	
					cobradorLocal.setid_tipo_identificacion(cobrador.getid_tipo_identificacion());	
					cobradorLocal.setidentificacion(cobrador.getidentificacion());	
					cobradorLocal.setapellido(cobrador.getapellido());	
					cobradorLocal.setnombre(cobrador.getnombre());	
					cobradorLocal.setdireccion(cobrador.getdireccion());	
					cobradorLocal.settelefono(cobrador.gettelefono());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cobrador.getIsDeleted()) {
				if(!existe) {
					cobradors.add(cobrador);
				}
			} else {
				if(cobradorEncontrado!=null && permiteQuitar)  {
					cobradors.remove(cobradorEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Cobrador cobrador,List<Cobrador> cobradors) throws Exception {
		try	{			
			for(Cobrador cobradorLocal:cobradors) {
				if(cobradorLocal.getId().equals(cobrador.getId())) {
					cobradorLocal.setIsSelected(cobrador.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCobrador(List<Cobrador> cobradorsAux) throws Exception {
		//this.cobradorsAux=cobradorsAux;
		
		for(Cobrador cobradorAux:cobradorsAux) {
			if(cobradorAux.getIsChanged()) {
				cobradorAux.setIsChanged(false);
			}		
			
			if(cobradorAux.getIsNew()) {
				cobradorAux.setIsNew(false);
			}	
			
			if(cobradorAux.getIsDeleted()) {
				cobradorAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCobrador(Cobrador cobradorAux) throws Exception {
		//this.cobradorAux=cobradorAux;
		
			if(cobradorAux.getIsChanged()) {
				cobradorAux.setIsChanged(false);
			}		
			
			if(cobradorAux.getIsNew()) {
				cobradorAux.setIsNew(false);
			}	
			
			if(cobradorAux.getIsDeleted()) {
				cobradorAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Cobrador cobradorAsignar,Cobrador cobrador) throws Exception {
		cobradorAsignar.setId(cobrador.getId());	
		cobradorAsignar.setVersionRow(cobrador.getVersionRow());	
		cobradorAsignar.setid_tipo_identificacion(cobrador.getid_tipo_identificacion());
		cobradorAsignar.settipoidentificacion_descripcion(cobrador.gettipoidentificacion_descripcion());	
		cobradorAsignar.setidentificacion(cobrador.getidentificacion());	
		cobradorAsignar.setapellido(cobrador.getapellido());	
		cobradorAsignar.setnombre(cobrador.getnombre());	
		cobradorAsignar.setdireccion(cobrador.getdireccion());	
		cobradorAsignar.settelefono(cobrador.gettelefono());	
	}
	
	public static void inicializarCobrador(Cobrador cobrador) throws Exception {
		try {
				cobrador.setId(0L);	
					
				cobrador.setid_tipo_identificacion(-1L);	
				cobrador.setidentificacion("");	
				cobrador.setapellido("");	
				cobrador.setnombre("");	
				cobrador.setdireccion("");	
				cobrador.settelefono("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCobrador(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CobradorConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobradorConstantesFunciones.LABEL_IDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobradorConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobradorConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobradorConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobradorConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCobrador(String sTipo,Row row,Workbook workbook,Cobrador cobrador,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrador.gettipoidentificacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrador.getidentificacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrador.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrador.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrador.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrador.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCobrador=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCobrador() {
		return this.sFinalQueryCobrador;
	}
	
	public void setsFinalQueryCobrador(String sFinalQueryCobrador) {
		this.sFinalQueryCobrador= sFinalQueryCobrador;
	}
	
	public Border resaltarSeleccionarCobrador=null;
	
	public Border setResaltarSeleccionarCobrador(ParametroGeneralUsuario parametroGeneralUsuario/*CobradorBeanSwingJInternalFrame cobradorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cobradorBeanSwingJInternalFrame.jTtoolBarCobrador.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCobrador= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCobrador() {
		return this.resaltarSeleccionarCobrador;
	}
	
	public void setResaltarSeleccionarCobrador(Border borderResaltarSeleccionarCobrador) {
		this.resaltarSeleccionarCobrador= borderResaltarSeleccionarCobrador;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCobrador=null;
	public Boolean mostraridCobrador=true;
	public Boolean activaridCobrador=true;

	public Border resaltarid_tipo_identificacionCobrador=null;
	public Boolean mostrarid_tipo_identificacionCobrador=true;
	public Boolean activarid_tipo_identificacionCobrador=true;
	public Boolean cargarid_tipo_identificacionCobrador=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_identificacionCobrador=false;//ConEventDepend=true

	public Border resaltaridentificacionCobrador=null;
	public Boolean mostraridentificacionCobrador=true;
	public Boolean activaridentificacionCobrador=true;

	public Border resaltarapellidoCobrador=null;
	public Boolean mostrarapellidoCobrador=true;
	public Boolean activarapellidoCobrador=true;

	public Border resaltarnombreCobrador=null;
	public Boolean mostrarnombreCobrador=true;
	public Boolean activarnombreCobrador=true;

	public Border resaltardireccionCobrador=null;
	public Boolean mostrardireccionCobrador=true;
	public Boolean activardireccionCobrador=true;

	public Border resaltartelefonoCobrador=null;
	public Boolean mostrartelefonoCobrador=true;
	public Boolean activartelefonoCobrador=true;

	
	

	public Border setResaltaridCobrador(ParametroGeneralUsuario parametroGeneralUsuario/*CobradorBeanSwingJInternalFrame cobradorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobradorBeanSwingJInternalFrame.jTtoolBarCobrador.setBorder(borderResaltar);
		
		this.resaltaridCobrador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCobrador() {
		return this.resaltaridCobrador;
	}

	public void setResaltaridCobrador(Border borderResaltar) {
		this.resaltaridCobrador= borderResaltar;
	}

	public Boolean getMostraridCobrador() {
		return this.mostraridCobrador;
	}

	public void setMostraridCobrador(Boolean mostraridCobrador) {
		this.mostraridCobrador= mostraridCobrador;
	}

	public Boolean getActivaridCobrador() {
		return this.activaridCobrador;
	}

	public void setActivaridCobrador(Boolean activaridCobrador) {
		this.activaridCobrador= activaridCobrador;
	}

	public Border setResaltarid_tipo_identificacionCobrador(ParametroGeneralUsuario parametroGeneralUsuario/*CobradorBeanSwingJInternalFrame cobradorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobradorBeanSwingJInternalFrame.jTtoolBarCobrador.setBorder(borderResaltar);
		
		this.resaltarid_tipo_identificacionCobrador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_identificacionCobrador() {
		return this.resaltarid_tipo_identificacionCobrador;
	}

	public void setResaltarid_tipo_identificacionCobrador(Border borderResaltar) {
		this.resaltarid_tipo_identificacionCobrador= borderResaltar;
	}

	public Boolean getMostrarid_tipo_identificacionCobrador() {
		return this.mostrarid_tipo_identificacionCobrador;
	}

	public void setMostrarid_tipo_identificacionCobrador(Boolean mostrarid_tipo_identificacionCobrador) {
		this.mostrarid_tipo_identificacionCobrador= mostrarid_tipo_identificacionCobrador;
	}

	public Boolean getActivarid_tipo_identificacionCobrador() {
		return this.activarid_tipo_identificacionCobrador;
	}

	public void setActivarid_tipo_identificacionCobrador(Boolean activarid_tipo_identificacionCobrador) {
		this.activarid_tipo_identificacionCobrador= activarid_tipo_identificacionCobrador;
	}

	public Boolean getCargarid_tipo_identificacionCobrador() {
		return this.cargarid_tipo_identificacionCobrador;
	}

	public void setCargarid_tipo_identificacionCobrador(Boolean cargarid_tipo_identificacionCobrador) {
		this.cargarid_tipo_identificacionCobrador= cargarid_tipo_identificacionCobrador;
	}

	public Border setResaltaridentificacionCobrador(ParametroGeneralUsuario parametroGeneralUsuario/*CobradorBeanSwingJInternalFrame cobradorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobradorBeanSwingJInternalFrame.jTtoolBarCobrador.setBorder(borderResaltar);
		
		this.resaltaridentificacionCobrador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridentificacionCobrador() {
		return this.resaltaridentificacionCobrador;
	}

	public void setResaltaridentificacionCobrador(Border borderResaltar) {
		this.resaltaridentificacionCobrador= borderResaltar;
	}

	public Boolean getMostraridentificacionCobrador() {
		return this.mostraridentificacionCobrador;
	}

	public void setMostraridentificacionCobrador(Boolean mostraridentificacionCobrador) {
		this.mostraridentificacionCobrador= mostraridentificacionCobrador;
	}

	public Boolean getActivaridentificacionCobrador() {
		return this.activaridentificacionCobrador;
	}

	public void setActivaridentificacionCobrador(Boolean activaridentificacionCobrador) {
		this.activaridentificacionCobrador= activaridentificacionCobrador;
	}

	public Border setResaltarapellidoCobrador(ParametroGeneralUsuario parametroGeneralUsuario/*CobradorBeanSwingJInternalFrame cobradorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobradorBeanSwingJInternalFrame.jTtoolBarCobrador.setBorder(borderResaltar);
		
		this.resaltarapellidoCobrador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoCobrador() {
		return this.resaltarapellidoCobrador;
	}

	public void setResaltarapellidoCobrador(Border borderResaltar) {
		this.resaltarapellidoCobrador= borderResaltar;
	}

	public Boolean getMostrarapellidoCobrador() {
		return this.mostrarapellidoCobrador;
	}

	public void setMostrarapellidoCobrador(Boolean mostrarapellidoCobrador) {
		this.mostrarapellidoCobrador= mostrarapellidoCobrador;
	}

	public Boolean getActivarapellidoCobrador() {
		return this.activarapellidoCobrador;
	}

	public void setActivarapellidoCobrador(Boolean activarapellidoCobrador) {
		this.activarapellidoCobrador= activarapellidoCobrador;
	}

	public Border setResaltarnombreCobrador(ParametroGeneralUsuario parametroGeneralUsuario/*CobradorBeanSwingJInternalFrame cobradorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobradorBeanSwingJInternalFrame.jTtoolBarCobrador.setBorder(borderResaltar);
		
		this.resaltarnombreCobrador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCobrador() {
		return this.resaltarnombreCobrador;
	}

	public void setResaltarnombreCobrador(Border borderResaltar) {
		this.resaltarnombreCobrador= borderResaltar;
	}

	public Boolean getMostrarnombreCobrador() {
		return this.mostrarnombreCobrador;
	}

	public void setMostrarnombreCobrador(Boolean mostrarnombreCobrador) {
		this.mostrarnombreCobrador= mostrarnombreCobrador;
	}

	public Boolean getActivarnombreCobrador() {
		return this.activarnombreCobrador;
	}

	public void setActivarnombreCobrador(Boolean activarnombreCobrador) {
		this.activarnombreCobrador= activarnombreCobrador;
	}

	public Border setResaltardireccionCobrador(ParametroGeneralUsuario parametroGeneralUsuario/*CobradorBeanSwingJInternalFrame cobradorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobradorBeanSwingJInternalFrame.jTtoolBarCobrador.setBorder(borderResaltar);
		
		this.resaltardireccionCobrador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionCobrador() {
		return this.resaltardireccionCobrador;
	}

	public void setResaltardireccionCobrador(Border borderResaltar) {
		this.resaltardireccionCobrador= borderResaltar;
	}

	public Boolean getMostrardireccionCobrador() {
		return this.mostrardireccionCobrador;
	}

	public void setMostrardireccionCobrador(Boolean mostrardireccionCobrador) {
		this.mostrardireccionCobrador= mostrardireccionCobrador;
	}

	public Boolean getActivardireccionCobrador() {
		return this.activardireccionCobrador;
	}

	public void setActivardireccionCobrador(Boolean activardireccionCobrador) {
		this.activardireccionCobrador= activardireccionCobrador;
	}

	public Border setResaltartelefonoCobrador(ParametroGeneralUsuario parametroGeneralUsuario/*CobradorBeanSwingJInternalFrame cobradorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobradorBeanSwingJInternalFrame.jTtoolBarCobrador.setBorder(borderResaltar);
		
		this.resaltartelefonoCobrador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoCobrador() {
		return this.resaltartelefonoCobrador;
	}

	public void setResaltartelefonoCobrador(Border borderResaltar) {
		this.resaltartelefonoCobrador= borderResaltar;
	}

	public Boolean getMostrartelefonoCobrador() {
		return this.mostrartelefonoCobrador;
	}

	public void setMostrartelefonoCobrador(Boolean mostrartelefonoCobrador) {
		this.mostrartelefonoCobrador= mostrartelefonoCobrador;
	}

	public Boolean getActivartelefonoCobrador() {
		return this.activartelefonoCobrador;
	}

	public void setActivartelefonoCobrador(Boolean activartelefonoCobrador) {
		this.activartelefonoCobrador= activartelefonoCobrador;
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
		
		
		this.setMostraridCobrador(esInicial);
		this.setMostrarid_tipo_identificacionCobrador(esInicial);
		this.setMostraridentificacionCobrador(esInicial);
		this.setMostrarapellidoCobrador(esInicial);
		this.setMostrarnombreCobrador(esInicial);
		this.setMostrardireccionCobrador(esInicial);
		this.setMostrartelefonoCobrador(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobradorConstantesFunciones.ID)) {
				this.setMostraridCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setMostrarid_tipo_identificacionCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.IDENTIFICACION)) {
				this.setMostraridentificacionCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoCobrador(esAsigna);
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
		
		
		this.setActivaridCobrador(esInicial);
		this.setActivarid_tipo_identificacionCobrador(esInicial);
		this.setActivaridentificacionCobrador(esInicial);
		this.setActivarapellidoCobrador(esInicial);
		this.setActivarnombreCobrador(esInicial);
		this.setActivardireccionCobrador(esInicial);
		this.setActivartelefonoCobrador(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobradorConstantesFunciones.ID)) {
				this.setActivaridCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setActivarid_tipo_identificacionCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.IDENTIFICACION)) {
				this.setActivaridentificacionCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.DIRECCION)) {
				this.setActivardireccionCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoCobrador(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CobradorBeanSwingJInternalFrame cobradorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCobrador(esInicial);
		this.setResaltarid_tipo_identificacionCobrador(esInicial);
		this.setResaltaridentificacionCobrador(esInicial);
		this.setResaltarapellidoCobrador(esInicial);
		this.setResaltarnombreCobrador(esInicial);
		this.setResaltardireccionCobrador(esInicial);
		this.setResaltartelefonoCobrador(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobradorConstantesFunciones.ID)) {
				this.setResaltaridCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setResaltarid_tipo_identificacionCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.IDENTIFICACION)) {
				this.setResaltaridentificacionCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionCobrador(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobradorConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoCobrador(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CobradorBeanSwingJInternalFrame cobradorBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdTipoIdentificacionCobrador=true;

	public Boolean getMostrarFK_IdTipoIdentificacionCobrador() {
		return this.mostrarFK_IdTipoIdentificacionCobrador;
	}

	public void setMostrarFK_IdTipoIdentificacionCobrador(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoIdentificacionCobrador= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdTipoIdentificacionCobrador=true;

	public Boolean getActivarFK_IdTipoIdentificacionCobrador() {
		return this.activarFK_IdTipoIdentificacionCobrador;
	}

	public void setActivarFK_IdTipoIdentificacionCobrador(Boolean habilitarResaltar) {
		this.activarFK_IdTipoIdentificacionCobrador= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdTipoIdentificacionCobrador=null;

	public Border getResaltarFK_IdTipoIdentificacionCobrador() {
		return this.resaltarFK_IdTipoIdentificacionCobrador;
	}

	public void setResaltarFK_IdTipoIdentificacionCobrador(Border borderResaltar) {
		this.resaltarFK_IdTipoIdentificacionCobrador= borderResaltar;
	}

	public void setResaltarFK_IdTipoIdentificacionCobrador(ParametroGeneralUsuario parametroGeneralUsuario/*CobradorBeanSwingJInternalFrame cobradorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoIdentificacionCobrador= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
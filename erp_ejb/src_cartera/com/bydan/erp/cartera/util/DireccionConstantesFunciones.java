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


import com.bydan.erp.cartera.util.DireccionConstantesFunciones;
import com.bydan.erp.cartera.util.DireccionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.DireccionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DireccionConstantesFunciones extends DireccionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Direccion";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Direccion"+DireccionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DireccionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DireccionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DireccionConstantesFunciones.SCHEMA+"_"+DireccionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DireccionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DireccionConstantesFunciones.SCHEMA+"_"+DireccionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DireccionConstantesFunciones.SCHEMA+"_"+DireccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DireccionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DireccionConstantesFunciones.SCHEMA+"_"+DireccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DireccionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DireccionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DireccionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DireccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DireccionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DireccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DireccionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DireccionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DireccionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DireccionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Direcciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Direccion";
	public static final String SCLASSWEBTITULO_LOWER="Direccion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Direccion";
	public static final String OBJECTNAME="direccion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="direccion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select direccion from "+DireccionConstantesFunciones.SPERSISTENCENAME+" direccion";
	public static String QUERYSELECTNATIVE="select "+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".id,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".version_row,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".id_empresa,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".id_cliente,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".id_tipo_direccion,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".id_tipo_vivienda,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".sector,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".barrio,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".calles,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".asegurada,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".direccion,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".esactivo from "+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME;//+" as "+DireccionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DireccionConstantesFuncionesAdditional direccionConstantesFuncionesAdditional=null;
	
	public DireccionConstantesFuncionesAdditional getDireccionConstantesFuncionesAdditional() {
		return this.direccionConstantesFuncionesAdditional;
	}
	
	public void setDireccionConstantesFuncionesAdditional(DireccionConstantesFuncionesAdditional direccionConstantesFuncionesAdditional) {
		try {
			this.direccionConstantesFuncionesAdditional=direccionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDTIPODIRECCION= "id_tipo_direccion";
    public static final String IDTIPOVIVIENDA= "id_tipo_vivienda";
    public static final String SECTOR= "sector";
    public static final String BARRIO= "barrio";
    public static final String CALLES= "calles";
    public static final String ASEGURADA= "asegurada";
    public static final String DIRECCION= "direccion";
    public static final String ESACTIVO= "esactivo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPODIRECCION= "Tipo Direccion";
		public static final String LABEL_IDTIPODIRECCION_LOWER= "Tipo Direccion";
    	public static final String LABEL_IDTIPOVIVIENDA= "Tipo Vivienda";
		public static final String LABEL_IDTIPOVIVIENDA_LOWER= "Tipo Vivienda";
    	public static final String LABEL_SECTOR= "Sector";
		public static final String LABEL_SECTOR_LOWER= "Sector";
    	public static final String LABEL_BARRIO= "Barrio";
		public static final String LABEL_BARRIO_LOWER= "Barrio";
    	public static final String LABEL_CALLES= "Calles";
		public static final String LABEL_CALLES_LOWER= "Calles";
    	public static final String LABEL_ASEGURADA= "Asegurada";
		public static final String LABEL_ASEGURADA_LOWER= "Asegurada";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_ESACTIVO= "Es Activo";
		public static final String LABEL_ESACTIVO_LOWER= "Es Activo";
	
		
		
		
		
		
		
	public static final String SREGEXSECTOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECTOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXBARRIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBARRIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCALLES=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCALLES=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXASEGURADA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXASEGURADA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getDireccionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DireccionConstantesFunciones.IDEMPRESA)) {sLabelColumna=DireccionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DireccionConstantesFunciones.IDCLIENTE)) {sLabelColumna=DireccionConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(DireccionConstantesFunciones.IDTIPODIRECCION)) {sLabelColumna=DireccionConstantesFunciones.LABEL_IDTIPODIRECCION;}
		if(sNombreColumna.equals(DireccionConstantesFunciones.IDTIPOVIVIENDA)) {sLabelColumna=DireccionConstantesFunciones.LABEL_IDTIPOVIVIENDA;}
		if(sNombreColumna.equals(DireccionConstantesFunciones.SECTOR)) {sLabelColumna=DireccionConstantesFunciones.LABEL_SECTOR;}
		if(sNombreColumna.equals(DireccionConstantesFunciones.BARRIO)) {sLabelColumna=DireccionConstantesFunciones.LABEL_BARRIO;}
		if(sNombreColumna.equals(DireccionConstantesFunciones.CALLES)) {sLabelColumna=DireccionConstantesFunciones.LABEL_CALLES;}
		if(sNombreColumna.equals(DireccionConstantesFunciones.ASEGURADA)) {sLabelColumna=DireccionConstantesFunciones.LABEL_ASEGURADA;}
		if(sNombreColumna.equals(DireccionConstantesFunciones.DIRECCION)) {sLabelColumna=DireccionConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(DireccionConstantesFunciones.ESACTIVO)) {sLabelColumna=DireccionConstantesFunciones.LABEL_ESACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesactivoDescripcion(Direccion direccion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!direccion.getesactivo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesactivoHtmlDescripcion(Direccion direccion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(direccion.getId(),direccion.getesactivo());

		return sDescripcion;
	}	
	
	public static String getDireccionDescripcion(Direccion direccion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(direccion !=null/* && direccion.getId()!=0*/) {
			sDescripcion=direccion.getId().toString()+"-"+direccion.getdireccion();//direcciondireccion.getId().toString().trim()+"-"+direccion.getdireccion().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDireccionDescripcionDetallado(Direccion direccion) {
		String sDescripcion="";
			
		sDescripcion+=DireccionConstantesFunciones.ID+"=";
		sDescripcion+=direccion.getId().toString()+",";
		sDescripcion+=DireccionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=direccion.getVersionRow().toString()+",";
		sDescripcion+=DireccionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=direccion.getid_empresa().toString()+",";
		sDescripcion+=DireccionConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=direccion.getid_cliente().toString()+",";
		sDescripcion+=DireccionConstantesFunciones.IDTIPODIRECCION+"=";
		sDescripcion+=direccion.getid_tipo_direccion().toString()+",";
		sDescripcion+=DireccionConstantesFunciones.IDTIPOVIVIENDA+"=";
		sDescripcion+=direccion.getid_tipo_vivienda().toString()+",";
		sDescripcion+=DireccionConstantesFunciones.SECTOR+"=";
		sDescripcion+=direccion.getsector()+",";
		sDescripcion+=DireccionConstantesFunciones.BARRIO+"=";
		sDescripcion+=direccion.getbarrio()+",";
		sDescripcion+=DireccionConstantesFunciones.CALLES+"=";
		sDescripcion+=direccion.getcalles()+",";
		sDescripcion+=DireccionConstantesFunciones.ASEGURADA+"=";
		sDescripcion+=direccion.getasegurada()+",";
		sDescripcion+=DireccionConstantesFunciones.DIRECCION+"=";
		sDescripcion+=direccion.getdireccion()+",";
		sDescripcion+=DireccionConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=direccion.getesactivo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDireccionDescripcion(Direccion direccion,String sValor) throws Exception {			
		if(direccion !=null) {
			
direccion.setdireccion(sValor);;//direcciondireccion.getId().toString().trim()+"-"+direccion.getdireccion().trim();
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

	public static String getTipoDireccionDescripcion(TipoDireccion tipodireccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodireccion!=null/*&&tipodireccion.getId()>0*/) {
			sDescripcion=TipoDireccionConstantesFunciones.getTipoDireccionDescripcion(tipodireccion);
		}

		return sDescripcion;
	}

	public static String getTipoViviendaDescripcion(TipoVivienda tipovivienda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipovivienda!=null/*&&tipovivienda.getId()>0*/) {
			sDescripcion=TipoViviendaConstantesFunciones.getTipoViviendaDescripcion(tipovivienda);
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
		} else if(sNombreIndice.equals("FK_IdValorClienteVivienda")) {
			sNombreIndice="Tipo=  Por Tipo Vivienda";
		} else if(sNombreIndice.equals("FK_IdValorDireccion")) {
			sNombreIndice="Tipo=  Por Tipo Direccion";
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

	public static String getDetalleIndiceFK_IdValorClienteVivienda(Long id_tipo_vivienda) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_vivienda!=null) {sDetalleIndice+=" Codigo Unico De Tipo Vivienda="+id_tipo_vivienda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdValorDireccion(Long id_tipo_direccion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_direccion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Direccion="+id_tipo_direccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDireccion(Direccion direccion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		direccion.setsector(direccion.getsector().trim());
		direccion.setbarrio(direccion.getbarrio().trim());
		direccion.setcalles(direccion.getcalles().trim());
		direccion.setasegurada(direccion.getasegurada().trim());
		direccion.setdireccion(direccion.getdireccion().trim());
	}
	
	public static void quitarEspaciosDireccions(List<Direccion> direccions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Direccion direccion: direccions) {
			direccion.setsector(direccion.getsector().trim());
			direccion.setbarrio(direccion.getbarrio().trim());
			direccion.setcalles(direccion.getcalles().trim());
			direccion.setasegurada(direccion.getasegurada().trim());
			direccion.setdireccion(direccion.getdireccion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDireccion(Direccion direccion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && direccion.getConCambioAuxiliar()) {
			direccion.setIsDeleted(direccion.getIsDeletedAuxiliar());	
			direccion.setIsNew(direccion.getIsNewAuxiliar());	
			direccion.setIsChanged(direccion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			direccion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			direccion.setIsDeletedAuxiliar(false);	
			direccion.setIsNewAuxiliar(false);	
			direccion.setIsChangedAuxiliar(false);
			
			direccion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDireccions(List<Direccion> direccions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Direccion direccion : direccions) {
			if(conAsignarBase && direccion.getConCambioAuxiliar()) {
				direccion.setIsDeleted(direccion.getIsDeletedAuxiliar());	
				direccion.setIsNew(direccion.getIsNewAuxiliar());	
				direccion.setIsChanged(direccion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				direccion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				direccion.setIsDeletedAuxiliar(false);	
				direccion.setIsNewAuxiliar(false);	
				direccion.setIsChangedAuxiliar(false);
				
				direccion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDireccion(Direccion direccion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDireccions(List<Direccion> direccions,Boolean conEnteros) throws Exception  {
		
		for(Direccion direccion: direccions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDireccion(List<Direccion> direccions,Direccion direccionAux) throws Exception  {
		DireccionConstantesFunciones.InicializarValoresDireccion(direccionAux,true);
		
		for(Direccion direccion: direccions) {
			if(direccion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDireccion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DireccionConstantesFunciones.getArrayColumnasGlobalesDireccion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDireccion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DireccionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DireccionConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDireccion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Direccion> direccions,Direccion direccion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Direccion direccionAux: direccions) {
			if(direccionAux!=null && direccion!=null) {
				if((direccionAux.getId()==null && direccion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(direccionAux.getId()!=null && direccion.getId()!=null){
					if(direccionAux.getId().equals(direccion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDireccion(List<Direccion> direccions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Direccion direccion: direccions) {			
			if(direccion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDireccion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DireccionConstantesFunciones.LABEL_ID, DireccionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DireccionConstantesFunciones.LABEL_VERSIONROW, DireccionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DireccionConstantesFunciones.LABEL_IDEMPRESA, DireccionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DireccionConstantesFunciones.LABEL_IDCLIENTE, DireccionConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DireccionConstantesFunciones.LABEL_IDTIPODIRECCION, DireccionConstantesFunciones.IDTIPODIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DireccionConstantesFunciones.LABEL_IDTIPOVIVIENDA, DireccionConstantesFunciones.IDTIPOVIVIENDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DireccionConstantesFunciones.LABEL_SECTOR, DireccionConstantesFunciones.SECTOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DireccionConstantesFunciones.LABEL_BARRIO, DireccionConstantesFunciones.BARRIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DireccionConstantesFunciones.LABEL_CALLES, DireccionConstantesFunciones.CALLES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DireccionConstantesFunciones.LABEL_ASEGURADA, DireccionConstantesFunciones.ASEGURADA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DireccionConstantesFunciones.LABEL_DIRECCION, DireccionConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DireccionConstantesFunciones.LABEL_ESACTIVO, DireccionConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDireccion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DireccionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DireccionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DireccionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DireccionConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DireccionConstantesFunciones.IDTIPODIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DireccionConstantesFunciones.IDTIPOVIVIENDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DireccionConstantesFunciones.SECTOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DireccionConstantesFunciones.BARRIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DireccionConstantesFunciones.CALLES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DireccionConstantesFunciones.ASEGURADA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DireccionConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DireccionConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDireccion() throws Exception  {
		return DireccionConstantesFunciones.getTiposSeleccionarDireccion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDireccion(Boolean conFk) throws Exception  {
		return DireccionConstantesFunciones.getTiposSeleccionarDireccion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDireccion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DireccionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DireccionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DireccionConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(DireccionConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DireccionConstantesFunciones.LABEL_IDTIPODIRECCION);
			reporte.setsDescripcion(DireccionConstantesFunciones.LABEL_IDTIPODIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DireccionConstantesFunciones.LABEL_IDTIPOVIVIENDA);
			reporte.setsDescripcion(DireccionConstantesFunciones.LABEL_IDTIPOVIVIENDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DireccionConstantesFunciones.LABEL_SECTOR);
			reporte.setsDescripcion(DireccionConstantesFunciones.LABEL_SECTOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DireccionConstantesFunciones.LABEL_BARRIO);
			reporte.setsDescripcion(DireccionConstantesFunciones.LABEL_BARRIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DireccionConstantesFunciones.LABEL_CALLES);
			reporte.setsDescripcion(DireccionConstantesFunciones.LABEL_CALLES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DireccionConstantesFunciones.LABEL_ASEGURADA);
			reporte.setsDescripcion(DireccionConstantesFunciones.LABEL_ASEGURADA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DireccionConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(DireccionConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DireccionConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(DireccionConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDireccion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDireccion(Direccion direccionAux) throws Exception {
		
			direccionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(direccionAux.getEmpresa()));
			direccionAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(direccionAux.getCliente()));
			direccionAux.settipodireccion_descripcion(TipoDireccionConstantesFunciones.getTipoDireccionDescripcion(direccionAux.getTipoDireccion()));
			direccionAux.settipovivienda_descripcion(TipoViviendaConstantesFunciones.getTipoViviendaDescripcion(direccionAux.getTipoVivienda()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDireccion(List<Direccion> direccionsTemp) throws Exception {
		for(Direccion direccionAux:direccionsTemp) {
			
			direccionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(direccionAux.getEmpresa()));
			direccionAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(direccionAux.getCliente()));
			direccionAux.settipodireccion_descripcion(TipoDireccionConstantesFunciones.getTipoDireccionDescripcion(direccionAux.getTipoDireccion()));
			direccionAux.settipovivienda_descripcion(TipoViviendaConstantesFunciones.getTipoViviendaDescripcion(direccionAux.getTipoVivienda()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDireccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoDireccion.class));
				classes.add(new Classe(TipoVivienda.class));
				
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
					if(clas.clas.equals(TipoDireccion.class)) {
						classes.add(new Classe(TipoDireccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoVivienda.class)) {
						classes.add(new Classe(TipoVivienda.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDireccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoDireccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDireccion.class)); continue;
					}

					if(TipoVivienda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoVivienda.class)); continue;
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

					if(TipoDireccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDireccion.class)); continue;
					}

					if(TipoVivienda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoVivienda.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDireccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DireccionConstantesFunciones.getClassesRelationshipsOfDireccion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDireccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDireccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DireccionConstantesFunciones.getClassesRelationshipsFromStringsOfDireccion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDireccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Direccion direccion,List<Direccion> direccions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Direccion direccionEncontrado=null;
			
			for(Direccion direccionLocal:direccions) {
				if(direccionLocal.getId().equals(direccion.getId())) {
					direccionEncontrado=direccionLocal;
					
					direccionLocal.setIsChanged(direccion.getIsChanged());
					direccionLocal.setIsNew(direccion.getIsNew());
					direccionLocal.setIsDeleted(direccion.getIsDeleted());
					
					direccionLocal.setGeneralEntityOriginal(direccion.getGeneralEntityOriginal());
					
					direccionLocal.setId(direccion.getId());	
					direccionLocal.setVersionRow(direccion.getVersionRow());	
					direccionLocal.setid_empresa(direccion.getid_empresa());	
					direccionLocal.setid_cliente(direccion.getid_cliente());	
					direccionLocal.setid_tipo_direccion(direccion.getid_tipo_direccion());	
					direccionLocal.setid_tipo_vivienda(direccion.getid_tipo_vivienda());	
					direccionLocal.setsector(direccion.getsector());	
					direccionLocal.setbarrio(direccion.getbarrio());	
					direccionLocal.setcalles(direccion.getcalles());	
					direccionLocal.setasegurada(direccion.getasegurada());	
					direccionLocal.setdireccion(direccion.getdireccion());	
					direccionLocal.setesactivo(direccion.getesactivo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!direccion.getIsDeleted()) {
				if(!existe) {
					direccions.add(direccion);
				}
			} else {
				if(direccionEncontrado!=null && permiteQuitar)  {
					direccions.remove(direccionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Direccion direccion,List<Direccion> direccions) throws Exception {
		try	{			
			for(Direccion direccionLocal:direccions) {
				if(direccionLocal.getId().equals(direccion.getId())) {
					direccionLocal.setIsSelected(direccion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDireccion(List<Direccion> direccionsAux) throws Exception {
		//this.direccionsAux=direccionsAux;
		
		for(Direccion direccionAux:direccionsAux) {
			if(direccionAux.getIsChanged()) {
				direccionAux.setIsChanged(false);
			}		
			
			if(direccionAux.getIsNew()) {
				direccionAux.setIsNew(false);
			}	
			
			if(direccionAux.getIsDeleted()) {
				direccionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDireccion(Direccion direccionAux) throws Exception {
		//this.direccionAux=direccionAux;
		
			if(direccionAux.getIsChanged()) {
				direccionAux.setIsChanged(false);
			}		
			
			if(direccionAux.getIsNew()) {
				direccionAux.setIsNew(false);
			}	
			
			if(direccionAux.getIsDeleted()) {
				direccionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Direccion direccionAsignar,Direccion direccion) throws Exception {
		direccionAsignar.setId(direccion.getId());	
		direccionAsignar.setVersionRow(direccion.getVersionRow());	
		direccionAsignar.setid_empresa(direccion.getid_empresa());
		direccionAsignar.setempresa_descripcion(direccion.getempresa_descripcion());	
		direccionAsignar.setid_cliente(direccion.getid_cliente());
		direccionAsignar.setcliente_descripcion(direccion.getcliente_descripcion());	
		direccionAsignar.setid_tipo_direccion(direccion.getid_tipo_direccion());
		direccionAsignar.settipodireccion_descripcion(direccion.gettipodireccion_descripcion());	
		direccionAsignar.setid_tipo_vivienda(direccion.getid_tipo_vivienda());
		direccionAsignar.settipovivienda_descripcion(direccion.gettipovivienda_descripcion());	
		direccionAsignar.setsector(direccion.getsector());	
		direccionAsignar.setbarrio(direccion.getbarrio());	
		direccionAsignar.setcalles(direccion.getcalles());	
		direccionAsignar.setasegurada(direccion.getasegurada());	
		direccionAsignar.setdireccion(direccion.getdireccion());	
		direccionAsignar.setesactivo(direccion.getesactivo());	
	}
	
	public static void inicializarDireccion(Direccion direccion) throws Exception {
		try {
				direccion.setId(0L);	
					
				direccion.setid_empresa(-1L);	
				direccion.setid_cliente(-1L);	
				direccion.setid_tipo_direccion(-1L);	
				direccion.setid_tipo_vivienda(-1L);	
				direccion.setsector("");	
				direccion.setbarrio("");	
				direccion.setcalles("");	
				direccion.setasegurada("");	
				direccion.setdireccion("");	
				direccion.setesactivo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDireccion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DireccionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DireccionConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DireccionConstantesFunciones.LABEL_IDTIPODIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DireccionConstantesFunciones.LABEL_IDTIPOVIVIENDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DireccionConstantesFunciones.LABEL_SECTOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DireccionConstantesFunciones.LABEL_BARRIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DireccionConstantesFunciones.LABEL_CALLES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DireccionConstantesFunciones.LABEL_ASEGURADA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DireccionConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DireccionConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDireccion(String sTipo,Row row,Workbook workbook,Direccion direccion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(direccion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(direccion.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(direccion.gettipodireccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(direccion.gettipovivienda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(direccion.getsector());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(direccion.getbarrio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(direccion.getcalles());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(direccion.getasegurada());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(direccion.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(direccion.getesactivo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDireccion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDireccion() {
		return this.sFinalQueryDireccion;
	}
	
	public void setsFinalQueryDireccion(String sFinalQueryDireccion) {
		this.sFinalQueryDireccion= sFinalQueryDireccion;
	}
	
	public Border resaltarSeleccionarDireccion=null;
	
	public Border setResaltarSeleccionarDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//direccionBeanSwingJInternalFrame.jTtoolBarDireccion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDireccion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDireccion() {
		return this.resaltarSeleccionarDireccion;
	}
	
	public void setResaltarSeleccionarDireccion(Border borderResaltarSeleccionarDireccion) {
		this.resaltarSeleccionarDireccion= borderResaltarSeleccionarDireccion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDireccion=null;
	public Boolean mostraridDireccion=true;
	public Boolean activaridDireccion=true;

	public Border resaltarid_empresaDireccion=null;
	public Boolean mostrarid_empresaDireccion=true;
	public Boolean activarid_empresaDireccion=true;
	public Boolean cargarid_empresaDireccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDireccion=false;//ConEventDepend=true

	public Border resaltarid_clienteDireccion=null;
	public Boolean mostrarid_clienteDireccion=true;
	public Boolean activarid_clienteDireccion=true;
	public Boolean cargarid_clienteDireccion=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteDireccion=false;//ConEventDepend=true

	public Border resaltarid_tipo_direccionDireccion=null;
	public Boolean mostrarid_tipo_direccionDireccion=true;
	public Boolean activarid_tipo_direccionDireccion=true;
	public Boolean cargarid_tipo_direccionDireccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_direccionDireccion=false;//ConEventDepend=true

	public Border resaltarid_tipo_viviendaDireccion=null;
	public Boolean mostrarid_tipo_viviendaDireccion=true;
	public Boolean activarid_tipo_viviendaDireccion=true;
	public Boolean cargarid_tipo_viviendaDireccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_viviendaDireccion=false;//ConEventDepend=true

	public Border resaltarsectorDireccion=null;
	public Boolean mostrarsectorDireccion=true;
	public Boolean activarsectorDireccion=true;

	public Border resaltarbarrioDireccion=null;
	public Boolean mostrarbarrioDireccion=true;
	public Boolean activarbarrioDireccion=true;

	public Border resaltarcallesDireccion=null;
	public Boolean mostrarcallesDireccion=true;
	public Boolean activarcallesDireccion=true;

	public Border resaltaraseguradaDireccion=null;
	public Boolean mostraraseguradaDireccion=true;
	public Boolean activaraseguradaDireccion=true;

	public Border resaltardireccionDireccion=null;
	public Boolean mostrardireccionDireccion=true;
	public Boolean activardireccionDireccion=true;

	public Border resaltaresactivoDireccion=null;
	public Boolean mostraresactivoDireccion=true;
	public Boolean activaresactivoDireccion=true;

	
	

	public Border setResaltaridDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//direccionBeanSwingJInternalFrame.jTtoolBarDireccion.setBorder(borderResaltar);
		
		this.resaltaridDireccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDireccion() {
		return this.resaltaridDireccion;
	}

	public void setResaltaridDireccion(Border borderResaltar) {
		this.resaltaridDireccion= borderResaltar;
	}

	public Boolean getMostraridDireccion() {
		return this.mostraridDireccion;
	}

	public void setMostraridDireccion(Boolean mostraridDireccion) {
		this.mostraridDireccion= mostraridDireccion;
	}

	public Boolean getActivaridDireccion() {
		return this.activaridDireccion;
	}

	public void setActivaridDireccion(Boolean activaridDireccion) {
		this.activaridDireccion= activaridDireccion;
	}

	public Border setResaltarid_empresaDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//direccionBeanSwingJInternalFrame.jTtoolBarDireccion.setBorder(borderResaltar);
		
		this.resaltarid_empresaDireccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDireccion() {
		return this.resaltarid_empresaDireccion;
	}

	public void setResaltarid_empresaDireccion(Border borderResaltar) {
		this.resaltarid_empresaDireccion= borderResaltar;
	}

	public Boolean getMostrarid_empresaDireccion() {
		return this.mostrarid_empresaDireccion;
	}

	public void setMostrarid_empresaDireccion(Boolean mostrarid_empresaDireccion) {
		this.mostrarid_empresaDireccion= mostrarid_empresaDireccion;
	}

	public Boolean getActivarid_empresaDireccion() {
		return this.activarid_empresaDireccion;
	}

	public void setActivarid_empresaDireccion(Boolean activarid_empresaDireccion) {
		this.activarid_empresaDireccion= activarid_empresaDireccion;
	}

	public Boolean getCargarid_empresaDireccion() {
		return this.cargarid_empresaDireccion;
	}

	public void setCargarid_empresaDireccion(Boolean cargarid_empresaDireccion) {
		this.cargarid_empresaDireccion= cargarid_empresaDireccion;
	}

	public Border setResaltarid_clienteDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//direccionBeanSwingJInternalFrame.jTtoolBarDireccion.setBorder(borderResaltar);
		
		this.resaltarid_clienteDireccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteDireccion() {
		return this.resaltarid_clienteDireccion;
	}

	public void setResaltarid_clienteDireccion(Border borderResaltar) {
		this.resaltarid_clienteDireccion= borderResaltar;
	}

	public Boolean getMostrarid_clienteDireccion() {
		return this.mostrarid_clienteDireccion;
	}

	public void setMostrarid_clienteDireccion(Boolean mostrarid_clienteDireccion) {
		this.mostrarid_clienteDireccion= mostrarid_clienteDireccion;
	}

	public Boolean getActivarid_clienteDireccion() {
		return this.activarid_clienteDireccion;
	}

	public void setActivarid_clienteDireccion(Boolean activarid_clienteDireccion) {
		this.activarid_clienteDireccion= activarid_clienteDireccion;
	}

	public Boolean getCargarid_clienteDireccion() {
		return this.cargarid_clienteDireccion;
	}

	public void setCargarid_clienteDireccion(Boolean cargarid_clienteDireccion) {
		this.cargarid_clienteDireccion= cargarid_clienteDireccion;
	}

	public Border setResaltarid_tipo_direccionDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//direccionBeanSwingJInternalFrame.jTtoolBarDireccion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_direccionDireccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_direccionDireccion() {
		return this.resaltarid_tipo_direccionDireccion;
	}

	public void setResaltarid_tipo_direccionDireccion(Border borderResaltar) {
		this.resaltarid_tipo_direccionDireccion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_direccionDireccion() {
		return this.mostrarid_tipo_direccionDireccion;
	}

	public void setMostrarid_tipo_direccionDireccion(Boolean mostrarid_tipo_direccionDireccion) {
		this.mostrarid_tipo_direccionDireccion= mostrarid_tipo_direccionDireccion;
	}

	public Boolean getActivarid_tipo_direccionDireccion() {
		return this.activarid_tipo_direccionDireccion;
	}

	public void setActivarid_tipo_direccionDireccion(Boolean activarid_tipo_direccionDireccion) {
		this.activarid_tipo_direccionDireccion= activarid_tipo_direccionDireccion;
	}

	public Boolean getCargarid_tipo_direccionDireccion() {
		return this.cargarid_tipo_direccionDireccion;
	}

	public void setCargarid_tipo_direccionDireccion(Boolean cargarid_tipo_direccionDireccion) {
		this.cargarid_tipo_direccionDireccion= cargarid_tipo_direccionDireccion;
	}

	public Border setResaltarid_tipo_viviendaDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//direccionBeanSwingJInternalFrame.jTtoolBarDireccion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_viviendaDireccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_viviendaDireccion() {
		return this.resaltarid_tipo_viviendaDireccion;
	}

	public void setResaltarid_tipo_viviendaDireccion(Border borderResaltar) {
		this.resaltarid_tipo_viviendaDireccion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_viviendaDireccion() {
		return this.mostrarid_tipo_viviendaDireccion;
	}

	public void setMostrarid_tipo_viviendaDireccion(Boolean mostrarid_tipo_viviendaDireccion) {
		this.mostrarid_tipo_viviendaDireccion= mostrarid_tipo_viviendaDireccion;
	}

	public Boolean getActivarid_tipo_viviendaDireccion() {
		return this.activarid_tipo_viviendaDireccion;
	}

	public void setActivarid_tipo_viviendaDireccion(Boolean activarid_tipo_viviendaDireccion) {
		this.activarid_tipo_viviendaDireccion= activarid_tipo_viviendaDireccion;
	}

	public Boolean getCargarid_tipo_viviendaDireccion() {
		return this.cargarid_tipo_viviendaDireccion;
	}

	public void setCargarid_tipo_viviendaDireccion(Boolean cargarid_tipo_viviendaDireccion) {
		this.cargarid_tipo_viviendaDireccion= cargarid_tipo_viviendaDireccion;
	}

	public Border setResaltarsectorDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//direccionBeanSwingJInternalFrame.jTtoolBarDireccion.setBorder(borderResaltar);
		
		this.resaltarsectorDireccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsectorDireccion() {
		return this.resaltarsectorDireccion;
	}

	public void setResaltarsectorDireccion(Border borderResaltar) {
		this.resaltarsectorDireccion= borderResaltar;
	}

	public Boolean getMostrarsectorDireccion() {
		return this.mostrarsectorDireccion;
	}

	public void setMostrarsectorDireccion(Boolean mostrarsectorDireccion) {
		this.mostrarsectorDireccion= mostrarsectorDireccion;
	}

	public Boolean getActivarsectorDireccion() {
		return this.activarsectorDireccion;
	}

	public void setActivarsectorDireccion(Boolean activarsectorDireccion) {
		this.activarsectorDireccion= activarsectorDireccion;
	}

	public Border setResaltarbarrioDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//direccionBeanSwingJInternalFrame.jTtoolBarDireccion.setBorder(borderResaltar);
		
		this.resaltarbarrioDireccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbarrioDireccion() {
		return this.resaltarbarrioDireccion;
	}

	public void setResaltarbarrioDireccion(Border borderResaltar) {
		this.resaltarbarrioDireccion= borderResaltar;
	}

	public Boolean getMostrarbarrioDireccion() {
		return this.mostrarbarrioDireccion;
	}

	public void setMostrarbarrioDireccion(Boolean mostrarbarrioDireccion) {
		this.mostrarbarrioDireccion= mostrarbarrioDireccion;
	}

	public Boolean getActivarbarrioDireccion() {
		return this.activarbarrioDireccion;
	}

	public void setActivarbarrioDireccion(Boolean activarbarrioDireccion) {
		this.activarbarrioDireccion= activarbarrioDireccion;
	}

	public Border setResaltarcallesDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//direccionBeanSwingJInternalFrame.jTtoolBarDireccion.setBorder(borderResaltar);
		
		this.resaltarcallesDireccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcallesDireccion() {
		return this.resaltarcallesDireccion;
	}

	public void setResaltarcallesDireccion(Border borderResaltar) {
		this.resaltarcallesDireccion= borderResaltar;
	}

	public Boolean getMostrarcallesDireccion() {
		return this.mostrarcallesDireccion;
	}

	public void setMostrarcallesDireccion(Boolean mostrarcallesDireccion) {
		this.mostrarcallesDireccion= mostrarcallesDireccion;
	}

	public Boolean getActivarcallesDireccion() {
		return this.activarcallesDireccion;
	}

	public void setActivarcallesDireccion(Boolean activarcallesDireccion) {
		this.activarcallesDireccion= activarcallesDireccion;
	}

	public Border setResaltaraseguradaDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//direccionBeanSwingJInternalFrame.jTtoolBarDireccion.setBorder(borderResaltar);
		
		this.resaltaraseguradaDireccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaraseguradaDireccion() {
		return this.resaltaraseguradaDireccion;
	}

	public void setResaltaraseguradaDireccion(Border borderResaltar) {
		this.resaltaraseguradaDireccion= borderResaltar;
	}

	public Boolean getMostraraseguradaDireccion() {
		return this.mostraraseguradaDireccion;
	}

	public void setMostraraseguradaDireccion(Boolean mostraraseguradaDireccion) {
		this.mostraraseguradaDireccion= mostraraseguradaDireccion;
	}

	public Boolean getActivaraseguradaDireccion() {
		return this.activaraseguradaDireccion;
	}

	public void setActivaraseguradaDireccion(Boolean activaraseguradaDireccion) {
		this.activaraseguradaDireccion= activaraseguradaDireccion;
	}

	public Border setResaltardireccionDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//direccionBeanSwingJInternalFrame.jTtoolBarDireccion.setBorder(borderResaltar);
		
		this.resaltardireccionDireccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionDireccion() {
		return this.resaltardireccionDireccion;
	}

	public void setResaltardireccionDireccion(Border borderResaltar) {
		this.resaltardireccionDireccion= borderResaltar;
	}

	public Boolean getMostrardireccionDireccion() {
		return this.mostrardireccionDireccion;
	}

	public void setMostrardireccionDireccion(Boolean mostrardireccionDireccion) {
		this.mostrardireccionDireccion= mostrardireccionDireccion;
	}

	public Boolean getActivardireccionDireccion() {
		return this.activardireccionDireccion;
	}

	public void setActivardireccionDireccion(Boolean activardireccionDireccion) {
		this.activardireccionDireccion= activardireccionDireccion;
	}

	public Border setResaltaresactivoDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//direccionBeanSwingJInternalFrame.jTtoolBarDireccion.setBorder(borderResaltar);
		
		this.resaltaresactivoDireccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresactivoDireccion() {
		return this.resaltaresactivoDireccion;
	}

	public void setResaltaresactivoDireccion(Border borderResaltar) {
		this.resaltaresactivoDireccion= borderResaltar;
	}

	public Boolean getMostraresactivoDireccion() {
		return this.mostraresactivoDireccion;
	}

	public void setMostraresactivoDireccion(Boolean mostraresactivoDireccion) {
		this.mostraresactivoDireccion= mostraresactivoDireccion;
	}

	public Boolean getActivaresactivoDireccion() {
		return this.activaresactivoDireccion;
	}

	public void setActivaresactivoDireccion(Boolean activaresactivoDireccion) {
		this.activaresactivoDireccion= activaresactivoDireccion;
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
		
		
		this.setMostraridDireccion(esInicial);
		this.setMostrarid_empresaDireccion(esInicial);
		this.setMostrarid_clienteDireccion(esInicial);
		this.setMostrarid_tipo_direccionDireccion(esInicial);
		this.setMostrarid_tipo_viviendaDireccion(esInicial);
		this.setMostrarsectorDireccion(esInicial);
		this.setMostrarbarrioDireccion(esInicial);
		this.setMostrarcallesDireccion(esInicial);
		this.setMostraraseguradaDireccion(esInicial);
		this.setMostrardireccionDireccion(esInicial);
		this.setMostraresactivoDireccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DireccionConstantesFunciones.ID)) {
				this.setMostraridDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.IDTIPODIRECCION)) {
				this.setMostrarid_tipo_direccionDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.IDTIPOVIVIENDA)) {
				this.setMostrarid_tipo_viviendaDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.SECTOR)) {
				this.setMostrarsectorDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.BARRIO)) {
				this.setMostrarbarrioDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.CALLES)) {
				this.setMostrarcallesDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.ASEGURADA)) {
				this.setMostraraseguradaDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.ESACTIVO)) {
				this.setMostraresactivoDireccion(esAsigna);
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
		
		
		this.setActivaridDireccion(esInicial);
		this.setActivarid_empresaDireccion(esInicial);
		this.setActivarid_clienteDireccion(esInicial);
		this.setActivarid_tipo_direccionDireccion(esInicial);
		this.setActivarid_tipo_viviendaDireccion(esInicial);
		this.setActivarsectorDireccion(esInicial);
		this.setActivarbarrioDireccion(esInicial);
		this.setActivarcallesDireccion(esInicial);
		this.setActivaraseguradaDireccion(esInicial);
		this.setActivardireccionDireccion(esInicial);
		this.setActivaresactivoDireccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DireccionConstantesFunciones.ID)) {
				this.setActivaridDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.IDTIPODIRECCION)) {
				this.setActivarid_tipo_direccionDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.IDTIPOVIVIENDA)) {
				this.setActivarid_tipo_viviendaDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.SECTOR)) {
				this.setActivarsectorDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.BARRIO)) {
				this.setActivarbarrioDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.CALLES)) {
				this.setActivarcallesDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.ASEGURADA)) {
				this.setActivaraseguradaDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.DIRECCION)) {
				this.setActivardireccionDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.ESACTIVO)) {
				this.setActivaresactivoDireccion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDireccion(esInicial);
		this.setResaltarid_empresaDireccion(esInicial);
		this.setResaltarid_clienteDireccion(esInicial);
		this.setResaltarid_tipo_direccionDireccion(esInicial);
		this.setResaltarid_tipo_viviendaDireccion(esInicial);
		this.setResaltarsectorDireccion(esInicial);
		this.setResaltarbarrioDireccion(esInicial);
		this.setResaltarcallesDireccion(esInicial);
		this.setResaltaraseguradaDireccion(esInicial);
		this.setResaltardireccionDireccion(esInicial);
		this.setResaltaresactivoDireccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DireccionConstantesFunciones.ID)) {
				this.setResaltaridDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.IDTIPODIRECCION)) {
				this.setResaltarid_tipo_direccionDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.IDTIPOVIVIENDA)) {
				this.setResaltarid_tipo_viviendaDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.SECTOR)) {
				this.setResaltarsectorDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.BARRIO)) {
				this.setResaltarbarrioDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.CALLES)) {
				this.setResaltarcallesDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.ASEGURADA)) {
				this.setResaltaraseguradaDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DireccionConstantesFunciones.ESACTIVO)) {
				this.setResaltaresactivoDireccion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteDireccion=true;

	public Boolean getMostrarFK_IdClienteDireccion() {
		return this.mostrarFK_IdClienteDireccion;
	}

	public void setMostrarFK_IdClienteDireccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteDireccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDireccion=true;

	public Boolean getMostrarFK_IdEmpresaDireccion() {
		return this.mostrarFK_IdEmpresaDireccion;
	}

	public void setMostrarFK_IdEmpresaDireccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDireccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdValorClienteViviendaDireccion=true;

	public Boolean getMostrarFK_IdValorClienteViviendaDireccion() {
		return this.mostrarFK_IdValorClienteViviendaDireccion;
	}

	public void setMostrarFK_IdValorClienteViviendaDireccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdValorClienteViviendaDireccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdValorDireccionDireccion=true;

	public Boolean getMostrarFK_IdValorDireccionDireccion() {
		return this.mostrarFK_IdValorDireccionDireccion;
	}

	public void setMostrarFK_IdValorDireccionDireccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdValorDireccionDireccion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteDireccion=true;

	public Boolean getActivarFK_IdClienteDireccion() {
		return this.activarFK_IdClienteDireccion;
	}

	public void setActivarFK_IdClienteDireccion(Boolean habilitarResaltar) {
		this.activarFK_IdClienteDireccion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDireccion=true;

	public Boolean getActivarFK_IdEmpresaDireccion() {
		return this.activarFK_IdEmpresaDireccion;
	}

	public void setActivarFK_IdEmpresaDireccion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDireccion= habilitarResaltar;
	}

	public Boolean activarFK_IdValorClienteViviendaDireccion=true;

	public Boolean getActivarFK_IdValorClienteViviendaDireccion() {
		return this.activarFK_IdValorClienteViviendaDireccion;
	}

	public void setActivarFK_IdValorClienteViviendaDireccion(Boolean habilitarResaltar) {
		this.activarFK_IdValorClienteViviendaDireccion= habilitarResaltar;
	}

	public Boolean activarFK_IdValorDireccionDireccion=true;

	public Boolean getActivarFK_IdValorDireccionDireccion() {
		return this.activarFK_IdValorDireccionDireccion;
	}

	public void setActivarFK_IdValorDireccionDireccion(Boolean habilitarResaltar) {
		this.activarFK_IdValorDireccionDireccion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteDireccion=null;

	public Border getResaltarFK_IdClienteDireccion() {
		return this.resaltarFK_IdClienteDireccion;
	}

	public void setResaltarFK_IdClienteDireccion(Border borderResaltar) {
		this.resaltarFK_IdClienteDireccion= borderResaltar;
	}

	public void setResaltarFK_IdClienteDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteDireccion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDireccion=null;

	public Border getResaltarFK_IdEmpresaDireccion() {
		return this.resaltarFK_IdEmpresaDireccion;
	}

	public void setResaltarFK_IdEmpresaDireccion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDireccion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDireccion= borderResaltar;
	}

	public Border resaltarFK_IdValorClienteViviendaDireccion=null;

	public Border getResaltarFK_IdValorClienteViviendaDireccion() {
		return this.resaltarFK_IdValorClienteViviendaDireccion;
	}

	public void setResaltarFK_IdValorClienteViviendaDireccion(Border borderResaltar) {
		this.resaltarFK_IdValorClienteViviendaDireccion= borderResaltar;
	}

	public void setResaltarFK_IdValorClienteViviendaDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdValorClienteViviendaDireccion= borderResaltar;
	}

	public Border resaltarFK_IdValorDireccionDireccion=null;

	public Border getResaltarFK_IdValorDireccionDireccion() {
		return this.resaltarFK_IdValorDireccionDireccion;
	}

	public void setResaltarFK_IdValorDireccionDireccion(Border borderResaltar) {
		this.resaltarFK_IdValorDireccionDireccion= borderResaltar;
	}

	public void setResaltarFK_IdValorDireccionDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*DireccionBeanSwingJInternalFrame direccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdValorDireccionDireccion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
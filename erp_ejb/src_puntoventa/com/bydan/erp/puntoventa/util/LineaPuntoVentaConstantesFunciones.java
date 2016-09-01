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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.LineaPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.LineaPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.LineaPuntoVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class LineaPuntoVentaConstantesFunciones extends LineaPuntoVentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="LineaPuntoVenta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="LineaPuntoVenta"+LineaPuntoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="LineaPuntoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="LineaPuntoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=LineaPuntoVentaConstantesFunciones.SCHEMA+"_"+LineaPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/LineaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=LineaPuntoVentaConstantesFunciones.SCHEMA+"_"+LineaPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=LineaPuntoVentaConstantesFunciones.SCHEMA+"_"+LineaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/LineaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=LineaPuntoVentaConstantesFunciones.SCHEMA+"_"+LineaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LineaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/LineaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LineaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LineaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/LineaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LineaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=LineaPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+LineaPuntoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=LineaPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+LineaPuntoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Linea Punto Ventas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Linea Punto Venta";
	public static final String SCLASSWEBTITULO_LOWER="Linea Punto Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="LineaPuntoVenta";
	public static final String OBJECTNAME="lineapuntoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="linea_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select lineapuntoventa from "+LineaPuntoVentaConstantesFunciones.SPERSISTENCENAME+" lineapuntoventa";
	public static String QUERYSELECTNATIVE="select "+LineaPuntoVentaConstantesFunciones.SCHEMA+"."+LineaPuntoVentaConstantesFunciones.TABLENAME+".id,"+LineaPuntoVentaConstantesFunciones.SCHEMA+"."+LineaPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+LineaPuntoVentaConstantesFunciones.SCHEMA+"."+LineaPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+LineaPuntoVentaConstantesFunciones.SCHEMA+"."+LineaPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal,"+LineaPuntoVentaConstantesFunciones.SCHEMA+"."+LineaPuntoVentaConstantesFunciones.TABLENAME+".id_linea,"+LineaPuntoVentaConstantesFunciones.SCHEMA+"."+LineaPuntoVentaConstantesFunciones.TABLENAME+".id_linea_grupo,"+LineaPuntoVentaConstantesFunciones.SCHEMA+"."+LineaPuntoVentaConstantesFunciones.TABLENAME+".id_linea_categoria,"+LineaPuntoVentaConstantesFunciones.SCHEMA+"."+LineaPuntoVentaConstantesFunciones.TABLENAME+".id_linea_marca,"+LineaPuntoVentaConstantesFunciones.SCHEMA+"."+LineaPuntoVentaConstantesFunciones.TABLENAME+".esta_activo from "+LineaPuntoVentaConstantesFunciones.SCHEMA+"."+LineaPuntoVentaConstantesFunciones.TABLENAME;//+" as "+LineaPuntoVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected LineaPuntoVentaConstantesFuncionesAdditional lineapuntoventaConstantesFuncionesAdditional=null;
	
	public LineaPuntoVentaConstantesFuncionesAdditional getLineaPuntoVentaConstantesFuncionesAdditional() {
		return this.lineapuntoventaConstantesFuncionesAdditional;
	}
	
	public void setLineaPuntoVentaConstantesFuncionesAdditional(LineaPuntoVentaConstantesFuncionesAdditional lineapuntoventaConstantesFuncionesAdditional) {
		try {
			this.lineapuntoventaConstantesFuncionesAdditional=lineapuntoventaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
		
		
		
	
	public static String getLineaPuntoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(LineaPuntoVentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=LineaPuntoVentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(LineaPuntoVentaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=LineaPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(LineaPuntoVentaConstantesFunciones.IDLINEA)) {sLabelColumna=LineaPuntoVentaConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(LineaPuntoVentaConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=LineaPuntoVentaConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(LineaPuntoVentaConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=LineaPuntoVentaConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(LineaPuntoVentaConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=LineaPuntoVentaConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(LineaPuntoVentaConstantesFunciones.ESTAACTIVO)) {sLabelColumna=LineaPuntoVentaConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(LineaPuntoVenta lineapuntoventa) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!lineapuntoventa.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(LineaPuntoVenta lineapuntoventa) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(lineapuntoventa.getId(),lineapuntoventa.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getLineaPuntoVentaDescripcion(LineaPuntoVenta lineapuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(lineapuntoventa !=null/* && lineapuntoventa.getId()!=0*/) {
			if(lineapuntoventa.getId()!=null) {
				sDescripcion=lineapuntoventa.getId().toString();
			}//lineapuntoventalineapuntoventa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getLineaPuntoVentaDescripcionDetallado(LineaPuntoVenta lineapuntoventa) {
		String sDescripcion="";
			
		sDescripcion+=LineaPuntoVentaConstantesFunciones.ID+"=";
		sDescripcion+=lineapuntoventa.getId().toString()+",";
		sDescripcion+=LineaPuntoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=lineapuntoventa.getVersionRow().toString()+",";
		sDescripcion+=LineaPuntoVentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=lineapuntoventa.getid_empresa().toString()+",";
		sDescripcion+=LineaPuntoVentaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=lineapuntoventa.getid_sucursal().toString()+",";
		sDescripcion+=LineaPuntoVentaConstantesFunciones.IDLINEA+"=";
		sDescripcion+=lineapuntoventa.getid_linea().toString()+",";
		sDescripcion+=LineaPuntoVentaConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=lineapuntoventa.getid_linea_grupo().toString()+",";
		sDescripcion+=LineaPuntoVentaConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=lineapuntoventa.getid_linea_categoria().toString()+",";
		sDescripcion+=LineaPuntoVentaConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=lineapuntoventa.getid_linea_marca().toString()+",";
		sDescripcion+=LineaPuntoVentaConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=lineapuntoventa.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setLineaPuntoVentaDescripcion(LineaPuntoVenta lineapuntoventa,String sValor) throws Exception {			
		if(lineapuntoventa !=null) {
			//lineapuntoventalineapuntoventa.getId().toString();
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

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaGrupoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaCategoriaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaMarcaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
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
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdLineaCategoria")) {
			sNombreIndice="Tipo=  Por Linea Categoria";
		} else if(sNombreIndice.equals("FK_IdLineaGrupo")) {
			sNombreIndice="Tipo=  Por Linea Grupo";
		} else if(sNombreIndice.equals("FK_IdLineaMarca")) {
			sNombreIndice="Tipo=  Por Linea Marca";
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

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaCategoria(Long id_linea_categoria) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaGrupo(Long id_linea_grupo) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaMarca(Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosLineaPuntoVenta(LineaPuntoVenta lineapuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosLineaPuntoVentas(List<LineaPuntoVenta> lineapuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(LineaPuntoVenta lineapuntoventa: lineapuntoventas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresLineaPuntoVenta(LineaPuntoVenta lineapuntoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && lineapuntoventa.getConCambioAuxiliar()) {
			lineapuntoventa.setIsDeleted(lineapuntoventa.getIsDeletedAuxiliar());	
			lineapuntoventa.setIsNew(lineapuntoventa.getIsNewAuxiliar());	
			lineapuntoventa.setIsChanged(lineapuntoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			lineapuntoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			lineapuntoventa.setIsDeletedAuxiliar(false);	
			lineapuntoventa.setIsNewAuxiliar(false);	
			lineapuntoventa.setIsChangedAuxiliar(false);
			
			lineapuntoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresLineaPuntoVentas(List<LineaPuntoVenta> lineapuntoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(LineaPuntoVenta lineapuntoventa : lineapuntoventas) {
			if(conAsignarBase && lineapuntoventa.getConCambioAuxiliar()) {
				lineapuntoventa.setIsDeleted(lineapuntoventa.getIsDeletedAuxiliar());	
				lineapuntoventa.setIsNew(lineapuntoventa.getIsNewAuxiliar());	
				lineapuntoventa.setIsChanged(lineapuntoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				lineapuntoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				lineapuntoventa.setIsDeletedAuxiliar(false);	
				lineapuntoventa.setIsNewAuxiliar(false);	
				lineapuntoventa.setIsChangedAuxiliar(false);
				
				lineapuntoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresLineaPuntoVenta(LineaPuntoVenta lineapuntoventa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresLineaPuntoVentas(List<LineaPuntoVenta> lineapuntoventas,Boolean conEnteros) throws Exception  {
		
		for(LineaPuntoVenta lineapuntoventa: lineapuntoventas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaLineaPuntoVenta(List<LineaPuntoVenta> lineapuntoventas,LineaPuntoVenta lineapuntoventaAux) throws Exception  {
		LineaPuntoVentaConstantesFunciones.InicializarValoresLineaPuntoVenta(lineapuntoventaAux,true);
		
		for(LineaPuntoVenta lineapuntoventa: lineapuntoventas) {
			if(lineapuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesLineaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=LineaPuntoVentaConstantesFunciones.getArrayColumnasGlobalesLineaPuntoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesLineaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(LineaPuntoVentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(LineaPuntoVentaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(LineaPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(LineaPuntoVentaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoLineaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<LineaPuntoVenta> lineapuntoventas,LineaPuntoVenta lineapuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(LineaPuntoVenta lineapuntoventaAux: lineapuntoventas) {
			if(lineapuntoventaAux!=null && lineapuntoventa!=null) {
				if((lineapuntoventaAux.getId()==null && lineapuntoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(lineapuntoventaAux.getId()!=null && lineapuntoventa.getId()!=null){
					if(lineapuntoventaAux.getId().equals(lineapuntoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaLineaPuntoVenta(List<LineaPuntoVenta> lineapuntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(LineaPuntoVenta lineapuntoventa: lineapuntoventas) {			
			if(lineapuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaLineaPuntoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,LineaPuntoVentaConstantesFunciones.LABEL_ID, LineaPuntoVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaPuntoVentaConstantesFunciones.LABEL_VERSIONROW, LineaPuntoVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaPuntoVentaConstantesFunciones.LABEL_IDEMPRESA, LineaPuntoVentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL, LineaPuntoVentaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaPuntoVentaConstantesFunciones.LABEL_IDLINEA, LineaPuntoVentaConstantesFunciones.IDLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaPuntoVentaConstantesFunciones.LABEL_IDLINEAGRUPO, LineaPuntoVentaConstantesFunciones.IDLINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaPuntoVentaConstantesFunciones.LABEL_IDLINEACATEGORIA, LineaPuntoVentaConstantesFunciones.IDLINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaPuntoVentaConstantesFunciones.LABEL_IDLINEAMARCA, LineaPuntoVentaConstantesFunciones.IDLINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaPuntoVentaConstantesFunciones.LABEL_ESTAACTIVO, LineaPuntoVentaConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasLineaPuntoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=LineaPuntoVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaPuntoVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaPuntoVentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaPuntoVentaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaPuntoVentaConstantesFunciones.IDLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaPuntoVentaConstantesFunciones.IDLINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaPuntoVentaConstantesFunciones.IDLINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaPuntoVentaConstantesFunciones.IDLINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaPuntoVentaConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLineaPuntoVenta() throws Exception  {
		return LineaPuntoVentaConstantesFunciones.getTiposSeleccionarLineaPuntoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLineaPuntoVenta(Boolean conFk) throws Exception  {
		return LineaPuntoVentaConstantesFunciones.getTiposSeleccionarLineaPuntoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLineaPuntoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(LineaPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(LineaPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaPuntoVentaConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(LineaPuntoVentaConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaPuntoVentaConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(LineaPuntoVentaConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaPuntoVentaConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(LineaPuntoVentaConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaPuntoVentaConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(LineaPuntoVentaConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaPuntoVentaConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(LineaPuntoVentaConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesLineaPuntoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesLineaPuntoVenta(LineaPuntoVenta lineapuntoventaAux) throws Exception {
		
			lineapuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(lineapuntoventaAux.getEmpresa()));
			lineapuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(lineapuntoventaAux.getSucursal()));
			lineapuntoventaAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(lineapuntoventaAux.getLinea()));
			lineapuntoventaAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(lineapuntoventaAux.getLineaGrupo()));
			lineapuntoventaAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(lineapuntoventaAux.getLineaCategoria()));
			lineapuntoventaAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(lineapuntoventaAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesLineaPuntoVenta(List<LineaPuntoVenta> lineapuntoventasTemp) throws Exception {
		for(LineaPuntoVenta lineapuntoventaAux:lineapuntoventasTemp) {
			
			lineapuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(lineapuntoventaAux.getEmpresa()));
			lineapuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(lineapuntoventaAux.getSucursal()));
			lineapuntoventaAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(lineapuntoventaAux.getLinea()));
			lineapuntoventaAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(lineapuntoventaAux.getLineaGrupo()));
			lineapuntoventaAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(lineapuntoventaAux.getLineaCategoria()));
			lineapuntoventaAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(lineapuntoventaAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfLineaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				
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
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfLineaPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfLineaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return LineaPuntoVentaConstantesFunciones.getClassesRelationshipsOfLineaPuntoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLineaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfLineaPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return LineaPuntoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfLineaPuntoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfLineaPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(LineaPuntoVenta lineapuntoventa,List<LineaPuntoVenta> lineapuntoventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			LineaPuntoVenta lineapuntoventaEncontrado=null;
			
			for(LineaPuntoVenta lineapuntoventaLocal:lineapuntoventas) {
				if(lineapuntoventaLocal.getId().equals(lineapuntoventa.getId())) {
					lineapuntoventaEncontrado=lineapuntoventaLocal;
					
					lineapuntoventaLocal.setIsChanged(lineapuntoventa.getIsChanged());
					lineapuntoventaLocal.setIsNew(lineapuntoventa.getIsNew());
					lineapuntoventaLocal.setIsDeleted(lineapuntoventa.getIsDeleted());
					
					lineapuntoventaLocal.setGeneralEntityOriginal(lineapuntoventa.getGeneralEntityOriginal());
					
					lineapuntoventaLocal.setId(lineapuntoventa.getId());	
					lineapuntoventaLocal.setVersionRow(lineapuntoventa.getVersionRow());	
					lineapuntoventaLocal.setid_empresa(lineapuntoventa.getid_empresa());	
					lineapuntoventaLocal.setid_sucursal(lineapuntoventa.getid_sucursal());	
					lineapuntoventaLocal.setid_linea(lineapuntoventa.getid_linea());	
					lineapuntoventaLocal.setid_linea_grupo(lineapuntoventa.getid_linea_grupo());	
					lineapuntoventaLocal.setid_linea_categoria(lineapuntoventa.getid_linea_categoria());	
					lineapuntoventaLocal.setid_linea_marca(lineapuntoventa.getid_linea_marca());	
					lineapuntoventaLocal.setesta_activo(lineapuntoventa.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!lineapuntoventa.getIsDeleted()) {
				if(!existe) {
					lineapuntoventas.add(lineapuntoventa);
				}
			} else {
				if(lineapuntoventaEncontrado!=null && permiteQuitar)  {
					lineapuntoventas.remove(lineapuntoventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(LineaPuntoVenta lineapuntoventa,List<LineaPuntoVenta> lineapuntoventas) throws Exception {
		try	{			
			for(LineaPuntoVenta lineapuntoventaLocal:lineapuntoventas) {
				if(lineapuntoventaLocal.getId().equals(lineapuntoventa.getId())) {
					lineapuntoventaLocal.setIsSelected(lineapuntoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesLineaPuntoVenta(List<LineaPuntoVenta> lineapuntoventasAux) throws Exception {
		//this.lineapuntoventasAux=lineapuntoventasAux;
		
		for(LineaPuntoVenta lineapuntoventaAux:lineapuntoventasAux) {
			if(lineapuntoventaAux.getIsChanged()) {
				lineapuntoventaAux.setIsChanged(false);
			}		
			
			if(lineapuntoventaAux.getIsNew()) {
				lineapuntoventaAux.setIsNew(false);
			}	
			
			if(lineapuntoventaAux.getIsDeleted()) {
				lineapuntoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesLineaPuntoVenta(LineaPuntoVenta lineapuntoventaAux) throws Exception {
		//this.lineapuntoventaAux=lineapuntoventaAux;
		
			if(lineapuntoventaAux.getIsChanged()) {
				lineapuntoventaAux.setIsChanged(false);
			}		
			
			if(lineapuntoventaAux.getIsNew()) {
				lineapuntoventaAux.setIsNew(false);
			}	
			
			if(lineapuntoventaAux.getIsDeleted()) {
				lineapuntoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(LineaPuntoVenta lineapuntoventaAsignar,LineaPuntoVenta lineapuntoventa) throws Exception {
		lineapuntoventaAsignar.setId(lineapuntoventa.getId());	
		lineapuntoventaAsignar.setVersionRow(lineapuntoventa.getVersionRow());	
		lineapuntoventaAsignar.setid_empresa(lineapuntoventa.getid_empresa());
		lineapuntoventaAsignar.setempresa_descripcion(lineapuntoventa.getempresa_descripcion());	
		lineapuntoventaAsignar.setid_sucursal(lineapuntoventa.getid_sucursal());
		lineapuntoventaAsignar.setsucursal_descripcion(lineapuntoventa.getsucursal_descripcion());	
		lineapuntoventaAsignar.setid_linea(lineapuntoventa.getid_linea());
		lineapuntoventaAsignar.setlinea_descripcion(lineapuntoventa.getlinea_descripcion());	
		lineapuntoventaAsignar.setid_linea_grupo(lineapuntoventa.getid_linea_grupo());
		lineapuntoventaAsignar.setlineagrupo_descripcion(lineapuntoventa.getlineagrupo_descripcion());	
		lineapuntoventaAsignar.setid_linea_categoria(lineapuntoventa.getid_linea_categoria());
		lineapuntoventaAsignar.setlineacategoria_descripcion(lineapuntoventa.getlineacategoria_descripcion());	
		lineapuntoventaAsignar.setid_linea_marca(lineapuntoventa.getid_linea_marca());
		lineapuntoventaAsignar.setlineamarca_descripcion(lineapuntoventa.getlineamarca_descripcion());	
		lineapuntoventaAsignar.setesta_activo(lineapuntoventa.getesta_activo());	
	}
	
	public static void inicializarLineaPuntoVenta(LineaPuntoVenta lineapuntoventa) throws Exception {
		try {
				lineapuntoventa.setId(0L);	
					
				lineapuntoventa.setid_empresa(-1L);	
				lineapuntoventa.setid_sucursal(-1L);	
				lineapuntoventa.setid_linea(-1L);	
				lineapuntoventa.setid_linea_grupo(null);	
				lineapuntoventa.setid_linea_categoria(null);	
				lineapuntoventa.setid_linea_marca(null);	
				lineapuntoventa.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderLineaPuntoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaPuntoVentaConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaPuntoVentaConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaPuntoVentaConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaPuntoVentaConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaPuntoVentaConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataLineaPuntoVenta(String sTipo,Row row,Workbook workbook,LineaPuntoVenta lineapuntoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(lineapuntoventa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(lineapuntoventa.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(lineapuntoventa.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(lineapuntoventa.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(lineapuntoventa.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(lineapuntoventa.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(lineapuntoventa.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryLineaPuntoVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryLineaPuntoVenta() {
		return this.sFinalQueryLineaPuntoVenta;
	}
	
	public void setsFinalQueryLineaPuntoVenta(String sFinalQueryLineaPuntoVenta) {
		this.sFinalQueryLineaPuntoVenta= sFinalQueryLineaPuntoVenta;
	}
	
	public Border resaltarSeleccionarLineaPuntoVenta=null;
	
	public Border setResaltarSeleccionarLineaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//lineapuntoventaBeanSwingJInternalFrame.jTtoolBarLineaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarLineaPuntoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarLineaPuntoVenta() {
		return this.resaltarSeleccionarLineaPuntoVenta;
	}
	
	public void setResaltarSeleccionarLineaPuntoVenta(Border borderResaltarSeleccionarLineaPuntoVenta) {
		this.resaltarSeleccionarLineaPuntoVenta= borderResaltarSeleccionarLineaPuntoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridLineaPuntoVenta=null;
	public Boolean mostraridLineaPuntoVenta=true;
	public Boolean activaridLineaPuntoVenta=true;

	public Border resaltarid_empresaLineaPuntoVenta=null;
	public Boolean mostrarid_empresaLineaPuntoVenta=true;
	public Boolean activarid_empresaLineaPuntoVenta=true;
	public Boolean cargarid_empresaLineaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaLineaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_sucursalLineaPuntoVenta=null;
	public Boolean mostrarid_sucursalLineaPuntoVenta=true;
	public Boolean activarid_sucursalLineaPuntoVenta=true;
	public Boolean cargarid_sucursalLineaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalLineaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_lineaLineaPuntoVenta=null;
	public Boolean mostrarid_lineaLineaPuntoVenta=true;
	public Boolean activarid_lineaLineaPuntoVenta=true;
	public Boolean cargarid_lineaLineaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaLineaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoLineaPuntoVenta=null;
	public Boolean mostrarid_linea_grupoLineaPuntoVenta=true;
	public Boolean activarid_linea_grupoLineaPuntoVenta=true;
	public Boolean cargarid_linea_grupoLineaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoLineaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaLineaPuntoVenta=null;
	public Boolean mostrarid_linea_categoriaLineaPuntoVenta=true;
	public Boolean activarid_linea_categoriaLineaPuntoVenta=true;
	public Boolean cargarid_linea_categoriaLineaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaLineaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaLineaPuntoVenta=null;
	public Boolean mostrarid_linea_marcaLineaPuntoVenta=true;
	public Boolean activarid_linea_marcaLineaPuntoVenta=true;
	public Boolean cargarid_linea_marcaLineaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaLineaPuntoVenta=false;//ConEventDepend=true

	public Border resaltaresta_activoLineaPuntoVenta=null;
	public Boolean mostraresta_activoLineaPuntoVenta=true;
	public Boolean activaresta_activoLineaPuntoVenta=true;

	
	

	public Border setResaltaridLineaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineapuntoventaBeanSwingJInternalFrame.jTtoolBarLineaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaridLineaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridLineaPuntoVenta() {
		return this.resaltaridLineaPuntoVenta;
	}

	public void setResaltaridLineaPuntoVenta(Border borderResaltar) {
		this.resaltaridLineaPuntoVenta= borderResaltar;
	}

	public Boolean getMostraridLineaPuntoVenta() {
		return this.mostraridLineaPuntoVenta;
	}

	public void setMostraridLineaPuntoVenta(Boolean mostraridLineaPuntoVenta) {
		this.mostraridLineaPuntoVenta= mostraridLineaPuntoVenta;
	}

	public Boolean getActivaridLineaPuntoVenta() {
		return this.activaridLineaPuntoVenta;
	}

	public void setActivaridLineaPuntoVenta(Boolean activaridLineaPuntoVenta) {
		this.activaridLineaPuntoVenta= activaridLineaPuntoVenta;
	}

	public Border setResaltarid_empresaLineaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineapuntoventaBeanSwingJInternalFrame.jTtoolBarLineaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaLineaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaLineaPuntoVenta() {
		return this.resaltarid_empresaLineaPuntoVenta;
	}

	public void setResaltarid_empresaLineaPuntoVenta(Border borderResaltar) {
		this.resaltarid_empresaLineaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaLineaPuntoVenta() {
		return this.mostrarid_empresaLineaPuntoVenta;
	}

	public void setMostrarid_empresaLineaPuntoVenta(Boolean mostrarid_empresaLineaPuntoVenta) {
		this.mostrarid_empresaLineaPuntoVenta= mostrarid_empresaLineaPuntoVenta;
	}

	public Boolean getActivarid_empresaLineaPuntoVenta() {
		return this.activarid_empresaLineaPuntoVenta;
	}

	public void setActivarid_empresaLineaPuntoVenta(Boolean activarid_empresaLineaPuntoVenta) {
		this.activarid_empresaLineaPuntoVenta= activarid_empresaLineaPuntoVenta;
	}

	public Boolean getCargarid_empresaLineaPuntoVenta() {
		return this.cargarid_empresaLineaPuntoVenta;
	}

	public void setCargarid_empresaLineaPuntoVenta(Boolean cargarid_empresaLineaPuntoVenta) {
		this.cargarid_empresaLineaPuntoVenta= cargarid_empresaLineaPuntoVenta;
	}

	public Border setResaltarid_sucursalLineaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineapuntoventaBeanSwingJInternalFrame.jTtoolBarLineaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_sucursalLineaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalLineaPuntoVenta() {
		return this.resaltarid_sucursalLineaPuntoVenta;
	}

	public void setResaltarid_sucursalLineaPuntoVenta(Border borderResaltar) {
		this.resaltarid_sucursalLineaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_sucursalLineaPuntoVenta() {
		return this.mostrarid_sucursalLineaPuntoVenta;
	}

	public void setMostrarid_sucursalLineaPuntoVenta(Boolean mostrarid_sucursalLineaPuntoVenta) {
		this.mostrarid_sucursalLineaPuntoVenta= mostrarid_sucursalLineaPuntoVenta;
	}

	public Boolean getActivarid_sucursalLineaPuntoVenta() {
		return this.activarid_sucursalLineaPuntoVenta;
	}

	public void setActivarid_sucursalLineaPuntoVenta(Boolean activarid_sucursalLineaPuntoVenta) {
		this.activarid_sucursalLineaPuntoVenta= activarid_sucursalLineaPuntoVenta;
	}

	public Boolean getCargarid_sucursalLineaPuntoVenta() {
		return this.cargarid_sucursalLineaPuntoVenta;
	}

	public void setCargarid_sucursalLineaPuntoVenta(Boolean cargarid_sucursalLineaPuntoVenta) {
		this.cargarid_sucursalLineaPuntoVenta= cargarid_sucursalLineaPuntoVenta;
	}

	public Border setResaltarid_lineaLineaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineapuntoventaBeanSwingJInternalFrame.jTtoolBarLineaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_lineaLineaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaLineaPuntoVenta() {
		return this.resaltarid_lineaLineaPuntoVenta;
	}

	public void setResaltarid_lineaLineaPuntoVenta(Border borderResaltar) {
		this.resaltarid_lineaLineaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_lineaLineaPuntoVenta() {
		return this.mostrarid_lineaLineaPuntoVenta;
	}

	public void setMostrarid_lineaLineaPuntoVenta(Boolean mostrarid_lineaLineaPuntoVenta) {
		this.mostrarid_lineaLineaPuntoVenta= mostrarid_lineaLineaPuntoVenta;
	}

	public Boolean getActivarid_lineaLineaPuntoVenta() {
		return this.activarid_lineaLineaPuntoVenta;
	}

	public void setActivarid_lineaLineaPuntoVenta(Boolean activarid_lineaLineaPuntoVenta) {
		this.activarid_lineaLineaPuntoVenta= activarid_lineaLineaPuntoVenta;
	}

	public Boolean getCargarid_lineaLineaPuntoVenta() {
		return this.cargarid_lineaLineaPuntoVenta;
	}

	public void setCargarid_lineaLineaPuntoVenta(Boolean cargarid_lineaLineaPuntoVenta) {
		this.cargarid_lineaLineaPuntoVenta= cargarid_lineaLineaPuntoVenta;
	}

	public Border setResaltarid_linea_grupoLineaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineapuntoventaBeanSwingJInternalFrame.jTtoolBarLineaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoLineaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoLineaPuntoVenta() {
		return this.resaltarid_linea_grupoLineaPuntoVenta;
	}

	public void setResaltarid_linea_grupoLineaPuntoVenta(Border borderResaltar) {
		this.resaltarid_linea_grupoLineaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoLineaPuntoVenta() {
		return this.mostrarid_linea_grupoLineaPuntoVenta;
	}

	public void setMostrarid_linea_grupoLineaPuntoVenta(Boolean mostrarid_linea_grupoLineaPuntoVenta) {
		this.mostrarid_linea_grupoLineaPuntoVenta= mostrarid_linea_grupoLineaPuntoVenta;
	}

	public Boolean getActivarid_linea_grupoLineaPuntoVenta() {
		return this.activarid_linea_grupoLineaPuntoVenta;
	}

	public void setActivarid_linea_grupoLineaPuntoVenta(Boolean activarid_linea_grupoLineaPuntoVenta) {
		this.activarid_linea_grupoLineaPuntoVenta= activarid_linea_grupoLineaPuntoVenta;
	}

	public Boolean getCargarid_linea_grupoLineaPuntoVenta() {
		return this.cargarid_linea_grupoLineaPuntoVenta;
	}

	public void setCargarid_linea_grupoLineaPuntoVenta(Boolean cargarid_linea_grupoLineaPuntoVenta) {
		this.cargarid_linea_grupoLineaPuntoVenta= cargarid_linea_grupoLineaPuntoVenta;
	}

	public Border setResaltarid_linea_categoriaLineaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineapuntoventaBeanSwingJInternalFrame.jTtoolBarLineaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaLineaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaLineaPuntoVenta() {
		return this.resaltarid_linea_categoriaLineaPuntoVenta;
	}

	public void setResaltarid_linea_categoriaLineaPuntoVenta(Border borderResaltar) {
		this.resaltarid_linea_categoriaLineaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaLineaPuntoVenta() {
		return this.mostrarid_linea_categoriaLineaPuntoVenta;
	}

	public void setMostrarid_linea_categoriaLineaPuntoVenta(Boolean mostrarid_linea_categoriaLineaPuntoVenta) {
		this.mostrarid_linea_categoriaLineaPuntoVenta= mostrarid_linea_categoriaLineaPuntoVenta;
	}

	public Boolean getActivarid_linea_categoriaLineaPuntoVenta() {
		return this.activarid_linea_categoriaLineaPuntoVenta;
	}

	public void setActivarid_linea_categoriaLineaPuntoVenta(Boolean activarid_linea_categoriaLineaPuntoVenta) {
		this.activarid_linea_categoriaLineaPuntoVenta= activarid_linea_categoriaLineaPuntoVenta;
	}

	public Boolean getCargarid_linea_categoriaLineaPuntoVenta() {
		return this.cargarid_linea_categoriaLineaPuntoVenta;
	}

	public void setCargarid_linea_categoriaLineaPuntoVenta(Boolean cargarid_linea_categoriaLineaPuntoVenta) {
		this.cargarid_linea_categoriaLineaPuntoVenta= cargarid_linea_categoriaLineaPuntoVenta;
	}

	public Border setResaltarid_linea_marcaLineaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineapuntoventaBeanSwingJInternalFrame.jTtoolBarLineaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaLineaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaLineaPuntoVenta() {
		return this.resaltarid_linea_marcaLineaPuntoVenta;
	}

	public void setResaltarid_linea_marcaLineaPuntoVenta(Border borderResaltar) {
		this.resaltarid_linea_marcaLineaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaLineaPuntoVenta() {
		return this.mostrarid_linea_marcaLineaPuntoVenta;
	}

	public void setMostrarid_linea_marcaLineaPuntoVenta(Boolean mostrarid_linea_marcaLineaPuntoVenta) {
		this.mostrarid_linea_marcaLineaPuntoVenta= mostrarid_linea_marcaLineaPuntoVenta;
	}

	public Boolean getActivarid_linea_marcaLineaPuntoVenta() {
		return this.activarid_linea_marcaLineaPuntoVenta;
	}

	public void setActivarid_linea_marcaLineaPuntoVenta(Boolean activarid_linea_marcaLineaPuntoVenta) {
		this.activarid_linea_marcaLineaPuntoVenta= activarid_linea_marcaLineaPuntoVenta;
	}

	public Boolean getCargarid_linea_marcaLineaPuntoVenta() {
		return this.cargarid_linea_marcaLineaPuntoVenta;
	}

	public void setCargarid_linea_marcaLineaPuntoVenta(Boolean cargarid_linea_marcaLineaPuntoVenta) {
		this.cargarid_linea_marcaLineaPuntoVenta= cargarid_linea_marcaLineaPuntoVenta;
	}

	public Border setResaltaresta_activoLineaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineapuntoventaBeanSwingJInternalFrame.jTtoolBarLineaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaresta_activoLineaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoLineaPuntoVenta() {
		return this.resaltaresta_activoLineaPuntoVenta;
	}

	public void setResaltaresta_activoLineaPuntoVenta(Border borderResaltar) {
		this.resaltaresta_activoLineaPuntoVenta= borderResaltar;
	}

	public Boolean getMostraresta_activoLineaPuntoVenta() {
		return this.mostraresta_activoLineaPuntoVenta;
	}

	public void setMostraresta_activoLineaPuntoVenta(Boolean mostraresta_activoLineaPuntoVenta) {
		this.mostraresta_activoLineaPuntoVenta= mostraresta_activoLineaPuntoVenta;
	}

	public Boolean getActivaresta_activoLineaPuntoVenta() {
		return this.activaresta_activoLineaPuntoVenta;
	}

	public void setActivaresta_activoLineaPuntoVenta(Boolean activaresta_activoLineaPuntoVenta) {
		this.activaresta_activoLineaPuntoVenta= activaresta_activoLineaPuntoVenta;
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
		
		
		this.setMostraridLineaPuntoVenta(esInicial);
		this.setMostrarid_empresaLineaPuntoVenta(esInicial);
		this.setMostrarid_sucursalLineaPuntoVenta(esInicial);
		this.setMostrarid_lineaLineaPuntoVenta(esInicial);
		this.setMostrarid_linea_grupoLineaPuntoVenta(esInicial);
		this.setMostrarid_linea_categoriaLineaPuntoVenta(esInicial);
		this.setMostrarid_linea_marcaLineaPuntoVenta(esInicial);
		this.setMostraresta_activoLineaPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.ID)) {
				this.setMostraridLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoLineaPuntoVenta(esAsigna);
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
		
		
		this.setActivaridLineaPuntoVenta(esInicial);
		this.setActivarid_empresaLineaPuntoVenta(esInicial);
		this.setActivarid_sucursalLineaPuntoVenta(esInicial);
		this.setActivarid_lineaLineaPuntoVenta(esInicial);
		this.setActivarid_linea_grupoLineaPuntoVenta(esInicial);
		this.setActivarid_linea_categoriaLineaPuntoVenta(esInicial);
		this.setActivarid_linea_marcaLineaPuntoVenta(esInicial);
		this.setActivaresta_activoLineaPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.ID)) {
				this.setActivaridLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoLineaPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridLineaPuntoVenta(esInicial);
		this.setResaltarid_empresaLineaPuntoVenta(esInicial);
		this.setResaltarid_sucursalLineaPuntoVenta(esInicial);
		this.setResaltarid_lineaLineaPuntoVenta(esInicial);
		this.setResaltarid_linea_grupoLineaPuntoVenta(esInicial);
		this.setResaltarid_linea_categoriaLineaPuntoVenta(esInicial);
		this.setResaltarid_linea_marcaLineaPuntoVenta(esInicial);
		this.setResaltaresta_activoLineaPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.ID)) {
				this.setResaltaridLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaLineaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaPuntoVentaConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoLineaPuntoVenta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaLineaPuntoVenta=true;

	public Boolean getMostrarFK_IdEmpresaLineaPuntoVenta() {
		return this.mostrarFK_IdEmpresaLineaPuntoVenta;
	}

	public void setMostrarFK_IdEmpresaLineaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaLineaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaLineaPuntoVenta=true;

	public Boolean getMostrarFK_IdLineaLineaPuntoVenta() {
		return this.mostrarFK_IdLineaLineaPuntoVenta;
	}

	public void setMostrarFK_IdLineaLineaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaLineaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaCategoriaLineaPuntoVenta=true;

	public Boolean getMostrarFK_IdLineaCategoriaLineaPuntoVenta() {
		return this.mostrarFK_IdLineaCategoriaLineaPuntoVenta;
	}

	public void setMostrarFK_IdLineaCategoriaLineaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaCategoriaLineaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaGrupoLineaPuntoVenta=true;

	public Boolean getMostrarFK_IdLineaGrupoLineaPuntoVenta() {
		return this.mostrarFK_IdLineaGrupoLineaPuntoVenta;
	}

	public void setMostrarFK_IdLineaGrupoLineaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaGrupoLineaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaMarcaLineaPuntoVenta=true;

	public Boolean getMostrarFK_IdLineaMarcaLineaPuntoVenta() {
		return this.mostrarFK_IdLineaMarcaLineaPuntoVenta;
	}

	public void setMostrarFK_IdLineaMarcaLineaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaMarcaLineaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalLineaPuntoVenta=true;

	public Boolean getMostrarFK_IdSucursalLineaPuntoVenta() {
		return this.mostrarFK_IdSucursalLineaPuntoVenta;
	}

	public void setMostrarFK_IdSucursalLineaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalLineaPuntoVenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaLineaPuntoVenta=true;

	public Boolean getActivarFK_IdEmpresaLineaPuntoVenta() {
		return this.activarFK_IdEmpresaLineaPuntoVenta;
	}

	public void setActivarFK_IdEmpresaLineaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaLineaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaLineaPuntoVenta=true;

	public Boolean getActivarFK_IdLineaLineaPuntoVenta() {
		return this.activarFK_IdLineaLineaPuntoVenta;
	}

	public void setActivarFK_IdLineaLineaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdLineaLineaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaCategoriaLineaPuntoVenta=true;

	public Boolean getActivarFK_IdLineaCategoriaLineaPuntoVenta() {
		return this.activarFK_IdLineaCategoriaLineaPuntoVenta;
	}

	public void setActivarFK_IdLineaCategoriaLineaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdLineaCategoriaLineaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaGrupoLineaPuntoVenta=true;

	public Boolean getActivarFK_IdLineaGrupoLineaPuntoVenta() {
		return this.activarFK_IdLineaGrupoLineaPuntoVenta;
	}

	public void setActivarFK_IdLineaGrupoLineaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdLineaGrupoLineaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaMarcaLineaPuntoVenta=true;

	public Boolean getActivarFK_IdLineaMarcaLineaPuntoVenta() {
		return this.activarFK_IdLineaMarcaLineaPuntoVenta;
	}

	public void setActivarFK_IdLineaMarcaLineaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdLineaMarcaLineaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalLineaPuntoVenta=true;

	public Boolean getActivarFK_IdSucursalLineaPuntoVenta() {
		return this.activarFK_IdSucursalLineaPuntoVenta;
	}

	public void setActivarFK_IdSucursalLineaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalLineaPuntoVenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaLineaPuntoVenta=null;

	public Border getResaltarFK_IdEmpresaLineaPuntoVenta() {
		return this.resaltarFK_IdEmpresaLineaPuntoVenta;
	}

	public void setResaltarFK_IdEmpresaLineaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaLineaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaLineaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaLineaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdLineaLineaPuntoVenta=null;

	public Border getResaltarFK_IdLineaLineaPuntoVenta() {
		return this.resaltarFK_IdLineaLineaPuntoVenta;
	}

	public void setResaltarFK_IdLineaLineaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdLineaLineaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdLineaLineaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaLineaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdLineaCategoriaLineaPuntoVenta=null;

	public Border getResaltarFK_IdLineaCategoriaLineaPuntoVenta() {
		return this.resaltarFK_IdLineaCategoriaLineaPuntoVenta;
	}

	public void setResaltarFK_IdLineaCategoriaLineaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdLineaCategoriaLineaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdLineaCategoriaLineaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaCategoriaLineaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdLineaGrupoLineaPuntoVenta=null;

	public Border getResaltarFK_IdLineaGrupoLineaPuntoVenta() {
		return this.resaltarFK_IdLineaGrupoLineaPuntoVenta;
	}

	public void setResaltarFK_IdLineaGrupoLineaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdLineaGrupoLineaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdLineaGrupoLineaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaGrupoLineaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdLineaMarcaLineaPuntoVenta=null;

	public Border getResaltarFK_IdLineaMarcaLineaPuntoVenta() {
		return this.resaltarFK_IdLineaMarcaLineaPuntoVenta;
	}

	public void setResaltarFK_IdLineaMarcaLineaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdLineaMarcaLineaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdLineaMarcaLineaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaMarcaLineaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdSucursalLineaPuntoVenta=null;

	public Border getResaltarFK_IdSucursalLineaPuntoVenta() {
		return this.resaltarFK_IdSucursalLineaPuntoVenta;
	}

	public void setResaltarFK_IdSucursalLineaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdSucursalLineaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdSucursalLineaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*LineaPuntoVentaBeanSwingJInternalFrame lineapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalLineaPuntoVenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}